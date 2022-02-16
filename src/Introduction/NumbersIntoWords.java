package Introduction;

import java.util.Scanner;

public class NumbersIntoWords {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number:");
            int inputNumber = scanner.nextInt();
            if (inputNumber > 0 && inputNumber < 11) {
                System.out.println(from1to10(inputNumber));

            } else {
                if (inputNumber < 21) {
                    System.out.println(from11to19(inputNumber));

                } else {
                    if (inputNumber < 100) {
                        int dozes = inputNumber / 10;
                        int unit = inputNumber % 10;
                        String dozesString = dozesFrom20to90(dozes);
                        String unitString = from1to10(unit);
                        System.out.printf("%s-%s\n", dozesString, unitString);

                    } else {
                        if (inputNumber < 1000) {
                            int hundreds = inputNumber / 100;
                            int dozes = (inputNumber / 10) % 10;
                            int unit = (inputNumber % 100) % 10;
                            String hundredString = hundredsFrom100to900(hundreds);
                            String dozesString = dozesFrom20to90(dozes);
                            String unitString = from1to10(unit);
                            System.out.printf("%s-%s-%s\n", hundredString, dozesString, unitString);
                        }
                    }
                }
            }
        }
    }

    public static String from1to10(int number) {
        String letter = "";
        switch (number) {
            case 1:
                letter = "one";
                break;
            case 2:
                letter = "two";
                break;
            case 3:
                letter = "three";
                break;
            case 4:
                letter = "four";
                break;
            case 5:
                letter = "five";
                break;
            case 6:
                letter = "six";
                break;
            case 7:
                letter = "seven";
                break;
            case 8:
                letter = "eight";
                break;
            case 9:
                letter = "nine";
                break;
            case 10:
                letter = "ten";
                break;
            default:
                break;
        }
        return letter;
    }

    public static String from11to19(int number) {
        String letter = "";
        switch (number) {
            case 11:
                letter = "eleven";
                break;
            case 12:
                letter = "twelve";
                break;
            case 13:
                letter = "thirteen";
                break;
            case 14:
                letter = "fourteen";
                break;
            case 15:
                letter = "fifteen";
                break;
            case 16:
                letter = "sixteen";
                break;
            case 17:
                letter = "seventeen";
                break;
            case 18:
                letter = "eighteen";
                break;
            case 19:
                letter = "nineteen";
                break;
            default:
                break;
        }
        return letter;
    }

    public static String dozesFrom20to90(int number) {
        String letter = "";
        switch (number) {
            case 2:
                letter = "twenty";
                break;
            case 3:
                letter = "thirty";
                break;
            case 4:
                letter = "forty";
                break;
            case 5:
                letter = "fifty";
                break;
            case 6:
                letter = "sixty";
                break;
            case 7:
                letter = "seventy";
                break;
            case 8:
                letter = "eighty";
                break;
            case 9:
                letter = "ninety";
                break;
            default:
                break;
        }
        return letter;
    }

    public static String hundredsFrom100to900(int number) {
        String letter = "";
        switch (number) {
            case 1:
                letter = "one hundred";
                break;
            case 2:
                letter = "two hundred";
                break;
            case 3:
                letter = "three hundred";
                break;
            case 4:
                letter = "four hundred";
                break;
            case 5:
                letter = "five hundred";
                break;
            case 6:
                letter = "six hundred";
                break;
            case 7:
                letter = "seven hundred";
                break;
            case 8:
                letter = "eight hundred";
                break;
            case 9:
                letter = "nine hundred";
                break;
            default:
                break;
        }
        return letter;
    }
}