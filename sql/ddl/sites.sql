CREATE TABLE IF NOT EXISTS bot.sites (
    site_id serial PRIMARY KEY,
    site_url varchar
);

CREATE INDEX IF NOT EXISTS idx_url on bot.sites(site_url);