package games;

import java.util.Scanner;

public class QuizGame {

    public static void start() {
        String[] questions = {
            // Original 5
            "What was the first programming language?",
            "Who is the father of computers?",
            "Which language does the computer understand directly?",
            "Which data structure is typically used to implement recursion?",
            "Which of these is NOT an Operating System?", // Replaced duplicate question
            // New 10
            "Which component is known as the brain of the computer?",
            "How many bits make up one byte?",
            "Which memory is volatile (data is lost when power is off)?",
            "What does 'S' stand for in HTTPS?",
            "Who is known as the father of Java?",
            "What is the time complexity of Binary Search?",
            "Which protocol is used to browse websites?",
            "What is the extension of a Java bytecode file?",
            "Which loop is guaranteed to execute at least once?",
            "What does SQL stand for?",
        };

        String[][] options = {
            // 1
            { "1.C", "2.Java", "3.Fortran", "4.Python" },
            // 2
            {
                "1.Alan Turing",
                "2.John von Neumann",
                "3.Charles Babbage",
                "4.Dennis Ritchie",
            },
            // 3
            {
                "1.Assembly Language",
                "2.High-Level Language",
                "3.C Language",
                "4.Machine Language",
            },
            // 4
            { "1.Queue", "2.Stack", "3.Linked List", "4.Array" },
            // 5
            { "1.Windows", "2.Linux", "3.Oracle", "4.MacOS" },
            // New Options
            // 6 (Brain)
            { "1.RAM", "2.CPU", "3.Hard Disk", "4.Monitor" },
            // 7 (Bits in Byte)
            { "1.4", "2.8", "3.16", "4.32" },
            // 8 (Volatile)
            { "1.ROM", "2.HDD", "3.RAM", "4.SSD" },
            // 9 (HTTPS)
            { "1.System", "2.Secure", "3.Simple", "4.Standard" },
            // 10 (Java Father)
            {
                "1.Guido van Rossum",
                "2.Bjarne Stroustrup",
                "3.James Gosling",
                "4.Mark Zuckerberg",
            },
            // 11 (Binary Search)
            { "1.O(n)", "2.O(n^2)", "3.O(log n)", "4.O(1)" },
            // 12 (Protocol)
            { "1.FTP", "2.SMTP", "3.HTTP", "4.TCP" },
            // 13 (Extension)
            { "1..java", "2..class", "3..js", "4..txt" },
            // 14 (Loop)
            { "1.For Loop", "2.While Loop", "3.Do-While Loop", "4.None" },
            // 15 (SQL)
            {
                "1.Structured Query Language",
                "2.Simple Query Language",
                "3.System Question List",
                "4.Standard Query Logic",
            },
        };

        // corresponding correct option numbers (1-4)
        int[] answers = {
            3, // Fortran
            3, // Charles Babbage
            4, // Machine Language
            2, // Stack
            3, // Oracle (Database, not OS)
            2, // CPU
            2, // 8 bits
            3, // RAM
            2, // Secure
            3, // James Gosling
            3, // O(log n)
            3, // HTTP
            2, // .class
            3, // Do-While
            1, // Structured Query Language
        };
        int score = 0;
        int choice;

        Scanner scanner = new Scanner(System.in);
        System.out.println("***Welcome to the Quiz Game***");

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your guess: ");
            choice = scanner.nextInt();

            if (choice == answers[i]) {
                System.out.println("CORRECT!");
                score++;
            } else {
                System.out.println("WRONG!");
            }
        }

        System.out.println(
            "Your final score is: " + score + "out of" + questions.length
        );

        scanner.close();
    }
}
