import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    
    public void insertMySQL(String nome, int idade, String cpf, String telefone, String cidade, String uf) {
        MySQLConnection mysql = new MySQLConnection();
        Connection connection = mysql.getConexao();
        if (connection != null) {
            try {
                String campos = "NOME, IDADE, CPF, TELEFONE, CIDADE, UF, DATACAD";
                String valores = "?, ?, ?, ?, ?, ?, ?";
                String sql = "INSERT INTO CLIENTE ("+ campos +") VALUES (" + valores + ")";
                
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nome);
                statement.setString(2, String.valueOf(idade));
                statement.setString(3, cpf);                
                statement.setString(4, telefone);
                statement.setString(5, cidade);
                statement.setString(6, uf);
                statement.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));
                
                int qtdeCad = statement.executeUpdate();
                if (qtdeCad > 0) {
                    System.out.println("Produto cadastrado com sucesso!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                mysql.desconectar();
            }
        }
    }
     
      public List<Cliente> selectMySQL() {
        List<Cliente> clientes = new ArrayList<>();
        MySQLConnection mysql = new MySQLConnection();
        Connection connection = mysql.getConexao();
        if (connection != null) {
            try {
                String query = "SELECT * FROM cliente";
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    //System.out.println("Dados: " + resultSet.getString("SEUCAMPO"));
                    Cliente cli = new Cliente();
                    cli.setId(resultSet.getInt("IDCLIENTE"));
                    cli.setNome(resultSet.getString("NOME"));
                    cli.setIdade(Integer.parseInt(resultSet.getString("IDADE")));
                    cli.setCpf(resultSet.getString("CPF"));
                    cli.setTelefone(resultSet.getString("TELEFONE"));
                    cli.setCidade(resultSet.getString("CIDADE"));
                    cli.setUf(resultSet.getString("UF"));                                      
                    clientes.add(cli);                 
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                mysql.desconectar();
            }
        }
        return clientes;
    }
      
      public void deleteMySQL(String id) {   
        MySQLConnection mysql = new MySQLConnection();
        Connection connection = mysql.getConexao();
        if (connection != null) {
            try {
                String query = "DELETE FROM CLIENTE WHERE IDCLIENTE=" + id;
                PreparedStatement statement = connection.prepareStatement(query);
                    int qtdeCad = statement.executeUpdate();
                    if(qtdeCad>0){
                        System.out.println("Registro excluído com sucesso!");
                    }else{
                        System.out.println("Erro ao excluir o registro!");
                    }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                mysql.desconectar();
            }
        }
    }
}
