package labPolymorphism;

import java.util.ArrayList;

public class DogApp
{
    public static void main(String[] args)
    {
        Dog myDog = new Dog("Greyhound");
        System.out.println(myDog.toString());
        actAsDog(myDog);

        SledDog mySledDog = new SledDog("Husky");
        System.out.println(mySledDog.toString());
        actAsDog(mySledDog);

        CircusDog myCircusDog = new CircusDog("Terrier");
        System.out.println(myCircusDog.toString());
        actAsDog(myCircusDog);
        
        System.out.println("Using an Array");
        System.out.println();
        
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(myDog);
        dogs.add(mySledDog);
        dogs.add(myCircusDog);
        
        for(Dog el: dogs)
        {
            System.out.println(el.toString());
            if(el instanceof SledDog)
            {
        	((SledDog) el).pullSled();
            }
            actAsDog(el);
            
        }
    }
    
   

    private static void actAsDog(Dog d)
    {
        d.communicate();
        d.move();
        System.out.println();
    }
}
