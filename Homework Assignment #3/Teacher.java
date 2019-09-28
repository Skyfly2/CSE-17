/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #3
 * Program: Teacher
 */
public class Teacher extends Person{
    private int numCourses = 0;
    private String[] courses = new String[5];

    /**
     * Initialize a new instance of Teacher with a name and address, calling superconstructor
     * @param name defines the name of the Teacher
     * @param address declares the address of the Teacher
     */
    public Teacher(String name, String address){
        super(name, address);
    }

    /**
     * Print the Teacher object as a string showing Teacher classification, name, and address
     * @return the Teacher classification, name of the Teacher followed by their address
     */
    public String toString(){
        return "Teacher: " + super.getName() + "(" + super.getAddress() + ")";
    }

    /**
     * Add a course to a Teacher's array of courses
     * @param course the name of the course
     * @return true if the course can be added, false if it can not
     */
    public boolean addCourse(String course){
        if(numCourses >= 5){
            System.out.println("Teacher already has the maximum amount of courses");
            return false;
        }

        //Loop through the courses of the teacher to see if the course is already there
        for(int c = 0; c < numCourses; c++){
            if(courses[c] != null){
                if(courses[c].equals(course)){
                    return false;
                }
            }
        }

        //Loop through to add the course
        for(int c = 0; c <= numCourses; c++){
            if(courses[c] == null || c == numCourses){
                courses[c] = course;
                numCourses++;
                break;
            }
        }
        return true;
    }

    /**
     * Remove a course from a Teacher's array of courses
     * @param course the name of the course to be removed
     * @return true if the course is found and removed, false if the course could not be found
     */
    public boolean removeCourse(String course){
        boolean found = false;
        for(int c = 0; c < numCourses; c++){
            if(courses[c] != null){
                if(courses[c].equals(course)){
                    found = true;
                    courses[c] = null;
                    break;
                }
            }
            else if(c == numCourses){
                found = false;
            }
        }
        return found;
    }
}