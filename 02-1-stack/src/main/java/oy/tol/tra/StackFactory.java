package oy.tol.tra;

public class StackFactory {

   private StackFactory() {
   }

   public static StackInterface<Integer> createIntegerStack() {
      return new StackImplementation<>();
   }

   public static StackInterface<Integer> createIntegerStack(int capacity) {
      return new StackImplementation<>(capacity);
   }
}
