package site.gfg.binaryIndexedTree;

public class ImplementationOfBIT {

    final static int MAX = 1000;
    static int BITree[] = new int[MAX];

    public static void main(String[] args) {
        int freq[] = {2,1,1,3,2,3,4,5,6,7,8,9};
        int n = freq.length;
        ImplementationOfBIT implementationOfBIT = new ImplementationOfBIT();
        implementationOfBIT.constructTree(freq,n);
        System.out.println("Sum of elements in arr[0....3] is "+ implementationOfBIT.getSum(3));

        freq[3] +=6;
        implementationOfBIT.updateBIT(n,3,6);
        System.out.println(implementationOfBIT.getSum(3));

        System.out.println(10 & (-10));

    }

    void constructTree(int arr[],int n){
        for(int i =1;i<=n;i++){
            BITree[i] = 0;
        }
        for (int i = 0;i<n;i++){
            updateBIT(n,i,arr[i]);
        }
    }

    void updateBIT(int n, int index,int val){
        index = index + 1;
        while(index<=n){
            BITree[index] += val;
            index = index + index & (-index);
        }
    }

    int getSum(int index){
        int sum =0;
        index = index + 1;
        while(index > 0){
            sum+=BITree[index];
            index -=index & (-index);
        }
        return sum;
    }

}
