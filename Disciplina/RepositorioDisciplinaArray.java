package Disciplina;

public class RepositorioDisciplinaArray implements RepositorioDisciplina {

	private Disciplina[] array;
	private int contador;

	public RepositorioDisciplinaArray() {
		array = new Disciplina[1];
		contador = 0;
	}

	public void cadastrar(Disciplina disciplina) {
		if (contador == array.length) {
			Disciplina[] arrayAux = new Disciplina[array.length + 1];
			for (int i = 0; i < array.length; i++) {
				arrayAux[i] = array[i];
			}
			this.array = arrayAux;
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				array[i] = disciplina;
				contador++;
			}
		}
	}

	public void remover(String nomeDisciplina) {
		int aux = 0;
		int aux2 = 0;
		for (int i = 0; i < array.length; i++) {
			if (this.array[i].getNome().equals(nomeDisciplina)) {
				this.array[i] = null;
				aux2 = i;
			}
		}
		Disciplina[] arrayAux = new Disciplina[array.length - 1];
		for (int i = 0; i < array.length; i++) {
			if (i != aux2) {
				arrayAux[aux] = this.array[i];
				aux++;
			}
		}
	}

	public boolean procurar(String nomeDisciplina) {
		boolean aux = false;
		for (int i = 0; i < array.length; i++) {
			if (this.array[i] != null && this.array[i].getNome().equals(nomeDisciplina)) {
				aux = true;
			}
		}
		return aux;
	}

	public void atualizarMensalidade(Disciplina disciplina)  {
		boolean aux = true;
		for (int i = 0; i < array.length && aux; i++) {
			if (this.array[i] != null && this.array[i].getNome().equals(disciplina.getNome())) {
				this.array[i].setMensalidade(disciplina.getMensalidade()); 
				aux = false;
			}
		}
	}
	
	public Disciplina[] dados() {
		Disciplina[] aux = null;
		if (this.array[0] != null) {
			aux = this.array;
		}
		return aux;
	}
}
