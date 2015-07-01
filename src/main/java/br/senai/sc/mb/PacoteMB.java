package br.senai.sc.mb;


import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import br.senai.sc.dao.PacoteDao;
import br.senai.sc.entity.Pacote;
import br.senai.sc.util.UploadImageException;
import br.senai.sc.util.UploadImageUtil;

@ManagedBean
public class PacoteMB {

	private Pacote pacote;
	private List<Pacote> pacotes;
	private PacoteDao pacoteDao;
	private Part fotoPacote;
	
	@PostConstruct
	public void initMB(){
		this.pacote = new Pacote();
		pacoteDao = new PacoteDao();
	}

	public String salvar(){
		String nomeFoto;
		try {
			nomeFoto = UploadImageUtil.salvar(fotoPacote, pacote.getFotoPacote());
			pacote.setFotoPacote(nomeFoto);
		} catch (UploadImageException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possivel salvar a imagem."));
			e.printStackTrace();
			return "";
		}
		pacoteDao.salvar(pacote);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
		return "listapacoteturistico";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		Pacote pacoteExcluir = pacoteDao.buscarPorId(id);
		UploadImageUtil.excluir(pacoteExcluir.getFotoPacote());
		pacoteDao.excluir(id);
		pacotes = null;
		return "";
	}
	
	
	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		pacote = pacoteDao.buscarPorId(id);
		return "cadastropacoteturistico";
	}
	

	public List<Pacote> getPacotes() {
		if(pacotes == null){
			pacotes = pacoteDao.listarTodos();
		}
		return pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}
	
	public String caminhoUpload(String imagem){
		return UploadImageUtil.getCaminhoRelativo(imagem);
	}
	
	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public PacoteDao getPacoteDao() {
		return pacoteDao;
	}

	public void setPacoteDao(PacoteDao pacoteDao) {
		this.pacoteDao = pacoteDao;
	}

	public Part getFotoPacote() {
		return fotoPacote;
	}

	public void setFotoPacote(Part fotoPacote) {
		this.fotoPacote = fotoPacote;
	}
	
}