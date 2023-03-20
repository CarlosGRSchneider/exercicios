package fizzbuzz;

public class FizzBuzz {

    public void iteradorFizzBuzz(int numero) {

        for(int i = 1; i <= numero; i++) {

            if(i%3 == 0 && i%5 == 0) {
                System.out.println("Fizz Buzz");
            } else if(i%3 == 0) {
                System.out.println("Fizz");
            } else if(i%5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();

        fb.iteradorFizzBuzz(25);
    }
}
