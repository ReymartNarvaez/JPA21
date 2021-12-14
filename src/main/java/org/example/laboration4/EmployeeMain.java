package org.example.laboration4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EmployeeMain {

    Scanner scanner = new Scanner(System.in);
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA21");
    EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        EmployeeMain main = new EmployeeMain();
        main.insertTestData();
        main.runMenu();
    }

    private void insertTestData() {
        Query query = em.createNativeQuery("SELECT id FROM Employee");
        List<Objects> results = query.getResultList();

        if (results.size() <= 1) {
            employeeDao.add(new Employee("David", "Wallace", 54, 'M', 250000));
            employeeDao.add(new Employee("Jan", "Levinson", 60, 'M', 110000));
            employeeDao.add(new Employee("Michael", "Scott", 57, 'M', 75000));
            employeeDao.add(new Employee("Angela", "Martin", 47, 'F', 63000));
            employeeDao.add(new Employee("Kelly", "Kapoor", 40, 'F', 55000));
            employeeDao.add(new Employee("Stanley", "Hudson", 63, 'M', 69000));
            employeeDao.add(new Employee("Josh", "Porter", 52, 'M', 78000));
            employeeDao.add(new Employee("Andy", "Bernard", 44, 'M', 65000));
            employeeDao.add(new Employee("Jim", "Halpert", 49, 'M', 71000));
        }
    }

    private void runMenu() {
        String choice;
        do {
            printMenu();
            choice = scanner.nextLine();
        } while (menuChoice(choice));
    }

    private void printMenu() {
        System.out.println("1.SHOW ALL");
        System.out.println("2.FIND BY ID");
        System.out.println("3.FIND BY NAME");
        System.out.println("4.FIND BY SALARY");
        System.out.println("5.FIND BY AGE");
        System.out.println("6.ADD EMPLOYEE");
        System.out.println("7.DELETE EMPLOYEE");
        System.out.println("8.UPDATE EMPLOYEE");
        System.out.println("e.EXIT");
        System.out.print("ENTER YOUR CHOICE: ");
    }

    private boolean menuChoice(String choice) {
        boolean continueApplication = true;
        switch (choice) {
            case "1" -> employeeDao.getAll().forEach(System.out::println);
            case "2" -> findByID();
            case "3" -> findByName();
            case "4" -> findBySalary();
            case "5" -> findByAge();
            case "6" -> addEmployee();
            case "7" -> deleteEmploye();
            case "8" -> updateEmploye();
            case "e", "E" -> continueApplication = false;
            default -> System.out.println("INVALID INPUT");
        }
        return continueApplication;
    }

    private void updateEmploye() {
        try {
            System.out.print("ENTER ID FOR ARTIST YOU WOULD LIKE TO UPPDATE: ");
            int idInput = scanner.nextInt();
            scanner.nextLine();
            System.out.print("New FirstName: ");
            String newFirstName = scanner.nextLine();
            System.out.print("New LastName: ");
            String newLastName = scanner.nextLine();
            System.out.print("New Age: ");
            int newAge = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Sex M/F: ");
            char newSex = scanner.next().charAt(0);
            System.out.print("New Salary: ");
            int newSalary = scanner.nextInt();
            scanner.nextLine();

            Employee employee = employeeDao.getByID(idInput);
            employee.setFirstName(newFirstName);
            employee.setLastName(newLastName);
            employee.getAge(newAge);
            employee.setSex(newSex);
            employee.setSalary(newSalary);

            employeeDao.update(employee);
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }

    }

    private void deleteEmploye() {
        try {
            System.out.print("ENTER ID TO DELETE: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            employeeDao.delete(employeeDao.getByID(input));
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }
    }

    private void addEmployee() {
        try {
            System.out.print("FirstName: ");
            String firstName = scanner.nextLine();
            System.out.print("LastName: ");
            String lastName = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Sex M/F: ");
            char sex = scanner.next().charAt(0);
            System.out.print("Salary: ");
            int salary = scanner.nextInt();
            scanner.nextLine();

            employeeDao.add(new Employee(firstName, lastName, age, sex, salary));
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
            scanner.nextLine();
        }
    }

    private void findByAge() {
        try {
            System.out.print("FROM AGE: ");
            int fromAge = scanner.nextInt();
            scanner.nextLine();
            System.out.print("TO AGE: ");
            int toAge = scanner.nextInt();
            scanner.nextLine();

            employeeDao.getByAge(fromAge, toAge).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }
    }

    private void findBySalary() {
        try {
            System.out.print("FROM Salary: ");
            int fromSalary = scanner.nextInt();
            scanner.nextLine();
            System.out.print("TO Salary: ");
            int toSalary = scanner.nextInt();
            scanner.nextLine();

            employeeDao.getBySalary(fromSalary, toSalary).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }
    }

    private void findByName() {
        System.out.print("ENTER NAME: ");
        String name = scanner.next();

        employeeDao.getByName(name).forEach(System.out::println);
        scanner.nextLine();
    }

    private void findByID() {
        try {
            System.out.print("ENTER ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println(employeeDao.getByID(id));
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
            scanner.nextLine();
        }
    }
}
