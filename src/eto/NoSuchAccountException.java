/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eto;

/**
 *
 * @author Paul
 */
public class NoSuchAccountException extends Exception {
    private long id;

    public NoSuchAccountException(long id, String message)
    {
        super(message);
        this.id = id;
    }

    public long getId()
    {
        return id;
    }
}
