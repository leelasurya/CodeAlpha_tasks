
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> studentGrades = new ArrayList<>();

        System.out.println("=================================");
        System.out.println("     STUDENT GRADE TRACKER");
        System.out.println("=================================");

        System.out.print("\nEnter number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfStudents; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine();

            studentNames.add(name);
            studentGrades.add(grade);
        }

        // Calculate average, highest and lowest
        double total = 0;
        double highest = studentGrades.get(0);
        double lowest = studentGrades.get(0);

        for (double grade : studentGrades) {

            total += grade;

            if (grade > highest) {
                highest = grade;
            }

            if (grade < lowest) {
                lowest = grade;
            }
        }

        double average = total / numberOfStudents;

        System.out.println("\n=================================");
        System.out.println("        STUDENT REPORT");
        System.out.println("=================================");

        System.out.printf("%-20s %-10s%n", "Student Name", "Grade");
        System.out.println("---------------------------------");

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.printf(
                "%-20s %-10.2f%n",
                studentNames.get(i),
                studentGrades.get(i)
            );
        }

        System.out.println("---------------------------------");

        System.out.printf("Average Score : %.2f%n", average);
        System.out.printf("Highest Score : %.2f%n", highest);
        System.out.printf("Lowest Score  : %.2f%n", lowest);

        System.out.println("=================================");

        scanner.close();
    }
}
