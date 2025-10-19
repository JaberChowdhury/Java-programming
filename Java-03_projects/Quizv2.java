// Quiz app

import java.util.Scanner;

class Quiz {

    public String question;
    public String[] options;
    public int answer;

    Quiz(String question, String[] opt, int answer) {
        this.question = question;
        this.options = opt;
        this.answer = answer;
    }
}

public class Quizv2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Quiz[] quizes = {
            new Quiz(
                "What is the color of the sky at day light  ?",
                new String[] { "Blue", "Green", "Orange", "Red" },
                0
            ),
            new Quiz(
                "What is the full meaning of CPU  ?",
                new String[] {
                    "Central pointing unit",
                    "Central Possible unit",
                    "Center pointed uncle",
                    "Central Processing Unit",
                },
                3
            ),
            new Quiz(
                "How many colors does a rainbow have  ?",
                new String[] { "5", "9", "7", "2" },
                2
            ),
            new Quiz(
                "Which planet is known as the Red Planet  ?",
                new String[] { "Earth", "Mars", "Jupiter", "Saturn" },
                1
            ),
            new Quiz(
                "What is the capital of Bangladesh  ?",
                new String[] { "Dhaka", "Chittagong", "Khulna", "Sylhet" },
                0
            ),
            new Quiz(
                "Which gas do humans need to survive  ?",
                new String[] {
                    "Carbon Dioxide",
                    "Oxygen",
                    "Hydrogen",
                    "Nitrogen",
                },
                1
            ),
            new Quiz(
                "Who is known as the Father of Computers  ?",
                new String[] {
                    "Albert Einstein",
                    "Isaac Newton",
                    "Charles Babbage",
                    "Elon Musk",
                },
                2
            ),
            new Quiz(
                "What is the largest mammal in the world  ?",
                new String[] { "Elephant", "Blue Whale", "Shark", "Dinosaur" },
                1
            ),
            new Quiz(
                "How many continents are there in the world  ?",
                new String[] { "5", "6", "7", "8" },
                2
            ),
            new Quiz(
                "Which device is used to take a photo  ?",
                new String[] { "Camera", "Keyboard", "Printer", "Mouse" },
                0
            ),
            new Quiz(
                "Which is the fastest land animal  ?",
                new String[] { "Tiger", "Leopard", "Cheetah", "Horse" },
                2
            ),
            new Quiz(
                "What is the national flower of Bangladesh  ?",
                new String[] { "Water Lily", "Rose", "Lotus", "Tulip" },
                0
            ),
            new Quiz(
                "Which programming language is used for Android apps  ?",
                new String[] { "Python", "Java", "C", "JavaScript" },
                1
            ),
            new Quiz(
                "What is the boiling point of water (Celsius)  ?",
                new String[] { "50  ?C", "100  ?C", "150  ?C", "200  ?C" },
                1
            ),
            new Quiz(
                "Who invented the light bulb  ?",
                new String[] { "Newton", "Edison", "Tesla", "Faraday" },
                1
            ),
            new Quiz(
                "Which is the smallest prime number  ?",
                new String[] { "0", "1", "2", "3" },
                1
            ),
            new Quiz(
                "What is the currency of Japan  ?",
                new String[] { "Yuan", "Yen", "Won", "Rupee" },
                1
            ),
            new Quiz(
                "Which ocean is the largest  ?",
                new String[] { "Atlantic", "Indian", "Pacific", "Arctic" },
                2
            ),
            new Quiz(
                "How many days are there in a leap year  ?",
                new String[] { "365", "366", "367", "364" },
                1
            ),
            new Quiz(
                "What is H2O commonly known as  ?",
                new String[] { "Salt", "Water", "Oxygen", "Hydrogen" },
                1
            ),
            new Quiz(
                "Which is the tallest mountain in the world  ?",
                new String[] {
                    "Mount Everest",
                    "K2",
                    "Kangchenjunga",
                    "Himalaya",
                },
                0
            ),
            new Quiz(
                "What is the national game of Bangladesh  ?",
                new String[] { "Cricket", "Kabaddi", "Football", "Hockey" },
                1
            ),
            new Quiz(
                "Which key is used to refresh a web page  ?",
                new String[] { "F5", "Ctrl", "Alt", "Esc" },
                0
            ),
            new Quiz(
                "Which programming language is known as the mother of all languages  ?",
                new String[] { "C", "Assembly", "FORTRAN", "COBOL" },
                2
            ),
            new Quiz(
                "Who discovered gravity  ?",
                new String[] { "Galileo", "Newton", "Einstein", "Darwin" },
                1
            ),
            new Quiz(
                "What is the national animal of Bangladesh  ?",
                new String[] {
                    "Elephant",
                    "Tiger",
                    "Cow",
                    "Royal Bengal Tiger",
                },
                3
            ),
            new Quiz(
                "Which country is called the Land of Rising Sun  ?",
                new String[] { "China", "Japan", "Korea", "Thailand" },
                1
            ),
            new Quiz(
                "What is the capital of India  ?",
                new String[] { "New Delhi", "Mumbai", "Kolkata", "Hyderabad" },
                0
            ),
            new Quiz(
                "Which number is known as a dozen  ?",
                new String[] { "6", "10", "12", "20" },
                2
            ),
            new Quiz(
                "How many hours are there in a day  ?",
                new String[] { "22", "23", "24", "25" },
                2
            ),
            new Quiz(
                "Which is the longest river in the world  ?",
                new String[] { "Amazon", "Nile", "Padma", "Yangtze" },
                1
            ),
            new Quiz(
                "Which organ pumps blood in the human body  ?",
                new String[] { "Lungs", "Heart", "Kidney", "Brain" },
                1
            ),
            new Quiz(
                "What is the freezing point of water (Celsius)  ?",
                new String[] { "0  ?C", "100  ?C", "-10  ?C", "32  ?C" },
                0
            ),
            new Quiz(
                "Which is the smallest country in the world  ?",
                new String[] { "Maldives", "Vatican City", "Nepal", "Bhutan" },
                1
            ),
            new Quiz(
                "What is the capital of the USA  ?",
                new String[] {
                    "Washington D.C.",
                    "New York",
                    "Chicago",
                    "Los Angeles",
                },
                0
            ),
            new Quiz(
                "Which element has the chemical symbol 'O'  ?",
                new String[] { "Oxygen", "Gold", "Hydrogen", "Carbon" },
                0
            ),
            new Quiz(
                "What is the national fruit of Bangladesh  ?",
                new String[] { "Banana", "Mango", "Jackfruit", "Litchi" },
                2
            ),
            new Quiz(
                "Which planet is closest to the Sun  ?",
                new String[] { "Mercury", "Venus", "Earth", "Mars" },
                0
            ),
            new Quiz(
                "Who wrote 'Gitanjali'  ?",
                new String[] {
                    "Rabindranath Tagore",
                    "Kazi Nazrul Islam",
                    "Bankim Chandra",
                    "Sarat Chandra",
                },
                0
            ),
            new Quiz(
                "What is the national bird of Bangladesh  ?",
                new String[] { "Crow", "Doel", "Pigeon", "Peacock" },
                1
            ),
            new Quiz(
                "Which device is used to measure temperature  ?",
                new String[] {
                    "Barometer",
                    "Thermometer",
                    "Speedometer",
                    "Voltmeter",
                },
                1
            ),
            new Quiz(
                "Which blood type is known as universal donor  ?",
                new String[] { "A", "B", "O-", "O+" },
                2
            ),
            new Quiz(
                "Which is the hardest natural substance  ?",
                new String[] { "Gold", "Diamond", "Iron", "Graphite" },
                1
            ),
            new Quiz(
                "What is the national currency of Bangladesh  ?",
                new String[] { "Taka", "Rupee", "Dollar", "Yen" },
                0
            ),
            new Quiz(
                "Which company created Windows OS  ?",
                new String[] { "Google", "Microsoft", "Apple", "IBM" },
                1
            ),
        };

        int correctAnswers = 0;
        for (int i = 0; i < quizes.length; i++) {
            System.out.println("[" + (i + 1) + "] " + quizes[i].question);
            for (int j = 0; j < quizes[i].options.length; j++) {
                System.out.println("[" + (j + 1) + "] " + quizes[i].options[j]);
            }
            int userans;
            System.out.print("Enter your answer: ");
            userans = scanner.nextInt();

            if (userans == quizes[i].answer) {
                System.out.println("Correct!");
                correctAnswers++;
                System.out.println("Well done!");
            } else {
                System.out.println("Incorrect!");
                System.out.println(
                    "The correct answer is " +
                        quizes[i].options[quizes[i].answer]
                );
            }
        }

        System.out.println(
            "You got " +
                correctAnswers +
                " out of " +
                quizes.length +
                " questions correct."
        );

        scanner.close();
    }
}
