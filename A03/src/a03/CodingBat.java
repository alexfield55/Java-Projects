package a03;

public class CodingBat
{

    public String zipZap(String str)
    {
      
      StringBuilder sb = new StringBuilder(str);
      
      for(int i = 0; i<sb.length()-1;i++)
      {
        if((i+2)>=sb.length())
        {
        break;
        }
        
        if(sb.charAt(i) == 'z' && sb.charAt(i+2) == 'p')
          {
            sb.deleteCharAt(i+1);
          }
      }
      
    return sb.toString();
    
    }


}
