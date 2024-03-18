package com.mycompany.practicaltask1_8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Passport {
    private int number;
    private String fullName;
    private String position;
    private boolean access;

    public Passport(int number, String fullName, String position, boolean access) {
        this.number = number;
        this.fullName = fullName;
        this.position = position;
        this.access = access;
    }

    public int getNumber() {
        return number;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public boolean hasAccess() {
        return access;
    }

    @Override
    public String toString() {
        return fullName + ", " + number + ", " + position + ", " + access;
    }
}

class PassportManagement {
    public static void printPassports(ArrayList<Passport> passports) {
        System.out.println("СОРТИРОВКА ПО ФИО:");
        passports.sort(Comparator.comparing(Passport::getFullName));
        for (Passport passport : passports) {
            System.out.println(passport);
        }
        System.out.println("\nСОРТИРОВКА ПО НОМЕРУ ПРОПУСКА:");
        passports.sort(Comparator.comparingInt(Passport::getNumber));
        for (Passport passport : passports) {
            System.out.println(passport);
        }
    }

    public static void addPassport(ArrayList<Passport> passports) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        String fullName = scanner.nextLine();
        System.out.print("Введите номер пропуска: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите должность: ");
        String position = scanner.nextLine();
        System.out.print("Прошел ли допуск на закрытую территорию (true/false): ");
        boolean access = scanner.nextBoolean();

        Passport existingPassport = null;
        for (Passport passport : passports) {
            if (passport.getNumber() == number && !passport.getFullName().equals(fullName)) {
                existingPassport = passport;
                break;
            }
        }

        if (existingPassport != null) {
            System.out.println("Такой номер уже существует. Замена.");
            passports.remove(existingPassport);
        }
        passports.add(new Passport(number, fullName, position, access));

        System.out.println("\nТекущее содержимое списка пропусков:");
        printPassports(passports);
    }
}

