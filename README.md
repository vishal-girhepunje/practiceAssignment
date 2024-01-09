# practiceAssignment
all about DSA problem
Patterns - Part 1











import java.util.*;


public class Patterns {
   public static void main(String args[]) {
       int n = 5;
       int m = 4;
       for(int i=0; i<n; i++) {
           for(int j=0; j<m; j++) {
               System.out.print("*");
           }
           System.out.println();
       }
   }
}





















import java.util.*;


public class Patterns {
   public static void main(String args[]) {
       int n = 5;
       int m = 4;
       for(int i=0; i<n; i++) {
           for(int j=0; j<m; j++) {
               if(i == 0 || i == n-1 || j == 0 || j == m-1) {
                   System.out.print("*");
               } else {
                   System.out.print(" ");
               }
           }
           System.out.println();
       }
   }
}

























import java.util.*;


public class Patterns {
   public static void main(String args[]) {
       int n = 4;
      
       for(int i=1; i<=n; i++) {
           for(int j=1; j<=i; j++) {
                   System.out.print("*");
           }
           System.out.println();
       }
   }
}





























import java.util.*;


public class Patterns {
   public static void main(String args[]) {
       int n = 4;
      
       for(int i=n; i>=1; i--) {
           for(int j=1; j<=i; j++) {
                   System.out.print("*");
           }
           System.out.println();
       }
   }
}




























import java.util.*;


public class Patterns {
   public static void main(String args[]) {
       int n = 4;
      
       for(int i=n; i>=1; i--) {
           for(int j=1; j<i; j++) {
               System.out.print(" ");
           }


           for(int j=0; j<=n-i; j++) {
               System.out.print("*");
           }
           System.out.println();
       }
   }
}






















import java.util.*;


public class Patterns {
   public static void main(String args[]) {
       int n = 5;
      
       for(int i=1; i<=n; i++) {
           for(int j=1; j<=i; j++) {
               System.out.print(j);
           }
           System.out.println();
       }
   }
}
























import java.util.*;


public class Patterns {
   public static void main(String args[]) {
       int n = 5;
      
       for(int i=n; i>=1; i--) {
           for(int j=1; j<=i; j++) {
               System.out.print(j);
           }
           System.out.println();
       }
   }
}






















import java.util.*;


public class Patterns {
   public static void main(String args[]) {
       int n = 5;
       int number = 1;


       for(int i=1; i<=n; i++) {
           for(int j=1; j<=i; j++) {
               System.out.print(number+" ");
               number++;
           }
           System.out.println();
       }
   }
}





















import java.util.*;


public class Patterns {
   public static void main(String args[]) {
       int n = 5;


       for(int i=1; i<=n; i++) {
           for(int j=1; j<=i; j++) {
               if((i+j) % 2 == 0) {
                   System.out.print(1+" ");
               } else {
                   System.out.print(0+" ");
               }
           }
           System.out.println();
       }
   }
}













Homework Problems (Solutions in next Lecture’s Video)
Print a solid rhombus.





Print a number pyramid.





Print a palindromic number pyramid.
	










Homework Solution (Lecture 4)

Print all even numbers till n.

public class Solutions {
   public static void main(String args[]) {
       int n = 25;


       for(int i=1; i<=n; i++) {
           if(i % 2 == 0) {
               System.out.println(i);
           }
       }
   }   
}



    3.  Make a menu driven program. The user can enter 2 numbers, either 1 or 0. 
If the user enters 1 then keep taking input from the user for a student’s marks(out of 100). 
If they enter 0 then stop.
If he/ she scores :
Marks >=90 -> print “This is Good”
89 >= Marks >= 60 -> print “This is also Good”
59 >= Marks >= 0 -> print “This is Good as well”
	Because marks don’t matter but our effort does.
(Hint : use do-while loop but think & understand why)

import java.util.*;


public class Solutions {
   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       int input;


       do {
           int marks = sc.nextInt();
           if(marks >= 90 && marks <= 100) {
               System.out.println("This is Good");
           } else if(marks >= 60 && marks <= 89) {
               System.out.println("This is also Good");
           } else if(marks >= 0 && marks <= 59) {
               System.out.println("This is Good as well");
           } else {
               System.out.println("Invalid");
           }


           System.out.println("Want to continue ? (yes(1) or no(0))");
           input = sc.nextInt();
      
       } while(input == 1);
   }   
}



Qs. Print if a number n is prime or not (Input n from the user). 
[In this problem you will learn how to check if a number is prime or not]
import java.util.*;


public class Solutions {
   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();


       boolean isPrime = true;
       for(int i=2; i<=n/2; i++) {
           if(n % i == 0) {
               isPrime = false;
               break;
           }
       }


       if(isPrime) {
           if(n == 1) {
               System.out.println("This is neither prime not composite");
           } else {
               System.out.println("This is a prime number");
           }
       } else {
           System.out.println("This is not a prime number");
       }
   }   
}


  
