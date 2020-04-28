package site.ibit.ninza;

import java.util.ArrayList;

public class MinJumps {
    public static class MinSumPath{
        Integer minSumPath;
    }

    public static int[] minJumps(int[] A, int B) {
        int n = A.length;
        if(A[n-1] == -1){
            return new int[1];
        }
        ArrayList<Integer> currPath = new ArrayList<>();
        currPath.add(0);
        ArrayList<Integer> resPath = new ArrayList<>();
        Integer minPathSum = Integer.MAX_VALUE;
        MinSumPath minSumPath = new MinSumPath();
        minSumPath.minSumPath = minPathSum;
        Integer pathSum = A[0];
        minJumps(A,B,0,n-1,resPath,currPath,pathSum,minSumPath);
        int[] result = new int[resPath.size()];
        for(int i = 0;i<resPath.size();i++){
            result[i] = resPath.get(i) + 1;
        }
        System.out.println(resPath);
        return result;
    }

    public static void minJumps(int[] A, int B, int l, int h,ArrayList<Integer> resPath,ArrayList<Integer> currPath,Integer pathSum,MinSumPath minSumPath){
        if(l == h){
            if(pathSum < minSumPath.minSumPath){
                minSumPath.minSumPath = pathSum;
                resPath.clear();
                resPath.addAll(currPath);
                return;
            }
        }
        for(int i = l+1;i< l+1+B && i<=h ;i++){
            if(A[i] != -1){
                currPath.add(i);
                pathSum += A[i];
                minJumps(A,B,i,h,resPath,currPath,pathSum,minSumPath);
                pathSum -=A[i];
                currPath.remove(currPath.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1,2,4,-1,2};
        int B = 2;
        minJumps(A,B);
    }

}

