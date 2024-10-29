CREATE TABLE books (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       isbn VARCHAR(255) NOT NULL,
                       title VARCHAR(255) NOT NULL,
                       author VARCHAR(255) NOT NULL,
                       category VARCHAR(255),
                       available BOOLEAN DEFAULT TRUE,
                       publication_date DATE,
                       price DECIMAL(10, 2)
);