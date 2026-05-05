# Activity 14: Weather Data Fetcher (Basic Fetching)

## Objective
The goal of this activity is to apply your knowledge of Java's `HttpClient` to fetch real-world data from a public API. You will practice building requests, handling responses, and validating status codes using the **7Timer! Weather API**.

## The API
We will use the **7Timer!** API, which provides weather forecasts in JSON format without requiring an API key.

*   **Base URL:** `https://www.7timer.info/bin/astro.php`
*   **Parameters:**
    *   `lon`: Longitude (e.g., 120.98 for Manila)
    *   `lat`: Latitude (e.g., 14.59 for Manila)
    *   `ac`: 0 (Altitude Correction)
    *   `unit`: `metric`
    *   `output`: `json`

**Example URL:**
`https://www.7timer.info/bin/astro.php?lon=120.98&lat=14.59&ac=0&unit=metric&output=json`

### How to get Coordinates (Lat/Lon)
1.  Open [Google Maps](https://www.google.com/maps).
2.  **Right-click** on any location on the map.
3.  A pop-up will appear with the coordinates at the top (e.g., `14.5995, 120.9842`).
4.  The first number is **Latitude**, the second is **Longitude**.

---

## Tasks

### 1. Project Setup
Create a Java class named `WeatherFetcher.java`. Ensure you have imported the necessary classes from `java.net.http.*` and `java.net.URI`.

### 2. User Input
Prompt the user to enter a **Latitude** and **Longitude**. 
*   *Hint:* Use the `Scanner` class to capture these values as `double` or `String`.

### 3. Build the Request
Construct the API URL dynamically using the user's input. 
*   Create an `HttpClient`.
*   Build an `HttpRequest` using the `GET` method.

### 4. Send and Receive
*   Send the request synchronously.
*   Check the **Status Code** of the response.
*   If the status code is `200`, **display the raw JSON data directly to the terminal**. You do not need to parse it yet.
*   If the status code is not `200` (e.g., 404 or 500), print a descriptive error message to the user.

### 5. Error Handling
Wrap your network logic in a `try-catch` block to handle potential `IOException` or `InterruptedException` (e.g., internet connection issues).

---

## Submission Requirements
*   A single `WeatherFetcher.java` file.

---

## Rubric (20 Points)

| Criteria | Description | Points |
| :--- | :--- | :--- |
| **HttpClient Setup** | Properly instantiated `HttpClient`, `HttpRequest`, and used `HttpResponse.BodyHandlers.ofString()`. | 5 |
| **Dynamic URL** | Successfully concatenated user-provided Latitude and Longitude into the API URL string. | 5 |
| **Status Validation** | Correctly checked if the status code is `200` before printing the body. Handled errors otherwise. | 5 |
| **Error Handling** | Implemented `try-catch` blocks to prevent the program from crashing on network failures. | 5 |
| **Total** | | **20** |
