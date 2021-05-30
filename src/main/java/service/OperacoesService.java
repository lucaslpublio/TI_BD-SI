package java.service;

import java.DAO.OperacoesDAO;
import java.io.IOException;
import java.Classes.Operacoes;
import compiler.core.GraalCompiler.Request;

public class OperacoesService {
    
    private OperacoesDAO operacoesDAO;

    public Object add(Request request, Response response){
        int saldoAtual = Integer.parseInt(request.queryParams("saldoAtual"));
        String resumo = request.queryParams("resumo");
        int valor = Integer.parseInt(request.queryParams("valor"));

        int id = operacoesDAO.getMaxId() + 1;
        Operacoes operacoes = new Operacoes(saldoAtual, resumo, valor);

        operacoesDAO.add(operacoes);

        response.status(201);
        return id;
    }

    public Object get(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));

        Operacoes operacoes = (Operacoes) operacoesDAO.get(id);

        if(operacoes != null){
            response.header("Content-Type", "application.xml");
            response.header("Content-Enconding", "UTF-8");

            return "<operacoes>\n" + 
                   "\t<id>" + operacoes.getId() + "</id>\n" +
                   "\t<saldoAtual>" + operacoes.getSaldoAtual() + "</saldoAtual>\n" +
                   "\t<resumo>" + operacoes.getResumo() + "</resumo>\n" +
                   "\t<valor>" + operacoes.getValor() + "</valor>\n" +
                   "</operacoes>\n";
        } else {
            response.status(404);
            return "Operacoes " + id + "não encontrado.";
        }

    }

    public Object update(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        Operacoes operacoes = (Operacoes) operacoesDAO.get(id);

        if(operacoes != null){
            operacoes.setSaldoAtual(request.queryParams("saldoAtual"));
            operacoes.setResumo(request.queryParams("resumo"));
            operacoes.setValor(request.queryParams("valor")); 

            operacoesDAO.update(operacoes);

            return id;
        } else {
            response.status(404);
            return "Operacoes " + id + "não encontrado.";
        }

    }

    public Object remove(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        Operacoes operacoes = (Operacoes) operacoesDAO.get(id);

        if(operacoes != null){

            operacoesDAO.remove(operacoes);
            response.status(200);

            return id;
        } else {
            response.status(404);
            return "Operacoes " + id + "não encontrado.";
        }

    }

    public Object getAll(Request request, Response response) {
        StringBuffer returnValue = new StringBuffer("<operacoes type=\ "array\">");

        for(Operacoes operacoes : operacoesDAO.getAll()) {
            returnValue.append "\n<operacoes>\n" + 
                   "\t<id>" + operacoes.getId() + "</id>\n" +
                   "\t<saldoAtual>" + operacoes.getSaldoAtual() + "</saldoAtual>\n" +
                   "\t<resumo>" + operacoes.getResumo() + "</resumo>\n" +
                   "\t<valor>" + operacoes.getValor() + "</valor>\n" +
                   "</operacoes>\n";
        }
        returnValue.append("</operacoes>");
        response.header("Content-Type", "application.xml");
        response.header("Content-Enconding", "UTF-8");
        return returnValue.toString();
    }
}
