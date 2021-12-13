package com.company;
import java.util.Random;

public class Enemy_Characters extends GameMech implements Comparable{

    int Damage_creep;
    protected int Count_of_hits;

    public Enemy_Characters(){
        this.HP = 35;
        this.Max_HP = this.HP;
        this.Damage = 5;
        this.Level = 1;
    }


    public Enemy_Characters(int HP, int Damage){
        this.HP = 35 + HP;
        this.Max_HP = this.HP;
        this.Damage = 5 + Damage;
        this.Level = 2;
    }


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


    public void respawn(){
        if (this.Level % 2 == 1) {
            this.HP = 35;
            this.Max_HP = this.HP;
            this.Damage = 5;
            this.Count_of_hits = 0;
        }
        else{
            this.HP = 50;
            this.Max_HP = this.HP;
            this.Damage = 23;
            this.Level = 2;
            this.Count_of_hits = 0;
        }
    }

    public void attack(Player player){
        if(this.Level % 2 == 1){
            // Атака для маленького крипа
            Random randv = new Random();
            this.Damage_creep = this.Damage + randv.nextInt(5);
            if(player.HP > 0 && Count_of_hits < 3){
                if (this.Damage_creep > player.HP) player.HP = 0;
                else {
                    Count_of_hits += 1;
                    player.HP -= this.Damage_creep;
                }
                System.out.println("Крип нанёс герою " + this.Damage_creep + " единиц урона.У игрока осталось "+ player.HP + " единиц здоровья");
            }
            else if(Count_of_hits == 3){ // balance
                if ((this.Damage_creep * 1.5) > player.HP) player.HP = 0;
                else {
                    player.HP -= (int)(this.Damage_creep * 1.5);// урон от крита маленького крипа
                    Count_of_hits = 0;}
                System.out.println("Крип нанёс герою " + (int)(this.Damage_creep * 1.5) + " единиц урона.У игрока осталось "+ player.HP + " единиц здоровья");
            }
        }
        else if(this.Level % 2 == 0){ // Атака для средних крипов
            Random randv1 = new Random();
            this.Damage_creep = (int) ((this.Damage * 1.7) + randv1.nextInt(5)); // balance
            if(player.HP > 0 && Count_of_hits < 5){ // balance
                if (this.Damage_creep > player.HP) player.HP = 0;
                else {
                    Count_of_hits += 1;
                    player.HP -= this.Damage_creep;
                }
                System.out.println("Крип нанёс герою " + this.Damage_creep + " единиц урона.У игрока осталось "+ player.HP + " единиц здоровья");
            }
            else if(Count_of_hits == 5){ // balance
                if ((this.Damage_creep * 1.2) > player.HP) player.HP = 0;
                else {
                    player.HP -= (int) (this.Damage_creep * 1.2); //balance // урон от крита среднего крипа
                    Count_of_hits = 0;
                }
                System.out.println("Крип нанёс герою " + (int) (this.Damage_creep * 1.2) + " единиц урона.У игрока осталось " + player.HP + " единиц здоровья");
            }
        }
    }


    public void enhancement(){
        this.Level += 2;
        this.Max_HP = (int)(this.Max_HP*2.5);
        this.HP = this.Max_HP;
        this.Damage = (this.Damage*2);
    }

    public String toString(){
        return "Вражеский юнит имеет такие атрибуты: \n" + " HP = " + this.HP  + "/" + this.Max_HP +
                " Урон = " + this.Damage + " Уровень = " + this.Level + "!";
    }
}