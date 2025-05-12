/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class SequenceManager {
    
}
package cadastro.model.util;

import java.sql.*;

public class SequenceManager {

    // Método para obter o próximo valor de uma sequência
    public static long getValue(Connection connection, String sequenceName) throws SQLException {
        String sql = "SELECT NEXTVAL(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, sequenceName);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            } else {
                throw new SQLException("Falha ao obter o próximo valor da sequência.");
            }
        }
    }
}
