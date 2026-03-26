CREATE TABLE IF NOT EXISTS book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    publication_year INT,
    isbn VARCHAR(255),
    price DECIMAL(19, 2)
);