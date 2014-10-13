import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class RecipeGUI extends JPanel{
    //making a instance of the controller class to do stuff
    JFrame parent;



    public RecipeGUI() {
        initComponents();
        add(panel1);
        recipeListBox.setSelectedIndex(0);
        recipeListBox.getListSelectionListeners()[0].valueChanged(new ListSelectionEvent(this,0,0,true));
        recipeListBox.requestFocus();
        // Try unselecting the selectionBox by default
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

                /**
                while(listModel.getSize() > 0) {listModel.removeElementAt(0);}
                controller.currentRecipes.add(addedRecipe);
                System.out.println(controller.currentRecipes);
                listModel.clear();
                recipeListBox.updateUI();
                controller.addRecipe(addedRecipe);
                 **/
            }
        });
        editButton = new JButton();
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("Editing Recipe...");
                int editIndex = recipeListBox.getSelectedIndex();
                String editName = recipeListBox.getSelectedValue();
                Recipe oldRecipe = Controller.currentRecipes.findByName(editName);
                Controller.openAddWindow(oldRecipe,true);
            }
        });
        deleteButton = new JButton();
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String deleteName = recipeListBox.getSelectedValue();
                Recipe delRecipe = Controller.currentRecipes.findByName(deleteName);
                Controller.deleteRecipeByID(delRecipe.id);

                //listModel.removeElementAt(deleteIndex);     // Removes element from list
                //Controller.deleteRecipe(Controller.currentRecipes.findByName(deleteName).id);  // Deletes recipe from database
                //Controller.currentRecipes.remove(deleteIndex);

                listModel.clear();
                recipeListBox.setSelectedIndex(0);
                recipeListBox.getListSelectionListeners()[0].valueChanged(new ListSelectionEvent(this, 0, 0, true));
                recipeListBox.updateUI();  // Refreshes UI

                System.out.println("Deleting: " + deleteName);

            }
        });
        searchField = new JTextField();
        searchField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                searchField.setText("");
                searchField.setFont(new Font("",Font.PLAIN,12));
            }

            public void focusLost(FocusEvent e) {
                searchField.setText("Search for a Recipe by name, tags, or ingredients");
                searchField.setFont(new Font("Sanserif",Font.ITALIC,12));
            }
        });
        searchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller.searchRecipe(searchField.getText());
                listModel.clear();
                recipeListBox.updateUI();


            }
        });
        listPane = new JScrollPane();
        recipeListBox = new JList<String>();
        recipeListBox.setForeground(Color.WHITE);
        recipeListBox.setBackground(Color.BLACK);

        recipeListBox.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    String name = recipeListBox.getSelectedValue();
                    Recipe selected = Controller.currentRecipes.findByName(name);
                    System.out.println("Selected: " + selected.name);

                    directionsTextArea.setText("");
                    ingredientsTextArea.setText("");
                    tagsTextArea.setText("");

                    titleLabel.setText(selected.name);
                    for (int i = 0; i < selected.directions.length; i++) {
                        directionsTextArea.append(selected.directions[i] + "\n");
                    }
                    for (int i = 0; i < selected.ingredients.length; i++) {
                        ingredientsTextArea.append(selected.ingredients[i].name + "\n");
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
                toolPanel.setBorder(new TitledBorder(BorderFactory.createEmptyBorder(), ""));
                toolPanel.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), 0, -1));

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
                searchField.setText("Search for a Recipe by name, tags, or ingredients");
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
                
              //---- selectionBox ----
                selectionBox = new JComboBox<String>(new String[]{"Option 1", "Option 2", "Option 3"});
    			selectionBox.setAutoscrolls(true);
    			selectionBox.setBackground(Color.white);
    			listPanel.add(selectionBox, BorderLayout.NORTH);
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
                    dataPanel.setBackground(Color.black);
                    dataPanel.setBorder(null);
                    dataPanel.setLayout(new BorderLayout());

                    //---- titleLabel ----
                    titleLabel.setBackground(Color.black);
                    titleLabel.setFont(titleLabel.getFont().deriveFont(26f));
                    titleLabel.setForeground(Color.white);
                    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    titleLabel.setMaximumSize(new Dimension(59, 50));
                    titleLabel.setText("Recipe Title");
                    titleLabel.setBorder(null);
                    dataPanel.add(titleLabel, BorderLayout.NORTH);

                    //---- directionsTextArea ----
                    directionsTextArea.setBackground(Color.black);
                    directionsTextArea.setFocusable(false);
                    directionsTextArea.setFont(directionsTextArea.getFont().deriveFont(Font.BOLD));
                    directionsTextArea.setForeground(Color.white);
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
                        ingredientsTextArea.setBackground(Color.black);
                        ingredientsTextArea.setFont(ingredientsTextArea.getFont().deriveFont(Font.BOLD));
                        ingredientsTextArea.setForeground(Color.white);
                        ingredientsTextArea.setPreferredSize(new Dimension(370, 50));
                        ingredientsTextArea.setText("Ingredients:");
                        ingredientsTextArea.setBorder(null);
                        splitPane1.setBottomComponent(ingredientsTextArea);

                        //---- tagsTextArea ----
                        tagsTextArea.setBackground(Color.black);
                        tagsTextArea.setFont(tagsTextArea.getFont().deriveFont(Font.BOLD));
                        tagsTextArea.setForeground(Color.white);
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
    private JComboBox selectionBox;
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
