/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #3
 * Program: Student
 */
public class Student extends Person{
    private int numCourses = 0;
    private String[] courses = new String[30];
    private int[] grades = new int[30];
    
    /**
     * Initialize a new instance of Student with a name and address, calling superconstructor
     * @param name defines the name of the Student
     * @param address declares the address of the Student
     */
    public Student(String name, String address){
        super(name, address);
    }
    
    /**
     * Print the Student object as a string showing Student classification, name, and address
     * @return the Student classification, name of the Student followed by their address
     */
    public String toString(){
        return "Student: " + super.getName() + "(" + super.getAddress() + ")";
    }

    /**
     * Add a course and a corresponding grade to a students courses array and grades array
     * @param course the name of the course
     * @param grade the student's grade in that course
     */
    public void addCourseGrade(String course, int grade){
        //Make sure student doesn't have too many courses
        if(numCourses < 30){
            courses[numCourses] = course;
            grades[numCourses] = grade;
            numCourses++;
        }
        else{
            System.out.println("Student has too many courses");
        }
    }
    
    /**
     * Print a Student's list of courses and corresponding grades in those courses
     */
    public void printGrades(){
        System.out.println(this.getName() + "'s Grades:");
        //Loop through the courses and grades arrays, printing their values together
        for(int c = 0; c < numCourses; c++){
            System.out.println(courses[c] + ": " + grades[c]);
        }
    }

    /**
     * Determine the average grade between all of the courses a student takes
     * @return averagegrade the average grade between all courses
     */
    public double getAverageGrade(){
        double totalgrade = 0;
        //Loop through the grades of all of the courses
        for(int c = 0; c <= numCourses; c++){
            totalgrade = totalgrade + grades[c];
        }
        double averagegrade = totalgrade / numCourses;
        return averagegrade;
    }
}