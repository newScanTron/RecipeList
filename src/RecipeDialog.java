import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.util.ArrayList;
/*
 * Created by JFormDesigner on Wed Oct 08 12:26:51 MDT 2014
 */



/**
 * @author Aaron Cameron
 */
public class RecipeDialog extends JDialog {

    Controller controller;

    RecipeGUI gui;
    Recipe newRecipe = new Recipe(0,"Window Test");
    ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

    public RecipeDialog(Frame parent, RecipeGUI _gui, Recipe _newRecipe, Controller _controller) {

        super(parent,true);
        newRecipe = _newRecipe;
        controller = _controller;
        gui = _gui;
        System.out.println("Constructor");
        if (parent != null) {
            Dimension parentSize = parent.getSize();
            Point p = parent.getLocation();
            setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
        }
        initComponents();
    }

    public Recipe getRecipe() {
        return newRecipe;
    }



    private void ingListValueChanged(ListSelectionEvent e) {
        // TODO add your code here
        ingList.updateUI();
    }

    private void deleteButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        int ind = ingList.getSelectedIndex();
        String val = ingList.getSelectedValue();

        for(int i = 0; i < ingredients.size(); i++) {
            String ingName = ingredients.get(i).toString();
            if (ingName.equalsIgnoreCase(val)) {
                ingredients.remove(i);
            }
        }

        listModel.removeElementAt(ind);
        ingList.updateUI();
    }

    private void addButtonActionPerformed(ActionEvent e) {

        System.out.println("Add Button Pressed");
        controller.gatherIngredient(this);

    }

    private void okButtonActionPerformed(ActionEvent e) {


        System.out.println("Ok Pressed");
        controller.gatherRecipe(this);
        dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent e) {

        newRecipe = null;
        System.out.println("Cancel Pressed");
        dispose();

    }

    private void initComponents() {

        listModel = new DefaultListModel<String>() {
            String[] values = newRecipe.getIngredientNames();
            //String[] values = new String[] {"one", "two", "three"};


            @Override
            public int getSize() { return values.length; }
            @Override
            public String getElementAt(int i) { return values[i]; }
            @Override
            public void removeElementAt(int i) {
                String[] newValues = new String[values.length-1];
                for(int a = 0; a < i; a++){
                    newValues[a] = values[a];
                }
                for(int a = i; a < values.length-1; a++){
                    newValues[a] = values[a+1];
                }
                values = newValues;
            }
            @Override
            public void addElement(String s) {
                String[] newValues = new String[values.length+1];
                for(int a = 0; a < values.length; a++){
                    newValues[a] = values[a];
                    System.out.println("Copied: " + newValues[a]);
                }
                newValues[values.length] = s;
                System.out.println("Added: " + s);
                values = newValues;

            }
        }; // Logic for displaying the names in the list model



        System.out.println("initComponents");
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aaron Cameron
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        nameLabel = new JLabel();
        nameField = new JTextField();
        tagField = new JTextField();
        tagLabel = new JLabel();
        ingLabel = new JLabel();
        ingScrollPane = new JScrollPane();
        ingList = new JList();
        deleteButton = new JButton();
        amountLabel = new JLabel();
        unitLabel = new JLabel();
        ingNameLabel = new JLabel();
        amountField = new JTextField();
        unitField = new JTextField();
        ingNameField = new JTextField();
        addButton = new JButton();
        directionsLabel = new JLabel();
        directionsScrollPane = new JScrollPane();
        directionsArea = new JTextArea();
        seperateLabel = new JLabel();
        helpScrollPane = new JScrollPane();
        helpPane = new JTextPane();
        buttonBar = new JPanel();
        okButton = new JButton();
        okButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                okButtonActionPerformed(e);
            }
        });
        cancelButton = new JButton();
        cancelButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelButtonActionPerformed(e);
            }
        });

        //======== this ========
        setTitle("Add/Edit Recipe");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //---- nameLabel ----
                nameLabel.setText("Name:");
                contentPanel.add(nameLabel);
                nameLabel.setBounds(new Rectangle(new Point(5, 10), nameLabel.getPreferredSize()));
                contentPanel.add(nameField);
                nameField.setBounds(50, 5, 185, nameField.getPreferredSize().height);
                contentPanel.add(tagField);
                tagField.setBounds(50, 40, 185, 28);

                //---- tagLabel ----
                tagLabel.setText("Tags:");
                contentPanel.add(tagLabel);
                tagLabel.setBounds(10, 45, 40, 16);

                //---- ingLabel ----
                ingLabel.setText("Ingredients");
                contentPanel.add(ingLabel);
                ingLabel.setBounds(new Rectangle(new Point(10, 90), ingLabel.getPreferredSize()));

                //======== ingScrollPane ========
                {

                    //---- ingList ----
                    ingList.addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            ingListValueChanged(e);
                        }
                    });
                    ingList.setModel(listModel);
                    ingList.setBorder(null);
                    ingScrollPane.setViewportView(ingList);
                }
                contentPanel.add(ingScrollPane);
                ingScrollPane.setBounds(10, 110, 115, 155);

                //---- deleteButton ----
                deleteButton.setText("Delete");
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteButtonActionPerformed(e);
                    }
                });
                contentPanel.add(deleteButton);
                deleteButton.setBounds(10, 265, 115, deleteButton.getPreferredSize().height);

                //---- amountLabel ----
                amountLabel.setText("Amount:");
                contentPanel.add(amountLabel);
                amountLabel.setBounds(new Rectangle(new Point(130, 110), amountLabel.getPreferredSize()));

                //---- unitLabel ----
                unitLabel.setText("Unit:");
                contentPanel.add(unitLabel);
                unitLabel.setBounds(new Rectangle(new Point(130, 135), unitLabel.getPreferredSize()));

                //---- ingNameLabel ----
                ingNameLabel.setText("Name:");
                contentPanel.add(ingNameLabel);
                ingNameLabel.setBounds(new Rectangle(new Point(130, 160), ingNameLabel.getPreferredSize()));
                contentPanel.add(amountField);
                amountField.setBounds(190, 105, 115, amountField.getPreferredSize().height);
                contentPanel.add(unitField);
                unitField.setBounds(190, 130, 115, 28);
                contentPanel.add(ingNameField);
                ingNameField.setBounds(190, 155, 115, 28);

                //---- addButton ----
                addButton.setText("< Add");
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addButtonActionPerformed(e);
                    }
                });
                contentPanel.add(addButton);
                addButton.setBounds(new Rectangle(new Point(205, 180), addButton.getPreferredSize()));

                //---- directionsLabel ----
                directionsLabel.setText("Directions:");
                contentPanel.add(directionsLabel);
                directionsLabel.setBounds(new Rectangle(new Point(320, 10), directionsLabel.getPreferredSize()));

                //======== directionsScrollPane ========
                {
                    directionsScrollPane.setViewportView(directionsArea);
                }
                contentPanel.add(directionsScrollPane);
                directionsScrollPane.setBounds(320, 30, 275, 270);

                //---- seperateLabel ----
                seperateLabel.setText("Seperate by spaces");
                seperateLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
                contentPanel.add(seperateLabel);
                seperateLabel.setBounds(new Rectangle(new Point(85, 65), seperateLabel.getPreferredSize()));

                //======== helpScrollPane ========
                {

                    //---- helpPane ----
                    helpPane.setBackground(Color.lightGray);
                    helpPane.setEditable(false);
                    helpPane.setText("Add recipes to the Ingredients List by using the form above. Use the delete button to remove items.");
                    helpPane.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
                    helpScrollPane.setViewportView(helpPane);
                }
                contentPanel.add(helpScrollPane);
                helpScrollPane.setBounds(135, 210, 175, 90);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        //setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Aaron Cameron
    public JPanel dialogPane;
    public JPanel contentPanel;
    public JLabel nameLabel;
    public JTextField nameField;
    public JTextField tagField;
    public JLabel tagLabel;
    public JLabel ingLabel;
    public JScrollPane ingScrollPane;
    public JList<String> ingList;
    public DefaultListModel<String> listModel;
    public JButton deleteButton;
    public JLabel amountLabel;
    public JLabel unitLabel;
    public JLabel ingNameLabel;
    public JTextField amountField;
    public JTextField unitField;
    public JTextField ingNameField;
    public JButton addButton;
    public JLabel directionsLabel;
    public JScrollPane directionsScrollPane;
    public JTextArea directionsArea;
    public JLabel seperateLabel;
    public JScrollPane helpScrollPane;
    public JTextPane helpPane;
    public JPanel buttonBar;
    public JButton okButton;
    public JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
