
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.applet.AudioClip;

/**
 *
 * @author Hantack
 */
public class AtariPanel extends javax.swing.JPanel {

    AudioClip bgMusic, impacto= java.applet.Applet.newAudioClip(getClass().getResource("/audio/usp2.wav"));;
    int time = 100;
    boolean fL = true, sL = false, tL = false;
    int ancho, alto;
    public ImageIcon icono;
    int score = 0;
    boolean init = true;

    int platX = 240, platY = 520;
    int ballonX = 270, ballonY = 510;
    int anf = 50, altf = 30;

    boolean bH, bV;

    //Game Logic Siza Level 1
    boolean ab1 = true, ab2 = true, vb1 = true, vb2 = true, vb3 = true, vb4 = true, mb1 = true, mb2 = true, mb3 = true, mb4 = true, mb5 = true, mb6 = true,
            nb1 = true, nb2 = true, nb3 = true, nb4 = true, nb5 = true, nb6 = true, nb7 = true, nb8 = true, vbb1 = true, vbb2 = true,
            vbb3 = true, vbb4 = true, vbb5 = true, vbb6 = true, vbb7 = true, vbb8 = true, vbb9 = true, vbb10 = true;
    int ax1 = 0, ay1 = 40, ax2, ay2 = 0,
            vx1 = 52, vy1 = 40, vx2 = 0, vy2 = 72, vx3, vy3 = 40, vx4, vy4 = 72,
            mx1 = 102, my1 = 40, mx2 = 52, my2 = 72, mx3 = 0, my3 = 102, mx4, my4 = 40, mx5, my5 = 72, mx6, my6 = 102,
            nx1 = 152, ny1 = 40, nx2 = 102, ny2 = 72, nx3 = 52, ny3 = 102, nx4 = 0, ny4 = 132, ny5 = 40, nx5, nx6, ny6 = 72, nx7, ny7 = 102, nx8, ny8 = 132,
            vbx1 = 202, vby1 = 40, vbx2 = 152, vby2 = 72, vbx3 = 102, vby3 = 102, vbx4 = 52, vby4 = 132, vbx5 = 0, vby5 = 162,
            vbx6, vby6 = 40, vbx7, vby7 = 72, vbx8, vby8 = 102, vbx9, vby9 = 132, vbx10, vby10 = 162;
    //Game Logic Size Level 2
    int nbx1 = 152, nby1 = 132, nbx2 = 202, nby2 = 162, nbx3, nby3 = 132, nbx4, nby4 = 162, nbx5 = 250, nby5 = 190,
            rx1 = 152, ry1 = 162, rx2 = 202, ry2 = 190, rx3, ry3 = 162, rx4, ry4 = 190, rx5 = 102, ry5 = 132, rx6, ry6 = 132, rx7 = 250, ry7 = 220;
    //Game Logic Size Level3 
    int abx1 = 250, aby1 = 40, abx2 = 152, aby2 = 102, abx3 = 202, aby3 = 72, abx4 = 202, aby4 = 132, abx5 = 250, aby5 = 162, abx6, aby6 = 72, abx7, aby7 = 102, abx8, aby8 = 132, blx1 = 250, bly1 = 102;

    public AtariPanel(int ancho, int alto) {
        initComponents();
        this.setSize(ancho, alto);
        this.ancho = ancho - 50;
        this.alto = alto - 50;

    }

    public boolean Collider() {
        if (platX + 80 > ballonX && platX < ballonX + 5 && (platY + 20 > ballonY && platY < ballonY + 5)) {

            bV = false;
            
            if(time>=10){
                time -=5;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean ObjectCollider(int platX, int platY) {
        if (platX + anf > ballonX && platX < ballonX + 5 && (platY + altf > ballonY && platY < ballonY + 5)) {
            if(time>=10){
                time -=5;
            }
            impacto.play();
            return true;
        } else {
            return false;
        }
    }

    public void CheckPoints() {
        if (ab1) {
            if (ObjectCollider(ax1, ay1)) {
                score += 10;
                Score.setText(score + "");
                ab1 = false;

                bV = true;
                
            }
        }
        if (ab2) {
            if (ObjectCollider(ax2, ay2)) {
                score += 10;
                Score.setText(score + "");
                ab2 = false;
                bV = true;
                
            }
        }
        if (vb1) {
            if (ObjectCollider(vx1, vy1)) {
                score += 10;
                Score.setText(score + "");
                vb1 = false;
                bV = true;
                if (bH == true) {
                    bH = false;
                } else {
                    bH = true;
                }
            }
        }
        if (vb2) {
            if (ObjectCollider(vx2, vy2)) {
                score += 10;
                Score.setText(score + "");
                vb2 = false;
                bV = true;
               
            }
        }
        if (vb3) {
            if (ObjectCollider(vx3, vy3)) {
                score += 10;
                Score.setText(score + "");
                vb3 = false;
                bV = true;
               
            }
        }
        if (vb4) {
            if (ObjectCollider(vx4, vy4)) {
                score += 10;
                Score.setText(score + "");
                vb4 = false;
                bV = true;
               
            }
        }
        if (mb1) {
            if (ObjectCollider(mx1, my1)) {
                score += 10;
                Score.setText(score + "");
                mb1 = false;
                bV = true;
                
            }
        }
        if (mb2) {
            if (ObjectCollider(mx2, my2)) {
                score += 10;
                Score.setText(score + "");
                mb2 = false;
                bV = true;
               
            }
        }
        if (mb3) {
            if (ObjectCollider(mx3, my3)) {
                score += 10;
                Score.setText(score + "");
                mb3 = false;
                bV = true;
                
            }
        }
        if (mb4) {
            if (ObjectCollider(mx4, my4)) {
                score += 10;
                Score.setText(score + "");
                mb4 = false;
                bV = true;
                
            }
        }
        if (mb5) {
            if (ObjectCollider(mx5, my5)) {
                score += 10;
                Score.setText(score + "");
                mb5 = false;
                bV = true;
                
            }
        }
        if (mb6) {
            if (ObjectCollider(mx6, my6)) {
                score += 10;
                Score.setText(score + "");
                mb6 = false;
                bV = true;
                
            }
        }
        if (nb1) {
            if (ObjectCollider(nx1, ny1)) {
                score += 10;
                Score.setText(score + "");
                nb1 = false;
                bV = true;
                
            }
        }
        if (nb2) {
            if (ObjectCollider(nx2, ny2)) {
                score += 10;
                Score.setText(score + "");
                nb2 = false;
                bV = true;
                
            }
        }
        if (nb3) {
            if (ObjectCollider(nx3, ny3)) {
                score += 10;
                Score.setText(score + "");
                nb3 = false;
                bV = true;
                
            }
        }
        if (nb4) {
            if (ObjectCollider(nx4, ny4)) {
                score += 10;
                Score.setText(score + "");
                nb4 = false;
                bV = true;
                
            }
        }
        if (nb5) {
            if (ObjectCollider(nx5, ny5)) {
                score += 10;
                Score.setText(score + "");
                nb5 = false;
                bV = true;
                
            }
        }
        if (nb6) {
            if (ObjectCollider(nx6, ny6)) {
                score += 10;
                Score.setText(score + "");
                nb6 = false;
                bV = true;
                
            }
        }
        if (nb7) {
            if (ObjectCollider(nx7, ny7)) {
                score += 10;
                Score.setText(score + "");
                nb7 = false;
                bV = true;
                
            }
        }
        if (nb8) {
            if (ObjectCollider(nx8, ny8)) {
                score += 10;
                Score.setText(score + "");
                nb8 = false;
                bV = true;
                
            }
        }
        if (vbb1) {
            if (ObjectCollider(vbx1, vby1)) {
                score += 10;
                Score.setText(score + "");
                vbb1 = false;
                bV = true;
               
            }
        }
        if (vbb2) {
            if (ObjectCollider(vbx2, vby2)) {
                score += 10;
                Score.setText(score + "");
                vbb2 = false;
                bV = true;
                if (bH == true) {
                    bH = false;
                } else {
                    bH = true;
                }
            }
        }
        if (vbb3) {
            if (ObjectCollider(vbx3, vby3)) {
                score += 10;
                Score.setText(score + "");
                vbb3 = false;
                bV = true;
                
            }
        }
        if (vbb4) {
            if (ObjectCollider(vbx4, vby4)) {
                score += 10;
                Score.setText(score + "");
                vbb4 = false;
                bV = true;
                
            }
        }
        if (vbb5) {

            if (ObjectCollider(vbx5, vby5)) {
                
                score += 10;
                Score.setText(score + "");
                vbb5 = false;
                bV = true;
                
            }
        }
        if (vbb6) {
            if (ObjectCollider(vbx6, vby6)) {
                score += 10;
                Score.setText(score + "");
                vbb6 = false;
                bV = true;
                
            }
        }
        if (vbb7) {
            if (ObjectCollider(vbx7, vby7)) {
                score += 10;
                Score.setText(score + "");
                vbb7 = false;
                bV = true;
                
            }
        }
        if (vbb8) {
            if (ObjectCollider(vbx8, vby8)) {
                score += 10;
                Score.setText(score + "");
                vbb8 = false;
                bV = true;
                
            }
        }
        if (vbb9) {
            if (ObjectCollider(vbx9, vby9)) {
                score += 10;
                Score.setText(score + "");
                vbb9 = false;
                bV = true;
                
            }
        }
        if (vbb10) {
            if (ObjectCollider(vbx10, vby10)) {
                score += 10;
                Score.setText(score + "");
                vbb10 = false;
                bV = true;
                
            }
        }

    }

    public boolean Lost() {
        if (ballonY >= 560) {
            JOptionPane.showMessageDialog(null, "G A M E   O V E R");

            return true;

        } else {
            return false;
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
            bgMusic.stop();
        }
        repaint();

    }

    Thread game = new Thread() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(time);
                    MoveBallon();
                    CheckPoints();
                    Collider();
                } catch (InterruptedException ex) {
                    Logger.getLogger(AtariPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    };
    
    public void winner(){
        if(score == 300){
            JOptionPane.showMessageDialog(null, "G A N A S T E"); 
            game.stop();
        }
    }
    Thread music = new Thread() {
        @Override
        public void run() {
            bgMusic = java.applet.Applet.newAudioClip(getClass().getResource("/audio/bg2.wav"));
            bgMusic.loop();
        }
    };
    

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

        if (ab1) {
            icono = new ImageIcon(getClass().getResource("/imgp/azul.png"));
            g.drawImage(icono.getImage(), ax1, ay1, anf, altf, null);
            setOpaque(false);
        }

        if (vb1) {
            icono = new ImageIcon(getClass().getResource("/imgp/verde.png"));
            g.drawImage(icono.getImage(), vx1, vy1, anf, altf, null);
            setOpaque(false);

        }
        if (vb2) {
            icono = new ImageIcon(getClass().getResource("/imgp/verde.png"));
            g.drawImage(icono.getImage(), vx2, vy2, anf, altf, null);
            setOpaque(false);
        }
        if (mb1) {
            icono = new ImageIcon(getClass().getResource("/imgp/morado.png"));
            g.drawImage(icono.getImage(), mx1, my1, anf, altf, null);
            setOpaque(false);
        }
        if (mb2) {
            icono = new ImageIcon(getClass().getResource("/imgp/morado.png"));
            g.drawImage(icono.getImage(), mx2, my2, anf, altf, null);
            setOpaque(false);
        }

        if (mb3) {
            icono = new ImageIcon(getClass().getResource("/imgp/morado.png"));
            g.drawImage(icono.getImage(), mx3, my3, anf, altf, null);
            setOpaque(false);
        }

        if (nb1) {
            icono = new ImageIcon(getClass().getResource("/imgp/naranja.png"));
            g.drawImage(icono.getImage(), nx1, ny1, anf, altf, null);
            setOpaque(false);
        }
        if (nb2) {
            icono = new ImageIcon(getClass().getResource("/imgp/naranja.png"));
            g.drawImage(icono.getImage(), nx2, ny2, anf, altf, null);
            setOpaque(false);
        }

        if (nb3) {
            icono = new ImageIcon(getClass().getResource("/imgp/naranja.png"));
            g.drawImage(icono.getImage(), nx3, ny3, anf, altf, null);
            setOpaque(false);
        }

        if (nb4) {
            icono = new ImageIcon(getClass().getResource("/imgp/naranja.png"));
            g.drawImage(icono.getImage(), nx4, ny4, anf, altf, null);
            setOpaque(false);
        }

        if (vbb1) {
            icono = new ImageIcon(getClass().getResource("/imgp/vebajo.png"));
            g.drawImage(icono.getImage(), vbx1, vby1, anf, altf, null);

            setOpaque(false);
        }
        if (vbb2) {
            icono = new ImageIcon(getClass().getResource("/imgp/vebajo.png"));
            g.drawImage(icono.getImage(), vbx2, vby2, anf, altf, null);
            setOpaque(false);
        }

        if (vbb3) {
            icono = new ImageIcon(getClass().getResource("/imgp/vebajo.png"));
            g.drawImage(icono.getImage(), vbx3, vby3, anf, altf, null);
            setOpaque(false);
        }
        if (vbb4) {
            icono = new ImageIcon(getClass().getResource("/imgp/vebajo.png"));
            g.drawImage(icono.getImage(), vbx4, vby4, anf, altf, null);
            setOpaque(false);
        }
        if (vbb5) {
            icono = new ImageIcon(getClass().getResource("/imgp/vebajo.png"));
            g.drawImage(icono.getImage(), vbx5, vby5, anf, altf, null);
            setOpaque(false);
        }
        if (vbb6) {
            icono = new ImageIcon(getClass().getResource("/imgp/vebajo.png"));
            g.drawImage(icono.getImage(), vbx6, vby6, anf, altf, null);
            setOpaque(false);
        }
        if (mb1) {
            icono = new ImageIcon(getClass().getResource("/imgp/morado.png"));
            g.drawImage(icono.getImage(), mx1, my1, anf, altf, null);
            setOpaque(false);
        }
        if (mb2) {

            icono = new ImageIcon(getClass().getResource("/imgp/morado.png"));
            g.drawImage(icono.getImage(), mx2, my2, anf, altf, null);
            setOpaque(false);
        }

        if (mb3) {
            icono = new ImageIcon(getClass().getResource("/imgp/morado.png"));
            g.drawImage(icono.getImage(), mx3, my3, anf, altf, null);
            setOpaque(false);
        }

        if (nb1) {
            icono = new ImageIcon(getClass().getResource("/imgp/naranja.png"));
            g.drawImage(icono.getImage(), nx1, ny1, anf, altf, null);
            setOpaque(false);
        }
        if (nb2) {
            icono = new ImageIcon(getClass().getResource("/imgp/naranja.png"));
            g.drawImage(icono.getImage(), nx2, ny2, anf, altf, null);
            setOpaque(false);
        }

        if (nb3) {
            icono = new ImageIcon(getClass().getResource("/imgp/naranja.png"));
            g.drawImage(icono.getImage(), nx3, ny3, anf, altf, null);
            setOpaque(false);
        }

        if (nb4) {
            icono = new ImageIcon(getClass().getResource("/imgp/naranja.png"));
            g.drawImage(icono.getImage(), nx4, ny4, anf, altf, null);
            setOpaque(false);
        }

        // parte isquierda
        if (ab2) {
            icono = new ImageIcon(getClass().getResource("/imgp/azul.png"));
            g.drawImage(icono.getImage(), ax2 = ancho - 50, 40, anf, altf, null);
            setOpaque(false);
        }

        if (vb3) {
            icono = new ImageIcon(getClass().getResource("/imgp/verde.png"));
            g.drawImage(icono.getImage(), vx3 = ancho - 102, vy3, anf, altf, null);
            setOpaque(false);
        }

        if (vb4) {
            icono = new ImageIcon(getClass().getResource("/imgp/verde.png"));
            g.drawImage(icono.getImage(), vx4 = ancho - 50, vy4, anf, altf, null);
            setOpaque(false);
        }

        if (mb4) {
            icono = new ImageIcon(getClass().getResource("/imgp/morado.png"));
            g.drawImage(icono.getImage(), mx4 = ancho - 152, my4, anf, altf, null);
            setOpaque(false);
        }
        if (mb5) {
            icono = new ImageIcon(getClass().getResource("/imgp/morado.png"));
            g.drawImage(icono.getImage(), mx5 = ancho - 102, my5, anf, altf, null);
            setOpaque(false);
        }

        if (mb6) {

            icono = new ImageIcon(getClass().getResource("/imgp/morado.png"));
            g.drawImage(icono.getImage(), mx6 = ancho - 50, my6, anf, altf, null);
            setOpaque(false);
        }

        if (nb5) {
            icono = new ImageIcon(getClass().getResource("/imgp/naranja.png"));
            g.drawImage(icono.getImage(), nx5 = ancho - 202, ny5, anf, altf, null);
            setOpaque(false);
        }
        if (nb6) {
            icono = new ImageIcon(getClass().getResource("/imgp/naranja.png"));
            g.drawImage(icono.getImage(), nx6 = ancho - 152, ny6, anf, altf, null);
            setOpaque(false);
        }

        if (nb7) {
            icono = new ImageIcon(getClass().getResource("/imgp/naranja.png"));
            g.drawImage(icono.getImage(), nx7 = ancho - 102, ny7, anf, altf, null);
            setOpaque(false);
        }

        if (nb8) {
            icono = new ImageIcon(getClass().getResource("/imgp/naranja.png"));
            g.drawImage(icono.getImage(), nx8 = ancho - 50, ny8, anf, altf, null);
            setOpaque(false);
        }

        if (vbb6) {
            icono = new ImageIcon(getClass().getResource("/imgp/vebajo.png"));
            g.drawImage(icono.getImage(), vbx6 = ancho - 252, vby6, anf, altf, null);
            setOpaque(false);
        }
        if (vbb7) {

            icono = new ImageIcon(getClass().getResource("/imgp/vebajo.png"));
            g.drawImage(icono.getImage(), vbx7 = ancho - 202, vby7, anf, altf, null);
            setOpaque(false);
        }

        if (vbb8) {
            icono = new ImageIcon(getClass().getResource("/imgp/vebajo.png"));
            g.drawImage(icono.getImage(), vbx8 = ancho - 152, vby8, anf, altf, null);
            setOpaque(false);
        }

        if (vbb9) {
            icono = new ImageIcon(getClass().getResource("/imgp/vebajo.png"));
            g.drawImage(icono.getImage(), vbx9 = ancho - 102, vby9 = 132, anf, altf, null);
            setOpaque(false);
        }

        if (vbb10) {
            icono = new ImageIcon(getClass().getResource("/imgp/vebajo.png"));
            g.drawImage(icono.getImage(), vbx10 = ancho - 50, vby10 = 162, anf, altf, null);
            setOpaque(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Score = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        Score.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Score.setForeground(new java.awt.Color(0, 51, 0));
        Score.setText("0");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("S C O R E:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Score, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Score)
                    .addComponent(jLabel2))
                .addContainerGap(266, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Score;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
