public class Main {

    public static void main(String[] args) {
        Database db = new Database("banking_db");
        Bank bank = new Bank();

        BankingCLI cli = new BankingCLI(bank, db);

        cli.start();
    }
}
