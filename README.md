# 🛒 Product Management System — Spring MVC

A full-stack **Product Management CRUD Web Application** built with **Spring MVC**, featuring product listing, creation, editing, deletion, and image upload functionality.

---

## 📸 Screenshots

| Add Product | Product List |
|---|---|
| Form with Name, Price, Brand, Quantity, Image | Table with Delete & Edit actions |

---

## 🚀 Features

- ✅ **Add New Product** — Name, Price, Brand, Quantity, Image Upload
- ✅ **Display All Products** — Responsive table with all product details
- ✅ **Edit Product** — Update existing product information
- ✅ **Delete Product** — Remove a product with success feedback
- ✅ **Image Upload** — Upload and display product images
- ✅ **Flash Messages** — Success alerts (e.g., "Product saved successfully!", "Product deleted successfully!")

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Framework | Spring MVC |
| Language | Java |
| View | JSP / Thymeleaf |
| Build Tool | Maven |
| Database | MySQL  |
| ORM | Spring Data JPA / Hibernate |
| Server | Apache Tomcat |
| Frontend | HTML, CSS, Bootstrap |

---

## 📁 Project Structure

```
SpringMVC-ProductManagement/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/yourpackage/
│   │   │       ├── controller/
│   │   │       │   └── ProductController.java
│   │   │       ├── model/
│   │   │       │   └── Product.java
│   │   │       ├── repository/
│   │   │       │   └── ProductRepository.java
│   │   │       └── service/
│   │   │           └── ProductService.java
│   │   ├── resources/
│   │   │   └── application.properties
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── views/
│   │       │       ├── addProduct.jsp
│   │       │       └── productList.jsp
│   │       └── uploads/         ← product images stored here
├── pom.xml
└── README.md
```

---

## ⚙️ Prerequisites

Make sure you have the following installed:

- Java JDK 17 
- Apache Maven 3.6+
- MySQL 8.0+ (or use H2 for in-memory)
- Apache Tomcat 9+ (or use embedded)
- Git

---

## 🔧 Setup & Installation

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/SpringMVC-ProductManagement.git
cd SpringMVC-ProductManagement
```

### 2. Configure the Database

Open `src/main/resources/application.properties` and update:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/productdb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```


### 3. Create the Database (MySQL only)

```sql
CREATE DATABASE productdb;
```

### 4. Build the Project

```bash
mvn clean install
```

### 5. Run the Application

```bash
mvn spring-boot:run
```

Or deploy the generated `.war` file to Apache Tomcat.

### 6. Access the Application

Open your browser and navigate to:

```
http://localhost:8080/
```

---

## 📋 API / URL Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/` | Home / Display all products |
| GET | `/products` | List all products |
| GET | `/products/add` | Show Add Product form |
| POST | `/products/save` | Save a new product |
| GET | `/products/edit/{id}` | Show Edit Product form |
| POST | `/products/update/{id}` | Update product |
| GET | `/products/delete/{id}` | Delete a product |

---

## 🗄️ Product Entity

```java
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String brand;
    private Integer quantity;
    private String imagePath;

    // Getters and Setters
}
```

---

## 🖼️ Image Upload

- Images are uploaded via multipart form
- Stored in the `uploads/` directory inside `webapp/`
- Displayed in the product list table as thumbnails

---

## 🧪 Sample Data

| ID | Name | Price | Brand | Quantity |
|----|------|-------|-------|----------|
| 1 | Apple | 140.0 | Apple | 3 |

---

## 🐛 Troubleshooting

| Issue | Fix |
|-------|-----|
| Port 8080 already in use | Change port in `application.properties`: `server.port=8081` |
| Image not displaying | Check `uploads/` folder path and file permissions |
| DB connection refused | Verify MySQL is running and credentials are correct |
| 404 on Tomcat | Check context path and ensure WAR is deployed correctly |

---

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch: `git checkout -b feature/your-feature`
3. Commit your changes: `git commit -m "Add your feature"`
4. Push to the branch: `git push origin feature/your-feature`
5. Open a Pull Request

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

## 👨‍💻 Author
Venkateswarlu Peetha 
---

> ⭐ If you found this project helpful, please give it a star!