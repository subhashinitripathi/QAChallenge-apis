package com.automation.AutomationQAChallenge_apis.QAChallenge_apis.conguration.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	private Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement preparedStatement;

    /**
     * This method provides connection to any database.
     * 
     * @param server The address of the server to connect to.
     * @param instance The instance to connect to on server.
     * @param userName The database user name.
     * @param password The database password.
     * @return Object of class DBConnector that wraps the connection to the database.
     * @throws Exception
     */
    public static DBConnection setupDB(String server, String instance, String userName, String password) throws Exception {
        String connectionURL = "jdbc:jtds:sqlserver://" + server + ";databaseName=" + instance + ";user=" + userName + ";password="
                + password + ";";
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        try {
            DBConnection dbConn = new DBConnection();
            dbConn.conn = DriverManager.getConnection(connectionURL);
            return dbConn;
        } catch (Exception e) {
            Exception ee = new Exception(e.getMessage() + " Full connection URL: '" + connectionURL + "'.");
            ee.setStackTrace(e.getStackTrace());
            throw ee;
        }
    }
    

    /**
     * This method executes the given SQL statement, which returns a single ResultSet object.
     * 
     * @param query SQL statement to be sent to the database, typically a static SQL SELECT statement.
     * @return resultSet object
     * @throws SQLException if a database access error occurs, the Statement is closed or the given SQL statement produces anything other
     *             than a single ResultSet object.
     */

    public ResultSet executeQuery(String query) throws SQLException {
        stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery(query);
        return results;
    }



    /**
     * This method executes the given SQL statement and indicates the form of the first result.
     * 
     * @param query SQL statement to be sent to the database, typically a static SQL SELECT statement.
     * @return true if the first result is a ResultSet object; false if it is an update count or there are no results.
     * @throws SQLException if a database access error occurs or the Statement is closed.
     */
    public boolean execute(String query) throws SQLException {
        stmt = conn.createStatement();
        boolean result = stmt.execute(query);
        return result;
    }


    /**
     * This method executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE statement or an SQL statement that returns
     * nothing, such as an SQL DDL statement.
     * 
     * @param query SQL statement to be sent to the database.
     * @return either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing.
     * @throws SQLException if a database access error occurs or the Statement is closed.
     */
    public int executeUpdate(String query) throws SQLException {
        stmt = conn.createStatement();
        int result = stmt.executeUpdate(query);
        return result;
    }


    /**
     * This method executes prepared statements and take parameters in the same order as are placeholders (?) which will be replaced in the
     * query.
     * 
     * @param query sql statement(can be with placeholder (?)) to be executed.
     * @param parameters
     * @return resultSet object
     * @throws SQLException if a database access error occurs; this method is called on a closed PreparedStatement or the SQL statement does
     *             not return a ResultSet object
     */
    public ResultSet executePreparedStatement(String query, Object... parameters) throws SQLException {
        preparedStatement = conn.prepareStatement(query);
        int index = 1;
        if (parameters != null) {
            for (Object object : parameters) {
                preparedStatement.setObject(index++, object);
            }
        }
        return preparedStatement.executeQuery();
    }
 
  }
