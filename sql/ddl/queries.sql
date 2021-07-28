CREATE TABLE IF NOT EXISTS bot.queries (
    id serial PRIMARY KEY,
    user_id bigint,
    query_text varchar
);

CREATE INDEX IF NOT EXISTS idx_user on bot.queries(user_id);

--here should be index for trigramms
--CREATE INDEX IF NOT EXISTS idx_trgm...