public class StudyPlanner {

    public static void generatePlan(String[] topics, int days) {

        int daysPerTopic = days / topics.length;

        System.out.println("\nYour Study Plan:\n");

        for (int i = 0; i < topics.length; i++) {

            int start = i * daysPerTopic + 1;
            int end = start + daysPerTopic - 1;

            System.out.println("Day " + start + " - " + end + " : " + topics[i]);
        }

        System.out.println("Last days → Revision");
    }
}