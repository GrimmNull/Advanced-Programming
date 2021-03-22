package Laborator6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ControlPanel extends JPanel 
{
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn= new JButton("Load");
    JButton resetBtn= new JButton("Reset");
    JButton exitBtn= new JButton("Exit");
    public ControlPanel(MainFrame frame) 
    {
        this.frame = frame; 
        init();
    }
    private void init() 
    {     
        setLayout(new GridLayout(1, 4));
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }   
    private void save(ActionEvent e) 
    {
        try 
        {
            ImageIO.write(frame.canvas.image, "PNG", new File("C:/Users/Panda/Desktop/test.png"));
        } catch (IOException ex) 
        { 
            System.err.println(ex); 
        }
    }
    private void load(ActionEvent e) 
    {
        try {
            frame.canvas.image = ImageIO.read(new File("C:/Users/Panda/Desktop/test.png"));
        } catch (IOException ex) {
            System.err.println(ex); 
        }
    }
    private void reset(ActionEvent e) 
    {
        frame.canvas.image= new BufferedImage(frame.WIDTH, frame.HEIGHT, BufferedImage.TYPE_INT_ARGB);
    }

    private void exit(ActionEvent e) 
    {
        System.exit(0);
    }

}