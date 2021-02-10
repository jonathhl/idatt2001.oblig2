package edu.ntnu.jonathhl.idatt2001.oblig2;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;

/**
 * Test class aimed towards the class bonusMember.java
 * @author Jonathan Løseth
 * @version 1.0.0
 */
@DisplayName("Test - BonusMember")
public class BonusMemberTest {

    @Test
    @DisplayName("Check new members start basic")
    public void newMemberBasicMembershipTest() {
        bonusMember bm = new bonusMember(1, LocalDate.now(), 0, "Name", "test@test.no", "password");
        assert bm.getMembershipLevel().equals("Basic membership");
    }

    @Test
    @DisplayName("Check changes to silver at right threshold")
    public void checkUpgradeToSilverAtThreshold() {
        bonusMember bm = new bonusMember(1, LocalDate.now(), 0, "Name", "test@test.no", "password");
        bm.registerBonusPoints(25000);
        assert bm.getMembershipLevel().equals("Silver Membership");
    }

    @Test
    @DisplayName("Check that membership doesn't change before silver limit")
    public void checkMembershipDoesntChangeBeforeSilverLimit() {
        bonusMember bm = new bonusMember(1, LocalDate.now(), 0, "Name", "test@test.no", "password");
        bm.registerBonusPoints(24999);
        assert bm.getMembershipLevel().equals("Basic membership");
    }

    @Test
    @DisplayName("Check changes to gold at right threshold")
    public void checkUpgradeToGoldAtThreshold() {
        bonusMember bm = new bonusMember(1, LocalDate.now(), 0 ,"Name", "test@test.no", "password");
        bm.registerBonusPoints(75000);
        assert bm.getMembershipLevel().equals("Gold membership");
    }

    @Test
    @DisplayName("Check that membership doesn't change before gold limit")
    public void checkMembershipDoesntChangeBeforeGoldLimit() {
        bonusMember bm = new bonusMember(1, LocalDate.now(), 0, "Name", "test@test.no", "password");
        bm.registerBonusPoints(74999);
        assert bm.getMembershipLevel().equals("Silver Membership");
    }

    @Test
    @DisplayName("Wrong password does not give access")
    public void wrongPasswordDoesNotGiveAccess() {
        MemberArchive ma = new MemberArchive();
        ma.addMember(new bonusMember(1, LocalDate.now(), 0, "Name", "eMail", "password"));
        assert ma.findPoints(1, "hei") == -1;
    }

    @Test
    @DisplayName("Right password gives access")
    public void rightPasswordGivesAccess() {
        MemberArchive ma = new MemberArchive();
        ma.addMember(new bonusMember(1, LocalDate.now(), 0, "Name", "eMail", "password"));
        assert ma.findPoints(1, "password") == -1;
    }
}
