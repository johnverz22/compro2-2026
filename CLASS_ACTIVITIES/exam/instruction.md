**Instruction**: Create a Java program that performs the 

**Scenario**: You are developing a simple program to manage student attendance records. Each student has a name and several attendance marks (e.g., 1 for present, 0 for absent). The system should store this data, calculate attendance percentages, and save/load records from a file.

**Task Requirements:**

1. **Data Structure (Student Class):**  
   1. Create a Student class with pure properties: name (String) and attendanceMarks (an ArrayList of Integer).  
   2. Note: All operations on student data (adding attendance, calculating percentage, displaying info) should be handled by static helper methods in the main application logic, not directly within the Student class.  
2. **Main Application Logic:**  
   1. In a public static void main(String\[\] args) method (within a class named AttendanceApp, for example), manage an ArrayList\<Student\>.  
   2. Implement the following helper methods (must be static within AttendanceApp or another utility class):  
      1. addStudent(ArrayList\<Student\> students, String name): Creates a new Student and adds it to the list.  
      2. recordAttendance(ArrayList\<Student\> students, String studentName, int mark): Finds a student by name and directly manipulates the student's attendanceMarks. Handle cases where the student is not found using a custom exception or by returning a boolean/null.  
      3. getAttendancePercentage(Student student): Calculates and returns the percentage of present marks for a given student.  
      4. getDisplayInfo(Student student): Returns a user-friendly string representation of the student (e.g., "Name: John Doe, Attendance: 80%").  
      5. displayAllStudents(ArrayList\<Student\> students): Prints the display info of all students using the getDisplayInfo helper method.  
3. **File I/O (Persistence):**  
   1. Implement a static method saveStudents(ArrayList\<Student\> students, String filename) that writes all student data to a text file. Each line in the file should represent a student, and should be parsable (e.g., "John Doe,1,1,0,1"). Use BufferedWriter for efficient writing. Handle IOException.  
   2. Implement a static method loadStudents(String filename) that reads student data from the file and returns an ArrayList\<Student\>. Use BufferedReader for efficient reading. Handle FileNotFoundException and IOException, and use String methods like split() to parse each line. Also, handle NumberFormatException if attendance marks are not valid integers.  
4. **Demonstration in main:**  
   1. In the main method, demonstrate the functionality:  
      1. Initialize an ArrayList\<Student\>.  
      2. Add a few sample students using addStudent.  
      3. Record some attendance marks using recordAttendance, demonstrating both success and handling of a non-existent student (using a try-catch block if an exception is thrown, or checking return values).  
      4. Save the student records to a file (e.g., "attendance.txt") using saveStudents.  
      5. Load the records from the file using loadStudents and populate a new ArrayList\<Student\>.  
      6. Display all students after loading to confirm data persistence using displayAllStudents.  
      7. Demonstrate error handling for a non-existent file during loading.

**Grading Rubric:** 

| Criteria | Max Points | Description |
| :---- | :---: | :---- |
| Properties (name, attendanceMarks) | 3 | Correct type and direct field access |
| saveStudents(ArrayList\<Student\>, String) | 4 | Correctly writes data to file; uses BufferedWriter; handles IOException. |
| loadStudents(String) | 5 | Correctly reads and parses data; uses BufferedReader; handles FileNotFoundException, IOException, NumberFormatException. |
| ArrayList\<Student\> management | 2 | Correctly uses and manages ArrayList of students in main. |
| addStudent helper method | 2 | Correctly creates and adds students to the list. |
| recordAttendance helper method | 3 | Correct student lookup; accurate mark addition; handles student not found. |
| getAttendancePercentage(Student student) | 3 | Calculates and returns the percentage of present marks for a given student. |
| getDisplayInfo(Student student) | 2 | Returns a user-friendly string representation of the student. |
| displayAllStudents helper method | 2 | Prints the display info of all students using the getDisplayInfo helper method. |
| Error handling demonstration | 4 | Shows try-catch for file not found and student not found. |
| **Total** | **30** |  |