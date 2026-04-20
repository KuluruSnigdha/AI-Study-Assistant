//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("AI Study Assistant");

        System.out.println("Enter number of topics:");
        int n = sc.nextInt();
        sc.nextLine();

        String[] topics = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter topic " + (i+1) + ":");
            topics[i] = sc.nextLine();
        }

        System.out.println("Enter number of days:");
        int days = sc.nextInt();

        // calling planner
        StudyPlanner.generatePlan(topics, days);
        QuizGenerator.generateQuiz();
    }
}