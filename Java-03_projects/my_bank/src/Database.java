import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Date;

public class Database {

    private File databaseFile;

    public Database(String fileName) {
        this.databaseFile = new File(fileName + ".txt");
        try {
            if (this.databaseFile.createNewFile()) {
                System.out.println("Database file created: " + this.databaseFile.getName());
            } else {
                System.out.println("Using existing database file: " + this.databaseFile.getName());
            }
        } catch (IOException e) {
            System.err.println("Error: Could not create or access database file.");
            e.printStackTrace();
        }
    }

    public void sync(User[] users) {
        try (FileWriter fw = new FileWriter(this.databaseFile, false);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println("name,id,pin,password,loan,amount,role");

            for (User user : users) {
                pw.println(user.toCsvString());
            }

            System.out.println("Sync complete. Wrote " + users.length + " users.");

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
        System.out.println("Last Modified: " + new Date(this.databaseFile.lastModified()));
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        System.out.println("--- Testing Database Class ---");

        Database testDb = new Database("test_db");

        User[] testUsers = {
                new User("Test Admin", "t101", "1111", "pass1", 100.0, 200.0, User.Role.ADMIN),
                new User("Test User", "t102", "2222", "pass2", 0.0, 500.0, User.Role.USER)
        };

        System.out.println("\nSyncing data...");
        testDb.sync(testUsers);

        testDb.printInfo();

        System.out.println("\nTest complete. Check for 'test_db.txt'. It should have 7 columns.");
        System.out.println("------------------------------");
    }
}