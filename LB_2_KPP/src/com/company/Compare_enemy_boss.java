package com.company;
import java.util.Comparator;

class Compare_enemy_boss implements Comparator<Enemy_Boss> {

    @Override
    public int compare(Enemy_Boss o1, Enemy_Boss o2) {
        int thisDamage = (((Enemy_Boss)o1).getDamage());
        int thisMax_HP = (((Enemy_Boss)o1).getMax_HP());

        int otherDamage = (((Enemy_Boss)o2).getDamage());
        int otherMax_HP = (((Enemy_Boss)o2).getMax_HP());

        if(thisDamage == otherDamage && thisMax_HP == otherMax_HP){
            System.out.println("\nУрон и здоровье боссов одинаковые: "+ "\nУрон: "+thisDamage +" = "+ otherDamage +"HP: "+ thisMax_HP +" = "+ otherMax_HP+ "\n");
            return 0;
        } else{
            System.out.println("\nУрон и здоровье боссов разные: \n"+ "Урон: " + thisDamage +" = "+ otherDamage +"HP: "+ thisMax_HP +" = "+ otherMax_HP+ "\n");
            return (thisMax_HP > otherMax_HP && thisDamage > otherDamage) ? 1 : -1;
        }
    }
}