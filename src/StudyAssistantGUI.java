
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class StudyAssistantGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("AI Study Assistant");
        frame.setSize(450,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.getContentPane().setBackground(new Color(30,30,60));

        JLabel title = new JLabel("AI Study Assistant");
        title.setBounds(140,10,200,25);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(title);

        JLabel label1 = new JLabel("Topics (topic-difficulty):");
        label1.setBounds(20,50,200,25);
        label1.setForeground(Color.WHITE);
        frame.add(label1);

        JTextField topicsField = new JTextField();
        topicsField.setBounds(200,50,200,25);
        frame.add(topicsField);

        JLabel label2 = new JLabel("Days:");
        label2.setBounds(20,90,150,25);
        label2.setForeground(Color.WHITE);
        frame.add(label2);

        JTextField daysField = new JTextField();
        daysField.setBounds(200,90,200,25);
        frame.add(daysField);

        JButton btn = new JButton("Generate Plan");
        btn.setBounds(130,130,180,30);
        btn.setBackground(new Color(0,150,255));
        btn.setForeground(Color.WHITE);
        frame.add(btn);

        JButton saveBtn = new JButton("Save Plan");
        saveBtn.setBounds(130,170,180,30);
        frame.add(saveBtn);

        JTextArea result = new JTextArea();
        result.setBounds(20,210,390,120);
        result.setEditable(false);
        frame.add(result);

        JProgressBar bar = new JProgressBar(0,100);
        bar.setBounds(20,340,390,20);
        frame.add(bar);

        // GENERATE PLAN
        btn.addActionListener(e -> {

            if(topicsField.getText().isEmpty() || daysField.getText().isEmpty()) {
                result.setText("⚠ Enter all fields!");
                return;
            }

            String[] topics = topicsField.getText().split(",");
            int days = Integer.parseInt(daysField.getText());

            int totalWeight = 0;

            for(String t : topics) {
                if(t.contains("hard")) totalWeight += 3;
                else if(t.contains("medium")) totalWeight += 2;
                else totalWeight += 1;
            }

            int currentDay = 1;
            result.setText("");

            for(String t : topics) {

                String name = t.split("-")[0];
                int weight = 1;

                if(t.contains("hard")) weight = 3;
                else if(t.contains("medium")) weight = 2;

                int topicDays = (days * weight) / totalWeight;

                int end = currentDay + topicDays - 1;

                result.append("Day "+currentDay+"-"+end+" : "+name+"\n");

                currentDay = end + 1;
            }

            result.append("\nRevision at end 📘");

            bar.setValue(100);
        });

        // SAVE FILE
        saveBtn.addActionListener(e -> {
            try {
                FileWriter fw = new FileWriter("study_plan.txt");
                fw.write(result.getText());
                fw.close();
                JOptionPane.showMessageDialog(frame, "Saved successfully!");
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error saving file");
            }
        });

        frame.setVisible(true);
    }
}