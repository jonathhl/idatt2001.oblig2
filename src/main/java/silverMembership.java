public class silverMembership extends membership{

    private float POINTS_SCALING_FACTOR = 1.2f;

    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        return bonusPointBalance += newPoints;
    }

    @Override
    public String getMembershipName() {
        return "Silver Membership";
    }
}
