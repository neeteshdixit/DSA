package dsa.StudentGradesManager;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

class Student {
    private String name;
    private ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.size();
    }

    public int getHighest() {
        if (grades.isEmpty()) return 0;
        int max = Integer.MIN_VALUE;
        for (int g : grades) if (g > max) max = g;
        return max;
    }

    public int getLowest() {
        if (grades.isEmpty()) return 0;
        int min = Integer.MAX_VALUE;
        for (int g : grades) if (g < min) min = g;
        return min;
    }

    public String getLetterGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else if (avg >= 50) return "E";
        else return "F";
    }

    public String getPassStatus() {
        String grade = getLetterGrade();
        if (grade.equals("F")) return "Fail";
        else return "Pass";
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }
}

public class StudentGradesGUI extends JFrame {
    private ArrayList<Student> students = new ArrayList<>();
    private JComboBox<String> studentList;
    private JTextArea outputArea;
    private JTextField nameField, gradeField;

    public StudentGradesGUI() {
        setTitle("Student Grades Manager (With Pass/Fail)");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- UI Components ---
        JLabel nameLabel = new JLabel("Student Name:");
        nameField = new JTextField(10);
        JButton addStudentBtn = new JButton("Add Student");

        JLabel gradeLabel = new JLabel("Grade:");
        gradeField = new JTextField(5);
        JButton addGradeBtn = new JButton("Add Grade");

        studentList = new JComboBox<>();
        JButton showReportBtn = new JButton("Show Summary Report");

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // --- Layout ---
        JPanel topPanel = new JPanel();
        topPanel.add(nameLabel);
        topPanel.add(nameField);
        topPanel.add(addStudentBtn);

        JPanel midPanel = new JPanel();
        midPanel.add(new JLabel("Select Student:"));
        midPanel.add(studentList);
        midPanel.add(gradeLabel);
        midPanel.add(gradeField);
        midPanel.add(addGradeBtn);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(showReportBtn);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.EAST);

        // --- Button Actions ---
        addStudentBtn.addActionListener(e -> addStudent());
        addGradeBtn.addActionListener(e -> addGrade());
        showReportBtn.addActionListener(e -> showReport());
    }

    private void addStudent() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a student name.");
            return;
        }
        students.add(new Student(name));
        studentList.addItem(name);
        nameField.setText("");
        JOptionPane.showMessageDialog(this, "Student added successfully!");
    }

    private void addGrade() {
        if (studentList.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "Add a student first!");
            return;
        }

        String gradeText = gradeField.getText().trim();
        if (gradeText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a grade.");
            return;
        }

        try {
            int grade = Integer.parseInt(gradeText);
            if (grade < 0 || grade > 100) {
                JOptionPane.showMessageDialog(this, "Grade must be between 0 and 100.");
                return;
            }

            int index = studentList.getSelectedIndex();
            Student student = students.get(index);
            student.addGrade(grade);
            gradeField.setText("");
            JOptionPane.showMessageDialog(this, "Grade added successfully!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid grade! Enter a number.");
        }
    }

    private void showReport() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No student data available!");
            return;
        }

        StringBuilder report = new StringBuilder("===== STUDENT SUMMARY REPORT =====\n\n");
        for (Student s : students) {
            report.append("Name: ").append(s.getName()).append("\n");
            report.append("Grades: ").append(s.getGrades()).append("\n");
            report.append(String.format("Average: %.2f\n", s.getAverage()));
            report.append("Highest: ").append(s.getHighest()).append("\n");
            report.append("Lowest: ").append(s.getLowest()).append("\n");
            report.append("Letter Grade: ").append(s.getLetterGrade()).append("\n");
            report.append("Status: ").append(s.getPassStatus()).append("\n\n");
        }
        outputArea.setText(report.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentGradesGUI frame = new StudentGradesGUI();
            frame.setVisible(true);
        });
    }
}
