package Disciplina;

import Exceptions.*;

public class CadastroDisciplina {
	private RepositorioDisciplina repositorioDisciplina;
	
	CadastroDisciplina(RepositorioDisciplina repositorioDisciplina) {
		this.repositorioDisciplina = repositorioDisciplina;
	}

	
	public void cadastrarDisciplina(Disciplina disciplina) throws DisciplinaCadastradaException {
		if (!repositorioDisciplina.procurar(disciplina)) {
			repositorioDisciplina.cadastrar(disciplina);
		} else {
			throw new DisciplinaCadastradaException(); 
		}
	}
	
	public void removerDisciplina(Disciplina disciplina) throws DisciplinaNaoCadastradaException {
		if (repositorioDisciplina.procurar(disciplina)) {
			repositorioDisciplina.remover(disciplina);
		} else {
			throw new DisciplinaNaoCadastradaException();
		}
	}
	
	public boolean procurarDisciplina(Disciplina disciplina) {
		return repositorioDisciplina.procurar(disciplina);
	}
	
	public void atualizarMensalidade(Disciplina disciplinaAntiga, Disciplina disciplinaNova) throws MensalidadeIncorretaException {
		if (repositorioDisciplina.procurar(disciplinaAntiga)) {
			if (disciplinaNova.checkMensalidade(disciplinaNova.getMensalidade())) {
				repositorioDisciplina.atualizarMensalidade(disciplinaAntiga, disciplinaNova);
			} else {
				throw new MensalidadeIncorretaException();
			}
		}
	}
}