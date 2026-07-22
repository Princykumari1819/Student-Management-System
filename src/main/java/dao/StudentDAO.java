package dao;

import database.DBConnection;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class StudentDAO {

    public void addStudent(Student student) {

        String sql = "INSERT INTO students (full_name, age, gender, dob, course, semester, phone, email, address, marks, attendance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getGender());
            preparedStatement.setDate(4, student.getDob());
            preparedStatement.setString(5, student.getCourse());
            preparedStatement.setInt(6, student.getSemester());
            preparedStatement.setString(7, student.getPhone());
            preparedStatement.setString(8, student.getEmail());
            preparedStatement.setString(9, student.getAddress());
            preparedStatement.setDouble(10, student.getMarks());
            preparedStatement.setDouble(11, student.getAttendance());

            preparedStatement.executeUpdate();
            System.out.println("Student added successfully!");

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {

        String sql = "SELECT * FROM students";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                System.out.println("Student ID: " + resultSet.getInt("student_id"));
                System.out.println("Name: " + resultSet.getString("full_name"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("Gender: " + resultSet.getString("gender"));
                System.out.println("Course: " + resultSet.getString("course"));
                System.out.println("Semester: " + resultSet.getInt("semester"));
                System.out.println("Phone: " + resultSet.getString("phone"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Address: " + resultSet.getString("address"));
                System.out.println("Marks: " + resultSet.getDouble("marks"));
                System.out.println("Attendance: " + resultSet.getDouble("attendance"));
                System.out.println("---------------------------------------");
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchStudent(int studentId) {
        String sql = "SELECT * FROM students WHERE student_id = ?";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, studentId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                System.out.println("Student ID: " + resultSet.getInt("student_id"));
                System.out.println("Name: " + resultSet.getString("full_name"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("Gender: " + resultSet.getString("gender"));
                System.out.println("Date of Birth: " + resultSet.getDate("dob"));
                System.out.println("Course: " + resultSet.getString("course"));
                System.out.println("Semester: " + resultSet.getInt("semester"));
                System.out.println("Phone: " + resultSet.getString("phone"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Address: " + resultSet.getString("address"));
                System.out.println("Marks: " + resultSet.getDouble("marks"));
                System.out.println("Attendance: " + resultSet.getDouble("attendance"));

            } else {
                System.out.println("Student not found!");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {

        try {
            Connection connection = DBConnection.getConnection();

            String query = "UPDATE students SET full_name=?, age=?, gender=?, dob=?, course=?, semester=?, phone=?, email=?, address=?, marks=?, attendance=? WHERE student_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getGender());
            preparedStatement.setDate(4, student.getDob());
            preparedStatement.setString(5, student.getCourse());
            preparedStatement.setInt(6, student.getSemester());
            preparedStatement.setString(7, student.getPhone());
            preparedStatement.setString(8, student.getEmail());
            preparedStatement.setString(9, student.getAddress());
            preparedStatement.setDouble(10, student.getMarks());
            preparedStatement.setDouble(11, student.getAttendance());

            preparedStatement.setInt(12, student.getStudentId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found!");
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentId) {
        try {
            Connection connection = DBConnection.getConnection();
            String query = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
