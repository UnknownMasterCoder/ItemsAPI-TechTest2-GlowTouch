# ItemsAPI-TechTest2-GlowTouch

## Items Management API - Spring Boot Technical Test

This API has been developed as part of a technical test, focusing on handling POST operations on a list of items in a DB. It includes validations such as handling null or empty inputs and avoiding duplicate item entries.

## Technologies Used

- **Java**: 17
- **Spring Boot**: 3.1.0
- **Gradle**: Build tool
- **Postman**: For testing API requests
- **Lombok**: For cleaner code by auto-generating getters, setters, constructors, etc.

## Project Requirements

The following features were implemented to meet the requirements of the technical test:

1. **POST `/items` Endpoint**: Accepts a list of items to add to the database.
   - If the list is null or empty, the API returns a `400 Bad Request`.
   - If an item's ID already exists in the database, the API skips that item and returns a `409 Conflict` response.
   - Successfully added items return a `200 OK` response.
   
2. **Database Simulation**: The API simulates a database using a `Set<Long>` to keep track of item IDs. This ensures that item IDs are unique, avoiding duplication.

## Prerequisites

- **Java 17** or higher.
- **Gradle** installed.

## How to Run the API

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/your-repo.git
   cd your-repo
   
2. Build and run the application:
   ```bash
   ./gradlew bootRun
   
3. The API will be available at `http://localhost:8080/items`

## Architecture Overview

Here is a simple architecture overview of the API:


- Controller: Handles the HTTP requests.
- Service: Contains the business logic, such as filtering out duplicate items.
- Database: Simulated in-memory storage using a Set<Long> to prevent duplicate IDs.
