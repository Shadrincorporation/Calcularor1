package calcRA;

import java.util.*;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;
    static List roman = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");


    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение в формате Х+Х:");
        String input = scanner.nextLine();

        String result = calc(input);

        System.out.println("Результат");
        System.out.println(number1 + " " + operation + " " + number2 + " = " + result);


    }


    public static String calc(String input) throws Exception {
        char[] under_char = new char[10];
        for (int i = 0; i < input.length(); i++) {
            under_char[i] = input.charAt(i);

            if (under_char[i] == '+') {
                operation = '+';
            }

            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String[] blocks = input.split("[+-/*]");

        if (blocks[0].equals("") && blocks[1].equals(""))
        {
            throw new Exception("Может быть только 2 числа и один символ");
        }
        String stable00 = blocks[0];
        String stable01 = blocks[1];
        if (blocks.length > 2) {
            throw new Exception("Вы ввели более 2х аргументов");
        }
        if (roman.contains(stable00) && roman.contains(stable01)) {
            number1 = Main.romanToNumber(stable00);
            number2 = Main.romanToNumber(stable01);
            if (number1 < 1 && number2 < 1 && number1 > 10 && number2 > 10) {
                throw new IllegalArgumentException("Вы ввели число менее 1 или более 10. Введите число от 1 до 10 включительно");
            } else{
                try {
                    result = calculated(number1, number2, operation);
                    String resultRoman = numberToRoman(result);
                    return resultRoman;
                } catch (Exception e) {

                }
            }
        } else if(!roman.contains(stable00) && !roman.contains(stable01)) {
            if (number1 < 1 || number2 < 1 || number1 > 10 || number2 > 10) {
                throw new IllegalArgumentException("Вы ввели число менее 1 или более 10. Введите число от 1 до 10 включительно");
            }
            number1 = Integer.parseInt(stable00);
            number2 = Integer.parseInt(stable01);
            try {
                result = calculated(number1, number2, operation);
                return String.valueOf(result);
            } catch (Exception e) {
            }
        }
        throw new IllegalArgumentException("Введите оба числа в одной системе записи");
    }

    private static int romanToNumber(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        }
        throw new RuntimeException("Введите число от 1 до 10 или от I до X");

    }
    public static int calculated(int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Деление на ноль запрещено.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Знак не поддерживается");
        }
        return result;
    }

    private static String numberToRoman(int number) {
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return hundreds[(number / 100) % 10] +
                tens[(number / 10) % 10] +
                ones[number % 10];
    }
}