public class TechnicalEmployee extends Employee {

    public int checkIn;

    public TechnicalEmployee(String name){
        super(name,75000);
        checkIn =0;
    }

    public String employeeStatus(){
        return this.toString() + " has "+ checkIn + " successful check ins";
    }

    public void increaseCheckIn(){

        checkIn++;
    }

}
