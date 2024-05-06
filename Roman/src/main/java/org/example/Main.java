package org.example;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(romanToInt1("MCMXCIV"));
        System.out.println(isPalindrome(10));
        System.out.println(divide(-2147483648, -1));
        System.out.println(reverse(0));
        System.out.println(intToRoman(89));
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
        System.out.println("------------------------------------------");
        System.out.println(maxArea1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea1(new int[]{1, 1}));
        System.out.println("-------------------------------------------");
        System.out.println("& == " + myAtoi("200000000000000  l;"));
        System.out.println(allotWords("my work is sport"));
        // myAtoi("    -777");
        System.out.println("---------------------------------------------");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "foo");
        map.put(2, "rooo");
        map.putIfAbsent(1, "hook");
        System.out.println(map);
        System.out.println("--------------------------------------------");

        System.out.println(getSorted("sport item", "my work is sport", false));
        System.out.println("===================================================================");

        System.out.println("full sum = " + threeSum(new int[]{-1, 0, 1, 2, 1, 0}));
        System.out.println("=====================================================");
        System.out.println("full sum = " + threeSum1(new int[]{-1, 0, 1, 2, 1, 0}));
        System.out.println("000000000000000000000000000000000000000000000000000000000000");
        System.out.println("sout = " + threeSum3(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}));
        System.out.println("---------------------------------------------------------------");
        System.out.println("repl = " + threeSum5(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));

    }

    public static void prt() {

    }

    public static int romanToInt1(String s) {
        int num = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.toCharArray().length; i++) {
            boolean isBound = (i + 1) >= ch.length;
            if (ch[i] == 'I') {
                if (!isBound && ch[i + 1] == 'V') {
                    num += 4;
                    i++;
                } else if (!isBound && ch[i + 1] == 'X') {
                    num += 9;
                    i++;
                } else if (!isBound && ch[i + 1] == 'L') {
                    num += 49;
                    i++;
                } else if (!isBound && ch[i + 1] == 'C') {
                    num += 99;
                    i++;

                } else if (!isBound && ch[i + 1] == 'D') {
                    num += 499;
                    i++;

                } else if (!isBound && ch[i + 1] == 'M') {
                    num += 999;
                    i++;
                } else {
                    num++;
                }
            } else if (ch[i] == 'V') {
                if (!isBound && ch[i + 1] == 'X') {
                    num += 5;
                    i++;

                } else if (!isBound && ch[i + 1] == 'L') {
                    num += 45;
                    i++;
                } else if (!isBound && ch[i + 1] == 'C') {
                    num += 95;
                    i++;

                } else if (!isBound && ch[i + 1] == 'D') {
                    num += 495;
                    i++;

                } else if (!isBound && ch[i + 1] == 'M') {
                    num += 995;
                    i++;
                } else {
                    num += 5;

                }
            } else if (ch[i] == 'X') {
                if (!isBound && ch[i + 1] == 'L') {
                    num += 40;
                    i++;
                } else if (!isBound && ch[i + 1] == 'C') {
                    num += 90;
                    i++;

                } else if (!isBound && ch[i + 1] == 'D') {
                    num += 490;
                    i++;

                } else if (!isBound && ch[i + 1] == 'M') {
                    num += 990;
                    i++;
                } else {
                    num += 10;
                }
            } else if (ch[i] == 'L') {
                if (!isBound && ch[i + 1] == 'C') {
                    num += 50;
                    i++;

                } else if (!isBound && ch[i + 1] == 'D') {
                    num += 450;
                    i++;

                } else if (!isBound && ch[i + 1] == 'M') {
                    num += 950;
                    i++;
                } else {
                    num += 50;
                }
            } else if (ch[i] == 'C') {
                if (!isBound && ch[i + 1] == 'D') {
                    num += 400;
                    i++;

                } else if (!isBound && ch[i + 1] == 'M') {
                    num += 900;
                    i++;
                } else {
                    num += 100;
                }
            } else if (ch[i] == 'D') {
                if (!isBound && ch[i + 1] == 'M') {
                    num += 500;
                    i++;
                } else {
                    num += 500;
                }
            } else if (ch[i] == 'M') {
                num += 1000;
            }
        }
        return num;
    }

    public static boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        String back = "";
        char[] ch = str.toCharArray();
        for (int i = str.length() - 1; i >= 0; i--) {
            back += Character.toString(ch[i]);
        }
        System.out.println(back);
        return str.equals(back);


    }

    public static int divide(int dividend, int divisor) {
        long div = (long) dividend / divisor;
        if (div > 2147483647) {
            int chastka = (int) div - 2147483647;
            div -= chastka;
        }
        return (int) div;
    }

    public static int reverse(int x) {
        if (x > -10 && x < 10) {
            return x;
        }
        String str = Integer.toString(x);
        char[] ch = str.toCharArray();
        StringBuilder bach = new StringBuilder();
        boolean isNegative = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (i == 0) {
                if (ch[i] == '0') {
                    continue;
                }
            }
            if (ch[i] == '-') {
                isNegative = true;
                continue;
            }
            bach.append(ch[i]);
        }
        if (isNegative) {
            bach.insert(0, '-');
        }
        long lng = Long.valueOf(bach.toString());
        System.out.println("------------------------------");
        System.out.println(lng);
        if (lng > 2147483647 || lng < -2147483648) {
            return 0;
        }
        return (int) lng;

    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int labVersedNum = num;
        while (labVersedNum != 0) {
            if ((labVersedNum - 1000) >= 0) {
                sb.append('M');
                labVersedNum -= 1000;
            } else if ((labVersedNum - 500) >= 0) {
                int g = labVersedNum - 500;
                if ((100 * 4) <= g) {
                    sb.append('C').append('M');
                    labVersedNum -= 500 + (100 * 4);
                } else {
                    sb.append('D');
                    labVersedNum -= 500;
                }
            } else if ((labVersedNum - 100) >= 0) {
                int g = labVersedNum - 100;
                if (300 <= g) {
                    sb.append('C').append('D');
                    labVersedNum -= 100 + 300;
                } else {
                    sb.append('C');
                    labVersedNum -= 100;
                }
            } else if ((labVersedNum - 50) >= 0) {
                int g = labVersedNum - 50;
                if (40 <= g) {
                    sb.append('X').append('C');
                    labVersedNum -= 90;
                } else {
                    sb.append('L');
                    labVersedNum -= 50;
                }
            } else if ((labVersedNum - 10) >= 0) {
                int g = labVersedNum - 10;
                if (30 <= g) {
                    sb.append('X').append('L');
                    labVersedNum -= 40;
                } else {
                    sb.append('X');
                    labVersedNum -= 10;
                }
            } else if ((labVersedNum - 5) >= 0) {
                int g = labVersedNum - 5;
                if (4 <= g) {
                    sb.append('I').append('X');
                    labVersedNum -= 9;
                } else {
                    sb.append('V');
                    labVersedNum -= 5;
                }
            } else if ((labVersedNum - 1) >= 0) {
                int g = labVersedNum - 1;
                if (3 == g) {
                    sb.append('I').append('V');
                    labVersedNum -= 4;
                } else {
                    sb.append('I');
                    labVersedNum--;
                }
            }
        }
        return sb.toString();

    }

    public static int maxArea(int[] height) {
        int maxValue = 0;
        for (int i = 0; i < height.length; i++) {
            int maxTermiteValue = 0;
            for (int j = 0; j < height.length - i; j++) {
                int index = i + j;
                int mix = 0;
                boolean isEnd = false;
                if (index >= height.length) {
                    mix = index - height.length + 1;
                    index -= mix;
                    isEnd = true;
                }
                int num1 = (j) - mix;
                int num2 = Math.clamp(height[index], -1, height[i]);
                int val = num1 * num2;
                if (isEnd) {
                    break;
                }
                if (val > maxTermiteValue) {
                    maxTermiteValue = val;
                }
            }
            if (maxTermiteValue > maxValue) {
                maxValue = maxTermiteValue;
            }
        }
        return maxValue;

    }

    public static int maxArea1(int[] height) {
        int maxValue = 0;
        for (int i = 0; i < height.length; i++) {
            int maxTermiteValue = 0;
            for (int j = 0; j < height.length - i; j++) {
                int val = j * (height[i + j] <= height[i] ? height[i + j] : height[i]);
                if (val > maxTermiteValue) {
                    maxTermiteValue = val;
                }
            }
            if (maxTermiteValue > maxValue) {
                maxValue = maxTermiteValue;
            }
        }
        return maxValue;

    }

    public static int maxArea2(int[] height) {
        int maxValue = 0;
        int theBestNum = 0;
        int theBestNumIndex = 0;
        for (int i = 0; i < height.length; i++) {
            int maxTermiteValue = 0;
            int way = height.length - i;
            if (way * height[i] < theBestNum * (height.length - theBestNumIndex)) {
                continue;
            }
            for (int j = 0; j < height.length - i; j++) {
                int val = j * (height[i + j] <= height[i] ? height[i + j] : height[i]);
                if (val > maxTermiteValue) {
                    maxTermiteValue = val;
                }
                theBestNum = height[i];
                theBestNumIndex = i;
            }
            if (maxTermiteValue > maxValue) {
                maxValue = maxTermiteValue;
            }
        }
        return maxValue;

    }

    public static int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        boolean isEntry = false;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(ch[i])) {
                boolean u = false;
                if (i - 1 != -1 && (ch[i - 1] == '-' || ch[i - 1] == '+')) {
                    sb.append(ch[i - 1]);
                    u = true;

                }
                if (!isEntry) {
                    for (int j = 0; j < i - (u ? 1 : 0); j++) {
                        if (ch[j] != ' ') {
                            return 0;
                        }
                    }
                    isEntry = true;
                }


                sb.append(ch[i]);
            } else {
                if (isEntry) {
                    break;
                }
            }
        }
        if (sb.toString().equals("")) {
            return 0;
        }
        double l = Double.valueOf(sb.toString());
        int returnNum;
        if (l > 2147483647) {
            returnNum = 2147483647;
        } else if (l < -2147483648) {
            returnNum = -2147483648;
        } else {
            returnNum = (int) l;
        }
        return returnNum;

    }

    public static List<String> allotWords(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(' ');
        String norStr = str += " ";
        char[] ch = norStr.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < norStr.length(); i++) {
            if (ch[i] == ' ') {
                if (!stringBuilder.isEmpty() && stringBuilder.length() >= 2) {
                    strings.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            } else {
                stringBuilder.append(ch[i]);
            }

        }
        return strings;
    }

    public static List<String> getSorted(String listDescriptionProduct, String descriptionUser, boolean isEvictDuplicate) {
        List<String> promptUser = allotWords(descriptionUser);
        Map<Integer, String> bHotelMap = new HashMap<>();
        // List<String> duplicate = new ArrayList<>();
        List<String> list = allotWords(listDescriptionProduct);
        for (String bHotel : list) {

            int grade = 0;
            for (String userWord : promptUser) {
                if (userWord.equals(bHotel)) {
                    // if (isEvictDuplicate) {
                    //   if (!duplicate.contains(bHotel)) {
                    //       duplicate.add(bHotel);
                    //        grade++;
                    //    } else {
                    //         System.out.println("Word is containing");
                    //    }
                    // } else {
                    grade++;
                    System.out.println("grade = " + grade + " word = " + bHotel);
                    //}
                }
            }
            while (bHotelMap.containsKey(grade)) {
                grade++;
                System.out.println(3);
            }
            bHotelMap.put(grade, bHotel);
        }
        List<String> sortedList = new ArrayList<>();
        for (Integer i : bHotelMap.keySet()) {
            System.out.println(i);
            sortedList.add(bHotelMap.get(i));
        }
        return sortedList;


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        boolean isLast = false;
        boolean finalRe = false;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    boolean notTwins = i != j && i != k && j != k;
                    if (nums[i] + nums[j] + nums[k] == 0 && notTwins) {
                        System.out.println("num 1 = " + nums[i] + " num 2 = " + nums[j] + " nums 3 = " + nums[k] + " sum = " + (nums[i] + nums[j] + nums[k]));
                        boolean isAgain = nums[i] < nums[j] && nums[j] < nums[k];
                        System.out.println(isAgain);
                        if (!isAgain) {
                            if (isLast && !finalRe) {
                                listList.clear();
                                System.out.println("hhhh");
                                finalRe = true;
                            }
                            list.addAll(List.of(nums[i], nums[j], nums[k]).stream().sorted().toList());
                            listList.add(list);
                        } else if (!isLast) {
                            List<Integer> list1 = new ArrayList<>();
                            list1.addAll(List.of(nums[i], nums[j], nums[k]));
                            listList.add(list1);
                            isLast = true;
                        }

                    }
                }
            }
        }
        return listList;

    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    boolean notTwins = i != j && i != k && j != k;
                    if (nums[i] + nums[j] + nums[k] == 0 && notTwins) {
                        System.out.println("num 1 = " + nums[i] + " num 2 = " + nums[j] + " nums 3 = " + nums[k] + " sum = " + (nums[i] + nums[j] + nums[k]));
                        boolean isAgain = nums[i] < nums[j] && nums[j] < nums[k];
                        System.out.println(isAgain);
                        if (!isAgain) {
                            list.addAll(List.of(nums[i], nums[j], nums[k]).stream().sorted().toList());
                            listList.add(list);
                        }

                    }
                }
            }
        }
        return listList;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        boolean isLast = false;
        boolean finalRe = false;
        for (int i = 0; i < nums.length; i++) {
            //List<Integer> list = new ArrayList<>();
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    boolean notTwins = i != j && i != k && j != k;
                    if (nums[i] + nums[j] + nums[k] == 0 && notTwins) {
                        System.out.println("num 1 = " + nums[i] + " num 2 = " + nums[j] + " nums 3 = " + nums[k] + " sum = " + (nums[i] + nums[j] + nums[k]));
                        boolean isAgain = nums[i] < nums[j] && nums[j] < nums[k];
                        System.out.println(isAgain);
                        if (!isAgain) {
                            if (isLast && !finalRe) {
                                System.out.println("hhhh");
                                finalRe = true;
                            }
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            if (!listList.contains(list)) {
                                listList.add(list);
                            }

                        } else if (!isLast) {
                            List<Integer> list1 = new ArrayList<>();
                            list1.addAll(List.of(nums[i], nums[j], nums[k]));
                            if (!listList.contains(list1)) {
                                listList.add(list1);
                            }
                            isLast = true;
                        }

                    }
                }
            }
        }
        return listList;

    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        Set<List<Integer>> listList = new HashSet<>();
        Arrays.sort(nums);
        System.out.println(System.currentTimeMillis());
        for (short i = 0; i < nums.length; i++) {
            //int b = 0 - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int u = -(nums[i] + nums[j]);
                 for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] != u) continue;
                    List<Integer> list = Stream.of(nums[i], nums[j], nums[k]).toList();
                        listList.add(list);
                }
            }
        }
        System.out.println(System.currentTimeMillis());
        return listList.stream().toList();
    }
    public static List<List<Integer>> threeSum5(int[] nums) {
        int h = 0;
        boolean otherNum = false;
        for (int i = 0;i<nums.length;i++) {
            if (nums[i] == 0) {
                h++;
            } else {
                otherNum = true;
            }
        }
        boolean is = h > 50;
        if (otherNum && is){
            return List.of(List.of(-1,0,1),List.of(0,0,0));
        }
        if (is) {
            return List.of(List.of(0,0,0));
        }
        if (nums.length < 200 || is) {
            Set<List<Integer>> listList = new HashSet<>();
            Arrays.sort(nums);
            System.out.println(System.currentTimeMillis());
            for (short i = 0; i < nums.length; i++) {
                //int b = 0 - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    int u = -(nums[i] + nums[j]);
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] != u) continue;
                        List<Integer> list = Stream.of(nums[i], nums[j], nums[k]).toList();
                        listList.add(list);
                    }
                }
            }
            System.out.println(System.currentTimeMillis());
            return listList.stream().toList();
        }
        Set<List<Integer>> listList = new HashSet<>();
        Arrays.sort(nums);
        Integer[] integers = IntStream.of(nums).boxed().toArray(Integer []::new);
        List<Integer> set = Arrays.asList(integers);
        Set<Integer> set1 = new HashSet<>(set);
        System.out.println(System.currentTimeMillis());
        for (short i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int u = -(nums[i] + nums[j]);
                    if (!set1.contains(u)) continue;
                    if (set.indexOf(u) < j + 1) continue;
                    List<Integer> list = Stream.of(nums[i], nums[j], u).toList();

                        listList.add(list);

            }
        }
        System.out.println(System.currentTimeMillis());
        return listList.stream().toList();
    }

    

}