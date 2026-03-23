import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class EjercicioFlor1 extends JPanel implements ActionListener {

    private Timer timer;
    private int petalosVisibles = 0;

    private final int petalosCapaExterior = 32;
    private final int petalosCapaInterior = 28;
    private final int totalPetalos = petalosCapaExterior + petalosCapaInterior;

    private boolean creando = true;

    public EjercicioFlor1() {
        setBackground(new Color(245, 245, 245));
        timer = new Timer(55, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        int cx = getWidth() / 2;
        int cy = getHeight() / 2;

        // sombra general de la flor
        g2.setColor(new Color(0, 0, 0, 25));
        g2.fillOval(cx - 145, cy - 60, 290, 290);

        // CAPA EXTERIOR
        int exterioresVisibles = Math.min(petalosVisibles, petalosCapaExterior);
        for (int i = 0; i < exterioresVisibles; i++) {
            double angulo = Math.toRadians((360.0 / petalosCapaExterior) * i);
            dibujarPetaloRelleno(g2, cx, cy, angulo, 120, 42, 82,
                    new Color(243, 188, 0),
                    new Color(255, 215, 20),
                    new Color(214, 155, 0));
        }

        // CAPA INTERIOR
        int interioresVisibles = Math.max(0, petalosVisibles - petalosCapaExterior);
        interioresVisibles = Math.min(interioresVisibles, petalosCapaInterior);

        for (int i = 0; i < interioresVisibles; i++) {
            double angulo = Math.toRadians((360.0 / petalosCapaInterior) * i + 0.10);
            dibujarPetaloRelleno(g2, cx, cy, angulo, 95, 34, 62,
                    new Color(247, 198, 10),
                    new Color(255, 225, 50),
                    new Color(224, 168, 8));
        }

        dibujarCentro(g2, cx, cy);

        g2.dispose();
    }

    private void dibujarPetaloRelleno(Graphics2D g2, int cx, int cy, double angulo,
                                      int largo, int ancho, int distanciaCentro,
                                      Color baseOscura, Color baseClara, Color contorno) {

        Shape petalo = crearPetalo(cx, cy, angulo, largo, ancho, distanciaCentro);

        // sombra del pétalo
        Graphics2D sombra = (Graphics2D) g2.create();
        sombra.translate(5, 5);
        sombra.setColor(new Color(0, 0, 0, 28));
        sombra.fill(petalo);
        sombra.dispose();

        // relleno degradado del pétalo
        Rectangle bounds = petalo.getBounds();
        GradientPaint gp = new GradientPaint(
                bounds.x, bounds.y, baseClara,
                bounds.x, bounds.y + bounds.height, baseOscura
        );
        g2.setPaint(gp);
        g2.fill(petalo);

        // textura interna del pétalo
        Shape oldClip = g2.getClip();
        g2.setClip(petalo);

        g2.setColor(new Color(255, 240, 120, 80));
        for (int i = 0; i < 6; i++) {
            int offset = i * 3;
            int x1 = bounds.x + bounds.width / 2;
            int y1 = bounds.y + 10;
            int x2 = bounds.x + bounds.width / 2 - 10 + offset;
            int y2 = bounds.y + bounds.height - 8;
            g2.drawLine(x1, y1, x2, y2);
        }

        g2.setColor(new Color(210, 150, 0, 45));
        for (int i = 0; i < 5; i++) {
            int y = bounds.y + 12 + i * (Math.max(8, bounds.height / 7));
            g2.drawLine(bounds.x + 8, y, bounds.x + bounds.width - 8, y);
        }

        g2.setClip(oldClip);

        // borde
        g2.setColor(contorno);
        g2.setStroke(new BasicStroke(1.4f));
        g2.draw(petalo);

        // nervadura central
        int baseX = cx + (int)(distanciaCentro * Math.cos(angulo));
        int baseY = cy + (int)(distanciaCentro * Math.sin(angulo));
        int puntaX = cx + (int)((distanciaCentro + largo - 6) * Math.cos(angulo));
        int puntaY = cy + (int)((distanciaCentro + largo - 6) * Math.sin(angulo));

        g2.setColor(new Color(180, 125, 0, 95));
        g2.drawLine(baseX, baseY, puntaX, puntaY);
    }

    private Shape crearPetalo(int cx, int cy, double angulo, int largo, int ancho, int distanciaCentro) {
        int baseX = cx + (int)(distanciaCentro * Math.cos(angulo));
        int baseY = cy + (int)(distanciaCentro * Math.sin(angulo));

        int puntaX = cx + (int)((distanciaCentro + largo) * Math.cos(angulo));
        int puntaY = cy + (int)((distanciaCentro + largo) * Math.sin(angulo));

        double perp = angulo + Math.PI / 2.0;

        int izqBaseX = baseX + (int)((ancho / 2.0) * Math.cos(perp));
        int izqBaseY = baseY + (int)((ancho / 2.0) * Math.sin(perp));

        int derBaseX = baseX - (int)((ancho / 2.0) * Math.cos(perp));
        int derBaseY = baseY - (int)((ancho / 2.0) * Math.sin(perp));

        int curvIzq1X = cx + (int)((distanciaCentro + largo * 0.32) * Math.cos(angulo) + (ancho * 0.78) * Math.cos(perp));
        int curvIzq1Y = cy + (int)((distanciaCentro + largo * 0.32) * Math.sin(angulo) + (ancho * 0.78) * Math.sin(perp));

        int curvIzq2X = cx + (int)((distanciaCentro + largo * 0.70) * Math.cos(angulo) + (ancho * 0.30) * Math.cos(perp));
        int curvIzq2Y = cy + (int)((distanciaCentro + largo * 0.70) * Math.sin(angulo) + (ancho * 0.30) * Math.sin(perp));

        int curvDer1X = cx + (int)((distanciaCentro + largo * 0.32) * Math.cos(angulo) - (ancho * 0.78) * Math.cos(perp));
        int curvDer1Y = cy + (int)((distanciaCentro + largo * 0.32) * Math.sin(angulo) - (ancho * 0.78) * Math.sin(perp));

        int curvDer2X = cx + (int)((distanciaCentro + largo * 0.70) * Math.cos(angulo) - (ancho * 0.30) * Math.cos(perp));
        int curvDer2Y = cy + (int)((distanciaCentro + largo * 0.70) * Math.sin(angulo) - (ancho * 0.30) * Math.sin(perp));

        Path2D.Double petalo = new Path2D.Double();
        petalo.moveTo(izqBaseX, izqBaseY);
        petalo.curveTo(curvIzq1X, curvIzq1Y, curvIzq2X, curvIzq2Y, puntaX, puntaY);
        petalo.curveTo(curvDer2X, curvDer2Y, curvDer1X, curvDer1Y, derBaseX, derBaseY);
        petalo.closePath();

        return petalo;
    }

    private void dibujarCentro(Graphics2D g2, int cx, int cy) {
        int radio = 68;

        // sombra del centro
        g2.setColor(new Color(0, 0, 0, 35));
        g2.fillOval(cx - radio + 4, cy - radio + 6, radio * 2, radio * 2);

        // relleno del centro
        RadialGradientPaint rgp = new RadialGradientPaint(
                new Point(cx - 10, cy - 10),
                radio,
                new float[]{0f, 0.55f, 1f},
                new Color[]{
                        new Color(165, 102, 35),
                        new Color(118, 70, 24),
                        new Color(75, 40, 10)
                }
        );
        g2.setPaint(rgp);
        g2.fill(new Ellipse2D.Double(cx - radio, cy - radio, radio * 2, radio * 2));

        // patrón de semillas
        for (int i = 0; i < 340; i++) {
            double angulo = Math.toRadians(i * 137.5);
            double dist = Math.sqrt(i) * 3.5;

            if (dist < radio - 5) {
                int x = cx + (int)(dist * Math.cos(angulo));
                int y = cy + (int)(dist * Math.sin(angulo));

                int tam = 4;
                if (i % 2 == 0) {
                    g2.setColor(new Color(90, 50, 15, 180));
                } else {
                    g2.setColor(new Color(190, 135, 45, 160));
                }
                g2.fillOval(x - tam / 2, y - tam / 2, tam, tam);
            }
        }

        // brillo ligero
        g2.setColor(new Color(255, 220, 140, 30));
        g2.fillOval(cx - 34, cy - 36, 42, 30);

        // borde
        g2.setColor(new Color(82, 45, 12));
        g2.setStroke(new BasicStroke(2f));
        g2.drawOval(cx - radio, cy - radio, radio * 2, radio * 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (creando) {
            petalosVisibles++;
            if (petalosVisibles >= totalPetalos) {
                petalosVisibles = totalPetalos;
                //creando = false;
            }
        } else {
            petalosVisibles--;
            if (petalosVisibles <= 0) {
                petalosVisibles = 0;
                creando = true;
            }
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Te amo Lupita hermosa");
        EjercicioFlor1 panel = new EjercicioFlor1();

        ventana.add(panel);
        ventana.setSize(720, 720);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}