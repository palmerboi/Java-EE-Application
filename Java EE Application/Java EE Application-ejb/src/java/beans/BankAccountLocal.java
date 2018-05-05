/*
 * Local Interface for the BankAccount bean
 */
package beans;

import java.sql.SQLException;
import javax.ejb.Local;

/**
 *
 * @author Reuben Palmer 1378847, Alex Alnaib 14874604
 */
@Local
public interface BankAccountLocal {

    public boolean createAccount(int accountID, int branchID, float balance) throws ClassNotFoundException, SQLException;

    public Account lookupAccount(int accountID) throws SQLException, ClassNotFoundException;
}
