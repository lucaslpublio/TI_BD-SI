package java.Usuario;

/*
/	CLASSES DO GERENCIADOR FINANCEIRO
/	RECEITA DESPESA TRANSACAO
*/

import java.util.Random;

public class Operacoes {
	protected int id;
    private int saldoAtual;
	Random geradorId = new Random();

	public Operacoes() {
        this.id = geradorId.nextInt(1000);//FUNÇÃO PARA FAZER O ID
        this.saldoAtual = -1;
	}
	
	public Operacoes(String saldoAtual) {
        this.id = geradorId.nextInt(1000);//FUNÇÃO PARA FAZER O ID
		this.saldoAtual = Integer.parseInt(saldoAtual);
	}

	public int getId() {
		return id;
	}

	public void setId() {
	
		this.id = geradorId.nextInt(1000);
	
    }

	public String getSaldoAtual() {
		return Integer.toString(saldoAtual);
	}

	public void setSaldoAtual(String saldoAtual) {
		this.saldoAtual = Integer.parseInt(saldoAtual);
	}

	public String toString() {
		return "Operacoes Dados : [id=" + id + ", Saldo Atual=" + saldoAtual + "]";
	}
	


class Receita extends Operacoes {
	private String resumo;
	private int valor;

	public Receita() {
		setId();
		this.resumo = "";
		this.valor = -1;
	}

	public Receita(int id, String resumo, int valor) {
		this.id = id;
		this.resumo = resumo;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = geradorId.nextInt(1000);
    }

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
    }

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String toString() {
		return "Receita Dados : [valor=" + valor + ", Resumo=" + resumo + "]";
	}
}

class Despesa extends Operacoes {
	private String resumo;
	private int valor;

	public Despesa() {
		this.id = -1;
		this.resumo = "";
		this.valor = -1;
	}

	public Despesa(int id, String resumo, int valor) {
		this.id = id;
		this.resumo = resumo;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = geradorId.nextInt(1000);
    }

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
    }

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String toString() {
		return "Despesa Dados : [valor=" + valor + ", Resumo=" + resumo + "]";
	}
}


class Transacoes extends Operacoes {
	private String resumo;
	private int valor;

	public Transacoes() {
		this.id = -1;
		this.resumo = "";
		this.valor = -1;
	}

	public Transacoes(int id, String resumo, int valor) {
		this.id = id;
		this.resumo = resumo;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = geradorId.nextInt(1000);
    }

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
    }

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String toString() {
		return "Despesa Dados : [valor=" + valor + ", Resumo=" + resumo + "]";
	}
}
}