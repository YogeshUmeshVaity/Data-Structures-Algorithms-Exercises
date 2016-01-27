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
    private char[] group = {'A', 'B', 'C', 'D', 'E'};
    LinkedList<Character> team = new LinkedList<>();
    LinkedList<Character> sequenceLeavingLeft = new LinkedList<>();

    public void showTeams(int groupSize, int teamSize, boolean leftCall) {
        // Base cases
        if (groupSize == 0
                || teamSize == 0
                || teamSize > groupSize) {
            return;
        }

        // Whenever you make a call to a left term, you record the node
        // you’re leaving by adding its letter to a sequence.
        if (leftCall) {
            sequenceLeavingLeft.add(group[group.length - groupSize]);
        }

        // You displayTeam team only in right calls, if you are at a valid node
        // and adding one member will complete the team.
        if(!leftCall) {
                sequenceLeavingLeft.add(group[group.length - groupSize]);
                System.out.print(sequenceLeavingLeft);
                sequenceLeavingLeft.removeLast();
        }

        // Recursion
        showTeams(groupSize - 1, teamSize - 1, true); // left call
        showTeams(groupSize - 1, teamSize, false);     // Right call
    }

    public void displayTeam() {
        System.out.println(team);
    }

}
