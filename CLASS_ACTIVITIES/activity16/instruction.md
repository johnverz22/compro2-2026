## Activity 16: Weather Data Parser (Service & Models)

### Objective
Building on **Activity 15**, where you successfully fetched raw JSON strings from the **7Timer! Weather API**, you will now refactor your code using professional design patterns. You will integrate the **Gson library** to map JSON data into Java Objects, allowing you to access weather variables (like temperature and wind) using standard getter methods instead of raw text.

### Key Concepts
1. **Deserialization**: Automatically converting JSON text into Java class instances.
2. **POJOs (Plain Old Java Objects)**: Modeling classes to match nested JSON structures.
3. **The Service Pattern**: Creating a dedicated `WeatherService` to encapsulate networking and parsing logic.
4. **Data Mapping**: Using `@SerializedName` to bridge the gap between JSON keys (e.g., `temp2m`) and Java variables.

---

### Technical Specifications
- **Package**: `com.weather.app`
- **Dependencies**: Google Gson library.
- **Reference API**: [7Timer! Astro Forecast](https://www.7timer.info/bin/astro.php?lon=120.98&lat=14.59&ac=0&unit=metric&output=json)

### Tasks

#### Task 1: Modeling the Weather Data (POJOs)
Create a class structure that mirrors the 7Timer! JSON response.
- **`WeatherResponse` Class**: Contains fields for `product` and a `List<Forecast>` (mapped to the `dataseries` key).
- **`Forecast` Class**: Contains fields for `timepoint`, `temp2m`, and a `Wind` object (mapped to `wind10m`).
- **`Wind` Class**: Contains fields for `direction` and `speed`.
- **Note**: Use `@SerializedName` for fields like `temp2m` and `wind10m` to keep your Java code clean.

#### Task 2: Implementing the `WeatherService`
Refactor your logic from Activity 15 into a dedicated service class.
- The class should hold a private `HttpClient` and `Gson` instance.
- Implement a method `public WeatherResponse getForecast(double lat, double lon)`.
- This method should build the URI, send the request, check for status `200`, and return the deserialized `WeatherResponse` object.

#### Task 3: Integration & Formatted Output
In your `Main` class:
- Reuse your `Scanner` logic from Activity 15 to get coordinates.
- Call the `WeatherService` to get the forecast object.
- **Output**: Iterate through the first **3 items** in the `dataseries` list and print:
    - *"At hour [timepoint]: [temp2m]°C with [speed] speed winds from the [direction]."*

#### Task 4: Defensive Programming
- Ensure that if the API returns an error or empty data, your program prints a clean error message (e.g., "Could not retrieve weather data") rather than crashing with a `NullPointerException`.

---

### Grading Rubric (Total: 20 Points)

| Criteria | Max Score | Mastery (Full) | Proficient (Partial) | Novice (Minimal) |
| --- | --- | --- | --- | --- |
| **Model Design & Nesting** | 6 | Correctly implements nested POJOs (Response, Forecast, Wind) with proper field mapping. | Models are implemented but miss nesting or have incorrect `@SerializedName` tags. | Models are missing or do not match the JSON structure. |
| **Service Encapsulation** | 6 | Successfully separates networking and parsing logic into a reusable `WeatherService` class. | Service class exists but still performs display logic or is tightly coupled to Main. | No Service pattern used; logic remains in the Main class. |
| **Data Parsing & Display** | 5 | Correctly parses JSON and displays specific fields (Temp, Wind) in a human-readable format. | Parsing works but the display is still raw or misses nested Wind data. | Still printing raw strings or parsing logic is broken. |
| **Error Handling** | 3 | Uses `try-catch` and status checks to handle network issues gracefully. | Try-catch exists but fails to prevent crashes on invalid/empty API responses. | Program crashes on network errors or invalid data. |
| **Total Score** | **20** |  |  | **/ 20** |
