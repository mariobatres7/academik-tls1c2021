package edu.telus.primer.soap.cliente;

import java.util.List;

/**
 *
 * @author Mario Batres
 */
public class Main {
    
    public static void main(String[] args) {
        
        UsuarioWebservice ws = new UsuarioWebservice();
                
        List<Usuario_Type> usuarioList = ws.getUsuarioPort().findUsuarios();
        
        usuarioList.forEach(usuarioType -> {
            
            System.out.print(usuarioType.getUsuarioId() + "\t");
            System.out.print(usuarioType.getNombre() + "\t");
            System.out.print(usuarioType.getUsuarioNombre() + "\t");            
            System.out.println(usuarioType.getContrasenya());
            System.out.println();
        });
        
    }
    
}
