public class Main {
    public static void main(String[] args) {
        // --- Лабораторная работа №4 ---
        System.out.println("=== Лабораторная работа №4 ===");
        
        // Создание и инициализация массива из 15 дробных чисел
        double[] numbers = {2.5, -4.5, 6.5, -1.5, 3.5, -7.5, 8.5, -2.0, 4.0, -9.1, 1.2, 5.5, -3.3, 0.8, -6.2};

        int positiveCount = 0;
        int negativeCount = 0;
        double positiveSum = 0;

        // Цикл for для подчета элементов и суммы
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                positiveCount++;
                positiveSum += numbers[i];
            } else if (numbers[i] < 0) {
                negativeCount++;
            }
        }

        // Вывод результатов Лабораторной работы №4
        System.out.println("Положительных: " + positiveCount);
        System.out.println("Отрицательных: " + negativeCount);
        System.out.println("Сумма положительных: " + positiveSum);

        System.out.println("
=== Задание 2 — СРС ===");

        // Создание массива из 10 целых чисел
        int[] array = {12, -5, 45, 0, 8, -18, 23, 99, -2, 34};

        // Вывод исходного массива
        System.out.print("Исходный массив: ");
        printIntArray(array);

        // Поиск индексов максимального и минимального элементов
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }

        // Перестановка минимального и максимального элементов местами
        int temp = array[minIndex];
        array[minIndex] = array[maxIndex];
        array[maxIndex] = temp;

        // Вывод изменённого массива
        System.out.print("Изменённый массив: ");
        printIntArray(array);
    }

    // Вспомогательный метод для печати массива целых чисел
    public static void printIntArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
