package br.senai.sc.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.dao.UsuarioDao;
import br.senai.sc.entity.Usuario;
 
@ManagedBean
@ViewScoped
public class UsuarioMB {
 
      private UsuarioDao usuarioDAO = new UsuarioDao();
      private Usuario usuario = new Usuario();
      
      public String envia() {
            
            usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
            if (usuario == null) {
                  usuario = new Usuario();
                  FacesContext.getCurrentInstance().addMessage(
                             null,
                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                         "Erro no Login!"));
                  return null;
            } else {
                  return "/main";
            }
            
            
      }
 
      public Usuario getUsuario() {
            return usuario;
      }
 
      public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
      }
}