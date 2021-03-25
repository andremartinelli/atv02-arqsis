/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Cadastrar;
import View.Deletar;
import View.Login;
import View.Menu;

/**
 *
 * @author andre
 */
public class MenuController {
        private final Menu menuView;


    public MenuController(Menu menuView) {
        this.menuView = menuView;
    }
    
    public void showLoginView(){
        new Login().setVisible(true);
    }
    
    public void showCadastroView(){
        new Cadastrar().setVisible(true);
    }
    
    public void showDeletarView(){
        new Deletar().setVisible(true);
    }
        
        

}
