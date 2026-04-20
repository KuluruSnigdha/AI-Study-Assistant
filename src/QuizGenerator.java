import java.util.*;

public class QuizGenerator {

    public static void generateQuiz() {

        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("\n--- Quiz Time ---");

        System.out.println("Q1: What does OOP stand for?");
        System.out.println("A) Object Oriented Programming");
        System.out.println("B) Online Operating Program");
        System.out.println("C) Object Operation Process");
        System.out.println("D) None");

        String ans = sc.nextLine();

        if(ans.equalsIgnoreCase("A")) {
            System.out.println("Correct ✅");
            score++;
        } else {
            System.out.println("Wrong ❌");
        }

        System.out.println("Score: " + score);
    }
}