package edu.ntnu.jonathhl.idatt2001;

public class silverMembership extends membership {


    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        final float POINTS_SCALING_FACTOR = 1.2f;
        return Math.round(bonusPointBalance + (newPoints * POINTS_SCALING_FACTOR));
    }

    @Override
    public String getMembershipName() {
        return "Silver Membership";
    }
}
