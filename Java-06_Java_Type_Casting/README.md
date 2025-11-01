Java Type Casting

Type casting means converting one data type into another. For example, turning an int into a double.

In Java, there are two main types of casting:

    Widening Casting (automatic) - converting a smaller type to a larger type size
    byte -> short -> char -> int -> long -> float -> double

    Narrowing Casting (manual) - converting a larger type to a smaller type size
    double -> float -> long -> int -> char -> short -> byte



# Widening Casting
```java
public class Main {
  public static void main(String[] args) {
    int myInt = 9;
    double myDouble = myInt; // Automatic casting: int to double

    System.out.println(myInt);
    System.out.println(myDouble);
  }
}
```

# Narrowing Casting
```java
public class Main {
  public static void main(String[] args) {
    double myDouble = 9.78d;
    int myInt = (int) myDouble; // Explicit casting: double to int

    System.out.println(myDouble);
    System.out.println(myInt);
  }
}
```
# example
``` java
public class Main {
  public static void main(String[] args) {
    // Set the maximum possible score in the game to 500
    int maxScore = 500;

    // The actual score of the user
    int userScore = 423;

    /* Calculate the percantage of the user's score in relation to the maximum available score.
    Convert userScore to double to make sure that the division is accurate */
    double percentage = (double) userScore / maxScore * 100.0d;

    // Print the result
    System.out.println("User's percentage is " + percentage);
  }
}

```
