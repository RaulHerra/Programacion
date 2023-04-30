package colecciones.com.colecciones.boletin1.historial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nickname;
	private List<PaginaWeb> historial;
	
	public Usuario(String nickname) {
		super();
		this.nickname = nickname;
		this.historial = new ArrayList<PaginaWeb>();
	}
	
	public boolean visitaWeb(String nombre, String url) {
		PaginaWeb p = new PaginaWeb(nombre, url);
		historial.add(p);
		return true;
	}

	public List<PaginaWeb> consultarHistorial() {
		return historial;
	}
	
	public String consultarHistorialDia(LocalDate dia){
		StringBuilder sb = new StringBuilder();
		for(PaginaWeb pw : historial) {
			if(pw!=null && pw.getFechaVisitada().toLocalDate().isEqual(dia)) {
				sb.append(pw).append(System.lineSeparator());
			}
		}
		return sb.toString();
	}
	
	public void borrarHistorial() {
		historial.clear();
	}
	
	public void borrarVisitasPagina(PaginaWeb pagina) {
		if(historial.contains(pagina)) {
			List<PaginaWeb> tmp = new ArrayList<>();
			tmp.add(pagina);
			historial.removeAll(tmp);
		}
	}
	
	public void borrarVisitasPagina(String nombre, String url) {
		PaginaWeb p = new PaginaWeb(nombre, url);
		borrarVisitasPagina(p);
	}
}