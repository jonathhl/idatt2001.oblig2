package edu.ntnu.jonathhl.idatt2001.oblig2;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;

/**
 * Test class aimed towards the class MemberArchive.java
 * @author Jonathan Løseth
 * @version 1.0.0
 */
public class MemberArchiveTest {

    @Test
    @DisplayName("Adding a member works as it should")
    public void addingAMemberWorksAsItShould() {
        MemberArchive ma = new MemberArchive();
        ma.addMember(new bonusMember(1, LocalDate.now(), 0, "test", "eMail", "password"));
        assert ma.findPoints(1, "password") == -1;
    }

    @Test
    @DisplayName("Find points works at it should")
    public void findPointsWorksAsItShould() {
        MemberArchive ma = new MemberArchive();
        ma.addMember(new bonusMember(1, LocalDate.now(), 0, "test", "eMail", "password"));
        assert ma.findPoints(1, "password") == -1;
    }
}
