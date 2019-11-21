/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendap2p;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Steffenon
 */
public class Servidor {

    protected static String idPeer;
    protected ObjectOutputStream saida;
    protected ObjectInputStream entrada;
    protected boolean sair = false;
    protected String mensagem = "Conectado";
    protected static List<Peer> listaPeers = new ArrayList<Peer>();
    protected static List<ContatoE> meusContatos = new ArrayList<ContatoE>();
    protected static List<ContatoE> contatosBuscados = new ArrayList<ContatoE>();

    public Servidor() {

    }

    public boolean iniciar(int porta, String idPeer) {
        this.idPeer = idPeer;
        try {
            // Instancia o ServerSocket ouvindo a porta 12345
            ServerSocket servidor = new ServerSocket(porta);
            System.out.println("Servidor ouvindo a porta: " + porta);

            while (true) {
                // o método accept() bloqueia a execução até que
                // o servidor receba um pedido de conexão

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                }

                Socket cliente;
                cliente = servidor.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //consultaThread(cliente);
                            executarThread(cliente);
                        } catch (IOException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (NoSuchAlgorithmException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }).start();

                //return true;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return true;
    }

    public void executarThread(Socket cliente) throws IOException, SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        System.out.println("Peer comunicando: " + cliente.getInetAddress().getHostAddress());
        String ret = "";
        //ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
        //ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
        DataInputStream entrada = new DataInputStream(cliente.getInputStream());
        DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());

        //this.recebe = (RequisicaoER) entrada.readObject();
        String entradaS = entrada.readUTF();
        String aux[] = entradaS.split(";");

        switch (aux[0]) {

            case "conectar":
                System.out.println("Novo peer " + aux[1]);
                inserirPeer(aux[1], cliente);
                ret = "rconectar;s;"+this.idPeer;
                break;

            case "buscar":
                System.out.println("Peer:" + aux[1]+" Buscando contato "+aux[2]);
                ret = buscarContato(aux[2]);
                break;
                
            case "atualizarpeers":
                System.out.println("Peer:" + aux[1]+" Atualizando lista de peers ");
                ret = buscarListaPeers();
                break;

        }

        saida.writeUTF(ret);

        saida.flush();

        entrada.close();

        saida.close();
    }

    public ObjectOutputStream getSaida() {
        return saida;
    }

    public void setSaida(ObjectOutputStream saida) {
        this.saida = saida;
    }

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public void setEntrada(ObjectInputStream entrada) {
        this.entrada = entrada;
    }

    public boolean isSair() {
        return sair;
    }

    public void setSair(boolean sair) {
        this.sair = sair;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public static List<Peer> getListaPeers() {
        return listaPeers;
    }

    public static void setListaPeers(List<Peer> listaPeers) {
        Servidor.listaPeers = listaPeers;
    }
    
    public void inserirPeer(String id, Socket sPeer){
        boolean tem = false;
        for(int i=0; i<listaPeers.size(); i++){
            if(listaPeers.get(i).getIdPeer().equalsIgnoreCase(id)){
                tem=true;
                Peer p = new Peer(id, sPeer);
                listaPeers.set(i, p);
            }
        }
        if(tem==false){
            Peer p = new Peer(id, sPeer);
            listaPeers.add(p);
        }
         
    }
    
    public String buscarContato(String nomeContato){
        String retorno = "";
        int pos=-1;
        for(int i=0; i<meusContatos.size(); i++){
            if(meusContatos.get(i).getNome().equalsIgnoreCase(nomeContato)){
                pos = i;
            }
        }
        if(pos!=-1){
            retorno+="retornoB;s;"+meusContatos.get(pos).nome+";"+meusContatos.get(pos).getTelefone()+";"+meusContatos.get(pos).getCidade()+";"+meusContatos.get(pos).getCriador();
        }else{
            retorno+="retornoB;n;";
        }
        return retorno;
    }
    
    public String buscarListaPeers(){
        String retorno = ""; 
        retorno+="retornoAP;"+this.listaPeers.size();
        for(int i=0; i<this.listaPeers.size();i++){
            retorno+=";"+this.listaPeers.get(i).getIdPeer()+";"+this.listaPeers.get(i).getSocket().getInetAddress();
        }
        return retorno;
    }

    public static String getIdPeer() {
        return idPeer;
    }

    public static void setIdPeer(String idPeer) {
        Servidor.idPeer = idPeer;
    }

    public static List<ContatoE> getMeusContatos() {
        return meusContatos;
    }

    public static void setMeusContatos(List<ContatoE> meusContatos) {
        Servidor.meusContatos = meusContatos;
    }

    public static List<ContatoE> getContatosBuscados() {
        return contatosBuscados;
    }

    public static void setContatosBuscados(List<ContatoE> contatosBuscados) {
        Servidor.contatosBuscados = contatosBuscados;
    }

    
}
