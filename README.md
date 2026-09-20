# Manpower Management System (Labour Placement)

An integrated database management application developed as a university mini-project.

## Tech Stack
* **Backend:** Java 21, Spring Boot 3.3.x (Spring Web, Spring Data JPA, Bean Validation)
* **Database:** MySQL (Local WAMP Server)
* **Build Tool:** Maven
* **Frontend:** HTML5, CSS3, JavaScript (Vanilla GUI)

## Project Structure
```text
├── pom.xml                 # Maven build dependencies & plugins
├── .gitignore              # Git ignore rules for build & IDE files
├── README.md               # Project documentation
├── frontend-gui/           # Client-side user interface
│   ├── index.html
│   ├── css/styles.css
│   └── js/app.js
└── src/
    ├── main/
    │   ├── java/com/labour/placement/
    │   │   ├── config/     # Security and CORS configurations
    │   │   ├── controller/ # REST API endpoints
    │   │   ├── dto/        # Request & Response DTOs
    │   │   ├── model/      # JPA Entities
    │   │   ├── repository/ # Spring Data JPA Repositories
    │   │   ├── service/    # Business logic & services
    │   │   └── LabourPlacementApplication.java
    │   └── resources/
    │       ├── application.properties # WAMP DB configuration
    │       ├── schema.sql             # 3NF DDL table definitions
    │       └── data.sql               # Seed / test data
```

## Getting Started

### 1. Database Setup
1. Start your local **WAMP Server** (ensure MySQL service is active on port 3306).
2. Create the database:
   ```sql
   CREATE DATABASE labour_placement_db;
   ```
3. Execute your table creation scripts from `src/main/resources/schema.sql`.

### 2. Run the Backend
Using Maven:
```bash
./mvnw spring-boot:run
# or if Maven is installed globally:
mvn spring-boot:run
```
The API server will start at `http://localhost:8080`.

### 3. Open the Frontend GUI
Open `frontend-gui/index.html` in your browser or run a simple local server:
```bash
cd frontend-gui
python -m http.server 3000
```
