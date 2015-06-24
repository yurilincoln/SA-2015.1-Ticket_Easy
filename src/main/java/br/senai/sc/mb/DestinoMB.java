//package br.senai.sc.mb;
//
//
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.context.FacesContext;
//import javax.servlet.http.Part;
//
//import br.senai.sc.dao.DestinoDao_Test;
//import br.senai.sc.entity.Destino;
//import br.senai.sc.util.UploadImageUtil;
//
//@ManagedBean
//public class DestinoMB {
//
//	public DestinoDao_Test getDestinoDaoTest() {
//		return destinoDaoTest;
//	}
//
//	public void setDestinoDaoTest(DestinoDao_Test destinoDaoTest) {
//		this.destinoDaoTest = destinoDaoTest;
//	}
//
//	private Destino destino;
//	private List<Destino> destinos;
////	private DestinoDao destinoDao;
//	private DestinoDao_Test destinoDaoTest;
//	private Part fotoDestino;
//	
//	@PostConstruct
//	public void initMB(){
//		this.destino = new Destino();
//		destinoDaoTest = new DestinoDao_Test();
//	}
//
//	public String salvar(){
////		String nomeFoto;
////		try {
////			nomeFoto = UploadImageUtil.salvar(fotoDestino, destino.getFotoDestino());
////			destino.setFotoDestino(nomeFoto);
////		} catch (UploadImageException e) {
////			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
////			e.printStackTrace();
////			return "";
////		} catch (IOException e) {
////			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possivel salvar a imagem."));
////			e.printStackTrace();
////			return "";
////		}
//		destinoDaoTest.save(destino);
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
//		return "listadestinoturistico";
//	}
//	
////	public String excluir(String idParam){
////		Long id = Long.valueOf(idParam);	
////		Destino destinoExcluir = destinoDao.buscarPorId(id);
////		UploadImageUtil.excluir(destinoExcluir.getFotoDestino());
////		destinoDao.excluir(id);
////		destinos = null;
////		return "";
////	}
//	
////	public String editar(String idParam){
////		Long id = Long.valueOf(idParam);
////		destino = destinoDao.buscarPorId(id);
////		return "cadastrodestinoturistico";
////	}
////	
////	public List<Destino> getDestinos() {
////		if(destinos == null){
////			destinos = destinoDao.listarTodos();
////		}
////		return destinos;
////	}
////
////	public void setDestinos(List<Destino> destinos) {
////		this.destinos = destinos;
////	}
//
//	public String caminhoUpload(String imagem){
//		return UploadImageUtil.getCaminhoRelativo(imagem);
//	}
//	
//	public Destino getDestino() {
//		return destino;
//	}
//
//	public void setDestino(Destino destino) {
//		this.destino = destino;
//	}
//
////	public DestinoDao getDestinoDao() {
////		return destinoDao;
////	}
////
////	public void setDestinoDao(DestinoDao destinoDao) {
////		this.destinoDao = destinoDao;
////	}
//
//	
//	public Part getFotoDestino() {
//		return fotoDestino;
//	}
//
//	public void setFotoDestino(Part fotoDestino) {
//		this.fotoDestino = fotoDestino;
//	}
//	
//	
//}
