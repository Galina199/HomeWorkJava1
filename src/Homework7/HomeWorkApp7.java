package Homework7;

public class HomeWorkApp7 {
    private static int TIME = 0;

    public static void main(String[] args) {

        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Буся", 95, 2);
        cat[1] = new Cat("Рыжик", 120, 5);
        cat[2] = new Cat("Матроскин", 30, 1);
        Plate plate = new Plate(950);
        System.out.println("Привет! У Вас есть три кота: " + cat[0].getName() + ", " + cat[1].getName() +
                " и " + cat[2].getName() + ", которые хотят есть каждые " + cat[0].getSatietyTime() +
                ", " + cat[1].getSatietyTime() + " и " + cat[2].getSatietyTime() + " час(а) соответственно.");
        System.out.println("Кто-то из них более голоден, кто-то менее. Сейчас в миске " + plate.getFood() +
                " грамм  корма. Посмотрим насколько его хватит, " +
                "в данный момент коты очень голодны и направляются поесть.\n");

        do {
            for (Cat i : cat) {

                //если кот голоден
                if (i.getSatiety() == 0) {

                    //если в миске не хватает еды, чтобы накормить кота, она будет добавлена
                    if (!plate.checkFood(i.getAppetite())) {
                        plate.increaseFood();
                    }

                    //кот ест
                    i.eat(plate);
                    System.out.println("Кот " + i.getName() + " съел " + i.getAppetite() +
                            " грамм корма и проголодается через " + (i.getSatiety()) + " часа(ов)");
                }

                //декрементация показателя сытости
                i.setSatiety(i.getSatiety() - 1);
            }
            System.out.println("\nС момента начала кормежки прошел(ло) " + TIME + " час(ов). В миске осталось " +
                    plate.getFood() + " грамм корма.\n");
            TIME++;

        } while (TIME <= 20);
    }
}
