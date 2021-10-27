package Homework6;

public class Dog extends Animal {
    public static final int DEFAULT_MAX_RUN_DISTANCE = 500;
    public static final int DEFAULT_MAX_SWIM_DISTANCE = 1;
    public static final  int DEFAULT_MAX_JUMP_HEIGTH = 10;

    private static int count;

    public static int getCount() {
        return count;
    }

    public Dog(int maxRunDistance, int maxJumpHeigth, int maxSwimDistance) {
        super(maxRunDistance, maxJumpHeigth, maxSwimDistance);
        count++;
    }

    public Dog() {
        this(DEFAULT_MAX_RUN_DISTANCE, DEFAULT_MAX_SWIM_DISTANCE, DEFAULT_MAX_JUMP_HEIGTH);
    }

    @Override
    public boolean run(int distance) {
        if (this.maxRunDistance >= distance){
            System.out.printf("Собака пробежала дистанцию %d. Max = %d%n", distance, maxRunDistance);
        return true;
    }
     System.out.printf("Собака не  смогла пробежать дистанцию %d. Max = %d%n",distance,maxRunDistance);
    return false;
}

    @Override
    public boolean swim(int distance) {
        if (this.maxSwimDistance >= distance){
            System.out.printf("Собака проплыла дистанцию %d. Max = %d%n", distance, maxSwimDistance);
        return true;
    }
     System.out.printf("Собака не смогла проплыть дистанцию %d. Max = %d%n",distance,maxSwimDistance);
        return false;
    }

    @Override
    public boolean jump(int heigth) {
        if (this.maxJumpHeigth >= heigth){
            System.out.printf("Собака перепрыгнула репятствие %d. Max = %d%n", heigth, maxJumpHeigth);
            return true;
        }
        System.out.printf("Собака не смогла перепрыгнуть препятствие %d. Max = %d%n",heigth, maxJumpHeigth);
        return false;
    }

}
