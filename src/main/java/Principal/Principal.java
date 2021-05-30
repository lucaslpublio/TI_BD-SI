package java.Principal;

import java.DAO.UsuarioDAO;
import java.Classes.Usuario;

public class Principal {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.conectar();

        //Inserir um elemento na tabela
        Usuario usuario = new Usuario("pablo", "1234");
        if(dao.inserirUsuario(usuario) == true){
            System.out.println("Inserção com sucesso -> " + usuario.toString());
        }

        //Mostrar usuários
        System.out.println(" === Mostrar usuarios === ");
        Usuario[] usuarios = dao.getUsuarios();
        for(int i = 0; i < usuarios.length; i++){
            System.out.println(usuarios[i].toString());
        }
    }
}
