package gui.buttons;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.MazeApp;
import gui.MazeAppModel;

public class NewMazeButton extends JButton{
    
    private final MazeApp mazeApp;
    private final JTextField textHeight = new JTextField();
    private final JTextField textWidth = new JTextField();
    private final JPanel inputPanel = new JPanel();

    public NewMazeButton(MazeApp mazeApp) {
        super("New Maze");
        this.mazeApp = mazeApp;
        setBackground(Color.YELLOW);

        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        inputPanel.add(new JLabel("Enter height :"));
        inputPanel.add(textHeight);
        inputPanel.add(new JLabel("Enter width :"));
        inputPanel.add(textWidth);

        addActionListener(e -> {
            MazeAppModel mazeAppModel = this.mazeApp.getMazeAppModel();
            textHeight.setText(Integer.toString(mazeAppModel.getHeight()));
            textWidth.setText(Integer.toString(mazeAppModel.getWidth()));

            int result = JOptionPane.showConfirmDialog(null,inputPanel,"Set Dimensions",JOptionPane.OK_CANCEL_OPTION);
            if(result==JOptionPane.OK_OPTION){
                final int newHeight = Integer.parseInt(textHeight.getText());
                final int newWidth = Integer.parseInt(textWidth.getText());
                mazeAppModel.newMaze(newHeight, newWidth);
            }
        });

    }

}
