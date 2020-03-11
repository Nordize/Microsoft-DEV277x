
import java.util.Scanner;

import static java.lang.System.exit;


public class Main_Fraction {


    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        String operator;
        Fraction fraction = new Fraction();
        Fraction fraction2 = new Fraction();

        //intro
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, substract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println();


        while(true){
            operator = getOperation(input);
            fraction = getFraction(input);
            fraction2 = getFraction(input);

            calculate(operator,fraction,fraction2);

        }



    }

    public static void calculate(String operator, Fraction fraction, Fraction fraction2){
        Fraction fraction3 = new Fraction();
        boolean isEqual;

        if(operator.equals("=")){
            isEqual = fraction.equals(fraction2);
            if (isEqual){
                System.out.println(fraction.toString() +" "+ operator + " "+ fraction2.toString() + " is true");
            }else {
                System.out.println(fraction.toString() +" "+ operator + " "+ fraction2.toString() + " is false");
            }
        }else
        {
            if (operator.equals("+")){
                fraction3 = fraction.add(fraction2);
            }
            if (operator.equals("-")){
                fraction3 = fraction.substract(fraction2);
            }
            if (operator.equals("*")){
                fraction3 = fraction.multiply(fraction2);
            }
            if (operator.equals("/")){
                fraction3 = fraction.divide(fraction2);
            }
            fraction3.toLowestTerms();
            if(fraction3.getDenominator() == 0){
                System.out.println(fraction.toString() + " " + operator + " " + fraction2.toString()+ " = undefined");
            }else{
                System.out.println(fraction.toString() + " " + operator + " " + fraction2.toString()+ " = " + fraction3.toString());
            }

        }


    }


    public static String getOperation(Scanner input){

        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit):");
        String operator = input.next().toUpperCase();

        while (!(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("=") || operator.equals("Q"))){
            System.out.print("Invalid input (+, -, /, *, = or Q to quit):");
            operator = input.next().toUpperCase();
        }

        if(operator.equals("Q"))
        {
            exit(0);
        }

        return operator;
    }
    public static boolean validFraction(String input){
        boolean validFraction = false;

        int denominator;

        if(input.substring(0,1).equals("-")){
            input = input.replace("-","");
        }

        if(input.matches("\\d+/\\d+")){
            validFraction = true;
            denominator = Integer.parseInt(input.substring(input.indexOf("/")+1));
            if (denominator == 0){
                validFraction = false;
            }
        }

        if (input.matches("\\d+")){
            validFraction = true;

        }

        return validFraction;
    }
    public static Fraction getFraction(Scanner input){

        int numerator;
        int denominator;
        int indexOfDiv;
        Fraction fraction;

        System.out.print("Please enter fraction (a/b) or integer (a):");
        String inputStr = input.next();

        while (!(validFraction(inputStr) == true) && inputStr.equals("") && inputStr.equalsIgnoreCase("Q")){
            System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero:");
            inputStr = input.next();
        }

        if(inputStr.equals("")){
            throw new IllegalArgumentException();
        }

        if (inputStr.equalsIgnoreCase("Q"))
        {
            exit(0);
        }

        indexOfDiv = inputStr.indexOf("/");
        if(indexOfDiv == -1){
            numerator = Integer.parseInt(inputStr);
            denominator = 1;
        }else{
            numerator = Integer.parseInt(inputStr.substring(0,indexOfDiv));
            denominator = Integer.parseInt(inputStr.substring(indexOfDiv+1));
        }

        fraction = new Fraction(numerator,denominator);
        return fraction;


    }
}
