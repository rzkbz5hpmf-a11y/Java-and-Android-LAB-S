public class Main {
    public static void main(String[] args) {
        // 1. Создание и заполнение массива из 15 дробных чисел
        double[] numbers = {8.0, -2.5, 4.3, -7.1, 2.0, 3.5, 6.2, -1.8, 5.0, 1.1, -3.4, 8.2, -9.0, 4.4, 0.5};

        // Переменные для вычисления среднего арифметического
        double sum = 0;
        int count = 0;
        boolean foundFirstNegative = false;

        // Цикл for-each для нахождения положительных чисел после первого отрицательного
        for (double number : numbers) {
            if (!foundFirstNegative) {
                if (number < 0) {
                    foundFirstNegative = true;
                }
            } else {
                if (number > 0) {
                    sum += number;
                    count++;
                }
            }
        }

        // Вывод результатов первой части
        if (count > 0) {
            System.out.println("Среднее арифметическое положительных чисел после первого отрицательного: " + (sum / count));
        } else {
            System.out.println("Положительные числа после первого отрицательного не найдены.");
        }

        System.out.println("\n--- СРС: Сортировка выбором (Selection Sort) ---");

        // Массив для сортировки
        double[] arrayToSort = {-4.0, 8.0, -2.5, 3.5, 2.0, 6.2};

        // Вывод начального состояния массива
        System.out.print("Начальный массив: ");
        printArray(arrayToSort);

        // Алгоритм сортировки по возрастанию (Selection Sort)
        for (int i = 0; i < arrayToSort.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrayToSort.length; j++) {
                if (arrayToSort[j] < arrayToSort[minIndex]) {
                    minIndex = j;
                }
            }

            // Перестановка элементов
            double temp = arrayToSort[minIndex];
            arrayToSort[minIndex] = arrayToSort[i];
            arrayToSort[i] = temp;

            // Вывод текущего состояния массива после каждой итерации
            System.out.print("Итерация " + (i + 1) + ": ");
            printArray(arrayToSort);
        }
    }

    // Вспомогательный метод для печати массива
    public static void printArray(double[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
