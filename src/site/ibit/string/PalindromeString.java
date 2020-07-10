package site.ibit.string;

//https://www.interviewbit.com/problems/palindrome-string/
public class PalindromeString {

    public static int isPalindrome(String a) {
        char[] arr = a.toLowerCase().toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (!((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= '0' && arr[i] <= '9'))) {
                i++;
                continue;
            }
            if (!((arr[j] >= 'a' && arr[j] <= 'z') || (arr[j] >= '0' && arr[j] <= '9'))) {
                j--;
                continue;
            }
            if (arr[i++] != arr[j--]) return 0;
        }
        return 1;
    }

    public static int isPalindrome2(String a) {
        int n = a.length();
        int startIdx = 0;
        int endIdx = n - 1;
        while (startIdx < endIdx) {
            char head = a.charAt(startIdx);
            head = Character.toLowerCase(head);
            if (!Character.isLetterOrDigit(head)) {
                startIdx++;
            } else {
                char tail = a.charAt(endIdx);
                tail = Character.toLowerCase(tail);
                if (!Character.isLetterOrDigit(tail)) {
                    endIdx--;
                } else {
                    if (head != tail) {
                        return 0;
                    }
                    startIdx++;
                    endIdx--;
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        isPalindrome2(str);
    }
}
