CREATE TABLE IF NOT EXISTS COMMIT (
    pk SERIAL primary key,
    id VARCHAR(255),
    author VARCHAR(255),
    message VARCHAR(255),
    primary key (pk)
);