/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroBDTeste;

/**
 *
 * @author User
 */
public class CadastroBDTeste {
    
}
package cadastro.model;

import java.util.List;

public class CadastroBDTeste {

    public static void main(String[] args) {
        // Testando operações com PessoaFisica
        System.out.println("### TESTE - PESSOA FÍSICA ###");

        // Instanciando e persistindo uma nova Pessoa Física
        PessoaFisica pessoaFisica = new PessoaFisica("João Silva", "Rua A", "Cidade A", "Estado A", "999999999", "joao.silva@email.com", "12345678900");
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.incluir(pessoaFisica);
        System.out.println("Pessoa Física incluída com sucesso!");

        // Alterando os dados da Pessoa Física
        pessoaFisica.setNome("João Silva Alterado");
        pessoaFisica.setTelefone("888888888");
        pessoaFisicaDAO.alterar(pessoaFisica);
        System.out.println("Pessoa Física alterada com sucesso!");

        // Consultando todas as pessoas físicas
        List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.getPessoas();
        System.out.println("### Lista de Pessoas Físicas: ###");
        for (PessoaFisica pf : pessoasFisicas) {
            System.out.println(pf);
        }

        // Excluindo a pessoa física
        pessoaFisicaDAO.excluir(pessoaFisica.getId());
        System.out.println("Pessoa Física excluída com sucesso!");

        
        // Testando operações com PessoaJuridica
        System.out.println("\n### TESTE - PESSOA JURÍDICA ###");

        // Instanciando e persistindo uma nova Pessoa Jurídica
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa ABC", "Av. B", "Cidade B", "Estado B", "777777777", "empresa.abc@email.com", "12345678000199");
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.incluir(pessoaJuridica);
        System.out.println("Pessoa Jurídica incluída com sucesso!");

        // Alterando os dados da Pessoa Jurídica
        pessoaJuridica.setNome("Empresa ABC Alterada");
        pessoaJuridica.setTelefone("666666666");
        pessoaJuridicaDAO.alterar(pessoaJuridica);
        System.out.println("Pessoa Jurídica alterada com sucesso!");

        // Consultando todas as pessoas jurídicas
        List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaDAO.getPessoas();
        System.out.println("### Lista de Pessoas Jurídicas: ###");
        for (PessoaJuridica pj : pessoasJuridicas) {
            System.out.println(pj);
        }

        // Excluindo a pessoa jurídica
        pessoaJuridicaDAO.excluir(pessoaJuridica.getId());
        System.out.println("Pessoa Jurídica excluída com sucesso!");
    }
}
package cadastro.model;

import java.util.List;

public class CadastroBDTeste {

    public static void main(String[] args) {
        // Testando operações com PessoaFisica
        System.out.println("### TESTE - PESSOA FÍSICA ###");

        // Instanciando e persistindo uma nova Pessoa Física
        PessoaFisica pessoaFisica = new PessoaFisica("João Silva", "Rua A", "Cidade A", "Estado A", "999999999", "joao.silva@email.com", "12345678900");
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.incluir(pessoaFisica);
        System.out.println("Pessoa Física incluída com sucesso!");

        // Alterando os dados da Pessoa Física
        pessoaFisica.setNome("João Silva Alterado");
        pessoaFisica.setTelefone("888888888");
        pessoaFisicaDAO.alterar(pessoaFisica);
        System.out.println("Pessoa Física alterada com sucesso!");

        // Consultando todas as pessoas físicas
        List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.getPessoas();
        System.out.println("### Lista de Pessoas Físicas: ###");
        for (PessoaFisica pf : pessoasFisicas) {
            System.out.println(pf);
        }

        // Excluindo a pessoa física
        pessoaFisicaDAO.excluir(pessoaFisica.getId());
        System.out.println("Pessoa Física excluída com sucesso!");

        
        // Testando operações com PessoaJuridica
        System.out.println("\n### TESTE - PESSOA JURÍDICA ###");

        // Instanciando e persistindo uma nova Pessoa Jurídica
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa ABC", "Av. B", "Cidade B", "Estado B", "777777777", "empresa.abc@email.com", "12345678000199");
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.incluir(pessoaJuridica);
        System.out.println("Pessoa Jurídica incluída com sucesso!");

        // Alterando os dados da Pessoa Jurídica
        pessoaJuridica.setNome("Empresa ABC Alterada");
        pessoaJuridica.setTelefone("666666666");
        pessoaJuridicaDAO.alterar(pessoaJuridica);
        System.out.println("Pessoa Jurídica alterada com sucesso!");

        // Consultando todas as pessoas jurídicas
        List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaDAO.getPessoas();
        System.out.println("### Lista de Pessoas Jurídicas: ###");
        for (PessoaJuridica pj : pessoasJuridicas) {
            System.out.println(pj);
        }

        // Excluindo a pessoa jurídica
        pessoaJuridicaDAO.excluir(pessoaJuridica.getId());
        System.out.println("Pessoa Jurídica excluída com sucesso!");
    }
}
