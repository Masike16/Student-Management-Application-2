/*
STUDENT NAME:Masike Junior Rasenyalo
STUDENT ID:ST10452404
PROJECT NAME:STUDENT-MANAGEMENT-APPLICATION
*/
package smapp.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StudentDatabase {
    // Private field for an ArrayList of Student objects
    private ArrayList<Student> students;

    public StudentDatabase() {
    // Constructor to create a new StudentDatabase object
    this.students = new ArrayList<Student>();
}

    public void addStudent(Student student) {
        if (students.stream().anyMatch(s -> s.getId().equals(student.getId()))) {
            throw new RuntimeException("Student with ID " + student.getId() + " already exists");
        }
        students.add(student);
    }

    public Student searchStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void printStudentReport() {
        for (Student student : students) {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Course: " + student.getCourse());
            System.out.println();
        }
    }

    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public Iterable<Student> getStudents() {
        return new StudentIterable();
    }

    private class StudentIterable implements Iterable<Student> {
        @Override
        public Iterator<Student> iterator() {
            return new StudentIterator();
        }
    }

    private class StudentIterator implements Iterator<Student> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < students.size();
        }

        @Override
        public Student next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return students.get(index++);
        }
    }
}