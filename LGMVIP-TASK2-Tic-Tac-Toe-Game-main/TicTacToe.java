import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener {
//By Mohit Ramesh Kulkarni.
JFrame frame=new JFrame();
JPanel jPanel=new JPanel();
JPanel btPanel=new JPanel();
JLabel textfield=new JLabel();
JButton[] button=new JButton[9];
int chance_flag=0;
Random random=new Random();
boolean pl1_chance;

TicTacToe() {
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(800, 800);
frame.getContentPane().setBackground(new Color(50,50,50));
frame.setTitle("Tic Tac Toe Game");
frame.setLayout(new BorderLayout());
frame.setVisible(true);

textfield.setBackground(new Color(120,20,124));
textfield.setForeground(new Color(25,255,0));
textfield.setFont(new Font("Ink Free",Font.BOLD,75));
textfield.setHorizontalAlignment(JLabel.CENTER);
textfield.setText("Tic Tac Toe Game");
textfield.setOpaque(true);

jPanel.setLayout(new BorderLayout());
jPanel.setBounds(0, 0, 800, 100);

btPanel.setLayout(new GridLayout(3,3));
btPanel.setBackground(new Color(150,150,150));

for(int i=0;i<9;i++) {
	button[i]=new JButton();
	btPanel.add(button[i]);
	button[i].setFont(new Font("Ink Free",Font.BOLD,120));
	button[i].setFocusable(false);
	button[i].addActionListener(this);
}
jPanel.add(textfield);
frame.add(jPanel,BorderLayout.NORTH);
frame.add(btPanel);
startGame();
}
public void startGame() {
	try {
		textfield.setText("Loading....");
		Thread.sleep(4000);
		
	}catch(InterruptedException e) {
		e.printStackTrace();
	}
	int chance=random.nextInt(100);
	if(chance%2==0) {
		pl1_chance=true;
		textfield.setText("X TURN");
	}else {
		pl1_chance=false;
		textfield.setText("Y TURN");
	}
}
public void gameOver(String s) {
	chance_flag=0;
	Object[]option= {"Restart","Exit"};
	int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
	if(n==0) {
		frame.dispose();
		new TicTacToe();
	}else {
		frame.dispose();
	}
}
public void matchCheck() {
    if ((button[0].getText() == "X") && (button[1].getText() == "X") && (button[2].getText() == "X")) {
        xWins(0, 1, 2);
    }
    else if ((button[0].getText() == "X") && (button[4].getText() == "X") && (button[8].getText() == "X")) {
        xWins(0, 4, 8);
    }
    else if ((button[0].getText() == "X") && (button[3].getText() == "X") && (button[6].getText() == "X")) {
        xWins(0, 3, 6);
    }
    else if ((button[1].getText() == "X") && (button[4].getText() == "X") && (button[7].getText() == "X")) {
        xWins(1, 4, 7);
    }
    else if ((button[2].getText() == "X") && (button[4].getText() == "X") && (button[6].getText() == "X")) {
        xWins(2, 4, 6);
    }
    else if ((button[2].getText() == "X") && (button[5].getText() == "X") && (button[8].getText() == "X")) {
        xWins(2, 5, 8);
    }
   else if ((button[3].getText() == "X") && (button[4].getText() == "X") && (button[5].getText() == "X")) {
        xWins(3, 4, 5);
    }
   else if ((button[6].getText() == "X") && (button[7].getText() == "X") && (button[8].getText() == "X")) {
        xWins(6, 7, 8);
    }
  
    else if ((button[0].getText() == "O") && (button[1].getText() == "O") && (button[2].getText() == "O")) {
        yWins(0, 1, 2);
    }
    else if ((button[0].getText() == "O") && (button[3].getText() == "O") && (button[6].getText() == "O")) {
        yWins(0, 3, 6);
    }
    else if ((button[0].getText() == "O") && (button[4].getText() == "O") && (button[8].getText() == "O")) {
        yWins(0, 4, 8);
    }
    else if ((button[1].getText() == "O") && (button[4].getText() == "O") && (button[7].getText() == "O")) {
        yWins(1, 4, 7);
    }
    else if ((button[2].getText() == "O") && (button[4].getText() == "O") && (button[6].getText() == "O")) {
        yWins(2, 4, 6);
    }
    else if ((button[2].getText() == "O") && (button[5].getText() == "O") && (button[8].getText() == "O")) {
        yWins(2, 5, 8);
    }
    else if ((button[3].getText() == "O") && (button[4].getText() == "O") && (button[5].getText() == "O")) {
        yWins(3, 4, 5);
    } else if ((button[6].getText() == "O") && (button[7].getText() == "O") && (button[8].getText() == "O")) {
        yWins(6, 7, 8);
    }
    else if(chance_flag==9) {
    	textfield.setText("Match Tie");
    	gameOver("Match Tie");
    }

}
public void xWins(int x1,int x2,int x3) {
	button[x1].setBackground(Color.RED);
	button[x2].setBackground(Color.RED);
	button[x3].setBackground(Color.RED);
	
	for(int i=0;i<9;i++) {
		button[i].setEnabled(false);
	}
	textfield.setText("X WINS");
	gameOver("X WINS");
}
public void yWins(int x1,int x2,int x3) {
	button[x1].setBackground(Color.RED);
	button[x2].setBackground(Color.RED);
	button[x3].setBackground(Color.RED);
	for(int i=0;i<9;i++) {
		button[i].setEnabled(false);
	}
	textfield.setText("Y WINS");
	gameOver("Y WINS");
}
public void actionPerformed(ActionEvent e) {
	for(int i=0;i<9;i++) {
		if(e.getSource()==button[i]) {
			if(pl1_chance) {
				if(button[i].getText()=="") {
					button[i].setForeground(new Color(255,0,0));
					button[i].setText("X");
					pl1_chance=false;
					textfield.setText("Y TURN");
					chance_flag++;
					matchCheck();
				}
			}else {
				if(button[i].getText()=="") {
					button[i].setForeground(new Color(0,0,255));
					button[i].setText("Y");
					pl1_chance=true;
					textfield.setText("X TURN");
					chance_flag++;
					matchCheck();
				}
			}
		}
	}
}}
