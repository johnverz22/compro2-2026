## Activity: Dynamic Student Subject Portfolio & CSV Exporter

### Objective

As an extension and improvement of Activity 4, develop a Java application named `App` or `Main` that allows a student to build a personal grade portfolio. The program will dynamically store grades for multiple subjects using **ArrayLists** and, upon exiting, save the entire academic record into a `.csv` file using buffered writing and exception handling.

---

### Technical Specifications

1. **Storage Structure (Single Student Focus)**:
* **ArrayList of Grade Objects**: An `ArrayList<Grade>` to store the entire grade portfolio. Each `Grade` object will encapsulate a subject's name and its `Prelim`, `Midterm`, and `Final` grades.


2. **The Interface**:
* **Main Menu**:
    1.  Add Grades
    2.  Display Grades
    3.  Search Grades
    0.  Exit

    * `Add Grades` - (Add a new subject and its term grades)
    * `Display Grades` - (Show all subjects and their grades)
    * `Search Grades` - (per subject - prompt for subject name, display if found)
    * `Exit` - (Save data and close)


* **Input Flow for Option 1 (Add Grades)**:
*   Prompt for **Subject Name**.
*   Prompt for **Prelim Grade**.
*   Prompt for **Midterm Grade**.
*   Prompt for **Final Grade**.
*   *Note: After saving one subject, return to the main menu.*


* **Input Flow for Option 2 (Display Grades)**:
*   Iterate through all stored subjects and their corresponding grades.
*   Display them in a readable format (e.g., "Subject: [Name], Prelim: [Grade], Midterm: [Grade], Final: [Grade]").
*   If no subjects are stored, display a message indicating that.


* **Input Flow for Option 3 (Search Grades)**:
*   Prompt for the **Subject Name** to search for.
*   If the subject is found, display its name and grades.
*   If the subject is not found, display an appropriate message.


3. **File Persistence (The "Exit" Hook)**:
* When the user selects **Exit**, the program must iterate through the stored subjects and write them to `grades.csv`.
* **Required Tools**: `FileWriter`, `BufferedWriter`, and `try-catch` blocks.
* **CSV Format**: `Subject,Prelim,Midterm,Final`



---

### Instructions for Students

This activity extends and revises `Activity 4`. The core logic remains similar, but with dynamic data structures and expanded functionality.

1.  **Class Setup**:
    *   Create a class named `App` or `Main`.
    *   Initialize your `ArrayLists` at the top of your `App`/`Main` class.
    *   **New**: Additionally, create a separate `Grade` class (or similar, e.g., `SubjectGrade`) to encapsulate the subject name and its three grades (Prelim, Midterm, Final). While implementing constructors, getters, and setters for this `Grade` class is optional for this activity, students are encouraged to consider their benefits for good object-oriented design.
2. **Input Handling**: Use a `Scanner` for user input. You may choose any loop (`while` or `do-while`) to keep the menu running.
3. **Data Management**: When adding new entries, create a new `Grade` object and add it to your `ArrayList<Grade>`. Ensure all data (subject name, Prelim, Midterm, Final grades) for a single subject is encapsulated within one `Grade` object.
4. **Exception Handling**: Wrap your file-writing logic in a `try-catch` block to handle `IOException`. Ensure you close the `BufferedWriter` in a `finally` block or use a `try-with-resources` statement.

---

### Grading Rubric (Total: 20 Points)

| Criteria | Max Score | Mastery (Full points) | Proficient (Partial points) | Novice (Minimal points) | Score |
| --- | --- | --- | --- | --- | --- |
| **ArrayList Implementation** | 4 | Correctly manages `ArrayList<ArrayList<Double>>` for grades and `ArrayList<String>` for subject names, with proper alignment. | `ArrayLists` are used, but indexes between names and grades are occasionally misaligned or not fully dynamic. | Incorrect dynamic data structures used, or significant misalignment. |  |
| **File I/O & Buffering** | 3 | Successfully uses `BufferedWriter` to create a clean, comma-separated `.csv` file. | File is created, but `BufferedWriter` is not used or formatting is poor. | No file is generated or writing logic is missing. |  |
| **Exception Handling** | 3 | `try-catch` is implemented correctly; resources (writer) are closed properly. | `try-catch` is present but lacks proper resource management (e.g., no `.close()`). | No exception handling; program crashes on file errors. |  |
| **Menu & User Logic Flow** | 4 | Menu-driven system is intuitive and fully functional (Add, Display, Search, Exit). Allows for multiple entries. | Program works but one or more menu options are partially functional or navigation is confusing. | Logic is broken; user cannot effectively navigate or perform required actions. |  |
| **Display Grades Functionality** | 3 | All stored subjects and their grades are accurately displayed in a clear, readable format. | Display functionality is present but may have minor formatting issues or edge case failures (e.g., empty list). | Display functionality is missing or severely flawed. |  |
| **Search Grades Functionality** | 3 | Accurately searches for and displays grades for a specified subject; handles not-found cases gracefully. | Search functionality is present but may have minor issues (e.g., case sensitivity, partial matches not handled). | Search functionality is missing or severely flawed. |  |
| **Total Score** | 20 | | | | **/ 20** |