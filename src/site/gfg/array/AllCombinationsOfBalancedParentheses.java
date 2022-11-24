package site.gfg.array;
//https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
public class AllCombinationsOfBalancedParentheses {
    static void _printParenthesis(char str[], int pos, int n, int open, int close) {
        if (close == n) {
            // print the possible combinations
            for (int i = 0; i < str.length; i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        } else {
            if (open > close) {
                str[pos] = '}';
                _printParenthesis(str, pos + 1, n, open, close + 1);
            }
            if (open < n) {
                str[pos] = '{';
                _printParenthesis(str, pos + 1, n, open + 1, close);
            }
        }
    }

    static void printParenthesis(char str[], int n) {
        if (n > 0)
            _printParenthesis(str, 0, n, 0, 0);
        return;
    }

    public static void main(String[] args) {
        int n = 3;
        char[] str = new char[2 * n];
        printParenthesis(str, n);
    }
}
//
//    Time Complexity: O(2^n).
//        For every index there can be two options ‘{‘ or ‘}’.
//        So it can be said that the upperbound of time complexity is O(2^n) or it has exponential time complexity.
//        Space Complexity: O(n).
//        The space complexity can be reduced to O(n) if global variable
//        or static variable is used to store the output string.
