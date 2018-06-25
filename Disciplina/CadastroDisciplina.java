package Disciplina;

import Exceptions.*;

public class CadastroDisciplina {
	private RepositorioDisciplina repositorioDisciplina;
	
	public CadastroDisciplina(int escolha) {
		if (escolha == 1) {
			this.repositorioDisciplina = new RepositorioDisciplinaLista(); 
		}
		if (escolha == 2) {
			this.repositorioDisciplina = new RepositorioDisciplinaArray();
		}
	}

	
	public void cadastrarDisciplina(Disciplina disciplina) throws DisciplinaCadastradaException, MensalidadeIncorretaException {
		if (!repositorioDisciplina.procurar(disciplina.getNome())) {
			double aux = disciplina.getMensalidade();
			if (disciplina.checkMensalidade(aux)) {
				repositorioDisciplina.cadastrar(disciplina);
			} else {
				throw new MensalidadeIncorretaException();
			}
		} else {
			throw new DisciplinaCadastradaException(); 
		}
	}
	
	public void removerDisciplina(String nomeDisciplina) throws DisciplinaNaoCadastradaException {
		if (repositorioDisciplina.procurar(nomeDisciplina)) {
			repositorioDisciplina.remover(nomeDisciplina);
		} else {
			throw new DisciplinaNaoCadastradaException();
		}
	}
	
	public boolean procurarDisciplina(String nomeDisciplina) {
		return repositorioDisciplina.procurar(nomeDisciplina);
	}
	
	public void atualizarMensalidade(Disciplina disciplina) throws MensalidadeIncorretaException, DisciplinaNaoCadastradaException {
		if (repositorioDisciplina.procurar(disciplina.getNome())) {
			if (disciplina.checkMensalidade(disciplina.getMensalidade())) {
				repositorioDisciplina.atualizarMensalidade(disciplina);
			} else {
				throw new MensalidadeIncorretaException();
			}
		} else {
			throw new DisciplinaNaoCadastradaException();
		}
	}
	
	public Disciplina[] dados() throws NenhumaDisciplinaCadastradaException {
		if (repositorioDisciplina.dados() != null) {
			return repositorioDisciplina.dados();
		} else {
			throw new NenhumaDisciplinaCadastradaException();
		}
	}
}