/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendap2p;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Steffenon
 */
public class Main extends javax.swing.JFrame {

    protected static String idPeer;
    protected static int porta = 8099;
    protected static Servidor serv1 = new Servidor();
    protected static Thread servicoServidor;

    /**
     * Creates new form Main
     */
    public Main(String idPeer) {
        this.idPeer = idPeer;
        
        servicoServidor = new Thread(new Runnable() {
            @Override
            public void run() {
                serv1.iniciar(porta, idPeer);
            }
        });
        servicoServidor.start();
        initComponents();
        this.l_contatos_locais.removeAll();
        this.l_contatos_rede.removeAll();
        this.l_peers_conectados.removeAll();
        this.v_nome_peer.setText(idPeer);
        //System.out.print("sssssssssssss");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_conectar = new javax.swing.JButton();
        b_buscar = new javax.swing.JButton();
        b_inserir_novo_contato = new javax.swing.JButton();
        c_ip_conectar = new javax.swing.JTextField();
        c_buscar_contato = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        l_contatos_locais = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        l_contatos_rede = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        c_nome_novo_contato = new javax.swing.JTextField();
        c_telefone_novo_contato = new javax.swing.JTextField();
        c_cidade_novo_contato = new javax.swing.JTextField();
        v_nome_peer = new javax.swing.JLabel();
        b_baixar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        l_peers_conectados = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        b_listar_peers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        b_conectar.setText("Conectar");
        b_conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_conectarActionPerformed(evt);
            }
        });

        b_buscar.setText("Buscar Contato");
        b_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_buscarActionPerformed(evt);
            }
        });

        b_inserir_novo_contato.setText("Inserir");
        b_inserir_novo_contato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_inserir_novo_contatoActionPerformed(evt);
            }
        });

        c_buscar_contato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_buscar_contatoActionPerformed(evt);
            }
        });

        l_contatos_locais.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(l_contatos_locais);

        jLabel2.setText("Meus contatos");

        jLabel3.setText("Contatos disponiveis na rede");

        l_contatos_rede.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(l_contatos_rede);

        jLabel1.setText("Inserir novo contato");

        jLabel4.setText("Nome");

        jLabel5.setText("Telefone");

        jLabel6.setText("Cidade");

        v_nome_peer.setText("Nome do peer");

        b_baixar.setText("Baixar");
        b_baixar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_baixarActionPerformed(evt);
            }
        });

        l_peers_conectados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(l_peers_conectados);

        jLabel7.setText("Peers conectados na rede");

        b_listar_peers.setText("Listar Peers");
        b_listar_peers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_listar_peersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(v_nome_peer)
                        .addGap(264, 264, 264))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(b_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b_conectar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(c_ip_conectar)
                                .addComponent(c_buscar_contato, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(b_inserir_novo_contato, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel4))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(c_telefone_novo_contato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                                        .addComponent(c_nome_novo_contato, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(c_cidade_novo_contato))))
                                            .addGap(0, 0, Short.MAX_VALUE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(97, 97, 97))
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(b_baixar)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(b_listar_peers))))
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(v_nome_peer)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_conectar)
                            .addComponent(c_ip_conectar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_listar_peers))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_buscar)
                            .addComponent(c_buscar_contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_baixar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(c_nome_novo_contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(c_telefone_novo_contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(c_cidade_novo_contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(b_inserir_novo_contato))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c_buscar_contatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_buscar_contatoActionPerformed

    }//GEN-LAST:event_c_buscar_contatoActionPerformed

    private void b_inserir_novo_contatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_inserir_novo_contatoActionPerformed
        ContatoE novo = new ContatoE(this.c_nome_novo_contato.getText(), this.c_telefone_novo_contato.getText(), this.c_cidade_novo_contato.getText(), this.idPeer);
        this.serv1.meusContatos.add(novo);
        atualizarListas();
    }//GEN-LAST:event_b_inserir_novo_contatoActionPerformed

    private void b_conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_conectarActionPerformed
        String ipDestino = this.c_ip_conectar.getText();
        try {
            Socket cliente = new Socket(ipDestino, porta);
            DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
            DataInputStream in = new DataInputStream(cliente.getInputStream());
            out.writeUTF("conectar;" + idPeer);
            out.flush();
            String retorno = in.readUTF();
            if (retorno.split(";")[1].equalsIgnoreCase("s")) {
                Peer novo = new Peer(retorno.split(";")[2], cliente);
                this.serv1.listaPeers.add(novo);
            }

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b_conectarActionPerformed

    public void sincronizarListaPeer(List<String> lista) throws IOException {

        for (int i = 0; i < lista.size(); i++) {
            boolean condicao = false;
            int pos = -1;
            for (int j = 0; j < this.serv1.listaPeers.size(); j++) {
                if (this.serv1.listaPeers.get(j).getIdPeer().equalsIgnoreCase(lista.get(i).split(";")[0])) {
                   condicao=true;
                   pos = j;
                }
            }
            if(condicao==false){
                Socket s = new Socket(lista.get(i).split(";")[1].replace("/", ""), porta);
                Peer novo = new Peer(lista.get(i).split(";")[0], s);
                this.serv1.listaPeers.add(novo);
            }else{
                Socket s = new Socket(lista.get(i).split(";")[1].replace("/", ""), porta);
                this.serv1.listaPeers.get(pos).setSocket(s);
            }
        }

    }

    private void b_listar_peersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_listar_peersActionPerformed

        List<String> listaAuxiliar = new ArrayList<String>();

        for (int i = 0; i < this.serv1.listaPeers.size(); i++) {
            if (!serv1.listaPeers.get(i).getIdPeer().equalsIgnoreCase(this.idPeer)) {
                Socket cliente;
                try {
                    cliente = new Socket(serv1.listaPeers.get(i).getSocket().getInetAddress(), porta);
                    DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
                    DataInputStream in = new DataInputStream(cliente.getInputStream());
                    out.writeUTF("atualizarpeers;" + idPeer);
                    out.flush();
                    String retorno = in.readUTF();
                    if (!retorno.split(";")[1].equalsIgnoreCase("0")) {
                        String auxR[] = retorno.split(";");
                        for (int j = 0; j < Integer.parseInt(auxR[1]); j++) {
                            listaAuxiliar.add(auxR[j + 2] + ";" + auxR[j + 3]);
                        }

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        try {
            sincronizarListaPeer(listaAuxiliar);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.l_peers_conectados.removeAll();
        String aux[] = new String[serv1.getListaPeers().size()];
        for (int i = 0; i < serv1.getListaPeers().size(); i++) {
            aux[i] = serv1.getListaPeers().get(i).toString();
        }
        this.l_peers_conectados.setModel(new javax.swing.AbstractListModel<String>() {

            String[] strings = aux;

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
    }//GEN-LAST:event_b_listar_peersActionPerformed

    private void b_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_buscarActionPerformed
        String nomeBuscar = this.c_buscar_contato.getText();
        serv1.contatosBuscados = new ArrayList<ContatoE>();
        for (int i = 0; i < this.serv1.listaPeers.size(); i++) {
            if (!serv1.listaPeers.get(i).getIdPeer().equalsIgnoreCase(this.idPeer)) {
                Socket cliente;
                try {
                    cliente = new Socket(serv1.listaPeers.get(i).getSocket().getInetAddress(), porta);
                    DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
                    DataInputStream in = new DataInputStream(cliente.getInputStream());
                    out.writeUTF("buscar;" + idPeer + ";" + nomeBuscar);
                    out.flush();
                    String retorno = in.readUTF();
                    if (retorno.split(";")[1].equalsIgnoreCase("s")) {
                        String auxR[] = retorno.split(";");
                        ContatoE novo = new ContatoE(auxR[2], auxR[3], auxR[4], auxR[5]);
                        serv1.contatosBuscados.add(novo);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        atualizarListas();
    }//GEN-LAST:event_b_buscarActionPerformed

    private void b_baixarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_baixarActionPerformed
        int pos = this.l_contatos_rede.getSelectedIndex();
        serv1.meusContatos.add(serv1.contatosBuscados.get(pos));
        serv1.contatosBuscados = new ArrayList<ContatoE>();
        atualizarListas();
    }//GEN-LAST:event_b_baixarActionPerformed

    public void atualizarListas() {
        //Lista peers
        this.l_peers_conectados.removeAll();
        String aux[] = new String[serv1.getListaPeers().size()];
        for (int i = 0; i < serv1.getListaPeers().size(); i++) {
            aux[i] = serv1.getListaPeers().get(i).toString();
        }
        this.l_peers_conectados.setModel(new javax.swing.AbstractListModel<String>() {

            String[] strings = aux;

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });

        //Lista contatos disponiveis
        this.l_contatos_rede.removeAll();
        String auxR[] = new String[serv1.getContatosBuscados().size()];
        for (int i = 0; i < serv1.getContatosBuscados().size(); i++) {
            auxR[i] = serv1.getContatosBuscados().get(i).toString();
        }
        this.l_contatos_rede.setModel(new javax.swing.AbstractListModel<String>() {

            String[] strings = auxR;

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });

        //Lista contatos locais
        this.l_contatos_locais.removeAll();
        String auxM[] = new String[serv1.getMeusContatos().size()];
        for (int i = 0; i < serv1.getMeusContatos().size(); i++) {
            auxM[i] = serv1.getMeusContatos().get(i).toString();
        }
        this.l_contatos_locais.setModel(new javax.swing.AbstractListModel<String>() {

            String[] strings = auxM;

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
    }

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main(args[0]).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_baixar;
    private javax.swing.JButton b_buscar;
    private javax.swing.JButton b_conectar;
    private javax.swing.JButton b_inserir_novo_contato;
    private javax.swing.JButton b_listar_peers;
    private javax.swing.JTextField c_buscar_contato;
    private javax.swing.JTextField c_cidade_novo_contato;
    private javax.swing.JTextField c_ip_conectar;
    private javax.swing.JTextField c_nome_novo_contato;
    private javax.swing.JTextField c_telefone_novo_contato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList l_contatos_locais;
    private javax.swing.JList l_contatos_rede;
    private javax.swing.JList l_peers_conectados;
    private javax.swing.JLabel v_nome_peer;
    // End of variables declaration//GEN-END:variables
}