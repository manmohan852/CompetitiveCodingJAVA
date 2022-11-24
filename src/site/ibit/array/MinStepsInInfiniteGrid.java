package site.ibit.array;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
public class MinStepsInInfiniteGrid {
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int numSteps = 0;
        for(int i = 1; i < X.size(); i++){
            numSteps += Math.max( Math.abs(X.get(i) - X.get(i-1)), Math.abs(Y.get(i) - Y.get(i-1)) );
        }
        return numSteps;
    }
}
