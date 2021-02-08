package edu.ntnu.jonathhl.idatt2001.oblig2;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;

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
        assert bm.getMembershipLevel().equals("Silver membership");
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
        assert bm.getMembershipLevel().equals("Silver membership");
    }

    @Test
    @DisplayName("Password has to match for access")
    public void memberPasswordHasToMatchToGetAccess() throws Exception {
        MemberArchive ma = new MemberArchive();
        ma.addMember(new bonusMember(1, LocalDate.now(), 0, "Name", "eMail", "password"));
        assert ma.findPoints(1, "password") == -1;
    }
}
