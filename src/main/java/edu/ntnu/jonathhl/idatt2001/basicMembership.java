package edu.ntnu.jonathhl.idatt2001;

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
