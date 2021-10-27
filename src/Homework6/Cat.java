package Homework6;

public class Cat extends Animal {
    public static final int DEFAULT_MAX_RUN_DISTANCE = 200;
    public static final int DEFAULT_MAX_SWIM_DISTANCE = 2;
    public static final int DEFAULT_MAX_JUMP_HEIGTH = 0;

    private static int count;

    public static int getCount() {
        return count;
    }

    public Cat(int maxRunDistance, int maxJumpHeigth) {
        super(maxRunDistance, DEFAULT_MAX_SWIM_DISTANCE,maxJumpHeigth);
        count++;
    }

    public Cat (){
        this(DEFAULT_MAX_RUN_DISTANCE,DEFAULT_MAX_JUMP_HEIGTH);
    }
    @Override
    public boolean run(int distance) {
        if (this.maxRunDistance >= distance){
            System.out.printf("Кошка пробежала дистанцию %d. Max = %d%n", distance, maxRunDistance);
            return true;
        }
        System.out.printf("Кошка не  смогла пробежать дистанцию %d. Max = %d%n",distance,maxRunDistance);
        return false;
    }

    @Override
    public boolean swim(int distance) {
            System.out.print("Коты не умеют плавать!");
        return false;
    }

    @Override
    public boolean jump(int heigth) {
        if (this.maxJumpHeigth >= heigth){
            System.out.printf("Кошка перепрыгнула репятствие %d. Max = %d%n", heigth, maxJumpHeigth);
            return true;
        }
        System.out.printf("Кошка не смогла перепрыгнуть препятствие %d. Max = %d%n",heigth, maxJumpHeigth);
        return false;
    }
}
