import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        FractionQuiz();
    }

    public static void estimatePI() {
        Fraction MILU = new Fraction(355,113);
        Fraction estimate = MILU;
        final double EPSILON = Math.abs(Math.PI - MILU.toDouble());
        while(Math.abs(Math.PI - estimate.toDouble()) >= EPSILON) {
            if(estimate.toDouble() > Math.PI) {
                estimate.setDenom(estimate.getDenom() + 1);
            } else {
                estimate.setNum(estimate.getNum() + 1);
            }
        }
        System.out.println(estimate);
    }

    public static void FractionQuiz() {
        Scanner scan = new Scanner(System.in);
        int right = 0;
        int questions = 0;
        Fraction result = new Fraction();
        boolean quit = false;

        System.out.println("Let the Fraction Quiz Begin. Answers should be in lowest terms. Good luck!\n");
        while(!quit) {
            Fraction frac1 = new Fraction();
            Fraction frac2 = new Fraction();
            int function = (int)(Math.random()*4)+1;
            if (function == 1) {
                result = frac1.add(frac2);
                System.out.print(frac1+ " + " +frac2);
            } else if(function == 2) {
                result = frac1.subtract(frac2);
                System.out.print(frac1+ " - " +frac2);
            } else if(function == 3) {
                result = frac1.multiply(frac2);
                    System.out.print(frac1+ " * " +frac2);
                } else if(function == 4) {
                    result = frac1.divide(frac2);
                    System.out.print(frac1+ " / " +frac2);
                }
            System.out.print(" = ");
            String ans = scan.next();
            if(!ans.equals("quit")) {
                if(new Fraction(ans).equals(result)) {
                    right++;
                    questions++;
                    System.out.println("Correct!");
                } else if(new Fraction(ans).equals(result)==false) {
                    questions++;
                    System.out.println("Wrong, the answer was " +result);
                }
            } else {
                quit = true;
                System.out.println("Your win/loss ratio was " +right+ "/" +questions+ ", for a score of " +100 * new Fraction(right,questions).toDouble()+ " percent!");
            }
            }
        }


    public static void debug() {
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction(252, 105);
        Fraction f3 = new Fraction("3/0");
        Fraction f4 = new Fraction(f3);
        Fraction f5 = new Fraction(5,6);
        Fraction f6 = new Fraction(2,3);
        Fraction f7 = Fraction.multiply(f5,f6);
        Fraction f8 = Fraction.divide(f5,f6);
        Fraction f9 = Fraction.add(f5,f6);
        Fraction f10 = Fraction.subtract(f5,f6);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);
        System.out.println(f7);
        System.out.println(f8);
        System.out.println(f9);
        System.out.println(f10);
    }
}
