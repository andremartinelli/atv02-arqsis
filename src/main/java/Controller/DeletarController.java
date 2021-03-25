/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import View.Deletar;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author andre
 */
public class DeletarController {

    private Deletar view;

    public DeletarController(Deletar view) {
        this.view = view;
    }

    public void remover() {
        int i = 0;
        Cliente aux = null;
        //pega os dados da view
        String login = view.getUsuarioText().getText();
        String senha = view.getSenhaText().getText();
        //busca dados no arquivo

        try {
            BufferedReader file = new BufferedReader(new FileReader("Cadastros.txt"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while ((line = file.readLine()) != null) {
                aux = montaCliente(line);

                if (!aux.getNome().equals(login) || !aux.getSenha().equals(senha)) {
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                } else {
                    view.exibeMensagem("Usuário Deletado!");

                }

            }
            file.close();

            FileOutputStream fileOut = new FileOutputStream("Cadastros.txt");
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }

        view.setVisible(false);
    }

    private Cliente montaCliente(String linha) {
        Cliente[] clientes;
        String[] desmontado = linha.split("&");

        return new Cliente(desmontado[0], desmontado[1], desmontado[2], desmontado[3], desmontado[4], desmontado[5], desmontado[6], desmontado[7], desmontado[8]);

    }

}
