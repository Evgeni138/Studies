//+На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть две команды
//        - команда 1 (к1): увеличить в с раза, а умножается на c
//        - команда 2 (к2): увеличить на d, к a прибавляется d
//        написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b или сообщить, что это невозможно
//        Пример 1: а = 1, b = 7, c = 2, d = 1
//        ответ: к2, к2, к2, к2, к2, к2, k2 или к1, к1, к2, к2, к2
//        Можно начать с более простого – просто подсчёта общего количесвтва вариантов
//        Пример 2: а = 11, b = 7, c = 2, d = 1
//        ответ: нет решения.
//        *Подумать над тем, как сделать минимальное количество команд
package Lesson1;

public class Seminar1 {
    static int solve(int start, int end, int com1, int com2) {
        int[] ways = new int[end + 1];
        ways[start] = 1;

        for (int index = start + com1; index <= end; index++) {
// При делении без остатка элемента последовательности на множетель, колличество решений будет равно
// количеству решений для предыдущего элемента плюс количество решений элемента под номером
// текущего деленного на множетель.
            if (index % com2 == 0) {
                ways[index] = ways[index - com1] + ways[index / com2];
            } else {
                ways[index] = ways[index - com1];
            }
        }
// Иначе колличество решений будет равно количеству решений для предыдущего элемента.
        System.out.println(print(ways)); // Выводится в консоль количество решений для каждого эллемента последовательности.
        return ways[end]; // Метод solve вычисляет колличество решений.
    }

    static String print(int[] items) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
// Этот метод собирает строку из элементов массива в скобках и их значений.
            sb.append(String.format("(%d)%d ", i, items[i]));
        }
        return sb.toString();
    }

    static StringBuilder st = new StringBuilder(); // Вводим переменную, чтобы собрать строку с решением.

    public static void main(String[] args) {
        System.out.println(solve(1, 7, 1, 2)); // Выводим строку с элементами и количеством решений для этого элемента.
        System.out.println();

        if (waysGetEndValue(1, 7, 1, 2)) {
            System.out.print("Answer: ");
            System.out.println(st); // Выводим решение
        } else {
            System.out.println("False");
        }
    }
// Метод вычисляет единственное оптимальное решение с помощью рекурсии.
    static boolean waysGetEndValue(int a, int b, int d, int c) {
        boolean result = false; // Объявляем булевскую переменную.
        if (a == b) { // Если условие выполняется. выходим из метода.
//            System.out.println("a = b");
            result = true;
        } else { // Иначе запускаем рекурсию в зависимости от подходящего условия.
            if (a <= b / c && b % c == 0 && (!result)) { // Пока не найден результат.
                result = waysGetEndValue(a, b / c, d, c);
                if (result) {
//                    System.out.println("k2 ");
                    st.append("k2 "); // Собираем строку с ответом.
                }
            }
            if (a < b && (!result)) {
                result = waysGetEndValue(a, b - d, d, c);
                if (result) {
//                    System.out.println("k1 ");
                    st.append("k1 ");}
            }
        }

        return result;
    }

}
