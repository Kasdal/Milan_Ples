public class SalesWorker extends Employee{

    private int bonus;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
            this.bonus = bonus;
//probably write new validation method in util?
    }



    public SalesWorker(double hoursWorked, double hourlyRate,int bonus){
        super(hoursWorked,hourlyRate);
    }
    public double calculateSallary(){
        return 0;
    }
}
