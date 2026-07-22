package app;

import dao.StudentDAO;

import java.util.Scanner;

import model.Student;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        while (true) {

            System.out.println("\n========== Student Manangement System ==========");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println("You entered: " + choice);

            switch (choice) {

                case 1:
                    scanner.nextLine();

                    System.out.print("Enter Full Name; ");
                    String fullName = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = scanner.nextLine();

                    System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
                    Date dob = Date.valueOf(scanner.nextLine());

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    System.out.print("Enter Semester: ");
                    int semester = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();

                    System.out.print("Enter Attendance: ");
                    double attendance = scanner.nextDouble();

                    Student student = new Student(
                            fullName,
                            age,
                            gender,
                            dob,
                            course,
                            semester,
                            phone,
                            email,
                            address,
                            marks,
                            attendance
                    );

                    studentDAO.addStudent(student);
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    scanner.nextLine();

                    break;

                case 2:
                    studentDAO.viewStudents();
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println("Enter Student ID: ");
                    int searchID = scanner.nextInt();
                    studentDAO.searchStudent(searchID);
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;

                case 4:
                    scanner.nextLine();

                    Student updateStudent = new Student();

                    System.out.print("Enter Student ID: ");
                    updateStudent.setStudentId(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Enter Full Name: ");
                    updateStudent.setFullName(scanner.nextLine());

                    System.out.print("Enter Age: ");
                    updateStudent.setAge(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Enter Gender: ");
                    updateStudent.setGender(scanner.nextLine());

                    System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
                    updateStudent.setDob(Date.valueOf(scanner.nextLine()));

                    System.out.print("Enter Course: ");
                    updateStudent.setCourse(scanner.nextLine());

                    System.out.print("Enter Semester: ");
                    updateStudent.setSemester(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Enter Phone: ");
                    updateStudent.setPhone(scanner.nextLine());

                    System.out.print("Enter Email: ");
                    updateStudent.setEmail(scanner.nextLine());

                    System.out.print("Enter Address: ");
                    updateStudent.setAddress(scanner.nextLine());

                    System.out.print("Enter Marks: ");
                    updateStudent.setMarks(scanner.nextDouble());

                    System.out.print("Enter Attendance: ");
                    updateStudent.setAttendance(scanner.nextDouble());

                    studentDAO.updateStudent(updateStudent);
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    scanner.nextLine();

                    break;

                case 5:
                    System.out.println("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    studentDAO.deleteStudent(deleteId);
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
