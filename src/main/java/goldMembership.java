public class goldMembership extends membership {

    private float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
    private float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        return bonusPointBalance += newPoints;
    }

    @Override
    public String getMembershipName() {
        return "Gold membership";
    }

}
