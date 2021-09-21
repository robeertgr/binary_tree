package arvoreBinaria;

public class No {
	int chave;
	No pai;
	No esq;
	No dir;

	public No(int chave) {
		this.chave = chave;
		this.esq = null;
		this.dir = null;
		this.pai = null;
	}

	public No() {
	}

}
