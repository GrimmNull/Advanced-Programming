package Laborator6;
import javax.swing.*;
import java.awt.*;
public class MainFrame extends JFrame 
{
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    public MainFrame() 
    {
        super("My Drawing Application");
        init();
    }
    private void init() 
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new DrawingPanel(this);
        add(canvas, canvas.CENTER_ALIGNMENT);
        configPanel= new ConfigPanel(this);
        add(configPanel, canvas.RIGHT_ALIGNMENT);
        controlPanel= new ControlPanel(this);
        add(controlPanel, canvas.BOTTOM_ALIGNMENT);
        pack();        
    }
}