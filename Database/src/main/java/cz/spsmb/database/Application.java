package cz.spsmb.database;

import java.sql.*;
import java.util.Scanner;

public class Application {

    //HW zjistit, jestli tam bude mysql driver v projektu

    // SELECT, UPDATE, DELETE, INSERT
    // PRIMARY KEY, FOREIGN KEY
    // Constraints
    // Co jsou joiny
    // Jakým způsobem se připoji
    // SQL injection


    // Kardinalita 1:1, 1:m, m:n
    // Trigger nebo procedurách
    // Index


    /**
     *  asdfasdlfk asdlfkjasldffad slajksd flkjalskdjflk <b>asdfasdf</b>
     *
     * @param statement - Sql statement
     * @param userName -
     * @throws SQLException -
     * @return returns true if user was created.
     */
    public static boolean createUser(Statement statement, String userName) throws SQLException {
        String query = String.format("INSERT INTO `users`(`name`) VALUES (\"%s\")", userName);
        System.out.println(query);
        statement.execute(query);
        Math.pow(12,2);
        return true;
    }

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/spsmb", "root", "toor");
        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadej jmeno:");
        String name = scanner.nextLine();
        printUserInfo(statement, name);
    }

    private static void printUserInfo(Statement statement, String name) throws SQLException {
        // select * from users where name = "" or 1=1 or name="" --> SQL INJECTION
        ResultSet resultSet = statement.executeQuery("select * from users where name = \"" + name + "\"");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
        }
    }

    private static void deleteUserById(Statement statement, int i) {
        String query = "delete from users where id = %s";
    }
}
