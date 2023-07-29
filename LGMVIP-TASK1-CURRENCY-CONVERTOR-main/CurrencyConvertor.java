import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CurrencyConvertor extends Frame implements ItemListener, ActionListener{  
    //Currency Convertor By Mohit Ramesh Kulkarni.
    JComboBox<String> convertFrom;
    JComboBox<String> convertTo;
    JTextField txtFrom, txtTo;
    JButton convert, exit;
    JLabel from, to;
    JLabel lblFrom, lblTo;
    JPanel mainPanel = new JPanel();
    double input = 0;
    double result = 0;

    public CurrencyConvertor() {
        super("LetsGrowMore - Currency Convertor");
        setSize(420,300);
        setLayout(null);
        setBackground(Color.lightGray);

        lblFrom = new JLabel("From :");
        lblFrom.setBounds(30,45,250,30);
        lblFrom.setForeground(Color.BLACK);
        add(lblFrom);

        String box1[]={"US Dollar","Indian Rupee","Japan Yen"};
        convertFrom = new JComboBox<>(box1);
        convertFrom.setBounds(30,70,150,30);
        add(convertFrom);

        lblTo = new JLabel("To :");
        lblTo.setBounds(230,45,250,30);
        lblTo.setForeground(Color.BLACK);
        add(lblTo);

        String box2[]={"US Dollar","Indian Rupee","Japan Yen"};
        convertTo = new JComboBox<>(box2);
        convertTo.setBounds(230,70,150,30);
        add(convertTo);

        from = new JLabel("Enter Amount to Convert :");
        from.setBounds(50,110,300,30);
        from.setForeground(Color.BLACK);
        add(from);

        txtFrom = new JTextField(15);
        txtFrom.setBounds(50,140,300,30);
        add(txtFrom);

        convert = new JButton("Convert");
        convert.setBounds(100,250,100,30);
        add(convert);

        to = new JLabel("Converted Amount :");
        to.setBounds(50,170,300,30);
        to.setForeground(Color.BLACK);
        add(to);  

        txtTo = new JTextField(15);
        txtTo.setBounds(50,200,300,30);
        txtTo.setEditable(false);
        txtTo.setForeground(Color.RED);
        add(txtTo);

        exit = new JButton("Exit");
        exit.setBounds(210,250,100,30);
        add(exit);
       
        convertFrom.addItemListener(this);
        convertTo.addItemListener(this);
        convert.addActionListener(this);
        txtFrom.addActionListener(this);
        exit.addActionListener(this);

        addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    exit();
                }
            });
    }

    public void exit(){
        setVisible(false);
        dispose();
        System.exit(0);
    }
  
    public static void main(String args[]) {
        CurrencyConvertor w = new CurrencyConvertor();
        w.setVisible(true);
    
    }
    public void ConvertDollar() {
        if(convertTo.getSelectedItem()=="US Dollar")
        {
            result = (input);
            txtTo.setText(""+result);
        }
        else if(convertTo.getSelectedItem()=="Indian Rupee")
        {
            result = (input * 82.71);
            txtTo.setText(""+result);
        }
        else
        {
            result = (input * 76.7);
            txtTo.setText(""+result);
        }
    }

    public void ConvertRupee() {
        if(convertTo.getSelectedItem()=="US Dollar")
        {
            result = (input / 82.71);
            txtTo.setText(""+result);
        }
        else if(convertTo.getSelectedItem()=="Indian Rupee")
        {
            result = (input);
            txtTo.setText(""+result);
        }
        else
        {
            result = (input / 0.63);
            txtTo.setText(""+result);
        }
    }

    public void ConvertYen() {
        if(convertTo.getSelectedItem()=="US Dollar")
        {
            result = (input * 0.013);
            txtTo.setText(""+result);
        }
        else if(convertTo.getSelectedItem()=="Indian Rupee")
        {
            result = (input * 0.63);
            txtTo.setText(""+result);
        }
        else
        {
            result = (input);
            txtTo.setText(""+result);
        }
    }

    public void actionPerformed(ActionEvent e) {
        input = Double.parseDouble(txtFrom.getText());

        if(e.getSource()==convert)
        {
            if(convertFrom.getSelectedItem()=="US Dollar")
            {
                ConvertDollar();                
            }
            else if(convertFrom.getSelectedItem()=="Indian Rupee")
            {
                ConvertRupee();
            }
            else
            {
                ConvertYen();
            }
        }
      
        else
        {
            dispose();
            System.exit(0);
        }   
    }
    public void itemStateChanged(ItemEvent e)
    {

    }
}

