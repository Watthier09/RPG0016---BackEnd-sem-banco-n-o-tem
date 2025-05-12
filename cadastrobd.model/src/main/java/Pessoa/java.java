/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pessoa;

/**
 *
 * @author User
 */
public class java {
    
}
package cadastrobd.model;

public class Pessoa {
    protected int id;
    protected String nome;
    protected String logradouro;
    protected String cidade;
    protected String estado;
    protected String telefone;
    protected String email;

    // Construtor padrão
    public Pessoa() {}

    // Construtor completo
    public Pessoa(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
    }

    // Método exibir - Para exibir os dados da pessoa
    public void exibir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + logradouro);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
    }
}
package cadastrobd.model;

public class PessoaFisica extends Pessoa {
    private String cpf;

    // Construtor padrão
    public PessoaFisica() {
        super();  // Chama o construtor da classe Pessoa
    }

    // Construtor completo
    public PessoaFisica(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cpf) {
        super(id, nome, logradouro, cidade, estado, telefone, email);  // Chama o construtor da classe Pessoa
        this.cpf = cpf;
    }

    // Sobrescrita do método exibir com polimorfismo
    @Override
    public void exibir() {
        super.exibir();  // Chama o método exibir da classe Pessoa
        System.out.println("CPF: " + cpf);
    }
}
package cadastrobd.model;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    // Construtor padrão
    public PessoaJuridica() {
        super();  // Chama o construtor da classe Pessoa
    }

    // Construtor completo
    public PessoaJuridica(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cnpj) {
        super(id, nome, logradouro, cidade, estado, telefone, email);  // Chama o construtor da classe Pessoa
        this.cnpj = cnpj;
    }

    // Sobrescrita do método exibir com polimorfismo
    @Override
    public void exibir() {
        super.exibir();  // Chama o método exibir da classe Pessoa
        System.out.println("CNPJ: " + cnpj);
    }
}
