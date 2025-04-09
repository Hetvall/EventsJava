import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventosSimples {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Eventos básicos");
        ventana.setSize(350, 300);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Botones
        JButton boton = new JButton("Clic aquí");
        boton.setBounds(30, 30, 100, 30);

        JButton segundoBoton = new JButton("Segundo botón");
        segundoBoton.setBounds(150, 30, 120, 30);

        JButton botonColor = new JButton("Cambiar color");
        botonColor.setBounds(30, 200, 150, 30);

        final Color[] colores = {Color.BLUE, Color.ORANGE, Color.MAGENTA};
        final int[] indiceColor = {0};

        JLabel etiqueta = new JLabel("Clics: 0");
        etiqueta.setBounds(30, 80, 100, 30);

        JLabel cantidadLetras = new JLabel("words: 0");
        cantidadLetras.setBounds(70, 100, 100, 30);

        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(30, 130, 150, 30);

        JLabel mensajeTecla = new JLabel("Escribe algo");
        mensajeTecla.setBounds(30, 170, 200, 30);

        // Focus Event
        campoTexto.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e){
                mensajeTecla.setText("Campo activo");
            }

            public void focusLost(FocusEvent e) {
                mensajeTecla.setText("Campo inactivo");
            }
        });

        // Evento del botón (ActionEvent)
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "¡Botón presionado!");

            }
        });
        segundoBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "¡Segundo botón presionado!");
            }
        });

        // Evento de mouse (MouseEvent) //a
        final int[] contador = {0};
        etiqueta.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                contador[0]++;
                if (contador[0] == 5) {
                    etiqueta.setText("¡Llegaste a 5 clics!");
                }else {
                etiqueta.setText("Clics: " + contador[0]); }
            }
        });

        // Evento de teclado (KeyEvent)
        campoTexto.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    mensajeTecla.setText("¡Presionaste Enter!");
                } else {
                    mensajeTecla.setText("Tecla: " + e.getKeyChar());
                }
            }
        });

        // Key event
        campoTexto.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                cantidadLetras.setText("words: " + campoTexto.getText().length());
            }
        });

        // Evento que cambia el color de fondo de la ventana
        botonColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //cambiar el color del fondo
                ventana.getContentPane().setBackground(colores[indiceColor[0]]);

                indiceColor[0] = (indiceColor[0] + 1) % colores.length;

            }
        });



        // Agregar componentes
        ventana.add(boton);
        ventana.add(segundoBoton);
        ventana.add(etiqueta);
        ventana.add(campoTexto);
        ventana.add(mensajeTecla);
        ventana.setVisible(true);
        ventana.add(botonColor);
        ventana.add(cantidadLetras);
    }
}
