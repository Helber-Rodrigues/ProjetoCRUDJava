import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public String selectMySQL(String Usuario) {
        MySQLConnection mysql = new MySQLConnection();
        Connection connection = mysql.getConexao();
        String result = "";
        if (connection != null) {
            try {
                String query = "SELECT SENHA FROM USUARIO WHERE USUARIO='" + Usuario + "';";
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
                
                if (resultSet.next()) {
                    result = resultSet.getString("SENHA");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                mysql.desconectar();
            }
        }
        return result;
    }
}
