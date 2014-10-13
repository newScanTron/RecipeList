import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * Created by JFormDesigner on Wed Oct 08 16:47:17 MDT 2014
 */



/**
 * @author Adam Clemons
 */
public class AddRecipeGUI extends JPanel {

    Color bgColor = new Color(163, 144, 82);
    Color panelColor =  new Color(105, 93, 52);
    Color fgColor = new Color(0, 0, 0);
    Color listColor = new Color(191, 169, 96);

    AddRecipeGUI thisGUI = this;
    int edittingID = -1;


	public AddRecipeGUI() {

        setBackground(panelColor);
		initComponents();
		add(mainPanel);
	}

	public void createUIComponents() {
		// TODO: add custom component creation code here
	}

	public void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Adam Clemons
		createUIComponents();

		mainPanel = new JPanel();
		nameLabel = new JLabel();
		nameField = new JTextField();
		tagsLabel = new JLabel();
		amountLabel = new JLabel();
		tagField = new JTextField();
		unitLabel = new JLabel();
		ingLabel = new JLabel();
		ingNameLabel = new JLabel();
		ingAmount1 = new JTextField();
		ingUnit1 = new JTextField();
		ingName1 = new JTextField();
		ingName2 = new JTextField();
		ingUnit2 = new JTextField();
		ingAmount2 = new JTextField();
		ingAmount3 = new JTextField();
		ingUnit3 = new JTextField();
		ingName3 = new JTextField();
		ingAmount4 = new JTextField();
		ingUnit4 = new JTextField();
		ingName4 = new JTextField();
		ingAmount5 = new JTextField();
		ingUnit5 = new JTextField();
		ingName5 = new JTextField();
		ingAmount6 = new JTextField();
		ingUnit6 = new JTextField();
		ingName6 = new JTextField();
		ingAmount7 = new JTextField();
		ingUnit7 = new JTextField();
		ingName7 = new JTextField();
		ingAmount8 = new JTextField();
		ingUnit8 = new JTextField();
		ingName8 = new JTextField();
		ingAmount9 = new JTextField();
		ingUnit9 = new JTextField();
		ingName9 = new JTextField();
		ingAmount10 = new JTextField();
		ingUnit10 = new JTextField();
		ingName10 = new JTextField();
		directionsLabel = new JLabel();
		directionsPane = new JScrollPane();
		directionsArea = new JTextArea();
		submit = new JButton();
        submit.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Controller.gatherRecipe(thisGUI);
                Controller.closeAddWindow(edittingID);

            }
        });



		//======== mainPanel ========
		{
			mainPanel.setAutoscrolls(false);
			mainPanel.setBackground(bgColor);
			mainPanel.setInheritsPopupMenu(true);
			mainPanel.setPreferredSize(new Dimension(405, 650));

			// JFormDesigner evaluation mark
			mainPanel.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), mainPanel.getBorder())); mainPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			mainPanel.setLayout(new FormLayout(
				"130px, left:4dlu, left:130px, left:4dlu, 130px",
				"[4px,default], top:4dlu, [4px,default], top:12dlu, 11*([4px,default], top:4dlu), [4px,default], top:17dlu, top:4dlu, 83px, [4px,default], top:4dlu, 28px"));

			//---- nameLabel ----
			nameLabel.setAutoscrolls(false);
			nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD, 20f));
			nameLabel.setForeground(fgColor);
			nameLabel.setText("Name:");
			mainPanel.add(nameLabel, CC.xy(1, 1));

			//---- nameField ----
			nameField.setPreferredSize(new Dimension(100, 22));
			nameField.setText("");
			mainPanel.add(nameField, CC.xywh(3, 1, 3, 1, CC.FILL, CC.DEFAULT));

			//---- tagsLabel ----
			tagsLabel.setDoubleBuffered(true);
			tagsLabel.setFont(tagsLabel.getFont().deriveFont(Font.BOLD, 20f));
			tagsLabel.setForeground(fgColor);
			tagsLabel.setText("Tags:");
			mainPanel.add(tagsLabel, CC.xy(1, 3));

			//---- amountLabel ----
			amountLabel.setFocusTraversalPolicyProvider(true);
			amountLabel.setFont(amountLabel.getFont().deriveFont(Font.BOLD, 16f));
			amountLabel.setForeground(fgColor);
			amountLabel.setText("Amount");
			mainPanel.add(amountLabel, CC.xy(1, 7, CC.CENTER, CC.DEFAULT));

			//---- tagField ----
			tagField.setPreferredSize(new Dimension(100, 22));
			mainPanel.add(tagField, CC.xywh(3, 3, 3, 1, CC.FILL, CC.DEFAULT));

			//---- unitLabel ----
			unitLabel.setBackground(bgColor);
			unitLabel.setFont(unitLabel.getFont().deriveFont(Font.BOLD, 16f));
			unitLabel.setForeground(fgColor);
			unitLabel.setText("Unit");
			mainPanel.add(unitLabel, CC.xy(3, 7, CC.CENTER, CC.DEFAULT));

			//---- ingLabel ----
			ingLabel.setBackground(bgColor);
			ingLabel.setFont(ingLabel.getFont().deriveFont(Font.BOLD, 20f));
			ingLabel.setForeground(fgColor);
			ingLabel.setText("Ingredients");
			mainPanel.add(ingLabel, CC.xy(3, 5, CC.CENTER, CC.DEFAULT));

			//---- ingNameLabel ----
			ingNameLabel.setBackground(bgColor);
			ingNameLabel.setFont(ingNameLabel.getFont().deriveFont(Font.BOLD, 16f));
			ingNameLabel.setForeground(fgColor);
			ingNameLabel.setText("Name");
			mainPanel.add(ingNameLabel, CC.xy(5, 7, CC.CENTER, CC.DEFAULT));
			mainPanel.add(ingAmount1, CC.xy(1, 9, CC.FILL, CC.DEFAULT));

			//---- ingUnit1 ----
			ingUnit1.setText("");
			mainPanel.add(ingUnit1, CC.xy(3, 9, CC.FILL, CC.DEFAULT));

			//---- ingName1 ----
			ingName1.setText("");
			mainPanel.add(ingName1, CC.xy(5, 9, CC.FILL, CC.DEFAULT));
			mainPanel.add(ingName2, CC.xy(5, 11, CC.FILL, CC.DEFAULT));
			mainPanel.add(ingUnit2, CC.xy(3, 11, CC.FILL, CC.DEFAULT));
			mainPanel.add(ingAmount2, CC.xy(1, 11, CC.FILL, CC.DEFAULT));
			mainPanel.add(ingAmount3, CC.xy(1, 13, CC.FILL, CC.DEFAULT));

			//---- ingUnit3 ----
			ingUnit3.setText("");
			mainPanel.add(ingUnit3, CC.xy(3, 13, CC.FILL, CC.DEFAULT));
			mainPanel.add(ingName3, CC.xy(5, 13, CC.FILL, CC.DEFAULT));

			//---- ingAmount4 ----
			ingAmount4.setText("");
			mainPanel.add(ingAmount4, CC.xy(1, 15, CC.FILL, CC.DEFAULT));

			//---- ingUnit4 ----
			ingUnit4.setText("");
			mainPanel.add(ingUnit4, CC.xy(3, 15, CC.FILL, CC.DEFAULT));
			mainPanel.add(ingName4, CC.xy(5, 15, CC.FILL, CC.DEFAULT));

			//---- ingAmount5 ----
			ingAmount5.setText("");
			mainPanel.add(ingAmount5, CC.xy(1, 17, CC.FILL, CC.DEFAULT));

			//---- ingUnit5 ----
			ingUnit5.setText("");
			mainPanel.add(ingUnit5, CC.xy(3, 17, CC.FILL, CC.DEFAULT));

			//---- ingName5 ----
			ingName5.setText("");
			mainPanel.add(ingName5, CC.xy(5, 17, CC.FILL, CC.DEFAULT));

			//---- ingAmount6 ----
			ingAmount6.setText("");
			mainPanel.add(ingAmount6, CC.xy(1, 19, CC.FILL, CC.DEFAULT));

			//---- ingUnit6 ----
			ingUnit6.setText("");
			mainPanel.add(ingUnit6, CC.xy(3, 19, CC.FILL, CC.DEFAULT));

			//---- ingName6 ----
			ingName6.setText("");
			mainPanel.add(ingName6, CC.xy(5, 19, CC.FILL, CC.DEFAULT));

			//---- ingAmount7 ----
			ingAmount7.setText("");
			mainPanel.add(ingAmount7, CC.xy(1, 21, CC.FILL, CC.DEFAULT));

			//---- ingUnit7 ----
			ingUnit7.setText("");
			mainPanel.add(ingUnit7, CC.xy(3, 21, CC.FILL, CC.DEFAULT));

			//---- ingName7 ----
			ingName7.setText("");
			mainPanel.add(ingName7, CC.xy(5, 21, CC.FILL, CC.DEFAULT));

			//---- ingAmount8 ----
			ingAmount8.setText("");
			mainPanel.add(ingAmount8, CC.xy(1, 23, CC.FILL, CC.DEFAULT));
			mainPanel.add(ingUnit8, CC.xy(3, 23, CC.FILL, CC.DEFAULT));

			//---- ingName8 ----
			ingName8.setText("");
			mainPanel.add(ingName8, CC.xy(5, 23, CC.FILL, CC.DEFAULT));

			//---- ingAmount9 ----
			ingAmount9.setText("");
			mainPanel.add(ingAmount9, CC.xy(1, 25, CC.FILL, CC.DEFAULT));
			mainPanel.add(ingUnit9, CC.xy(3, 25, CC.FILL, CC.DEFAULT));
			mainPanel.add(ingName9, CC.xy(5, 25, CC.FILL, CC.DEFAULT));

			//---- ingAmount10 ----
			ingAmount10.setText("");
			mainPanel.add(ingAmount10, CC.xy(1, 27, CC.FILL, CC.DEFAULT));

			//---- ingUnit10 ----
			ingUnit10.setText("");
			mainPanel.add(ingUnit10, CC.xy(3, 27, CC.FILL, CC.DEFAULT));
			mainPanel.add(ingName10, CC.xy(5, 27, CC.FILL, CC.DEFAULT));

			//---- directionsLabel ----
			directionsLabel.setBackground(bgColor);
			directionsLabel.setFont(directionsLabel.getFont().deriveFont(Font.BOLD, 20f));
			directionsLabel.setForeground(fgColor);
			directionsLabel.setText("Directions");
			mainPanel.add(directionsLabel, CC.xy(3, 28, CC.CENTER, CC.DEFAULT));

			//======== directionsPane ========
			{

				//---- directionsArea ----
				directionsArea.setText("");
				directionsArea.setLineWrap(true);
				directionsPane.setViewportView(directionsArea);
			}
			mainPanel.add(directionsPane, CC.xywh(1, 29, 5, 3, CC.FILL, CC.FILL));

			//---- submit ----
			submit.setActionCommand("submit");
			submit.setAutoscrolls(false);
			submit.setInheritsPopupMenu(true);
			submit.setSelected(true);
			submit.setText("Submit");
			mainPanel.add(submit, CC.xy(3, 33, CC.FILL, CC.DEFAULT));
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Adam Clemons

	public JPanel mainPanel;
	public JLabel nameLabel;
	public JTextField nameField;
	public JLabel tagsLabel;
	public JLabel amountLabel;
	public JTextField tagField;
	public JLabel unitLabel;
	public JLabel ingLabel;
	public JLabel ingNameLabel;
	public JTextField ingAmount1;
	public JTextField ingUnit1;
	public JTextField ingName1;
	public JTextField ingName2;
	public JTextField ingUnit2;
	public JTextField ingAmount2;
	public JTextField ingAmount3;
	public JTextField ingUnit3;
	public JTextField ingName3;
	public JTextField ingAmount4;
	public JTextField ingUnit4;
	public JTextField ingName4;
	public JTextField ingAmount5;
	public JTextField ingUnit5;
	public JTextField ingName5;
	public JTextField ingAmount6;
	public JTextField ingUnit6;
	public JTextField ingName6;
	public JTextField ingAmount7;
	public JTextField ingUnit7;
	public JTextField ingName7;
	public JTextField ingAmount8;
	public JTextField ingUnit8;
	public JTextField ingName8;
	public JTextField ingAmount9;
	public JTextField ingUnit9;
	public JTextField ingName9;
	public JTextField ingAmount10;
	public JTextField ingUnit10;
	public JTextField ingName10;
	public JLabel directionsLabel;
	public JScrollPane directionsPane;
	public JTextArea directionsArea;
	public JButton submit;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
