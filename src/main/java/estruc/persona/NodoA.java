/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruc.persona;

import java.io.Serializable;

/**
 *
 * @author alan
 */
public class NodoA implements Serializable {
    
    Artista Dato;
    NodoA Sig;

    NodoA() {
        Sig = null;// estado inicial de un nodo
    }

    public Artista getDato() {
        return Dato;
    }

    public void setDato(Artista dato) {
        Dato = dato;
    }

    public NodoA getSig() {
        return Sig;
    }

    public void setSig(NodoA sig) {
        Sig = sig;
    }
}
