package ph.cary;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Date now = new Date();
        System.out.println(now);

        //strings
        String hello = "Hello ";
        String world = "World";
        System.out.println(hello.toUpperCase() + world.toUpperCase());

        //arrays
        int[] numbers = {4, 2, 1, 5, 3};
        System.out.println(numbers.length);
        Arrays.sort(numbers);
        System.out.println("sorted: " + Arrays.toString(numbers));

        //2 or more dimensional arrays
        int[][] mNumbers = new int[2][5];
        mNumbers[0][0] = 5;
        mNumbers[1][4] = 3;

        int[][] mNumbers2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("[2][5]: " + Arrays.deepToString(mNumbers));
        System.out.println("[2][3]: " + Arrays.deepToString(mNumbers2));

        int x = 1;
        int y = x++;
        System.out.println(x);
        System.out.println(y);

        //implicit casting
        //bte > short > int > long > float > double
        short a = 1;
        int b = a + 2;
        System.out.println("implicit casting: " + b);

        //explicit casting
        double c = 1.1;
        int d = (int)c + 2;
        System.out.println("explicit casting: " + d);

        //parsing string to int
        String e = "1";
        int f = Integer.parseInt(e) + 2;
        System.out.println("parsing string: " + f);

        //math random
        int g = (int)(Math.random() * 100);
        System.out.println("random: " + g);

        //formatting numbers
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String dollar = currency.format(53423212.12);
        System.out.println(dollar);

        //input
        Scanner scanner = new Scanner(System.in);
        System.out.print("age: ");
        int age = scanner.nextInt();
        System.out.println("your age is: " + age);

    }
}