package com.company;
import java.lang.Object;
import java.lang.String;


public class GameMech {


    // Переменные
    public int HP;
    protected int Max_HP;
    protected String Name;
    protected int Damage;
    protected int Level;

    // Модификаторы и селекторы полей
    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return HP;
    }

    public int getMax_HP() {
        return Max_HP;
    }

    public void setMax_HP(int max_HP) {
        Max_HP = max_HP;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    // Методы
    public void status_of_character() {
        if(this.HP == 0){
            System.out.println(" Игрок мёртв ");
            Damage = 0;
        }else if(HP > 0){
            System.out.println(" Игрок жив ");
            System.out.println("HP = " + this.HP  + "/" + this.Max_HP + " Урон = " + this.Damage +
                    " Уровень = " + this.Level + "!");
        } else{
            System.out.println(" Ошибка, не может быть отрицательного значения жизни ");
        }
    }


    public void attack(Object object){
        //object.HP -= this.Damage;
    }


    public void enhancement(){

    }

    public String toString(){
        return "";
    }

}