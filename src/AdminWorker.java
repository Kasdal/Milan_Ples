public class AdminWorker extends Employee{

    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        if(Utilities.validIntNonNegative(bonus))
            this.bonus = bonus;
        else
            this.bonus = 0;
    }

    /**
     * Creates AdminWorker as child of Emp class
     * @param firstName
     * @param lastName
     * @param hoursWorked
     * @param hourlyRate
     * @param emailAddress
     * @param bonus
     */
    public AdminWorker(String firstName, String lastName, double hoursWorked, double hourlyRate, String emailAddress,double bonus){
        super(hoursWorked,hourlyRate,firstName,lastName,emailAddress);
    }
    /**
     * Salary calculation method
     * @return Salary + any bonus entitled
     */
    public double calculateSalary(){
        double salary = getSalary();
        double bonus = getBonus();
        return salary + bonus;
    }
    @Override
    public String toString() {
        return "AdminWorker{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", emailAddress='" + getEmailAddress() + '\'' +
                ", hoursWorked=" + getHoursWorked() +
                ", hourlyRate=" + getHourlyRate() +
                ", bonus=" + bonus +
                '}';
    }
}


