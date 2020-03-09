package edu.infnet.patrimonio.negocio.servico;

import java.util.List;

import edu.infnet.patrimonio.negocio.dao.PatrimonioDAO;
import edu.infnet.patrimonio.negocio.modelo.Patrimonio;

public class PatrimonioService {
	
	private PatrimonioDAO dao;
	
	public PatrimonioService() {
		dao = new PatrimonioDAO();
	}
	
	public List<Patrimonio> listaPatrimonios(){
		return dao.findAll();
	}
	
	public Boolean salvarPatrimonio(Patrimonio patrimonio) {
		return dao.save(patrimonio);
	}
	
	public Patrimonio buscarPatrimonio(Integer id) {
		return dao.find(id);
	}
	
	public Boolean atualizarPatrimonio(Patrimonio patrimonio) {
		return dao.edit(patrimonio);
	}
	
	public Boolean removerPatrimonio(Patrimonio patrimonio) {
		return dao.delete(patrimonio);
	}

}
