PRAGMA encoding='UTF-8';
CREATE TABLE IF NOT EXISTS prisoners (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  surname VARCHAR(30) NOT NULL,
  firstName VARCHAR(30) NOT NULL,
  patronymic VARCHAR(30) NOT NULL,
  nickname VARCHAR(30) DEFAULT 'none',
  birthYear INTEGER NOT NULL,
  birthPlace VARCHAR NOT NULL,
  livingPlace VARCHAR(500) NOT NULL,
  prison VARCHAR(500) NOT NULL,
  convictionInfo VARCHAR,
  additionalInfo VARCHAR,
  fileLink VARCHAR,
  UNIQUE (surname, firstName, patronymic) ON CONFLICT FAIL
);

CREATE TABLE IF NOT EXISTS links (
  prisoner1 INTEGER,
  prisoner2 INTEGER,
  UNIQUE (prisoner1, prisoner2)
);

CREATE INDEX prisoners_surname_firstName_patronymic ON prisoners (surname, firstName, patronymic);

CREATE INDEX prisoners_nickname ON prisoners (nickname);

CREATE INDEX prisoners_livingPlace ON prisoners (livingPlace);

CREATE INDEX prisoners_prison ON prisoners (prison);