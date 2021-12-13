package com.company;
import java.util.Random;
import java.util.Comparator;



public class Enemy_Boss extends Enemy_Characters{

    int Damage_boss;

    public Enemy_Boss(){
        this.Max_HP = 500;
        this.HP = 500;
        this.Damage = 50;
        this.Level = 15;
    }

    public Enemy_Boss(int Max_hp, int damage, int lvl){
        this.Max_HP = Max_hp;
        this.HP = Max_hp;
        this.Damage = damage;
        this.Level = lvl;
    }

    public void attack(Player player){
        if(player.HP > 0 && Count_of_hits < 7) {
            Random randval = new Random();
            this.Damage_boss = this.Damage + randval.nextInt(15);
            if (this.Damage_boss > player.HP){
                player.HP -= this.Damage_boss; // удар Босса
                player.HP = 0;
                System.out.println("\n\n:::::::::::::Босс нанёс герою " + this.Damage_boss  + " единиц " +
                        "урона:::::::::::::\n:::::::::::::У игрока не осталось единиц здоровья:::::::::::::");
                Count_of_hits += 1;
            } else{
                player.HP -= this.Damage_boss; // удар Босса
                System.out.println("\n\n:::::::::::::Босс нанёс герою " + this.Damage_boss  + " единиц " +
                        "урона:::::::::::::\n:::::::::::::У игрока осталось "+ player.HP + " единиц здоровья:::::::::::::");
                Count_of_hits += 1; }
        } else if(player.HP > 0 && Count_of_hits == 7){
            int Crit = (int)(this.Damage_boss * 1.1);
            if (Crit > player.HP) {
                player.HP -= Crit;// урон от крита Босса // удар Босса
                player.HP = 0;
                System.out.println("\n\n:::::::::::::Босс нанёс герою Сокрушающий удар в " + Crit + " единиц " +
                        "урона:::::::::::::\n:::::::::::::У игрока не осталось единиц здоровья:::::::::::::");
                Count_of_hits = 0;
            }
            else{
                player.HP -= Crit;// урон от крита Босса // удар Босса
                System.out.println("\n\n:::::::::::::Босс нанёс герою Сокрушающий удар в " + Crit + " единиц " +
                        "урона:::::::::::::\n:::::::::::::У игрока осталось "+ player.HP +" единиц здоровья:::::::::::::");
                Count_of_hits = 0;
            }
        }
    }


    public void enhancement(){
        this.Level += 2;
        this.Max_HP = (int)(this.Max_HP*2.5);
        this.HP = this.Max_HP;
        this.Damage = (this.Damage*2);
    }


    public void respawn(){

    }

    public String toString(){
        return "Босс имеет такие атрибуты: \n" + " HP = " + this.HP  + "/" + this.Max_HP +
                " Урон = " + this.Damage + " Уровень = " + this.Level + "!";
    }

    //Comparator для сортировки списка или массива объектов по Max_HP
    public static Comparator<Enemy_Boss> Max_HPComparator = new Comparator<Enemy_Boss>(){

        @Override
        public int compare(Enemy_Boss o1, Enemy_Boss o2) {
            return  (o1.getMax_HP() - o2.getMax_HP());
        }
    };


}