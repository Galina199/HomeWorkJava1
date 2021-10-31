package Homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterExample {
    private static int counter = 0;
    private static JLabel counterValueView;

    public static void main(String[] args) {
        JFrame mainFrame = initFrame();

        Font font = new Font("Arial", Font.BOLD, 32);
        creatCounterView(mainFrame, font);
        createButtos(mainFrame, font);
        mainFrame.setVisible(true);

    }

    private static void createButtos(JFrame mainFrame, Font font) {
        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        mainFrame.add(decrementButton, BorderLayout.LINE_START);

        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        mainFrame.add(incrementButton, BorderLayout.LINE_END);


        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterValueView.setText(String.valueOf(--counter));
            }
        });
        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterValueView.setText(String.valueOf(++counter));
            }
        });
    }

    private static JFrame initFrame() {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Counter");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setBounds(300, 300, 400, 200);
        return mainFrame;
    }

    private static void creatCounterView(JFrame mainFrame, Font font) {
        counterValueView = new JLabel(getCounterValueAsText());
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        counterValueView.setFont(font);
        mainFrame.add(counterValueView, BorderLayout.CENTER);
    }


    private static String getCounterValueAsText() {
        return String.valueOf(counter);
    }
}