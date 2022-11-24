package site.interview.amazon;

import java.util.*;

//https://leetcode.com/problems/analyze-user-website-visit-pattern/
public class AnalyzeUserWebsiteVisitPattern {

    class Event {
        public String user;
        public String website;
        public int timestamp;

        public Event(String username, String website, int timestamp) {
            this.user = username;
            this.website = website;
            this.timestamp = timestamp;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // Create a list of all Events
        List<Event> eventList = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            Event event = new Event(username[i], website[i], timestamp[i]);
            eventList.add(event);
        }
        //Sort the events based on timestamp no matter the user
        Collections.sort(eventList, (v1, v2) -> v1.timestamp - v2.timestamp);

        //create a map for user to the list of websites he visited
        Map<String, List<String>> userToWebsiteMap = new HashMap<>();
        for (Event event : eventList) {
            List<String> websites = userToWebsiteMap.getOrDefault(event.user, new ArrayList<>());
            websites.add(event.website);
            userToWebsiteMap.put(event.user, websites);
        }

        //create a map of all possible sequences to their frequencies
        Map<String, Integer> sequenceToFrequencyMap = new HashMap<>();
        for (List<String> websites : userToWebsiteMap.values()) {
            if (websites.size() < 3) continue;
            Set<String> sequences = getAllSequencesFromList(websites);
            for (String sequence : sequences) {
                sequenceToFrequencyMap.put(sequence, sequenceToFrequencyMap.getOrDefault(sequence, 0) + 1);
            }
        }

        int max = 0;
        String res = "";
        // retrieve the max frequency
        for (Map.Entry<String, Integer> entry : sequenceToFrequencyMap.entrySet()) {

            if (max < entry.getValue()) {
                max = entry.getValue();
                res = entry.getKey();
            } else if (max == entry.getValue()) {
                res = res.compareTo(entry.getKey()) > 0 ? entry.getKey() : res;
            }
        }
        return Arrays.asList(res.split(" "));
    }

    public Set<String> getAllSequencesFromList(List<String> websites) {
        Set<String> sequences = new HashSet<>();
        for (int i = 0; i < websites.size() - 2; i++) {
            for (int j = i + 1; j < websites.size() - 1; j++) {
                for (int k = j + 1; k < websites.size(); k++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(websites.get(i)).append(" ").append(websites.get(j)).append(" ").append(websites.get(k));
                    sequences.add(sb.toString());
                }
            }
        }
        return sequences;
    }
}