/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipfs_chat;

import io.ipfs.api.IPFS;
import ipfs_shell_control.ipfs_shell;
import java.util.Base64;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author toor
 */
public class ipfs_chat extends javax.swing.JFrame implements Runnable {
    
    IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
    ipfs_shell conn_ipfs_shell = new ipfs_shell();
    
    /**
     * Creates new form ipfs_chat
     */
    public ipfs_chat() {
        th1 = new Thread(this);
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chat_output = new javax.swing.JTextArea();
        send_ipfs = new javax.swing.JButton();
        text_input = new javax.swing.JTextField();
        start_listen = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Project - BlackStar");

        jLabel2.setText("Chat:");

        chat_output.setEditable(false);
        chat_output.setColumns(20);
        chat_output.setForeground(new java.awt.Color(255, 0, 0));
        chat_output.setRows(5);
        jScrollPane1.setViewportView(chat_output);
        chat_output.setVisible(false);

        send_ipfs.setText("Send");
        send_ipfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_ipfsActionPerformed(evt);
            }
        });

        start_listen.setText("Start");
        start_listen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_listenActionPerformed(evt);
            }
        });

        jLabel3.setText("Node Name:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_input)
                        .addGap(18, 18, 18)
                        .addComponent(send_ipfs, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1)
                        .addGap(0, 125, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(name)
                        .addGap(18, 18, 18)
                        .addComponent(start_listen, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(start_listen)
                    .addComponent(jLabel3)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(send_ipfs)
                    .addComponent(text_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jLabel2.setVisible(false);
        send_ipfs.setVisible(false);
        text_input.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void send_ipfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_ipfsActionPerformed
        // TODO add your handling code here:
        publish_ipfs();
    }//GEN-LAST:event_send_ipfsActionPerformed

    private void start_listenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_listenActionPerformed
        // TODO add your handling code here:
        chat_output.setVisible(true);
        jLabel2.setVisible(true);
        text_input.setVisible(true);
        send_ipfs.setVisible(true);
        start_listen.setEnabled(false);
        name.setEditable(false);
        th1.start();
    }//GEN-LAST:event_start_listenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ipfs_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ipfs_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ipfs_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ipfs_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ipfs_chat().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chat_output;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JButton send_ipfs;
    private javax.swing.JButton start_listen;
    private javax.swing.JTextField text_input;
    // End of variables declaration//GEN-END:variables
    public Thread th1;
    
    public void run() {
        th1.currentThread();
        try {

            while (true) {
                Object sub1 = ipfs.pubsub.sub("startchat");
                Stream<Map<String, Object>> sub2 = (Stream<Map<String, Object>>) sub1;
                Object first = sub2.findAny();
                String sub3 = "" + first;
                String sub4[] = sub3.split(",");
                String data = sub4[1].substring(6, sub4[1].length());
                Base64.Decoder decoder = Base64.getDecoder();
                String dStr = new String(decoder.decode(data));
                String redStr = new String(decoder.decode(dStr));
                chat_output.append(redStr + "\n");
            }
        } catch (Exception ex) {
            Logger.getLogger(ipfs_chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void publish_ipfs() {
        try {          
            String command = text_input.getText();
            String padding_enc = name.getText()+":"+command;
            String encodedString = Base64.getEncoder().encodeToString(padding_enc.getBytes());           
            ipfs.pubsub.pub("startchat", encodedString);
        } catch (Exception ex) {
            Logger.getLogger(ipfs_chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
