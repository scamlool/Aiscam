/**
PLEASE NOTE: 
---------
I AM GIVING THE FILE NAME AS MY ROLL NUMBER. BUT TO EXECUTE THIS FILE YOU HAVE TO GIVE FILE NAME AS 'TTT' WHICH IS MY MAIN CLASS NAME. SO PLEASE RENAME IT. THANK YOU :)
*/

import java.awt.*;
import java.awt.event.*;

class XoStart extends Frame implements ActionListener
{
	Label m1, p1, p2, alt;
	TextField tf1, tf2;
	Button start;

	public XoStart()
	{
		setLayout(null);

		m1 = new Label("XO Game Play",Label.CENTER);
		m1.setSize(320,30);
		m1.setFont(new Font("Arial",Font.BOLD,21));
		m1.setLocation(0,70);
		add(m1);

		p1 = new Label("Player X : ");
		p2 = new Label("Player O : ");
		tf1 = new TextField(15);
		tf2 = new TextField(15);
		start = new Button("Start");

		Font f = new Font("TimesRoman",Font.BOLD,16);
		p1.setSize(100,20);
		p1.setFont(f);
		p1.setLocation(50,150);
		add(p1);

		tf1.setSize(140,20);
		tf1.setLocation(150,150);
		add(tf1);

		p2.setSize(100,20);
		p2.setFont(f);
		p2.setLocation(50,180);
		add(p2);

		tf2.setSize(140,20);
		tf2.setLocation(150,180);
		add(tf2);

		start.setSize(100,25);
		start.setLocation(110,230);
		add(start);

		alt = new Label("",Label.CENTER);
		alt.setSize(200,20);
		alt.setForeground(Color.red);
		alt.setLocation(59,270);
		add(alt);

		start.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(tf1.getText().equals("") || tf2.getText().equals(""))
		{
			alt.setText("Enter Player Name");
		}
		else
		{	
			TTT x = new TTT(tf1.getText(), tf2.getText());
			x.setSize(400,400);
			x.setVisible(true);
		}
	}
}


class TTT extends Frame implements ActionListener
{
	Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,resetgame;
	String player1, player2;

	String letter = "X";
	int draw = 0;

	public TTT(String player1, String player2)
	{
		this.player1 = player1;
		this.player2 = player2;

		setLayout(new GridLayout(4,3));
		setTitle(player1+"'s Chance");

		btn1 = new Button();
		btn2 = new Button();
		btn3 = new Button();
		btn4 = new Button();
		btn5 = new Button();
		btn6 = new Button();
		btn7 = new Button();
		btn8 = new Button();
		btn9 = new Button();
		resetgame = new Button("Reset Game");


		add(btn1);add(btn2);add(btn3);add(btn4);add(btn5);add(btn6);add(btn7);add(btn8);add(btn9);add(resetgame);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		resetgame.addActionListener(this);

	}

	public void resetGame()
	{
		btn1.setLabel("");
		btn2.setLabel("");
		btn3.setLabel("");
		btn4.setLabel("");
		btn5.setLabel("");
		btn6.setLabel("");
		btn7.setLabel("");
		btn8.setLabel("");
		btn9.setLabel("");

		btn1.setEnabled(true);
		btn2.setEnabled(true);
		btn3.setEnabled(true);
		btn4.setEnabled(true);
		btn5.setEnabled(true);
		btn6.setEnabled(true);
		btn7.setEnabled(true);
		btn8.setEnabled(true);
		btn9.setEnabled(true);
	}

	public void isDraw()
	{
		if(
			(!(btn1.getLabel().equals(""))) &&
			(!(btn2.getLabel().equals(""))) &&
			(!(btn3.getLabel().equals(""))) &&
			(!(btn4.getLabel().equals(""))) &&
			(!(btn5.getLabel().equals(""))) &&
			(!(btn6.getLabel().equals(""))) &&
			(!(btn7.getLabel().equals(""))) &&
			(!(btn8.getLabel().equals(""))) &&
			(!(btn9.getLabel().equals("")))
		)
		{
			WinnerDialog wd = new WinnerDialog(this,"No One ");
			wd.setTitle("Oops");
			wd.setVisible(true);
		}
	}


	public int isWin()
	{
		// Cheking horizontal lines
		if(btn1.getLabel().equals("X") && btn2.getLabel().equals("X") && btn3.getLabel().equals("X"))
		{
			draw = 0;
			return 0;
		}
		else if(btn1.getLabel().equals("O") && btn2.getLabel().equals("O") && btn3.getLabel().equals("O"))
		{
			draw = 0;
			return 1;
		}
		else if(btn4.getLabel().equals("X") && btn5.getLabel().equals("X") && btn6.getLabel().equals("X"))
		{
			draw = 0;
			return 0;
		}
		else if(btn4.getLabel().equals("O") && btn5.getLabel().equals("O") && btn6.getLabel().equals("O"))
		{
			draw = 0;
			return 1;
		}
		else if(btn7.getLabel().equals("X") && btn8.getLabel().equals("X") && btn9.getLabel().equals("X"))
		{
			draw = 0;
			return 0;
		}
		else if(btn7.getLabel().equals("O") && btn8.getLabel().equals("O") && btn9.getLabel().equals("O"))
		{
			draw = 0;
			return 1;
		}
		// Cheking vertical lines
		else if(btn1.getLabel().equals("X") && btn4.getLabel().equals("X") && btn7.getLabel().equals("X"))
		{
			draw = 0;
			return 0;
		}
		else if(btn1.getLabel().equals("O") && btn4.getLabel().equals("O") && btn7.getLabel().equals("O"))
		{
			draw = 0;
			return 1;
		}
		else if(btn2.getLabel().equals("X") && btn5.getLabel().equals("X") && btn8.getLabel().equals("X"))
		{
			draw = 0;
			return 0;
		}
		else if(btn2.getLabel().equals("O") && btn5.getLabel().equals("O") && btn8.getLabel().equals("O"))
		{
			draw = 0;
			return 1;
		}
		else if(btn3.getLabel().equals("X") && btn6.getLabel().equals("X") && btn9.getLabel().equals("X"))
		{
			draw = 0;
			return 0;
		}
		else if(btn3.getLabel().equals("O") && btn6.getLabel().equals("O") && btn9.getLabel().equals("O"))
		{
			draw = 0;
			return 1;
		}
		// Checking for major diagonals
		else if(btn1.getLabel().equals("X") && btn5.getLabel().equals("X") && btn9.getLabel().equals("X"))
		{
			draw = 0;
			return 0;
		}
		else if(btn1.getLabel().equals("O") && btn5.getLabel().equals("O") && btn9.getLabel().equals("O"))
		{
			draw = 0;
			return 1;
		}
		else if(btn3.getLabel().equals("X") && btn5.getLabel().equals("X") && btn7.getLabel().equals("X"))
		{
			draw = 0;
			return 0;
		}
		else if(btn3.getLabel().equals("O") && btn5.getLabel().equals("O") && btn7.getLabel().equals("O"))
		{
			draw = 0;
			return 1;
		}
		
		draw = 1;
		return 2;
	}

	public void actionPerformed(ActionEvent ae)
	{
		Object ob = ae.getSource();


		if(ob == btn1)
		{
			System.out.println(letter);
			btn1.setLabel(letter);
			btn1.setFont(new Font("Arial",Font.BOLD,22));
			btn1.setEnabled(false);
			if(letter.equals("X"))
			{
				letter = "O";
				setTitle(player2 + "'s Chance");
			}
			else
			{
				letter = "X";
				setTitle(player1 + "'s Chance");
			}
			isDraw();
			if(isWin() == 0)
			{
				WinnerDialog wd = new WinnerDialog(this,player1);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
			else if(isWin() == 1)
			{
				WinnerDialog wd = new WinnerDialog(this,player2);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}

		}
		else if(ob == btn2)
		{
			btn2.setLabel(letter);
			btn2.setFont(new Font("Arial",Font.BOLD,22));
			btn2.setEnabled(false);
			if(letter.equals("X"))
			{
				letter = "O";
				setTitle(player2 + "'s Chance");
			}
			else
			{
				letter = "X";
				setTitle(player1 + "'s Chance");
			}
			isDraw();
			if(isWin() == 0)
			{
				WinnerDialog wd = new WinnerDialog(this,player1);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
			else if(isWin() == 1)
			{
				WinnerDialog wd = new WinnerDialog(this,player2);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
		}
		else if(ob == btn3)
		{
			btn3.setLabel(letter);
			btn3.setFont(new Font("Arial",Font.BOLD,22));
			btn3.setEnabled(false);
			if(letter.equals("X"))
			{
				letter = "O";
				setTitle(player2 + "'s Chance");
			}
			else
			{
				letter = "X";
				setTitle(player1 + "'s Chance");
			}
			isDraw();
			if(isWin() == 0)
			{
				WinnerDialog wd = new WinnerDialog(this,player1);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
			else if(isWin() == 1)
			{
				WinnerDialog wd = new WinnerDialog(this,player2);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
		}
		else if(ob == btn4)
		{
			btn4.setLabel(letter);
			btn4.setFont(new Font("Arial",Font.BOLD,22));
			btn4.setEnabled(false);
			if(letter.equals("X"))
			{
				letter = "O";
				setTitle(player2 + "'s Chance");
			}
			else
			{
				letter = "X";
				setTitle(player1 + "'s Chance");
			}
			isDraw();
			if(isWin() == 0)
			{
				WinnerDialog wd = new WinnerDialog(this,player1);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
			else if(isWin() == 1)
			{
				WinnerDialog wd = new WinnerDialog(this,player2);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
		}
		else if(ob == btn5)
		{
			btn5.setLabel(letter);
			btn5.setFont(new Font("Arial",Font.BOLD,22));
			btn5.setEnabled(false);
			if(letter.equals("X"))
			{
				letter = "O";
				setTitle(player2 + "'s Chance");
			}
			else
			{
				letter = "X";
				setTitle(player1 + "'s Chance");
			}
			isDraw();
			if(isWin() == 0)
			{
				WinnerDialog wd = new WinnerDialog(this,player1);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
			else if(isWin() == 1)
			{
				WinnerDialog wd = new WinnerDialog(this,player2);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
		}
		else if(ob == btn6)
		{
			btn6.setLabel(letter);
			btn6.setFont(new Font("Arial",Font.BOLD,22));
			btn6.setEnabled(false);
			if(letter.equals("X"))
			{
				letter = "O";
				setTitle(player2 + "'s Chance");
			}
			else
			{
				letter = "X";
				setTitle(player1 + "'s Chance");
			}
			isDraw();
			if(isWin() == 0)
			{
				WinnerDialog wd = new WinnerDialog(this,player1);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
			else if(isWin() == 1)
			{
				WinnerDialog wd = new WinnerDialog(this,player2);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
		}
		else if(ob == btn7)
		{
			btn7.setLabel(letter);
			btn7.setFont(new Font("Arial",Font.BOLD,22));
			btn7.setEnabled(false);
			if(letter.equals("X"))
			{
				letter = "O";
				setTitle(player2 + "'s Chance");
			}
			else
			{
				letter = "X";
				setTitle(player1 + "'s Chance");
			}
			isDraw();
			if(isWin() == 0)
			{
				WinnerDialog wd = new WinnerDialog(this,player1);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
			else if(isWin() == 1)
			{
				WinnerDialog wd = new WinnerDialog(this,player2);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
		}
		else if(ob == btn8)
		{
			btn8.setLabel(letter);
			btn8.setEnabled(false);
			btn8.setFont(new Font("Arial",Font.BOLD,22));
			if(letter.equals("X"))
			{
				letter = "O";
				setTitle(player2 + "'s Chance");
			}
			else
			{
				letter = "X";
				setTitle(player1 + "'s Chance");
			}
			isDraw();
			if(isWin() == 0)
			{
				WinnerDialog wd = new WinnerDialog(this,player1);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
			else if(isWin() == 1)
			{
				WinnerDialog wd = new WinnerDialog(this,player2);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
		}
		else if(ob == btn9)
		{
			btn9.setLabel(letter);
			btn9.setEnabled(false);
			btn9.setFont(new Font("Arial",Font.BOLD,22));
			if(letter.equals("X"))
			{
				letter = "O";
				setTitle(player2 + "'s Chance");
			}
			else
			{
				letter = "X";
				setTitle(player1 + "'s Chance");
			}
			isDraw();
			if(isWin() == 0)
			{
				WinnerDialog wd = new WinnerDialog(this,player1);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
			else if(isWin() == 1)
			{
				WinnerDialog wd = new WinnerDialog(this,player2);
				wd.setTitle("Congrats");
				wd.setVisible(true);
			}
		}
		else if(ob == resetgame)
		{
			resetGame();
		}
	}

	public static void main(String arg[])
	{
		XoStart xs = new XoStart();
		xs.setLayout(null);
		xs.setSize(320,400);
		xs.setVisible(true);
		
		
	}
}

class WinnerDialog extends Dialog implements ActionListener
{
	public WinnerDialog(Frame f, String winner)
	{
		super(f,false);
		this.setLayout(new FlowLayout());
		this.setSize(200,200);
		Label l1 = new Label(winner + " is winner !");
		l1.setFont(new Font("Arial",Font.BOLD,18));
		add(l1);

		Button okBtn = new Button("OK");
		add(okBtn);
		okBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		this.dispose();
	}
}