import java.lang.Runnable;
import java.lang.Exception;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Acheteur0 implements Runnable {
Thread ach;
Acheteur0(){
ach = new Thread(this,"nom a");
ach.start();}
    public void nom(){
    System.out.println("nom a");}

public static void main (String[]args){
Acheteur0 a = new Acheteur0();
    System.out.println("ddddd");
   
//a.run();

}

    @Override
    public void run() {
         System.out.println("ddddd2");
         //this.wait(2000);//this.Wait(10000);
        System.out.println("ddddd2");
        throw new UnsupportedOperationException("Not supported yet.");
         
    }
}
