/*
STUDENT NAME:Masike Junior Rasenyalo
STUDENT ID:ST10452404
PROJECT NAME:STUDENT-MANAGEMENT-APPLICATION
*/
package smapp.java;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private StudentDatabase studentDatabase;

    public Database() {
        this.studentDatabase = new StudentDatabase();
    }

    public void deleteStudent(String id) {
        studentDatabase.deleteStudent(id);
    }

    public void printStudentReport() {
        studentDatabase.printStudentReport();
    }

}