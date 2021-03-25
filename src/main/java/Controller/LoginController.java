/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import View.Logado;
import View.Login;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class LoginController {
    private final Login view;
    private final Logado viewLogado;
    
    public LoginController(Login view) {
        this.view = view;
        this.viewLogado = new Logado();
    }
    
    public void teste(){
        this.view.exibeMensagem("Executei fiz tarefa");
    }
    
    public void buscaDadosCliente(){
        int i = 0;
        Cliente aux = null;
        //pega os dados da view
        String login = view.getUsuarioText().getText();
        String senha = view.getSenhaText().getText();
        //busca dados no arquivo
        
        try{
            FileReader reader = new FileReader("Cadastros.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            
            String linha;
            while((linha = bufferedReader.readLine())!= null){
                aux = montaCliente(linha);
                if(aux.getNome().equals(login) && aux.getSenha().equals(senha)){
                    viewLogado.setVisible(true);
                    viewLogado.preencheCliente(aux);
                    return;
                }
            }
            view.exibeMensagem("Usuário não encontrado!");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
            
        private Cliente montaCliente(String linha){
            Cliente[] clientes;
            String[] desmontado = linha.split("&");
            
            return new Cliente(desmontado[0],desmontado[1],desmontado[2],desmontado[3],desmontado[4],desmontado[5],desmontado[6],desmontado[7],desmontado[8]);
            

       }

    
    
}
