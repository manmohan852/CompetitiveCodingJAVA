package site.gfg.graph;

//https://www.geeksforgeeks.org/find-minimum-moves-reach-target-infinite-line/
//https://www.geeksforgeeks.org/minimum-steps-to-reach-a-destination/
public class MinimumStepsOnInfiniteLine {

    //TODO
    static int reachTarget(int target) {
        target = Math.abs(target);
        int sum = 0, step = 0;
        while (sum < target || (sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }

    static int steps(int source, int step, int dest) {
        if (Math.abs(source) > (dest))
            return Integer.MAX_VALUE;
        if (source == dest)
            return step;
        int pos = steps(source + step + 1, step + 1, dest);
        int neg = steps(source - step - 1, step + 1, dest);
        return Math.min(pos, neg);
    }

    public static void main(String args[]) {
        int target = 5;
        System.out.println(reachTarget(target));
    }

    public static void main2(String[] args) {
        int dest = 11;
        System.out.println("No. of steps required" +
                " to reach " + dest +
                " is " + steps(0, 0, dest));
    }
}

