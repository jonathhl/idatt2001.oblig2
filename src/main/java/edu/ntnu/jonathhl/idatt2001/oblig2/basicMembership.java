package edu.ntnu.jonathhl.idatt2001.oblig2;

/**
 * Class to keep most memberships info. The basic memberships.
 * @author Jonathan Løseth
 * @version 1.0.0
 * @since 1.0.0
 */
public class basicMembership extends membership {

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        return bonusPointBalance += newPoints;
    }

    @Override
    public String getMembershipName() {
        return "Basic membership";
    }
}
