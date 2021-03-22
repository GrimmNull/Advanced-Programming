package Laborator6;
import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel 
{
    final MainFrame frame;
    JLabel sidesLabel;        
    JSpinner sidesField; 
    JComboBox colorCombo; 
    ConfigPanel(MainFrame frame) 
    {
        this.frame = frame;
        init();
    }
    private void init() {
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); 
        add(sidesLabel); 
        add(sidesField);
        String[] colors={"WHITE", "BLACK", "RED", "GREEN", "YELLOW", "BLUE", "PURPLE"};
        colorCombo= new JComboBox(colors);
        add(colorCombo);        
    }
}