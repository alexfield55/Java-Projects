package labWrapperClassGUI;

public class DemoWrapperClassConsole {
    public static void main(String[] args)
    {
        DemoWrapperClass dwc = new DemoWrapperClass();

        System.out.println("Method minMax:\n\n" + dwc.minMax());
        

        System.out.println("\nMethod toBinary:\n\n" +  dwc.toBinary(15));
       

        System.out.println("\nMethod charProperties:\n\n"+ dwc.charProperties(' ') + "\n" + dwc.charProperties('1')+ "\n" + dwc.charProperties('b')+ "\n" + dwc.charProperties('B'));

    }

}
