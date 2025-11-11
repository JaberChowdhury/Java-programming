---

## **Java Notes**

### **1. Definition of Array**

An **array** in Java is a data structure that stores multiple values of the same type in a single variable.
Example:

```java
int[] numbers = {1, 2, 3, 4, 5};
```

---

### **2. Necessity of Using Arrays in Java**

Arrays are necessary because they:

- Allow storing multiple elements of the same type.
- Provide easy access to elements using indices.
- Reduce code redundancy.
- Improve data management efficiency.

---

### **3. Limitations of Using Arrays**

- Fixed size (cannot be changed after creation).
- Can only store elements of the same data type.
- Insertion and deletion operations are time-consuming.
- No built-in methods for dynamic resizing (unlike ArrayList).

---

### **4. Benefits of Using Arrays**

- Easy to access elements using index.
- Efficient memory utilization.
- Useful for data sorting and searching operations.
- Faster access to elements.

---

### **5. String Definition**

A **String** in Java is a sequence of characters enclosed in double quotes.
Example:

```java
String name = "Java";
```

---

### **6. Substring Definition**

A **substring** is a part or portion of a string. It can be extracted using the `substring()` method.
Example:

```java
String text = "Programming";
String sub = text.substring(0, 6); // Output: "Progra"
```

---

### **7. Functions of String**

Common String methods:

- `length()` – Returns length of the string.
- `charAt()` – Returns character at a specific index.
- `toUpperCase()` / `toLowerCase()` – Converts string case.
- `concat()` – Joins two strings.
- `equals()` – Compares two strings.

---

### **8. String vs Character**

| **String**                     | **Character**                  |
| ------------------------------ | ------------------------------ |
| Sequence of characters         | Single character               |
| Enclosed in double quotes ("") | Enclosed in single quotes ('') |
| Example: `"Java"`              | Example: `'J'`                 |

---

### **9. Method / Function Definition**

A **method** (or function) is a block of code designed to perform a specific task.
Example:

```java
void display() {
    System.out.println("Hello World");
}
```

---

### **10. Why We Use Functions / Methods**

- To avoid code repetition.
- To improve code readability and reusability.
- To divide a large program into smaller manageable parts.

---

### **11. Recursion Code**

**Recursion** is a process in which a method calls itself to solve a smaller instance of the same problem.

#### Examples:

**(a) Factorial using recursion**

```java
int factorial(int n) {
    if(n == 0)
        return 1;
    else
        return n * factorial(n - 1);
}
```

**(b) Series Sum using recursion**

```java
int seriesSum(int n) {
    if(n == 0)
        return 0;
    else
        return n + seriesSum(n - 1);
}
```

**(c) Even Series Sum using recursion**

```java
int evenSeriesSum(int n) {
    if(n == 0)
        return 0;
    else
        return (2 * n) + evenSeriesSum(n - 1);
}
```

---
