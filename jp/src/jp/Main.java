package jp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame{
   public Main() {
      setTitle("TermProject 18114875");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(500,250);
      
      Container c=getContentPane();
      c.setLayout(new FlowLayout());
      
      JButton btnSorting1=new JButton("��ȯ ����");
      btnSorting1.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            // ȭ�� ����
            new ExchangeSorting();
         }
      });
      c.add(btnSorting1);
      

      JButton btnSorting2=new JButton("���� ����");
      btnSorting2.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            // ȭ�� ����
            new SelectionSorting();
         }
      });
      c.add(btnSorting2);

      JButton btnSorting3=new JButton("���� ����");
      btnSorting3.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            // ȭ�� ����
            new BubbleSorting();
         }
      });
      c.add(btnSorting3);
      
      setVisible(true);
   }
   
   class ExchangeSorting extends JFrame{
      private JButton[] data=new JButton[10];
      private JPanel panel_data=new JPanel();
      private JPanel panel_button=new JPanel();
      
      public ExchangeSorting(){
         setTitle("Exchange Sorting");
         setSize(750,100);
         Container c=getContentPane();
         c.setLayout(new FlowLayout());
         
         for(int i=0;i<data.length;i++) {
            int x=(int)(Math.random()*50);
            data[i]=new JButton(Integer.toString(x));
            data[i].setBackground(Color.white);
            data[i].setPreferredSize(new Dimension(50,50));
            panel_data.add(data[i]);
         }
         
         JButton btnStart=new JButton("START!!");
         
         btnStart.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
               if(e.getButton()==MouseEvent.BUTTON1) {
                  for(int i=0;i<data.length-1;i++) {
                     data[i].setBackground(Color.yellow);
                     panel_data.update(panel_data.getGraphics());
                     for(int j=i+1;j<data.length;j++) {
                        data[j].setBackground(Color.blue);
                        panel_data.update(panel_data.getGraphics());
                        wait_1s(System.currentTimeMillis());
                        if(Integer.parseInt(data[i].getText())>Integer.parseInt(data[j].getText())) {
                           int temp=Integer.parseInt(data[i].getText());
                           data[i].setText(Integer.toString(Integer.parseInt(data[j].getText())));
                           data[j].setText(Integer.toString(temp));
                           data[i].setBackground(Color.blue);
                           data[j].setBackground(Color.yellow);
                           panel_data.update(panel_data.getGraphics());

                           wait_1s(System.currentTimeMillis());
                           data[i].setBackground(Color.yellow);
                           panel_data.update(panel_data.getGraphics());
                        }
                        data[j].setBackground(Color.white);
                        panel_data.update(panel_data.getGraphics());
                     }
                     data[i].setBackground(Color.white);
                     panel_data.update(panel_data.getGraphics());
                  }
               }
            }
         });
         panel_button.add(btnStart);
         
         c.add(panel_data);
         c.add(panel_button);
         
         setVisible(true);
      }
   }
      
   class SelectionSorting extends JFrame{
      private JButton[] data=new JButton[10];
      private JPanel panel_data=new JPanel();
      private JPanel panel_button=new JPanel();
      
      public SelectionSorting(){
         setTitle("Selection Sorting");
         setSize(750,100);
         Container c=getContentPane();
         c.setLayout(new FlowLayout());
         
         for(int i=0;i<data.length;i++) {
            int x=(int)(Math.random()*50);
            data[i]=new JButton(Integer.toString(x));
            data[i].setBackground(Color.white);
            data[i].setPreferredSize(new Dimension(50,50));
            panel_data.add(data[i]);
         }
         
         JButton btnStart=new JButton("START!!");
         
         btnStart.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
               if(e.getButton()==MouseEvent.BUTTON1) {
                  for(int i=0;i<data.length-1;i++) {
                     data[i].setBackground(Color.yellow);
                     int indexMin=i;
                     for(int j=i+1;j<data.length;j++) {
                        data[j].setBackground(Color.blue);
                        panel_data.update(panel_data.getGraphics());
                        wait_1s(System.currentTimeMillis());
                        if(Integer.parseInt(data[indexMin].getText())>Integer.parseInt(data[j].getText())) {
                           if(indexMin!=i) data[indexMin].setBackground(Color.white);
                           data[j].setBackground(Color.blue);
                           indexMin=j;
                           panel_data.update(panel_data.getGraphics());
                           wait_1s(System.currentTimeMillis());
                           continue;
                        }
                        data[j].setBackground(Color.white);
                        panel_data.update(panel_data.getGraphics());
                        wait_1s(System.currentTimeMillis());
                     }
                     int temp=Integer.parseInt(data[indexMin].getText());
                     data[indexMin].setText(Integer.toString(Integer.parseInt(data[i].getText())));
                     data[i].setText(Integer.toString(temp));
                     data[indexMin].setBackground(Color.white);
                     data[i].setBackground(Color.white);
                     panel_data.update(panel_data.getGraphics());
                     wait_1s(System.currentTimeMillis());
                  }
               }
            }
         });
         
         panel_button.add(btnStart);
         
         c.add(panel_data);
         c.add(panel_button);
         
         setVisible(true);
      }
   }
   class BubbleSorting extends JFrame{
      private JButton[] data=new JButton[10];
      private JPanel panel_data=new JPanel();
      private JPanel panel_button=new JPanel();
      
      public BubbleSorting(){
         setTitle("Bubble Sorting");
         setSize(750,100);
         Container c=getContentPane();
         c.setLayout(new FlowLayout());
         
         for(int i=0;i<data.length;i++) {
            int x=(int)(Math.random()*50);
            data[i]=new JButton(Integer.toString(x));
            data[i].setBackground(Color.white);
            data[i].setPreferredSize(new Dimension(50,50));
            panel_data.add(data[i]);
         }
         
         JButton btnStart=new JButton("START!!");
         
         btnStart.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
               if(e.getButton()==MouseEvent.BUTTON1) {
                  for(int i=0;i<data.length-1;i++) {
                     for(int j=0;j<data.length-(i+1);j++) {
                        data[j].setBackground(Color.yellow);
                        data[j+1].setBackground(Color.blue);
                        panel_data.update(panel_data.getGraphics());
                        wait_1s(System.currentTimeMillis());
                        if(Integer.parseInt(data[j].getText())>Integer.parseInt(data[j+1].getText())) {
                           int temp=Integer.parseInt(data[j].getText());
                           data[j].setText(Integer.toString(Integer.parseInt(data[j+1].getText())));
                           data[j+1].setText(Integer.toString(temp));
                           data[j].setBackground(Color.blue);
                           data[j+1].setBackground(Color.yellow);
                           panel_data.update(panel_data.getGraphics());
                           wait_1s(System.currentTimeMillis());
                        }
                        data[j].setBackground(Color.white);
                        data[j+1].setBackground(Color.white);
                        panel_data.update(panel_data.getGraphics());
                        wait_1s(System.currentTimeMillis());
                     }
                  }
               }
            }
         });
         panel_button.add(btnStart);
         
         c.add(panel_data);
         c.add(panel_button);
         
         setVisible(true);
      }
   }
   
   public void wait_1s(long currentTime) {
      while(true) {
         long finishTime=System.currentTimeMillis();
         if(finishTime>=currentTime+500) break;
      }
   }
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new Main();
   }

}