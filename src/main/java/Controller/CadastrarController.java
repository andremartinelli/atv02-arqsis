/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import View.Cadastrar;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author andre
 */
public class CadastrarController {

    private Cadastrar view;
    private Cliente cliente;

    public CadastrarController(Cadastrar view) {
        this.view = view;
    }

    private Boolean getDadosCliente() {
        String nome = view.getNomeText().getText().trim();
        String sobrenome = view.getSobrenomeText().getText().trim();
        String email = view.getEmailText().getText().trim();
        String dataNasc = view.getDataNascText().getText().trim();
        String cpf = view.getCpfText().getText().trim();
        String matricula = view.getMatriculaText().getText().trim();
        String idade = view.getIdadeText().getText().trim();
        String profissao = view.getProfissaoText().getText().trim();
        String senha = view.getSenhaText().getText().trim();

        cliente = new Cliente(nome, sobrenome, email, dataNasc, cpf, matricula, idade, profissao, senha);
        return validaDadosCliente(cliente);
    }

    public Boolean cadastra() {
        //recebe os dados da view
        if (!getDadosCliente()) {
            return false;
        }
        //grava os dados em texto
        gravaDadosCliente();
        view.setVisible(false);

        return true;
    }

    private void gravaDadosCliente() {
        try {
            FileWriter writer = new FileWriter("Cadastros.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(transformaClienteString());
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String transformaClienteString() {
        String insere = "";
        insere = insere.concat(cliente.getNome());
        insere = insere.concat("&");
        insere = insere.concat(cliente.getSobrenome());
        insere = insere.concat("&");
        insere = insere.concat(cliente.getEmail());
        insere = insere.concat("&");
        insere = insere.concat(cliente.getDataNasc());
        insere = insere.concat("&");
        insere = insere.concat(cliente.getCpf());
        insere = insere.concat("&");
        insere = insere.concat(cliente.getMatricula());
        insere = insere.concat("&");
        insere = insere.concat(cliente.getIdade());
        insere = insere.concat("&");
        insere = insere.concat(cliente.getProfissao());
        insere = insere.concat("&");
        insere = insere.concat(cliente.getSenha());

        return insere;
    }

    private Boolean validaDadosCliente(Cliente cliente) {
        if("".equals(cliente.getNome()) || cliente.getNome() == null){
           view.exibeMensagem("Preencha o nome de usuário!"); 
           return false;
        }
        
        if("".equals(cliente.getSenha()) || cliente.getSenha() == null){
           view.exibeMensagem("Preencha a senha!"); 
           return false;
        }
        
        if (cliente.getNome().contains("&")) {
            view.exibeMensagem("Nome não aceita o caractere '&'");
            return false;
        }
        
        if (cliente.getSobrenome().contains("&")) {
            view.exibeMensagem("Sobrenome não aceita o caractere '&'");
            return false;
        }
        
        if (cliente.getEmail().contains("&")) {
            view.exibeMensagem("Email não aceita o caractere '&'");
            return false;
        }
        
        if (cliente.getDataNasc().contains("&")) {
            view.exibeMensagem("Data de Nascimento não aceita o caractere '&'");
            return false;
        }
        
        if (cliente.getCpf().contains("&")) {
            view.exibeMensagem("CPF não aceita o caractere '&'");
            return false;
        }
        
        if (cliente.getMatricula().contains("&")) {
            view.exibeMensagem("Matricula não aceita o caractere '&'");
            return false;
        }
        
        if (cliente.getIdade().contains("&")) {
            view.exibeMensagem("Idade não aceita o caractere '&'");
            return false;
        }
        
        if (cliente.getProfissao().contains("&")) {
            view.exibeMensagem("Profissão não aceita o caractere '&'");
            return false;
        }
        
        if (cliente.getSenha().contains("&")) {
            view.exibeMensagem("Senha não aceita o caractere '&'");
            return false;
        }

        return true;
    }

}
