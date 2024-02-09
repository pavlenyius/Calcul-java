import java.util.Scanner;

public class Calcul {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите выражение в формате '((Число a) операция (число b))': ");
            String inputData = scanner.nextLine();
            System.out.println("Вводные данные: " + inputData);
            System.out.println("Результат вычислений:  " + (calc(inputData)));
            System.out.println("____________________");
            System.out.println("Отличный результат!");

        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        } finally {
            scanner.close();
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" "); 
        if (parts.length != 3) {
            throw new Exception("Неверный формат ввода");
        }

        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[2]);
        char operation = parts[1].charAt(0);

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Числа должны быть в диапазоне от 1 до 10");
        }

        switch (operation) {
            case '+':
                return String.valueOf(num1 + num2);
            case '-':
                return String.valueOf(num1 - num2);
            case '*':
                return String.valueOf(num1 * num2);
            case '/':
                if (num2 == 0) {
                    throw new Exception("Деление на ноль");
                }
                return String.valueOf(num1 / num2);
            default:
                throw new Exception("Неверная операция");
        }
    }
}
