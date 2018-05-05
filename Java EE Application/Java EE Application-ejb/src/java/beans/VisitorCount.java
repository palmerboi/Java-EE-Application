/*
 * Simple singleton bean that counts the number of times a visitor has gone on the site
 * increments by 1 each time.
 */
package beans;

import javax.ejb.Singleton;

/**
 *
 * @author Reuben Palmer 1378847, Alex Alnaib 14874604
 */
@Singleton
public class VisitorCount implements VisitorCountRemote {

    @Override
    public int countVisitor(int value) {
        value = value + 1;
        return value;
    }
}
