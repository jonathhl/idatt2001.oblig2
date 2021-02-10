package edu.ntnu.jonathhl.idatt2001.oblig2;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * The member archive holds all the bonus members. The archive provides
 * functionality for adding members to the register, looking up bonuspoints
 * of given members, registering new bonuspoints and listing all the members.
 *
 * @author arne
 */
public class MemberArchive {

    // Use a HashMap, since the members have a unique member number.
    private HashMap<Integer, bonusMember> members;

    /**
     * Creates a new instance of MemberArchive.
     */
    public MemberArchive() {
        this.members = new HashMap<>();
        this.fillRegisterWithTestdata();
    }

    /**
     * Method to add a new member to the HashMap. The method checks if any members are already registered with the
     * specified member number.
     * @param BonusMember Key number for all members specified. Checks if it is already registered.
     * @return Returns and adds a new member.
     */
    public int addMember(bonusMember BonusMember) {
        if(members.containsKey(BonusMember.getMemberNumber())) {
            return -1;
        }
        members.put(BonusMember.getMemberNumber(), BonusMember);
        return BonusMember.getMemberNumber();
    }

    /**
     * Method to find the amount of points a specified member has registered in their name.
     * @param memberNumber Key number for the specified member.
     * @param password The method checks through the entered password if it corresponds to the registered password.
     * @return Returns an integer value, in the form of points.
     * @throws Exception
     */
    public int findPoints(int memberNumber, String password) {
        if(!members.containsKey(memberNumber) || !(members.get(memberNumber).checkPassword(password))) {
            return -1;
        }
        return members.get(memberNumber).getBonusPointsBalance();
    }

    /**
     * Method to register additional points to an existing member.
     * @param memberNumber Key number for the specified member.
     * @param bonusPoints Additional points to be added.
     * @return {@code true} if member number is registered.
     *         {@code false} if method does not find any member with the entered number key.
     * @throws Exception if method returns false, and gives an error message to the console.
     */
    public boolean registerPoints(int memberNumber, int bonusPoints) {
        if(members.containsKey(memberNumber)) {
            members.get(memberNumber).registerBonusPoints(bonusPoints);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prints out a list of all registered members.
     */
    public void listAllMembers() {
        for (bonusMember BonusMember : members.values()) {
            System.out.println(BonusMember.toString());
        }
    }


    /**
     * Some example members for testing the code.
     */
    protected void fillRegisterWithTestdata() {
        bonusMember member = new bonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz", "password1");
        this.members.put(member.getMemberNumber(), member);
        member = new bonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz", "password2");
        this.members.put(member.getMemberNumber(), member);
        member = new bonusMember(3, LocalDate.now(), 5000, "Lie, Linda", "linda@lie.no", "password3");
        this.members.put(member.getMemberNumber(), member);
        member = new bonusMember(4, LocalDate.now(), 30000, "Paulsen, Paul", "paul@paulsen.org", "password4");
        this.members.put(member.getMemberNumber(), member);
        member = new bonusMember(5, LocalDate.now(), 75000, "FLo, Finn", "finn.flo@gmail.com", "password5");
        this.members.put(member.getMemberNumber(), member);

    }
}

