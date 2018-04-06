package client.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import client.listener.ConnectionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * MenuBar handles the menu options given on main frame
 *
 * @author Abhishek
 */
public class MenuBar extends JMenuBar implements ActionListener {

    private JMenuItem launchServer;
    private JMenuItem connect;
    private JMenuItem reconnect;
    private JMenuItem stopWatch;
    private JMenuItem connection;
    private ConnectionListener connectionListener;
    private BufferedImage GreenIcon, RedIcon;


    public MenuBar(){
        //URL menu_url = getClass().getResource("MENU_BACKGROUND.png");
        //setLayout(new GridLayout(1,4));
        URL menuBack_url = getClass().getResource("BlackBackground.jpg");
        URL stopimg_url = getClass().getResource("StopWatch.png");
        JMenu menu = new JMenu("Menu");
        BufferedImage  menuBorder, stopImage, redImage, greenImage;
        BufferedImage resizeMBorder = null, resizeStopImg = null;
        GreenIcon = null;
        RedIcon = null;
        try{
            //menuImage = ImageIO.read(menu_url);
            redImage = ImageIO.read(getClass().getResource("redDot.png"));
            greenImage = ImageIO.read(getClass().getResource("greenDot.png"));
            menuBorder = ImageIO.read(menuBack_url);
            stopImage = ImageIO.read(stopimg_url);
            //resizeMenuImg= new BufferedImage(30, 20, BufferedImage.TYPE_INT_ARGB);
            resizeMBorder = new BufferedImage(20, 10, BufferedImage.TYPE_INT_ARGB);
            resizeStopImg = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
            RedIcon = new BufferedImage(30,30,BufferedImage.TYPE_INT_ARGB);

            GreenIcon = new BufferedImage(25,25,BufferedImage.TYPE_INT_ARGB);
            //Graphics2D g2 = setGraphics(resizeMenuImg,menuImage);
            Graphics2D g1 = setGraphics(resizeMBorder, menuBorder);
            Graphics2D g3 = setGraphics(resizeStopImg, stopImage);
            Graphics2D g4 = setGraphics(RedIcon, redImage);

            Graphics2D g5 = setGraphics(GreenIcon, greenImage);
        }catch (IOException e) {
            System.out.println("Please specify image path");
        }
        menu.setHorizontalTextPosition(SwingConstants.CENTER);
        menu.setVerticalTextPosition(SwingConstants.BOTTOM);
        //menu.setIcon(new ImageIcon(resizeMBorder));
        //menu.setSize(this.getWidth(),20);
        menu.setMnemonic(KeyEvent.VK_M);
        launchServer = new JMenuItem("Launch Server");

        Border black_border = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK);
        launchServer.setBorder(black_border);
        launchServer.setOpaque(true);
        launchServer.setBackground(Color.BLACK);
        launchServer.setForeground(Color.WHITE);

        JMenu connectMenu = new JMenu("Connect");
        connectMenu.setOpaque(true);
        connectMenu.setBackground(Color.BLACK);
        connectMenu.setForeground(Color.WHITE);
        connectMenu.setBorder(black_border);
        connect = new JMenuItem("Connect");
        reconnect = new JMenuItem("Reconnect");
        connect.setOpaque(true);
        connect.setForeground(Color.WHITE);
        connect.setBackground(Color.BLACK);
        connect.setBorder(black_border);
        reconnect.setOpaque(true);
        reconnect.setForeground(Color.WHITE);
        reconnect.setBackground(Color.BLACK);
        reconnect.setBorder(black_border);
        connectMenu.add(connect);
        connectMenu.add(new JPopupMenu.Separator());
        connectMenu.add(reconnect);

        stopWatch = new JMenuItem("Stop Watch", new ImageIcon(resizeStopImg));
        //stopImage_item.setSize(1,this.getHeight());
        connection = new JMenuItem();
        connect(false);

        launchServer.addActionListener(this);
        connect.addActionListener(this);
        reconnect.addActionListener(this);
        menu.add(launchServer);
        menu.add(new JPopupMenu.Separator());
        menu.add(connectMenu);
        menu.setOpaque(true);
        menu.setBackground(Color.BLACK);
        menu.setForeground(Color.WHITE);
        add(menu);
        //add(Box.createRigidArea(new Dimension(this.getWidth(),40)));
        stopWatch.setBackground(Color.BLACK);
        stopWatch.setForeground(Color.WHITE);
        connection.setBackground(Color.BLACK);
        connection.setForeground(Color.WHITE);
        add(stopWatch);
        add(connection);
        //add(timmer, BorderLayout.CENTER);
    }

    /**
     * connect method, changes the label and icon on menubar.
     *
     * @param flag
     */
    public void connect(boolean flag){
        if(flag){
            connection.setIcon(new ImageIcon(GreenIcon));
            connection.setText("Connected");
        }
        else{
            connection.setIcon(new ImageIcon(RedIcon));
            connection.setText("Not Connected");
        }
    }
    
    public void setConnectionListener(ConnectionListener connectionListener) {
    		this.connectionListener = connectionListener;
    }

    public Graphics2D setGraphics(BufferedImage resizeImg, BufferedImage menuImage){
        Graphics2D g2 = resizeImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(menuImage, 0, 0, 30, 24, null);
        g2.dispose();
        return g2;
    }

    @Override
    public void paintComponent(Graphics g) {
        Dimension size = this.getSize();
        g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("BlackBackground.jpg")), 0,
                0, size.width, size.height, this);
    }

    /**
     * actionPerformed method handles the on click event from menu.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == launchServer)
        {
            connectionListener.initializeServer();
        }
        else if (e.getSource() == connect)
        {
            if(connectionListener!=null) {
            		connectionListener.startServer();
            }
            /*call connection(true) to turn connection label green*/
        }
        else if (e.getSource() == reconnect)
        {
        		connectionListener.reconnectServer(null);
        }
    }
}
