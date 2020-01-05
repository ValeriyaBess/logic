package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

/*getting inf from diffComponents*/
public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private ToolBar toolbar;
    private FormPanel formPanel;
    private JFileChooser fileChooser;
    private Controller controller;
    private TablePanel tablePanel;


    public MainFrame() {
        super("Hello World");

        setLayout(new BorderLayout());
///////constructor gui.MainFrame
        toolbar = new ToolBar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();
        tablePanel = new TablePanel();
        controller = new Controller();

        tablePanel.setData(controller.getPeople());

        tablePanel.setPersonTableListener (new PersonTableListener()

        {
            public void rowDeleted(int row)
            {
            controller.removePerson(row);
            }
        });



        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new PersonFileFilter());




        setJMenuBar((createMenuBar()));


        toolbar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {

                textPanel.appendText(text);
            }
        });


        formPanel.setFormListener(new FormListener() {
            public void formEventOccurred(FormEvent e) {


                controller.addPerson(e);
                tablePanel.refresh();
            }

        });

        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);

        setMinimumSize(new Dimension(400,500));
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    /// create new
    private JMenuBar createMenuBar(){

    JMenuBar menuBar = new JMenuBar();


    JMenu fileMenu = new JMenu("File");
    JMenuItem exportDataItem = new JMenuItem("Export Data...");
    JMenuItem importDataItem = new JMenuItem("Import Data...");
    JMenuItem exitItem = new JMenuItem("Exit");

    fileMenu.add(exportDataItem);
    fileMenu.add(importDataItem);
    fileMenu.addSeparator();
    fileMenu.add(exitItem);

    //-----------------------------Show
        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");

        JCheckBoxMenuItem showFormItem =  new JCheckBoxMenuItem("Person form");
        showFormItem.setSelected(true);
        showMenu.add(showFormItem);
        windowMenu.add(showMenu);

//------------------------------------------end show


    menuBar.add(fileMenu);
    menuBar.add(windowMenu);

    showFormItem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ev) {
            JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem)ev.getSource();

            formPanel.setVisible(menuItem.isSelected());
        }

    });
        ///////////////////////////HotKeys
        fileMenu.setMnemonic(KeyEvent.VK_F);



        exitItem.setMnemonic(KeyEvent.VK_X);

        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));//I don't hesitate

        importDataItem.addActionListener(new ActionListener() {
                                             @Override
                                             public void actionPerformed(ActionEvent e) {
                                                 if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                                                     try {

                                                         controller.loadFromFile(fileChooser.getSelectedFile());
                                                         tablePanel.refresh();
                                                     } catch (IOException ex) {
                                                         JOptionPane.showMessageDialog(MainFrame.this, "Could not load data from file.", "Error", JOptionPane.ERROR_MESSAGE);
                                                     }
                                                     System.out.println(fileChooser.getSelectedFile());
                                                 }
                                             }

                                         });

        exportDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {

                        try {

                            controller.saveToFile(fileChooser.getSelectedFile());

                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(MainFrame.this, "Could not safe data to file.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                }
            }

        });












        exitItem.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = JOptionPane.showInputDialog(MainFrame.this, "Enter your user name?", "Enter user name", JOptionPane.OK_OPTION | JOptionPane.QUESTION_MESSAGE);
                System.out.println(text);
               int action =  JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit the application?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
               if (action == JOptionPane.OK_OPTION)
               {
               System.exit(0);
               }

            }
        }));

        return menuBar;



}

    public static interface StringListener
    {
    public void textEmitted(String text);//излучаемый
    }
}
