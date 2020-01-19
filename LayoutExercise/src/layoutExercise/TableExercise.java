package layoutExercise;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableExercise
{

    private JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
	EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		try
		{
		    TableExercise window = new TableExercise();
		    window.frame.setVisible(true);
		} catch (Exception e)
		{
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public TableExercise()
    {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JScrollPane scrollPane = new JScrollPane();
	frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	
	table = new JTable();
	table.setModel(new DefaultTableModel(
		new Object[][] {
			{null, null, null},
			{null, null, null},
			{null, null, null},
			{null, null, null},
		},
		new String[] {
			"col 1", "col 2", "col 3"
		}
	));
	scrollPane.setViewportView(table);
    }

}
