//Alex Field
//CS1400
//5/1/18

package final1400;

import java.util.ArrayList;


public class DemoList
{

 
    public static void main(String[] args)
    {
       ArrayList<Integer> numbers = new ArrayList();
       
       numbers.add(5);
       numbers.add(7);
       numbers.add(2);
       numbers.add(8);
       numbers.add(10);
       numbers.add(45);
       
        System.out.println("list: " + numbers.toString());
        
        numbers.remove(numbers.size()-1);
       
        Integer sum = 0;
        
        for (Integer n: numbers)
        {
            sum+=n;
        }
       
        System.out.println("Sum of elements in list: " + sum);
        
        numbers.set(numbers.size()-1, 18);
        
        for(int i = 0; i< numbers.size(); i++)
        {
            if(numbers.get(i)==8)
            {
                numbers.remove(i);
            }
        }
        
        System.out.println("list: " + numbers.toString());
        
        
    }
    
}
