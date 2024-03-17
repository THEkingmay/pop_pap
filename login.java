import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class login extends JFrame implements ActionListener{
   Container cp;
   JButton go; 
   String[] s=new String[2];
   String a;
   private Font font=new Font("Arial", Font.BOLD, 40);
   public login(){
      setting();
      setframe();
   }
   private void setframe(){
      try{
         File f=new File("bestscore.txt");
         FileReader fr =new FileReader(f);
         BufferedReader br=new BufferedReader(fr);
         while((a=br.readLine())!=null){
            s=a.split(",");
         }
         JLabel bscore = new JLabel("Your best score is : "+s[1]);
         bscore.setBounds(120, 50, 500, 300);
         bscore.setFont(font);
         cp.add(bscore);
      }catch(Exception e){}
      go=new JButton("PLAY !");
      go.setFont(font);
      go.setBounds(230,350,200,100);
      go.addActionListener(this);
      cp.add(go);
   }
    private void setting(){
      cp=this.getContentPane();
      cp.setLayout(null);
      this.setSize(700,800);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setResizable(false);
      this.setVisible(true);
   }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==go){
            this.setVisible(false);
            new GameController((Integer.parseInt(s[1])));
        }
    }
}