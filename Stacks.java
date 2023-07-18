import java.util.*;
import java.util.Arrays;

public class Stacks {
    public static void main(String[] args) {
        int[] a = { 4, 2, 1, 5, 6, 3, 2, 4, 2 };
        String s = "{([]{([])})}";
        int[][] matrix={
            {0,1,1,1,1,0},
            {1,1,1,1,0,1},
            {1,1,0,1,1,1},
            {1,1,1,1,1,0}
        };
        // System.out.println(Arrays.toString(prevsmaller(a)));  //it give index
        // System.out.println(Arrays.toString(prevgreater(a)));
        // System.out.println(Arrays.toString(nextsmaller(a)));  //it give index
        // System.out.println(Arrays.toString(nextgreater(a)));
        // System.out.println(parenthesisCheck(s));
        // System.out.println(areaofHistogram(a));
        // System.out.println(areainSubMatrix(matrix));
    }

    static int[] prevsmaller(int[] a) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            while (!s.isEmpty() && a[s.peek()] >= a[i]) {
                    s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = -1;
            }else{
                ans[i]=s.peek();
            }
            s.push(i);
        }
        return ans;
    }

    static int[] prevgreater(int[] a) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            while (!s.isEmpty()) {
                if (s.peek() > a[i]) {
                    ans[i] = s.peek();
                    break;
                } else {
                    s.pop();
                }
            }
            if (s.isEmpty()) {
                ans[i] = -1;
            }
            s.push(a[i]);
        }
        return ans;
    }

    static int[] nextsmaller(int[] a) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[a.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < a.length; i++) {
            while (!s.isEmpty() && a[s.peek()] > a[i]) {
                int pi = s.pop();
                // ans[pi] = a[i]; //for element
                ans[pi] = i;    //for index
            }
            s.push(i);
        }
         while (!s.isEmpty()) {
            int pi = s.pop();
            ans[pi] = a.length;
        }
        return ans;
    }

    static int[] nextgreater(int[] a) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[a.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < a.length; i++) {
            while (!s.isEmpty() && a[s.peek()] < a[i]) {
                int pi = s.pop();
                ans[pi] = a[i];
            }
            s.push(i);
        }
        return ans;
    }

    static boolean parenthesisCheck(String str) {
        Stack<Character> s = new Stack<>();
        for (char i : str.toCharArray()) {
            if (i == '(' || i == '{' || i == '[') {
                s.push(i);
            } else if (i == ')' || i == '}' || i == ']') {
                if (s.isEmpty()) {
                    return false;
                }
                char top = s.pop();
                if (i == ')' && top != '(' || i == '}' && top != '{' || i == ']' && top != '[') {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }

    static int areaofHistogram(int[] a) {
        int[] ps = prevsmaller(a);
        int[] ns = nextsmaller(a);
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            int cur = (ns[i] - ps[i] - 1) * a[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    static int areainSubMatrix(int[][] area){
        int[] row=area[0];
        int maxarea=areaofHistogram(row);
        for (int i = 1; i < area.length; i++) {
            for(int j=0;j<area[0].length;j++){
                if(area[i][j]==1){
                    row[j]+=1;
                }else{
                    row[j]=0;
                }
            }
            int ans=areaofHistogram(row);
            maxarea=Math.max(maxarea, ans);
        }
        return maxarea;
    }


}