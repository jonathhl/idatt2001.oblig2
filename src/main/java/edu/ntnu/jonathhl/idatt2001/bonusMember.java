package edu.ntnu.jonathhl.idatt2001;

import java.time.LocalDate;

public class bonusMember {

    private int memberNumber;
    private LocalDate enrolledDate;
    private int bonusPointsBalance = 0;
    private String name;
    private String eMailAddress;
    private String password;

    // Named every .java with a lowercase letter in the start. Switching it up here from the task-description.
    private membership Membership;

    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

    public bonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name,
                       String eMailAddress) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPointsBalance;
        this.name = name;
        this.eMailAddress = eMailAddress;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    public String getName() {
        return name;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public String getPassword() {
        return password;
    }

    public membership getMembership() {
        return Membership;
    }

    public static int getSilverLimit() {
        return SILVER_LIMIT;
    }

    public static int getGoldLimit() {
        return GOLD_LIMIT;
    }

    public boolean checkPassword(String password) {
        if(password.equals(getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public void registerBonusPoints(int newPoints) {
        Membership.registerPoints(bonusPointsBalance, newPoints);
    }

    public void checkAndSetMembership() {
        if(bonusPointsBalance >= SILVER_LIMIT && !(Membership instanceof silverMembership)) {
            Membership = new silverMembership();
        } else if(bonusPointsBalance >= GOLD_LIMIT && !(Membership instanceof goldMembership)) {
            Membership = new goldMembership();
        }
    }

    public String getMembershipLevel() {
        return Membership.getMembershipName();
    }

    @Override
    public String toString() {
        return "bonusMember{" +
                "memberNumber=" + memberNumber +
                ", enrolledDate=" + enrolledDate +
                ", bonusPointsBalance=" + bonusPointsBalance +
                ", name='" + name + '\'' +
                ", eMailAddress='" + eMailAddress + '\'' +
                ", password='" + password + '\'' +
                ", Membership=" + Membership +
                '}';
    }


}
