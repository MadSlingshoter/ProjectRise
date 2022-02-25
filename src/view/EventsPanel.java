package view;

import controller.ManageEvents;
import model.player.Player;
import model.tiles.Property;
import model.tiles.Tavern;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EventsPanel extends JPanel {

    private Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 4);
    private Border emptyBorder = BorderFactory.createEmptyBorder();
    private JTextArea infoArea = new JTextArea();
    private JLabel headerLbl = new  JLabel();
    private Font fontHeader = new Font("ALGERIAN", Font.BOLD, 21);
    private Font font = new Font("Gabriola", Font.BOLD, 16);
    public JButton yesProperty = new JButton();
    public JButton noProperty = new JButton();
    public JButton payJail = new JButton();
    public JButton noPayJail = new JButton();
    public JButton yesTavern = new JButton();
    public JButton noTavern = new JButton();
    public JButton reset = new JButton();
    private FlowLayout layout = new FlowLayout();
    private Player player;
    private ManageEvents manageEvent;
    private Property property;
    private Tavern tavern;



    public EventsPanel(ManageEvents manageEvents) {
        setPreferredSize(new Dimension(400,300));
        setLayout(layout);
        setBackground(Color.gray);
        setBounds(180,280, 400, 300);
        setBorder(border);
        setVisible(false);

        headerLbl.setBounds(5,10, 390, 20);
        headerLbl.setFont(fontHeader);

        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);
        infoArea.setBounds(25,30,350, 140);
        infoArea.setPreferredSize(new Dimension(390,140));
        infoArea.setEditable(false);
        infoArea.setFont(font);
        infoArea.setBackground(Color.gray);
        infoArea.setForeground(Color.black);
        infoArea.setVisible(true);

        add(headerLbl);
        add(infoArea);
        add(yesProperty);
        add(noProperty);

        this.manageEvent = manageEvents;

        initializeButtons();
        addListeners();
    }

    public Icon makeIcon(String path){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));

        } catch (IOException e) {

            e.printStackTrace();
        }

        Image bimg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);


        return new ImageIcon(bimg);
    }

    public void setMessage(String text, String header){
        headerLbl.setText(header);
        infoArea.setText(text);
        setVisible(true);
    }

    public void setMessage(String text){
        infoArea.setText(text);
        setVisible(true);
    }
    public void activatePropertyButtons(){
        yesProperty.setVisible(true);
        noProperty.setVisible(true);
        yesProperty.setEnabled(true);
        noProperty.setEnabled(true);
    }

    public void activeJailButtons(){
        payJail.setVisible(true);
        payJail.setEnabled(true);
        noPayJail.setVisible(true);
        noPayJail.setEnabled(true);
    }

    public void activateTavernButtons(){
        yesTavern.setVisible(true);
        yesTavern.setEnabled(true);
        noTavern.setVisible(true);
        noTavern.setEnabled(true);
    }

    public void deactivateAllButtons(){
        yesProperty.setEnabled(false);
        noProperty.setEnabled(false);
        yesProperty.setVisible(false);
        noProperty.setVisible(false);
        payJail.setVisible(false);
        payJail.setEnabled(false);
        noPayJail.setVisible(false);
        noPayJail.setEnabled(false);
        noTavern.setVisible(false);
        noTavern.setEnabled(false);
        yesTavern.setVisible(false);
        yesTavern.setEnabled(false);
    }

    public void activateResetButton(){
      reset.setEnabled(true);
      reset.setVisible(true);
    }

    public void setPlayer(Player player){
        this.player=player;
    }
    public void setProperty(Property property){
        this.property=property;
    }
    public void setTavern(Tavern tavern) {
        this.tavern = tavern;
    }

    public void hideEventpanel(){
        setVisible(false);
    }

    public void addListeners(){
        yesProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deactivateAllButtons();
                manageEvent.propertyBuy(property,player);
                setVisible(false);
            }
        });
        noProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deactivateAllButtons();
                manageEvent.propertyNotBuy(property,player);
                setVisible(false);
            }
        });
        noPayJail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deactivateAllButtons();
                manageEvent.noPayJail(player);
                setVisible(false);
            }
        });
        payJail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deactivateAllButtons();
                manageEvent.payJail(player);
                setVisible(false);
            }
        });
        yesTavern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deactivateAllButtons();
                manageEvent.buyTavern(tavern,player);
                setVisible(false);
            }
        });
        noTavern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deactivateAllButtons();
                manageEvent.noBuyTavern(tavern,player);
                setVisible(false);
            }
        });
//        reset.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dice.resetGame();
//            }
//        });
    }

    public void initializeButtons() {
        yesProperty.setBounds(50,160, 100,10);
        yesProperty.setPreferredSize(new Dimension(40,40));
        yesProperty.setIcon(makeIcon("images/grenn_check.png"));
        yesProperty.setEnabled(false);
        yesProperty.setVisible(false);

        noProperty.setBounds(100,160, 100,10);
        noProperty.setPreferredSize(new Dimension(40,40));
        noProperty.setIcon(makeIcon("images/red_cross.png"));
        noProperty.setEnabled(false);
        noProperty.setVisible(false);

        payJail.setBounds(50,160, 100,10);
        payJail.setPreferredSize(new Dimension(40,40));
        payJail.setIcon(makeIcon("images/grenn_check.png"));
        payJail.setEnabled(false);
        payJail.setVisible(false);
        add(payJail);

        noPayJail.setBounds(100,160, 100,10);
        noPayJail.setPreferredSize(new Dimension(40,40));
        noPayJail.setIcon(makeIcon("images/red_cross.png"));
        noPayJail.setEnabled(false);
        noPayJail.setVisible(false);
        add(noPayJail);

        yesTavern.setBounds(50,160, 100,10);
        yesTavern.setPreferredSize(new Dimension(40,40));
        yesTavern.setIcon(makeIcon("images/grenn_check.png"));
        yesTavern.setEnabled(false);
        yesTavern.setVisible(false);
        add(yesTavern);

        noTavern.setBounds(100,160, 100,10);
        noTavern.setPreferredSize(new Dimension(40,40));
        noTavern.setIcon(makeIcon("images/red_cross.png"));
        noTavern.setEnabled(false);
        noTavern.setVisible(false);
        add(noTavern);

        reset.setBounds(100,160, 100,10);
        reset.setPreferredSize(new Dimension(40,40));
        reset.setIcon(makeIcon("images/grenn_check.png"));
        reset.setEnabled(false);
        reset.setVisible(false);
        add(reset);

    }
}
