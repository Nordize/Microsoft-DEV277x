import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {

    // ArrayList to keep track of software engineers tech lead manages
    ArrayList<SoftwareEngineer> team;

    // Reference to the accountant that is supporting tech lead's team
    Accountant supportAccountant;

    public TechnicalLead(String name){
        super(name);

        this.employee_baseSalary *= 1.3;

        //default head count = 4;
        this.headCount = 4;
        this.team = new ArrayList<SoftwareEngineer>();

    }

    public boolean hasHeadCount(){
        // Check if tech lead has room for more software engineers in his team
        if( team.size() < this.headCount){
            return true;
        }else{
            return false;
        }
    }

    public boolean addReport(SoftwareEngineer e){

        // If there's room in the team, add software engineer. Otherwise, don't.
        if(this.hasHeadCount()){

            //add Software Engineer to the team
            team.add(e);

            //Update its manager
            e.setManager(this);

            return true;
        }else {
            return false;
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e){
        //if the employee passed in does report to this manager and if their code access is currently set to "true"
        if(e.getManager().equals(this) && e.getCodeAccess()){
            return true;
        }else {
            return false;
        }
    }

    public boolean requestBonus(Employee e,double bonus){

        BusinessLead b = (BusinessLead) getSupportAccountant().getManager();

        if(b.approveBonus(e,bonus)){

            // If approved by business lead, employee gets bonus and method returns true. Otherwise, returns false.
            e.bonusBudget = bonus;

            return true;
        }else
        {
            return false;
        }
    }

    public Accountant getSupportAccountant(){
        return supportAccountant;
    }

    public String getTeamStatus(){

        //if the TechnicalLead has no reports
        if(team.size() == 0){
            return this.employeeStatus() + " and no direct report yet";
        }else{

            String s= this.employeeStatus() + " and is managing:";

            for(int i =0 ;i< team.size();i++){
                s += "\n" + team.get(i).employeeStatus();
            }

            return s;
        }
    }
}
