/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepan_ms;

import jframe.LoadingPage;
import static jframe.LoadingPage.lblloard;
import static jframe.LoadingPage.loadbar;
import jframe.loginPage;
import jframe.signin;


/**
 *
 * @author deepankumar
 */
public class Deepan_ms {

    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    LoadingPage ld=new LoadingPage();
          ld.setVisible(true);
     try
        {
            for(int x=0;x<=100;x++)
            {
                 Thread.sleep(100);
                lblloard.setText(x+"%");
                loadbar.setValue(x);
              if(x==100)
              {
                  loginPage home=new loginPage();
                  home.setVisible(true);
                  
                  ld.hide();
                  
              }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
        // TODO code application logic here
    }
    
