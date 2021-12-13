package com.company;
import java.util.Comparator;

class ComparePlayers implements Comparator<Player> {

    public int compare(Player o1,Player o2){
        int thisMax_HP = (((Player)o1).getMax_HP());
        int otherMax_HP = (((Player)o2).getMax_HP());
        if(otherMax_HP == thisMax_HP){
            System.out.println("\nЗдоровье игроков одинаково: " + thisMax_HP +" = "+ otherMax_HP + "\n");
            return 0;
        }
        System.out.println("\nЗдоровье игроков: " + thisMax_HP +" = "+ otherMax_HP + "\n");
        return (thisMax_HP > otherMax_HP)? 1 : -1;
    }

}
