package Homework6;

public abstract class Animal {

    private static int count;

    public static int getCount(){
        return count;
    }

    protected int maxRunDistance;
    protected int maxJumpHeigth;
    protected int maxSwimDistance;

    public Animal(int maxRunDistance,int maxJumpHeigth,int maxSwimDistance){
        this.maxRunDistance=maxRunDistance;
        this.maxJumpHeigth=maxJumpHeigth;
        this.maxSwimDistance=maxSwimDistance;
        count++;
    }
    public abstract boolean run(int distance);
    public abstract boolean swim(int distance);
    public abstract boolean jump(int heigth);

    public void printInfo (){
        System.out.println(this);
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName()  + "{" +
        "maxRunDistance =" + maxRunDistance+
        ", maxJumpHeigth=" + maxJumpHeigth +
        ", maxSwimDistance=" + maxSwimDistance +
        '}';
  }

}
