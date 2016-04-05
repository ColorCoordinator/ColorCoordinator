import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


class Surface extends JPanel {
    
    private void doDrawing(Graphics g) {

    	ArrayList<HSLColor> colors = new ArrayList<HSLColor>();
    	
    	colors.add(new HSLColor(206,98,36));
		colors.add(new HSLColor(219,95,17));
		colors.add(new HSLColor(216,42,68));
		colors.add(new HSLColor(15,26,51));
		colors.add(new HSLColor(15, 40, 22));
		colors.add(new HSLColor(23,64,51));
		colors.add(new HSLColor(37,53,26));
		colors.add(new HSLColor(11,25,50));
		colors.add(new HSLColor(26,60,50));
    	
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(HSLColor.toRGB(200, 74, 79));

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        int y = 20;
        for (HSLColor color: colors){
        	g2d.setPaint(HSLColor.toRGB(color.getHSL()));
        	g2d.fillRect(30, y, 40, 40);
        	y += 30;
        }
        
        /*
        g2d.fillRect(30, 20, 50, 50);
        g2d.fillRect(120, 20, 50, 50);
        g2d.setPaint(HSLColor.toRGB(33, 100, 47));
        g2d.fillRect(30,100,50,50);
        g2d.fillRect(120,100,50,50);
        */
        Clothing clothes = new Clothing();
        y = 20;
        for (Float hue: clothes.primaryHues){
        	g2d.setPaint(HSLColor.toRGB(hue, 60, 50));
        	g2d.fillRect(80, y, 40, 40);
        	y += 30;
        }
        g2d.setColor(Color.black);
        g2d.drawString(clothes.getScheme().getName(), 100, 150);
   } 

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        doDrawing(g);
    }    
}

public class ColorTester extends JFrame {

    public ColorTester() {

        initUI();
    }
    
    private void initUI() {
        
        add(new Surface());
        
        setTitle("Basic shapes");
        setSize(350, 250);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                ColorTester ex = new ColorTester();
                ex.setVisible(true);
            }
        });
    }
}