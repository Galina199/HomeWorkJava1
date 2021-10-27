package Homework7;

public class Plate {
    public void decreaseFood() {
    }
    private int food;

    int getFood() {
        return food;
    }

    Plate(int food) {
        this.food = food;
    }

    void increaseFood() {
        this.food += 300;
        System.out.println("В миску добавили 300 грамм корма");
    }

    boolean checkFood(int n) {
        return (food - n) >= 0;
    }
}


