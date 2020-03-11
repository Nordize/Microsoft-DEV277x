public class BusinessEmployee extends Employee {

    public BusinessEmployee(String name){

        super(name,50000);

    }

    public double getBonusBudget(){
        return this.bonusBudget;
    }

    public void setBonusBudget(double bonusBudget){
        this.bonusBudget = bonusBudget;
    }

    public String employeeStatus(){

        // Reduce the double to 1 decimal
        String s = String.format("%.1f", this.getBonusBudget());

        return this.toString() + " with a budget of " + s;
    }
}
