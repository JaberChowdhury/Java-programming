// Quiz app

import java.nio.IntBuffer;
import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String questions[] = {
            "What is the color of the sky at day light?",
            "What is the full meaning of CPU?",
            "How many colors does a rainbow have?",
            "Which planet is known as the Red Planet?",
            "What is the capital of Bangladesh?",
            "Which gas do humans need to survive?",
            "Who is known as the Father of Computers?",
            "What is the largest mammal in the world?",
            "How many continents are there in the world?",
            "Which device is used to take a photo?",
            "Which is the fastest land animal?",
            "What is the national flower of Bangladesh?",
            "Which programming language is used for Android apps?",
            "What is the boiling point of water (Celsius)?",
            "Who invented the light bulb?",
            "Which is the smallest prime number?",
            "What is the currency of Japan?",
            "Which ocean is the largest?",
            "How many days are there in a leap year?",
            "What is H2O commonly known as?",
            "Which is the tallest mountain in the world?",
            "What is the national game of Bangladesh?",
            "Which key is used to refresh a web page?",
            "Which programming language is known as the mother of all languages?",
            "Who discovered gravity?",
            "What is the national animal of Bangladesh?",
            "Which country is called the Land of Rising Sun?",
            "What is the capital of India?",
            "Which number is known as a dozen?",
            "How many hours are there in a day?",
            "Which is the longest river in the world?",
            "Which organ pumps blood in the human body?",
            "What is the freezing point of water (Celsius)?",
            "Which is the smallest country in the world?",
            "What is the capital of the USA?",
            "Which element has the chemical symbol 'O'?",
            "What is the national fruit of Bangladesh?",
            "Which planet is closest to the Sun?",
            "Who wrote 'Gitanjali'?",
            "What is the national bird of Bangladesh?",
            "Which device is used to measure temperature?",
            "Which blood type is known as universal donor?",
            "Which is the hardest natural substance?",
            "What is the national currency of Bangladesh?",
            "Which company created Windows OS?",
        };

        String options[][] = {
            { "Blue", "Green", "Orange", "Red" },
            {
                "Central pointing unit",
                "Central Possible unit",
                "Center pointed uncle",
                "Central Processing Unit",
            },
            { "5", "9", "7", "2" },
            { "Earth", "Mars", "Jupiter", "Saturn" },
            { "Dhaka", "Chittagong", "Khulna", "Sylhet" },
            { "Carbon Dioxide", "Oxygen", "Hydrogen", "Nitrogen" },
            {
                "Albert Einstein",
                "Isaac Newton",
                "Charles Babbage",
                "Elon Musk",
            },
            { "Elephant", "Blue Whale", "Shark", "Dinosaur" },
            { "5", "6", "7", "8" },
            { "Camera", "Keyboard", "Printer", "Mouse" },
            { "Tiger", "Leopard", "Cheetah", "Horse" },
            { "Water Lily", "Rose", "Lotus", "Tulip" },
            { "Python", "Java", "C", "JavaScript" },
            { "50°C", "100°C", "150°C", "200°C" },
            { "Newton", "Edison", "Tesla", "Faraday" },
            { "0", "1", "2", "3" },
            { "Yuan", "Yen", "Won", "Rupee" },
            { "Atlantic", "Indian", "Pacific", "Arctic" },
            { "365", "366", "367", "364" },
            { "Salt", "Water", "Oxygen", "Hydrogen" },
            { "Mount Everest", "K2", "Kangchenjunga", "Himalaya" },
            { "Cricket", "Kabaddi", "Football", "Hockey" },
            { "F5", "Ctrl", "Alt", "Esc" },
            { "C", "Assembly", "FORTRAN", "COBOL" },
            { "Galileo", "Newton", "Einstein", "Darwin" },
            { "Elephant", "Tiger", "Cow", "Royal Bengal Tiger" },
            { "China", "Japan", "Korea", "Thailand" },
            { "New Delhi", "Mumbai", "Kolkata", "Hyderabad" },
            { "6", "10", "12", "20" },
            { "22", "23", "24", "25" },
            { "Amazon", "Nile", "Padma", "Yangtze" },
            { "Lungs", "Heart", "Kidney", "Brain" },
            { "0°C", "100°C", "-10°C", "32°C" },
            { "Maldives", "Vatican City", "Nepal", "Bhutan" },
            { "Washington D.C.", "New York", "Chicago", "Los Angeles" },
            { "Oxygen", "Gold", "Hydrogen", "Carbon" },
            { "Banana", "Mango", "Jackfruit", "Litchi" },
            { "Mercury", "Venus", "Earth", "Mars" },
            {
                "Rabindranath Tagore",
                "Kazi Nazrul Islam",
                "Bankim Chandra",
                "Sarat Chandra",
            },
            { "Crow", "Doel", "Pigeon", "Peacock" },
            { "Barometer", "Thermometer", "Speedometer", "Voltmeter" },
            { "A", "B", "O-", "O+" },
            { "Gold", "Diamond", "Iron", "Graphite" },
            { "Taka", "Rupee", "Dollar", "Yen" },
            { "Google", "Microsoft", "Apple", "IBM" },
        };

        int answers[] = {
            1, // Blue
            4, // CPU = Central Processing Unit
            3, // Rainbow = 7
            2, // Mars
            1, // Dhaka
            2, // Oxygen
            3, // Charles Babbage
            2, // Blue Whale
            3, // 7 continents
            1, // Camera
            3, // Cheetah
            1, // Water Lily
            2, // Java
            2, // 100°C
            2, // Edison
            2, // 1 (smallest prime)
            2, // Yen
            3, // Pacific
            2, // 366 days
            2, // Water
            1, // Mount Everest
            2, // Kabaddi
            1, // F5
            3, // FORTRAN
            2, // Newton
            4, // Royal Bengal Tiger
            2, // Japan
            1, // New Delhi
            3, // 12
            3, // 24
            2, // Nile
            2, // Heart
            1, // 0°C
            2, // Vatican City
            1, // Washington D.C.
            1, // Oxygen
            3, // Jackfruit
            1, // Mercury
            1, // Rabindranath Tagore
            2, // Doel
            2, // Thermometer
            3, // O-
            2, // Diamond
            1, // Taka
            2, // Microsoft
        };

        int correct = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println("[" + (i + 1) + "].  " + questions[i]);

            for (int j = 0; j < options[i].length; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }
            int userans;
            userans = scanner.nextInt();

            if (userans == answers[i]) {
                correct++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
                System.out.println(
                    "The correct answer is: " + options[i][answers[i] - 1]
                );
            }
        }

        System.out.println(
            "You got " +
                correct +
                " out of " +
                questions.length +
                " questions correct."
        );

        scanner.close();
    }
}
