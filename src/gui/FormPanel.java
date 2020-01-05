package gui;

import com.appl;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class FormPanel extends JPanel
    {
        private JLabel nameLabel;
        private JLabel last_NameLabel;
        private JTextField nameField;
        private JTextField last_NameField;
        private JButton okBtn;
        private FormListener formListener;
        private JList ageList;
        private JComboBox empCombo;
        private  JCheckBox ratesCheck;//exist rates?•
        private  JTextField ratesField;//••
        private  JLabel ratesLabel; //••
        private  JButton btnClient;




        public FormPanel()
        {
            Dimension dim = getPreferredSize();
            dim.width = 250;
            setPreferredSize(dim);

            //item description
            nameLabel = new JLabel ("First Name:");
            last_NameLabel = new JLabel("Last Name:");
            nameField = new JTextField(10);
            last_NameField = new JTextField(10);
            ageList = new JList();
            empCombo = new JComboBox();
            ratesCheck = new JCheckBox();
           ratesField= new JTextField(10);
            ratesLabel = new JLabel("Rates:");
            okBtn = new JButton("ok");
            btnClient = new JButton(" Client (all about)");


            //Set up mnemonics
            okBtn.setMnemonic(KeyEvent.VK_O);
            nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
            nameLabel.setLabelFor(nameField);//set up from label to field

            ////////Set up rates ID////////////
            ratesLabel.setEnabled(false);
            ratesField.setEnabled(false);

            ratesCheck.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean isTicked = ratesCheck.isSelected();
                    ratesLabel.setEnabled(isTicked);
                    ratesField.setEnabled(isTicked);
                }
            });


            ////////Set up list box////////////

            DefaultListModel ageModel = new DefaultListModel();
            ageModel.addElement(new AgeCategory(1,"Under 18"));
            ageModel.addElement(new AgeCategory(2,"18 to 65"));
            ageModel.addElement(new AgeCategory(3,"60 or over"));
            ageList.setModel(ageModel);


            ageList.setPreferredSize(new Dimension(110,70));
            ageList.setBorder(BorderFactory.createEtchedBorder());
            ageList.setSelectedIndex(1);

            /////////Set up Combo Box////////
            DefaultComboBoxModel empModel = new DefaultComboBoxModel();
            empModel.addElement("employed");
            empModel.addElement("self-emploued");
            empModel.addElement("unemployed");
            empCombo.setModel(empModel);
            empCombo.setSelectedIndex(0);
            empCombo.setEditable(true);







            okBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name= nameField.getText();
                    String last_Name = last_NameField.getText();
                    AgeCategory ageCat = (AgeCategory)ageList.getSelectedValue();
                    String empCat = (String)empCombo.getSelectedItem();
                    String ratesId = ratesField.getText();
                    boolean rates = ratesCheck.isSelected();



                    FormEvent ev = new FormEvent(this, name, last_Name,
                            ageCat.getId(), empCat, ratesId, rates);

                    if(formListener != null)
                    {
                        formListener.formEventOccurred(ev);
                    }


                }
            });
// t потрачено немерянно
            btnClient.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    appl plane = new appl();
                   // add(plane);ты городила херню
                    plane.setVisible(true);

                }
            });





                    
            //decoration for me
            Border innerBorder = BorderFactory.createTitledBorder("Add Person");
            Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
            setBorder (BorderFactory.createCompoundBorder(outerBorder, innerBorder));

            layoutComponents();



        }
    public void layoutComponents()
    {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //#1
        ////////////////////////First row//////////////
        /*Bullshit moved*/
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;


        /*Bullshit moved*/
        gc.gridx = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(nameLabel,gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField,gc);

        ////////////////////////Second  row//////////////
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.1;




        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5); //distance between label/field
        gc.anchor = GridBagConstraints.LINE_END;
        add(last_NameLabel,gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(last_NameField,gc);
        ////////////////////////Third row//////////////
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5); //distance between label/field
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Age: "),gc);


        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(ageList, gc);
        //////////////////////// 4 row//////////////
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;


        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5); //distance between label/field
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Employment: "),gc);


        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(empCombo, gc);

        //////////////////////// 5 row//////////////
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;


        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5); //distance between label/field
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Rates(Тариф): "),gc);


        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(ratesCheck, gc);


        //////////////////////// 5 row//////////////
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;


        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,5); //distance between label/field
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(ratesLabel,gc);


        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(ratesField, gc);

        ////////////////////////6 (button) row//////////////
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 2.0;


        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(okBtn, gc);
        ////////////////////////7 (button) row//////////////
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 2.0;


        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(btnClient, gc);



    }

    //private  void set

    public void setFormListener(FormListener listener)
        {
            this.formListener = listener;
        }
    }

    class AgeCategory {
    private int id;
    private String text;

    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }


    public String toString() {
        return text;
    }
    public int getId()
    {
        return id;
    }

}