package org.beast.addpersonalb.gui;

import org.beast.addpersonalb.utils.actioColor;
import org.beast.addpersonalb.utils.actioMur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class guiPrincipal extends JFrame {
    public guiPrincipal() {
        Principal panelGui = new Principal();
        setBounds(600,280,600,408);
        setLocationRelativeTo(this);
        setResizable(false);
        add(panelGui);

    }
    public static class Principal extends JPanel {
        public Principal() {
            actioMur.setCustomCursor(this);
            addMouseMotionListener(new actioMur());

            setLayout(null);//No se, pq no?
            setBackground(new Color(60, 60, 62));//para cambiar el color a la monda esta q está muy trite
            JMenuBar barr= getMenus();
            add(barr);
            JPopupMenu emergent = new JPopupMenu();
            JMenuItem opt1 = new JMenuItem("reload");
            emergent.add(opt1);setComponentPopupMenu(emergent);
            //Oyentes
            //Botones
            JButton boton6 = new JButton("future");
            JButton boton7 = new JButton(new ImageIcon("src/main/java/org/beast/addpersonalb/ico/SEGREDO.jpg"));
            JButton boton8 = new JButton("execute");
            boton5 = new JButton("close");
            //AÑADIR BOTONES
            add(boton5);boton5.setBounds(506, 220, 85, 20);
            //add(boton6);boton6.setBounds(506, 145, 85, 20);
            add(boton7);boton7.setBounds(576, 306, 20, 20);
            add(boton8);boton8.setBounds(506, 170, 85, 20);
            //añadir botones y oyente
            //boton6.addActionListener(new futureButtonListener());
            boton7.addActionListener(new personalButtonListener());
            boton8.addActionListener(new chatButtonListener());

            //instancia de Imagen - TryCatch de la IOException (obligatorio)
            try {imagen = ImageIO.read(new File("src/main/java/org/beast/addpersonalb/ico/RADAR3.png"));}
            catch (IOException e) {System.out.println("not found");}}

        public void paintComponent(Graphics g) {
            //imagen
            super.paintComponent(g);
            g.drawImage(imagen, 0, 0, null);
            //presentación
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.LIGHT_GRAY);
            Font font2 = new Font("Courier", Font.BOLD, 12);
            g2.setFont(font2);
            g2.drawString(":3", 560, 320);
            //fin
        }
        private Image imagen;

        private JMenuBar getMenus() {
            JMenu menuArch = new JMenu("File");
            JMenu menuPref = new JMenu("Preferences");
            JMenu menuOpc = new JMenu("Settings");
            JMenu menuCol = new JMenu("Color");

            menuCol.add(new actioColor("Bermejo ", new ImageIcon("src/main/java/org/beast/addpersonalb/ico/Icono.jpg"), new Color(103, 19, 27),Principal.this));
            menuCol.add(new actioColor("Celeste grisaceo ", new ImageIcon("src/main/java/org/beast/addpersonalb/ico/Icono.jpg"), new Color(19, 78, 102),Principal.this));
            menuCol.add(new actioColor("Gris ", new ImageIcon("src/main/java/org/beast/addpersonalb/ico/Icono.jpg"), new Color(70, 70, 70),Principal.this));
            menuOpc.add(menuCol);
            menuPref.add(menuOpc);

            JMenuBar menos = new JMenuBar();
            menos.add(menuArch);
            menos.add(menuPref);

            menos.setBounds(0, 0, 600, 20);
            return menos;
        }
        //                          Clases oyentes de distintas ventanas

        //#1 chat
        private class chatButtonListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                guiLoginFrame letteraFrameBTN = new guiLoginFrame(boton5);
                letteraFrameBTN.setVisible(true);
            }
        }
        //#2 mensaxe
        private class personalButtonListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                guiPersonalSharing personalFrameBTN = new guiPersonalSharing(boton5);
                personalFrameBTN.setVisible(true);
                personalFrameBTN.setResizable(false);
            }
        }
        //#3  futuro
        private class futureButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                guiMethods methodFrame = new guiMethods(boton5);
                methodFrame.setVisible(true);
                methodFrame.setResizable(false);
            }
        }

                //                               El boton de la salvación:
                                                    JButton boton5;
    }
}
