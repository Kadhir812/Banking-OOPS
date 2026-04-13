package spring_bean.springcore.src.main.java.com.example.springcore;

public class Department {
    int depId;
    String departmentName;
    Employee empObj;
    
    public Employee getEmpObj() {
        return empObj;
    }


    public void setEmpObj(Employee empObj) {
        this.empObj = empObj;
    }


    public Department() {
    }
    
   
    public Department(int depId, String departmentName) {
        this.depId = depId;
        this.departmentName = departmentName;
    }

    public int getDepId() {
        return depId;
    }
    public void setDepId(int depId) {
        this.depId = depId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

  

    @Override
    public String toString() {
        return "Department [depId=" + depId + ", departmentName=" + departmentName + ", empObj=" + empObj + "]";
    }
    
    
}
