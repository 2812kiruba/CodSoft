import java.util.*;

public class StudentGradeCalc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();
        System.out.println("*******WELCOME TO STUDENTS GRADE CALCULATOR******");
        System.out.println();
        System.out.println("ENTER YOUR MARKS OUT OF 100 :");
        System.out.println();
        int f = 0;
        System.out.println("PHYSICS :");
        int m1 = s.nextInt();
        if (m1 >= 0 && m1 <= 100)
            f++;
        System.out.println("CHEMISTRY :");
        int m2 = s.nextInt();
        if (m2 >= 0 && m2 <= 100)
            f++;
        System.out.println("BIOLOGY :");
        int m3 = s.nextInt();
        if (m3 >= 0 && m3 <= 100)
            f++;
        System.out.println("COMPUTER SCIENCE :");
        int m4 = s.nextInt();
        if (m4 >= 0 && m4 <= 100)
            f++;
        System.out.println("ENGLISH :");
        int m5 = s.nextInt();
        if (m5 >= 0 && m5 <= 100)
            f++;

        if (f == 5) {
            int total = m1 + m2 + m3 + m4 + m5;
            marks.add(total);
            int avg = (total / 5);
            marks.add(avg);

            System.out.println("Your Total mark out of 500 is : " + total);
            System.out.println();
            System.out.println("Your Average percentage out of 500 is : " + avg + " % .");
            System.out.println();
            if (avg >= 95)
                System.out.println("O - Outstanding");
            else if (avg >= 90)
                System.out.println("A+ - Excellent");
            else if (avg >= 80)
                System.out.println("A - Very Good");
            else if (avg >= 70)
                System.out.println("B+ - Can Do Better");
            else if (avg >= 60)
                System.out.println("B - Improvement needed");
            else if (avg >= 50)
                System.out.println("c - Poor");
            else if (avg >= 40)
                System.out.println("D - Very Poor");
            else if (avg < 40)
                System.out.println("F - Fail");
        } else {
            System.out.println("KINDLY ENTER YOUR MARK OUT OF 100:: TRY AGAIN THANK YOU");
        }
    }
}
