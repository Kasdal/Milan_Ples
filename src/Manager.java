import java.lang.reflect.Array;
import java.util.ArrayList;

public class Manager extends Employee{
    ArrayList<Employee> departmentEmployees;

    /**
     * Creates the manager as child of employee class
     * @param firstName
     * @param lastName
     * @param hoursWorked
     * @param hourlyRate
     * @param emailAddress
     */
    public Manager(String firstName, String lastName, double hoursWorked, double hourlyRate, String emailAddress){
        super(hoursWorked,hourlyRate,firstName,lastName,emailAddress );
        departmentEmployees = new ArrayList<>();
    }

    public ArrayList<Employee> getDepartmentEmployees() {
        return departmentEmployees;
    }

    public void setDepartmentEmployees(ArrayList<Employee> departmentEmployees) {
        this.departmentEmployees = departmentEmployees;
    }

    /**
     * Number of employees in the department.
     * @return size of the array.
     */
    public int departmentEmployees(){
        return departmentEmployees.size();
    }


    public double calculateSalary(){
        // This takes the salary calculated by the superclass's getSalary and adds it to the managers bonus, defined as follows:
        //The managers bonus is calculated by adding 1% of each of his/her employees' full salaries (including their bonuses).
        double salary = getSalary();
        double bonus = 0;
        for (int i = 0; i <departmentEmployees.size(); i++){
            double empSalary =departmentEmployees.get(i).getSalary();
            bonus += empSalary/100;
        }
        return salary + bonus;
    }



    @Override
    public String toString() {
        return "Manager{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", emailAddress='" + getEmailAddress() + '\'' +
                ", hoursWorked=" + getHoursWorked() +
                ", hourlyRate=" + getHourlyRate() +
                '}';
    }

}
