import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;
    private String section;

    public Student(String name, int rollNumber, String grade, String section) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public String getSection() {
        return section;
    }
}

public class StudentManagementSystem {
    private List<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.println("Enter student name:");
        String name = scanner.nextLine();

        int rollNumber = 0;
        while (rollNumber == 0) {
            try {
                System.out.println("Enter student roll number:");
                rollNumber = scanner.nextInt();
                scanner.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Roll number must be a number.");
                scanner.nextLine();
            }
        }

        System.out.println("Enter student grade:");
        String grade = scanner.nextLine();

        System.out.println("Enter student section:");
        String section = scanner.nextLine();

        Student newStudent = new Student(name, rollNumber, grade, section);
        students.add(newStudent);
        System.out.println("Student added successfully");
    }

    public void removeStudent() {
        System.out.println("Enter the roll number of the student:");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 

        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student removed successfully");
        } else {
            System.out.println("Student not found with the given roll number.");
        }
    }

    public void searchStudent() {
        System.out.println("Enter the roll number of the student:");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student Found:");
                displayStudentInfo(student);
                return;
            }
        }

        System.out.println("Student not found with the given roll number.");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            System.out.println("List of all students:");
            for (Student student : students) {
                displayStudentInfo(student);
            }
        }
    }

    private void displayStudentInfo(Student student) {
        System.out.println("Name: " + student.getName());
        System.out.println("Roll Number: " + student.getRollNumber());
        System.out.println("Grade: " + student.getGrade());
        System.out.println("Section: " + student.getSection());
        System.out.println("---------------------------------");
    }

    public void run() {
        while (true) {
            System.out.println(" Student Management System ");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.run();
    }
}
