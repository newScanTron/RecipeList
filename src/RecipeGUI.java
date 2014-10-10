import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.zip.DeflaterOutputStream;



public class RecipeGUI extends JPanel{
    //making a instance of the controller class to do stuff
    JFrame parent;



    public RecipeGUI() {
        initComponents();
        add(panel1);
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
            @Override
            public void actionPerformed(ActionEvent e) {

                //System.out.println("Adding Recipe...");
                Controller.openAddWindow(new Recipe());

                //System.out.println(addedRecipe);

                /**
                while(listModel.getSize() > 0) {listModel.removeElementAt(0);}
                controller.currentRecipes.add(addedRecipe);
                System.out.println(controller.currentRecipes);
                listModel.clear();
                recipeList.updateUI();
                controller.addRecipe(addedRecipe);
                 **/
            }
        });
        editButton = new JButton();
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Editing Recipe...");
                Recipe oldRecipe = new Recipe(0,"This is the original recipe");
                Recipe newRecipe = new Recipe(0,"This is the new recipe");
                //TODO: Same as add recipe, but here we need to automatically populate the new window with data from original recipe
                Controller.editRecipe(oldRecipe.id, newRecipe);
            }
        });
        deleteButton = new JButton();
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String deleteName = recipeList.getSelectedValue();
                int deleteIndex = recipeList.getSelectedIndex();
                listModel.removeElementAt(deleteIndex);     // Removes element from list
                Controller.deleteRecipe(Controller.currentRecipes.findByName(deleteName).id);  // Deletes recipe from database
                Controller.currentRecipes.remove(deleteIndex);
                recipeList.setSelectedIndex(0);
                recipeList.getListSelectionListeners()[0].valueChanged(new ListSelectionEvent(this,deleteIndex,0,true));
                recipeList.updateUI();  // Refreshes UI
                System.out.println("Deleting: " + deleteName);

            }
        });
        searchField = new JTextField();
        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                searchField.setText("");
                searchField.setFont(new Font("",Font.PLAIN,12));
            }

            @Override
            public void focusLost(FocusEvent e) {
                searchField.setText("Search for a Recipe by name, tags, or ingredients");
                searchField.setFont(new Font("Sanserif",Font.ITALIC,12));
            }
        });
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.searchRecipe(searchField.getText());
                listModel.clear();
                recipeList.updateUI();


            }
        });
        listPane = new JScrollPane();
        recipeList = new JList<>();
        recipeList.setForeground(Color.WHITE);
        recipeList.setBackground(Color.BLACK);

        recipeList.addListSelectionListener( new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    String name = recipeList.getSelectedValue();
                    Recipe selected = Controller.currentRecipes.findByName(name);
                    System.out.println("Selected: " + selected.name);

                    directionsTextArea.setText("");
                    ingredientsTextArea.setText("");
                    tagsTextArea.setText("");

                    titleLabel.setText(selected.name);
                    for(int i = 0; i < selected.directions.length; i++) {
                        directionsTextArea.append(selected.directions[i] + "\n");
                    }
                    for(int i = 0; i < selected.ingredients.length; i++) {
                        ingredientsTextArea.append(selected.ingredients[i].name + "\n");
                    }
                    for(int i = 0; i < selected.tags.length; i++) {
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

                //---- addButton ----
                addButton.setBackground(Color.green);
                addButton.setText("+");
                addButton.setBorder(null);
                toolPanel.add(addButton, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, new Dimension(30, 30), null));

                //---- editButton ----
                editButton.setBackground(Color.yellow);
                editButton.setText("\u0394");
                editButton.setBorder(null);
                toolPanel.add(editButton, new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, new Dimension(30, 30), null));

                //---- deleteButton ----
                deleteButton.setBackground(new Color(255, 51, 51));
                deleteButton.setInheritsPopupMenu(false);
                deleteButton.setText("-");
                deleteButton.setVerifyInputWhenFocusTarget(false);
                deleteButton.setBorder(null);
                toolPanel.add(deleteButton, new GridConstraints(0, 2, 1, 1,
                        GridConstraints.ANCHOR_WEST, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, new Dimension(30, 30), null));

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

            //======== listPane ========
            {
                listPane.setDoubleBuffered(false);
                listPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                listPane.setMaximumSize(new Dimension(135, 400));
                listPane.setMinimumSize(new Dimension(130, 400));
                listPane.setPreferredSize(new Dimension(129, 400));
                listPane.setVisible(true);
                listPane.setBorder(null);

                //---- recipeList ----
                recipeList.setModel(listModel);
                recipeList.setBorder(null);
                listPane.setViewportView(recipeList);
            }
            panel1.add(listPane, BorderLayout.WEST);

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
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JTextField searchField;
    private JScrollPane listPane;
    private JList<String> recipeList;
    private JScrollPane dataPane;
    private JPanel dataPanel;
    private JLabel titleLabel;
    private JTextArea directionsTextArea;
    private JTextArea ingredientsTextArea;
    private JTextArea tagsTextArea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
