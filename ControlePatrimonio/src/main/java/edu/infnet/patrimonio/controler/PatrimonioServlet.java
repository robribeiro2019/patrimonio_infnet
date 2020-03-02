package edu.infnet.patrimonio.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.util.StringUtils;

import edu.infnet.patrimonio.negocio.dao.PatrimonioDAO;
import edu.infnet.patrimonio.negocio.modelo.Patrimonio;
import edu.infnet.patrimonio.negocio.servico.PatrimonioService;

@WebServlet(urlPatterns = {"/PatrSrv"})
public class PatrimonioServlet extends HttpServlet {

	private static Logger logger = LogManager.getLogger(PatrimonioServlet.class);
	
	private PatrimonioService service;
	
	public PatrimonioServlet() {
		this.service = new PatrimonioService();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		
		logger.debug("Entrando no doPost");
		
		//TODO RECUPERAR O OBJETO DA REQUISICAO
		String descricao = req.getParameter("descricao");
		String localizacao =  req.getParameter("localizacao");
		String action =  req.getParameter("action");
		
		if("new".equals(action)) {
			//TODO VALIDAR O VALORES
			if(StringUtils.isEmptyOrWhitespaceOnly(descricao)) {
			}
			//TODO CONVERTER OS VALORES
			//TODO APLICAR VALORES AO MODELO
			Patrimonio usuario = new Patrimonio(descricao, localizacao);
			//TODO EXECUTAR LOGICA DE NEGOCIO
			service.save(usuario);
		}
		else {
			if(service.validarpatrimonio(descricao, localizacao)) {
				req.getSession().setAttribute("user", descricao);
			}else {
				req.setAttribute("error", "descricao ou localizacao inválidos!");
			}
			
		}
		
		req.getRequestDispatcher("pages/home.jsp")
				.forward(req, resp);
	}
	
	
}



