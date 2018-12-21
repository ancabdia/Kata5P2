/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class Mail {
    private final String correo;
    
    public Mail(String correo){
        this.correo = correo;
    }

    public String getCorreo() {
        return correo.substring(correo.indexOf("@")+1, correo.length());
    }
    
}
