package oy.tol.tra;

/**
 * Uses the StackInterface implementation to check that parentheses in text files
 * match. 
 * <p>
 * TODO: Students, implement the checkParentheses() method using your StackImplementation
 * to check if parentheses in the two test files match or not.
 * <p>
 * NOTE: The Person.json test file has an error, but the tests expect that. So the test will 
 * not fail with that file -- the erroneus json file is _expected_.
 * <p>
 * Note that you do not have to instantiate this class anywhere. The ParenthesisTests:
 * <ul>
 *  <li>Constructs your implementation of the {@code StackImplementation<Character>}, and
 *  <li>Calls ParenthesisChecker.checkParentheses.
 * </ul>
 * So your job is just to have a working StackImplementation and implement the ParenthesisChecker.checkParentheses.
 * Then execute the ParenthesisTests.
 */
public class ParenthesisChecker {

   private ParenthesisChecker() {
   }

   /**
    * TODO: Implement this function which checks if the given string has matching opening and closing
    * parentheses. It should check for matching parentheses:<p>
    *  <code>Lorem ipsum ( dolor sit {  amet, [ consectetur adipiscing ] elit, sed } do eiusmod tempor ) incididunt ut...</code>,
    * <p>
    * which can be found for example in Java source code and JSON structures.
    * <p>
    * If the string has issues with parentheses, you should throw a {@code ParenthesisException} with a
    * descriptive message and error code. Error codes are already defined for you in the ParenthesesException
    * class to be used.
    * <p>
    * What is to be tested:
    * <ul>
    *  <li>when an opening parenthesis is found in the string, it is successfully pushed to the stack.
    *  <li>when a closing parenthesis is found in the string, a matching opening parenthesis is popped from the stack.
    *  <li>when popping a parenthesis from the stack, it must not be null. Otherwise string has too many closing parentheses.
    *  <li>when the string has been handled, and if the stack still has parentheses, there are too few closing parentheses.
    * </ul>
    * @param stack The stack object used in checking the parentheses from the string.
    * @param fromString A string containing parentheses to check if it is valid.
    * @return Returns the number of parentheses found from the input in total (both opening and closing).
    * @throws ParenthesesException if the parentheses did not match as intended.
    * @throws StackAllocationException If the stack cannot be allocated or reallocated if necessary.
    */
    public static int checkParentheses(StackInterface<Character> stack, String fromString) throws ParenthesesException {
      // TODO:
      // for each character in the input string
      //   if character is an opening parenthesis -- one of "([{"
      //      push it into the stack (check for failure and throw an exception if so)  这个怎么检查
      //   else if character is a closing parenthesis -- one of ")]}"
      //      pop the latest opening parenthesis from the stack
      //      if the popped item is null
      //         throw an exception, there are too many closing parentheses 
      //      check the popped opening parenthesis against the closing parenthesis read from the string
      //      if they do not match -- opening was { but closing was ], for example.
      //         throw an exception, wrong kind of parenthesis were in the text (e.g. "asfa ( asdf } sadf")
      // if the stack is not empty after all the characters have been handled
      //   throw an exception since the string has more opening than closing parentheses.
      stack.push('a');
      int num = 0;
      for(int i=0;i< fromString.length(); i++ ){
         char c = fromString.charAt(i);
         if('('==c || '[' == c ||'{' == c){
            stack.push(c);
            num++;
         }else if(')'==c ||']'==c||'}'==c){
            num++;
            char comp = ' ';
            comp = stack.pop();
            //栈为空时comp的值是什么，是a吗
            if('a' == comp ){
               throw new ParenthesesException("There are too many closing parentheses", -1);
            }
            else if((')'==c && '(' != comp) || (']'==c && '[' != comp) || ('}'==c && '{' != comp)){
               throw new ParenthesesException("Wrong kind of parenthesis were in the text", -3);
            }
            
         }

      }
      stack.pop();
      if(!stack.isEmpty()){
         throw new ParenthesesException("The string has more opening than closing parentheses", -2);
      }

      return num;
   }
}
