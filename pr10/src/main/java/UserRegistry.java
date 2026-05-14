import java.time.LocalDateTime;
import java.util.HashSet;

public class UserRegistry {
    private HashSet<User> users;
    private int nextId;

    public UserRegistry() {
        this.users = new HashSet<>();
        this.nextId = 1;
    }

    public void registerUser(String login, String password) {
        User newUser = new User(nextId, login, password);
        if (users.add(newUser)) {
            System.out.println("Користувача [" + login + "] успішно зареєстровано з ID: " + nextId);
            nextId++;
        } else {
            System.out.println("Користувач [" + login + "] вже є у списку");
        }
    }

    public void loginUser(String login, String password) {
        for (User user : users) {
            if (user.getName().equals(login) && user.getPassword().equals(password)) {
                user.setLoggedIn(true);
                user.setLastLoginDate(LocalDateTime.now());
                System.out.println("Аутентифікація успішна. Вітаємо, " + login + "!");
                return;
            }
        }
        System.out.println("Неможливо ідентифікувати або аутентифікувати користувача");
    }

    public void logoutUser(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                user.setLoggedIn(false);
                System.out.println("Користувач з ID " + userId + " вийшов із системи.");
                return;
            }
        }
        System.out.println("Користувача з таким ID не знайдено.");
    }

    public boolean isUserRegistered(String login) {
        for (User user : users) {
            if (user.getName().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public void removeUser(int id) {
        User target = null;
        for (User user : users) {
            if (user.getId() == id) {
                target = user;
                break;
            }
        }
        if (target != null) {
            users.remove(target);
            System.out.println("Користувача з ID " + id + " видалено з множини.");
        } else {
            System.out.println("Користувача з таким ID не знайдено.");
        }
    }

    public void printTotalUniqueUsers() {
        System.out.println("Кількість унікальних користувачів: " + users.size());
    }

    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("Список користувачів порожній.");
            return;
        }
        System.out.println("Всі логіни (зверніть увагу, що HashSet не гарантує порядок):");
        for (User user : users) {
            System.out.println("- " + user.getName());
        }
    }
}