public class Fraction {

    //Fields
    private int numerator;
    private int denominator;

    //Constructors
    public Fraction(int num,int deno){
        if(deno == 0){
            throw new IllegalArgumentException();
        }
        if(deno<0){
            deno = deno * -1;
            num = num * -1;
        }

        this.denominator = deno;
        this.numerator = num;
    }

    public Fraction(int num){
        this(num,1);
    }

    public Fraction(){
        this(0,1);
    }

    //Getters
    public int getNumerato(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    /*
    accessor methods:
    return numerator, return denominator, toString, toDouble (returns real number equivalent
    to the fraction)
     */
    public String toString(){
        if(denominator == 1){
            return numerator + "";
        }else if(denominator == 0){
            return "0";
        }else {
            return numerator+"/"+denominator;
        }

    }

    public double toDouble(){
        return numerator/denominator;

    }

    public Fraction add(Fraction other){
        Fraction sum = new Fraction();

        if(this.denominator == other.denominator){
            sum.numerator = this.numerator + other.numerator;
            this.denominator = other.denominator;
        }else {
            sum.numerator = (this.numerator*other.denominator) + (other.numerator*this.denominator);
            sum.denominator = this.denominator * other.denominator;
        }

        return sum;
    }

    public Fraction substract(Fraction other){
        Fraction substract = new Fraction();

        if(this.denominator == other.denominator){
            substract.numerator = this.numerator - other.numerator;
            this.denominator = other.denominator;
        }else {
            substract.numerator = (this.numerator*other.denominator) - (other.numerator*this.denominator);
            substract.denominator = this.denominator * other.denominator;
        }

        return substract;
    }

    public Fraction multiply(Fraction other){
        Fraction multiply = new Fraction();

        multiply.numerator = this.numerator * other.numerator;
        multiply.denominator = this.denominator * other.denominator;

        return multiply;
    }

    public Fraction divide(Fraction other){
        Fraction divide = new Fraction();

        divide.numerator = this.numerator * other.denominator;
        divide.denominator = this.denominator * other.numerator;

        return divide;
    }

    public boolean equals(Object other){
        if(!(other instanceof Fraction)){
            return false;
        }else{
            Fraction verifyFrac = (Fraction) other; //create object for "other"

            Fraction tempThisFraction = new Fraction(this.numerator,this.denominator);
            Fraction tempOtherFraction = new Fraction(verifyFrac.numerator,verifyFrac.denominator);

            tempThisFraction.toLowestTerms();
            tempOtherFraction.toLowestTerms();

            if(tempThisFraction.denominator < 0){
                tempThisFraction.numerator = this.numerator * -1;
                tempThisFraction.denominator = this.denominator * -1;
            }
            if(tempOtherFraction.denominator < 0){
                tempOtherFraction.numerator = this.numerator * -1;
                tempOtherFraction.denominator = this.denominator * -1;
            }

            if ((tempThisFraction.numerator == tempOtherFraction.numerator) && (tempOtherFraction.denominator == tempOtherFraction.denominator)){
                return true;
            }else {
                return false;
            }
        }
    }
    public void toLowestTerms(){
        int gcd;

        gcd = gcd(this.numerator,this.denominator);
        this.numerator = this.numerator/gcd;
        this.denominator = this.denominator/gcd;
    }
    public int gcd (int num, int den){
        if(den == 0){
            return num;
        }else{
            return gcd(den,num % den);
        }
    }


}
