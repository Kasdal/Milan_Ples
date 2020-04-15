public abstract class Employee{
    private String firstName;
    private String lastName;
    private String emailAddress;
    private double hoursWorked;
    private double hourlyRate;
    private static double NORMAL_WORKWEEK = 37.5;
    private static double MIN_WAGE = 9.80;

    /**
     * This is a parent class of all company employees
     * Using keyword "super" this constructor is called.
     * @param hoursWorked
     * @param hourlyRate
     * @param firstName
     * @param lastName
     * @param emailAddress
     */
    public Employee(double hoursWorked, double hourlyRate, String firstName, String lastName, String emailAddress) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getNORMAL_WORKWEEK() {
        return NORMAL_WORKWEEK;
    }

    public double getMIN_WAGE() {
        return MIN_WAGE;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setNORMAL_WORKWEEK(double NORMAL_WORKWEEK) {
        this.NORMAL_WORKWEEK = NORMAL_WORKWEEK;
    }

    public void setMIN_WAGE(double MIN_WAGE) {
        this.MIN_WAGE = MIN_WAGE;
    }
    public abstract double calculateSalary();

    public double getSalary(){
        //    This method returns the basic salary(hourly-rate * amount <= 'NORMAL_WORKING_WEEK') + overtime (see above) based on hours worked (i.e. no bonuses included).
        if(hoursWorked <= NORMAL_WORKWEEK){
            return hoursWorked * hourlyRate;}
        else {
            return (NORMAL_WORKWEEK * hourlyRate) + getOvertime();
        }
    }


    public double getOvertime(){
        //    This method should return the amount owed to the employee for overtime. This is calculated by multiplying the number of hours over the 'NORMALWORKINGWEEK' (i.e.39.5 hours) worked by the employee by the hourlyRate*2.
        if (hoursWorked > NORMAL_WORKWEEK){
            double hoursOver = hoursWorked - NORMAL_WORKWEEK;
            double overTimeRate = hourlyRate * 2;
            return hoursOver * overTimeRate;
        }
        else return 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", hoursWorked=" + hoursWorked +
                ", hourlyRate=" + hourlyRate +
                '}';
    }

}
