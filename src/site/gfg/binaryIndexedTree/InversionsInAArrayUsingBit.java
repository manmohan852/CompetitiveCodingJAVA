package site.gfg.binaryIndexedTree;

public class InversionsInAArrayUsingBit {

    public static void main(String[] args) {
        int[] arr = {8,4,2,1};
        int n = arr.length;

        InversionsInAArrayUsingBit inversionsInAArrayUsingBit = new InversionsInAArrayUsingBit();
        System.out.println(getInvCount(arr,n));
    }

    static int getSum(int[] BITree,int index){
        int sum = 0;
        while(index>0){
            sum+=BITree[index];
            index = index - (index & (-index));
        }
        return sum;
    }

    static void updateBIT(int[] BITree,int n,int index,int val){
        while(index<=n){
            BITree[index]+=val;
            index+=index & (-index);
        }
    }

    static int getInvCount(int[] arr,int n){
        int invCount = 0;
        int maxElement = 0;
        for(int i=0;i<n;i++){
            if(maxElement < arr[i]){
                maxElement = arr[i];
            }
        }

        int[] BITree = new int[maxElement+1];
        for(int i =1;i<=n;i++){
            BITree[i] = 0;
        }

        for(int i = n-1;i>=0;i--){
            invCount += getSum(BITree,arr[i] - 1);
            updateBIT(BITree,maxElement,arr[i],1);
        }
        return invCount;
    }

}
