/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

/**
 *
 * @author Anđela
 */
public interface Operation {
    public static final int REGISTER = 17;   
    public static final int LOGIN = 0;
    public static final int LOGOUT = 1;

    public static final int ADD_JELO = 2;
    public static final int DELETE_JELO = 3;
    public static final int UPDATE_JELO = 4;
    public static final int GET_ALL_JELO = 5;

    public static final int ADD_KLIJENT = 6;
    public static final int DELETE_KLIJENT = 7;
    public static final int UPDATE_KLIJENT = 8;
    public static final int GET_ALL_KLIJENT = 9;

    public static final int ADD_NARUDZBINA = 10;
    public static final int DELETE_NARUDZBINA = 11;
    public static final int UPDATE_NARUDZBINA = 12;
    public static final int GET_ALL_NARUDZBINA = 13;

    public static final int GET_ALL_STAVKA_NARUDZBINE = 14;

    public static final int GET_ALL_MESTO = 15;
    
    public static final int GET_ALL_POZICIJA = 16;

}
