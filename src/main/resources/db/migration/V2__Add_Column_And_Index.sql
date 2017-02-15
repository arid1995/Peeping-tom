PRAGMA encoding='UTF-8';
ALTER TABLE links ADD COLUMN isFriendly INTEGER DEFAULT 1;

CREATE INDEX links_covering ON links (prisoner2, prisoner1, isFriendly);