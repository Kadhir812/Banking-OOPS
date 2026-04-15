package spring.auto_wired.src.main.java.com.example.auto_wired;

import java.util.List;
import java.util.ArrayList;

import java.util.Set;
import java.util.HashSet;

import java.util.Map;
import java.util.HashMap;

public class Student {
	private int Rollno;
	private String name;
	private List<String> projects = new ArrayList<>();
    private Set<String> skills = new HashSet<>();
    private Map<String, Integer> marks = new HashMap<>();
    

	public Student() {
	}

	public int getRollno() {
		return Rollno;
	}

	public void setRollno(int rollno) {
		this.Rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getProjects() {
		return projects;
	}

	public void setProjects(List<String> projects) {
		this.projects = projects;
	}


	public List<String> getProject() {
		return projects;
	}

	public void setProject(List<String> project) {
		this.projects = project;
	}

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }
    
    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }

	@Override
	public String toString() {
		return "Student [Rollno=" + Rollno + ", name=" + name + ", projects=" + projects + ", skills=" + skills + ", marks" + marks + "]";
	}
}
