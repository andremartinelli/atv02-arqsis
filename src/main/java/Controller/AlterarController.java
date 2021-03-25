/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import View.Alterar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
/**
 *
 * @author andre
 */
public class AlterarController {

    private Alterar view;
    private Cliente cliente;

    public AlterarController(Alterar view) {
        this.view = view;
    }

    public void preencheCliente(Cliente cliente) {
        view.getNomeText().setText(cliente.getNome());
        view.getSobrenomeText().setText(cliente.getSobrenome());
        view.getEmailText().setText(cliente.getEmail());
        view.getDataNascText().setText(cliente.getDataNasc());
        view.getCpfText().setText(cliente.getCpf());
        view.getMatriculaText().setText(cliente.getMatricula());
        view.getIdadeText().setText(cliente.getIdade());
        view.getProfissaoText().setText(cliente.getProfissao());
        view.getSenhaText().setText(cliente.getSenha());
        salvaCliente();
    }

    private void salvaCliente() {
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
    }

    private String getStringClienteAntigo() {
        String clienteAntigo = "";
        clienteAntigo = clienteAntigo.concat(cliente.getNome());
        clienteAntigo = clienteAntigo.concat("&");
        clienteAntigo = clienteAntigo.concat(cliente.getSobrenome());
        clienteAntigo = clienteAntigo.concat("&");
        clienteAntigo = clienteAntigo.concat(cliente.getEmail());
        clienteAntigo = clienteAntigo.concat("&");
        clienteAntigo = clienteAntigo.concat(cliente.getDataNasc());
        clienteAntigo = clienteAntigo.concat("&");
        clienteAntigo = clienteAntigo.concat(cliente.getCpf());
        clienteAntigo = clienteAntigo.concat("&");
        clienteAntigo = clienteAntigo.concat(cliente.getMatricula());
        clienteAntigo = clienteAntigo.concat("&");
        clienteAntigo = clienteAntigo.concat(cliente.getIdade());
        clienteAntigo = clienteAntigo.concat("&");
        clienteAntigo = clienteAntigo.concat(cliente.getProfissao());
        clienteAntigo = clienteAntigo.concat("&");
        clienteAntigo = clienteAntigo.concat(cliente.getSenha());

        return clienteAntigo;
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

    private String getStringClienteNovo() {
        String nome = view.getNomeText().getText().trim();
        String sobrenome = view.getSobrenomeText().getText().trim();
        String email = view.getEmailText().getText().trim();
        String dataNasc = view.getDataNascText().getText().trim();
        String cpf = view.getCpfText().getText().trim();
        String matricula = view.getMatriculaText().getText().trim();
        String idade = view.getIdadeText().getText().trim();
        String profissao = view.getProfissaoText().getText().trim();
        String senha = view.getSenhaText().getText().trim();
        
        if(!validaDadosCliente(new Cliente(nome, sobrenome, email, dataNasc, cpf, matricula, idade, profissao, senha))){
            return "";
        }

        String insere = "";
        insere = insere.concat(nome);
        insere = insere.concat("&");
        insere = insere.concat(sobrenome);
        insere = insere.concat("&");
        insere = insere.concat(email);
        insere = insere.concat("&");
        insere = insere.concat(dataNasc);
        insere = insere.concat("&");
        insere = insere.concat(cpf);
        insere = insere.concat("&");
        insere = insere.concat(matricula);
        insere = insere.concat("&");
        insere = insere.concat(idade);
        insere = insere.concat("&");
        insere = insere.concat(profissao);
        insere = insere.concat("&");
        insere = insere.concat(senha);

        return insere;

    }

    public Boolean alterar() throws FileNotFoundException, IOException {
        String clienteNovo = getStringClienteNovo();
        String clienteAntigo = getStringClienteAntigo();
        
        if(clienteNovo.equals("")){
            return false;
        }

        try {
        BufferedReader file = new BufferedReader(new FileReader("Cadastros.txt"));
        StringBuffer inputBuffer = new StringBuffer();
        String line;

        while ((line = file.readLine()) != null) {
            if(line.equals(clienteAntigo)){
                line = clienteNovo;
            }
            inputBuffer.append(line);
            inputBuffer.append('\n');
        }
        file.close();

        FileOutputStream fileOut = new FileOutputStream("Cadastros.txt");
        fileOut.write(inputBuffer.toString().getBytes());
        fileOut.close();

    } catch (Exception e) {
        System.out.println("Problem reading file.");
    }
        
        return true;
    }
}
