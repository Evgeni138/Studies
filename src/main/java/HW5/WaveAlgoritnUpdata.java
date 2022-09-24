package HW5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WaveAlgoritnUpdata {
    static int[] inputPoint() { // Задаем координаты точек
        int[] point = new int[2];
        for (int i = 0; i < 2; i++) {
            Scanner iScanner = new Scanner(System.in);
            point[i] = iScanner.nextInt();
        }
        return point;
    }

    static int[][] createPole() { // Создаем поле с заданными размерами
        int m = 10;
        int n = 10;
        int[][] pole = new int[m][n];
        return pole;
    }

    static int[][] labirint() {
        int m = 10;
        int n = 10;
        int[][] pole = new int[m][n];
        pole[0][0] = 1;
        pole[0][1] = 1;
        pole[0][2] = 1;
        pole[0][3] = 1;
        pole[0][4] = 1;
        pole[0][5] = 1;
        pole[0][6] = 1;
        pole[0][7] = 1;
        pole[0][8] = 1;
        pole[0][9] = 1;
        pole[1][0] = 1;
        pole[1][1] = 0;
        pole[1][2] = 1;
        pole[1][3] = 0;
        pole[1][4] = 1;
        pole[1][5] = 0;
        pole[1][6] = 0;
        pole[1][7] = 0;
        pole[1][8] = 0;
        pole[1][9] = 1;
        pole[2][0] = 1;
        pole[2][1] = 0;
        pole[2][2] = 1;
        pole[2][3] = 0;
        pole[2][4] = 1;
        pole[2][5] = 0;
        pole[2][6] = 0;
        pole[2][7] = 0;
        pole[2][8] = 0;
        pole[2][9] = 1;
        pole[3][0] = 1;
        pole[3][1] = 0;
        pole[3][2] = 1;
        pole[3][3] = 0;
        pole[3][4] = 1;
        pole[3][5] = 1;
        pole[3][6] = 1;
        pole[3][7] = 1;
        pole[3][8] = 0;
        pole[3][9] = 1;
        pole[4][0] = 1;
        pole[4][1] = 0;
        pole[4][2] = 1;
        pole[4][3] = 0;
        pole[4][4] = 0;
        pole[4][5] = 0;
        pole[4][6] = 0;
        pole[4][7] = 1;
        pole[4][8] = 0;
        pole[4][9] = 1;
        pole[5][0] = 1;
        pole[5][1] = 0;
        pole[5][2] = 1;
        pole[5][3] = 0;
        pole[5][4] = 0;
        pole[5][5] = 0;
        pole[5][6] = 0;
        pole[5][7] = 1;
        pole[5][8] = 0;
        pole[5][9] = 1;
        pole[6][0] = 1;
        pole[6][1] = 0;
        pole[6][2] = 0;
        pole[6][3] = 0;
        pole[6][4] = 0;
        pole[6][5] = 0;
        pole[6][6] = 0;
        pole[6][7] = 1;
        pole[6][8] = 0;
        pole[6][9] = 1;
        pole[7][0] = 1;
        pole[7][1] = 0;
        pole[7][2] = 1;
        pole[7][3] = 0;
        pole[7][4] = 0;
        pole[7][5] = 0;
        pole[7][6] = 0;
        pole[7][7] = 0;
        pole[7][8] = 0;
        pole[7][9] = 1;
        pole[8][0] = 1;
        pole[8][1] = 0;
        pole[8][2] = 1;
        pole[8][3] = 0;
        pole[8][4] = 0;
        pole[8][5] = 0;
        pole[8][6] = 0;
        pole[8][7] = 0;
        pole[8][8] = 0;
        pole[8][9] = 1;
        pole[9][0] = 1;
        pole[9][1] = 1;
        pole[9][2] = 1;
        pole[9][3] = 1;
        pole[9][4] = 1;
        pole[9][5] = 1;
        pole[9][6] = 1;
        pole[9][7] = 1;
        pole[9][8] = 1;
        pole[9][9] = 1;
        return pole;
    }

    static void step(int[][] pole, int[][] labirint, int[] pointA, int k) { // Метод делает один шаг из точки А в точку Б
        for (int i = pointA[0]; i < pole.length; i++) {
            for (int j = pointA[1]; j < pole[i].length; j++) {
                if (pole[i][j] == k) {
                    if (i > 0 && pole[i - 1][j] == 0 && labirint[i -1][j] == 0) {
                        pole[i - 1][j] = k + 1;
                    }
                    if (j > 0 && pole[i][j - 1] == 0 && labirint[i][j - 1] == 0) {
                        pole[i][j - 1] = k + 1;
                    }
                    if (i < pole.length - 1 && pole[i + 1][j] == 0 && labirint[i + 1][j] == 0) {
                        pole[i + 1][j] = k + 1;
                    }
                    if (j < pole[i].length - 1 && pole[i][j + 1] == 0 && labirint[i][j + 1] == 0) {
                        pole[i][j + 1] = k + 1;
                    }
                }
            }
        }

    }

    static void printPole(int[][] pole) { // Метод выводит в консоль поле
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[i].length; j++) {
                System.out.printf("%3d", pole[i][j]);
            }
            System.out.println();
        }
    }
    static Map<Integer, int[]> resultPath(int pole[][], int pointA[], int pointB[], int k) {
        // Формируем и выводим путь, где собран пошагово путь из точки А в точку Б
        Map<Integer, int[]> path = new HashMap<>();
        path.put(k, new int[]{pointB[0], pointB[1]});
        int i = pointB[0];
        int j = pointB[1];
        while (k > 1) {
            if (i > 0 && pole[i - 1][j] == k - 1) {
                i = i - 1;
                j = j;
                path.put(--k, new int[]{i, j});
            } else if (j > 0 && pole[i][j - 1] == k - 1) {
                i = i;
                j = j - 1;
                path.putIfAbsent(--k, new int[]{i, j});
            } else if (i < pole.length - 1 && pole[i + 1][j] == k - 1) {
                i = i + 1;
                j = j;
                path.putIfAbsent(--k, new int[]{i, j});
            } else if (j < pole[i].length - 1 && pole[i][j + 1] == k - 1) {
                i = i;
                j = j + 1;
                path.putIfAbsent(--k, new int[]{i, j});
            }
        }
        for (Integer key : path.keySet()) {
            System.out.println(key + " " + Arrays.toString(path.get(key)));
        }
        return path;
    }
    static void resultPole(int pole[][], Map<Integer, int[]> path) {
        // Метод, который формируем и выводим поле, где показан пошагово путь из точки А в точку Б
        int m = pole.length;
        int n = pole[0].length;
        int[][] result = new int[m][n];

        int[] coordinates;

        for (Integer key : path.keySet()) {
            coordinates = path.get(key);
            result[coordinates[0]][coordinates[1]] = key;
        }
        printPole(result);
    }

    public static void main(String[] args) {
        // Вводи координаты точек А и Б
        int[] pointA = {1, 1};

        int[] pointB = {2, 5};

        int[][] pole = createPole(); // Создаем поле
        pole[pointA[0]][pointA[1]] = 1; // Присваиваем точке А 1, первый шаг
        System.out.println();

        int[][] poleLabirint = labirint();
        printPole(poleLabirint);
        System.out.println();

        // Заполняем поле от точки А до точки Б волновым алгоритмом
        int k = pole[pointA[0]][pointA[1]];
        while (pole[pointB[0]][pointB[1]] == 0) {
            step(pole, poleLabirint, pointA, k);
            k++;
        }

        printPole(pole);
        System.out.println();

        System.out.println(pole[pointB[0]][pointB[1]]);
        System.out.println();

        // Формируем и выводим путь, где собран пошагово путь из точки А в точку Б
        Map<Integer, int[]> path = new HashMap<>();
        path = resultPath(pole, pointA, pointB, k);

        System.out.println();
        // Формируем и выводим поле, где показан пошагово путь из точки А в точку Б
        resultPole(pole, path);

    }
}



