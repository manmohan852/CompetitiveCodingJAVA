package site.interview.dunjo;

import java.util.*;

public class FoorballScores {

    public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
        Collections.sort(teamA);
        List<Integer> teamBCopy = new ArrayList<>(teamB);
        Collections.sort(teamB);
        int pivot = 0;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> goalVSScore = new HashMap<>();

        for (int j = 0; j < teamB.size(); j++) {
            for (int i = pivot; i < teamA.size(); i++) {
                if (teamB.get(j) >= teamA.get(i)) {
                    pivot++;
                }
            }
            goalVSScore.put(teamB.get(j), pivot);
        }
        for (Integer goal : teamBCopy) {
            Integer score = goalVSScore.get(goal);
            ans.add(score);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> teamA = new ArrayList<>(Arrays.asList(2, 10, 5, 4, 8));
        List<Integer> teamB = new ArrayList<>(Arrays.asList(3, 1, 7, 8));

        counts(teamA, teamB);

    }
}
