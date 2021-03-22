package Laborator6;
import javax.swing.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.lang.Object;
import java.awt.Dimension;

public class DrawingPanel extends JPanel 
{
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;  
    Graphics2D graphics;  
    public DrawingPanel(MainFrame frame) 
    {
        this.frame = frame; 
        createOffscreenImage(); 
        init();
    }
    private void createOffscreenImage() 
    {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);  
        graphics.fillRect(0, 0, W, H);
    }
    private void init() 
    {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() 
        {
            public void mousePressed(MouseEvent e) 
            {
                drawShape(e.getX(), e.getY()); repaint();
            }
        });
    }
    private void drawShape(int x, int y) 
    {
        Random rand = new Random();
        int radius = rand.nextInt(10);
        int sides = (int)frame.configPanel.sidesField.getValue();
        Color color;
        if("RANDOM".equals(frame.configPanel.colorCombo.getSelectedItem()))
        {
            color = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)); 
        }
        else
        {
            color = Color.BLACK;
        }
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    public void update(Graphics g) { }
    protected void paintComponent(Graphics g) 
    {
        g.drawImage(image, 0, 0, this);
    }
}
