
/* Drop Triggers */

DROP TRIGGER TRI_cart_cseq;
DROP TRIGGER TRI_event_eseq;
DROP TRIGGER TRI_Member_membernum;
DROP TRIGGER TRI_member_mseq;
DROP TRIGGER TRI_order_detail_odseq;
DROP TRIGGER TRI_product_productnum;
DROP TRIGGER TRI_product_pseq;
DROP TRIGGER TRI_qna_qseq;
DROP TRIGGER TRI_sub_product_spseq;



/* Drop Tables */

DROP TABLE address CASCADE CONSTRAINTS;
DROP TABLE admin CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE event CASCADE CONSTRAINTS;
DROP TABLE Myaddress CASCADE CONSTRAINTS;
DROP TABLE qna CASCADE CONSTRAINTS;
DROP TABLE member CASCADE CONSTRAINTS;
DROP TABLE non_member CASCADE CONSTRAINTS;
DROP TABLE order_detail CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE sub_product CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE cseq;
DROP SEQUENCE eseq;
DROP SEQUENCE mseq;
DROP SEQUENCE oseq;
DROP SEQUENCE pseq;
DROP SEQUENCE qseq;
DROP SEQUENCE spseq;




/* Create Sequences */

create sequence mseq increment by 1 start with 1;
create sequence qseq increment by 1 start with 1;
create sequence cseq increment by 1 start with 1;
create sequence oseq increment by 1 start with 1;
create sequence pseq increment by 1 start with 1;
create sequence spseq increment by 1 start with 1;
create sequence eseq increment by 1 start with 1;




/* Create Tables */

CREATE TABLE address
(
   zip_num varchar2(7) NOT NULL,
   sido varchar2(30) NOT NULL,
   gugun varchar2(30) NOT NULL,
   dong varchar2(100) NOT NULL,
   zip_code varchar2(30),
   bunji varchar2(30)
);


CREATE TABLE admin
(
   id varchar2(20) NOT NULL,
   pwd varchar2(30) NOT NULL,
   name varchar2(20) NOT NULL,
   phone varchar2(20) NOT NULL,
   PRIMARY KEY (id)
);


CREATE TABLE cart
(
   cseq number(10) NOT NULL,
   id varchar2(50) NOT NULL,
   pseq number(10),
   quantity number(5) DEFAULT 1,
   result varchar2(1) DEFAULT '1',
   indate date DEFAULT sysdate,
   PRIMARY KEY (cseq)
);


CREATE TABLE event
(
   eseq number(10) NOT NULL,
   subject varchar2(100) NOT NULL,
   content varchar2(3000) NOT NULL,
   image varchar2(50),
   startdate date DEFAULT sysdate,
   enddate date,
   state number(1) DEFAULT 1,
   PRIMARY KEY (eseq)
);


CREATE TABLE member
(
   mseq number(10) NOT NULL,
   id varchar2(50) NOT NULL UNIQUE,
   pwd varchar2(20) NOT NULL,
   phone varchar2(13) NOT NULL,
   indate date DEFAULT sysdate,
   lastdate date DEFAULT sysdate,
   name varchar2(5) NOT NULL,
   memberkind number(1) DEFAULT 1,
   PRIMARY KEY (mseq)
);


CREATE TABLE Myaddress
(
   mseq number(10) NOT NULL,
   address varchar2(100) NOT NULL,
   aname varchar2(10) NOT NULL,
   zip_num varchar2(7),
   PRIMARY KEY (mseq)
);


CREATE TABLE non_member
(
   id varchar2(50) NOT NULL,
   password varchar2(20) NOT NULL,
   phone varchar2(13) NOT NULL,
   memberkind number(1) DEFAULT 2,
   PRIMARY KEY (id, password)
);


CREATE TABLE orders
(
   oseq number(10) NOT NULL,
   id varchar2(50) NOT NULL,
   indate  date DEFAULT sysdate,
   memberkind number(1) NOT NULL,
   PRIMARY KEY (oseq)
);


CREATE TABLE order_detail
(
   odseq number(10) NOT NULL,
   oseq number(10),
   pseq number(10),
   quantity number(5) DEFAULT 1,
   result number(1) DEFAULT '1',
   PRIMARY KEY (odseq)
);


CREATE TABLE product
(
   pseq number(10) NOT NULL,
   pname varchar2(100) NOT NULL,
   price1 number(10) NOT NULL,
   price2 number(10) NOT NULL,
   price3 number(10) NOT NULL,
   kind1 varchar2(5) NOT NULL,
   kind2 varchar2(3) NOT NULL,
   kind3 varchar2(3) NOT NULL,
   indate  date DEFAULT sysdate NOT NULL,
   content varchar2(100),
   image varchar2(50),
   useyn number(1) DEFAULT 1 NOT NULL,
   PRIMARY KEY (pseq)
);


CREATE TABLE qna
(
   qseq number(30) NOT NULL,
   subject varchar2(30) NOT NULL,
   content varchar2(50) NOT NULL,
   indate date DEFAULT sysdate,
   id varchar2(50) NOT NULL,
   reply varchar2(30),
   rep char DEFAULT '1',
   readcount number(5),
   pass number(4) NOT NULL,
   PRIMARY KEY (qseq)
);


CREATE TABLE sub_product
(
   spseq number(10) NOT NULL,
   sname varchar2(10) NOT NULL,
   kind1 number(5),
   kind2 varchar2(3) DEFAULT '0-0',
   addprice number(5) NOT NULL,
   image varchar2(50),
   PRIMARY KEY (spseq)
);



/* Create Foreign Keys */

ALTER TABLE cart
   ADD FOREIGN KEY (id)
   REFERENCES member (id)
;


ALTER TABLE Myaddress
   ADD FOREIGN KEY (mseq)
   REFERENCES member (mseq)
;


ALTER TABLE qna
   ADD FOREIGN KEY (id)
   REFERENCES member (id)
;


ALTER TABLE order_detail
   ADD FOREIGN KEY (oseq)
   REFERENCES orders (oseq)
;


ALTER TABLE cart
   ADD FOREIGN KEY (pseq)
   REFERENCES product (pseq)
;


ALTER TABLE order_detail
   ADD FOREIGN KEY (pseq)
   REFERENCES product (pseq)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_cart_cseq BEFORE INSERT ON cart
FOR EACH ROW
BEGIN
   SELECT SEQ_cart_cseq.nextval
   INTO :new.cseq
   FROM dual;
END;

DROP TRIGGER TRI_cart_cseq; 

CREATE OR REPLACE TRIGGER TRI_event_eseq BEFORE INSERT ON event
FOR EACH ROW
BEGIN
   SELECT SEQ_event_eseq.nextval
   INTO :new.eseq
   FROM dual;
END;

DROP TRIGGER TRI_event_eseq; 

CREATE OR REPLACE TRIGGER TRI_Member_membernum BEFORE INSERT ON Member
FOR EACH ROW
BEGIN
   SELECT SEQ_Member_membernum.nextval
   INTO :new.membernum
   FROM dual;
END;



CREATE OR REPLACE TRIGGER TRI_member_mseq BEFORE INSERT ON member
FOR EACH ROW
BEGIN
   SELECT SEQ_member_mseq.nextval
   INTO :new.mseq
   FROM dual;
END;

DROP TRIGGER TRI_member_mseq; 

CREATE OR REPLACE TRIGGER TRI_order_detail_odseq BEFORE INSERT ON order_detail
FOR EACH ROW
BEGIN
   SELECT SEQ_order_detail_odseq.nextval
   INTO :new.odseq
   FROM dual;
END;

DROP TRIGGER TRI_order_detail_odseq;

CREATE OR REPLACE TRIGGER TRI_product_productnum BEFORE INSERT ON product
FOR EACH ROW
BEGIN
   SELECT SEQ_product_productnum.nextval
   INTO :new.productnum
   FROM dual;
END;

DROP TRIGGER TRI_product_productnum;

CREATE OR REPLACE TRIGGER TRI_product_pseq BEFORE INSERT ON product
FOR EACH ROW
BEGIN
   SELECT SEQ_product_pseq.nextval
   INTO :new.pseq
   FROM dual;
END;

DROP TRIGGER TRI_product_pseq;

CREATE OR REPLACE TRIGGER TRI_qna_qseq BEFORE INSERT ON qna
FOR EACH ROW
BEGIN
   SELECT SEQ_qna_qseq.nextval
   INTO :new.qseq
   FROM dual;
END;

DROP TRIGGER TRI_qna_qseq;

CREATE OR REPLACE TRIGGER TRI_sub_product_spseq BEFORE INSERT ON sub_product
FOR EACH ROW
BEGIN
   SELECT SEQ_sub_product_spseq.nextval
   INTO :new.spseq
   FROM dual;
END;

DROP TRIGGER TRI_sub_product_spseq;
DROP TRIGGER TRI_MEMBER_MEMBERNUM;
--select * from user_triggers;
--alter table event modify subject varchar(100);
--alter table event modify content varchar(3000);
--delete  from event ; 
create table shortproduct(
   spseq number(10),
   pname varchar2(100),
   kind1 varchar2(5),
   kind2 varchar2(3),
   image varchar2(50),
   useyn varchar2(1)
);


