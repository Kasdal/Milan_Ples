import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private ArrayList<Employee> employees;
    private Scanner input = new Scanner(System.in);
    private empAPI  empAPI;
}

    public Driver() {
        input = new Scanner(System.in);
        empAPI = new EmpAPI();
    }
    public static void main(String[] args) {
        new Driver();
        app.run();
    }
