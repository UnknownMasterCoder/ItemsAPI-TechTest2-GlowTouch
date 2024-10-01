# ItemsAPI-TechTest2-GlowTouch

> ## Items Management API - Spring Boot Technical Test

This API has been developed as part of a technical test, focusing on handling POST operations on a list of items in a DB. It includes validations such as handling null or empty inputs and avoiding duplicate item entries.

> ## Technologies Used

- **Java**: 17
- **Spring Boot**: 3.3.4
- **Gradle**: Build tool
- **Postman**: For testing API requests
- **Lombok**: For cleaner code by auto-generating getters, setters, constructors, etc.

> ## Project Requirements

Please create a Spring Boot REST controller with the following requirements:

1. The controller should handle POST requests at the endpoint '/items'.
2. It should accept a List of Items in the request body.
3. If the List is null or empty, the controller should return a 400 Bad Request response.
4. For each Item in the List, if the item’s ID is already present in the database, it should skip adding that item and return a 409 Conflict response for those items

The following features were implemented to meet the requirements of the technical test:

1. **POST `/items` Endpoint**:
   - ✅ Accepts a list of items to add to the database in the body.
   - ✅ If the list is null or empty, the API returns a `400 Bad Request`.
   - ✅ If an item's ID already exists in the database, the API skips that item and returns a `409 Conflict` response.
   - ✅ Successfully added items return a `200 OK` response.
   
3. **Database Simulation**: The API simulates a database using a `Set<Long>` to keep track of item IDs. This ensures that item IDs are unique, avoiding duplication.

> ## Prerequisites

- **Java 17** or higher.
- **Gradle** installed.

> ## How to Run the API

1. Clone the repository:

   ```bash
   git clone https://github.com/UnknownMasterCoder/ItemsAPI-TechTest2-GlowTouch.git
   cd your-repo
   
2. Build and run the application:
   ```bash
   ./gradlew bootRun
   
3. The API will be available at `http://localhost:8080/items`

> ## Architecture Overview

Here is a simple architecture overview of the API:

![Architecture model](/docs/ArchitectureModel.png "Architecture model")

- **Controller:** Handles the HTTP requests.
- **Service:** Contains the business logic, such as filtering out duplicate items.
- **Database:** Simulated in-memory storage using a Set<Long> to prevent duplicate IDs.

> ## Database Implementation

Instead of using a real database, the API stores the item IDs in an in-memory set `(Set<Long>)`. Each time the `/items` endpoint is called, the service checks whether the item ID already exists in this set. If it does, that item is skipped, and a `409 Conflict` response is returned.

> ## API Endpoints

### POST /items

This endpoint allows adding a list of items. If the list is empty or null, or if any item has an ID that already exists, appropriate error messages are returned.

- **Request:** Accepts a JSON array of items in the following format:
   ```json
   [
       {"id": 1, "name": "Item 1"},
       {"id": 9, "name": "Item 9"},
       {"id": 10, "name": "Item 10"},
       {"id": 4, "name": "Item 4"},
       {"id": 11, "name": "Item 11"},
       {"id": 12, "name": "Item 12"},
       {"id": 7, "name": "Item 7"},
       {"id": 8, "name": "Item 8"}
   ]

- **Responses:**

   - `200 OK`: Items added successfully.
   - `400 Bad Request`: If the list is null or empty.
   - `409 Conflict`: If any item in the list has an existing ID in the database.

> ## Example Usage

### 1. Adding new items successfully
Using Postman, you can send a request like the following to add new items:

### 2. Handling item conflicts
If you try to add an item with an existing ID, you will receive a conflict message:

> ## Author

This project was developed by [Pedro Mayorga] as part of a technical test.

- [Pedro Mayorga on LinkedIn](https://linkedin.com/in/PedroMayorga)
- [UnknownMasterCoder on GitHub](https://github.com/UnknownMasterCoder)
