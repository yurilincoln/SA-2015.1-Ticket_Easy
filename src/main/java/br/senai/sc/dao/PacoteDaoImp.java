package br.senai.sc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import conection.ConnectionManager;
import model.Evento;
import dao.EventoDaoImp;
import br.senai.sc.model.Pacote;

public class PacoteDaoImp {
	

	private final String INSERT = "insert into pacote (nome, cidade, estado, bairro, descricao, horaFuncionamento, valor, observacoes) values (?,?,?,?,?,?,?,?)";
	private final String UPDATE = "update pacote set descricao = ?, horaFuncionamento = ?, valor = ?, observacoes = ? where id = ?";
	private final String DELETE = "delete from pacote where id = ?";
	private final String ALL = "select * from pacote";
	private final String NOME = "select * from pacote where nome = ?";
	private static Connection connection;

	public EventoDaoImp() {
		openConnection();
	}
	
	public Pacote salvar(Pacote e){
		try {

			PreparedStatement ps = null;
			
			ps = ConnectionManager.getInstance().getConnection().prepareStatement(INSERT);
			
			ps.setObject(1, e.getNome());
			ps.setObject(2, e.getCidade());
			ps.setObject(3, e.getEstado());
			ps.setObject(4, e.getBairro());
			ps.setObject(5, e.getDescricao());
			ps.setObject(6, e.getHoraFuncionamento());
			ps.setObject(7, e.getValor());
			ps.setObject(8, e.getObersevacoes());
			
					
			ps.executeUpdate();
			
		} catch (SQLException ex) {
			Logger.getLogger(PacoteDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
		return e;
		}
	
	public void alterar(Pacote e) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(UPDATE);
			
			ps.setObject(1, e.getDescricao());
			ps.setObject(2, e.getHoraFuncionamento());
			ps.setObject(3, e.getValor());
			ps.setObject(4, e.getObersevacoes());
			
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(PacoteDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
	}
	
	public void deletar(Pacote e) {
		try {
			PreparedStatement ps = null;
			ps = connection.prepareStatement(DELETE);

			ps.setObject(1, e.getId());
			
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(PacoteDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
	}
	
	public List<Pacote> findAll() {
		List<Pacote> pacotes = new ArrayList<Pacote>();

		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			ps = connection.prepareStatement(ALL);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Pacote pacote = new Pacote();
				pacote.setId(rs.getLong("id"));
				pacote.setNome(rs.getString("nome"));
				pacote.setCidade(rs.getString("cidade"));
				pacote.setEstado(rs.getString("estado"));
				pacote.setBairro(rs.getString("bairro"));
				pacote.setDescricao(rs.getString("descricao"));
				pacote.setHoraFuncionamento(rs.getString("horaFuncionamento"));
				pacote.setValor(rs.getDouble("valor"));
				pacote.setObersevacoes(rs.getString("observacoes"));
				pacotes.add(pacote);
				
			}

		} catch (SQLException ex) {
			Logger.getLogger(PacoteDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
		return pacotes;
	}
	

	public Pacote listarPorNome(String listarPorNome) {
		List<Pacote> listaNome = new ArrayList<Pacote>();

		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			ps = connection.prepareStatement(NOME);
			ps.setObject(1, listarPorNome);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Pacote pacote = new Pacote();
				pacote.setId(rs.getLong("id"));
				pacote.setNome(rs.getString("nome"));
				pacote.setCidade(rs.getString("cidade"));
				pacote.setEstado(rs.getString("estado"));
				pacote.setBairro(rs.getString("bairro"));
				pacote.setDescricao(rs.getString("descricao"));
				pacote.setHoraFuncionamento(rs.getString("horaFuncionamento"));
				pacote.setValor(rs.getDouble("valor"));
				pacote.setObersevacoes(rs.getString("observacoes"));
				listaNome.add(pacote);
			}

		} catch (SQLException ex) {
			Logger.getLogger(PacoteDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
		if (listaNome.isEmpty()) {
			return null;
		} else {
			return listaNome.get(0);
		}
	}

	public boolean isConnectionClose() {
		try {
			return connection.isClosed();
		} catch (SQLException ex) {
			return false;
		}
	}

	public void openConnection() {
		if ( connection == null) {
			connection = ConnectionManager.getInstance().getConnection();
		}
		
		if ( isConnectionClose() ) {
			connection = ConnectionManager.getInstance().getConnection();
		}		
	}

	public void closeConnection() {
		if ( connection != null && !this.isConnectionClose()) {
			ConnectionManager.getInstance().closeConnection(connection);
		}
		
	}
	
}