import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class restart extends JFrame implements ActionListener{
    Container cp;
    JLabel over,last_score;
    JButton regame;
    int best_score;
    private Font font=new Font("Arial", Font.BOLD, 40);
    public restart(int last, int best){
        setting();  
        try{
            File f=new File("bestscore.txt");
            FileWriter fw=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(fw);
            if(last>best){
                best=last;
                bw.write("best,"+best);
            }
            bw.close();fw.close();
        }catch(Exception e){}

        best_score=best;
        over= new JLabel("BEST SCORE : "+best);
        over.setFont(font);
        over.setBounds(150, 50, 500,100);
        cp.add(over);
        last_score= new JLabel("last Score : "+last);
        last_score.setFont(new Font("Arial", Font.BOLD, 20));
        last_score.setBounds(150, 150, 500,100);
        cp.add(last_score);
        regame = new JButton("Restart");
        regame.setFont(font);
        regame.setBounds(150, 300, 200, 80);
        regame.addActionListener(this);
        cp.add(regame);
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
        this.setVisible(false);
        new GameController(best_score);
    }
}