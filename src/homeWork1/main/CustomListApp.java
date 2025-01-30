package homeWork1;

import homeWork1.list.CustomArrayList;
import homeWork1.list.CustomLinkedList;
import homeWork1.list.CustomList;

import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class CustomListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomArrayList<Integer> arrayList = new CustomArrayList<>();
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();

        System.out.println("Выберите тип списка: 1 - ArrayList, 2 - LinkedList");
        int listType = scanner.nextInt();

        boolean running = true;
        while (running) {
            System.out.println("Выберите операцию: \n" +
                    "1 - Добавить элемент \n" +
                    "2 - Добавить элемент по индексу \n" +
                    "3 - Получить элемент \n" +
                    "4 - Удалить элемент \n" +
                    "5 - Очистить коллекцию \n" +
                    "6 - Отсортировать коллекцию \n" +
                    "7 - Рандомное заполнение числами \n" +
                    "8 - Печать списка \n" +
                    "0 - Выйти");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.println("Введите элемент для добавления:");
                        int element = getValidIntInput(scanner);
                        long startTime = System.nanoTime();
                        getList(listType, arrayList, linkedList).add(element);
                        long endTime = System.nanoTime();
                        System.out.println("Время выполнения операции: " + (endTime - startTime) + " нс");
                    }
                    case 2 -> {
                        System.out.println("Введите индекс и элемент для добавления:");
                        int index = getValidIntInput(scanner);
                        int element = getValidIntInput(scanner);
                        long startTime = System.nanoTime();
                        getList(listType, arrayList, linkedList).add(index, element);
                        long endTime = System.nanoTime();
                        System.out.println("Время выполнения операции: " + (endTime - startTime) + " нс");
                    }
                    case 3 -> {
                        System.out.println("Введите индекс для получения элемента:");
                        int index = getValidIntInput(scanner);
                        long startTime = System.nanoTime();
                        System.out.println("Элемент: " + getList(listType, arrayList, linkedList).get(index));
                        long endTime = System.nanoTime();
                        System.out.println("Время выполнения операции: " + (endTime - startTime) + " нс");
                    }
                    case 4 -> {
                        System.out.println("Введите индекс для удаления элемента:");
                        int index = getValidIntInput(scanner);
                        long startTime = System.nanoTime();
                        getList(listType, arrayList, linkedList).remove(index);
                        long endTime = System.nanoTime();
                        System.out.println("Время выполнения операции: " + (endTime - startTime) + " нс");
                    }
                    case 5 -> {
                        long startTime = System.nanoTime();
                        getList(listType, arrayList, linkedList).clear();
                        long endTime = System.nanoTime();
                        System.out.println("Время выполнения операции: " + (endTime - startTime) + " нс");
                    }
                    case 6 -> {
                        long startTime = System.nanoTime();
                        getList(listType, arrayList, linkedList).sort(Comparator.naturalOrder());
                        long endTime = System.nanoTime();
                        System.out.println("Время выполнения операции: " + (endTime - startTime) + " нс");
                    }
                    case 7 -> {
                        System.out.println("Введите количество случайных элементов для добавления:");
                        int count = scanner.nextInt();
                        long startTime = System.nanoTime();
                        fillWithRandom(getList(listType, arrayList, linkedList), count);
                        long endTime = System.nanoTime();
                        System.out.println("Время выполнения операции: " + (endTime - startTime) + " нс");
                    }
                    case 8 -> {
                        System.out.println("Содержимое списка:");
                        long startTime = System.nanoTime();
                        printList(getList(listType, arrayList, linkedList));
                        long endTime = System.nanoTime();
                        System.out.println("Время выполнения операции: " + (endTime - startTime) + " нс");
                    }
                    case 0 -> running = false;
                    default -> System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static CustomList<Integer> getList(int type, CustomArrayList<Integer> arrayList, CustomLinkedList<Integer> linkedList) {
        return type == 1 ? arrayList : linkedList;
    }

    private static void fillWithRandom(CustomList<Integer> list, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(999) + 1);
        }
    }

    private static void printList(CustomList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
    private static int getValidIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите целое число!");
            scanner.next(); // Очистка некорректного ввода
        }
        return scanner.nextInt();
    }
}
