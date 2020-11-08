CREATE TABLE CUSTOMER (
    ID INTEGER NOT NULL IDENTITY,
    FNAME VARCHAR,
    LNAME VARCHAR,
    EMAIL VARCHAR,
    PHONENUMBER VARCHAR,
    CREATED TIMESTAMP,
    UPDATED TIMESTAMP,
    VERSION INTEGER,
    PRIMARY KEY (ID)
);

-- ensure all customer rows have CREATED, UPDATED and VERSION columns set
UPDATE CUSTOMER SET CREATED=CURRENT_TIMESTAMP, UPDATED=CURRENT_TIMESTAMP, VERSION=1;


