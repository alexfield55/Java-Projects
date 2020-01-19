package circles;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CircleApp extends JFrame
{

    public static void main(String[] args)
    {
	new CircleApp().run();
    }

    public void run()
    {
	setBounds(100, 10, 400, 500);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	add(new Circle());
	setVisible(true);
	
	System.out.println(Math.pow(2, -103));
    }

}
