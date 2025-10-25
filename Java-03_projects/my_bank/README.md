-----

# Simple Java Banking System

A basic, command-line (CLI) banking application written in Java. It allows for user management and simple transactions, saving all data to a local `.txt` file.

## Features

  * **User Management:** Add new users (Admin or User) and remove existing users.
  * **Transactions:** Deposit money into and withdraw money from any user's account.
  * **Persistence:** All user data is saved to `banking_db.txt` when the application exits and reloaded on start.
  * **Simple Authentication:** Users have associated IDs, PINs, and passwords (though they are not fully used in the current CLI).
  * **Roles:** Differentiates between `ADMIN` and `USER` roles.

## How to Run

This project does not use any external dependencies. You can compile and run it directly from the `src` folder.

1.  **Compile all `.java` files:**

    ```bash
    javac src/*.java
    ```

2.  **Run the `Main` class:**

    ```bash
    java -cp src Main
    ```

    *(Note: `-cp src` tells Java to look for the compiled `.class` files in the `src` directory)*

## Core Classes

  * `Main.java`: The entry point of the application. Its only job is to create the `Bank`, `Database`, and `BankingCLI` objects and start the program.
  * `BankingCLI.java`: Handles all user interaction. It prints the menu, takes user input, and calls the appropriate methods in `Bank` or `Database`.
  * `Bank.java`: Manages the application's in-memory state. It holds the `ArrayList` of `User` objects and contains the business logic for adding, removing, and finding users.
  * `Database.java`: Manages persistence. It handles reading from and writing to the `banking_db.txt` file using CSV-formatted strings.
  * `User.java`: The data model. It represents a single user, holding their ID, name, balance, loan amount, role, and credentials. It also includes the `deposit` and `withdraw` methods.
