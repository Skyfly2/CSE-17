public class TestPerson{
    public static void main(String[] args){
        //Test Student
        Student student1 = new Student("Thorn McNally", "1754 Falcon Drive");
        student1.addCourseGrade("CSE017", 92);
        student1.addCourseGrade("CSE340", 88);
        System.out.println(student1.toString());
        System.out.println("Student Grades: ");
        student1.printGrades();
        System.out.println("Average is: " + student1.getAverageGrade());
        System.out.println();
        
        //Test Teacher
        Teacher teacher1 = new Teacher("Arielle Carr", "Packard 200B");
        System.out.println(teacher1.toString());
        String[] courses = {"CSE017", "CSE340", "CSE017"};
        for(int i = 0; i < courses.length; i++){
            String course = courses[i];
            if(teacher1.addCourse(course)){
                System.out.println(course + " added to teacher schedule.");
            }
            else{
                System.out.println(course + " could not be added to the teacher's schedule.");
            }
        }
        for(int i = 0; i < courses.length; i++){
            String course = courses[i];
            if(teacher1.removeCourse(course)){
                System.out.println(course + " removed from teacher schedule.");
            }
            else{
                System.out.println(course + " cannot be removed from teacher schedule.");
            }
        }
        System.out.println();
        
        //Test Person
        Person person1 = new Person("Charlie", "1883 Green Road");
        System.out.println(person1.toString());
        System.out.println("Person Name: " + person1.getName());
        System.out.println("Address: " + person1.getAddress());
        String newAddress = "1123 Orange Road";
        System.out.println("Update address to " + newAddress);
        person1.setAddress(newAddress);
        System.out.println("New Address: " + person1.getAddress());
    } 
}