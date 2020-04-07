import java.lang.reflect.Array;
import java.util.ArrayList;

public class Manager extends Employee{
    ArrayList<Employee> departmentEmployees;
    public Manager(double hoursWorked, double hourlyRate){
        super(hoursWorked,hourlyRate);
        departmentEmployees = new ArrayList<>();
    }

    public double calculateSallary(){
        return 0;
    }
}
