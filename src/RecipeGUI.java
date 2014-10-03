import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.zip.DeflaterOutputStream;

public class RecipeGUI extends JPanel{
    //making a instance of the controller class to do stuff
    Controller controller = new Controller();
	public RecipeGUI() {
		initComponents();
		add(panel1);
	}
	private void createUIComponents() {
		// TODO: add custom component creation code here
	}

    private void updateList(String[] newList) {
        //recipeList

    }

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Adam Clemons
		createUIComponents();


        listModel = new DefaultListModel<String>() {
            Recipe[] recipes = {
                    new Recipe("test1"),
                    new Recipe("test2"),
                    new Recipe("test3"),
                    new Recipe("test4"),
            };
            String[] values = {
                    recipes[0].name,
                    recipes[1].name,
                    recipes[2].name,
                    recipes[3].name
            };

            public void updateNames() {
                values = new String[recipes.length];
                for(int i = 0; i < recipes.length; i++) {
                    values[i] = recipes[i].name;
                }
            }
            @Override
            public int getSize() { return values.length; }
            @Override
            public String getElementAt(int i) { return values[i]; }
            @Override
            public void removeElementAt(int i) {
                Recipe[] newRecipes = new Recipe[values.length-1];

                for(int a = 0; a < i; a++){
                    newRecipes[a] = recipes[a];
                }
                for(int a = i; a < recipes.length-1; a++){
                    newRecipes[a] = recipes[a+1];
                }
                recipes = newRecipes;
                updateNames();
            }
        }; // Logic for displaying the names in the list model
		panel1 = new JPanel();
		toolPanel = new JPanel();
		//button action,  a place for buttons to have actions listented to and them
        //call the appropriate controller class method
        addButton = new JButton();
		addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Adding Recipe...");
                Recipe newRecipe = new Recipe("New Recipe from window");

                //@TODO: Set up new window that allows user input to create new recipe

                controller.addRecipe(newRecipe);
            }
        });
        editButton = new JButton();
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Editing Recipe...");
                Recipe oldRecipe = new Recipe("This is the original recipe");
                Recipe newRecipe = new Recipe("This is the new recipe");

                //@TODO: Same as add recipe, but here we need to automatically populate the new window with data from original recipe

                controller.editRecipe(oldRecipe.name,newRecipe);
            }
        });
		deleteButton = new JButton();
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deleteName = recipeList.getSelectedValue();
                int deleteIndex = recipeList.getSelectedIndex();

                listModel.removeElementAt(deleteIndex);     // Removes element from list

                controller.delRecipe(controller.findByName(deleteName));  // Deletes recipe from database

                recipeList.updateUI();  // Refreshes UI

                System.out.println("dellete biatch: " + deleteName);
            }
        });
        searchField = new JTextField();
        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                searchField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                searchField.setText("Search for a Recipe by name, tags, or ingredients");
            }
        });
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] results = controller.searchRecipe(searchField.getText());



            }
        });
		listPane = new JScrollPane();
		recipeList = new JList<>();
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

			// JFormDesigner evaluation mark
			panel1.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

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
