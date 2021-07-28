CREATE TABLE IF NOT EXISTS users (
id bigint PRIMARY KEY,
first_name varchar,
last_name varchar,
username varchar,
is_bot boolean
);

CREATE INDEX idx_user_name on bot.users(username);