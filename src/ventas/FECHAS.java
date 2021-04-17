/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author AnToNiO
 */
public class FECHAS {
    Calendar calendario = new GregorianCalendar();
    
    public FECHAS(){
        
        }
    public String darHora(){
        
        String horafinal = "";
        String hora1 ="";
             String minuto1 ="";
             String segundo1 ="";
         int hor = calendario.get(Calendar.HOUR);
         int min = calendario.get(Calendar.MINUTE);
         int sec = calendario.get(Calendar.SECOND);
         if(hor<10){
             hora1 = "0"+String.valueOf(hor);
            }else{hora1 = String.valueOf(hor);}
         if(min<10){
             minuto1 = "0"+String.valueOf(min);
            }else{minuto1 = String.valueOf(min);}
         if(sec<10){
            segundo1 = "0"+String.valueOf(sec);
            }else{segundo1 = String.valueOf(sec);}
         horafinal = hora1+":"+minuto1+":"+segundo1;
         
         return horafinal;
    }
        public String darHoraAP(){
        String AP="";
        String horafinal = "";
        String hora1 ="";
             String minuto1 ="";
             String segundo1 ="";
         int hor = calendario.get(Calendar.HOUR);
         int min = calendario.get(Calendar.MINUTE);
         int sec = calendario.get(Calendar.SECOND);
         if(hor<10){
             hora1 = "0"+String.valueOf(hor);
            }else{hora1 = String.valueOf(hor);}
         if(min<10){
             minuto1 = "0"+String.valueOf(min);
            }else{minuto1 = String.valueOf(min);}
         if(sec<10){
            segundo1 = "0"+String.valueOf(sec);
            }else{segundo1 = String.valueOf(sec);}
         horafinal = hora1+":"+minuto1+" ";
         if(calendario.get(Calendar.AM_PM)==0){
         AP="am";
         }else{
         AP="pm";
         }
         return horafinal+AP;
    }
    
   public String darFecha(){
        
        String horafinal = "";
        String hora1 ="";
             String minuto1 ="";
             String segundo1 ="";
         int hor = calendario.get(Calendar.DATE);
         int min = calendario.get(Calendar.MONTH)+1;
         int sec = calendario.get(Calendar.YEAR);
         if(hor<10){
             hora1 = "0"+String.valueOf(hor);
            }else{hora1 = String.valueOf(hor);}
         if(min<10){
             minuto1 = "0"+String.valueOf(min);
            }else{minuto1 = String.valueOf(min);}
        segundo1 = String.valueOf(sec);
         horafinal = segundo1+"-"+minuto1+"-"+hora1;
         
         return horafinal;
    }
       public String darHoraSinPunt(){
        
        String horafinal = "";
        String hora1 ="";
             String minuto1 ="";
             String segundo1 ="";
         int hor = calendario.get(Calendar.HOUR);
         int min = calendario.get(Calendar.MINUTE);
         int sec = calendario.get(Calendar.SECOND);
         if(hor<10){
             hora1 = "0"+String.valueOf(hor);
            }else{hora1 = String.valueOf(hor);}
         if(min<10){
             minuto1 = "0"+String.valueOf(min);
            }else{minuto1 = String.valueOf(min);}
         if(sec<10){
            segundo1 = "0"+String.valueOf(sec);
            }else{segundo1 = String.valueOf(sec);}
         horafinal = hora1+"-"+minuto1+"-"+segundo1;
         
         return horafinal;
    }
}
