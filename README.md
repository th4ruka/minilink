# MiniLink: A Simple URL Shortener

[![Java CI with Maven](https://github.com/th4ruka/minilink/actions/workflows/maven.yml/badge.svg)](https://github.com/th4ruka/minilink/actions/workflows/maven.yml) [![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

MiniLink is a user-friendly URL shortener built with Spring Boot. It allows you to quickly create short, easy-to-remember links for long, cumbersome URLs.

## Upcoming Features

- **Shorten URLs:** Convert long URLs into concise, shareable short links.
- **Custom Short Codes:** Optionally create your own personalized short codes.
- **Click Tracking:** Track the number of clicks on your shortened links.
- **API Access:** Integrate MiniLink with other applications through a RESTful API.

## Technologies Used

- Java version 21
- Spring Boot version 3.3.0
- Spring Data JPA
- MySQL
- Maven

## Getting Started

1. **Clone the repository:**

   ```bash
   git clone https://github.com/th4ruka/minilink.git
   ```

2. **Build the project:**

   ```bash
   ./mvnw clean install  # (Maven)
   ```

3. **Run the application:**

   ```bash
   ./mvnw spring-boot:run  # (Maven)
   ```

4. **Access the application:**

   Open your web browser and navigate to `http://localhost:8080`.

## Usage

- **To shorten a URL:** Enter the long URL in the provided field and click "Shorten."
- **To access a shortened URL:** Enter the short code in your browser's address bar, and you'll be redirected to the original URL.

## Configuration

Update the `application.properties` file with your database connection details and other relevant settings.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue if you find any bugs or want to suggest new features.

## License

This project is licensed under the MIT License.
