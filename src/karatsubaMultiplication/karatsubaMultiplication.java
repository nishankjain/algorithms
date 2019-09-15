package karatsubaMultiplication;

import static java.lang.Math.*;

public class karatsubaMultiplication {
    public static long multiplyInts(long int1, long int2) {
        if (int1 < 10 || int2 < 10) {
            return int1 * int2;
        }

        String str1 = Long.toString(int1);
        String str2 = Long.toString(int2);
        int len1 = str1.length();
        int len2 = str2.length();

        int power = (int) floor((float) min(len1, len2) / 2);

        long a = Long.parseLong(str1.substring(0, len1-power));
        long b = Long.parseLong(str1.substring(len1-power));
        long c = Long.parseLong(str2.substring(0, len2-power));
        long d = Long.parseLong(str2.substring(len2-power));

        long ac = multiplyInts(a, c);
        long ad_plus_bc = multiplyInts(a+b, c+d);
        long bd = multiplyInts(b, d);

        return (long) (pow(10, power * 2) * ac + pow(10, power) * (ad_plus_bc - ac - bd) + bd);
    }

    public static void main(String[] args) {
        long int1 = 31415926L;
        long int2 = 27182818L;
        long result = multiplyInts(int1, int2);
        long built_in = int1 * int2;
        System.out.println("Using Karatsuba: " + result);
        System.out.println("Using built-in: " + built_in);
        if (result == built_in) {
            System.out.println("Results match");
        }
        else {
            System.out.println("Results do not match");
        }
    }
}
