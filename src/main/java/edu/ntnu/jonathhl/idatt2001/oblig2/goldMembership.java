package edu.ntnu.jonathhl.idatt2001.oblig2;

/**
 * Class to calculate the scaling of points earned inside the gold membership.
 * @author Jonathan Løseth
 * @version 1.0.0
 * @since 1.0.0
 */
public class goldMembership extends membership {

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        final float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
        final float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

        if(bonusPointBalance < 90000) {
            return Math.round(bonusPointBalance + (newPoints * POINTS_SCALING_FACTOR_LEVEL_1));
        } else {
            return Math.round(bonusPointBalance + (newPoints * POINTS_SCALING_FACTOR_LEVEL_2));
        }
    }

    @Override
    public String getMembershipName() {
        return "Gold membership";
    }
}
