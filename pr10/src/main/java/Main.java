import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserRegistry registry = new UserRegistry();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Система Логування Подій ---");
            System.out.println("1. Зареєструвати користувача");
            System.out.println("2. Увійти (login)");
            System.out.println("3. Вийти (logout)");
            System.out.println("4. Перевірити реєстрацію");
            System.out.println("5. Видалити користувача");
            System.out.println("6. Показати кількість унікальних користувачів");
            System.out.println("7. Вивести всі логіни");
            System.out.println("0. Вихід");
            System.out.print("Оберіть дію: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введіть логін: ");
                    String regLogin = scanner.nextLine();
                    System.out.print("Введіть пароль: ");
                    String regPassword = scanner.nextLine();
                    registry.registerUser(regLogin, regPassword);
                    break;
                case 2:
                    System.out.print("Введіть логін: ");
                    String login = scanner.nextLine();
                    System.out.print("Введіть пароль: ");
                    String password = scanner.nextLine();
                    registry.loginUser(login, password);
                    break;
                case 3:
                    System.out.print("Введіть ID користувача: ");
                    int logoutId = scanner.nextInt();
                    registry.logoutUser(logoutId);
                    break;
                case 4:
                    System.out.print("Введіть логін для перевірки: ");
                    String checkLogin = scanner.nextLine();
                    boolean isReg = registry.isUserRegistered(checkLogin);
                    System.out.println(isReg ? "Користувач знайдений." : "Користувача немає в системі.");
                    break;
                case 5:
                    System.out.print("Введіть ID для видалення: ");
                    int removeId = scanner.nextInt();
                    registry.removeUser(removeId);
                    break;
                case 6:
                    registry.printTotalUniqueUsers();
                    break;
                case 7:
                    registry.displayAllUsers();
                    break;
                case 0:
                    System.out.println("Завершення роботи.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Невірний вибір.");
            }
        }
    }
}