/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class ConectorBD {
    
}
package cadastro.model.util;

import java.sql.*;

public class ConectorBD {

    // Método para obter uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/seu_banco";
        String usuario = "seu_usuario";
        String senha = "sua_senha";

        return DriverManager.getConnection(url, usuario, senha);
    }

    // Método para obter um PreparedStatement
    public static PreparedStatement getPrepared(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    // Método para realizar uma consulta SELECT e retornar o ResultSet
    public static ResultSet getSelect(Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    // Métodos para garantir o fechamento dos recursos

    // Fechar PreparedStatement
    public static void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Fechar ResultSet
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Fechar Connection
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Fechar Statement (para generalidade)
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
