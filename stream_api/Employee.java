package stream_api;

class Employee {
    int empId;
    String name;
    double salary;
    
    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }    

    @Override
    public String toString() {
            return "ID: " + empId + ", Name: " + name + ", Salary: " + salary;
    }
}
