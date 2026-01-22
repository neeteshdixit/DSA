package dsa.program;
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * ✅ TASK 3: Artificial Intelligence Chatbot
 * -------------------------------------------
 * ✔ Java-based interactive chatbot
 * ✔ Uses NLP (keyword + string similarity)
 * ✔ Rule-based + Self-learning logic
 * ✔ Trained on common FAQs
 * ✔ GUI-based real-time interaction
 */

public class AIChatbot extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton, clearButton;
    private Map<String, String> knowledgeBase;

    public AIChatbot() {
        setTitle("AI Chatbot 🤖");
        setSize(650, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- CHAT AREA ---
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        chatArea.setBackground(new Color(245, 245, 245));
        chatArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // --- INPUT AREA ---
        inputField = new JTextField();
        sendButton = new JButton("Send");
        clearButton = new JButton("Clear");

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.add(inputField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(clearButton);
        buttonPanel.add(sendButton);
        inputPanel.add(buttonPanel, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // --- KNOWLEDGE BASE (Trained FAQs) ---
        knowledgeBase = new HashMap<>();
        trainBot();

        // --- ACTIONS ---
        sendButton.addActionListener(e -> processInput());
        inputField.addActionListener(e -> processInput());
        clearButton.addActionListener(e -> chatArea.setText(""));

        // --- INITIAL GREETING ---
        chatArea.append("🤖 Chatbot: Hello! I’m your AI assistant.\n");
        chatArea.append("Type 'help' to see what I can do.\n\n");
    }

    private void trainBot() {
        // Frequently Asked Questions (Rule-based responses)
        knowledgeBase.put("hi", "Hello! How can I assist you today?");
        knowledgeBase.put("hello", "Hey there! What’s up?");
        knowledgeBase.put("how are you", "I’m just code, but I’m feeling awesome!");
        knowledgeBase.put("your name", "I’m your friendly AI Chatbot.");
        knowledgeBase.put("who created you", "I was created using Java and NLP logic.");
        knowledgeBase.put("what is java", "Java is a high-level, object-oriented programming language.");
        knowledgeBase.put("what can you do", "I can chat, answer your questions, and even learn new things!");
        knowledgeBase.put("bye", "Goodbye! It was nice chatting with you.");
        knowledgeBase.put("thank you", "You’re very welcome!");
        knowledgeBase.put("help", "You can ask me about Java, programming, or general questions!");
        knowledgeBase.put("time", "The current time is " + new java.util.Date());
        knowledgeBase.put("date", "Today's date is " + new java.util.Date());
        knowledgeBase.put("what is ai", "AI stands for Artificial Intelligence — the simulation of human intelligence by machines.");
        knowledgeBase.put("what is nlp", "NLP stands for Natural Language Processing — the technology that helps computers understand human language.");
    }

    private void processInput() {
        String userInput = inputField.getText().trim().toLowerCase();
        if (userInput.isEmpty()) return;

        chatArea.append("🧑 You: " + userInput + "\n");

        String response = generateResponse(userInput);
        chatArea.append("🤖 Chatbot: " + response + "\n\n");

        inputField.setText("");
    }

    private String generateResponse(String input) {
        // Direct match
        if (knowledgeBase.containsKey(input)) {
            return knowledgeBase.get(input);
        }

        // NLP-like fuzzy matching: find closest known phrase
        String bestMatch = null;
        int highestSimilarity = 0;

        for (String key : knowledgeBase.keySet()) {
            int similarity = getSimilarityScore(input, key);
            if (similarity > highestSimilarity) {
                highestSimilarity = similarity;
                bestMatch = key;
            }
        }

        // If similar question found
        if (highestSimilarity >= 60) { // 60% match threshold
            return knowledgeBase.get(bestMatch);
        }

        // If chatbot doesn't know the answer → learn new one
        String learnResponse = JOptionPane.showInputDialog(
                this,
                "I don't know how to respond to that.\nCan you teach me what I should reply with?",
                "Learn New Response",
                JOptionPane.QUESTION_MESSAGE
        );

        if (learnResponse != null && !learnResponse.trim().isEmpty()) {
            knowledgeBase.put(input, learnResponse.trim());
            return "Got it! I’ve learned something new. 😊";
        }

        return "Hmm... I’m not sure about that yet.";
    }

    // Simple NLP-like similarity check (based on common words)
    private int getSimilarityScore(String a, String b) {
        String[] aWords = a.split(" ");
        String[] bWords = b.split(" ");
        int matchCount = 0;

        for (String wordA : aWords) {
            for (String wordB : bWords) {
                if (wordA.equalsIgnoreCase(wordB)) {
                    matchCount++;
                }
            }
        }

        return (int) ((matchCount / (double) Math.max(aWords.length, bWords.length)) * 100);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AIChatbot bot = new AIChatbot();
            bot.setVisible(true);
        });
    }
}
