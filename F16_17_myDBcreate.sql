

--
-- --------------------------------------------------------

--
-- Table structure for table `F16_17_OWNER`
--

CREATE TABLE F16_17_OWNER (
  O_SSN number(10) NOT NULL,
  O_CONTACT number(10) NOT NULL,
  O_NAME varchar2(10) NOT NULL,
  O_ADDR varchar2(20) NOT NULL,
  CONSTRAINT O_SSN PRIMARY KEY  (O_SSN),
  CONSTRAINT O_CONTACT UNIQUE  (O_CONTACT)
) ;


-- --------------------------------------------------------

--
-- Table structure for table `F16_17_PERSON`
--

CREATE TABLE F16_17_PERSON (
  P_SSN number(10) NOT NULL,
  FNAME varchar2(15) NOT NULL,
  MNAME varchar2(15) default NULL,
  LNAME varchar2(15) NOT NULL,
  DOB date NOT NULL,
  PHY_ADDR varchar2(40) NOT NULL,
  CONTACT number(10) NOT NULL,
  CONSTRAINT P_SSN_PK PRIMARY KEY  (P_SSN),
  CONSTRAINT CONTACT UNIQUE  (CONTACT)
) ;



-- --------------------------------------------------------

--
-- Table structure for table `F16_17_PRODUCT`
--

CREATE TABLE F16_17_PRODUCT (
  PROD_ID number(10) NOT NULL,
  PROD_PRICE number(10) NOT NULL,
  PROD_NAME varchar2(20) NOT NULL,
  RATING number(10) default NULL,
  CONSTRAINT PROD_ID PRIMARY KEY  (PROD_ID)
) ;

-- --------------------------------------------------------


-- --------------------------------------------------------

--
-- Table structure for table `F16_17_SUPPLIER`
--

CREATE TABLE F16_17_SUPPLIER (
  S_ID number(10) NOT NULL,
  S_NAME varchar2(20) NOT NULL,
  S_ADDR varchar2(40) NOT NULL,
  S_CONTACT number(10) NOT NULL,
  S_RATING number(10) default NULL,
  O_SSN number(10) NOT NULL,
  CONSTRAINT S_ID PRIMARY KEY  (S_ID),
  CONSTRAINT S_CONTACT UNIQUE  (S_CONTACT),
CONSTRAINT F16_17_SUPPLIER_ibfk_1 FOREIGN KEY (O_SSN) REFERENCES F16_17_OWNER (O_SSN)
) ;





-- --------------------------------------------------------

--
-- Table structure for table `F16_17_WAREHOUSE`
--

CREATE TABLE F16_17_WAREHOUSE (
  W_ID number(10) NOT NULL,
  W_CONTACT number(10) NOT NULL,
  W_NAME varchar2(10) NOT NULL,
  W_LOCATION varchar2(20) NOT NULL,
  O_SSN number(10) NOT NULL,
  CONSTRAINT W_ID PRIMARY KEY  (W_ID),
  CONSTRAINT W_CONTACT UNIQUE  (W_CONTACT,O_SSN),
CONSTRAINT F16_17_WAREHOUSE_ibfk_1 FOREIGN KEY (O_SSN) REFERENCES F16_17_OWNER (O_SSN)
) ;




-- Table structure for table `F16_17_CUSTOMER`
--

CREATE TABLE F16_17_CUSTOMER (
  SSN number(10) NOT NULL,
  CUST_ID number(10) NOT NULL,
  CONSTRAINT CSSN_PK PRIMARY KEY  (SSN),
  CONSTRAINT CUST_ID UNIQUE  (CUST_ID),
CONSTRAINT F16_17_CUSTOMER_ibfk_1 FOREIGN KEY (SSN) REFERENCES F16_17_PERSON (P_SSN)
) ;


-- --------------------------------------------------------

--
-- Table structure for table `F16_17_DELIVERS`
--

CREATE TABLE F16_17_DELIVERS (
  W_ID number(10) NOT NULL,
  S_ID number(10) NOT NULL,
  DELIVERY_TIME timestamp(0) NOT NULL,
  DELIVERY_TYPE varchar2(10) NOT NULL,
  SPROD_ID number(10) NOT NULL,
  SPROD_PRICE number(10) NOT NULL,
  SPROD_QTY number(10) NOT NULL,
  CONSTRAINT WIDSID PRIMARY KEY  (W_ID,S_ID),
CONSTRAINT F16_17_DELIVERS_ibfk_1 FOREIGN KEY (W_ID) REFERENCES F16_17_WAREHOUSE (W_ID),
   CONSTRAINT F16_17_DELIVERS_ibfk_2 FOREIGN KEY (S_ID) REFERENCES F16_17_SUPPLIER (S_ID)) ;




-- --------------------------------------------------------

--
-- Table structure for table `F16_17_EMPLOYEE`
--

CREATE TABLE F16_17_EMPLOYEE (
  SSN number(10) NOT NULL,
  EMP_ID number(10) NOT NULL,
  SALARY number(10) NOT NULL,
  WARE_ID number(10) NOT NULL,
  CONSTRAINT ESSN_PK PRIMARY KEY  (SSN),
CONSTRAINT F16_17_EMPLOYEE_ibfk_1 FOREIGN KEY (SSN) REFERENCES F16_17_PERSON (P_SSN), 
  CONSTRAINT F16_17_EMPLOYEE_ibfk_2 FOREIGN KEY (WARE_ID) REFERENCES F16_17_WAREHOUSE (W_ID)) ;


-- --------------------------------------------------------

--
-- Table structure for table `F16_17_ORDERS`
--

CREATE TABLE F16_17_ORDERS (
  P_SSN number(10) NOT NULL,
  PROD_ID number(10) NOT NULL,
  ORDER_ID number(10) NOT NULL,
  PAY_TYPE varchar2(10) NOT NULL,
  SHIP_ADDR varchar2(40) NOT NULL,
  DELIVERY_STATUS varchar2(10) NOT NULL,
  CONSTRAINT PSSNPRODID PRIMARY KEY  (P_SSN,PROD_ID),
  CONSTRAINT ORDER_ID UNIQUE  (ORDER_ID),
CONSTRAINT F16_17_ORDERS_ibfk_1 FOREIGN KEY (P_SSN) REFERENCES F16_17_PERSON (P_SSN),
  CONSTRAINT F16_17_ORDERS_ibfk_2 FOREIGN KEY (PROD_ID) REFERENCES F16_17_PRODUCT (PROD_ID)
) ;





--
-- Table structure for table `F16_17_STORES`
--

CREATE TABLE F16_17_STORES (
  W_ID number(10) NOT NULL,
  P_ID number(10) NOT NULL,
  P_QUANTITY number(10) NOT NULL,
  CONSTRAINT WIDPID PRIMARY KEY  (W_ID,P_ID),
CONSTRAINT F16_17_STORES_ibfk_2 FOREIGN KEY (P_ID) REFERENCES F16_17_PRODUCT (PROD_ID),
  CONSTRAINT F16_17_STORES_ibfk_1 FOREIGN KEY (W_ID) REFERENCES F16_17_WAREHOUSE (W_ID)
) ;














