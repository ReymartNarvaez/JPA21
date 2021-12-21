package org.example.FinalProdject.Tabels;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StudentID;
    private String firstName;
    private String lastName;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Education education;

    public Student() {
    }

    public Student(String firstName, String lastName, Education education) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.education = education;
    }

    public Education getEducation(Education newEducation) {
        return education;
    }

    public Student setEducation(Education education) {
        this.education = education;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentID=" + StudentID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", education=" + education +
                '}';
    }
}
