package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private int age;
    private String name;
    private List<Student> students = new ArrayList<>();

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student s : students) {
            if (s.getAverageGrade() >= averageGrade) return s;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student studentWithMaxAverageGrade = null;
        double maxAverageGrade = 0;
        for (Student s : students) {
            if (s.getAverageGrade() > maxAverageGrade) {
                studentWithMaxAverageGrade = s;
                maxAverageGrade = s.getAverageGrade();
            }

        }
        return studentWithMaxAverageGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        Student studentWithMinAverageGrade = null;
        double minAverageGrade = 999;
        for (Student s : students) {
            if (s.getAverageGrade() < minAverageGrade) {
                studentWithMinAverageGrade = s;
                minAverageGrade = s.getAverageGrade();
            }

        }
        return studentWithMinAverageGrade;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}
