package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Student {

    private int studentId;
    private String fullName;
    private int age;
    private String gender;
    private Date dob;
    private String course;
    private int semester;
    private String phone;
    private String email;
    private String address;
    private double marks;
    private double attendance;
    private Timestamp createdAt;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", course='" + course + '\'' +
                ", semester=" + semester +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", marks=" + marks +
                ", attendance=" + attendance +
                ", createdAt=" + createdAt +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Student(String fullName, int age, String gender, Date dob,
                   String course, int semester, String phone, String email,
                   String address, double marks, double attendance) {

        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
        this.course = course;
        this.semester = semester;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.marks = marks;
        this.attendance = attendance;

    }
}
