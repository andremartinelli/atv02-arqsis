/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import View.Alterar;
import View.Logado;
import javax.swing.JTextArea;

/**
 *
 * @author andre
 */
public class LogadoController {

    private Logado view;
    private Alterar viewAlterar;
    private Cliente cliente;

    public LogadoController(Logado view) {
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

    public void showAlterarView() {
        viewAlterar = new Alterar();
        viewAlterar.setVisible(true);
        view.setVisible(false);
        viewAlterar.preencheCliente(this.cliente);
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

}
