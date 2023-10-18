import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conexao;
    public ClienteDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Criar Clientes
    public void criarCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nomeCliente, enderecoCliente, emailCliente, telefoneCliente, cpfCliente) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getEndereco());
            stmt.setString(3,cliente.getEmail());
            stmt.setString(4,cliente.getTelefone());
            stmt.setString(5,cliente.getCpf());
            stmt.executeUpdate();
            System.out.println("Cliente criado com sucesso!");
            System.out.println("###########################");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Listar Clientes
    public List<Cliente> listarCliente() {
        List<Cliente> Cliente = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setCpf(resultado.getString("cpf"));
                Cliente.add(cliente);
                System.out.println("Fim da Lista!");
                System.out.println("###########################");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Cliente;
    }
    //Buscar Cliente
    public Cliente buscarCliente(int id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM Cliente WHERE idCliente = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setCpf(resultado.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
    //Fechar Conexão com Banco
    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}