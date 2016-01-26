package com.company;

import java.util.ArrayList;

/**
 * Created by try on 26/1/16.
 */
public class TeamMaker {

    int char[] group = { 'A', 'B', 'C', 'D', 'E'};

    public void showTeams(int groupSize, int teamSize, boolean leftCall) {
        // Base cases
        if (groupSize == 0
                || teamSize == 0
                || teamSize > groupSize
                || (groupSize == 1 && teamSize == 1)) {
            return;
        }
        ArrayList<Character> team = new ArrayList<>();
        team.add(group[groupSize - teamSize])
        // You display team only in right calls, if you are at a valid node
        // and adding one member will complete the team.
        if(!leftCall && (team.size() == 3)) {
            System.out.print(team);
        }
        // Recursion
        showTeams(groupSize - 1, teamSize - 1, true); // left call
        showTeams(groupSize - 1, teamSize, false);     // Right call

    }
}
