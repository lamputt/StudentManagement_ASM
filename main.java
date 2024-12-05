import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();

        System.out.print("Welcome to student management ");
        int numberOfStudents = -1;
        
        // Kiểm tra nhập số lượng sinh viên hợp lệ
        while (numberOfStudents < 0) {
            System.out.print("Enter the number of students to manage: ");
            if (scanner.hasNextInt()) {
                numberOfStudents = scanner.nextInt();
                if (numberOfStudents < 0) {
                    System.out.println("Please enter a valid number of students (greater than or equal to 0).");
                }
            } else {
                System.out.println("Invalid input! Please enter a numeric value.");
                scanner.next(); // Đọc bỏ giá trị không hợp lệ
            }
        }
        scanner.nextLine();  // Đọc bỏ dòng newline sau khi nhập số lượng sinh viên

        int enteredStudents = 0;

        while (true) {
            System.out.println("Please enter your request");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Info");
            System.out.println("3. Sort Students by Score");
            System.out.println("4. Remove Student");
            System.out.println("5. Find Student by ID");
            System.out.println("6. Print All Students");
            System.out.println("7. Exit");

            int choice = -1;  
            while (choice < 1 || choice > 7) {
                System.out.print("Enter your choice: ");
                if (scanner.hasNextInt()) {  
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 7) {
                        System.out.println("Invalid choice! Please select a number between 1 and 7.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a numeric value between 1 and 7.");
                    scanner.next();  
                }
            }
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    if (enteredStudents >= numberOfStudents) {
                        System.out.println("You have exceeded the number of students to manage");
                        break;
                    }

                    Student newStudent = new Student();
                    System.out.print("Enter ID for new student: ");
                    newStudent.setId(scanner.nextLine());

                    if (studentManagement.checkId(newStudent.getId())) {
                        System.out.println("Student with ID " + newStudent.getId() + " already exists. Please enter a different ID.");
                        break;
                    }

                    System.out.print("Enter Full Name for new student: ");
                    newStudent.setFullname(scanner.nextLine());

                    double score = studentManagement.getValidScore();
                    newStudent.setScore(score);

                    studentManagement.addStudent(newStudent);
                    enteredStudents++;
                    break;

                case 2:
                    System.out.print("Enter ID of the student to update: ");
                    String Idstudent = scanner.nextLine();

                    Student studentToUpdate = studentManagement.findStudentById(Idstudent);
                    if (studentToUpdate == null) {
                        break;
                    }
                    System.out.print("Enter new Full Name: ");
                    String newFullname = scanner.nextLine();

                    double newScoreUpdate = studentManagement.getValidScore();
                    studentManagement.updateStudentById(Idstudent, newFullname, newScoreUpdate);
                    break;

                case 3:
                    studentManagement.sortStudentsByScore();
                    break;

                case 4:
                    System.out.print("Enter ID of the student to remove: ");
                    String removeId = scanner.nextLine();
                    studentManagement.removeStudent(removeId);
                    break;

                case 5:
                    System.out.print("Enter ID of the student to find: ");
                    String findId = scanner.nextLine();
                    studentManagement.findStudentById(findId);
                    break;

                case 6:
                    studentManagement.printAllStudents();
                    break;

                case 7:
                    System.out.println("Exiting program");
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
