public class Main {
    static void sayHello() {
        System.out.println("Hello, world!");
      }
    
      static int calculateSum(int a, int b) {
        return a + b;
      }
    
      public static void main(String[] args) {
        sayHello();
        int num1 = 18;
        int num2 = 3;
        int sum = calculateSum(num1, num2);
        System.out.println(num1 + " + " + num2 + " = " + sum);
      }
}
