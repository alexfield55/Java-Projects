//Alex Field
//CS1400
//5/1/18

package final1400;

import java.util.Arrays;


public class DemoArray
{
    
    public enum Fruit {BANANA, PEACH, PLUM, APPLE, ORANGE, GRAPEFRUIT}
    
    public static void main(String[] args)
    {
        Fruit[] fruitie = {Fruit.BANANA, Fruit.GRAPEFRUIT, Fruit.APPLE, Fruit.PLUM, Fruit.PEACH, Fruit.ORANGE, Fruit.PLUM};
        
        System.out.println("Fruits: " + Arrays.toString(fruitie));
        
        System.out.println("First fruit: " + fruitie[0]);
        
        System.out.println("Last Fruit: " + fruitie[fruitie.length-1]);
        
        fruitie[1] = Fruit.BANANA;
        
        System.out.println("Fruits: " + Arrays.toString(fruitie));
        
        System.out.println("Size: " + fruitie.length);
  
    }
    
}
