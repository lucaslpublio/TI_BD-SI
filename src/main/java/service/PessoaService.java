package java.service;

import java.Classes.Pessoa;
import java.DAO.PessoaDAO;

public class PessoaService {
    
    private PessoaDAO pessoaDAO;

    public Object add(Request request, Response response){
        String nome = request.queryParams("nome");
        String email = request.queryParams("email");
        String login = request.queryParams("login");

        int id = pessoaDAO.getMaxId() + 1;
        Pessoa pessoa = new Pessoa(nome, email, login);

        pessoaDAO.add(pessoa);

        response.status(201);
        return id;
    }

    public Object get(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));

        Pessoa pessoa = (Pessoa) pessoaDAO.get(id);

        if(pessoa != null){
            response.header("Content-Type", "application.xml");
            response.header("Content-Enconding", "UTF-8");

            return "<pessoa>\n" + 
                   "\t<id>" + pessoa.getId() + "</id>\n" +
                   "\t<saldoAtual>" + pessoa.getNome() + "</nome>\n" +
                   "\t<resumo>" + pessoa.getEmail() + "</email>\n" +
                   "\t<valor>" + pessoa.getLogin() + "</login>\n" +
                   "</pessoa>\n";
        } else {
            response.status(404);
            return "Pessoa " + id + "não encontrado.";
        }

    }

    public Object update(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        Pessoa pessoa = (Pessoa) pessoaDAO.get(id);

        if(pessoa != null){
            pessoa.setNome(request.queryParams("Nome"));
            pessoa.setEmail(request.queryParams("email"));
            pessoa.setLogin(request.queryParams("login")); 

            pessoaDAO.update(pessoa);

            return id;
        } else {
            response.status(404);
            return "Pessoa " + id + "não encontrado.";
        }

    }

    public Object remove(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        Pessoa pessoa = (Pessoa) pessoaDAO.get(id);

        if(pessoa != null){

            pessoaDAO.remove(pessoas);
            response.status(200);

            return id;
        } else {
            response.status(404);
            return "Pessoa " + id + "não encontrado.";
        }

    }

    public Object getAll(Request request, Response response) {
        StringBuffer returnValue = new StringBuffer("<pessoa type=\ "array\">");

        for(Pessoa pessoa : pessoaDAO.getAll()) {
            returnValue.append "\n<pessoa>\n" + 
                   "\t<id>" + pessoa.getId() + "</id>\n" +
                   "\t<nome>" + pessoa.getNome() + "</nome>\n" +
                   "\t<email>" + pessoa.getEmail() + "</email>\n" +
                   "\t<login>" + pessoa.getLogin() + "</login>\n" +
                   "</pessoa>\n";
        }
        returnValue.append("</pessoas>");
        response.header("Content-Type", "application.xml");
        response.header("Content-Enconding", "UTF-8");
        return returnValue.toString();
    }
}
