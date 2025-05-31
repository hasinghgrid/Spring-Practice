# Spring Boot CRUD Application with Spring Data JPA

This is a basic Spring Boot application that demonstrates CRUD operations using **Spring Data JPA**. It features a simple domain model consisting of `Book`, `Author`, and `Publisher` entities with the following relationships:

* **Many-to-Many** between `Book` and `Author`
* **Many-to-One** between `Book` and `Publisher`
* **One-to-Many** between `Publisher` and `Book`

---

## 🧱 Technologies Used

* Java 17+
* Spring Boot 3.5.0
* Spring Data JPA
* H2 (in-memory database)
* Maven
* Lombok (for boilerplate reduction)

---

## 📘 Domain Model Overview

### Entities and Relationships

#### 📚 Book

* `id`: Long
* `title`: String
* `isbn`: String
* `authors`: Set<Author> (Many-to-Many)
* `publisher`: Publisher (Many-to-One)

#### ✍️ Author

* `id`: Long
* `firstName`: String
* `lastName`: String
* `books`: Set<Book> (Many-to-Many)

#### 🏢 Publisher

* `id`: Long
* `name`: String
* `books`: Set<Book> (One-to-Many)

---

## 🔁 Relationship Mapping Summary

* **Book ↔ Author**

    * Many-to-Many (bidirectional)
    * Mapped using a join table `book_author`

* **Book → Publisher**

    * Many-to-One (each book has one publisher)

* **Publisher → Book**

    * One-to-Many (a publisher can publish many books)

---



## 📆 Repository Interfaces

All repository interfaces extend `CrudRepository` or `JpaRepository`:

```java
public interface BookRepository extends CrudRepository<Book, Long> {}
public interface AuthorRepository extends CrudRepository<Author, Long> {}
public interface PublisherRepository extends CrudRepository<Publisher, Long> {}
```

---

## 🚀 Running the Application

1. Clone the repository:

```bash
git clone https://github.com/your-username/spring-data-jpa-demo.git
cd spring-data-jpa-demo
```

2. Run the app:

```bash
./mvnw spring-boot:run
# or
./gradlew bootRun
```

3. H2 Console (for development & debugging):

* Visit: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
* JDBC URL: `jdbc:h2:mem:testdb`

---

## 🧪 Example API Endpoints (Optional)

* `GET /books`
* `POST /books`
* `GET /authors`
* `POST /authors`
* `GET /publishers`
* `POST /publishers`

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

## ✨ Notes

* Lombok must be enabled in your IDE.
* Data can be initialized using `data.sql` or `CommandLineRunner` in `DemoApplication`.
* You can easily switch to PostgreSQL or MySQL by updating `application.properties`.
