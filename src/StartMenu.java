import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartMenu extends AppPanel implements MouseListener {
private Buttons ngamebttn = new Buttons(30,175,125,50);
    private Buttons lselectbttn = new Buttons(30,375,125,50);
    private Buttons upgradesbttn = new Buttons(30,475,125,50);
    private Buttons continuegamebttn = new Buttons(30,275,125,50);
    public StartMenu() {
        addMouseListener(this);
        setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draw Background
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 2300, 2000);
        /*ngb.paint(g2d);
        cgb.paint(g2d);
        ub.paint(g2d);
lsb.paint(g2d);*/
        //Draw button
        g2d.setColor(Color.GREEN);
        ngamebttn.paint(g2d);
        upgradesbttn.paint(g2d);
        continuegamebttn.paint(g2d);
        lselectbttn.paint(g2d);
    }

    public void tick() {
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        // IF STATEMENTS FOR NEW GAME BUTTON
        if ((mouseEvent.getX() >= ngamebttn.getX()) && (mouseEvent.getX()<=(ngamebttn.getX()+ngamebttn.getW())) && (mouseEvent.getY()>= ngamebttn.getY())&& (mouseEvent.getY()<=(ngamebttn.getY()+ngamebttn.getH()))){
            System.out.println("I'm in the New Game button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+ngamebttn.getY());
        }

        // IF STATEMENTS FOR CONTINUE GAME BUTTON
        if ((mouseEvent.getX() >= continuegamebttn.getX()) && (mouseEvent.getX()<=(continuegamebttn.getX()+continuegamebttn.getW())) && (mouseEvent.getY()>= continuegamebttn.getY())&& (mouseEvent.getY()<=(continuegamebttn.getY()+continuegamebttn.getH()))){
            System.out.println("I'm in the Continue Game button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+continuegamebttn.getY());
        }

        // IF STATEMENTS FOR UPGRADES GAME BUTTON
        if ((mouseEvent.getX() >= upgradesbttn.getX()) && (mouseEvent.getX()<=(upgradesbttn.getX()+upgradesbttn.getW())) && (mouseEvent.getY()>= upgradesbttn.getY())&& (mouseEvent.getY()<=(upgradesbttn.getY()+upgradesbttn.getH()))){
            System.out.println("I'm in the Upgrades button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+upgradesbttn.getY());
        }

        // IF STATEMENTS FOR LEVEL SELECT BUTTON
        if ((mouseEvent.getX() >= lselectbttn.getX()) && (mouseEvent.getX()<=(lselectbttn.getX()+lselectbttn.getW())) && (mouseEvent.getY()>= lselectbttn.getY())&& (mouseEvent.getY()<=(lselectbttn.getY()+lselectbttn.getH()))){
            System.out.println("I'm in the Level Select button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+lselectbttn.getY());
            /*lsb.paint();*/
        }
    }

    public void mousePressed(MouseEvent mouseEvent) {
        // Go to corresponding menu
        // IF STATEMENTS FOR NEW GAME BUTTON
        if ((mouseEvent.getX() >= ngamebttn.getX()) && (mouseEvent.getX()<=(ngamebttn.getX()+ngamebttn.getW())) && (mouseEvent.getY()>= ngamebttn.getY())&& (mouseEvent.getY()<=(ngamebttn.getY()+ngamebttn.getH()))){
            System.out.println("I'm in the New Game button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+ngamebttn.getY());
        }

        // IF STATEMENTS FOR CONTINUE GAME BUTTON
        if ((mouseEvent.getX() >= continuegamebttn.getX()) && (mouseEvent.getX()<=(continuegamebttn.getX()+continuegamebttn.getW())) && (mouseEvent.getY()>= continuegamebttn.getY())&& (mouseEvent.getY()<=(continuegamebttn.getY()+continuegamebttn.getH()))){
            System.out.println("I'm in the Continue Game button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+continuegamebttn.getY());
        }

        // IF STATEMENTS FOR UPGRADES GAME BUTTON
        if ((mouseEvent.getX() >= upgradesbttn.getX()) && (mouseEvent.getX()<=(upgradesbttn.getX()+upgradesbttn.getW())) && (mouseEvent.getY()>= upgradesbttn.getY())&& (mouseEvent.getY()<=(upgradesbttn.getY()+upgradesbttn.getH()))){
            System.out.println("I'm in the Upgrades button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+upgradesbttn.getY());
        }

        // IF STATEMENTS FOR LEVEL SELECT BUTTON
        if ((mouseEvent.getX() >= lselectbttn.getX()) && (mouseEvent.getX()<=(lselectbttn.getX()+lselectbttn.getW())) && (mouseEvent.getY()>= lselectbttn.getY())&& (mouseEvent.getY()<=(lselectbttn.getY()+lselectbttn.getH()))){
            System.out.println("I'm in the Level Select button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+lselectbttn.getY());
            /*    lsb.paint();*/
        }
    }

    public void mouseReleased(MouseEvent mouseEvent) {
    }

    public void mouseEntered(MouseEvent mouseEvent) {
    }

    public void mouseExited(MouseEvent mouseEvent) {
    }
}