# Activity: 2D Array Methods

## Instructions

Complete the two programming problems below. You should implement the required methods and write a test program for each. Combine both solutions into a single Java file for submission.

---

### Problem 1: Sum Elements by Column

Write a method that returns the sum of all the elements in a specified column in a matrix. Use the following method header:

```java
public static double sumColumn(double[][] m, int columnIndex)
```

Write a test code in `main` method that does the following:
1.  Prompts the user to enter a 3-by-4 matrix row by row.
2.  Reads the matrix.
3.  Displays the sum of each column by calling the `sumColumn` method.

#### Sample Run

```text
Enter a 3-by-4 matrix row by row:
1.5 2 3 4
5.5 6 7 8
9.5 1 3 1
Sum of the elements at column 0 is 16.5
Sum of the elements at column 1 is 9.0
Sum of the elements at column 2 is 13.0
Sum of the elements at column 3 is 13.0
```

---

### Problem 2: Sum the Major Diagonal

Write a method that sums all the numbers in the major diagonal of an *n* x *n* matrix. The major diagonal is the one that runs from the top-left corner to the bottom-right corner. Use the following method header:

```java
public static double sumMajorDiagonal(double[][] m)
```

Write a test code in `main` method that does the following:
1.  Prompts the user to enter a 4-by-4 matrix row by row.
2.  Reads the matrix.
3.  Displays the sum of the elements in the major diagonal by calling the `sumMajorDiagonal` method.

#### Sample Run

```text
Enter a 4-by-4 matrix row by row:
1 2 3 4.0
5 6.5 7 8
9 10 11 12
13 14 15 16
Sum of the elements in the major diagonal is 34.5
```

---

# Rubric for 2D Array Methods Activity

**Total Points: 20**

---

### Problem 1: Sum Elements by Column (10 Points)

| Criteria | Points |
| :--- | :---: |
| **`sumColumn` Method (6 points)** | |
| Correct method header (signature). | 1 |
| Initializes sum variable correctly. | 1 |
| Loops correctly through the rows for the given `columnIndex`. | 3 |
| Returns the correct `double` sum. | 1 |
| **Test Program (4 points)** | |
| Creates a 3x4 matrix and correctly reads user input. | 2 |
| Calls `sumColumn` for all four columns. | 1 |
| Prints the output for each column in the specified format. | 1 |

---

### Problem 2: Sum the Major Diagonal (10 Points)

| Criteria | Points |
| :--- | :---: |
| **`sumMajorDiagonal` Method (6 points)** | |
| Correct method header (signature). | 1 |
| Initializes sum variable correctly. | 1 |
| Loops correctly along the major diagonal (where row index equals column index). | 3 |
| Returns the correct `double` sum. | 1 |
| **Test Program (4 points)** | |
| Creates a 4x4 matrix and correctly reads user input. | 2 |
| Calls `sumMajorDiagonal` to get the result. | 1 |
| Prints the final sum in the specified format. | 1 |
