public class SoftwareEngineer extends TechnicalEmployee {

    private boolean CodeAccess;

    public SoftwareEngineer(String name){
        super(name);

        CodeAccess = false;

    }

    public boolean getCodeAccess(){
        return CodeAccess;
    }

    public void setCodeAccess(boolean access){
        this.CodeAccess = access;
    }

    public int getSuccessfulCheckIns(){
        return checkIn;
    }

    public boolean checkInCode(){

        TechnicalLead t = (TechnicalLead) getManager();

        if(t.approveCheckIn(this))
        {
            increaseCheckIn();

            return true;
        }else {
            return false;
        }
    }
}
