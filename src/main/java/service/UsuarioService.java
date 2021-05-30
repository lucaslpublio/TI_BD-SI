package java.service;

import java.Classes.Usuario;
import java.DAO.UsuarioDAO;

public class UsuarioService {
    
    private UsuarioDAO usuarioDAO;

    public Object add(Request request, Response response){
        String login = request.queryParams("login");
        String senha = request.queryParams("senha");
        Usuario usuario = new Usuario(login, senha);

        usuarioDAO.add(usuario);

        response.status(201);
        return login;
    }

    public Object get(Request request, Response response) {
        String login = request.params(":login");

        Usuario usuario = (Usuario) usuarioDAO.get(login);

        if(usuario != null){
            response.header("Content-Type", "application.xml");
            response.header("Content-Enconding", "UTF-8");

            return "<usuario>\n" + 
                   "\t<login>" + usuario.getLogin() + "</login>\n" +
                   "\t<senha>" + usuario.getSenha() + "</senha>\n" +
                   "</usuario>\n";
        } else {
            response.status(404);
            return "Usuario " + login + "não encontrado.";
        }

    }

    public Object update(Request request, Response response) {
        String login = request.params(":login");
        Usuario usuario = (Usuario) usuarioDAO.get(login);

        if(usuario != null){
            usuario.setLogin(request.queryParams("login"));
            usuario.setLogin(request.queryParams("senha"));

            usuarioDAO.update(usuario);

            return login;
        } else {
            response.status(404);
            return "Usuario " + login + "não encontrado.";
        }

    }

    public Object remove(Request request, Response response) {
        String login = request.params(":login");
        Usuario usuario = (Usuario) usuarioDAO.get(login);

        if(usuario != null){

            usuarioDAO.remove(usuario);
            response.status(200);

            return login;
        } else {
            response.status(404);
            return "Usuario " + login + "não encontrado.";
        }

    }

    public Object getAll(Request request, Response response) {
        StringBuffer returnValue = new StringBuffer("<usuario type=\ "array\">");

        for(Usuario usuario : usuarioDAO.getAll()) {
            returnValue.append "\n<usuario>\n" + 
                   "\t<login>" + usuario.getLogin() + "</login>\n" +
                   "\t<senha>" + usuario.getSenha() + "</senha>\n" +
                   "</usuario>\n";
        }
        returnValue.append("</usuario>");
        response.header("Content-Type", "application.xml");
        response.header("Content-Enconding", "UTF-8");
        return returnValue.toString();
    }
}
