package fizzbuzz;

public class FizzBuzz {

    public void iteradorFizzBuzz(int numero) {

        for(int i = 0; i <= numero; i++) {

            if(numero%3 == 0 && numero%5 == 0) {
                System.out.println("Fizz Buzz");
            } else if(numero%3 == 0) {
                System.out.println("Fizz");
            } else if(numero%5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
