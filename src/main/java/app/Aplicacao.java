package java.app;

import java.Classes.Operacoes;
import java.service.OperacoesServices;
import java.Classes.Pessoa;
import java.service.PessoaServices;
import java.Classes.Usuario;
import java.service.UsuarioServices;

public class Aplicacao {
    
    private static OperacoesService operacoesService = new OperacoesService();

    private static PessoaService pessoaService = new PessoaService();

    private static UsuarioService usuarioService = new UsuarioService();
    public static void main(String[] args) {
        port(6789);
        //Operacoes
        post("/operacoes", (request, response) -> operacoesService.add(request, response));

        get("/operacoes/:id", (request, response) -> operacoesService.get(request, response));

        get("/operacoes/update/:id", (request, response) -> operacoesService.update(request, response));

        get("/operacoes/delete/:id", (request, response) -> operacoesService.remove(request, response));

        get("/operacoes", (request, response) -> operacoesService.getAll(request, response));

        //Pessoa
        post("/pessoa", (request, response) -> pessoaService.add(request, response));

        get("/pessoa/:id", (request, response) -> pessoaService.get(request, response));

        get("/pessoa/update/:id", (request, response) -> pessoaService.update(request, response));

        get("/pessoa/delete/:id", (request, response) -> pessoaService.remove(request, response));

        get("/pessoa", (request, response) -> pessoaService.getAll(request, response));

        //Usuario
        post("/usuario", (request, response) -> usuarioService.add(request, response));

        get("/usuario/:login", (request, response) -> usuarioService.get(request, response));

        get("/usuario/update/:login", (request, response) -> usuarioService.update(request, response));

        get("/usuario/delete/:login", (request, response) -> usuarioService.remove(request, response));

        get("/usuario", (request, response) -> usuarioService.getAll(request, response));
    }
}
