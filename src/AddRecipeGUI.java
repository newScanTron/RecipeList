import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddRecipeGUI extends JDialog implements ActionListener {
    public AddRecipeGUI(JFrame parent, String title, String message) {
        super(parent, title, true);
        if (parent != null) {
            Dimension parentSize = parent.getSize();
            Point p = parent.getLocation();
            setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
        }






// BUTTON PANE
        JPanel buttonPane = new JPanel();

        JButton addButton = new JButton("Add");
        buttonPane.add(addButton);
        addButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit w/ Add
                System.out.println("Dialog: 'Add' Exit");
                dispose();
            }
        });
        JButton cancelButton = new JButton("Cancel");
        buttonPane.add(cancelButton);
        cancelButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit w/ Cancel
                System.out.println("Dialog: 'Cancel' Exit");
                dispose();
            }
        });

        getContentPane().add(buttonPane, BorderLayout.SOUTH);
////
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        System.out.println("actionPerformed");
        dispose();
    }
    public static void main(String[] a) {
        AddRecipeGUI dlg = new AddRecipeGUI(new JFrame(), "title", "message");
    }
}