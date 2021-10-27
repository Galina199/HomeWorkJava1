package Homework6;

 import java.util.Random;

 public class HomeWorkApp6 {

 public static void main (String[] args){
    Animal[]participants = preparetParticipants();
    playGame(participants);
 }

    private static Animal[] preparetParticipants(){
       return new Animal[]{
        new Cat(),
        new Dog(),
        new Cat(300,3),
        new Cat(400,3),
        new Dog(1000,2,100),
        };
    }
    private static void playGame(Animal[] participants) {
        Random random = new Random();
        for (Animal participant : participants) {
            participant.printInfo();
            System.out.println(participant.run(random.nextInt(500)));
            System.out.println(participant.jump(random.nextInt(5)));
            System.out.println(participant.swim(random.nextInt(100)));
            System.out.println();
        }
        System.out.println(Animal.getCount());
        System.out.println(Cat.getCount());
        System.out.println(Dog.getCount());
    }
}
