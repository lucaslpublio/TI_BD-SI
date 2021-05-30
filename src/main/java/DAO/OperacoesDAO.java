package java.DAO;

import java.Classes.Operacoes;
import java.sql.*;

public class OperacoesDAO {
    private Connection conexao;
	
	public OperacoesDAO() {
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
	// --------------- Operaçoes ------------------ //
	public boolean inserirOperacoes(Operacoes operacao) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO Operacoes (id, saldoAtual) "
					       + "VALUES (" +operacao.getId()+ ", " + operacao.getSaldoAtual() + ");");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarOperacao(Operacoes operacao) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE Operacoes SET ID = '" + operacao.getId() + "', SaldoAtual = '"  
				       + operacao.getSaldoAtual();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirOperacao(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM Operacoes WHERE ID = " + codigo);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Operacoes[] getOperacoes() {
		Operacoes[] operacoes = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM Operacoes");		
	         if(rs.next()){
	             rs.last();
	             operacoes = new Operacoes[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                operacoes[i] = new Operacoes(rs.getInt("Id"), rs.getInt("saldoAtual"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return operacoes;
	}

	// --------------- Terminando Operaçoes ------------------ //

	// --------------- Receitas ------------------ //

	public boolean inserirReceita(Operacoes receita) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO receita (resumo, valor) "
					       + "VALUES (" + receita.getResumo() + ", " + receita.getValor() + ");");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarReceita(Operacoes receita) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE receita SET Resumo = '" + receita.getResumo() + "', valor = '"  
				       + receita.getValor();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirReceita(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM Receita WHERE ID = " + codigo);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Operacoes[] getReceitas() {
		Operacoes[] receitas = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM Operacoes");		
	         if(rs.next()){
	             rs.last();
	             receitas = new Operacoes[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                receitas[i] = new Operacoes(rs.getString("Resumo"), rs.getInt("valor"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return receitas;
	}

	// --------------- Terminando Receitas ------------------ //

	// --------------- Despesas ------------------ //

	public boolean inserirDespesa(Operacoes despesa) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO despesa (resumo, valor) "
					       + "VALUES (" + despesa.getResumo() + ", " + despesa.getValor() + ");");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarDespesa(Operacoes despesa) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE despesa SET Resumo = '" + despesa.getResumo() + "', valor = '"  
				       + despesa.getValor();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirDespesa(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM Despesa WHERE ID = " + codigo);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Operacoes[] getDespesas() {
		Operacoes[] despesas = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM Operacoes");		
	         if(rs.next()){
	             rs.last();
	             despesas = new Operacoes[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                despesas[i] = new Operacoes(rs.getString("Resumo"), rs.getInt("valor"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return despesas;
	}

	// --------------- Terminando Despesas ------------------ //
}
