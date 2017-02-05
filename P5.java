import java.io.*;
import java.sql.*;


//Team 17
//Sai Charan Bolisetty
//Sumanth Tella

public class P5 {

    public static Connection connection = null;
    Statement statement = null;


    public P5() {
    }

    public static void connect() {

        System.out.println("-------- Oracle JDBC Connection  ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        try {


            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:cse1", "sxt1476", "Hello2016");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection == null) {
            System.out.println("Failed to make connection!");
        }

    }

    public static void main(String[] args) throws IOException {

        int selection = 0, selection1, selection2 = 0, selection3, selection4, selection41, selection5, sid,scontact;
        float srating;
        String table, sname, snamec, saddress, sidc;
        P5 p = new P5();

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);


        do {
            out.write("\n\n\t\tWAREHOUSE MANAGEMENT\t\t\n\n");

            out.write("\n 1. VIEW TABLES");
            out.write("\n 2. INSERT VALUES");
            out.write("\n 3. DELETE VALUES");
            out.write("\n 4. UPDATE VALUES");
            out.write("\n 5. REPORTS ");
            out.write("\n 6. Exit ");
            out.write("\n\n PLEASE SELECT FROM ABOVE OPTIONS :\n");
            out.flush();

            try {
                selection = Integer.parseInt(buff.readLine());
            } catch (NumberFormatException e1) {
                System.out.println("\n WRONG SELECTION");
            }

            try {

                switch (selection) {

                    case 1: {

                        p.connect();

                        do {


                            out.write("\n\n 1.  Display contents of OWNER table");
                            out.write("\n\n 2.  Display contents of PERSON table ");
                            out.write("\n\n 3.  Display contents of PRODUCT table");
                            out.write("\n\n 4.  Display contents of SUPPLIER table");
                            out.write("\n\n 5.  Display contents of WAREEHOUSE table");
                            out.write("\n\n 6.  Display contents of CUSTOMER table");
                            out.write("\n\n 7.  Display contents of DELIVERS table");
                            out.write("\n\n 8.  Display contents of EMPLOYEE table");
                            out.write("\n\n 9.  Display contents of ORDERS table");
                            out.write("\n\n 10. Display contents of STORES table");
                            out.write("\n\n 11. GO BACK ");
                            out.write("\n\n PLEASE ENTER YOUR CHOICE :\n");
                            out.flush();

                            selection1 = Integer.parseInt(buff.readLine());

                            switch (selection1) {

                                case 1: {
                                    p.display_owner();
                                    break;
                                }

                                case 2: {
                                    p.display_person();
                                    break;
                                }

                                case 3: {
                                    p.display_product();
                                    break;
                                }

                                case 4: {
                                    p.display_supplier();
                                    break;
                                }

                                case 5: {
                                    p.display_warehouse();
                                    break;
                                }

                                case 6: {
                                    p.display_customer();
                                    break;
                                }

                                case 7: {
                                    p.display_delivers();
                                    break;
                                }

                                case 8: {
                                    p.display_employee();
                                    break;
                                }

                                case 9: {
                                    p.display_orders();
                                    break;
                                }

                                case 10: {
                                    p.display_stores();
                                    break;
                                }

                                case 11: {
                                    break;
                                }

                                default: {
                                    System.out.println("\n\n Wrong Selection");
                                    break;
                                }

                            }
                        } while (selection1 != 11);
                        break;


                    }


                    case 2: {
                        p.connect();

                        do {
                            out.write("\n Tables available for Inserting records are : ");
                            out.write("\n\n 1. SUPPLIER table ");
                            out.write("\n\n 2. Go back to previous menu ");
                            out.write("\n\n PLEASE ENTER YOUR CHOICE :");
                            out.flush();
                            selection2 = Integer.parseInt(buff.readLine());

                            switch (selection2) {

                                case 1: {
                                    table = "F16_17_SUPPLIER";


                                    out.write("\n\n INSERTING INTO SUPPLIER\n");
                                    out.write("\nPlease Enter valid S_ID:\n ");
                                    out.flush();
                                    sid = Integer.parseInt(buff.readLine());
                                    out.write("\nPlease Enter SUPPLIER NAME:\n ");
                                    out.flush();
                                    sname = buff.readLine();
                                    out.write("\nPlease Enter SUPPLIER ADDRESS:\n ");
                                    out.flush();
                                    saddress = buff.readLine();
                                    out.write("\nPlease Enter SUPPLIER CONTACT:\n ");
                                    out.flush();
                                    scontact = Integer.parseInt(buff.readLine());
                                    out.write("\nPlease Enter SUPPLIER RATING:\n ");
                                    out.flush();
                                    srating = Float.parseFloat(buff.readLine());


                                    out.write("\n\n Insertion Completed........");
                                    p.insert_into_supplier(table, sid, sname, saddress, scontact, srating);
                                    out.write("\n\n Now displaying the table with tuple........");
                                    out.flush();
                                    p.display_table_supplier_on_sid(sid);
                                    break;


                                }

                                case 2: {
                                    break;
                                }

                                default: {
                                    System.out.println("\n\n Wrong Selection!");
                                    break;
                                }


                            }


                        } while (selection2 != 2);
                        break;

                    }

                    case 3:

                    {
                        p.connect();
                        do {
                            out.write("\n Tables available for Deleting tuples are: ");
                            out.write("\n\n 1. SUPPLIER Table ");
                            out.write("\n\n 2. Go back to previous menu ");
                            out.write("\n\n PLEASE ENTER YOUR CHOICE :");
                            out.flush();
                            selection3 = Integer.parseInt(buff.readLine());

                            switch (selection3) {

                                case 1: {
                                    table = "F16_17_SUPPLIER";
                                    sidc = "S_ID";
                                    out.write("\n\n Deleting record from SUPPLIER...............\n");
                                    out.write("\nPlease Enter valid S_ID:");
                                    out.flush();
                                    sid = Integer.parseInt(buff.readLine());
                                    out.write("\n\n Deleting the selected S_ID:" + sid);
                                    p.delete_from_supplier_on_sid(table, sidc, sid);
                                    out.write("\n\n Record successfully deleted");
                                    out.flush();
                                    p.display_table_supplier_on_sid(sid);
                                    break;
                                }

                                case 2: {
                                    break;
                                }

                                default: {
                                    System.out.println("\n\n Wrong Selection!");
                                    break;
                                }


                            }

                        } while (selection3 != 2);
                        break;
                    }

                    case 4: {

                        p.connect();
                        do {
                            out.write("\n***** Update Table *****\n");
                            out.write("\n Table available for Update: ");
                            out.write("\n\n 1. SUPPLIER table");
                            out.write("\n\n\n 2. Go back to previous menu ");
                            out.write("\n\n PLEASE ENTER YOUR CHOICE :");
                            out.flush();
                            selection4 = Integer.parseInt(buff.readLine());

                            switch (selection4) {

                                case 1: {
                                    table = "F16_17_SUPPLIER";
                                    sidc = "S_ID";
                                    snamec = "S_NAME";
                                    out.write("\n\n .................Updating SUPPLIER table...............\n");
                                    out.write("\n\n Existing Values of SUPPLIER table are:");
                                    out.flush();
                                    p.display_supplier();

                                    out.write("\n\n You can update columns:");
                                    out.write("\n\n 1. S_ID:");
                                    out.write("\n\n 2. S_NAME:");
                                    out.write("\n\n PLEASE ENTER YOUR CHOICE :");
                                    out.flush();

                                    selection41 = Integer.parseInt(buff.readLine());


                                    switch (selection41) {

                                        case 1: {

                                            System.out.println("\nPlease Enter Supplier Name: ");
                                            sname = buff.readLine();
                                            System.out.println("\nPlease Enter New Unique Supplier ID: ");
                                            sid = Integer.parseInt(buff.readLine());
                                            p.update_table_supplierid(table, sidc, sid, snamec, sname);
                                            System.out.println("\n\n Record successfully updated!!");
                                            p.display_table_supplier_on_sid(sid);
                                            break;
                                        }

                                        case 2: {

                                            System.out.println("\nPlease Enter Supplier ID: ");
                                            sid = Integer.parseInt(buff.readLine());
                                            System.out.println("\nPlease Enter New Supplier Name: ");
                                            sname = buff.readLine();


                                            p.update_table_suppliername(table, snamec, sname, sidc, sid);
                                            System.out.println("\n\n Record successfully updated!!");
                                            p.display_table_supplier_on_sid(sid);
                                            break;
                                        }

                                        default: {
                                            System.out.println("\n\n Wrong Selection!");
                                            break;
                                        }

                                    }


                                }

                                case 2: {
                                    break;
                                }

                            }

                        } while (selection4 != 2);
                        break;
                    }


                    case 5: {
                        p.connect();
                        do {
                            out.write("\n\n1. MOST PURCHASED ITEM IN ORDERS AND WAREHOUSE WITH LEAST QUANTITY OF THAT PRODUCT ");
                            out.write("\n\n2. RETURNED ORDERS BASED ON DELIVERY STATUS AND WAREHOUSE IT HAS BEEN RETURNED TO");
                            out.write("\n\n3. TOTAL PROFIT ON THE PRODUCT");
                            out.write("\n\n4. PAYMENT TYPE OF PERSON FROM ORDERS");
                            out.write("\n\n5. TO SELECT SUPPLIER BASED ON RATING");
                            out.write("\n\n6. PRODUCT QUANTITY OF A PRODUCT IN A PARTICULAR WAREHOUSE");
                            out.write("\n\n7. PRODUCT RATING GIVEN BY CUSTOMER");
                            out.write("\n\n8. PRODUCT ID ORDERED IN A PARTICULAR TIME");
                            out.write("\n\n9. TOTAL NO OF ORDERS MADE BY BOTH CUSTOMERS AND EMPLOYEES");
                            out.write("\n\n10. Go back");
                            out.write("\n\n PLEASE ENTER YOUR CHOICE:");
                            out.flush();
                            selection5 = Integer.parseInt(buff.readLine());


                            switch (selection5) {

                                case 1: {
                                    p.report1();
                                    break;
                                }

                                case 2: {
                                    p.report2();
                                    break;
                                }

                                case 3: {
                                    p.report3();
                                    break;
                                }

                                case 4: {
                                    p.report4();
                                    break;
                                }

                                case 5: {
                                    p.report5();
                                    break;
                                }

                                case 6: {
                                    p.report6();
                                    break;
                                }

                                case 7: {
                                    p.report7();
                                    break;
                                }

                                case 8: {
                                    p.report8();
                                    break;
                                }

                                case 9: {
                                    p.report9();
                                    break;
                                }
                                case 10: {
                                    break;
                                }

                                default: {
                                    System.out.println("\n\n Wrong Selection!");
                                    break;
                                }

                            }


                        } while (selection5 != 10);
                        break;
                    }
                    case 6:

                    {

                        break;
                    }

                    default: {
                        System.out.println("\nWrong selection! please select from above choices");

                        break;
                    }


                }

            } catch (Exception e) {

            }


        } while (selection != 6);

    }

    private void report9() {

        try {
            statement = connection.createStatement();
            String query = "SELECT FNAME,LNAME,(SELECT COUNT(ORDER_ID) FROM F16_17_ORDERS WHERE F16_17_PERSON.P_SSN=F16_17_ORDERS.P_SSN) AS NO_OF_ORDERS FROM F16_17_PERSON";
            ResultSet r = statement.executeQuery(query);
            System.out.println("\nTOTAL NO OF ORDERS MADE BY BOTH CUSTOMERS AND EMPLOYEES");
            System.out.println("\n---------------------------------");
            System.out.println("\nFNAME | LNAME | NO_OF ORDERS");

            while (r.next()) {

                System.out.println("\n|    " + r.getString(1) + "\t     |      " + r.getString(2) + "\t     |      " + r.getString(3));
            }

            statement.close();

            System.out.println("\n---------------------------------");

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void report8() {

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM (SELECT SPROD_ID FROM F16_17_DELIVERS WHERE DELIVERY_TIME BETWEEN '01/NOV/2016' AND  '30/NOV/2016' GROUP BY SPROD_ID ORDER BY COUNT(*) DESC) WHERE rownum <= 1";
            ResultSet r = statement.executeQuery(query);
            System.out.println("\nPRODUCT ID ORDERED IN A PARTICULAR TIME");
            System.out.println("\n---------------------------------");
            System.out.println("\nSPROD_ID");

            while (r.next()) {

                System.out.println("\n|    " + r.getString(1) + "\t");
            }

            statement.close();

            System.out.println("\n---------------------------------");

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void report7() {

        try {
            statement = connection.createStatement();
            String query = "SELECT F16_17_PERSON.FNAME,F16_17_ORDERS.ORDER_ID,F16_17_PRODUCT.PROD_ID,F16_17_PRODUCT.RATING FROM F16_17_ORDERS INNER JOIN F16_17_PERSON ON F16_17_PERSON.P_SSN=F16_17_ORDERS.P_SSN INNER JOIN F16_17_PRODUCT ON F16_17_ORDERS.PROD_ID=F16_17_PRODUCT.PROD_ID WHERE F16_17_PRODUCT.RATING>3";
            ResultSet r = statement.executeQuery(query);
            System.out.println("\n PRODUCT RATING GIVEN BY CUSTOMER");
            System.out.println("\n---------------------------------");
            System.out.println("\nFNAME | ORDER_ID | PROD_ID | RATING");

            while (r.next()) {

                System.out.println("\n|    " + r.getString(1) + "\t     |      " + r.getString(2) + "\t     |      " + r.getString(3) + "\t     |      " + r.getString(4));
            }

            statement.close();

            System.out.println("\n---------------------------------");

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void report6() {

        try {
            statement = connection.createStatement();
            String query = "SELECT F16_17_WAREHOUSE.W_ID,F16_17_WAREHOUSE.W_NAME,F16_17_STORES.P_QUANTITY,F16_17_PRODUCT.PROD_ID,F16_17_PRODUCT.PROD_NAME FROM F16_17_STORES INNER JOIN F16_17_PRODUCT ON F16_17_STORES.P_ID=F16_17_PRODUCT.PROD_ID INNER JOIN F16_17_WAREHOUSE ON F16_17_STORES.W_ID=F16_17_WAREHOUSE.W_ID WHERE F16_17_STORES.P_QUANTITY>200";
            ResultSet r = statement.executeQuery(query);
            System.out.println("\nPRODUCT QUANTITY OF A PRODUCT IN A PARTICULAR WAREHOUSE");
            System.out.println("\n---------------------------------");
            System.out.println("\nW_ID | W_NAME | P_QUANTITY | PROD_ID | PROD_NAME");

            while (r.next()) {

                System.out.println("\n|    " + r.getString(1) + "\t     |      " + r.getString(2) + "\t     |      " + r.getString(3) + "\t     |      " + r.getString(4) + "\t     |      " + r.getString(5));
            }

            statement.close();

            System.out.println("\n---------------------------------");

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void report5() {

        try {
            statement = connection.createStatement();
            String query = "SELECT S_NAME,S_RATING FROM F16_17_SUPPLIER WHERE S_RATING IN (SELECT S_RATING FROM  F16_17_SUPPLIER WHERE S_RATING>3) ORDER BY S_RATING DESC ";
            ResultSet r = statement.executeQuery(query);
            System.out.println("\nTO SELECT SUPPLIER BASED ON RATING");
            System.out.println("\n---------------------------------");
            System.out.println("\nS_NAME | S_RATING");

            while (r.next()) {

                System.out.println("\n|    " + r.getString(1) + "\t     |      " + r.getString(2) + "\t\t|");
            }

            statement.close();

            System.out.println("\n---------------------------------");

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    private void report4() {

        try {
            statement = connection.createStatement();
            String query = "SELECT F16_17_ORDERS.ORDER_ID, F16_17_PERSON.FNAME, F16_17_ORDERS.PAY_TYPE FROM F16_17_ORDERS INNER JOIN F16_17_PERSON ON F16_17_ORDERS.P_SSN=F16_17_PERSON.P_SSN";
            ResultSet r = statement.executeQuery(query);
            System.out.println("\nPAYMENT TYPE OF PERSON FROM ORDERS");
            System.out.println("\n---------------------------------");
            System.out.println("\nORDER_ID | PAY_TYPE");

            while (r.next()) {

                System.out.println("\n|    " + r.getString(1) + "\t     |      " + r.getString(2) + "\t\t|");
            }

            statement.close();

            System.out.println("\n---------------------------------");

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void report3() {

        try {
            statement = connection.createStatement();
            String query = "SELECT F16_17_DELIVERS.SPROD_ID,F16_17_DELIVERS.SPROD_PRICE,F16_17_PRODUCT.PROD_PRICE ,F16_17_PRODUCT.PROD_PRICE-F16_17_DELIVERS.SPROD_PRICE AS PROFIT FROM F16_17_DELIVERS INNER JOIN F16_17_PRODUCT ON F16_17_DELIVERS.SPROD_ID=F16_17_PRODUCT.PROD_ID";
            ResultSet r = statement.executeQuery(query);
            System.out.println("\nTOTAL PROFIT ON THE PRODUCT");
            System.out.println("\n---------------------------------");
            System.out.println("\nSPROD_ID | SPROD_PRICE | PROD_PRICE | PROFIT");

            while (r.next()) {

                System.out.println("\n|    " + r.getString(1) + "\t     |      " + r.getString(2) + "\t     |      " + r.getString(3) + "\t     |      " + r.getString(4));
            }

            statement.close();

            System.out.println("\n---------------------------------");

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void report2() {

        try {
            statement = connection.createStatement();
            String query = "SELECT ORDER_ID,DELIVERY_STATUS,PRODUCT_ID,F16_17_STORES.W_ID FROM (SELECT F16_17_ORDERS.DELIVERY_STATUS AS DELIVERY_STATUS, F16_17_ORDERS.ORDER_ID AS ORDER_ID, F16_17_ORDERS.PROD_ID AS PRODUCT_ID FROM F16_17_ORDERS) DELIVERY INNER JOIN F16_17_STORES ON F16_17_STORES.P_ID=DELIVERY.PRODUCT_ID WHERE DELIVERY_STATUS='NOT DELIVE' GROUP BY PRODUCT_ID,ORDER_ID,DELIVERY_STATUS,F16_17_STORES.W_ID";
            ResultSet r = statement.executeQuery(query);
            System.out.println("\nRETURNED ORDERS BASED ON DELIVERY STATUS AND WAREHOUSE IT HAS BEEN RETURNED TO");
            System.out.println("\n---------------------------------");
            System.out.println("\nORDER_ID | DELIVERY_S | PRODUCT_ID | W_ID");

            while (r.next()) {

                System.out.println("\n|    " + r.getString(1) + "\t     |      " + r.getString(2) + "\t     |      " + r.getString(3) + "\t     |      " + r.getString(4));
            }

            statement.close();

            System.out.println("\n---------------------------------");

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void report1() {

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM (SELECT F16_17_ORDERS.PROD_ID, F16_17_PRODUCT.PROD_NAME FROM F16_17_ORDERS INNER JOIN F16_17_PRODUCT ON F16_17_ORDERS.PROD_ID=F16_17_PRODUCT.PROD_ID GROUP BY F16_17_ORDERS.PROD_ID,F16_17_PRODUCT.PROD_NAME ORDER BY COUNT(*) DESC) WHERE rownum <= 1";
            ResultSet r = statement.executeQuery(query);
            System.out.println("\nMOST PURCHASED ITEM IN ORDERS AND WAREHOUSE WITH LEAST QUANTITY OF THAT PRODUCT");
            System.out.println("\n---------------------------------");
            System.out.println("\nPROD_ID | PROD_NAME");

            while (r.next()) {

                System.out.println("\n|    " + r.getString(1) + "\t     |      " + r.getString(2) + "\t\t|");
            }

            statement.close();

            System.out.println("\n---------------------------------");

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    private void update_table_suppliername(String table, String snamec, String sname, String sidc, int sid) {

        try {
            statement = connection.createStatement();
            statement.executeQuery("UPDATE " + table + " SET " + snamec + " = '" + sname + "' WHERE " + sidc + "=" + sid);

            statement.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void update_table_supplierid(String table, String sidc, int sid, String snamec, String sname) {

        try {
            statement = connection.createStatement();

            statement.executeQuery("UPDATE " + table + " SET " + sidc + " = '" + sid + "' WHERE " + snamec + "= '" + sname + "'");

            statement.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }


    }

    private void delete_from_supplier_on_sid(String table, String sidc, int sid) {

        try {
            statement = connection.createStatement();

            statement.executeQuery("DELETE FROM " + table + " WHERE " + sidc + "=" + sid);

            statement.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    private void display_table_supplier_on_sid(int sid) {

        try {
            statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT * FROM F16_17_SUPPLIER where S_ID = " + sid);
            System.out.println("\n\nS_ID\t\tS_NAME\t\tS_ADDR\t\tS_CONTACT\t\tS_RATING\t\tO_SSN");

            while (r.next()) {

                System.out.println("\n  " + r.getString(1) + "\t" + r.getString(2) + "\t\t" + r.getString(3) + "\t\t" + r.getString(4) + "\t\t" + r.getString(5) + "\t\t" + r.getString(6));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void insert_into_supplier(String table, int sid, String sname, String saddress, int scontact, float srating) {

        try {
            statement = connection.createStatement();

            statement.executeQuery("INSERT INTO " + table + " VALUES(" + sid + ",'" + sname + "','" + saddress + "','" + scontact + "','" + srating + "','100117147')");

            statement.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void display_stores() {

        try {
            statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT * FROM F16_17_STORES");
            System.out.println("\nDisplaying table STORES:");
            System.out.println("\n\nW_ID\t\tP_ID\t\tP_QUANTITY");

            while (r.next()) {

                System.out.println("\n  " + r.getString(1) + "\t\t" + r.getString(2) + "\t\t" + r.getString(3));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void display_orders() {

        try {
            statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT * FROM F16_17_ORDERS");
            System.out.println("\nDisplaying table ORDERS:");
            System.out.println("\n\nP_SSN\t\tPROD_ID\t\tORDER_ID\t\tPAY_TYPE\t\tSHIP_ADDR\t\tDELIVERY_STATUS");

            while (r.next()) {

                System.out.println("\n  " + r.getString(1) + "\t\t" + r.getString(2) + "\t\t" + r.getString(3) + "\t\t" + r.getString(4) + "\t\t" + r.getString(5) + "\t\t" + r.getString(6));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void display_employee() {

        try {
            statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT * FROM F16_17_EMPLOYEE");
            System.out.println("\nDisplaying table EMPLOYEE:");
            System.out.println("\n\nSSN\t\tEMP_ID\t\tSALARY\t\tWARE_ID");

            while (r.next()) {

                System.out.println("\n  " + r.getString(1) + "\t\t" + r.getString(2) + "\t\t" + r.getString(3) + "\t\t" + r.getString(4));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void display_delivers() {

        try {
            statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT * FROM F16_17_DELIVERS");
            System.out.println("\nDisplaying table DELIVERS:");
            System.out.println("\n\nW_ID\t\tS_ID\t\t   DELIVERY_TIME\t\tDELIVERY_TYPE\tSPROD_ID\tSPROD_PRICE\t\tSPROD_QTY");

            while (r.next()) {

                System.out.println("\n  " + r.getString(1) + "\t\t" + r.getString(2) + "\t\t" + r.getString(3) + "\t\t" + r.getString(4) + "\t\t" + r.getString(5) + "\t\t" + r.getString(6) + "\t\t" + r.getString(7));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void display_customer() {

        try {
            statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT * FROM F16_17_CUSTOMER");
            System.out.println("\nDisplaying table CUSTOMER:");
            System.out.println("\n\n      SSN\tCUST_ID");

            while (r.next()) {

                System.out.println("\n  " + r.getString(1) + "\t" + r.getString(2));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void display_warehouse() {

        try {
            statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT * FROM F16_17_WAREHOUSE");
            System.out.println("\nDisplaying table WAREHOUSE:");
            System.out.println("\n\n W_ID\t\tW_CONTACT\t\tW_NAME\t\tW_LOCATION\t\t\tO_SSN");

            while (r.next()) {

                System.out.println("\n  " + r.getString(1) + "\t\t" + r.getString(2) + "\t\t" + r.getString(3) + "\t\t" + r.getString(4) + "\t\t\t" + r.getString(5));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void display_supplier() {

        try {
            statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT * FROM F16_17_SUPPLIER");
            System.out.println("\nDisplaying table SUPPLIER:");
            System.out.println("\n\n  S_ID\t\tS_NAME\t\tS_ADDR\t\t\tS_CONTACT\t\tS_RATING\t\tO_SSN");

            while (r.next()) {

                System.out.println("\n  " + r.getString(1) + "\t\t" + r.getString(2) + "\t\t" + r.getString(3) + "\t\t" + r.getString(4) + "\t\t" + r.getString(5) + "\t\t" + r.getString(6));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void display_product() {

        try {
            statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT * FROM F16_17_PRODUCT");
            System.out.println("\nDisplaying table PRODUCT:");
            System.out.println("\n\nPROD_ID\t\tPROD_PRICE\t\tPROD_NAME\t\tRATING");

            while (r.next()) {

                System.out.println("\n  " + r.getString(1) + " \t\t" + r.getString(2) + "\t\t\t" + r.getString(3) + "\t\t" + r.getString(4));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    private void display_person() {

        try {
            statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT * FROM F16_17_PERSON");
            System.out.println("\nDisplaying table PERSON:");
            System.out.println("\n\n  P_SSN\t\t\tFNAME\t\tMNAME\t\tLNAME\t\tDOB\t\tPHY_ADDR\t\tCONTACT");

            while (r.next()) {

                System.out.println("\n  " + r.getString(1) + "\t\t" + r.getString(2) + "\t\t" + r.getString(3) + "\t\t" + r.getString(4) + "\t\t" + r.getString(5) + "\t\t" + r.getString(6) + "\t\t" + r.getString(7));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void display_owner() {

        try {

            statement = connection.createStatement();
            ResultSet r = statement.executeQuery("SELECT * FROM F16_17_OWNER");
            System.out.println("\nDisplaying table OWNER:");
            System.out.println("\n\n  O_SSN\t\tO_CONTACT\t\tO_NAME\t\tO_ADDRESS");

            while (r.next()) {

                System.out.println("\n  " + r.getString(1) + "\t\t" + r.getString(2) + "\t\t" + r.getString(3) + "\t\t" + r.getString(4));
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }


}
