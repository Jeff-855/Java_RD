CREATE TABLE test (id INTEGER NOT NULL, email VARCHAR(50), first_name VARCHAR(50), last_name VARCHAR(50), PRIMARY KEY (id))
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
