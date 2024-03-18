package com.mycompany.practicaltask1_8;

import static com.mycompany.practicaltask1_8.PassportManagement.addPassport;
import static com.mycompany.practicaltask1_8.PassportManagement.printPassports;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Passport> initialPassports = new ArrayList<>();
        initialPassports.add(new Passport(445566, "Антонов Андрей Антонович", "сантехник", false));
        initialPassports.add(new Passport(112134, "Иванов Иван Иванович", "директор", true));
        initialPassports.add(new Passport(306306, "Яковлева Юлия Аристарховна", "секретарь", false));
        initialPassports.add(new Passport(123456, "Абобов Виктор Олегович", "фрезеровщик", true));
        initialPassports.add(new Passport(977073, "Атаманов Алексей Макронович", "водитель", false));

        System.out.println("Начальные пропуски:");
        printPassports(initialPassports);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить пропуск");
            System.out.println("2. Выйти");
            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPassport(initialPassports);
                    break;
                case 2:
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}
