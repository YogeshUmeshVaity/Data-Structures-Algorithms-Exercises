package com.company;

import java.util.LinkedList;

/**
 * Implement a recursive approach to showing all the teams that can be created
 * from a group (n things taken k at a time). Write the recursive showTeams()
 * method and a main() method to prompt the user for the group size and the
 * team size to provide arguments for showTeam(), which then displays all the
 * possible combinations.
 */
public class TeamMaker {
    LinkedList<Character> sequence = new LinkedList<>();

    // Starting character representing a member in a group.
    char groupMember = 'A';

    public void showTeams(int groupSize, int teamSize) {
        recurseShowTeams(groupSize, teamSize, teamSize - 1);
    }

    private void recurseShowTeams(int groupSize,
                                 int teamSize, int validNode) {
        // Base cases
        if (groupSize == 0 || teamSize == 0 || teamSize > groupSize) return;

        // Whenever you make a call to a left term, you record the node
        // you’re leaving by adding its letter to a sequence.
        sequence.add(groupMember);
        groupMember++;
        recurseShowTeams(groupSize - 1, teamSize - 1, validNode); // left call
        sequence.removeLast();

        // When you make calls to right, check if adding one member will
        // complete the team, then add the node to the sequence and display.
        if(sequence.size() == validNode) {
            sequence.add((char)(groupMember - 1));
            System.out.println(sequence);
            sequence.removeLast();
        }
        recurseShowTeams(groupSize - 1, teamSize, validNode);     // Right call

        //You’ll need to role the sequence back up as you return.
        groupMember--;
    }
}
