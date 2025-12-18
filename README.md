[M604 – Backend Development Project Report.md](https://github.com/user-attachments/files/24233253/M604.Backend.Development.Project.Report.md)
# **M604 – Backend Development Project Report**

**Project Title:** UrbanEco Backend System

**Module:** M604 – Backend Development

**Technology Stack:** Java, Spring Boot, MySQL, OpenAPI (Swagger)

**Full Name:** Giselle Victoria Peñaloza Guacaneme

**Student ID:** GH1037182

**Project GitHub URL:** [M604-backend-development](https://github.com/Gisellev14/M604-backend-development)

**Project video URL: [M604.mov](https://gismauniversity-my.sharepoint.com/:v:/g/personal/giselle_penaloza_gisma-student_com/IQARuw0D78OmTrmQJBXwHHZiAeiAlEgjmNVH7NimG2Z1wSA?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&e=v1fkat)**

---

## **1\. Introduction**

The objective of this project is to design and implement a backend system that manages data flow between an application and a database using modern backend development practices. The project focuses on building a RESTful backend in Java using Spring Boot, providing full CRUD functionality and robust error handling.

The UrbanEco backend simulates a standard retail platform, enabling interaction with product data stored in a relational database.

---

## **2\. System Architecture**

The backend follows a layered architecture composed of:

* **Controller Layer:** Exposes RESTful endpoints to external clients.

* **Service / Repository Layer:** Handles business logic and database interaction.

* **Persistence Layer:** MySQL database accessed via Spring Data JPA.

Spring Boot was selected as part of the course contents.Additionally it already provides a Java application, easily complying with project requirements, as well as ease of integration with databases, and strong ecosystem support.

---

## **3\. Backend Development**

The backend system was implemented in Java using Spring Boot. It manages data flow between the API layer and a MySQL database using JPA repositories.

Key features include:

* Dependency injection for loose coupling

* Repository abstraction to simplify database access

---

## **4\. Database Interaction**

The backend interacts with a relational MySQL database designed separately as part of the database module. Entities are mapped to database tables using JPA annotations, ensuring consistency between the object model and the underlying schema.

The application connects to the database via a configured data source, and schema changes are intentionally disabled in the application to preserve manual database design decisions.

---

## **5\. API Development**

A RESTful API was developed to expose backend functionality. Endpoints are defined using standard HTTP methods:

* **POST** – Create a product

* **GET** – Retrieve all products

* **GET (by ID)** – Retrieve a single product

* **PUT** – Update an existing product

* **DELETE** – Remove a product

Swagger (OpenAPI) was integrated to provide an interactive interface for testing and visualizing API endpoints. This interface allows users to explore the API structure, submit requests, and view responses directly from the browser, avoiding the need to create automated tests for this project scope.

---

## **6\. Error Handling and Fallback Procedures**

Centralized error handling was implemented using a global exception handler. Custom exceptions are used to represent known error conditions such as missing resources, while a generic fallback handler captures unexpected runtime errors.

The system ensures:

* Meaningful HTTP status codes (404, 400, 500\)

* Consistent JSON error responses

* Graceful degradation without application crashes

This approach minimizes disruption to users and improves system robustness.

---

## **7\. Evaluation and Limitations**

The backend successfully fulfills all project requirements, providing a functional, well-structured API with full CRUD support. While the system currently focuses on a single entity for demonstration purposes, the architecture allows easy extension to additional entities such as orders or customers.

As mentioned above, this implementation is missing automated tests, on purpose, as testing is being carried out on browsers via Swagger. Therefore, we are not implementing client/consumers of the API response, or logging, as not explicitly required for this scope.

Also, while testing we found out that we are not properly handling the scenario where a user attempts to create a product with an already existing product\_id, which should ideally raise an exception, or at least a warning, instead of allowing the customer to update the product, which is the current behavior. For project purposes this wasn’t fixed and it is being reported as an accepted bug.

---

## **8\. Conclusion**

This project demonstrates the design and implementation of a modern backend system using Java and Spring Boot. It integrates database interaction, RESTful APIs, and robust error handling, forming a solid foundation for scalable backend development.

