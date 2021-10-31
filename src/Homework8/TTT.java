package Homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class TTT extends JComponent {
    public static final int DOT_X = 10;// поле с крестиком
    public static final int DOT_0 =200;// поле с ноликом
    public static final int DOT_EMPLY = 0;//пустое поле
   int [][] field;// объявляем массив  игрового поля
   boolean isXturn;


    public TTT(){
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        field = new int[3][3]; // массив игрового поля
        initGame();
    }
    public void initGame(){
        for (int i=1;i<3;i++) {
            for (int j=1;j<3;j++){
                field[i][j]= DOT_EMPLY;// очищаем массив заполняя его 0
            }
        }
        isXturn=true;
    }

    @Override
    protected void processMouseEvent(MouseEvent mouseEvent){
        super.processMouseEvent(mouseEvent);
        if(mouseEvent.getButton() == MouseEvent.BUTTON1){
            int x =mouseEvent.getX();// координата х клика
            int y = mouseEvent.getY();// координата у клика
            //переводим координаты в индексы ячейки в массиве field
            int i = (int) ((float)x/getWidth()*3);
            int j = (int) ((float)y/getHeight()*3);
             // проверяем пуста ли выбранная ячейка,  и можно ли туда пойти
            if (field[i][j] == DOT_EMPLY){
             // проверка хода, если х то ставим крестик , если 0 то ставим нолик
                field [i][j]= isXturn?DOT_X:DOT_0;
                isXturn =!isXturn;// меняем ход
                repaint();// перерисовка компоненка, вызывается paintComponent
                int res = checState();
                if (res!=0){
                    //победили нолики
                    if (res == DOT_0*3){
                        JOptionPane.showMessageDialog(this,"выиграли нолики", "победа", JOptionPane.INFORMATION_MESSAGE);
                    // победили крестики
                    }else if (res == DOT_X*3){
                        JOptionPane.showMessageDialog(this,"выиграли крестики", "победа", JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(this,"ничья","ничья", JOptionPane.INFORMATION_MESSAGE);
                    }
                    // перезапускаем игру
                    initGame();
                    //перезапускаем поле
                    repaint();


                }
            }
        }
    }
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        //очищаем холст
        graphics.drawRect(0, 0, getWidth(),getHeight());
        // рисуем сетку из линий
       drawGrid(graphics);
       //рисуем крестики и нолики
       drawX0(graphics);
    }



    void drawGrid(Graphics graphics){
        int w = getWidth();// ширина игрового поля
        int h = getHeight();// высота игрового поля
        int dw = w/3; // делим ширину поля на 3, получаем ширину 1й ячейки
        int dh = h / 3;//делим высоту поля на 3, получаем высоту 1й ячейки
        graphics.setColor(Color.BLACK); // цвет линий
        for (int i=1;i<3;i++){// i пробегает значение от 1 до 2 включительно, при i=3 выход из цикла
            graphics.drawLine(0,dh*i,w,dh*i);//горизонтальная линия
            graphics.drawLine(dw*i,0,dw*i, h);// вертикальная линия
        }



    }
    void drawX(int i, int j, Graphics graphics){
        graphics.setColor(Color.BLACK);
        int dw = getWidth()/3;
        int dh = getHeight()/ 3;
        var y = j * dh;
        var x = i * dw;
        graphics.drawLine(x,y,x+dw, y+dh);//линия от верхнего левого угла в правый нижний
        graphics.drawLine(x, y+dh, x+dw,y);// линия от нижнего левого угла в правый верхний

    }


    void draw0(int i, int j, Graphics graphics) {
         graphics.setColor(Color.BLACK);
        int dw = getWidth()/ 3;
        int dh = getHeight()/ 3;
        var x = i * dw;
        var y = j * dh;
        graphics.drawOval(x * 5 * dw / 100, y, dw * 9 / 10, dh); // данное умножение необходимо для того, чтобы стенки
        //нолика не касались стенок ячейки
    }


    void drawX0(Graphics graphics) {
        //исуем крестик или нолик
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (field[i][j] == DOT_X) {
                    drawX(i, j, graphics);
                } else if (field[i][j] == DOT_0) {
                    draw0(i, j, graphics);
                }
            }
        }
    }
     int checState() {
        //проверка диагоналей
        int diag = 0;
        int diag2 = 0;
        for (int i = 0; i < 3; ++i) {
            diag += field[i][i];
            diag2 += field[i][2 - i];
        }
        if (!(diag != DOT_0 * 3 && diag != DOT_X * 3)) {
            return diag;
        }
        if (!(diag2 != DOT_0 * 3 && diag != DOT_X * 3)) {
            return diag2;
        }
        int check_i, check_j;
        boolean hasEmpty = false;
        for (int i = 0; i < 3; ++i) {
            check_i = 0;
            check_j = 0;
            int j;
            for (j = 0; j < 3; ++j) {
                if (field[i][j] == 0) {
                    hasEmpty = true;
                }
                check_i += field[i][j];
                check_j += field[j][i];
            }
            if (!(check_i != DOT_0 * 3 && diag != DOT_X * 3)){
                return check_i;
            }
            if (!(check_j != DOT_0 * 3 && diag != DOT_X * 3)){
                return check_j;
            }
        }
        if(hasEmpty) return 0;else return -1;

    }
}
