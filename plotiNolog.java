import java.util.Scanner;

public class plotiNolog {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);

            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    int money = Integer.parseInt(scanner.nextLine());
                    earnings += money;
                    break;

                case 2:
                    System.out.println("Введите сумму расхода:");
                    int expenses = Integer.parseInt(scanner.nextLine());
                    spendings += expenses;
                    break;

                case 3:
                    int taxEarnings = taxEarnings(earnings);
                    int taxEarningsMinusSpendings = taxEarningsMinusSpendings(earnings, spendings);

                    if (taxEarnings < taxEarningsMinusSpendings) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + taxEarnings + " рублей");
                        System.out.println("Налог на другой системе: " + taxEarningsMinusSpendings + " рублей");
                        System.out.println("Экономия: " + (taxEarningsMinusSpendings - taxEarnings) + " рублей");
                    } else if (taxEarnings > taxEarningsMinusSpendings) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + taxEarningsMinusSpendings + " рублей");
                        System.out.println("Налог на другой системе: " + taxEarnings + " рублей");
                        System.out.println("Экономия: " + (taxEarnings - taxEarningsMinusSpendings) + " рублей");
                    } else {
                        System.out.println("Можете выбрать любую систему налогообложения");
                        System.out.println("Налог на обеих системах составит: " + taxEarnings + " рублей");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }

    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
}
