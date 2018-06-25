package Disciplina;

public class RepositorioDisciplinaLista implements RepositorioDisciplina {
	private Disciplina atual;
	private RepositorioDisciplinaLista prox;

	RepositorioDisciplinaLista() {
		this.atual = null;
		this.prox = null;
	}

	public void cadastrar(Disciplina disciplina) {
		if (this.atual == null) {
			this.atual = disciplina;
			this.prox = new RepositorioDisciplinaLista();
		} else {
			this.prox.cadastrar(disciplina);
		}
	}
	
	public void remover(String nomeDisciplina) {
		if (this.atual.getNome().equals(nomeDisciplina)) {
			this.atual = this.prox.atual;
			this.prox = this.prox.prox;
		}
		if (this.prox != null) {
			this.prox.remover(nomeDisciplina);
		}
	}
	
	public boolean procurar(String nomeDisciplina) {
		if (this.atual != null && this.atual.getNome().equals(nomeDisciplina)) {
			return true;
		}
		if (this.prox != null) {
			return this.prox.procurar(nomeDisciplina);
		} else {
			return false;
		}
	}
	
	public void atualizarMensalidade(Disciplina disciplina)  {
		if (this.atual.getNome().equals(disciplina.getNome())) {
			this.atual.setMensalidade(disciplina.getMensalidade());
		} else {
			this.prox.atualizarMensalidade(disciplina);
		}
	}
	
	public Disciplina[] dados() {
		Disciplina[] aux = new Disciplina[10];
		boolean aux2 = true;
		int aux3 = 0;
		if (this.atual != null && aux2) {
			aux[aux3] = this.atual;
			aux3++;	
		} else {
			aux2 = false;
		}
		if (this.prox != null && aux2) {
			this.prox.dados();
		}
		return aux;
	}	
}
