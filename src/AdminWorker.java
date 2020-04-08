public class AdminWorker extends Employee{

    private int bonus;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        if(Utilities.validIntNonNegative(bonus))
            this.bonus = bonus;
        else
            this.bonus = 0;
    }



    public AdminWorker(double hoursWorked, double hourlyRate,int bonus){
        super(hoursWorked,hourlyRate);
    }
    public double calculateSallary(){
        return 0;
    }

}
