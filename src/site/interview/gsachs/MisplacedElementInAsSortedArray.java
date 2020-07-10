package site.interview.gsachs;

public class MisplacedElementInAsSortedArray {

    public static void main(String[] args) {
        int[] arr = {71, 73, 75, 89, 85, 87, 88, 93, 97, 99};
        int x = findMisplacedElement(arr);
        System.out.println();
    }

    private static int findMisplacedElement(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (arr[i] > arr[i + 1]) {
                    return i;
                }
            } else if (i == n - 1) {
                if (arr[i] < arr[i - 1]) {
                    return i;
                }
            } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
