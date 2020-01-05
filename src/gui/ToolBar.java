package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToolBar extends JPanel implements ActionListener
{
    private JButton helloButton;
    private JButton goodbyeButton;
    private MainFrame.StringListener textListener;

    public ToolBar()
   {
       setBorder (BorderFactory.createEtchedBorder());
       //etched [eʧt] прич
       //вытравленный, протравленный

       helloButton = new JButton("Hello");
       goodbyeButton= new JButton("GoodBye");

       helloButton.addActionListener(this);
       goodbyeButton.addActionListener(this);

       setLayout(new FlowLayout(FlowLayout.LEFT));

       add(helloButton);
       add(goodbyeButton);
   }
    public void setStringListener (MainFrame.StringListener listener)
    {
        this.textListener = listener;
    }

    @Override
    //why e or arg0, what's the difference?
    public void actionPerformed(ActionEvent arg0)
    {
        JButton clicked = (JButton)arg0.getSource();
        //System.out.println("A button has been clicked");
         if(clicked == helloButton)
         {
             if (textListener != null)
             {
                 textListener.textEmitted("Hello\n");
             }
         }
        // {
            // textPanel.appendText("Hello\n");
        // }
         else if (clicked == goodbyeButton)
            // textPanel.appendText("Bye\n");
            {
             if (textListener != null)
             {
                 textListener.textEmitted("Bye\n");
             }
            }
    }
}
