package calcRA;
import java.util.*;


public class RomanArabianCalc {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;
    static List roman = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");


    public static void main(String[] args) {
        System.out.println("Введите выражение в формате Х+Х:");
        String userInput = scanner.nextLine();
        char[] under_char = new char[5];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);

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
        String[] blacks = userInput.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        if (roman.contains(stable00) || roman.contains(stable01)) {
            number1 = romanToNumber(stable00);
            number2 = romanToNumber(stable01);
            if (number1 < 1 && number2 < 1 && number1 < 11 && number2 < 11) {
                System.out.println("Вы ввели число менее 1 или более 10. Введите число от 1 до 10 включительно");
                return;
            } else {
                result = calculated(number1, number2, operation);
                String resultRoman = numberToRoman(result);
                System.out.println("Результат");
                System.out.println(stable00 + " " + operation + " " + stable01 + " = " + resultRoman);
            }
        } else {
            if (number1 < 1 && number2 < 1 && number1 < 11 && number2 < 11) {
                System.out.println("Вы ввели число менее 1 или более 10. Введите число от 1 до 10 включительно");
                return;
            }
            number1 = Integer.parseInt(stable00);
            number2 = Integer.parseInt(stable01);
            result = calculated(number1, number2, operation);
            System.out.println("Результат");
            System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
        }
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
        return -1;
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
                    System.err.println("на ноль нельзя делить");
                }
                result = num1 / num2;
                break;
            default:
                System.err.println("Знак не поддерживается");
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