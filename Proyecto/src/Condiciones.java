import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Condiciones extends JFrame implements ActionListener, ChangeListener {
    private JLabel label1, label2;
    private JCheckBox check1;
    private JButton boton1, boton2;
    private JScrollPane scroll1;
    private JTextArea textarea1;
    String nombre = "";

    public Condiciones(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Licencia de uso");
        setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
        Bienvenida ventanaBienvenida = new Bienvenida();
        nombre = ventanaBienvenida.texto;

        label1 = new JLabel("TÉRMINOS Y CONDICIONES");
        label1.setBounds(215,5,200,30);
        label1.setFont(new Font("Andale Mono",1,14));
        label1.setForeground(new Color(0,0,0));
        add(label1);

        textarea1 = new JTextArea();
        textarea1.setEditable(false);
        textarea1.setFont(new Font("Andale Mono", 0,12));
        textarea1.setText("\n\n          TÉRMINOS Y CONDICIONES"+
                "\n\n          Esta web, por tanto, cumple rigurosamente con el RGPD (REGLAMENTO (UE) 2016/679 de protección de datos)"+
                "\n          y la LSSI-CE la Ley 34/2002, de 11 de julio, de servicios de la sociedad de la información y de comercio electrónico. "+
                "\n\n          A. El Usuario queda informado, y acepta, que el acceso a la presente web no supone, en modo alguno, el inicio de una relación comercial "+
                "\n\n          B. El Usuario se compromete a utilizar el sitio Web, sus servicios y contenidos sin contravenir la legislación vigente, la buena fe y el orden público."+
                "\n\n          C. El Usuario se compromete a no llevar a cabo ninguna conducta que pudiera dañar la imagen, los intereses y los derechos de la marca o de terceros"+
                "\n\n          D. El usuario conoce y acepta que la totalidad del sitio web está protegida por marcas, derechos de autor y otros derechos legítimos");
        scroll1 = new JScrollPane(textarea1);
        scroll1.setBounds(10,40,575,200);
        add(scroll1);

        check1 = new JCheckBox("Yo "+nombre+" Acepto");
        check1.setBounds(10,250,300,30);
        check1.addChangeListener(this);
        add(check1);

        boton1 = new JButton("Continuar");
        boton1.setBounds(10,290,100,30);
        boton1.addActionListener(this);
        boton1.setEnabled(false);
        add(boton1);

        boton2 = new JButton("No Acepto");
        boton2.setBounds(120,290,100,30);
        boton2.addActionListener(this);
        boton2.setEnabled(true);
        add(boton2);

        ImageIcon imagen = new ImageIcon(getClass().getResource("images/coca-cola.png"));
        label2 = new JLabel(imagen);
        label2.setBounds(315,135,300,300);
        add(label2);
    }

    public void stateChanged(ChangeEvent e){
        if(check1.isSelected() == true){
            boton1.setEnabled(true);
            boton2.setEnabled(false);
        }else{
            boton1.setEnabled(false);
            boton2.setEnabled(true);
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            Principal ventanaPrincipal= new Principal();
            ventanaPrincipal.setBounds(0,0,640,535);
            ventanaPrincipal.setVisible(true);
            ventanaPrincipal.setResizable(false);
            ventanaPrincipal.setLocationRelativeTo(null);
            this.setVisible(false);

        }else if(e.getSource() == boton2){
            Bienvenida ventanabienve = new Bienvenida();
            ventanabienve.setBounds(0,0,350,450);
            ventanabienve.setVisible(true);
            ventanabienve.setResizable(false);
            ventanabienve.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }

    public static void main (String [] args){
        Condiciones ventanacond = new Condiciones();
        ventanacond.setBounds(0,0,600,360);
        ventanacond.setVisible(true);
        ventanacond.setResizable(false);
        ventanacond.setLocationRelativeTo(null);
    }
}
