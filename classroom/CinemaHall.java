public class CinemaHall {

    public int count = 500;

    public boolean sellOne() {
        if (count > 0) {
            count--;
            return true;
        } else {
            return false;
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        CinemaHall c = new CinemaHall();
        if (c.sellOne()) {
            System.out.println("One ticket is soled");
        } else {
            System.out.println("We are running out of ticket");
        }

        System.out.println("Currently ticket left => " + c.getCount());
    }
}
