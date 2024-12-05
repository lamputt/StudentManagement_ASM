import java.util.ArrayList;
import java.util.Scanner;
public class StudentManagement {
    ArrayList<Student> listStudent = new ArrayList<>();

    public void addStudent(Student student) {
        listStudent.add(student);
        System.out.println("The student just added to the student list is named: " + student.getFullname() 
                + " id is: " + student.getId() + " score is: " + student.getScore() + " ranking is: " + student.getRank());  
    }

    public boolean checkId(String id) {
        for (Student s : listStudent) {
            if (s.getId().equals(id)) {
                return true; 
            }
        }
        return false; 
    }

    public void removeStudent(String studentId) {
        Student studentToRemove = null;
        for (Student student : listStudent) {
            if (student.getId().equals(studentId)) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            listStudent.remove(studentToRemove);
            System.out.println("Removed student: Name: " + studentToRemove.getFullname() 
                    + ", id is : " + studentToRemove.getId() 
                    + ", score is : " + studentToRemove.getScore() 
                    + ", ranking is : " + studentToRemove.getRank());
        } else {
            System.out.println("Student with ID " + studentId + " does not exist.");
        }
    }
    public void sortStudentsByScore() {
        if (listStudent.isEmpty()) {
            System.out.println("No students in the list to sort.");
            return;
        }
        int n = listStudent.size();
        boolean swapped;
    
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (listStudent.get(j).getScore() < listStudent.get(j + 1).getScore()) {
                    Student temp = listStudent.get(j);
                    listStudent.set(j, listStudent.get(j + 1));
                    listStudent.set(j + 1, temp);
                    swapped = true; 
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.println("Students sorted by score from highest to lowest:");
        for (Student student : listStudent) {
            System.out.println("Name: " + student.getFullname() 
                    + ", ID: " + student.getId() 
                    + ", Score: " + student.getScore() 
                    + ", Rank: " + student.getRank());
        }
      
    }

    // private ArrayList<Student> mergeSort(ArrayList<Student> students) {
    //     if (students.size() <= 1) {
    //         return students;
    //     }

    //     int mid = students.size() / 2;
    //     ArrayList<Student> left = new ArrayList<>(students.subList(0, mid));
    //     ArrayList<Student> right = new ArrayList<>(students.subList(mid, students.size()));

    //     left = mergeSort(left);
    //     right = mergeSort(right);

    //     return merge(left, right);
    // }

    // private ArrayList<Student> merge(ArrayList<Student> left, ArrayList<Student> right) {
    //     ArrayList<Student> merged = new ArrayList<>();
    //     int i = 0, j = 0;

    //     while (i < left.size() && j < right.size()) {
    //         if (left.get(i).getScore() >= right.get(j).getScore()) {
    //             merged.add(left.get(i));
    //             i++;
    //         } else {
    //             merged.add(right.get(j));
    //             j++;
    //         }
    //     }

    //     while (i < left.size()) {
    //         merged.add(left.get(i));
    //         i++;
    //     }

    //     while (j < right.size()) {
    //         merged.add(right.get(j));
    //         j++;
    //     }

    //     return merged;
    // }

       public Student findStudentById(String studentId) {
        for (Student student : listStudent) {
            if (student.getId().equals(studentId)) {
                System.out.println("Found student: Name: " + student.getFullname() 
                        + ", ID is : " + student.getId() 
                        + ", Score is : " + student.getScore() 
                        + ", Rank is : " + student.getRank());
                return student; 
            }
        }
        System.out.println("Student with ID " + studentId + " does not exist.");
        return null; 
    }

    // Cập nhật thông tin học sinh bằng ID, sử dụng phương thức getValidScore
    public void updateStudentById(String studentId, String newFullname, Double newScore) {
        Student studentToUpdate = findStudentById(studentId);
        if (studentToUpdate == null) {
            System.out.println("Student with ID " + studentId + " does not exist.");
            return;
        }

        studentToUpdate.setFullname(newFullname);

        // Sử dụng phương thức getValidScore để lấy điểm hợp lệ
        double validScore = getValidScore();
        studentToUpdate.setScore(validScore);

        System.out.println("Updated student info: Name: " + studentToUpdate.getFullname() 
                + ", ID: " + studentToUpdate.getId() 
                + ", Score: " + studentToUpdate.getScore() 
                + ", Rank: " + studentToUpdate.getRank());
    }

    // Phương thức kiểm tra và yêu cầu nhập điểm hợp lệ từ người dùng
    public double getValidScore() {
        Scanner scanner = new Scanner(System.in);
        double score;
        while (true) {
            System.out.print("Enter Score (0-10): ");
            if (scanner.hasNextDouble()) {
                score = scanner.nextDouble();
                if (score >= 0 && score <= 10) {
                    break;
                } else {
                    System.out.println("Invalid score, please enter a valid score between 0 and 10.");
                }
            } else {
                System.out.println("Invalid input! Please enter a numeric value for the score.");
                scanner.next(); 
            }
        }
        return score;
    }

    // In ra tất cả các học sinh
    public void printAllStudents() {
        if (listStudent.isEmpty()) {
            System.out.println("No students in the list.");
            return;
        }
        System.out.println("Student List:");
        for (Student student : listStudent) {
            System.out.println("Name: " + student.getFullname() 
                    + ", ID is : " + student.getId() 
                    + ", Score is : " + student.getScore() 
                    + ", Rank is : " + student.getRank());
        }
    }
}
