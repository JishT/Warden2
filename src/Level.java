import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public abstract class Level extends AppPanel implements MouseListener, KeyListener, MouseMotionListener {
    private final static Image grassimage;
    private final static Image iceimage;
    private final static Image cityimage;
    private final static Image mudimage;
    static {
        try {
            grassimage = ImageIO.read(Upgradesmenu.class.getResourceAsStream("grassbackground.bmp"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    static {
        try {
            mudimage = ImageIO.read(Upgradesmenu.class.getResourceAsStream("mudbackground.bmp"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    static {
        try {
            iceimage= ImageIO.read(Upgradesmenu.class.getResourceAsStream("snowbackground.bmp"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    static {
        try {
            cityimage = ImageIO.read(Upgradesmenu.class.getResourceAsStream("citybackground.jpg"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    List<Entity> entities = Collections.synchronizedList(new CopyOnWriteArrayList<>());
    List<Particle> particles = Collections.synchronizedList(new CopyOnWriteArrayList<>());
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;

    private static final int TANK = 1;
    private static final int TRUCK = 2;
    private static final int PLANE = 3;
    private static final int TURRET = 4;
    private static final int TOWER = 5;

    private static final int BOSSTURRET = 1;
    private static final int BOSSTANK = 2;
    private static final int BOSSSHIP = 3;
    private static final int BOSSCOPTER = 4;

    public static int level = 0;


    public static int points = 1000;
    private int currentWave = -1;

    private List<List<Entity>> waves = new CopyOnWriteArrayList<>();

    public static class Level1 extends Level {

        public Level1() {
            this.level = 1;
            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),

            }));

            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 75),
                    new Enemy(TURRET, 400, 100),
                    new Enemy(TOWER, 500, 100),

            }));

            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(TRUCK, 200, 200),
                    new Enemy(PLANE, 300, 75),
                    new Enemy(TURRET, 400, 100),
                    new Boss(BOSSTURRET, 500, 100),
            }));
        }
    }

    public static class Level2 extends Level {
        public Level2() {
            this.level = 2;
            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 75),
                    new Enemy(TURRET, 40, 150),
                    new Enemy(TOWER, 600, 150),
            }));

            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 50),
                    new Enemy(TURRET, 40, 100),
                    new Enemy(TOWER, 700, 100),
                    new Enemy(TANK, 200, 200),
                    new Enemy(TRUCK, 300, 200),
                    new Enemy(PLANE, 400, 150),
                    new Enemy(TURRET, 50, 210),
                    new Enemy(TOWER, 500, 400),
            }));
            this.addWave(Arrays.asList(new Entity[]{
                    new Boss(BOSSTANK, 500, 100),
                    new Enemy(TANK, 100, 200),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 100),
                    new Enemy(TURRET, 400, 100),
                    new Enemy(TANK, 200, 200),
                    new Enemy(TRUCK, 300, 200),
                    new Enemy(PLANE, 300, 150),
                    new Enemy(TURRET, 20, 200),
                    new Enemy(TOWER, 700, 200),
            }));
        }
    }

    public static class Level3 extends Level {
        public Level3() {
            this.level = 3;
            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 250),
                    new Enemy(TRUCK, 200, 150),
                    new Enemy(PLANE, 50, 50),
                    new Enemy(TURRET, 800, 200),
                    new Enemy(TOWER, 500, 200),
            }));
            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 175),
                    new Enemy(TRUCK, 200, 175),
                    new Enemy(PLANE, 300, 100),
                    new Enemy(TURRET, 800, 250),
                    new Enemy(TOWER, 50, 250),
                    new Enemy(TANK, 200, 200),
                    new Enemy(TRUCK, 300, 200),
                    new Enemy(PLANE, 400, 50),
                    new Enemy(TURRET, 20, 200),
                    new Enemy(TOWER, 700, 200),
            }));

            this.addWave(Arrays.asList(new Entity[]{
                    new Boss(BOSSSHIP, 100, 100),
                    new Enemy(TRUCK, 350, 50),
                    new Enemy(PLANE, 300, 50),
                    new Enemy(TURRET, 750, 150),
                    new Enemy(TOWER, 900, 300),
                    new Enemy(TANK, 200, 200),
                    new Enemy(TRUCK, 300, 200),
                    new Enemy(PLANE, 200, 300),
                    new Enemy(TURRET, 20, 200),
                    new Enemy(TOWER, 600, 200),
            }));
        }
    }

    public static class Level4 extends Level {
        public Level4() {
            this.level = 4;
            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 200),
                    new Enemy(PLANE, 300, 50),
                    new Enemy(TURRET, 40, 300),
                    new Enemy(TOWER, 800, 100),
            }));

            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 20),
                    new Enemy(TURRET, 750, 100),
                    new Enemy(TOWER, 900, 100),
                    new Enemy(TANK, 300, 200),
                    new Enemy(TRUCK, 350, 200),
                    new Enemy(PLANE, 400, 75),
                    new Enemy(TURRET, 250, 200),
                    new Enemy(TOWER, 500, 200),
            }));

            this.addWave(Arrays.asList(new Entity[]{
                    new Boss(BOSSCOPTER, 50, 150),
                    new Enemy(TRUCK, 200, 200),
                    new Enemy(TRUCK, 300, 200),
                    new Enemy(PLANE, 300, 50),
                    new Enemy(TURRET, 40, 200),
                    new Enemy(TOWER, 900, 200),
                    new Enemy(TANK, 200, 200),
                    new Enemy(TRUCK, 350, 200),
                    new Enemy(PLANE, 400, 250),
                    new Enemy(TURRET, 750, 300),
                    new Enemy(TOWER, 250, 300),
            }));
        }
    }

    public Level() {
        entities.add(new PlayerTank(500, 500));
        for (Entity e : entities) {
            e.addParticleToLevel = particle -> {
                particle.removeSelf = this.particles::remove;
                particles.add(particle);
            };
            e.removeSelf = this.entities::remove;
            e.removeParticleFromLevel = this.particles::remove;
            e.addToScore = this::addToScore;
        }
        for (Particle p : particles) p.removeSelf = this.particles::remove;
        setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }


    public void addWave(List<Entity> wave) {
        this.waves.add(wave);
    }

    public void tick() {
        if (App.getCurrentPanel() == App.level1) {
            level = 1;
        } else if (App.getCurrentPanel() == App.level2) {
            level = 2;
        } else if (App.getCurrentPanel() == App.level3) {
            level = 3;
        } else if (App.getCurrentPanel() == App.level4) {
            level = 4;
        }
        // copy the list so it doesn't crash if the list is modified
        for (Entity a : entities) for (Entity b : entities) a.check(b);
        for (Entity a : entities) for (Particle b : particles) a.check(b);
        for (Particle p : particles) p.tick(WIDTH, HEIGHT);
        for (Entity e : entities) e.tick(WIDTH, HEIGHT);

        int enemyCount = 0;


        for (Entity p : entities) {
            if (p instanceof PlayerTank)
                if (((PlayerTank) p).health <= 0) {
                    ((PlayerTank) p).health = PlayerTank.HEALTH;
                    this.reset();
                    App.retryScreen.retryView = this;
                    App.setCurrentPanel(App.retryScreen);
                }
            if (p instanceof PlayerTank)
                if (((PlayerTank) p).pause) {
                    App.pauseScreen.resumeView = this;
                    App.setCurrentPanel(App.pauseScreen);
                }
            if (p instanceof Enemy) enemyCount++;
            if (p instanceof Boss) enemyCount++;
        }


        if (enemyCount < 1) {
            currentWave++;
            for (Entity e : entities)
                if (e instanceof PlayerTank) {
                    ((PlayerTank) e).x = 500;
                    ((PlayerTank) e).y = 500;
                    ((PlayerTank) e).vx = 0;
                    ((PlayerTank) e).vy = 0;
                }
            if (currentWave >= this.waves.size()) {
                this.reset();
                if (App.getCurrentPanel() == App.level1) {
                    App.setCurrentPanel(App.level2);
                } else if (App.getCurrentPanel() == App.level2) { ;
                    App.setCurrentPanel(App.level3);
                } else if (App.getCurrentPanel() == App.level3) {
                    App.setCurrentPanel(App.level4);
                } else {
                    App.setCurrentPanel(App.endScreen);
                }
                return;
            }
            this.entities.addAll(this.waves.get(this.currentWave));
            for (Entity e : entities) {
                e.addParticleToLevel = particle -> {
                    particle.removeSelf = this.particles::remove;
                    particles.add(particle);
                };
                e.removeSelf = this.entities::remove;
                e.removeParticleFromLevel = this.particles::remove;
                e.addToScore = this::addToScore;
            }
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g); //Clears the panel, for a fresh start
        Graphics2D g2d = (Graphics2D) g;

        Font txt = new Font("Monospaced", Font.BOLD, 13);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (this.level == 1) {
            g2d.drawImage(Level.grassimage,0,0,this);
            level=1;
        }
        if (this.level == 2) {
            g2d.drawImage(Level.iceimage,0,0,this);
            level=2;
        }
        if (this.level == 3) {
            g2d.drawImage(Level.mudimage,0,-50,this);
            level=3;
        }
        if (this.level == 4) {
            g2d.drawImage(Level.cityimage,0,0,WIDTH,HEIGHT,this);
            level=4;
        }

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, HEIGHT - 85, WIDTH, 50);
        g2d.setColor(Color.green);
        g2d.setFont(txt);
        g2d.drawString("Points:" + points, 10, HEIGHT - 55);
        g2d.drawString("Level:" + level + " Wave: " + (currentWave + 1), 800, HEIGHT - 55);
        for (Entity e : entities) e.paint(g2d);
        for (Particle p : particles) p.paint(g2d);
    }


    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Den of Tanks");
        Level jp = new Level1();
        frame.setContentPane(jp);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            jp.tick(); //Updates the coordinates
            jp.repaint(); //Calls the paint method
            Thread.sleep(1000 / 30); //Pauses for a moment
        }
    }

    public void mouseClicked(MouseEvent mouseEvent) {

    }

    public void mousePressed(MouseEvent mouseEvent) {
        for (Entity e : entities) e.mousePressed(mouseEvent);
    }

    public void mouseReleased(MouseEvent mouseEvent) {

    }

    public void mouseEntered(MouseEvent mouseEvent) {

    }

    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent keyEvent) {
        for (Entity e : entities) e.keyPressed(keyEvent);
    }

    public void keyReleased(KeyEvent keyEvent) {
        for (Entity e : entities) e.keyReleased(keyEvent);
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        for (Entity e : entities) e.mouseDragged(mouseEvent);
    }

    public void mouseMoved(MouseEvent mouseEvent) {
    }

    public void addToScore(int n) {
        points += n*10;
    }

    public void reset() {
        for (Entity e : entities)
            if (e instanceof PlayerTank) {
                ((PlayerTank) e).health = PlayerTank.HEALTH;
                ((PlayerTank) e).usedKit = false;
                ((PlayerTank) e).usedRapid = false;
                ((PlayerTank) e).usedDouble = false;
                ((PlayerTank) e).usedMobility = false;
                ((PlayerTank) e).r = 0;
                ((PlayerTank) e).b = 0;
                ((PlayerTank) e).m = 0;
            }
        for (Entity e : entities) if (e instanceof Enemy) entities.remove(e);
        particles.removeIf(v -> true);
        this.currentWave = -1;
    }
}

