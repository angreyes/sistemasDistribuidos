/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.RMI;

/**
 *
 * @author usuario
 */
public class CommandUser extends java.applet.Applet {

    /**
     * Initializes the applet CommandUser
     */
    public void init() {
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void connectServer() {
        try{
            Registry reg = LocateRegistry.getRegistry("127.0.0.1",22);
            RMI rmi = (RMI) reg.lookup("server");
            String comand = jTextArea1.getText();
            String result = "Connected to server \n 127.0.0.1:22";
            String text = rmi.getComand("cmd /c "+comand);
            //String text = rmi.getComand("cmd /c dir");
            System.out.println(result+text);
            jLabel2.setText(result + text);     
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();

        setLayout(new java.awt.BorderLayout());

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame1.setVisible(true);

        jLabel1.setText("Sistemas Distribuidos");
        jInternalFrame1.getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jTextArea1.setBackground(new java.awt.Color(255, 204, 255));
        jTextArea1.setColumns(40);
        jTextArea1.setFont(new java.awt.Font("Monotype Corsiva", 2, 12)); // NOI18N
        jTextArea1.setRows(6);
        jTextArea1.setAlignmentX(0.7F);
        jTextArea1.setAlignmentY(0.3F);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jButton1, org.jdesktop.beansbinding.ObjectProperty.create(), jTextArea1, org.jdesktop.beansbinding.BeanProperty.create("alignmentX"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jButton1, org.jdesktop.beansbinding.ObjectProperty.create(), jTextArea1, org.jdesktop.beansbinding.BeanProperty.create("alignmentY"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(jTextArea1);

        jInternalFrame1.getContentPane().add(jScrollPane1, java.awt.BorderLayout.LINE_END);

        jLabel2.setText("Resultado");
        jInternalFrame1.getContentPane().add(jLabel2, java.awt.BorderLayout.CENTER);

        jButton1.setText("Conectar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButton1, java.awt.BorderLayout.PAGE_END);

        jToolBar1.setRollover(true);
        jInternalFrame1.getContentPane().add(jToolBar1, java.awt.BorderLayout.LINE_START);

        add(jInternalFrame1, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        connectServer();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
