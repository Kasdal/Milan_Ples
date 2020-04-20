import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private Scanner input = new Scanner(System.in);
    private EmployeeAPI empAPI = new EmployeeAPI();

    public Driver() {
        runMenu();
    }

    public static void main(String[] args) {
        new Driver();
    }

    private int mainMenu() {
        System.out.println("Administration Menu");
        System.out.println("-------------------");
        System.out.println("  1) Add a Manager");
        System.out.println("  2) Add a  Admin employee");
        System.out.println("  3) Add a Sales employee");
        System.out.println("  4) Add employee to a department");
        System.out.println("  5) Delete an employee");
        System.out.println("  6) Delete an employee from a manager list");
        System.out.println("  --------------------");
        System.out.println("  7) Find the total of the salaries owed to all the employees");
        System.out.println("  8) Find the average of the salaries owed to all the employees");
        System.out.println("  9) Print the employee with the highest pay");
        System.out.println("  10) Print the number of Employees");
        System.out.println("  --------------------");
        System.out.println("  11) List all employees in alphabetical order by first name");
        System.out.println("  12) List all employees in alphabetical order by last name");
        System.out.println("  ------------------");
        System.out.println("  13) Search for an employee through a manager's department");
        System.out.println("  -------");
        System.out.println("  14) Save to XML");
        System.out.println("  15) Load from XML");
        System.out.println("  -------");
        System.out.println("  0) Exit");
        System.out.print(" ==>>");
        return ScannerInput.readNextInt("==>>");
    }

    private void runMenu() {
        for(int option = mainMenu(); option != 0; option = mainMenu()) {
            switch (option) {
                case 1:
                    addManager();
                    break;
                case 2:
                    addSalesWorker();
                    break;
                case 3:
                    addAdminWorker();
                    break;
                case 4:
                    addEmployeeToDepartment();
                    break;
                case 5:
                    removeEmployeeByDept();
                    break;
                case 14:
                    try{
                        empAPI.save();;
                    }
                    catch(Exception e){
                        System.err.println("Error writing to file: " + e);
                    }
                    break;
                case 15:
                    try{
                        empAPI.load();
                    }
                    catch(Exception e){
                        System.err.println("Error reading from file: " + e);
                    }
                    break;

            }
        }
    }

    /**
     * Adding the manager with following properties.
     */
    public void addManager(){
        System.out.print("Enter the first name of the manager: ");
        String firstName = input.nextLine();
        System.out.println();
        System.out.print("Enter the last name of the manager: ");
        String lastName = input.nextLine();
        System.out.println();
        System.out.print("Enter the emailAddress of the manager: ");
        String emailAddress = input.nextLine();
        System.out.println();
        System.out.print("Enter the hours worked by the manager: ");
        double hoursWorked = ScannerInput.readNextDouble("Enter hours: ");
        System.out.println();
        System.out.print("Enter the hourly rate of the manager: ");
        double hourlyRate = ScannerInput.readNextDouble("Enter rate: ");
        System.out.println();

        Manager addManager = new Manager(firstName, lastName, hoursWorked, hourlyRate,emailAddress);
        empAPI.addEmployee(addManager);
    }

    /**
     * Adding Sales Worker with following properties.
     */
    public void addSalesWorker(){
        System.out.print("Enter the first name of the sale worker: ");
        String firstName = input.nextLine();
        System.out.println();
        System.out.print("Enter the last name of the sale worker: ");
        String lastName = input.nextLine();
        System.out.println();
        System.out.print("Enter the emailAddress of the sale worker: ");
        String emailAddress = input.nextLine();
        System.out.println();
        System.out.print("Enter the hours worked by the sale worker: ");
        double hoursWorked = ScannerInput.readNextDouble("Enter Hours: ");
        System.out.println();
        System.out.print("Enter the hourly rate of the sale worker: ");
        double hourlyRate = ScannerInput.readNextDouble("Enter rate: ");
        System.out.println();
        System.out.print("Enter the percentage of the bonus for Sales Worker: ");
        double bonus = ScannerInput.readNextDouble("Enter % of bonus: ");
        System.out.println();

        SalesWorker addSale = new SalesWorker(firstName, lastName, hoursWorked, hourlyRate,emailAddress,bonus);
        empAPI.addEmployee(addSale);
    }

    /**
     * Adding Admin Worker with following properties.
     */
    public void addAdminWorker(){
        System.out.print("Enter the first name of the admin worker: ");
        String firstName = input.nextLine();
        System.out.println();
        System.out.print("Enter the last name of the admin worker: ");
        String lastName = input.nextLine();
        System.out.println();
        System.out.print("Enter the emailAddress of the admin worker: ");
        String emailAddress = input.nextLine();
        System.out.println();
        System.out.print("Enter the hours worked by the admin worker: ");
        double hoursWorked = ScannerInput.readNextDouble("Enter Hours: ");
        System.out.println();
        System.out.print("Enter the hourly rate of the admin worker: ");
        double hourlyRate = ScannerInput.readNextDouble("Enter Rate: ");
        System.out.println();
        System.out.print("Enter the bonus value for Sales Worker: ");
        double bonus = ScannerInput.readNextDouble("Enter allocated bonus: ");
        System.out.println();

        AdminWorker addAdmin = new AdminWorker(firstName, lastName, hoursWorked, hourlyRate,emailAddress,bonus);
        empAPI.addEmployee(addAdmin);
    }

    public void addEmployeeToDepartment(){
        System.out.println("Enter the index of the department: ");
        System.out.println(empAPI.listManagerEmployees());
        int managerindex = ScannerInput.readNextInt("");
        System.out.println(empAPI.listOfEmployees());
        int newAdd = ScannerInput.readNextInt("Enter the employee index: ");
        empAPI.addEmployeeToDepartment(newAdd,managerindex);

    }

    /**
     *Prints out list of manager employees
     * Preforms the validation on the chosen index that is the actual manager
     *
     */
    public void showEmployeeByDepartment(){
        System.out.println(empAPI.listManagerEmployees());
        int index = ScannerInput.readNextInt("Enter manager number");
        if (index >= 0 && index < empAPI.numberOfEmployees()&& empAPI.getEmployees().get(index) instanceof Manager){
            System.out.println(empAPI.listManagerEmployees((Manager)empAPI.getEmployees().get(index)));
        }
    }

    public void removeEmployeeByDept(){
        System.out.println(empAPI.listManagerEmployees());
        int index = ScannerInput.readNextInt("Enter manager number");
        if (index >= 0 && index < empAPI.numberOfEmployees()&& empAPI.getEmployees().get(index) instanceof Manager) {
            System.out.println(empAPI.listManagerEmployees((Manager) empAPI.getEmployees().get(index)));
            int employeeindex = ScannerInput.readNextInt("Enter employee index number: ");
            empAPI.removeEmployee(employeeindex, index);
        }
    }

    /**
     * Ask user to enter last name, store it in a string
     * Create new object of Employee array list
     * Parse through array list and if match is found it will print it.
     * Else give no match.
     */
    public void searchEmployees(){
        System.out.println("Enter the last name of the employee: ");
        String lastname = input.nextLine();
        ArrayList<Employee> emplist = empAPI.searchEmployees(lastname);
        if(emplist == null) {
            System.out.println("No employees in the list ");
        }else if(emplist.size() > 0){
              for(int i = 0; i < emplist.size(); i++){
                  System.out.println("Employee details" + emplist.get(i).toString());
              }
            }
        else System.out.println("No matching records");
        }
    }



