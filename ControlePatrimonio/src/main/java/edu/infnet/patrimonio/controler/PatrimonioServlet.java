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

@WebServlet(urlPatterns = { "/PatrSrv" })
public class PatrimonioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public PatrimonioServlet() {
		super();
	}

	private PatrimonioService service;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String descricao = request.getParameter("descricao");
		String localizacao = request.getParameter("localizacao");
		String action = request.getParameter("action");

		try {

			if ("new".equals(action)) {

				if (service.validarpatrimonio(descricao, localizacao)) {
					Patrimonio patrimonio = new Patrimonio(descricao, localizacao);
					service.save(patrimonio);
				} else {
					request.setAttribute("error", "descricao ou localizacao inválidos!");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Erro no no banco de dados!");
		} finally {
			request.getRequestDispatcher("pages/patrimonio.jsp").forward(request, response);
		}
	}

}
