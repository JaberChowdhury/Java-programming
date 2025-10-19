// Quiz app

import java.nio.IntBuffer;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String questions[] = {
            "What is color of the sky at day light ? ",
            "What is the full meaning of CPU ?",
            "How many color does rainbow have ?",
        };
        String options[][] = {
            { "Blue", "Green", "Orange", "Red" },
            {
                "Central pointing unit",
                "Central Possible unit",
                "center pointed uncle",
                "Central Processing Unit",
            },
            { "$", "9", "7", "2" },
        };
        int answers[] = { 1, 4, 3 };

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
