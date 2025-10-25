import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Database {

    private File databaseFile;

    public Database(String fileName) {
        this.databaseFile = new File(fileName + ".txt");
        try {
            if (this.databaseFile.createNewFile()) {
                System.out.println(
                    "Database file created: " + this.databaseFile.getName()
                );
            } else {
                System.out.println(
                    "Using existing database file: " +
                        this.databaseFile.getName()
                );
            }
        } catch (IOException e) {
            System.err.println(
                "Error: Could not create or access database file."
            );
            e.printStackTrace();
        }
    }

    public User[] read_db() {
        ArrayList<User> userList = new ArrayList<>();

        try (Scanner scan = new Scanner(this.databaseFile)) {
            if (!scan.hasNextLine()) {
                System.out.println("Database file is empty. No users to read.");
                return new User[0];
            }

            String header = scan.nextLine();

            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                if (data.trim().isEmpty()) {
                    continue;
                }

                User user = User.fromCsvString(data);
                if (user != null) {
                    userList.add(user);
                } else {
                    System.err.println("Skipping invalid line: " + data);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Database file not found during read.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(
                "An unexpected error occurred during database read."
            );
            e.printStackTrace();
        }

        return userList.toArray(new User[0]);
    }

    public void sync(User[] users) {
        try (
            FileWriter fw = new FileWriter(this.databaseFile, false);
            PrintWriter pw = new PrintWriter(fw)
        ) {
            pw.println("name,id,pin,password,loan,amount,role");

            for (User user : users) {
                pw.println(user.toCsvString());
            }

            System.out.println(
                "Sync complete. Wrote " + users.length + " users."
            );
        } catch (IOException e) {
            System.err.println("Error: Could not sync data to database file.");
            e.printStackTrace();
        }
    }

    public void printInfo() {
        System.out.println("--- Database Info ---");
        System.out.println("File Name: " + this.databaseFile.getName());
        System.out.println("Full Path: " + this.databaseFile.getAbsolutePath());
        System.out.println("Size: " + this.databaseFile.length() + " bytes");
        System.out.println(
            "Last Modified: " + new Date(this.databaseFile.lastModified())
        );
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        System.out.println("--- Testing Database Class ---");

        Database testDb = new Database("test_db");

        User[] testUsers = {
            new User(
                "Test Admin",
                "t101",
                "1111",
                "pass1",
                100.0,
                200.0,
                User.Role.ADMIN
            ),
            new User(
                "Test User",
                "t102",
                "2222",
                "pass2",
                0.0,
                500.0,
                User.Role.USER
            ),
        };

        System.out.println("\nSyncing data...");
        testDb.sync(testUsers);

        testDb.printInfo();

        System.out.println("\nTesting read_db method...");
        User[] usersFromDb = testDb.read_db();

        System.out.println(
            "Read " + usersFromDb.length + " users from the database:"
        );
        for (User u : usersFromDb) {
            u.showStatus();
        }

        System.out.println("------------------------------");
    }
}
