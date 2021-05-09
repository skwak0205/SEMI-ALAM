
DROP TABLE ONLINE_CLASS;

CREATE TABLE ONLINE_CLASS(
	ONLINE_CLASS_NO NUMBER NOT NULL PRIMARY KEY,
	ONLINE_CLASS_ID VARCHAR2(30) NOT NULL,
	ONLINE_CLASS_TITLE VARCHAR2(30) NOT NULL,
	ONLINE_CLASS_CONTENT VARCHAR2(30) NOT NULL,
	ONLINE_CLASS_DATE DATE NOT NULL,
	ONLINE_CLASS_CATEGORY NUMBER NOT NULL,
	ONLINE_CLASS_PRICE NUMBER NOT NULL,
	CONSTRAINT ONLINE_CLASS_ID_FK FOREIGN KEY(ONLINE_CLASS_ID) REFERENCES MEMBER(MEMBER_ID),
	CONSTRAINT ONLINE_CLASS_CATEGORY_FK FOREIGN KEY(ONLINE_CLASS_CATEGORY) REFERENCES CATEGORY(CATEGORY_NUM)
);

select * from online_class;

ALTER TABLE ONLINE_CLASS
DROP CONSTRAINT ONLINE_CLASS_ID_FK;

ALTER TABLE ONLINE_CLASS ADD CONSTRAINT ONLINE_CLASS_ID_FK FOREIGN KEY (ONLINE_CLASS_ID)
REFERENCES MEMBER(MEMBER_ID) ON DELETE CASCADE;