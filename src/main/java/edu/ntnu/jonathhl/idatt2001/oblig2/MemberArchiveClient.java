package edu.ntnu.jonathhl.idatt2001.oblig2;

/**
 * The client class for the different membership classes.
 * @author Jonathan Løseth
 * @version 1.0.0
 * @since 1.0.0
 */
public class MemberArchiveClient {

    public static void main(String[] args) {
        MemberArchive memberArchive = new MemberArchive();
        memberArchive.fillRegisterWithTestdata();
        memberArchive.listAllMembers();

        System.out.println("Registering some points to all members:");

        System.out.println("Adding 90000 points to membernumber 1...");
        memberArchive.registerPoints(1, 90000);
        System.out.println("\n");

        System.out.println("Adding 50000 points to membernumber 2...");
        memberArchive.registerPoints(2, 50000);
        System.out.println("\n");

        System.out.println("Adding 5000 points to membernumber 3...");
        memberArchive.registerPoints(3, 5000);
        System.out.println("\n");

        System.out.println("Adding 15000 points to membernumber 4...");
        memberArchive.registerPoints(4, 15000);
        System.out.println("\n");

        System.out.println("Adding 30000 points to membernumber 5...");
        memberArchive.registerPoints(5, 30000);

        System.out.println("Printing out the current register...\n");
        memberArchive.listAllMembers();

    }
}
