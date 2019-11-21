/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendap2p;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Steffenon
 */
public class Peer {
    protected String idPeer;
    protected Socket socket;
    
    protected Peer(){
        
    }

    public Peer(String idPeer, Socket socket) {
        this.idPeer = idPeer;
        this.socket = socket;
    }

    public String getIdPeer() {
        return idPeer;
    }

    public void setIdPeer(String idPeer) {
        this.idPeer = idPeer;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String toString(){
        return "ID: "+this.idPeer+" - IP:"+socket.getInetAddress();
    }
    
    
}
