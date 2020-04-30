import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class EmployeeAPI {

    private ArrayList<Employee> employees;
    private String listOfEmployees;

    public EmployeeAPI() {
        this.employees = new ArrayList<Employee>();
    }


    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }


    public boolean addEmployeeToDepartment(int empindex, int mgrindex){
        if (Utilities.validIndex(empindex,employees)&& Utilities.validIndex(mgrindex,employees) && employees.get(mgrindex)instanceof Manager){
          ((Manager) employees.get(mgrindex)).addEmpToDepartment(employees.get(empindex));
          return true;
        }
        return false;
    }

    public boolean removeEmployee(int empindex, int mgrindex){
        if (Utilities.validIndex(empindex,employees)&& Utilities.validIndex(mgrindex,employees) && employees.get(mgrindex)instanceof Manager){
            ((Manager) employees.get(mgrindex)).removeEmployee(empindex);
            return true;
        }
        return false;
    }


    /**
     * Parse through array,add elements from the array to the string
     * @return list of employees
     */
    public String listOfEmployees(){

        if (employees.size() == 0) {
            return "No employees stored.";
        } else {
            String listOfEmployees = "";
            for (int i = 0; i < employees.size(); i++) {
                listOfEmployees = listOfEmployees + i + ": " + employees.get(i) + "\n";
            }
            return listOfEmployees;
        }
    }

    /**
     * Parse through employee array if element is Manager add it to list.
     * @return List of Managers
     */
    public String listManagerEmployees(){
        if (employees.size() == 0) {
            return "No employees stored.";
        } else {
            String listOfManagers = "";
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i) instanceof Manager)
                listOfManagers = listOfManagers + i + ": " + employees.get(i) + "\n";
            }
            if(listOfManagers.length()>1)
            return listOfManagers;
            else return "No managers found";
        }

    }

    public String listManagerEmployees(Manager m){
    ArrayList<Employee> emps = m.getDepartmentEmployees();

        if (emps.size() == 0) {
            return "No employees stored.";
        } else {
            String listOfEmployees = "";
            for (int i = 0; i < emps.size(); i++) {
                listOfEmployees = listOfEmployees + i + ": " + emps.get(i) + "\n";
            }
            return listOfEmployees;
        }
    }

    /**
     * @return employee array number of elements.
     */
    public int numberOfEmployees(){
        return employees.size();
    }

    /**
     * Create new object of employee array
     * Parses through array ignoring case.
     * @param lastname
     * @return element that matches the search parameters
     */
    public ArrayList<Employee> searchEmployees(String lastname){
        ArrayList<Employee> matchemp = new ArrayList<>();
        if(employees.size () == 0)
            return null;
        for (int i = 0; i < employees.size(); i++){
            if(employees.get(i).getLastName().equalsIgnoreCase(lastname)){
                matchemp.add(employees.get(i));
            }
        }
        return matchemp;
    }

    /**
     * Method takes in last name parameter to find the employee and removes it from the array of employees.
     * @param lastname
     */
    public void deleteEmployeeByName(String lastname) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getLastName().equalsIgnoreCase(lastname)) {
                employees.remove(employees.get(i));
            }
        }
    }
    /**
     * Adds Employee to array
     * @param worker
     */
    public void addEmployee(Employee worker){
        employees.add(worker);
    }

    /**
     * Removes the employee from the array.
     * @param employee
     * @return valid removal.
     */
    public boolean removeEmployee(int employee) {
        if (this.employees.size() > employee && employee >=0) {
            this.employees.remove(employee);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return Total salary owed to all employees in aggregate.
     */
    public double totalSalariesOwed(){
        double totalsallary = 0;
        for (int i = 0; i <employees.size(); i++){
            totalsallary +=employees.get(i).calculateSalary();
        }
        return totalsallary;
    }

    /**
     *
     * @return Calculated average salary owed.
     */
    public double averageSalaryOwed(){
        return totalSalariesOwed()/numberOfEmployees();
    }

    public Employee employeeWithHighestPay(){
        double largestpay = 0;
        Employee largestemp = null;
        for (int i = 0; i < employees.size(); i++){
            if (employees.get(i).calculateSalary() > largestpay){
                largestpay = employees.get(i).calculateSalary();
                largestemp = employees.get(i);
            }
        }
        return largestemp;
    }




    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("employeeList.xml"));
        this.employees = (ArrayList)is.readObject();
        is.close();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("employeeList.xml"));
        out.writeObject(this.employees);
        out.close();
    }

}
