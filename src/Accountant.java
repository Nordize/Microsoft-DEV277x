public class Accountant extends BusinessEmployee{

    private TechnicalLead teamSupported;

    public Accountant(String name){
        super(name);

        this.bonusBudget =0;

        //no team officially support
        this.teamSupported = null;
    }

    public TechnicalLead getTeamSupported(){
        return teamSupported;
    }

    public void supportTeam(TechnicalLead lead){

        //Keep track of the team accountant is supporting
        this.teamSupported = lead;

        //Variable to contain the amount of budget for accountant to manage
        double bonusAmount = 0;

        for(int i =0; i < lead.team.size(); i++){

            //Budget is every software engineers below tech lead salary plus 10% (check out of loop)
            bonusAmount += lead.team.get(i).employee_baseSalary;
        }

        //This is the 10%
        bonusAmount *= 1.1;

        //Update accountant's bonus budget
        this.setBonusBudget(bonusAmount);
    }

    public boolean approveBonus(double bonus){

        // If accountant supports no team, return false
        if(this.teamSupported == null){
            return false;
        }else {
            // If bonus is bigger than budget, return false. Otherwise, return true
            if(bonus > this.bonusBudget){
                return false;
            }else {
                return true;
            }
        }
    }

    public String employeeStatus(){
        // Reduce the double to 1 decimal
        String s = String.format("%.1f", this.getBonusBudget());

        return this.toString() + " with a budget of " + s + " is supporting "+ this.teamSupported.getName();
    }
}
