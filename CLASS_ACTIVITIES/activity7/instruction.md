## Activity: Phonebook Management System (Maven & CSV)

### Objective

Develop a Java application using **Maven** to manage a Phonebook. You will use a `HashMap` for data storage and implement **File I/O** to both save and load your contacts using a `.csv` file.

### What is a Service Layer?

The `PhonebookService` acts as the "logic hub" of your application. Instead of writing all your code in the entry-point class, the Service handles the technical details of managing the `HashMap` and interacting with the file system.

* **The Main/App Class**: Handles user interaction (menus, scanning input).
* **The Service Class**: Handles data processing (adding to the map, formatting CSV lines, reading/writing files).

---

### Technical Specifications

1. **Project Structure (Maven)**:
Your project must follow the standard `src/main/java` directory layout.
* `com.phonebook`: Entry-point class (e.g., `Main` or `App`).
* `com.phonebook.models`: The `Contact` data class.
* `com.phonebook.services`: The `PhonebookService` (Logic & File I/O).


2. **Data Models (`com.phonebook.models`)**:
* **`Contact` Class**: Private fields for `name`, `phoneNumber`, and `email`.
* Include a constructor, getters, and setters.
* **Method**: `toCsvString()` – returns a String formatted for a CSV (e.g., `Jane Doe,555-0101,jane@example.com`).


3. **The Service Layer (`com.phonebook.services`)**:
* **`PhonebookService` Class**:
* Contains a `private HashMap<String, Contact> contacts`. Use the contact's **name** as the key.
* Methods: `addContact(Contact c)`, `searchContact(String name)`, and `removeContact(String name)`.
* **`saveToCSV(String filename)`**: Iterates through the map and writes contacts to a file.
* **`loadFromCSV(String filename)`**: Reads the CSV file line-by-line, splits the strings, creates `Contact` objects, and populates the `HashMap`. Use **try-with-resources** for all File I/O.




4. **The Entry Point (`com.phonebook`)**:
* Use the class containing the `public static void main` method.
* Instantiate `PhonebookService` and **immediately call the load method** so existing contacts are available.
* Implement a `Scanner`-based menu:
1. Add | 2. Search | 3. Remove | 4. Display All | 5. Save to CSV | 0. Exit





---

### Instructions for Students

1. **Maven Setup**: Ensure your source code follows the package paths exactly.
2. **Implementation Order**:
* Create the `Contact` model.
* Build the `PhonebookService`. For `loadFromCSV`, use `String.split(",")` to break each line into the fields needed for the `Contact` constructor.
* Update your `Main`/`App` class to handle the menu.


3. **Persistence**: The program should be able to close and reopen without losing data. This is achieved by calling `loadFromCSV` at the start and `saveToCSV` via the menu or before exiting.
4. **Submission Requirements**:
* Create a folder named **`activity7`**.
* Place **only** your source code (`.java` files) and your generated **`contacts.csv`** into this folder.
* Do **not** submit the entire Maven project or the `target` folder.



---

### Grading Rubric (Total: 20 Points)

| Criteria | Max Score | Mastery (Full) | Proficient (Partial) | Novice (Minimal) |
| --- | --- | --- | --- | --- |
| **Project Structure** | 4 | Maven layout followed; Main is in root with `models` and `services` sub-packages. | Packages are present but logic is leaked (e.g., `Scanner` used in Service). | No packages used. |
| **HashMap Logic** | 5 | Correct use of `HashMap<String, Contact>` using name as key. | `HashMap` used but relies on loops to find specific contacts. | `HashMap` is missing. |
| **CSV Save & Load** | 5 | Successfully writes TO and reads FROM a `.csv` file using `try-with-resources`. | Can save but not load (or vice-versa), or formatting is broken. | No file I/O implemented. |
| **Service Layer Design** | 3 | Service class independently manages all data logic; Main only handles UI. | Service exists but contains print statements or user input logic. | No Service layer used. |
| **Submission & UX** | 3 | **`activity7`** folder contains correct files. Menu handles "Contact Not Found" gracefully. | Missing CSV file or incorrect folder naming. | Logic is non-functional. |
| **Total Score** | **20** |  |  | **/ 20** |