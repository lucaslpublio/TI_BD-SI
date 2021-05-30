package java.model;
import java.io.Serializable;

public class OperacoesModel implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String DESCRIÇÃO_PADRAO = "Nova operação";
    public static final int MAX_OPERACAO = 1000;
    private int id;
    private int saldoAtual;
    private String resumo;
    private int valor;

    public void Operacoes() {
        id = -1;
        saldoAtual = 1;
        resumo = DESCRIÇÃO_PADRAO;
        valor = -1;
    }

    public void Operacoes(int id, int saldoAtual, String resumo, int valor){
        setId(id);
        setSaldoAtual(saldoAtual);
        setResumo(resumo);
        setValor(valor);
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getSaldoAtual(){
        return saldoAtual;
    }

    public void setSaldoAtual(int saldoAtual){
        this.saldoAtual = saldoAtual;
    }

    public String getResumo(){
        return resumo;
    }

    public void setResumo(String resumo){
        this.resumo = resumo;
    }

    public int getValor(){
        return valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public String toString(){
        return "Operacao = " + resumo + "Valor = " + valor + "Saldo atual = " + saldoAtual;
    }

    public boolean equals(Object obj){
        return (this.getId() == ((OperacoesModel)obj).getId());
    }
}
