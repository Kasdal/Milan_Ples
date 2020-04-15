import java.util.ArrayList;

public class EmployeeAPI {

    private ArrayList<Employee> employees;
    private String listOfEmployees;

    public EmployeeAPI() {
        this.employees = new ArrayList<Employee>();
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

    public ArrayList<Employee> getEmployees() {
        return employees;
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
     * Adds Employee to array
     * @param worker
     */
    public void addEmployee(Employee worker){
        employees.add(worker);
    }
// Check with Siobahn.
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

}
