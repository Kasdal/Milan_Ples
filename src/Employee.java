public abstract class Employee{

    private double hoursWorked;
    private double hourlyRate;
    static double NORMAL_WORKWEEK = 37.5;
    static double MIN_WAGE = 9.50;

    public Employee(double hoursWorked, double hourlyRate) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
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
    public abstract double calculateSallary();

}
