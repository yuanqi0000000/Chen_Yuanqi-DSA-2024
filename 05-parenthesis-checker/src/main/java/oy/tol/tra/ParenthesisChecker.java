package oy.tol.tra;

public class ParenthesisChecker {

   private ParenthesisChecker() {
   }

   public static int checkParentheses(StackInterface<Character> stack, String fromString) throws ParenthesesException {

      stack.push('a');
      int num = 0;
      for (int i = 0; i < fromString.length(); i++) {
         char c = fromString.charAt(i);
         if ('(' == c || '[' == c || '{' == c) {
            stack.push(c);
            num++;
         } else if (')' == c || ']' == c || '}' == c) {
            num++;
            char comp = ' ';
            comp = stack.pop();
            if ('a' == comp) {
               throw new ParenthesesException("There are too many closing parentheses", -1);
            } else if ((')' == c && '(' != comp) || (']' == c && '[' != comp) || ('}' == c && '{' != comp)) {
               throw new ParenthesesException("Wrong kind of parenthesis were in the text", -3);
            }

         }

      }
      stack.pop();
      if (!stack.isEmpty()) {
         throw new ParenthesesException("The string has more opening than closing parentheses", -2);
      }

      return num;
   }
}
