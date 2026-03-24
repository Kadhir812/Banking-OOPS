
interface Employee {
    void calculateSalary();
    void displayDetails();
    int getEmpId();
}

class TemporaryEmployee implements Employee {
    int empId;
    String name;
    int hoursWorked;
    double ratePerHour;
    double salary;

    TemporaryEmployee(int empId, String name, int hoursWorked, double ratePerHour) {
        this.empId = empId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public void calculateSalary() {
        salary = hoursWorked * ratePerHour;
        System.out.println("Temporary Employee Salary: " + salary);
    }

    public void displayDetails() {
        System.out.println("ID: " + empId + ", Name: " + name + ", Type: Temporary, Salary: " + salary);
    }

    public int getEmpId() {
        return empId;
    }
}

class PermanentEmployee implements Employee {
    int empId;
    String name;
    double basicSalary;
    double bonus;
    double salary;

    PermanentEmployee(int empId, String name, double basicSalary, double bonus) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    public void calculateSalary() {
        salary = basicSalary + bonus;
        System.out.println("Permanent Employee Salary: " + salary);
    }

    public void displayDetails() {
        System.out.println("ID: " + empId + ", Name: " + name + ", Type: Permanent, Salary: " + salary);
    }

    public int getEmpId() {
        return empId;
    }
}


import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();

        while (true) {
            System.out.println("\n1.Add Temporary\n2.Add Permanent\n3.Calculate Salary\n4.Display\n5.Search\n6.Update\n7.Exit");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID, Name, Hours, Rate: ");
                    int tid = sc.nextInt();
                    String tname = sc.next();
                    int hours = sc.nextInt();
                    double rate = sc.nextDouble();
                    list.add(new TemporaryEmployee(tid, tname, hours, rate));
                    break;

                case 2:
                    System.out.print("Enter ID, Name, Basic, Bonus: ");
                    int pid = sc.nextInt();
                    String pname = sc.next();
                    double basic = sc.nextDouble();
                    double bonus = sc.nextDouble();
                    list.add(new PermanentEmployee(pid, pname, basic, bonus));
                    break;

                case 3:
                    for (Employee e : list) {
                        e.calculateSalary();  // runtime polymorphism
                    }
                    break;

                case 4:
                    for (Employee e : list) {
                        e.displayDetails();
                    }
                    break;

                case 5:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    for (Employee e : list) {
                        if (e.getEmpId() == sid) {
                            e.displayDetails();
                        }
                    }
                    break;

                case 6:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();

                    for (Employee e : list) {
                        if (e.getEmpId() == uid) {

                            if (e instanceof TemporaryEmployee) {
                                TemporaryEmployee t = (TemporaryEmployee) e;
                                System.out.print("Enter new hours and rate: ");
                                t.hoursWorked = sc.nextInt();
                                t.ratePerHour = sc.nextDouble();
                            } else if (e instanceof PermanentEmployee) {
                                PermanentEmployee p = (PermanentEmployee) e;
                                System.out.print("Enter new basic and bonus: ");
                                p.basicSalary = sc.nextDouble();
                                p.bonus = sc.nextDouble();
                            }
                        }
                    }
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}