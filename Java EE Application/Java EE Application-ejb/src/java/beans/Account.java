/**
 * This class is a bean representing a bank account.
 * Includes getters and setters for all bank account attributes.
 *
 * @author Reuben Palmer 1378847, Alex Alnaib 14874604
 *
 */
package beans;

import java.io.Serializable;

public class Account implements Serializable {

    private int accountID;
    private int branchID;
    private float balance;

    public Account() {

    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
