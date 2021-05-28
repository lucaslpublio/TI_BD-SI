package java.dao;

import java.Pessoa.Pessoa;
import java.sql.*;

public class PessoaDAO {
	private Connection conexao;
	
	public PessoaDAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "bdti.postgres.database.azure.com";                    
		String serverName = "localhost";
		String mydatabase = "bdti";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "adm@bdti";
		String password = "Maluco123";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o Banco de Dados!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o BD -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o BD -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean inserirPessoa(Pessoa pessoa) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO Pessoa (id, nome, email, login) "
					       + "VALUES (" +pessoa.getId() + ", " + pessoa.getNome() + ", " + pessoa.getEmail() + ", " + pessoa.getLogin() + ");");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarPessoa(Pessoa pessoa) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE Usuario SET Login = '" + pessoa.getLogin() + "', Email = '"  
				       + pessoa.getEmail() + "', Nome = '"  
				       + pessoa.getNome() + "', Id = '"  
				       + pessoa.getId();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirPessoa(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM Pessoa WHERE Id = " + codigo);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Usuario[] getPessoas() {
		Usuario[] pessoas = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM Pessoa");		
	         if(rs.next()){
	             rs.last();
	             usuarios = new Usuario[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                pessoas[i] = new Usuario(rs.getInt("Id"), rs.getString("Nome"), rs.getString("Email"),  rs.getString("Login"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuarios;
	}

}