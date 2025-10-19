package bank;

import java.io.File;
import java.io.IOException;

public class Database {

    private File mydatabase;

    public Database(String filename) {
        this.mydatabase = new File(filename);
        if (!mydatabase.exists()) {
            System.out.println(
                "Database file not found. Attempting to create it..."
            );
            try {
                if (mydatabase.createNewFile()) {
                    System.out.println(
                        "✅ File created successfully: " + mydatabase.getName()
                    );
                } else {
                    System.out.println(
                        "⚠️ Could not create file, but it seems to exist now."
                    );
                }
            } catch (IOException e) {
                System.out.println(
                    "❌ An error occurred while creating the file."
                );
                e.printStackTrace();
            }
        } else {
            System.out.println("Database file already exists.");
        }
    }

    public File getFile() {
        return mydatabase;
    }

    public boolean isReadable() {
        return mydatabase.canRead();
    }
}

// need implementation
