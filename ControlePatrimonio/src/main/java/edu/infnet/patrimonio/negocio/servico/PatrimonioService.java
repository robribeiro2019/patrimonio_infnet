package edu.infnet.patrimonio.negocio.servico;

import java.util.Objects;

import edu.infnet.patrimonio.negocio.dao.PatrimonioDAO;
import edu.infnet.patrimonio.negocio.modelo.Patrimonio;

public class PatrimonioService {
	
	private PatrimonioDAO dao;
	
	public PatrimonioService() {
		dao = new PatrimonioDAO();
	}
	
	public Boolean validarpatrimonio(String descricao, String localizacao) {
		
		Patrimonio patrimonio = dao.getByDescricao(descricao);
		if(!Objects.isNull(patrimonio) && patrimonio.getLocalizacao().equals(localizacao)) {
			return true;
		}
		
		return false;
	}

	public void save(Patrimonio patrimonio) {
		dao.save(patrimonio);
	}
	

}
