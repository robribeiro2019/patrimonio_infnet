package edu.infnet.patrimonio.negocio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.infnet.patrimonio.negocio.MysqlConection;
import edu.infnet.patrimonio.negocio.modelo.Patrimonio;

public class PatrimonioDAO {

	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	public PatrimonioDAO() {
		this.con = MysqlConection.getConnection();
	}
	
	public Boolean save(Patrimonio patrimonio) {
		
		String sql = "insert into patrimonio(descricao,localizacao) values(?,?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, patrimonio.getDescricao());
			pstm.setString(2, patrimonio.getLocalizacao());
			return pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public Patrimonio getByDescricao(String descricao) {
		String sql = "select id, descricao, localizacao from patrimonio where descricao=?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, descricao);
			rs = pstm.executeQuery();
			if(rs.next()) {
				Integer id = rs.getInt(1);
				String _descricao = rs.getString(2);
				String localizacao = rs.getString(3);
				return new Patrimonio(id, descricao, localizacao);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
}










