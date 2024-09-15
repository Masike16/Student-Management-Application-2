/*
STUDENT NAME:Masike Junior Rasenyalo
STUDENT ID:ST10452404
PROJECT NAME:STUDENT-MANAGEMENT-APPLICATION
*/
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {

    /**
     * Clears the student list before each test to avoid interference between tests.
     */
    @Before
    public void setUp() {
        Student.studentList.clear();
    }

    /**
     * Currently empty, but can be used for any necessary cleanup after each test.
     */
    @After
    public void tearDown() {
    }

    // Test Getters
    // ===========

    /**
     * Tests the getId method of the Student class.
     */
    @Test
    public void testGetId() {//100%
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Math");
        assertEquals("1", student.getId());
    }

    /**
     * Tests the getName method of the Student class.
     */
    @Test
    public void testGetName() {//100%
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Math");
        assertEquals("John Doe", student.getName());
    }

    /**
     * Tests the getAge method of the Student class.
     */
    @Test
    public void testGetAge() {//100%
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Math");
        assertEquals(20, student.getAge());
    }

    /**
     * Tests the getEmail method of the Student class.
     */
    @Test
    public void testGetEmail() {//100%
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Math");
        assertEquals("john@example.com", student.getEmail());
    }

    /**
     * Tests the getCourse method of the Student class.
     */
    @Test
    public void testGetCourse() {//100%
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Math");
        assertEquals("Math", student.getCourse());
    }

    // Test Setters
    // ===========

    /**
     * Tests the setId method of the Student class.
     */
    @Test
    public void testSetId() {//100%
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Math");
        student.setId("2");
        assertEquals("2", student.getId());
    }

    /**
     * Tests the setName method of the Student class.
     */
    @Test
    public void testSetName() {//100%
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Math");
        student.setName("Jane Doe");
        assertEquals("Jane Doe", student.getName());
    }

    /**
     * Tests the setAge method of the Student class.
     */
    @Test
    public void testSetAge() {//100%
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Math");
        student.setAge(21);
        assertEquals(21, student.getAge());
    }

    /**
     * Tests the setEmail method of the Student class.
     */
    @Test
    public void testSetEmail() {//100%
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Math");
        student.setEmail("jane@example.com");
        assertEquals("jane@example.com", student.getEmail());
    }

    /**
     * Tests the setCourse method of the Student class.
     */
    @Test
    public void testSetCourse() {//100%
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Math");
        student.setCourse("Science");
        assertEquals("Science", student.getCourse());
    }

    // Test Static Methods
    // =================

    /**
     * Tests the saveStudent method of the Student class.
     */
    @Test
    public void testSaveStudent() {//100%
        Student.saveStudent("1", "John Doe", 20, "john@example.com", "Math");
        Student student = Student.searchStudent("1");
        assertNotNull(student);
        assertEquals("John Doe", student.getName());
    }

    /**
     * Tests the searchStudent method of the Student class.
     */
    @Test
    public void testSearchStudent() {//100%
        Student.saveStudent("1", "John Doe", 20, "john@example.com", "Math");
        Student student = Student.searchStudent("1");
        assertNotNull(student);
        assertEquals("John Doe", student.getName());
    }

    /**
     * Tests the deleteStudent method of the Student class.
     */
    @Test
    public void testDeleteStudent() {//100%
        Student.saveStudent("1", "John Doe", 20, "john@example.com", "Math");
        boolean result = Student.deleteStudent("1");
        assertTrue(result);
        Student student = Student.searchStudent("1");
        assertNull(student);
    }

    /**
     * Tests the studentReport method of the Student class.
     * This test is mainly for manual verification as it prints to console.
     */
    @Test
    public void testStudentReport() {//100%
        Student.saveStudent("1", "John Doe", 20, "john@example.com", "Math");
        Student.studentReport();
        // Check manually that the report contains the expected student data
    }

    // Test Edge Cases
    // ==============

    /**
     * Tests the searchStudent method with an invalid ID.
     */
    @Test
    public void testSearchStudent_StudentNotFound() {//100%
        Student student = Student.searchStudent("Invalid ID");
        assertNull(student);
    }

    /**
     * Tests the deleteStudent method with an invalid ID.
     */
    @Test
    public void testDeleteStudent_StudentNotFound() {//100%
        boolean result = Student.deleteStudent("Invalid ID");
        assertFalse(result);
    }

    /**
     * Tests the isValidAge method with a valid age.
     */
    @Test
    public void testStudentAge_StudentAgeValid() {//100%
        int age = 20;
        Student student = new Student("12345", "John Doe", age, "john.doe@example.com", "Math");
        assertEquals(age, student.getAge());
    }

    /**
     * Tests the age of a student with an invalid age.
     */
    @Test
    public void testStudentAge_StudentAgeInvalid() {//0%
        int age = 15;
        try {
            Student student = new Student("12345", "John Doe", age, "john.doe@example.com", "Math");
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            // Expected exception
        }
    }

    /**
     * Tests the age of a student with an invalid age (non-numeric string).
     */
    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {//100%
        String ageString = "Invalid Age";
        try {
            int numericAge = Integer.parseInt(ageString);
            fail("Expected NumberFormatException");
        } catch (NumberFormatException e) {
            // Expected exception
        }
        Student student = new Student("12345", "John Doe", 20, "john.doe@example.com", "Math");
        int invalidAge = 15; // or any other invalid age value
        try {
            student.setAge(invalidAge);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            // Expected exception
        }
    }
}