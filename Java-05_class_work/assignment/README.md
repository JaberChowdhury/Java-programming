
---

# 🧮 Java Programming Assignment

#### **Course:**  Java Programming
#### **Topic:** Array Operations in Java
#### **Submitted by:** *MD JABER HOSSAIN CHOWDHURY*
#### **ID No:** *202431070002*
#### **Date:** *4 NOVEMBER 2025*
#### **Instructor:** *PABON SHAHA*

---

---

# 1. Write a program in Java to copy the elements of one array into another array.

```java
// task 01
public class One {

    public static void main(String[] args) {
        int data[] = {218, 31, 43, 654, 576, 7896, 24};
        int new_array[] = data.clone();

        for (int d : new_array) {
            System.out.print(d + " ");
        }
    }
}
```

**Output:**
``` bash
218 31 43 654 576 7896 24
```
---

# 2. Write a program in Java to find the maximum and minimum elements in an array.

```java
// task two
import java.util.Scanner;

public class Two {
    public static void main(String[] arge) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        int max = scan.nextInt();
        int min = max;


        for (int i = 1; i < n; i++) {
            arr[i] = scan.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }

            if (min > arr[i]) {
                min = arr[i];
            }
        }


        System.out.println("Maximum number is " + max);
        System.out.println("Minimum number is " + min);

        scan.close();
    }
}
```

**Output:**
``` bash
4
12 23 34 45
Maximum number is 45
Minimum number is 12
```

---

# 3. Write a program in Java to find the second largest element in an array.

```java
// task 3

import java.util.Scanner;

public class Three {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n, largest, second_largest;


        n = scan.nextInt();
        int[] arr = new int[n];

        arr[0] = scan.nextInt();
        arr[1] = scan.nextInt();


        if(arr[0] > arr[1]){
            largest = arr[0];
            second_largest = arr[1];
        }else {
            largest = arr[1];
            second_largest = arr[0];
        }



        for (int i = 2; i < n; i++) {
            arr[i] = scan.nextInt();

            if (largest < arr[i]) {
                second_largest = largest;
                largest = arr[i];
            }
        }


        System.out.println("Second largest element is " + second_largest);
        scan.close();
    }
}
```

**Output:**
``` bash
4
12 23 34 45
Second largest element is 34
```

---

# 4. Write a program in Java to find the second smallest element in an array.

```java
// task 4

import java.util.Scanner;

public class Four {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n, smallest, second_smallest;


        n = scan.nextInt();
        int[] arr = new int[n];

        arr[0] = scan.nextInt();
        arr[1] = scan.nextInt();


        if (arr[0] < arr[1]) {
            smallest = arr[0];
            second_smallest = arr[1];
        } else {
            smallest = arr[1];
            second_smallest = arr[0];
        }


        for (int i = 2; i < n; i++) {
            arr[i] = scan.nextInt();

            if (smallest > arr[i]) {
                second_smallest = smallest;
                smallest = arr[i];
            }
        }


        System.out.println("Second smallest element is " + second_smallest);
        scan.close();
    }
}
```

**Output:**
``` bash
4
43 32 21 76
Second smallest element is 32
```

---

# 5. Write a program in Java to sort elements of an array in ascending order.

```java
import java.util.Arrays;
import java.util.Scanner;

public class Five {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        scan.close();
    }
}
```

**Output:**
``` bash
4
45 32 76 33
[32, 33, 45, 76]
```

---

# 6. Write a program in Java for a 2D array of size 3x3 and print the matrix.

```java
import java.util.Scanner;

public class Six {
    public static void print_matrix(int[][] arr) {
        int row = arr.length, column = arr[0].length;
        System.out.println("{");
        for (int[] ints : arr) {
            System.out.print("  {");
            for (int j = 0; j < column; j++) {
                System.out.print(ints[j]);
                if (j < column - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("},");
            System.out.println();
        }
        System.out.println("}");
    }


    public static int[][] take_matrix(Scanner scan) {
        System.out.print("Enter row and column size (e.g. 4 6): ");
        int r = scan.nextInt(), c = scan.nextInt();
        int[][] arr = new int[r][c];
        System.out.println("Now enter the matrix:");

        for (int i = 0; i < r; i++) {
            System.out.print("Enter the arr[" + i + "]th row: ");
            for (int j = 0; j < c; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = take_matrix(scan);
        print_matrix(matrix);
        scan.close();
    }
}
```

**Output:**
``` java
Enter row and column size (e.g. 4 6): 3 3
Now enter the matrix:
Enter the arr[0]th row: 12 23 34
Enter the arr[1]th row: 12 34 45
Enter the arr[2]th row: 65 43 32
{
  {12, 23, 34},
  {12, 34, 45},
  {65, 43, 32},
}
```

---

# 7. Write a program in Java for adding two matrices of the same size.

```java
// matrix addition

import java.util.Scanner;

public class Seven {
    public static void print_matrix(int[][] arr) {
        int row = arr.length, column = arr[0].length;
        System.out.println("{");
        for (int[] ints : arr) {
            System.out.print("  {");
            for (int j = 0; j < column; j++) {
                System.out.print(ints[j]);
                if (j < column - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("},");
            System.out.println();
        }
        System.out.println("}");
    }

    public static int[][] take_matrix(Scanner scan) {
        System.out.print("Enter row and column size (e.g. 4 6): ");
        int r = scan.nextInt(), c = scan.nextInt();
        int[][] arr = new int[r][c];
        System.out.println("Now enter the matrix:");

        for (int i = 0; i < r; i++) {
            System.out.print("Enter the arr[" + i + "]th row: ");
            for (int j = 0; j < c; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        return arr;
    }

    public static boolean isEqualMatrix(int[][] matrixA, int[][] matrixB) {
        if (matrixA == null || matrixB == null) {
            return false;
        }

        if (matrixA.length != matrixB.length) {
            return false;
        }

        for (int i = 0; i < matrixA.length; i++) {
            if (matrixA[i].length != matrixB[i].length) {
                return false;
            }
        }

        return true;
    }

    public static int[][] add_two_matrix(int[][] a, int[][] b) {
        int row = a.length;
        int[][] result = new int[row][row];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }

        }


        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Now enter 1st matrix:");
        int[][] matrixA = take_matrix(scan);
        System.out.println("Now enter 2nd matrix:");
        int[][] matrixB = take_matrix(scan);


        if (isEqualMatrix(matrixA, matrixB)) {
            int[][] result = add_two_matrix(matrixA, matrixB);
            System.out.println("Result of the matrix addition");
            print_matrix(result);
        }

        scan.close();
    }
}
```

**Output:**
``` bash
Now enter 1st matrix:
Enter row and column size (e.g. 4 6): 2 2
Now enter the matrix:
Enter the arr[0]th row: 12 23
Enter the arr[1]th row: 21 32
Now enter 2nd matrix:
Enter row and column size (e.g. 4 6): 2 2
Now enter the matrix:
Enter the arr[0]th row: 12 34
Enter the arr[1]th row: 43 32
Result of the matrix addition
{
  {24, 57},
  {64, 64},
}
```

---

# 8. Write a program in Java for the subtraction of two matrices.

```java
import java.util.Scanner;

public class Eight {
    public static void print_matrix(int[][] arr) {
        int row = arr.length, column = arr[0].length;
        System.out.println("{");
        for (int[] ints : arr) {
            System.out.print("  {");
            for (int j = 0; j < column; j++) {
                System.out.print(ints[j]);
                if (j < column - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("},");
            System.out.println();
        }
        System.out.println("}");
    }

    public static int[][] take_matrix(Scanner scan) {
        System.out.print("Enter row and column size (e.g. 4 6): ");
        int r = scan.nextInt(), c = scan.nextInt();
        int[][] arr = new int[r][c];
        System.out.println("Now enter the matrix:");

        for (int i = 0; i < r; i++) {
            System.out.print("Enter the arr[" + i + "]th row: ");
            for (int j = 0; j < c; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        return arr;
    }

    public static boolean isEqualMatrix(int[][] matrixA, int[][] matrixB) {
        if (matrixA == null || matrixB == null) {
            return false;
        }

        if (matrixA.length != matrixB.length) {
            return false;
        }

        for (int i = 0; i < matrixA.length; i++) {
            if (matrixA[i].length != matrixB[i].length) {
                return false;
            }
        }

        return true;
    }

    public static int[][] subtract_two_matrix(int[][] a, int[][] b) {
        int row = a.length;
        int[][] result = new int[row][row];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }

        }


        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Now enter 1st matrix:");
        int[][] matrixA = take_matrix(scan);
        System.out.println("Now enter 2nd matrix:");
        int[][] matrixB = take_matrix(scan);


        if (isEqualMatrix(matrixA, matrixB)) {
            int[][] result = subtract_two_matrix(matrixA, matrixB);
            System.out.println("Result of the matrix subtraction");
            print_matrix(result);
        }

        scan.close();
    }
}
```

**Output:**
``` bash
Now enter 1st matrix:
Enter row and column size (e.g. 4 6): 2 2
Now enter the matrix:
Enter the arr[0]th row: 76 54
Enter the arr[1]th row: 23 45
Now enter 2nd matrix:
Enter row and column size (e.g. 4 6): 2 2
Now enter the matrix:
Enter the arr[0]th row: 87 45
Enter the arr[1]th row: 23 45
Result of the matrix subtraction
{
  {-11, 9},
  {0, 0},
}
```

---

# 9. Write a program in Java for the multiplication of two square matrices.

```java
import java.util.Scanner;

public class Nine {

    public static void print_matrix(int[][] arr) {
        int row = arr.length, column = arr[0].length;
        System.out.println("{");
        for (int[] ints : arr) {
            System.out.print("  {");
            for (int j = 0; j < column; j++) {
                System.out.print(ints[j]);
                if (j < column - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("},");
            System.out.println();
        }
        System.out.println("}");
    }

    public static int[][] take_matrix(Scanner scan) {
        System.out.print("Enter row and column size (e.g. 4 6): ");
        int r = scan.nextInt(), c = scan.nextInt();
        int[][] arr = new int[r][c];
        System.out.println("Now enter the matrix:");

        for (int i = 0; i < r; i++) {
            System.out.print("Enter the arr[" + i + "]th row: ");
            for (int j = 0; j < c; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        return arr;
    }


    public static int[][] multiply_two_matrix(int[][] a, int[][] b) {
        int aRows, aCols, bRows, bCols;
        aRows = a.length;
        aCols = a[0].length;
        bRows = b.length;
        bCols = b[0].length;

        if (aCols != bRows) {
            System.out.println("Error: Matrices cannot be multiplied. Columns of A must equal rows of B.");
            return null;
        }

        int[][] result = new int[aRows][bCols];

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                result[i][j] = 0;
                for (int k = 0; k < aCols; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Now enter 1st matrix:");
        int[][] matrixA = take_matrix(scan);
        System.out.println("Now enter 2nd matrix:");
        int[][] matrixB = take_matrix(scan);

        int[][] result = multiply_two_matrix(matrixA, matrixB);
        print_matrix(result);
        scan.close();
    }
}
```

**Output:**
``` bash
Now enter 1st matrix:
Enter row and column size (e.g. 4 6): 2 2
Now enter the matrix:
Enter the arr[0]th row: 21 23
Enter the arr[1]th row: 32 21
Now enter 2nd matrix:
Enter row and column size (e.g. 4 6): 2 2
Now enter the matrix:
Enter the arr[0]th row: 45 67
Enter the arr[1]th row: 21 34
{
  {1428, 2189},
  {1881, 2858},
}
```


---

# 10. Write a program in Java to find the transpose of a given matrix.

```java
import java.util.Scanner;

public class Ten {
    public static void print_matrix(int[][] arr) {
        int row = arr.length, column = arr[0].length;
        System.out.println("{");
        for (int[] ints : arr) {
            System.out.print("  {");
            for (int j = 0; j < column; j++) {
                System.out.print(ints[j]);
                if (j < column - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("},");
            System.out.println();
        }
        System.out.println("}");
    }

    public static int[][] take_matrix(Scanner scan) {
        System.out.print("Enter row and column size (e.g. 4 6): ");
        int r = scan.nextInt(), c = scan.nextInt();
        int[][] arr = new int[r][c];
        System.out.println("Now enter the matrix:");

        for (int i = 0; i < r; i++) {
            System.out.print("Enter the arr[" + i + "]th row: ");
            for (int j = 0; j < c; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        return arr;
    }

    public static int[][] transpose_matrix(int[][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = arr[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));

        int[][] A = take_matrix(scan);
        int[][] result = transpose_matrix(A);

        print_matrix(result);
        scan.close();
    }
}
```

**Output:**
``` bash
Enter row and column size (e.g. 4 6): 3 3
Now enter the matrix:
Enter the arr[0]th row: 98 76 65
Enter the arr[1]th row: 65 54 43
Enter the arr[2]th row: 43 32 21
{
  {98, 65, 43},
  {76, 54, 32},
  {65, 43, 21},
}
```

---

# 11. Write a program in Java to accept two matrices and check whether they are equal.

```java
import java.util.Scanner;

public class Eleven {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] a = take_matrix(scan);
        int[][] b = take_matrix(scan);
        if (isEqual(a, b)) {
            System.out.println("Matrices are equal.");
        } else {
            System.out.println("Matrices are not equal.");
        }
        scan.close();
    }

    public static void print_matrix(int[][] arr) {
        int row = arr.length, column = arr[0].length;
        System.out.println("{");
        for (int[] ints : arr) {
            System.out.print("  {");
            for (int j = 0; j < column; j++) {
                System.out.print(ints[j]);
                if (j < column - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("},");
            System.out.println();
        }
        System.out.println("}");
    }

    public static int[][] take_matrix(Scanner scan) {
        System.out.print("Enter row and column size (e.g. 4 6): ");
        int r = scan.nextInt(), c = scan.nextInt();
        int[][] arr = new int[r][c];
        System.out.println("Now enter the matrix:");
        for (int i = 0; i < r; i++) {
            System.out.print("Enter the arr[" + i + "]th row: ");
            for (int j = 0; j < c; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        return arr;
    }

    public static boolean isEqual(int[][] a, int[][] b) {
        int arow = a.length, acol = a[0].length, brow = b.length, bcol = b[0].length;
        if (arow != brow || acol != bcol) return false;
        for (int i = 0; i < arow; i++) {
            for (int j = 0; j < acol; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

}
```

**Output:**
``` bash
Enter row and column size (e.g. 4 6): 2 2
Now enter the matrix:
Enter the arr[0]th row: 12 23
Enter the arr[1]th row: 21 21
Enter row and column size (e.g. 4 6): 2 2
Now enter the matrix:
Enter the arr[0]th row: 21 23
Enter the arr[1]th row: 43 32
Matrices are not equal.
```

---

# 12. Write a program in Java to add an element to an array in any position.

```java
import java.util.Scanner;

public class Twelve {

    public static int[] add_element(int element, int index, int[] a) {
        int col = a.length;
        int[] result = new int[col + 1];


        result[index] = element;

        for (int i = 0; i < index; i++) {
            result[i] = a[i];
        }

        for (int i = index + 1; i < col + 1; i++) {
            result[i] = a[i - 1];
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = 1, position, element;
        System.out.print("What is the size of the array ? ");
        n = scan.nextInt();

        int[] nums = new int[n];

        System.out.print("Enter n number with space saparated :: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        System.out.print("Enter enter element and the position to add (position must be <=n+1) :: ");

        element = scan.nextInt();
        position = scan.nextInt();


        if (position > n + 1 || position < 0) {
            System.out.print("Input is out of range");
        } else {
            int[] result = add_element(element, position, nums);

            for (int d : result) {
                System.out.print(d + " ");
            }
            System.out.println("");
        }
        scan.close();
    }
}
```

**Output:**
``` bash
What is the size of the array ? 4
Enter n number with space saparated :: 12 23 34 45
Enter enter element and the position to add (position must be <=n+1) :: 100 3
12 23 34 100 45
```

---

# 13. Write a program in Java to delete an element of an array.

```java
import java.util.Scanner;

public class Thirteen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, pos;

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the position of element to delete (1 to " + n + "): ");
        pos = sc.nextInt();

        if (pos <= 0 || pos > n) {
            System.out.println("Invalid position!");
        } else {
            for (int i = pos - 1; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            n--; // reduce size
            System.out.println("Array after deletion:");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        sc.close();
    }
}
```

**Output:**
``` bash
Enter number of elements: 4
Enter elements:
12 23 34 45
Enter the position of element to delete (1 to 4): 3
Array after deletion:
12 23 45
```

---

# 14. Write a program in Java to find an element in a given array.

```java
import java.util.Scanner;

public class Fourteen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, search, flag = 0;

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        search = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (arr[i] == search) {
                System.out.println("Element found at position: " + (i + 1));
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
            System.out.println("Element not found!");
        }

        sc.close();
    }
}
```

**Output:**
``` bash
Enter number of elements: 7
Enter elements:
12 23 34 45 56 67 87
Enter element to search: 34
Element found at position: 3
```
---
