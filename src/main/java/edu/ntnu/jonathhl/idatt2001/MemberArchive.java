package edu.ntnu.jonathhl.idatt2001;

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
     * Adds a new member to the register. The new member must have a memebr number
     * different from exsisting members. If not, the new member will not be added.
     *
     * @return {@code true} if the new member was added successfully,
     *         {@code false} if the new member could not be added, due to a
     *          membernumber that allready exsists.
     */
    public boolean addMember(bonusMember bonusMember) {
        boolean success = false;
        //TODO: Fill in your solution
        for (int i = 0; i < members.size(); i++) {
            if(members.containsKey())
        }
        return success;
    }


    public int findPoints(int memberNumber, String password) throws Exception {
        int pointBalance = 0;
        for (int i = 0; i < members.size(); i++) {
            if(members.containsKey(memberNumber) && members.containsValue(password)) {
                pointBalance += members.get(i).getBonusPointsBalance();
            } else {
                throw new RuntimeException("Either the member is not registered, or the password is wrong.");
            }
        }
        return pointBalance;
    }

    /**
     * Registers new bonuspoints to the member with the member number given
     * by the parameter {@code memberNumber}. If no member in the register
     * matches the provided member number, {@code false} is returned.
     *
     * @param memberNumber the member number to add the bonus points to
     * @param bonusPoints the bonus points to be added
     * @return {@code true} if bonuspoints were added successfully,
     *         {@code false} if not.
     */
    public boolean registerPoints(int memberNumber, int bonusPoints) throws Exception {
        boolean success = false;
        //TODO: Test code
        for (int i = 0; i < members.size(); i++) {
            if(members.containsKey(memberNumber)) {
                int updatedPointBalance = members.get(i).getBonusPointsBalance() + bonusPoints;
                success = true;
            } else {
                throw new RuntimeException("Something went wrong, the points were not added.");
            }
        }
        return success;
    }

    /**
     * Lists all members to the console.
     */
    public void listAllMembers() {
        //TODO: Fill in your solution
    }


    /**
     * Fills the register with some arbitrary members, for testing purposes.
     */
    private void fillRegisterWithTestdata() {
        bonusMember member = new bonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz");
        this.members.put(member.getMemberNumber(), member);
        member = new bonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz");
        this.members.put(member.getMemberNumber(), member);
        member = new bonusMember(3, LocalDate.now(), 5000, "Lie, Linda", "linda@lie.no");
        this.members.put(member.getMemberNumber(), member);
        member = new bonusMember(4, LocalDate.now(), 30000, "Paulsen, Paul", "paul@paulsen.org");
        this.members.put(member.getMemberNumber(), member);
        member = new bonusMember(5, LocalDate.now(), 75000, "FLo, Finn", "finn.flo@gmail.com");
        this.members.put(member.getMemberNumber(), member);

    }



}

