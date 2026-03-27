package com.example.junit;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public String calculateGrade(int marks) {
        if (marks >= 90) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }

    
    public boolean checkAge(int age) {
        if (age >= 18)
            {
                return true;
                
            }   else {
                return false;
            }
            
        }
        
        public boolean checkExperience(int years) {
            return years >= 2;
        }
        
        public String checkName(String name) {
            return name;
        }
        

   
}
