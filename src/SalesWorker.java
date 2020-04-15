public class SalesWorker extends Employee{

    private double bonus;



    public void setBonus(double bonus) {
            if(Utilities.validDoubleRange(0, 20, bonus))
                this.bonus = bonus;
            else this.bonus = 0;
    }
    public double getBonus() {
        return bonus;
    }

    /**
     * Creates SaleWorker as child of Emp class
     * @param firstName
     * @param lastName
     * @param hoursWorked
     * @param hourlyRate
     * @param emailAddress
     * @param bonus
     */
    public SalesWorker(String firstName, String lastName, double hoursWorked, double hourlyRate, String emailAddress, double bonus){
        super(hoursWorked,hourlyRate,firstName,lastName,emailAddress);
    }

    /**
     * Salary calculation method
     * @return Salary + any bonus percentage entitled
     */
    public double calculateSalary(){
    double salary = getSalary();
    double bonus = (salary/100)*getBonus();
        return salary + bonus;
    }



    @Override
    public String toString() {
        return "SalesWorker{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", emailAddress='" + getEmailAddress() + '\'' +
                ", hoursWorked=" + getHoursWorked() +
                ", hourlyRate=" + getHourlyRate() +
                ", bonus=" + bonus +
                '}';
    }
}
