# Progressive Activity: From 1D to 2D Arrays

## Objective
This activity will guide you from using a one-dimensional array for a simple task to understanding why a two-dimensional array is necessary for a more complex version of the same task. You will write and adapt code to manage a movie theater seating chart.

---

### Part 1: Managing a Single Row (1D Array)

Imagine you are managing the seating for a single row in a small theater. This row has 8 seats. We can represent this row using a 1D array. Let's use `0` for an available seat and `1` for a booked seat.

**Task:**
1.  Declare and initialize a 1D integer array named `theaterRow` with a size of 8. By default, all seats are available (`0`).
2.  Write code to book the seat at index `3`.
3.  Write a loop to print the status of all seats in the row.
4.  After the loop, calculate and print how many seats are still available.

**Starter Code:**
```java
public class TheaterSeating {
    public static void main(String[] args) {
        // 1. Declare and initialize the 1D array for a single row
        int[] theaterRow = new int[8];

        // 2. Book the seat at index 3 (the 4th seat)
        // TODO: Your code here

        System.out.println("Seat Status (0=Available, 1=Booked):");
        // 3. Loop through the array and print each seat's status
        // TODO: Your code here

        // 4. Count and print the number of available seats
        // TODO: Your code here
    }
}
```

---

### Part 2: The Problem with Multiple Rows

The single-row system works, but now you need to manage a whole theater with 5 rows, where each row has 8 seats.

**Question:** How would you do this using only 1D arrays?

You could create five separate 1D arrays:
```java
int[] row1 = new int[8];
int[] row2 = new int[8];
int[] row3 = new int[8];
int[] row4 = new int[8];
int[] row5 = new int[8];
```
Booking a seat at `row 3, seat 5` would require `row3[4] = 1;`. This is becoming clumsy. What if the theater had 30 rows? You can see how this approach doesn't scale well. This is the exact problem that 2D arrays solve.

---

### Part 3: Managing the Whole Theater (2D Array)

A 2D array is an "array of arrays." It's perfect for representing a grid, like our theater. We can declare a 2D array `int[][] theater` where the first index is the **row** and the second index is the **column** (seat number).

**Task:**
Refactor the program to use a single 2D array for the entire theater.

1.  Declare and initialize a 2D integer array named `theater` with 5 rows and 8 columns.
2.  Write code to book the seat at `row 2, column 5`.
3.  Write code to book the seat at `row 0, column 0`.
4.  Use **nested loops** to print the entire seating chart in a grid format.
5.  After printing, calculate and display the total number of booked seats in the whole theater.

**Starter Code:**
```java
public class TheaterSeating2D {
    public static void main(String[] args) {
        // 1. Declare and initialize the 2D array for the theater
        int[][] theater = new int[5][8]; // 5 rows, 8 columns

        // 2. Book the seat at row 2, column 5
        // TODO: Your code here

        // 3. Book the seat at row 0, column 0
        // TODO: Your code here

        System.out.println("Theater Seating Chart (0=Available, 1=Booked):");
        // 4. Use nested loops to print the seating chart
        // The outer loop should iterate through rows
        // The inner loop should iterate through columns
        // TODO: Your code here

        // 5. Count and print the total number of booked seats
        // TODO: Your code here
    }
}
```
---
# Rubric for Progressive Activity: From 1D to 2D Arrays

**Total Points: 20**

---

### Part 1: Managing a Single Row (1D Array) - 8 Points

| Criteria                                                  | Points |
| --------------------------------------------------------- | :----: |
| **1. Array Declaration**                                  |   2    |
| - Correctly declares and initializes a 1D integer array `theaterRow` of size 8. |        |
| **2. Booking a Seat**                                     |   1    |
| - Correctly assigns `1` to the seat at index `3`.        |        |
| **3. Printing Seat Status**                               |   2    |
| - Implements a loop that iterates through the entire array. |        |
| - Prints the status of each seat.                         |        |
| **4. Counting Available Seats**                           |   3    |
| - Correctly initializes a counter.                        |        |
| - Loops through the array and increments the counter for available seats (`0`). |        |
| - Prints the final correct count of available seats.      |        |

---

### Part 3: Managing the Whole Theater (2D Array) - 12 Points

| Criteria                                                  | Points |
| --------------------------------------------------------- | :----: |
| **1. Array Declaration**                                  |   2    |
| - Correctly declares and initializes a 2D integer array `theater` with 5 rows and 8 columns. |        |
| **2. Booking Seats**                                      |   2    |
| - Correctly books the seat at `row 2, column 5`.          |        |
| - Correctly books the seat at `row 0, column 0`.          |        |
| **3. Printing the Seating Chart**                         |   4    |
| - Implements a correct outer loop for rows.               |        |
| - Implements a correct inner loop for columns.            |        |
| - Prints the seat status in a grid format with appropriate newlines. |        |
| **4. Counting Booked Seats**                              |   4    |
| - Correctly initializes a counter.                        |        |
| - Uses nested loops to iterate through the entire 2D array. |        |
| - Correctly identifies and counts booked seats (`1`).     |        |
| - Prints the final correct total of booked seats.         |        |
