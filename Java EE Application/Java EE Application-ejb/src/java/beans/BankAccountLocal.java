/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author reube
 */
@Local
public interface BankAccountLocal {
    public boolean createAccount(int accountID, int branchID, float balance) throws ClassNotFoundException, SQLException;
    public Account lookupAccount(int accountID) throws SQLException, ClassNotFoundException;
}
