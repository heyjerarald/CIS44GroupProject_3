package cis44groupproject;

/**
 *
 * @author chuongtruong
 */


public class Student implements  Comparable<Student> {
    
    private String fName;
    private String lName;
    private double GPA;
    public static int count;
    
    public Student (String fName, String lName, double GPA)
    {
        this.fName = fName;
        this.lName = lName;
        this.GPA = GPA;
        count++;
    }

    public String getfName() {
        return this.fName;
    }

      public String getlName() {
        return this.lName;
    }
    
    public double getGPA() {
        return this.GPA;
    }
    
    
    public void setFName(String fName) {
        this.fName = fName;
    }
    
    public void setLName(String lName) {
       this.lName = lName;
    }
    
    public void setGPA(double GPA)
    {
        this.GPA = GPA;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s%6s%12.2f", this.fName , this.lName, this.GPA);
    }
    
    @Override
    public int compareTo(Student s)
    {
        if (this.GPA > s.GPA )
            return 1;
        else if (this.GPA == s.GPA)
            return 0;
        else
            return -1;
    }
    
    public static int getCount()
    {
        return count;
    }
}

