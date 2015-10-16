
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulo.matias
 */
public class ClienteForm extends javax.swing.JFrame {

    /**
     * Creates new form ClienteForm
     */
    public ClienteForm() {
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

        btnList = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnWrite = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConteudo = new javax.swing.JTextArea();
        txtNomeArquivo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ListaArquivos = new javax.swing.JScrollPane();
        listArquivos = new javax.swing.JList();
        btnNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnList.setText("List");
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        btnRead.setText("Read");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnWrite.setText("Write");
        btnWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWriteActionPerformed(evt);
            }
        });

        txtConteudo.setColumns(20);
        txtConteudo.setRows(5);
        jScrollPane1.setViewportView(txtConteudo);

        jLabel1.setText("Nome:");

        listArquivos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listArquivos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListaArquivos.setViewportView(listArquivos);

        btnNovo.setText("New!");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ListaArquivos, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRead, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnWrite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(txtNomeArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRead)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnWrite))
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(ListaArquivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        // Preencher a lista de arquivos existentes
        try{
            Socket client = new Socket("localhost",20000);
            client.setKeepAlive(true);
            ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
            
            ArrayList<String> arq_nomes = new ArrayList();
            
            //nao feito ainda..............
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btnListActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        // Exibe conteudo de arquivo
         try{
            Socket cli = new Socket("localhost",20000);
            cli.setKeepAlive(true);
            ObjectOutputStream output = new ObjectOutputStream(cli.getOutputStream());
            
           String nome_arq = txtNomeArquivo.getText();           
           
            Requisicao req = new Requisicao();
            req.set_message_content(Requisicao.PEGA_ARQUIVO);
            req.set_nome_arquivo(nome_arq);     //<<--procura por esse nome de arq
            
            output.writeObject(req);
            
            ObjectInputStream input = new ObjectInputStream(cli.getInputStream());
            Resposta rep = (Resposta)input.readObject();
            if (rep.get_message_content()== Resposta.ARQUIVO_NAO_ENCONTRADO){
                JOptionPane.showMessageDialog(this,"File not found");
            }
            else{
                JOptionPane.showMessageDialog(this, "Encontrado!!!");
                txtConteudo.setText(rep.get_arquivo());  //Exibe conteudo do arquivo achado
               
            }
            
            output.close();
            input.close();
            cli.close();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWriteActionPerformed
        // Sobrescreve ou atualiza conteudo de um arquivo
    }//GEN-LAST:event_btnWriteActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // Add novo arquivo para algum servidor
       
        try {
            Socket client;
            client = new Socket("localhost", 20000);
            client.setKeepAlive(true);
            ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
            
            Requisicao req = new Requisicao();
            req.set_conteudo(txtConteudo.getText());
            req.set_nome_arquivo(txtNomeArquivo.getText());
            
            req.set_message_content(Requisicao.NOVO_ARQUIVO);
            
           output.writeObject(req);
           JOptionPane.showMessageDialog(this, "Sending message..");
           
            ObjectInputStream  input  = new ObjectInputStream(client.getInputStream());
            Resposta rep = (Resposta)input.readObject();
            
            JOptionPane.showMessageDialog(this, "..Message Received");
            if (rep.get_message_content()== Resposta.ARQUIVO_ESCRITO_COM_SUCESSO){
                JOptionPane.showMessageDialog(this,"Arquivo Criado com sucesso!");
                listArquivos.add(txtNomeArquivo.getText(), null);                  //arquivo item na lista
            }
            else{
                JOptionPane.showMessageDialog(this, "Tentativa Fail de criação...");
            }
            output.close();
            input.close();
            client.close();
            
        } catch (Exception ex) {
           ex.printStackTrace();
        }
            
        txtConteudo.setText("");
        txtNomeArquivo.setText("");       
        
                
    }//GEN-LAST:event_btnNovoActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ListaArquivos;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnWrite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listArquivos;
    private javax.swing.JTextArea txtConteudo;
    private javax.swing.JTextField txtNomeArquivo;
    // End of variables declaration//GEN-END:variables
}
