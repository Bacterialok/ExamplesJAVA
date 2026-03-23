import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class FlorLoop extends JPanel implements ActionListener {

    private Timer timer;
    private int petalosVisibles = 0;

    private final int totalPetalos = 24;
    private boolean creando = true; // controla si crece o se borra

    public FlorLoop() {
        timer = new Timer(100, this);
        timer.start();
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int cx = 250;
        int cy = 250;

        double paso = 360.0 / totalPetalos;

        for (int i = 0; i < petalosVisibles; i++) {
            double angulo = Math.toRadians(i * paso);

            Shape petalo = crearPetalo(cx, cy, 120, 50, angulo);

            g2.setColor(Color.YELLOW);
            g2.fill(petalo);

            g2.setColor(Color.ORANGE);
            g2.draw(petalo);
        }

        // centro
        g2.setColor(new Color(139, 69, 19));
        g2.fillOval(cx - 35, cy - 35, 70, 70);
    }

    public Shape crearPetalo(int cx, int cy, int largo, int ancho, double angulo) {
        Path2D.Double p = new Path2D.Double();

        p.moveTo(cx - ancho / 2.0, cy);
        p.curveTo(cx - ancho, cy - largo / 2.0, cx - ancho / 3.0, cy - largo, cx, cy - largo);
        p.curveTo(cx + ancho / 3.0, cy - largo, cx + ancho, cy - largo / 2.0, cx + ancho / 2.0, cy);
        p.closePath();

        AffineTransform at = new AffineTransform();
        at.rotate(angulo, cx, cy);

        return at.createTransformedShape(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (creando) {
            petalosVisibles++;

            if (petalosVisibles >= totalPetalos) {
                petalosVisibles = totalPetalos;
                creando = false; // empieza a borrar
            }

        } else {
            petalosVisibles--;

            if (petalosVisibles <= 0) {
                petalosVisibles = 0;
                creando = true; // vuelve a crear
            }
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Flor en loop");
        ventana.add(new FlorLoop());
        ventana.setSize(500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}


