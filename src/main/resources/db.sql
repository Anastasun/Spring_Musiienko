-- Створення таблиці review, якщо вона ще не існує
CREATE TABLE IF NOT EXISTS review (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      book_title VARCHAR(255),
    review_text TEXT,
    sentiment VARCHAR(50)
    );

-- Додавання тестових відгуків
INSERT INTO review (book_title, review_text, sentiment)
VALUES
    ('To Kill a Mockingbird', 'A wonderful book with deep insights into human nature.', 'positive'),
    ('1984', 'A chilling vision of a dystopian future. A must-read!', 'positive'),
    ('The Great Gatsby', 'The book is very well written but I felt disconnected from the characters.', 'neutral'),
    ('Moby Dick', 'Too long and repetitive. I didn’t enjoy it much.', 'negative'),
    ('Pride and Prejudice', 'A classic romance, beautifully written.', 'positive'),
    ('The Catcher in the Rye', 'I didn’t connect with the protagonist, but the writing is impressive.', 'neutral');
