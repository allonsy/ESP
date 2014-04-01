/* Alec Snyder
 * cs162
 * ESP GUI program
 * Do you have ESP? find out! */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
public class ESP implements ActionListener
{
    boolean activated=false;
    int positive=0; int negative=0;
    ArrayList<ImageIcon> positivePics, negativePics;
    JFrame frame;
    JButton right, left, quit, cont;
    ImageIcon curtain;
    
    public ESP()
    {
        populateArrays();
        curtain= new ImageIcon("curtains.gif");
        frame=new JFrame("Esp");
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,2));
        right=new JButton("", curtain);
        left=new JButton("", curtain);
        right.setBackground(Color.WHITE);
        left.setBackground(Color.WHITE);
        panel.add(right);
        panel.add(left);
        cont=new JButton("continue");
        cont.addActionListener(this);
        left.addActionListener(this);
        right.addActionListener(this);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        quit=new JButton("quit");
        quit.addActionListener(this);
        frame.add(quit, BorderLayout.NORTH);
        frame.add(cont, BorderLayout.SOUTH);
        frame.getRootPane().setDefaultButton(cont);
        frame.pack();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==(Object)(quit))
        {
            frame.dispose();
            outmessage();
            System.exit(0);
        }
        else if(e.getSource()==(Object)(right))
        {
            if(!activated)
            {
                if(display(right)) {}
            
                else
                {
                    //outmessage();
                    //System.exit(0);
                }
            }
            else
            {
                right.setIcon(curtain);
                left.setIcon(curtain);
                activated=false;
            }
        }
        else if(e.getSource()==(Object)(left))
        {
            if(!activated)
            {
                if(display(left)) {}
            
                else
                {
                    //outmessage();
                    //System.exit(0);
                }
            }
            else
            {
                right.setIcon(curtain);
                left.setIcon(curtain);
                activated=false;
            }
        }
        else if(e.getSource()==(Object)(cont))
        {
            if(positivePics.isEmpty() && negativePics.isEmpty())
            {
                outmessage();
                System.exit(0);
            }
            contTest();
        }
    }
    public boolean display(JButton sel)
    {
        activated=true;
        int arr, select;
        boolean correct;
        int doorSelect=(int)(Math.random()*2);
        JButton door;
        if(doorSelect==0)
        {
            door=right;
            correct=right==sel;
        }
        else
        {
            door=left;
            correct=left==sel;
        }
        if(positivePics.isEmpty() && negativePics.isEmpty())
        {
            return false;
        }
        else if((!positivePics.isEmpty()) && (!negativePics.isEmpty()))
        {
            arr=(int)(Math.random()*2);
        }
        else if(positivePics.isEmpty())
            arr=1;
        else
            arr=0;
        if(arr==0)
        {
            select=(int)(Math.random()*positivePics.size());
            door.setIcon(positivePics.remove(select));
            if(correct)
                positive++;
            return true;
        }
        else
        {
            select=(int)(Math.random()*negativePics.size());
            door.setIcon(negativePics.remove(select));
            if(correct)
                negative++;
            return true;
        }
    }
    
    public void populateArrays()
    {
        positivePics=new ArrayList<ImageIcon>();
        negativePics=new ArrayList<ImageIcon>();
        positivePics.add(new ImageIcon("happy1.jpg"));
        positivePics.add(new ImageIcon("smiley.png"));
        positivePics.add(new ImageIcon("happy3.jpg"));
        positivePics.add(new ImageIcon("happy4.jpg"));
        positivePics.add(new ImageIcon("happy5.jpg"));
        positivePics.add(new ImageIcon("happy6.jpg"));
        positivePics.add(new ImageIcon("happy7.jpg"));
        positivePics.add(new ImageIcon("happy8.jpg"));
        positivePics.add(new ImageIcon("happy9.jpg"));
        positivePics.add(new ImageIcon("happy10.jpg"));
        negativePics.add(new ImageIcon("scary1.jpg"));
        negativePics.add(new ImageIcon("scary2.jpg"));
        negativePics.add(new ImageIcon("scary3.png"));
        negativePics.add(new ImageIcon("scary4.png"));
        negativePics.add(new ImageIcon("scary5.jpg"));
        negativePics.add(new ImageIcon("scary6.png"));
        negativePics.add(new ImageIcon("scary7.jpg"));
        negativePics.add(new ImageIcon("scary8.jpg"));
        negativePics.add(new ImageIcon("scary9.jpg"));
        negativePics.add(new ImageIcon("scary10.jpg"));
    }
    
    public void contTest()
    {
        right.setIcon(curtain);
        left.setIcon(curtain);
        activated=false;
    }
    public void outmessage()
    {
        System.out.println("Number of positive images guessed: "+positive+" Number of negative pictures guessed: "+negative);
        if(positive >5)
            System.out.println("You are pyschic to positive images");
        else
            System.out.println("You are not psychic to positive images");
        if(negative > 5)
            System.out.println("You are psychic to negative images");
        else
            System.out.println("You are not psychic to negative images");
        if(positive+negative > 10)
            System.out.println("You are psychic overall");
        else
            System.out.println("You are not psychic overall");
    }
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ESP(); 
            }
        });
    }
}
