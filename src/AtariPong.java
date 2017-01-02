
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Hantack
 */
public class AtariPong extends javax.swing.JPanel {

    ImageIcon icono;
    int platX = 240, platY = 520;
    int plat2X = 240, plat2Y = 40;
    boolean bH, bV;
    int ancho, alto;
    int ballonX = 270, ballonY = 510;

    public AtariPong(int ancho, int alto) {
        initComponents();
        this.setSize(ancho, alto);
        this.ancho = ancho - 50;
        this.alto = alto - 50;

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 30, ancho, alto);
        icono = new ImageIcon(getClass().getResource("/imgp/pelota.png"));
        g.drawImage(icono.getImage(), ballonX, ballonY, 10, 10, null);

        icono = new ImageIcon(getClass().getResource("/imgp/plat.png"));
        g.drawImage(icono.getImage(), platX, platY, 80, 20, null);
        setOpaque(false);

        icono = new ImageIcon(getClass().getResource("/imgp/plat.png"));
        g.drawImage(icono.getImage(), plat2X, plat2Y, 80, 20, null);
        setOpaque(false);

    }

    public boolean Lost() {
        if (ballonY >= 560 || ballonY <=25) {
            JOptionPane.showMessageDialog(null, "G A M E   O V E R");

            return true;

        } else {
            return false;
        }
    }

    public void Collider() {
        if (platX + 80 > ballonX && platX < ballonX + 5 && (platY + 25 > ballonY && platY < ballonY + 5)) {

            bV = false;

            /*if(time>=10){
                time -=5;
            }*/
        } else if (plat2X + 80 > ballonX && plat2X < ballonX + 5 && (plat2Y + 25 > ballonY && plat2Y < ballonY + 5)) {
            bV = true;
        }
    }

    public void MoveBallon() {

        if (bH) {
            if (ballonX <= 530) {
                ballonX += 5;
            } else {
                bH = false;
                ballonX -= 5;
            }
        } else if (ballonX >= 0) {
            ballonX -= 5;
        } else {
            bH = true;
            ballonX += 5;

        }

        // Vertical
        if (bV) {
            if (ballonY <= 600) {
                ballonY += 5;
            } else {
                bV = false;
                ballonY -= 5;
            }
        } else if (ballonY >= 30) {
            ballonY -= 5;
        } else {
            bV = true;
            ballonY += 5;

        }
        if (Lost()) {
            game.stop();
            //bgMusic.stop();
        }
        repaint();

    }
    Thread game = new Thread() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    MoveBallon();
                    Collider();
                } catch (InterruptedException ex) {
                    Logger.getLogger(AtariPong.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
