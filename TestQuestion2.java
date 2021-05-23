import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class TestQuestion2 extends JFrame implements ActionListener
{
	JTextField jtfileName,jtwordtofind;
	JLabel j1,jlword, jlresult;
	JButton jtsearch;
	JPanel jp1;
	public TestQuestion2(String s)
	{
		super(s);
		j1=new JLabel("Enter File Name:");
		jtfileName=new JTextField(10);
		jlword=new JLabel("Enter the word to search");
		jtwordtofind=new JTextField(10);
		jtsearch=new JButton("Click");
		jtsearch.addActionListener(this);
		jlresult=new JLabel();
		jp1=new JPanel();
		jp1.add(j1);
		jp1.add(jtfileName);
		jp1.add(jlword);
		jp1.add(jtwordtofind);
		jp1.add(jtsearch);
		jp1.add(jlresult);
		add(jp1);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			String b =ae.getActionCommand();
			if(b.equals("Click"))
			{
				File f=new File(jtfileName.getText()); 
				FileReader fr = new FileReader(f);
				String[] words=null;
				String s;   
				BufferedReader bfr = new BufferedReader(fr);
				int count=0;   
				while((s=bfr.readLine())!=null)  
			    {
					words=s.split(" ");  //Split the word using space
					for (String word : words) 
					{
						if (word.equals(jtwordtofind.getText()))   
						{
						   count++;    
						}
				  }
			  }
			  if(count!=0)  
			  {
				 jlresult.setText("The " + jtwordtofind.getText()+" word is present :  "+count+ " times in the file!");
			  }
			  else
			  {
				 jlresult.setText("The " + jtwordtofind.getText()+" word is not present in the file");
			  }
			  fr.close();
			}
		}
		catch(Exception ex)
		{
			jlresult.setText(""+ex);
		}
	}
	public static void main(String args[])
	{
	   JFrame jf=new TestQuestion2("TestQuestion2");
	   jf.setSize(400,400);
	   jf.setVisible(true);
	}
}