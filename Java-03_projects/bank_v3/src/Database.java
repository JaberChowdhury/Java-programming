import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Database {


    private File databaseFile;

    Database(String filename) {
        this.databaseFile = new File(filename + ".txt");
        try {
            if (this.databaseFile.createNewFile()) {
                System.out.println("Database file created: " + this.databaseFile.getName());
            } else {
                System.out.println("Using existing database file: " + this.databaseFile.getName());
            }
            // handling error
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
}
