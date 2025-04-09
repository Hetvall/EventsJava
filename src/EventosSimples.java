import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventosSimples extends JFrame {

    public EventosSimples() {
        setTitle("FocusEvent (campo de texto)");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Botón con formato HTML
        JButton botonChiste = new JButton("<html>🐤 <b>¿Quieres reír?</b><br><i>Haz clic, valiente</i></html>");
        botonChiste.setPreferredSize(new Dimension(300, 60));

        // Acción del botón
        botonChiste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "—¿Cómo maldice un pollito a otro?\n—¡Caldito seas! 🐣😝");
            }
        });

        add(botonChiste);
        setVisible(true);
    }
}
