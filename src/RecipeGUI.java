import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;


public class RecipeGUI extends JPanel{
    //making a instance of the controller class to do stuff
    JFrame parent;

    Color bgColor = new Color(163, 144, 82);
    Color panelColor =  new Color(105, 93, 52);
    Color fgColor = new Color(0, 0, 0);
    Color listColor = new Color(191, 169, 96);


    public RecipeGUI() {
        initComponents();
        add(panel1);
        recipeListBox.setSelectedIndex(0);
        recipeListBox.getListSelectionListeners()[0].valueChanged(new ListSelectionEvent(this,0,0,true));
        recipeListBox.requestFocus();
        setBackground(panelColor);

        // Try unselecting the filterBox by default
    }
    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Adam Clemons
        createUIComponents();


        listModel = new DefaultListModel<String>() {
            String[] values = Controller.currentRecipes.getNames();

            @Override
            public void clear() {
                values = Controller.currentRecipes.getNames(); // Hi-jacking clear() to serve as a function to update values
            }
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
        }; // Logic for displaying the names in the list model


        panel1 = new JPanel();
        toolPanel = new JPanel();

// ACTION LISTENERS
        addButton = new JButton();
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //System.out.println("Adding Recipe...");
                Controller.openAddWindow(new Recipe(),false);

                //System.out.println(addedRecipe);

                /*
                while(listModel.getSize() > 0) {listModel.removeElementAt(0);}
                controller.currentRecipes.add(addedRecipe);
                System.out.println(controller.currentRecipes);
                listModel.clear();
                recipeListBox.updateUI();
                controller.addRecipe(addedRecipe);
                 */
            }
        });
        editButton = new JButton();
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //System.out.println("Editing Recipe...");
                int editIndex = recipeListBox.getSelectedIndex();
                String editName = recipeListBox.getSelectedValue();
                Recipe oldRecipe = Controller.currentRecipes.findByName(editName);
                Controller.openAddWindow(oldRecipe,true);
                // TODO: select editted recipe after
            }
        });
        deleteButton = new JButton();
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String deleteName = recipeListBox.getSelectedValue();
                Recipe delRecipe = Controller.currentRecipes.findByName(deleteName);
                Controller.deleteRecipeByID(delRecipe.id);

                listModel.clear();
                recipeListBox.setSelectedIndex(0);
                if (listModel.size() > 0) {
                    recipeListBox.getListSelectionListeners()[0].valueChanged(new ListSelectionEvent(this, 0, 0, true));
                }
                recipeListBox.updateUI();  // Refreshes UI

                //System.out.println("Deleting: " + deleteName);

            }
        });
        searchField = new JTextField();
        searchField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                searchField.setText("");
                searchField.setFont(new Font("",Font.PLAIN,12));
            }

            public void focusLost(FocusEvent e) {
                searchField.setText("Search by name, tags, or ingredients");
                searchField.setFont(new Font("Sanserif",Font.ITALIC,12));
            }
        });
        searchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText();
                Controller.searchRecipe(searchField.getText());
                listModel.clear();
                recipeListBox.updateUI();


            }
        });
        listPane = new JScrollPane();
        recipeListBox = new JList<String>();
        recipeListBox.setForeground(fgColor);
        recipeListBox.setBackground(listColor);

        recipeListBox.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    String name = recipeListBox.getSelectedValue();
                    Recipe selected = Controller.currentRecipes.findByName(name);
                    //System.out.println("Selected: " + selected.name);

                    directionsTextArea.setText("Directions: \n");
                    ingredientsTextArea.setText("Ingredients: \n");
                    tagsTextArea.setText("Tags: ");

                    titleLabel.setText(selected.name + " " + selected.id);

                    for (int i = 0; i < selected.directions.length; i++) {
                        directionsTextArea.append(selected.directions[i] + "\n");
                    }
                    for (int i = 0; i < selected.ingredients.length; i++) {
                        ingredientsTextArea.append(selected.ingredients[i].toString() + "\n");
                    }
                    for (int i = 0; i < selected.tags.length; i++) {
                        tagsTextArea.append(selected.tags[i] + "  ");
                    }
                }
            }
        });
        dataPane = new JScrollPane();
        dataPanel = new JPanel();
        titleLabel = new JLabel();
        directionsTextArea = new JTextArea();
        JSplitPane splitPane1 = new JSplitPane();
        ingredientsTextArea = new JTextArea();
        tagsTextArea = new JTextArea();

        //======== panel1 ========
        {
            panel1.setBorder(null);
            panel1.setLayout(new BorderLayout());

            //======== toolPanel ========
            {
                toolPanel.setPreferredSize(new Dimension(500, 30));
                toolPanel.setBorder(null);
                toolPanel.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), 0, -1));
                toolPanel.setBackground(panelColor);

              //---- addButton ----
				addButton.setBackground(Color.green);
				addButton.setText("+");
				toolPanel.add(addButton, new GridConstraints(0, 0, 1, 1,
					GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
					GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
					GridConstraints.SIZEPOLICY_FIXED,
					null, null, null));
				addButton.setFocusPainted(false);

				//---- editButton ----
				editButton.setBackground(Color.yellow);
				editButton.setText("\u0394");
				toolPanel.add(editButton, new GridConstraints(0, 1, 1, 1,
					GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
					GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
					GridConstraints.SIZEPOLICY_FIXED,
					null, null, null));
				editButton.setFocusPainted(false);

				//---- deleteButton ----
				deleteButton.setBackground(new Color(255, 51, 51));
				deleteButton.setInheritsPopupMenu(false);
				deleteButton.setMargin(new Insets(3, 14, 3, 14));
				deleteButton.setText("-");
				deleteButton.setVerifyInputWhenFocusTarget(false);
				toolPanel.add(deleteButton, new GridConstraints(0, 2, 1, 1,
					GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
					GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
					GridConstraints.SIZEPOLICY_FIXED,
					null, null, null));
				deleteButton.setFocusPainted(false);

                //---- searchField ----
                searchField.setText("Search by name, tags, or ingredients");
                searchField.setBorder(null);
                searchField.setPreferredSize(new Dimension(200, 14));
                searchField.setHorizontalAlignment(SwingConstants.TRAILING);
                toolPanel.add(searchField, new GridConstraints(0, 3, 1, 1,
                        GridConstraints.ANCHOR_EAST, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
            }
            panel1.add(toolPanel, BorderLayout.SOUTH);

            listPanel = new JPanel();
            listPanel.setLayout(new BorderLayout());
            
            //======== listPane ========
            {
                listPane.setDoubleBuffered(false);
                listPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                listPane.setMaximumSize(new Dimension(135, 400));
                listPane.setMinimumSize(new Dimension(130, 400));
                listPane.setPreferredSize(new Dimension(129, 400));
                listPane.setVisible(true);
                listPane.setBorder(null);

                //---- recipeListBox ----
                recipeListBox.setModel(listModel);
                recipeListBox.setBorder(null);
                listPane.setViewportView(recipeListBox);
                
              //---- filterBox ----
                filterPanel = new JPanel();
                filterPanel.setLayout(new BorderLayout());
                filterPanel.setBackground(bgColor);


                filterLabel = new JLabel("Filter By:");
                filterLabel.setFont(new Font("Serif",Font.ITALIC,16));
                listLabel = new JLabel("Recipes: ");
                listLabel.setFont(new Font("Serif",Font.ITALIC,16));
                filterBox = new JComboBox<String>(new String[]{"","Breakfast","Lunch","Dinner","Snack"});
                filterBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String searchText = filterBox.getSelectedItem().toString();
                        Controller.searchRecipe(searchField.getText());
                        listModel.clear();
                        recipeListBox.updateUI();

                    }
                });



                filterBox.setAutoscrolls(true);


                filterPanel.add(filterLabel, BorderLayout.NORTH);
    			filterPanel.add(filterBox, BorderLayout.CENTER);
                filterPanel.add(listLabel, BorderLayout.SOUTH);

                listPanel.add(filterPanel, BorderLayout.NORTH);
            }
            listPanel.add(listPane, BorderLayout.SOUTH);
            panel1.add(listPanel, BorderLayout.WEST);

            //======== dataPane ========
            {
                dataPane.setPreferredSize(new Dimension(370, 400));
                dataPane.setRequestFocusEnabled(false);
                dataPane.setBorder(null);


                //======== dataPanel ========
                {
                    dataPanel.setBackground(bgColor);
                    dataPanel.setLayout(new BorderLayout());
                    dataPanel.setBorder(null);


                    //---- titleLabel ----
                    titleLabel.setBackground(bgColor);
                    titleLabel.setFont(new Font("Sanserif",Font.ITALIC,26));
                    titleLabel.setForeground(fgColor);
                    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    titleLabel.setMaximumSize(new Dimension(59, 50));
                    titleLabel.setText("Recipe Title");
                    titleLabel.setBorder(null);
                    dataPanel.add(titleLabel, BorderLayout.NORTH);

                    //---- directionsTextArea ----
                    directionsTextArea.setBackground(bgColor);
                    directionsTextArea.setFocusable(false);
                    directionsTextArea.setFont(directionsTextArea.getFont().deriveFont(Font.BOLD));
                    directionsTextArea.setForeground(fgColor);
                    directionsTextArea.setLineWrap(true);
                    directionsTextArea.setPreferredSize(new Dimension(370, 200));
                    directionsTextArea.setText("Directions:");
                    directionsTextArea.setBorder(null);
                    dataPanel.add(directionsTextArea, BorderLayout.SOUTH);

                    //======== splitPane1 ========
                    {
                        splitPane1.setContinuousLayout(true);
                        splitPane1.setDividerSize(1);
                        splitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
                        splitPane1.setPreferredSize(new Dimension(370, 50));
                        splitPane1.setBorder(null);


                        //---- ingredientsTextArea ----
                        ingredientsTextArea.setBackground(bgColor);
                        ingredientsTextArea.setFont(ingredientsTextArea.getFont().deriveFont(Font.BOLD));
                        ingredientsTextArea.setForeground(fgColor);
                        ingredientsTextArea.setPreferredSize(new Dimension(370, 50));
                        ingredientsTextArea.setText("Ingredients:");
                        ingredientsTextArea.setBorder(null);
                        splitPane1.setBottomComponent(ingredientsTextArea);

                        //---- tagsTextArea ----
                        tagsTextArea.setBackground(bgColor);
                        tagsTextArea.setFont(tagsTextArea.getFont().deriveFont(Font.BOLD));
                        tagsTextArea.setForeground(fgColor);
                        tagsTextArea.setText("Tags: ");
                        tagsTextArea.setBorder(null);
                        splitPane1.setTopComponent(tagsTextArea);

                    }
                    dataPanel.add(splitPane1, BorderLayout.CENTER);
                }
                dataPane.setViewportView(dataPanel);
            }
            panel1.add(dataPane, BorderLayout.EAST);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Adam Clemons
    private DefaultListModel<String> listModel;
    private JPanel panel1;
    private JPanel toolPanel;
    private JPanel listPanel;
    private JLabel listLabel;
    private JLabel filterLabel;
    private JComboBox filterBox;
    private JPanel filterPanel;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JTextField searchField;
    private JScrollPane listPane;
    private JList<String> recipeListBox;
    private JScrollPane dataPane;
    private JPanel dataPanel;
    private JLabel titleLabel;
    private JTextArea directionsTextArea;
    private JTextArea ingredientsTextArea;
    private JTextArea tagsTextArea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
