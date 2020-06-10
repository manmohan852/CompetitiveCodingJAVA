package site.interview.techmojo;

import java.util.*;

public class TrendingHashtagTwitter {

    //Data Structure to store HashTags vs their count[no of times they occur in all tweets]
    public static Map<String, Integer> hashTagCountMap;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of Tweets to analyse:");
        String n = s.nextLine();
        Integer noOfTweets = Integer.parseInt(n);
        int noOfTopTweetsToPrint = 10;
        hashTagCountMap = new HashMap<>();

        System.out.println("Enter " + noOfTweets + " Tweets in different lines:");
        for (int i = 0; i < noOfTweets; i++) {
            String str = s.nextLine();
            findAndUpdateCountHashTags(str);
        }

        ArrayList<Pair> v = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hashTagCountMap.entrySet()) {
            v.add(new Pair(entry.getValue(), entry.getKey()));
        }
        Collections.sort(v, new PairComparator());
        System.out.println();

        System.out.println("Printing Top Trending Tweets :");
        for (int i = 0; i < v.size() && i < noOfTopTweetsToPrint; i++) {
            System.out.println(v.get(i).hashTag);
        }
    }

    public static void test(String[] args) {
        int noOfTopTweetsToPrint = 3;
        hashTagCountMap = new HashMap<>();
        List<String> tweets = new ArrayList<>();
        tweets.add("Made with only #natural ingredients, #ChobaniKids Greek Yogurt");
        tweets.add("A Super Easy Slow #Cooker #Moroccan #Chicken #Tagine https://bit.ly/2GrfMRI #dairyfree #Kids");
        tweets.add("account #represents my #views only, #not #those of any #org | she/her/hers | #DoctorsLog #Health");
        tweets.add("#Seeing off the 1st batch of stranded #Indians on their repatriation to India under #VandeBharatMission. @airindiain #Kids");
        tweets.add("#account represents my #views only, not #those of any #org | she/her/hers | #DoctorsLog #Log #Kids");
        tweets.add("account represents my views only, not those of any org | she/her/hers | #DoctorsLog #Log");
        tweets.add("account represents my views only, not those of any org | she/her/hers | #DoctorsLog #Log");

        for (int i = 0; i < tweets.size(); i++) {
            String str = tweets.get(i);
            findAndUpdateCountHashTags(str);
        }
        ArrayList<Pair> v = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hashTagCountMap.entrySet()) {
            v.add(new Pair(entry.getValue(), entry.getKey()));
        }
        Collections.sort(v, new PairComparator());
        System.out.println();

        System.out.println("Printing Top Trending Tweets :");
        for (int i = 0; i < v.size() && i < noOfTopTweetsToPrint; i++) {
            System.out.println(v.get(i).hashTag);
        }
    }

    //Method to find hashtags in tweet and update its count in a map
    public static void findAndUpdateCountHashTags(String str) {
        int index = 0;
        int sz = str.length();
        while (index < sz) {
            if (str.charAt(index) == '#') {
                String hashString = "";
                while (index < sz && str.charAt(index) != ' ') {
                    hashString += str.charAt(index);
                    index++;
                }
                if (!hashString.isEmpty()) {
                    hashString = hashString.toLowerCase(); //assuming hashtags in tweets are not case sensitive
                    if (hashTagCountMap.containsKey(hashString)) {
                        Integer count = hashTagCountMap.get(hashString);
                        hashTagCountMap.put(hashString, count + 1);
                    } else {
                        hashTagCountMap.put(hashString, 1);
                    }
                }
            } else {
                index++;
            }
        }
    }

    //custom comparator to sort hashtags based on their count in descending order,
    // if two tweets have same count, then they are sorted lexicographically[alphabetically]
    public static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            if (p1.count != p2.count) {
                return p2.count - p1.count; //descending order by count
            }
            return p1.hashTag.compareTo(p2.hashTag); //ascending order by hashTag String
        }
    }

    //class to keep hashtags and their count bind together as a single unit
    public static class Pair {
        Integer count;
        String hashTag;

        public Pair(Integer count, String hashTag) {
            this.count = count;
            this.hashTag = hashTag;
        }
    }

}
