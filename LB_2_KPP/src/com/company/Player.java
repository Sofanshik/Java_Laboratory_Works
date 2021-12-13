package com.company;
import java.util.Scanner;
import java.util.Comparator;

public class Player extends GameMech implements Comparable<Player>{
    Scanner input = new Scanner(System.in);
    protected float Strange;
    protected float Agility;
    protected int Count_point_per_level;
    private int Value_before_up_level = 1;
    private int counter = 1;
    protected int heal_potion = 0;


    @Override
    public int compareTo(Player pl) {
        return (this.Max_HP - pl.Max_HP);
    }
/*
public int compareTo(Object obj){
        int otherMax_HP = (((Enemy_Characters)obj).getMax_HP());
        int otherDamage = (((Enemy_Characters)obj).getDamage());
        if(this.HP == otherMax_HP && this.Damage == otherDamage){
            return 0;
        }
        else{
            return (this.HP > otherMax_HP && this.Damage > otherDamage ) ? 1 :-1;
        }
    }
* */


    public Player(){
        set_name();
        this.Max_HP = 100;
        this.HP = Max_HP;
        this.Damage = 10;
        this.Strange = 0;
        this.Agility = 0;
    }

    public Player(int Max_HP, int Damage){
        set_name();
        this.Max_HP = Max_HP;
        this.HP = Max_HP;
        this.Damage = Damage;
        this.Strange = 0;
        this.Agility = 0;
    }


    public void set_name(){
        System.out.println("\n\n|~~~~~~~~~~~ Введите имя персонажа! ~~~~~~~~~~~|\n");
        this.Name = input.nextLine();
    }


    public void attack(Enemy_Characters enemy) {
        if (enemy.HP > 0) {
            this.Damage = (int) (Math.random() * ((this.Damage + 6) - this.Damage) + this.Damage);
            if (this.Damage > enemy.HP) enemy.HP = 0;
            else enemy.HP -= this.Damage;
            if(enemy.HP == 0){
                if (enemy.Level % 2 == 1){
                    this.Count_point_per_level++;
                }
                else if(enemy.Level % 2 == 0){
                    this.Count_point_per_level += 3;
                }
                else{
                    this.Count_point_per_level += 10;
                }
                System.out.println("\n\n:::::::::::::Ваша атака нанесла " + this.Damage + " едениц урона" +
                        ":::::::::::::\n:::::::::::::Вражеский юнит - убит!:::::::::::::");
                if (this.Count_point_per_level >= this.Value_before_up_level){
                    this.Level += 1;
                    this.heal_potion += 1;
                    this.enhancement();
                    System.out.println("\n*%%% LEVEL UP %%%* \nУровень вашего героя увеличен, до " + this.Level + "\n*%%% LEVEL UP %%%*");
                    this.Value_before_up_level = (int) Math.pow(1, counter);
                    counter += 1;
                }
            }
            else{
                System.out.println("\n\n:::::::::::::Ваша атака нанесла " + this.Damage + " едениц урона:::::::::::::" +
                        "\n:::::::::::::У противника осталось " + enemy.HP + " едениц HP:::::::::::::");
            }
        }
    }


    public void heal(){
        if (this.HP > (this.Max_HP/2)){
            this.HP += (this.Max_HP - this.HP);
        }
        else{
            this.HP += (this.Max_HP/2);
        }
        this.heal_potion--;
    }


    public void enhancement(){
        this.Strange += 3;
        this.Agility += 1.5;
        this.Damage += this.Damage * (Agility * 0.1);
        this.Max_HP += (int) (this.Max_HP * 0.1) + (this.Strange * 1.3);
        this.HP += this.Max_HP * 0.1;
        this.toString();
    }


    public String toString(){
        return "Герой по имени " + this.Name + " имеет такие атрибуты: \n" + " HP = " + this.HP  + "/" + this.Max_HP +
                " Урон = " + this.Damage + " Уровень = " + this.Level + "!";
    }


}