import java.util.Scanner;
import java.util.Stack;

/**
 * Created by simonsaffer on 2016-01-17.
 */
public class BalancedParentheses {

  private static boolean isLeft(char c) { return c == '{' || c == '[' || c == '('; };
  private static boolean isRight(char c) { return c == '}' || c == ']' || c == ')'; };

  private static boolean isMatch(char a, char b) {
    return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    for(int n = 0; n < N; n++) {
      String expr = sc.next();

      Stack<Character> s = new Stack<Character>();

      boolean isBalanced = true;

      for(int i = 0; i < expr.length(); i++) {

        char c = expr.charAt(i);

        if(c == '{' || c == '[' || c == '(') {

          s.add(c);

        } else {

          if(s.isEmpty() || !isMatch(c, s.pop())) {
            isBalanced = false;
            break;
          }

        }

      }
      if (isBalanced && s.isEmpty()) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
