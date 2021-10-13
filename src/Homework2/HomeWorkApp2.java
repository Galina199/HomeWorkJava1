package Homework2;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        System.out.println(summ(15, 8));
        isPositiveOrNegative(8);
        System.out.println(isNegative(19));
        printWordNTimes();
        LeapYear(1996);
    }



    public static boolean summ(int a, int b) {
        int sum = a + b;
        if (sum > 10 && sum < 20) {
            return true;
        } else return false;
    }
    public static void isPositiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Число " + a + "положительное");
        } else {
            System.out.println("Число " + a + " отрицательное");
        }
    }
    public static boolean isNegative(int a) {
        return a < 0;
    }
    public static void printWordNTimes() {
        for ( int b = 0; b < 5; b++) {
            System.out.println("String word!");
        }
    }
    public  static void LeapYear(int y) {
        if (!(y % 4 == 0) || ((y % 100 == 0) && !(y % 400 == 0)))
            System.out.println(y + " г. не високосный");
        else System.out.println(y + " г. високосный");
    }
}

