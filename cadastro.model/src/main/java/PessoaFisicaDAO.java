/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class PessoaFisicaDAO {
    
}
package cadastro.model;

import cadastro.model.util.ConectorBD;
import cadastro.model.util.SequenceManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {

    // Método para obter uma pessoa física pelo ID
    public PessoaFisica getPessoa(int id) {
        String sql = "SELECT * FROM Pessoa p JOIN PessoaFisica pf ON p.id = pf.id WHERE p.id = ?";
        try (Connection connection = ConectorBD.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Montando o objeto PessoaFisica com dados do banco
                return new PessoaFisica(
                        resultSet.getInt("p.id"),
                        resultSet.getString("p.nome"),
                        resultSet.getString("p.logradouro"),
                        resultSet.getString("p.cidade"),
                        resultSet.getString("p.estado"),
                        resultSet.getString("p.telefone"),
                        resultSet.getString("p.email"),
                        resultSet.getString("pf.cpf")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Se não encontrado
    }

    // Método para obter todas as pessoas físicas
    public List<PessoaFisica> getPessoas() {
        String sql = "SELECT * FROM Pessoa p JOIN PessoaFisica pf ON p.id = pf.id";
        List<PessoaFisica> pessoas = new ArrayList<>();

        try (Connection connection = ConectorBD.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                // Montando o objeto PessoaFisica com dados do banco
                pessoas.add(new PessoaFisica(
                        resultSet.getInt("p.id"),
                        resultSet.getString("p.nome"),
                        resultSet.getString("p.logradouro"),
                        resultSet.getString("p.cidade"),
                        resultSet.getString("p.estado"),
                        resultSet.getString("p.telefone"),
                        resultSet.getString("p.email"),
                        resultSet.getString("pf.cpf")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    // Método para incluir uma nova pessoa física
    public void incluir(PessoaFisica pessoaFisica) {
        String sqlPessoa = "INSERT INTO Pessoa (nome, logradouro, cidade, estado, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlPessoaFisica = "INSERT INTO PessoaFisica (id, cpf) VALUES (?, ?)";

        try (Connection connection = ConectorBD.getConnection()) {
            // Iniciando transação
            connection.setAutoCommit(false);

            // Inserir dados na tabela Pessoa
            try (PreparedStatement preparedStatementPessoa = ConectorBD.getPrepared(connection, sqlPessoa)) {
                preparedStatementPessoa.setString(1, pessoaFisica.getNome());
                preparedStatementPessoa.setString(2, pessoaFisica.getLogradouro());
                preparedStatementPessoa.setString(3, pessoaFisica.getCidade());
                preparedStatementPessoa.setString(4, pessoaFisica.getEstado());
                preparedStatementPessoa.setString(5, pessoaFisica.getTelefone());
                preparedStatementPessoa.setString(6, pessoaFisica.getEmail());
                preparedStatementPessoa.executeUpdate();
            }

            // Obter o próximo ID usando a sequência
            int id = (int) SequenceManager.getValue(connection, "seq_pessoa");

            // Inserir dados na tabela PessoaFisica
            try (PreparedStatement preparedStatementPF = ConectorBD.getPrepared(connection, sqlPessoaFisica)) {
                preparedStatementPF.setInt(1, id);
                preparedStatementPF.setString(2, pessoaFisica.getCpf());
                preparedStatementPF.executeUpdate();
            }

            // Confirmando a transação
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            // Revertendo em caso de erro
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Método para alterar os dados de uma pessoa física
    public void alterar(PessoaFisica pessoaFisica) {
        String sqlPessoa = "UPDATE Pessoa SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ? WHERE id = ?";
        String sqlPessoaFisica = "UPDATE PessoaFisica SET cpf = ? WHERE id = ?";

        try (Connection connection = ConectorBD.getConnection()) {
            // Atualizando dados na tabela Pessoa
            try (PreparedStatement preparedStatementPessoa = ConectorBD.getPrepared(connection, sqlPessoa)) {
                preparedStatementPessoa.setString(1, pessoaFisica.getNome());
                preparedStatementPessoa.setString(2, pessoaFisica.getLogradouro());
                preparedStatementPessoa.setString(3, pessoaFisica.getCidade());
                preparedStatementPessoa.setString(4, pessoaFisica.getEstado());
                preparedStatementPessoa.setString(5, pessoaFisica.getTelefone());
                preparedStatementPessoa.setString(6, pessoaFisica.getEmail());
                preparedStatementPessoa.setInt(7, pessoaFisica.getId());
                preparedStatementPessoa.executeUpdate();
            }

            // Atualizando dados na tabela PessoaFisica
            try (PreparedStatement preparedStatementPF = ConectorBD.getPrepared(connection, sqlPessoaFisica)) {
                preparedStatementPF.setString(1, pessoaFisica.getCpf());
                preparedStatementPF.setInt(2, pessoaFisica.getId());
                preparedStatementPF.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir uma pessoa física
    public void excluir(int id) {
        String sqlPessoaFisica = "DELETE FROM PessoaFisica WHERE id = ?";
        String sqlPessoa = "DELETE FROM Pessoa WHERE id = ?";

        try (Connection connection = ConectorBD.getConnection()) {
            // Remover dados da tabela PessoaFisica
            try (PreparedStatement preparedStatementPF = ConectorBD.getPrepared(connection, sqlPessoaFisica)) {
                preparedStatementPF.setInt(1, id);
                preparedStatementPF.executeUpdate();
            }

            // Remover dados da tabela Pessoa
            try (PreparedStatement preparedStatementPessoa = ConectorBD.getPrepared(connection, sqlPessoa)) {
                preparedStatementPessoa.setInt(1, id);
                preparedStatementPessoa.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
package cadastro.model;

import cadastro.model.util.ConectorBD;
import cadastro.model.util.SequenceManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {

    // Método para obter uma pessoa jurídica pelo ID
    public PessoaJuridica getPessoa(int id) {
        String sql = "SELECT * FROM Pessoa p JOIN PessoaJuridica pj ON p.id = pj.id WHERE p.id = ?";
        try (Connection connection = ConectorBD.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Montando o objeto PessoaJuridica com dados do banco
                return new PessoaJuridica(
                        resultSet.getInt("p.id"),
                        resultSet.getString("p.nome"),
                        resultSet.getString("p.logradouro"),
                        resultSet.getString("p.cidade"),
                        resultSet.getString("p.estado"),
                        resultSet.getString("p.telefone"),
                        resultSet.getString("p.email"),
                        resultSet.getString("pj.cnpj")
                );
            }
        } catch (
