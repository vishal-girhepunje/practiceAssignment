public class Varriable {
    int instanceVariable; // Instance variable
    
    public void exampleMethod() {
        int methodVariable; // Method variable
    }

        public static void main(String[] args) {
            // Primitive types
            int age = 25;
            double salary = 50000.5;
            char grade = 'A';
            boolean isStudent = true;
    
            // Reference types
            String name = "John Doe";
            
            // Local variable type inference (Java 10 and later)
            var count = 10;
    
            System.out.println("Age: " + age);
            System.out.println("Salary: " + salary);
            System.out.println("Grade: " + grade);
            System.out.println("Is Student: " + isStudent);
            System.out.println("Name: " + name);
            System.out.println("Count: " + count);
        }
    

}



