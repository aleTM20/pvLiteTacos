/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author pv_lite_team
 */
public class ExceptionPvLite extends Exception{
    
    private String causeMessage;
    
    public ExceptionPvLite(String message, String causeMessage){
        super(message);
        this.causeMessage = causeMessage;
    }

    public String getCauseMessage() {
        return causeMessage;
    }

    public void setCauseMessage(String causeMessage) {
        this.causeMessage = causeMessage;
    }
    
    
    
}
