package Homework4;


import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    public static final String DOT_X = "X";
    public static final String DOT_0 = "O";
    public static final String DOT_Y = "Y";
    public static final String DOT_EMPLY = "*";
    public static int aiLevel = 0;
    public static final int SIZE = 4;
    public static String[][] field = new String[SIZE][SIZE];

    public static void main(String[] args) {
        mainMenu();
    }


    public static void modeTwoPlayers() {
        int count = 0;
        initField();
        while (true) {
            printField();
            userShot(DOT_X, 1);
            count++;
            if (checkWin(DOT_X)) {
                System.out.println("USER 1 WIN!!!");
                printField();
                break;
            }
            userShot(DOT_Y, 2);
            count++;
            if (checkWin(DOT_Y)) {
                System.out.println("USER 2 WIN!!!");
                printField();
                break;
            }
            if (count == Math.pow(SIZE, 2)) {
                printField();
                break;
            }
        }
    }
    public static void modeAgainstAI() {
        int count = 0;
        initField();
        while (true) {
            printField();
            userShot(DOT_X, 0);
            count++;
            if (checkWin(DOT_X)) {
                System.out.println("Player's Victory!!!");
                printField();
                break;
            }
            aiShot();
            count++;
            if (checkWin(DOT_0)) {
                System.out.println("AI Victory!!!");
                printField();
                break;
            }
            if (count == Math.pow(SIZE, 2)) {
                printField();
                break;
            }
        }
    }
    public static void mainMenu() {
        System.out.println("Выберите режим игры: ");
        System.out.println("1. Игра против компьютера.");
        System.out.println("2. 2 игрока.");
        System.out.println("3. Выход.");
        int i;
        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        if (i == 1) {
            aiLevel();
        } else if (i == 2) {
            modeTwoPlayers();
        } else if (i == 3) {
            System.exit(0);
        } else {
            System.out.println("Было введено неверное значение!");
        }
    }
    public static void aiLevel() {
        System.out.println("Выберите сложность компьютера: ");
        System.out.println("1. Простой.");
        System.out.println("2. Продвинутый.");
        System.out.println("3. Сложный.");
        System.out.println("4. Вернуться в предыдущее меню.");
        System.out.println("5. Выход.");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 1 -> {
                aiLevel = 0;
                modeAgainstAI();
            }
            case 2 -> {
                aiLevel = 1;
                modeAgainstAI();
            }
            case 3 -> {
                aiLevel = 2;
                modeAgainstAI();
            }
            case 4 -> mainMenu();
            case 5 -> System.exit(0);
            default -> System.out.println("Было введено неверное значение!");
        }
    }

    public static void initField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = DOT_EMPLY;
            }
        }
    }

    public static void printField() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void userShot(String sign, int i) {
        int x;
        int y;
        do {
            if (i == 0) {
                System.out.println("Введите координаты x y (1 - " + SIZE + "): ");
            } else {
                System.out.println("Игрок " + i + ". Введите координаты x y (1 - " + SIZE + "): ");
            }
            Scanner sc = new Scanner(System.in);
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        }
        while (isCellBusy(x, y));
        field[x][y] = sign;
    }

    public static void aiShot() {
        int x = -1;
        int y = -1;
        boolean ai_win = false;
        boolean user_win = false;
// Поиск выигрышного хода
        if (aiLevel == 2) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (!isCellBusy(i, j)) {
                        field[i][j] = DOT_0;
                        if (checkWin(DOT_0)) {
                            x = i;
                            y = j;
                            ai_win = true;
                        }
                        field[i][j] = DOT_EMPLY;
                    }
                }
            }
        }
// Блокировка хода пользователя
        if (aiLevel > 0) {
            if (!ai_win) {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (!isCellBusy(i, j)) {
                            field[i][j] = DOT_X;
                            if (checkWin(DOT_X)) {
                                x = i;
                                y = j;
                                user_win = true;
                            }
                            field[i][j] = DOT_EMPLY;
                        }
                    }
                }
            }
        }
        if (!ai_win && !user_win) {
            do {
                Random rnd = new Random();
                x = rnd.nextInt(SIZE);
                y = rnd.nextInt(SIZE);
            }
            while (isCellBusy(x, y));
        }
        field[x][y] = DOT_0;
        System.out.println("x = " + x + "| y = " + y + "| ai_win = " + ai_win + "| user_win = " + user_win);
    }


    public static boolean isCellBusy(int x, int y) {
        if (x < 0 || y < 0 || x > SIZE - 1 || y > SIZE - 1) {
            return false;
        }
        return !Objects.equals(field[x][y], DOT_EMPLY);
    }

    public static boolean checkLine(int start_x, int start_y, int dx, int dy, String sign) {
        for (int i = 0; i < SIZE; i++) {
            if (!Objects.equals(field[start_x + i * dx][start_y + i * dy], sign))
                return false;
        }
        return true;
    }

    public static boolean checkWin(String sign) {
        for (int i = 0; i < SIZE; i++) {
// проверка строк
            if (checkLine(i, 0, 0, 1, sign)) return true;
// проверка столбцов
            if (checkLine(0, i, 1, 0, sign)) return true;
        }
// проверка диагоналей
        if (checkLine(0, 0, 1, 1, sign)) return true;
        return checkLine(0, SIZE - 1, 1, -1, sign);
    }
}
