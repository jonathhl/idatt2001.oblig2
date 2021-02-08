package edu.ntnu.jonathhl.idatt2001.oblig2;

/**
 * Abstract class to keep the methods "registerPoints" and "getMembershipName". The class is used to calculate the
 * details on a users edu.ntnu.jonathhl.idatt2001.membership.
 * @author Jonathan Løseth
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class membership {

    public abstract int registerPoints(int bonusPointBalance, int newPoints);

    public abstract String getMembershipName();
}
