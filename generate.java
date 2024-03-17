import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class generate extends JPanel implements ActionListener,MouseListener{
    private Font font=new Font("Arial", Font.BOLD, 20);
    int x=500,y=300,a=100;
    int life=5,count=0,best;
    Random random = new Random();
    Timer tx;
    public generate(int b){
        tx=new Timer(800,this);  
        addMouseListener(this);
        best=b;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(font);
        g.fillOval(x, y, a,a);
        g.drawString("score : "+count, 30,30);
        g.drawString("best : "+best, 1000,30);
        g.drawString("life : "+life, 500,30);
        
    
    }
    public void actionPerformed(ActionEvent e) {  
     if(life==0){
          tx.stop();
          this.setVisible(false);
          new restart(count,best);
     } 
        x = random.nextInt(1000)+20;
        y = random.nextInt(600)+20;
        a = random.nextInt(150)+50;  
        repaint();
    }
  
    public void mousePressed(MouseEvent e) {
        int mousex=e.getX();  // ใช้ e.get เพื่อที่จะเช็คว่ากดที่ตำแหน่งไหน
        int mousey=e.getY();
        if(mousex>=x&&mousex<=x+a&&mousey>=y&&mousey<=y+a){
            tx.start(); 
            count++;
        }
        else{  //ถ้ากดพลาด
            life--;  
            if(life==0){
                tx.stop();
                this.setVisible(false);
                new restart(count,best);
            } 
        }
    }

    public void mouseClicked(MouseEvent e) {
       
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }
  
    public void mouseExited(MouseEvent e) {

    }
}

// ต้องทำให้ทันสุ่มตำแหน่งกับขนาดต่อ + พยายามให้มันคลิ๊กได้(วงกลมที่เจนมาใหม่) + ระบบนับแต้ม + เขียนคะแนนสูงสุด
