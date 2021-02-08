package edu.ntnu.jonathhl.idatt2001.oblig2;

import java.time.LocalDate;

/**
 * class to keep info about each member. It also contains a constructor, and getters. It also contains some methods
 * to check status on different members, as well as updating the amount of points each member has.
 * @author Jonathan Løseth
 * @version 1.0.0
 * @since 1.0.0
 */
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

    /**
     * A constructor.
     * @param memberNumber
     * @param enrolledDate
     * @param bonusPointsBalance
     * @param name
     * @param eMailAddress
     */
    public bonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name,
                       String eMailAddress, String password) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPointsBalance;
        this.name = name;
        this.eMailAddress = eMailAddress;
        this.password = password;

        checkAndSetMembership();
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

    /**
     * Method to check if the password entered corresponds with the one registered.
     * @param password
     * @return
     */
    public boolean checkPassword(String password) {
        if(password.equals(getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to register new points, and update them. The method also updates the membership status if the points go
     * over the differenth thresholds.
     * @param newPoints
     */
    public void registerBonusPoints(int newPoints) {
        bonusPointsBalance = Membership.registerPoints(bonusPointsBalance, newPoints);
        checkAndSetMembership();
    }

    /**
     * Here is the exact method to actually "promote" a membership status.
     */
    public void checkAndSetMembership() {
        if(bonusPointsBalance >= GOLD_LIMIT && !(Membership instanceof goldMembership)) {
            Membership = new goldMembership();
        } else if(bonusPointsBalance >= SILVER_LIMIT && !(Membership instanceof silverMembership)) {
            Membership = new silverMembership();
        } else if(!(Membership instanceof basicMembership)) {
            Membership = new basicMembership();
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
