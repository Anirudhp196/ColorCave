import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

public class ColorCave extends JPanel implements MouseListener {
    JFrame frame;
    Room currentRoom;
    long startTime;
    boolean gameStarted = false;
    Room start, end;
    AbstractRoomLoader loader;
    int counter;

    JLabel timerLabel;
    JLabel roomCounter;
    javax.swing.Timer timer;

    public ColorCave() {

        frame = new JFrame("Color Cave");
        frame.setSize(1500, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(this);
        frame.addMouseListener(this);

        frame.setVisible(true);

        showWelcomeScreen();

        loader = new RoomLoader();
        start = loader.getStart();
        end = loader.getEnd();
        counter = 0;
    }

    private void showWelcomeScreen() {
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.setBackground(Color.BLACK);

        JLabel title = new JLabel("Welcome to the Color Cave!");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomePanel.add(title);

        JLabel description = new JLabel("Try to escape by selecting the correct doors and finding your way out.");
        description.setFont(new Font("Arial", Font.PLAIN, 20));
        description.setForeground(Color.WHITE);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomePanel.add(description);

        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 30));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        welcomePanel.add(startButton);

        frame.getContentPane().removeAll();
        frame.add(welcomePanel);
        frame.revalidate();
        frame.repaint();
    }

    private void startGame() {
        frame.getContentPane().removeAll();
        frame.add(this);

        currentRoom = loader.getStart();
        System.out.println(currentRoom);
        startTime = System.currentTimeMillis();

        gameStarted = true;
        startTimer();

        frame.revalidate();
        frame.repaint();
    }

    private void startTimer() {
        timerLabel = new JLabel("Time Elapsed: 0.0 seconds");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        timerLabel.setForeground(Color.BLACK);
        frame.add(timerLabel, BorderLayout.SOUTH);

        roomCounter = new JLabel("Rooms Visited: 0");
        roomCounter.setFont(new Font("Arial", Font.BOLD, 20));
        roomCounter.setForeground(Color.PINK);
        frame.add(roomCounter, BorderLayout.NORTH);

        timer = new javax.swing.Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double elapsedTime = (System.currentTimeMillis() - startTime) / 1000.0;
                timerLabel.setText("Time Elapsed: " + Math.round(elapsedTime * 10) /10.0 + " seconds");
            }
        });
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, frame.getWidth(), frame.getHeight());

        if (currentRoom != null) {
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, 25));
            g2.drawString("Current Room: " + currentRoom.getName(), 20, 30);
            g2.drawString("Description: " + currentRoom.getDescription(), 20, 60);

            Set<Door> doors = currentRoom.getDoors();
            int x = 100;
            for (Door door : doors) {
                g2.setColor(enumToColor(door));
                Rectangle rect = new Rectangle(x, 300, 200, 400);
                g2.fill(rect);

                drawDoorknob(g2, x, 300, door);
                x += 250;
            }
        }
    }

    private void drawDoorknob(Graphics2D g2, int x, int y, Door door) {
        int knobX = x + 150;
        int knobY = y + 200;
        g2.setColor(Color.WHITE);
        g2.fillOval(knobX - 5, knobY - 5, 25, 25);
    }

    public void mouseClicked(MouseEvent e) {
        if (!gameStarted) {
            return;
        }

        Set<Door> doors = currentRoom.getDoors();
        int x = 100;
        for (Door door : doors) {
            Rectangle doorRect = new Rectangle(x, 300, 200, 400);
            if (doorRect.contains(e.getPoint())) {
                currentRoom = currentRoom.enter(door);
                counter++;
                roomCounter.setText("Rooms Visited: " + counter);
                repaint();
                break;
            }
            x += 250;
        }

        // Check if the current room is the end room
        if (currentRoom.equals(end)) {
            timer.stop();
            //long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
            double elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000.0;
            displayEscapePanel(elapsedSeconds, counter);
        }
    }

    private void displayEscapePanel(double elapsedTime, int counter) {
        frame.remove(timerLabel);

        JPanel escapePanel = new JPanel(new BorderLayout());
        escapePanel.setBackground(Color.BLACK);

        JLabel messageLabel = new JLabel("You escaped in " + counter + " steps!!!");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 50));
        messageLabel.setForeground(Color.WHITE);
        escapePanel.add(messageLabel, BorderLayout.CENTER);

        JLabel timeLabel = new JLabel("Time taken: " + Math.round(elapsedTime * 10) /10.0 + " seconds");
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        timeLabel.setForeground(Color.WHITE);
        escapePanel.add(timeLabel, BorderLayout.SOUTH);

        frame.getContentPane().removeAll();
        frame.add(escapePanel);
        frame.revalidate();
        frame.repaint();
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    private Color enumToColor(Door d) {
        switch (d) {
            case RED:
                return Color.RED;
            case GREEN:
                return Color.GREEN;
            case BLUE:
                return Color.BLUE;
            case PINK:
                return Color.PINK;
            case YELLOW:
                return Color.YELLOW;
            default:
                return Color.WHITE;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorCave::new);
    }
}


