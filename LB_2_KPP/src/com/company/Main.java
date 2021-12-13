package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void hit_or_heall(Player Hero, Enemy_Characters Creep){
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n--------------Выберите действие--------------\n\n");
        System.out.println("Нажмите 7, чтобы ударить противника.");
        System.out.println("Нажмите 8, чтобы пополнить здоровье героя.(колличество эликсиров - " +
                Hero.heal_potion + ")\n\n");
        int button = input.nextInt();

        switch (button){
            case 7:
                Hero.attack(Creep);
                break;
            case 8:
                if (Hero.heal_potion > 0) {
                    Hero.heal();
                    break;
                }
                else{
                    break;
                }
        }
    }

    public static void run(){
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        Player Hero = new Player();
        Enemy_Characters Creep1 = new Enemy_Characters(120, 20);
        Enemy_Characters Creep2 = new Enemy_Characters(150, 30);
        Enemy_Characters Creep_mini = new Enemy_Characters();
        Enemy_Characters Creep_average = new Enemy_Characters(15, 18);
        Enemy_Boss Boss = new Enemy_Boss();
        Enemy_Boss Boss1 = new Enemy_Boss(3400, 216, 32);
        Enemy_Boss Boss2 = new Enemy_Boss(2743, 234, 26);
        System.out.println("\n------------------------" + Hero.toString() + "\n" + Creep_mini.toString() + "\n------------------------");

        Enemy_Boss []arr_boss = new Enemy_Boss[3];
        arr_boss[0] = Boss;
        arr_boss[2] = Boss2;
        arr_boss[1] = Boss1;
        Enemy_Characters []arr_enemy = new Enemy_Characters[3];
        arr_enemy[0] = Creep1;
        arr_enemy[2] = Creep2;
        arr_enemy[1] = Creep_mini;
        System.out.println("\n_____________________________________________________________\n");
        System.out.println(Arrays.toString(arr_enemy));
        Arrays.sort(arr_enemy);
        System.out.println("\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
        System.out.println(Arrays.toString(arr_enemy));
        System.out.println("\n_____________________________________________________________\n");

        // сортируем массив с помощью интерфейса Comparator по зарплате
        System.out.println(Arrays.toString(arr_boss));
        Arrays.sort(arr_boss, Enemy_Boss.Max_HPComparator);
        System.out.println("Comparator по HP:\n"+Arrays.toString(arr_boss));

        System.out.println(Creep_mini.compareTo(Creep_average));

        while(Hero.HP > 0) {
            int who_was_first = (int) (Math.random() * ((2 - 1) + 1));
            int choose;
            while (flag) {
                System.out.println("\n\n--------------Выберите действие--------------\n\n");
                System.out.println("Нажмите 1, чтобы начать поединок с легким крипом.");
                System.out.println("Нажмите 2, чтобы начать поединок с средним крипом.");
                System.out.println("Нажмите 3, чтобы начать поединок с боссом.");
                System.out.println("Нажмите 0, чтобы закончить игру.\n\n");
                choose = input.nextInt();
                switch (choose) {
                    case 1:
                        while (Creep_mini.HP > 0 && Hero.HP > 0) {
                            if (who_was_first == 0) {
                                hit_or_heall(Hero, Creep_mini);
                                if (Creep_mini.HP > 0) Creep_mini.attack(Hero);
                            } else {
                                Creep_mini.attack(Hero);
                                if (Hero.HP > 0) hit_or_heall(Hero, Creep_mini);
                            }
                        }
                        break;

                    case 2:
                        while (Creep_average.HP > 0 && Hero.HP > 0) {
                            if (who_was_first == 0) {
                                hit_or_heall(Hero, Creep_average);
                                if (Creep_average.HP > 0) Creep_average.attack(Hero);
                            }
                            else {
                                Creep_average.attack(Hero);
                                if (Hero.HP > 0) hit_or_heall(Hero, Creep_mini);
                            }
                        }
                        break;

                    case 3:
                        while (Boss.HP > 0 && Hero.HP > 0) {
                            if (who_was_first == 0) {
                                hit_or_heall(Hero, Boss);
                                if (Boss.HP > 0) Boss.attack(Hero);
                            }
                            else {
                                Boss.attack(Hero);
                                if (Hero.HP > 0) hit_or_heall(Hero, Boss);
                            }
                        }
                        break;

                    case 0:
                        flag = false;
                    default:
                        Hero.HP = 0;
                        break;
                }

                if (Creep_average.HP == 0){
                    Creep_average.Count_of_hits = 0;
                    Creep_average.respawn();
                }

                if (Creep_mini.HP == 0){
                    Creep_mini.Count_of_hits = 0;
                    Creep_mini.respawn();
                }

                if(Hero.HP == 0)flag = false;

                if(Boss.HP == 0){
                    Creep_average.respawn();
                    Creep_average.enhancement();
                    Creep_average.toString();
                    Creep_mini.respawn();
                    Creep_mini.enhancement();
                    Creep_mini.toString();
                    Boss.respawn();
                    Boss.enhancement();
                }
            }
        }
    }
}
