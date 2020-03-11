import org.xml.sax.helpers.AttributesImpl;

import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee{

    ArrayList<Accountant> team;

    public BusinessLead(String name){

        super(name);

        this.employee_baseSalary *= 2;

        this.headCount = 10;
        this.team = new ArrayList<Accountant>();
    }
    public boolean hasHeadCount(){
        if(team.size() < this.headCount){
            return true;
        }else{
            return false;
        }
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        // If there's room in the team, add accountant. Otherwise, don't.
        if(this.hasHeadCount()){
            // Add accountant to team
            team.add(e);

            // Update its manager
            e.setManager(this);

            // Update business lead bonus budget by the accountant's salary plus 10%
            this.bonusBudget = e.employee_baseSalary * 1.1;

            // Define which team the accountant will support
            e.supportTeam(supportTeam);

            // Pass accountant reference to defined team
            supportTeam.supportAccountant = e;

            return true;
        }else{
            return false;
        }
    }

    public boolean requestBonus(Employee e,double bonus){
        if(bonus < this.bonusBudget){

            // If approved by business lead, employee gets bonus
            e.bonusBudget = bonus;

            // Business lead bonus budget gets deducted
            this.bonusBudget -= bonus;
            return true;
        }else{
            return false;
        }
    }

    public boolean approveBonus(Employee e, double bonus){
        for(int i =0;i< team.size();i++){

            // If the accountant in the team is supporting the manager of the employee passed, check budget
            if(team.get(i).getTeamSupported().equals(e.getManager())){

                // If there's budget, employee gets bonus.
                if(team.get(i).bonusBudget > bonus){
                    e.bonusBudget = bonus;

                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
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
