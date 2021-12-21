package org.example.FinalProdject;

import org.example.FinalProdject.Dao.*;
import org.example.FinalProdject.Impls.*;
import org.example.FinalProdject.Tabels.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    StudentDao studentDao = new StudentDaoImpl();
    EducationDao educationDao = new EducationDaoImpl();
    CourseDao courseDao = new CourseImpl();
    TeacherDao teacherDao = new TeacherDaoImpl();
    CourseTeacherDao courseTeacherDao = new CourseTeacherImpl();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA21");
    EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        Main main = new Main();
        main.testData();
        main.runMenu();
    }

    private void runMenu() {
        String choice;
        do {
            printMenu();
            choice = scanner.nextLine();
        } while (menuChoice(choice));
    }

    private void showTable() {
        String choice;
        do {
            System.out.println("ENTER TABLE TO VIEW ALL INFORMATION");
            printTables();
            choice = scanner.nextLine();
        } while (selectTable(choice));
    }

    private void search() {
        String choice;
        do {
            System.out.println("ENTER TABLE YOU WOULD LIKE TO SEARCH INFORMATION");
            printTables();
            choice = scanner.nextLine();
        } while (selectTableToSearch(choice));
    }

    private void add() {
        String choice;
        do {
            System.out.println("ENTER TABLE TO ADD");
            printTables();
            choice = scanner.nextLine();
        } while (selectTableToAdd(choice));
    }

    private void delete() {
        String choice;
        do {
            System.out.println("ENTER TABLE TO DELETE");
            printTables();
            choice = scanner.nextLine();
        } while (selectTableToDelete(choice));
    }

    private void updateInformation() {
        String choice;
        do {
            System.out.println("ENTER TABLE TO DELETE");
            printTables();
            choice = scanner.nextLine();
        } while (selectTableToUpdate(choice));
    }


    private void printMenu() {
        System.out.println("1.SHOW");
        System.out.println("2.FIND");
        System.out.println("3.ADD");
        System.out.println("4.DELETE");
        System.out.println("5.UPDATE");
        System.out.println("e.EXIT");
        System.out.print("ENTER YOUR CHOICE: ");
    }

    private void printTables() {
        System.out.println("1.STUDENT");
        System.out.println("2.TEACHER");
        System.out.println("3.EDUCATION");
        System.out.println("4.COURSE");
        System.out.println("5.COURSETEACHER");
        System.out.println("b.BACK TO MENU");
        System.out.print("ENTER YOUR CHOICE: ");
    }

    private boolean menuChoice(String choice) {
        boolean continueApplication = true;
        switch (choice) {
            case "1" -> showTable();
            case "2" -> search();
            case "3" -> add();
            case "4" -> delete();
            case "5" -> updateInformation();
            case "e", "E" -> continueApplication = false;
            default -> System.out.println("INVALID INPUT");
        }
        return continueApplication;
    }


    private boolean selectTable(String choice) {
        boolean continueApplication = true;
        switch (choice) {
            case "1" -> studentDao.getAll().forEach(System.out::println);
            case "2" -> teacherDao.getAll().forEach(System.out::println);
            case "3" -> educationDao.getAll().forEach(System.out::println);
            case "4" -> courseDao.getAll().forEach(System.out::println);
            case "5" -> courseTeacherDao.getAll().forEach(System.out::println);
            case "b", "B" -> continueApplication = false;
            default -> System.out.println("INVALID INPUT");
        }
        return continueApplication;
    }

    private boolean selectTableToSearch(String choice) {
        boolean continueApplication = true;
        switch (choice) {
            case "1" -> findStudent();
            case "2" -> findTeacher();
            case "3" -> findEducation();
            case "4" -> findeCourse();
            case "b", "B" -> continueApplication = false;
            default -> System.out.println("INVALID INPUT");
        }
        return continueApplication;
    }


    private boolean selectTableToAdd(String choice) {
        boolean continueApplication = true;
        switch (choice) {
            case "1" -> addStudent();
            case "2" -> addTeacher();
            case "3" -> addEducation();
            case "4" -> addCourse();
            case "5" -> addCourseTeacher();
            case "b", "B" -> continueApplication = false;
            default -> System.out.println("INVALID INPUT");
        }
        return continueApplication;
    }

    private boolean selectTableToDelete(String choice) {
        boolean continueApplication = true;
        switch (choice) {
            case "1" -> deleteStudent();
            case "2" -> deleteTeacher();
            case "3" -> deleteEducation();
            case "4" -> deleteCourse();
            case "5" -> deleteCourseTeacher();
            case "b", "B" -> continueApplication = false;
            default -> System.out.println("INVALID INPUT");
        }
        return continueApplication;
    }

    private boolean selectTableToUpdate(String choice) {
        boolean continueApplication = true;
        switch (choice) {
            case "1" -> updateStudent();
            case "2" -> updateTeacher();
            case "3" -> updateEducation();
            case "4" -> updateCourse();
            case "5" -> updateCourseTeacher();
            case "b", "B" -> continueApplication = false;
            default -> System.out.println("INVALID INPUT");
        }
        return continueApplication;
    }

    private void updateCourseTeacher() {
        System.out.println("CAN NOT UPDATE COURSE_TEACHER");
    }


    private void updateCourse() {
        try {
            System.out.print("ENTER COURSE ID YOU WOULD LIKE TO UPPDATE: ");
            int courseID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("New CourseName: ");
            String newCourseName = scanner.nextLine();
            System.out.println("EDUCATION LIST");
            educationDao.getAll().forEach(System.out::println);
            System.out.println("ENTER EDUCATION ID FOR COURSE");
            int educationID = scanner.nextInt();
            scanner.nextLine();

            Course course = em.find(Course.class, courseID);
            course.setCourseName(newCourseName);
            course.getEducation(em.find(Education.class, educationID));

            courseDao.update(course);
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }
    }

    private void updateEducation() {
        try {
            System.out.print("ENTER EDUCATION ID YOU WOULD LIKE TO UPPDATE: ");
            int educationID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("New educationName: ");
            String newEducationName = scanner.nextLine();

            Education education = em.find(Education.class, educationID);
            education.setEducationName(newEducationName);

            educationDao.update(education);
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }
    }

    private void updateTeacher() {
        try {
            System.out.print("ENTER TEACHER ID YOU WOULD LIKE TO UPPDATE: ");
            int teacherID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("New FirstName: ");
            String newFirstName = scanner.nextLine();
            System.out.print("New LastName: ");
            String newLastName = scanner.nextLine();

            Teacher teacher = em.find(Teacher.class, teacherID);
            teacher.setFirstName(newFirstName);
            teacher.setLastName(newLastName);

            teacherDao.update(teacher);
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }
    }

    private void updateStudent() {
        try {
            System.out.print("ENTER STUDENT ID YOU WOULD LIKE TO UPPDATE: ");
            int studentID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("New FirstName: ");
            String newFirstName = scanner.nextLine();
            System.out.print("New LastName: ");
            String newLastName = scanner.nextLine();
            System.out.println("EDUCATION LIST");
            educationDao.getAll().forEach(System.out::println);
            System.out.print("ENTER EDUCATION ID FOR STUDENT: ");
            int educationID = scanner.nextInt();
            scanner.nextLine();

            Student student = em.find(Student.class, studentID);
            student.setFirstName(newFirstName);
            student.setLastName(newLastName);
            student.setEducation(educationDao.getByID(educationID));

            studentDao.update(student);
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }
    }

    private void deleteCourseTeacher() {
        try {
            System.out.println("COURSE_TEACHER LIST:");
            courseTeacherDao.getAll().forEach(System.out::println);
            System.out.print("ENTER COURSE ID: ");
            int courseId = scanner.nextInt();
            System.out.print("ENTER TEACHER ID: ");
            int teacherId = scanner.nextInt();
            scanner.nextLine();
            courseTeacherDao.delete(em.find(CourseTeacher.class, courseId + teacherId));
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }
    }

    private void deleteCourse() {
        try {
            System.out.println("COURSE LIST:");
            courseDao.getAll().forEach(System.out::println);
            System.out.print("ENTER COURSE ID TO DELETE: ");
            int courseId = scanner.nextInt();
            scanner.nextLine();
            courseDao.delete(courseDao.getByCourseID(courseId));
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }
    }


    private void deleteEducation() {
        try {
            System.out.println("EDUCATION LIST:");
            educationDao.getAll().forEach(System.out::println);
            System.out.print("ENTER EDUCATION ID TO DELETE: ");
            int educationId = scanner.nextInt();
            scanner.nextLine();
            educationDao.delete(educationDao.getByID(educationId));
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }
    }

    private void deleteTeacher() {
        try {
            System.out.println("TEACHER LIST:");
            teacherDao.getAll().forEach(System.out::println);
            System.out.print("ENTER TEACHER ID TO DELETE: ");
            int teacherId = scanner.nextInt();
            scanner.nextLine();
            teacherDao.delete(teacherDao.getByID(teacherId));
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }
    }

    private void deleteStudent() {
        try {
            System.out.println("STUDENT LIST:");
            studentDao.getAll().forEach(System.out::println);
            System.out.print("ENTER STUDENT ID TO DELETE: ");
            int studentId = scanner.nextInt();
            scanner.nextLine();
            studentDao.delete(studentDao.getByID(studentId));
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }
    }

    private void addCourseTeacher() {
        try {
            System.out.println("TEACHER LIST: ");
            teacherDao.getAll().forEach(System.out::println);
            System.out.println("SELECT TEACHER ID TO ADD IN COURSE");
            System.out.print("ENTER ID CHOICE: ");
            int teacherId = scanner.nextInt();

            System.out.println("COURSE LIST: ");
            courseDao.getAll().forEach(System.out::println);
            System.out.println("SELECT COURSE");
            System.out.print("ENTER ID CHOICE: ");
            int courseId = scanner.nextInt();

            courseTeacherDao.add(new CourseTeacher(em.find(Course.class, courseId), em.find(Teacher.class, teacherId)));
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
            scanner.nextLine();
        }
    }

    private void addCourse() {
        try {
            System.out.print("CourseName: ");
            String courseName = scanner.nextLine();
            System.out.println("EDUCATION LIST: ");
            courseDao.getAll().forEach(System.out::println);
            System.out.println("SELECT EDUCATION ID FOR THIS COURSE");
            System.out.print("ENTER ID CHOICE: ");
            int id = scanner.nextInt();

            courseDao.add(new Course(courseName, em.find(Education.class, id)));
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
            scanner.nextLine();
        }
    }

    private void addEducation() {
        try {
            System.out.print("EducationName: ");
            String educationName = scanner.nextLine();
            educationDao.add(new Education(educationName));
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
            scanner.nextLine();
        }
    }

    private void addTeacher() {
        try {
            System.out.print("FirstName: ");
            String firstName = scanner.nextLine();
            System.out.print("LastName: ");
            String lastName = scanner.nextLine();
            teacherDao.add(new Teacher(firstName, lastName));
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
            scanner.nextLine();
        }
    }

    private void addStudent() {
        try {
            System.out.print("FirstName: ");
            String firstName = scanner.nextLine();
            System.out.print("LastName: ");
            String lastName = scanner.nextLine();
            System.out.println("EDUCATION LIST: ");
            educationDao.getAll().forEach(System.out::println);
            System.out.println("SELECT EDUCATION ID FOR THIS STUDENT");
            System.out.print("ENTER ID CHOICE: ");
            int id = scanner.nextInt();
            studentDao.add(new Student(firstName, lastName, em.find(Education.class, id)));
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
            scanner.nextLine();
        }
    }

    private void findeCourse() {
        try {
            System.out.print("ENTER ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println(courseDao.getByCourseID(id));
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
            scanner.nextLine();
        }
    }

    private void findEducation() {
        System.out.print("ENTER NAME: ");
        String name = scanner.next();
        educationDao.getByName(name).forEach(System.out::println);
        scanner.nextLine();
    }

    private void findTeacher() {
        System.out.print("ENTER NAME: ");
        String name = scanner.next();
        teacherDao.getByName(name).forEach(System.out::println);
        scanner.nextLine();
    }

    private void findStudent() {
        System.out.print("ENTER NAME: ");
        String name = scanner.next();
        studentDao.getByName(name).forEach(System.out::println);
        scanner.nextLine();
    }

    public void testData() {
        Query query = em.createNativeQuery("SELECT * FROM Student");
        List<Objects> results = query.getResultList();
        if (results.size() <= 1) {
            Education education1 = new Education("Java");
            Education education2 = new Education("Javascript");
            Education education3 = new Education(".net");
            educationDao.add(education1);
            educationDao.add(education2);
            educationDao.add(education3);

            studentDao.add(new Student("Linus", "Persson", education1));
            studentDao.add(new Student("David", "Lundqvist", education2));
            studentDao.add(new Student("Stina", "Larsson", education3));
            studentDao.add(new Student("Stefan", "Carlsson", education1));
            studentDao.add(new Student("Marcus", "Berg", education2));
            studentDao.add(new Student("Anna", "Olsson", education3));
            studentDao.add(new Student("Niclas", "Eriksson", education1));
            studentDao.add(new Student("Frida", "Svensson", education2));
            studentDao.add(new Student("Linn", "Lindström", education3));

            Course course1 = new Course("Java", education1);
            Course course2 = new Course("SQL", education1);
            Course course3 = new Course("JavaEE", education1);
            Course course4 = new Course("HTML", education2);
            Course course5 = new Course("CSS", education2);
            Course course6 = new Course("Javascript", education2);
            Course course7 = new Course("C#", education3);
            Course course8 = new Course("Datalogi", education3);
            Course course9 = new Course("Agil", education3);
            courseDao.add(course1);
            courseDao.add(course2);
            courseDao.add(course3);
            courseDao.add(course4);
            courseDao.add(course5);
            courseDao.add(course6);
            courseDao.add(course7);
            courseDao.add(course8);
            courseDao.add(course9);

            Teacher teacher1 = new Teacher("Peter", "Sjöberg");
            Teacher teacher2 = new Teacher("Tobias", "Nordström");
            Teacher teacher3 = new Teacher("Sandra", "Hansson");
            teacherDao.add(teacher1);
            teacherDao.add(teacher2);
            teacherDao.add(teacher3);

            courseTeacherDao.add(new CourseTeacher(course9, teacher1));
            courseTeacherDao.add(new CourseTeacher(course8, teacher2));
            courseTeacherDao.add(new CourseTeacher(course7, teacher3));
            courseTeacherDao.add(new CourseTeacher(course9, teacher3));
            courseTeacherDao.add(new CourseTeacher(course6, teacher1));
            courseTeacherDao.add(new CourseTeacher(course5, teacher2));
            courseTeacherDao.add(new CourseTeacher(course4, teacher3));
            courseTeacherDao.add(new CourseTeacher(course3, teacher1));
            courseTeacherDao.add(new CourseTeacher(course2, teacher2));
            courseTeacherDao.add(new CourseTeacher(course1, teacher3));

        }
    }
}
