import javax.swing.*;
import java.awt.*;
public class GameController extends JFrame{
   Container cp;
   public GameController(int b){
      setting();
      generate q= new generate(b);
      cp.add(q,BorderLayout.CENTER);   
      cp.add(q);   
   }
   private void setting(){
      cp=this.getContentPane();
      cp.setLayout(new BorderLayout());     ///ตั้งเป็น null กับ flow ไม่ได้
      this.setSize(1200,800);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setResizable(false);
      this.setVisible(true);
   }
}