package HW;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersonalData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите данные в формате: Фамилия Имя Отчество Дата_рождения Номер_телефона Пол");
            String input = scanner.nextLine();
            String[] data = input.split(" ");

            if (data.length != 6) {
                throw new IllegalArgumentException("Недостаточное количество данных. Введите Фамилию, Имя, Отчество, Дата_рождения, Номер_телефона и Пол, разделенные пробелом.");
            }

            String surname = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                throw new IllegalArgumentException("Неверный формат даты. Используйте формат dd.mm.yyyy.");
            }

            if (gender != 'f' && gender != 'm') {
                throw new IllegalArgumentException("Неверное значение пола. Укажите 'f' или 'm'.");
            }

            String filename = surname + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write("ФИО:" + " " + surname + " " + firstName + " " + middleName + "\n" + "Дата рождения:" + " " + birthDate + "\n" + "Номер телефона:" + " " + phoneNumber + "\n" + "Пол:" + " " + gender);
            writer.newLine();
            writer.close();
            System.out.println("Данные успешно записаны в файл " + filename);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Номер телефона должен быть числом.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл:");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}