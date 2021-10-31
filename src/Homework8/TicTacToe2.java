package Homework8;

import javax.swing.*;
import java.awt.*;

public class TicTacToe2 {
    public static void main(String[]args) {
   System.out.println("Запускаем игру!");
        JFrame window = new JFrame("TicTacToe2"); //главное окно
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // кнопка закрывающая окно
        window.setSize(600,600); // размер окна
        window.setLayout(new BorderLayout()); // менеджер компановки
        window.setLocationRelativeTo(null);// центрирование окна относительно экрана
        window.setVisible(true);//видимость окна
        TTT game = new TTT();//создаем объект нашего класса
        window.add(game);//добавляем объект в окно
        System.out.println("конец игры.");

    }
}
