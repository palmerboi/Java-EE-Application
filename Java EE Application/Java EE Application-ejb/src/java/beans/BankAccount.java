/**
 * This class is a EJB that represents a bank account and has methods to retrieve
 * accounts, bank branches and create bank accounts.
 * 
 * @author Reuben Palmer
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.ejb.Stateless;


@Stateless
public class BankAccount implements BankAccountLocal {

    private final String dbDriver = "org.apache.derby.jdbc.ClientDriver";
    private final String dbUrl = "jdbc:derby://localhost:1527/DMSASS2DB";
    private final String username = "dms";
    private final String password = "dms2018";
    
    @Override
    public boolean createAccount(int accountID, int branchID, float balance) throws SQLException, ClassNotFoundException {
        Class.forName(dbDriver);
        Connection connection = DriverManager.getConnection(dbUrl, username, password);
        Statement statement = connection.createStatement();
        String command = "INSERT INTO BANK_ACCOUNT VALUES (" + accountID +
                ", " + branchID + ", " + balance + ")";
        int result = statement.executeUpdate(command);
        connection.close();
        boolean created;
        if (result == 1) {
            created = true;
        }
        else {
            created = false;
        }
        return created;
    }

    @Override
    public Account lookupAccount(int accountID) throws SQLException, ClassNotFoundException {
        Class.forName(dbDriver);
        Connection connection = DriverManager.getConnection(dbUrl, username, password);
        Statement statement = connection.createStatement();
        String command = "SELECT * FROM BANK_ACCOUNT WHERE BANK_ACCOUNT.accountID = "+ accountID ;
        ResultSet resultSet = statement.executeQuery(command);
        Account account = new Account();
        while (resultSet.next()) {
            account.setAccountID(resultSet.getInt("accountID"));
            account.setBranchID(resultSet.getInt("branchID"));
            account.setBalance(resultSet.getFloat("balance"));
        }
        connection.close();
        return account;
    }

 
}
