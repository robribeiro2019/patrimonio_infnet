package edu.infnet.patrimonio.controler;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.infnet.patrimonio.negocio.modelo.Patrimonio;
import edu.infnet.patrimonio.negocio.servico.PatrimonioService;

@WebServlet(urlPatterns = { "/PatrSrv" })
public class PatrimonioServlet extends HttpServlet {

	private static final long serialVersionUID = 3203059670294120152L;
	
	private PatrimonioService patrimonioService;	
	
	private List<Patrimonio> listaPatrimonios;
	private Patrimonio patrimonio;
	 	
	@PostConstruct
	public void init() {
		patrimonioService = new PatrimonioService();
		listaPatrimonios =  patrimonioService.listaPatrimonios();		
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = (String) req.getParameter("action");
		String id = (String) req.getParameter("id");
		String descricao = req.getParameter("descricao");
		String localizacao = req.getParameter("localizacao");
		String recurso = "pages/home.jsp";
		
		if("new".equals(action)) {
			if(id != null && !"".equals(id)) {
				patrimonioService.atualizarPatrimonio(new Patrimonio(Integer.parseInt(id), descricao, localizacao));
			} else {
				patrimonioService.salvarPatrimonio(new Patrimonio(descricao, localizacao));
			}
			recurso = "pages/home.jsp";
		}
		
		if("edit".equals(action)) {
			patrimonio = patrimonioService.buscarPatrimonio(Integer.parseInt(id));
			req.setAttribute("patrimonio", new Patrimonio(Integer.parseInt(id), descricao, localizacao));
			recurso = "pages/patrimonio.jsp";
		}
						
		if("delete".equals(action)) {
			patrimonio = patrimonioService.buscarPatrimonio(Integer.parseInt(id));
			
			if(!Objects.isNull(patrimonio)) {
				patrimonioService.removerPatrimonio(patrimonio);
			}			
		}
		listaPatrimonios =  patrimonioService.listaPatrimonios();
		req.setAttribute("listaPatrimonios", listaPatrimonios);
		req.getRequestDispatcher(recurso).forward(req, resp);
		
	}
	
}