package ipfs_shell_control;

import io.ipfs.api.IPFS;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.apache.commons.io.FileUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author toor
 */
public class ipfs_shell extends javax.swing.JFrame implements Runnable {

    IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");

    public Thread th1;

    /**
     * Creates new form ipfs_shell
     */
    public ipfs_shell() {
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
        jLabel3 = new javax.swing.JLabel();
        channel_name1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        shell_cmd = new javax.swing.JTextField();
        Send = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        output_sub = new javax.swing.JTextArea();
        set_topic = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Project - Black Star");

        jLabel3.setText("Channel Name:");

        jLabel4.setText("CMD:");

        Send.setText("Send");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });

        output_sub.setEditable(false);
        output_sub.setColumns(20);
        output_sub.setForeground(new java.awt.Color(255, 0, 0));
        output_sub.setRows(5);
        jScrollPane1.setViewportView(output_sub);

        set_topic.setText("Topic Set");
        set_topic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                set_topicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(shell_cmd)
                            .addComponent(channel_name1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Send, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(set_topic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(channel_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(set_topic))
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(shell_cmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Send))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
        );

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

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendActionPerformed
        publish_ipfs();
    }//GEN-LAST:event_SendActionPerformed

    private void set_topicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_set_topicActionPerformed
        // TODO add your handling code here:
        set_topic.setEnabled(false);
        channel_name1.setEnabled(false);
        th1.start();
      //  ipfs_chat conn_ipfs_chat = new ipfs_chat();
      //  conn_ipfs_chat.setVisible(true);

    }//GEN-LAST:event_set_topicActionPerformed

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
            java.util.logging.Logger.getLogger(ipfs_shell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ipfs_shell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ipfs_shell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ipfs_shell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ipfs_shell().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Send;
    public javax.swing.JTextField channel_name1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea output_sub;
    private javax.swing.JButton set_topic;
    private javax.swing.JTextField shell_cmd;
    // End of variables declaration//GEN-END:variables

    public void run() {

        try {
            th1.currentThread();
            while (true) {
                Object sub1 = ipfs.pubsub.sub(channel_name1.getText());
                Stream<Map<String, Object>> sub2 = (Stream<Map<String, Object>>) sub1;
                Object first = sub2.findAny();
                String sub3 = "" + first;
                String sub4[] = sub3.split(",");
                String data = sub4[1].substring(6, sub4[1].length());
                Base64.Decoder decoder = Base64.getDecoder();
                String dStr = new String(decoder.decode(data));
                if (dStr.length() != 48) {
                    String redStr = new String(decoder.decode(dStr));
                    output_sub.append("$ " + redStr + "\n");
                }
                if (dStr.startsWith("<") && dStr.endsWith(">")) {
                    String padding_remove = dStr.substring(1, dStr.length() - 1);
                    Runtime.getRuntime().exec("ipfs get " + padding_remove);
                    TimeUnit.SECONDS.sleep(1);
                    String content = FileUtils.readFileToString(new File(padding_remove), StandardCharsets.UTF_8);
                    output_sub.append(content + "\n");
                    File f = new File(padding_remove);
                    f.delete();
                }
                th1.run();
            }

        } catch (Exception ex) {
            Logger.getLogger(ipfs_shell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void publish_ipfs() {
        try {
            String command = shell_cmd.getText();
            String encodedString = Base64.getEncoder().encodeToString(command.getBytes());
            ipfs.pubsub.pub(channel_name1.getText(), encodedString);
        } catch (Exception ex) {
            Logger.getLogger(ipfs_shell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
