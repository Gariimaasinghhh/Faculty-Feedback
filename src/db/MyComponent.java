/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
 *
 * @author Analyze
 */
public class MyComponent extends JComponent { 
    int a,b,c,d;
  public  MyComponent(int a1,int a2, int a3, int a4) {
       a=a1;
       b=a2;
       c=a3;
       d=a4;
   }
   public void paint(Graphics g) {
   Slice[] slices = { new Slice(a, Color.cyan), 
   new Slice(b, Color.green),
   new Slice(c, Color.yellow), new Slice(d, Color.red) };
  
       drawPie((Graphics2D) g, getBounds(), slices);
   }
   void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
      double total = 0.0D;
      for (int i = 0; i < slices.length; i++)
      {
         total += slices[i].value;
      }
      double curValue = 0.0D;
      int startAngle = 0;
      for (int i = 0; i < slices.length; i++)
      {
         startAngle = (int) (curValue * 360 / total);
         int arcAngle = (int) (slices[i].value * 360 / total);
         g.setColor(slices[i].color);
         g.fillArc(area.x, area.y, area.width, area.height, 
         startAngle, arcAngle);
         curValue += slices[i].value;
      }
   }
}