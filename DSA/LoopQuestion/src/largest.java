import java.util.Scanner;

public class largest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();
        int b=sc.nextInt();
        int c= sc.nextInt();

        /*Q. Find the largest of Three number*/
//        int max=a;
//        if(b>a)max=b;
//        if(c>max)max=c;
//        System.out.println(max);

        int max=Math.max(a,Math.max(b,c));
        System.out.println(max);

    }
}
