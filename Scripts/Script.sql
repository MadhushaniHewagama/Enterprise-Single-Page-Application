SELECT * FROM customer;
INSERT INTO CUSTOMER (ID,FNAME,LNAME,EMAIL,PHONENUMBER ) VALUES (1,'a','ad','dhj@fas.sd','16733');
INSERT INTO CUSTOMER (ID,FNAME,LNAME,EMAIL,PHONENUMBER ) VALUES (2,'daefea','sfad','dshdj@fas.sd','136733');

UPDATE CUSTOMER SET CREATED=CURRENT_TIMESTAMP, UPDATED=CURRENT_TIMESTAMP, VERSION=1;
