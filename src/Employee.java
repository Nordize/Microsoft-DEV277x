public abstract class Employee {

    private String employee_name;
    public double employee_baseSalary;
    private int employee_id;
    private int idCount = 0;
    private Employee manager;
    public double bonusBudget;
    public int headCount = 0;


    public Employee(String name, double baseSalary){
        this.employee_name = name;
        this.employee_baseSalary = baseSalary;
        this.employee_id = idCount+1;
        idCount++;

    }

    public double getBaseSalary(){
        return employee_baseSalary;
    }
    public String getName(){
        return employee_name;
    }

    public int getEmployeeID(){
        return employee_id;
    }

    public int employeeCount(){
        return idCount;
    }

    public Employee getManager(){
        return manager;
    }

    public void setManager(Employee manager){
        this.manager = manager;
    }

    public boolean equals(Employee other){
        if(this.employee_id == other.employee_id){
            return true;
        }else {
            return false;
        }
    }

    public String toString(){
        return employee_id +" "+ employee_name;
    }

    abstract String employeeStatus();

}
