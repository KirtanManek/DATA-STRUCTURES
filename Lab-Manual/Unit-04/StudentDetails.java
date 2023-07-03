import java.util.Scanner;

class Student_Detail {
    private int enrollmentNo;
    private String name;
    private int semester;
    private double cpi;

    public Student_Detail(int enrollmentNo, String name, int semester, double cpi) {
        this.enrollmentNo = enrollmentNo;
        this.name = name;
        this.semester = semester;
        this.cpi = cpi;
    }

    public int getEnrollmentNo() {
        return enrollmentNo;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public double getCPI() {
        return cpi;
    }
}
public class StudentDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of Student_Detail objects
        Student_Detail[] students = new Student_Detail[5];

        // Scan information for each student
        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter information for Student " + (i + 1) + ":");

            System.out.print("Enrollment No: ");
            int enrollmentNo = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Semester: ");
            int semester = scanner.nextInt();

            System.out.print("CPI: ");
            double cpi = scanner.nextDouble();

            // Create a new Student_Detail object and store it in the array
            students[i] = new Student_Detail(enrollmentNo, name, semester, cpi);
        }

        scanner.close();

        // Print the information for each student
        System.out.println("\nStudent Details:");
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Enrollment No: " + students[i].getEnrollmentNo());
            System.out.println("Name: " + students[i].getName());
            System.out.println("Semester: " + students[i].getSemester());
            System.out.println("CPI: " + students[i].getCPI());
            System.out.println();
        }
    }
}
