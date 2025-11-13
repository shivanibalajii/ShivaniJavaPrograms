
import java.util.Scanner;

public class SGPA_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        int[] marks = new int[n];
        int[] credits = new int[n];
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Subject " + (i + 1));
            System.out.print("Enter marks (0-100): ");
            marks[i] = sc.nextInt();
            System.out.print("Enter credits: ");
            credits[i] = sc.nextInt();

            int gradePoint = getGradePoint(marks[i]);
            totalGradePoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        double sgpa = totalGradePoints / totalCredits;
        System.out.printf("Your SGPA is: %.2f\n", sgpa);
        sc.close();
    }

    // Convert marks to grade points (simple scale)
    public static int getGradePoint(int marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else if (marks >= 40) return 5;
        else return 0; // Fail
    }
}
