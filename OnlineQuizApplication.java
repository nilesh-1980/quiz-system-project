import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String text;
    private String[] options;
    private int correctAnswer; // Correct answer index is 0-based

    public Question(String text, String[] options, int correctAnswer) {
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer; // Assumed to be 0-based index
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public String getCorrectAnswerText() {
        return options[correctAnswer];
    }
}

class Quiz {
    private List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            int userAnswer = -1;
            boolean validAnswer = false;
            while (!validAnswer) {
                System.out.print("Enter your answer (1-" + options.length + "): ");
                try {
                    userAnswer = scanner.nextInt();
                    if (userAnswer >= 1 && userAnswer <= options.length) {
                        validAnswer = true;
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and " + options.length + ".");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }

            // Convert userAnswer to 0-based index for comparison
            if (userAnswer - 1 == question.getCorrectAnswer()) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + question.getCorrectAnswerText());
            }
        }

        System.out.println("Your final score is " + score + " out of " + questions.size());
    }
}

public class OnlineQuizApplication {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Add questions to the quiz
        quiz.addQuestion(new Question("What is the capital of France?", new String[] {"Paris", "London", "Berlin", "Rome"}, 0));
        quiz.addQuestion(new Question("What is the largest planet in our solar system?", new String[] {"Earth", "Saturn", "Jupiter", "Uranus"}, 2));
        quiz.addQuestion(new Question("What is the smallest country in the world?", new String[] {"Vatican City", "Monaco", "Nauru", "Tuvalu"}, 0));
        quiz.addQuestion(new Question("Which element has the chemical symbol 'O'?", new String[] {"Oxygen", "Gold", "Silver", "Iron"}, 0));
        quiz.addQuestion(new Question("What year did the Titanic sink?", new String[] {"1912", "1905", "1910", "1920"}, 0));
        quiz.addQuestion(new Question("Who wrote 'To Kill a Mockingbird'?", new String[] {"Harper Lee", "Mark Twain", "J.D. Salinger", "Ernest Hemingway"}, 0));
        quiz.addQuestion(new Question("What is the smallest prime number?", new String[] {"1", "2", "3", "5"}, 1));
        quiz.addQuestion(new Question("Which planet is known as the Red Planet?", new String[] {"Mars", "Venus", "Jupiter", "Saturn"}, 0));
        quiz.addQuestion(new Question("Who painted the Mona Lisa?", new String[] {"Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet"}, 0));
        quiz.addQuestion(new Question("In which year did World War II end?", new String[] {"1945", "1939", "1941", "1950"}, 0));

        // Take the quiz
        quiz.takeQuiz();
    }
}

