package curCIn;

import Cantina.*;
import Curso.*;
import Disciplina.*;
import Material.*;
import Pessoa.*;
import Exceptions.*;

public class CadastroCurCIn {
	private CadastroCantina cadastroCantina;
	private CadastroCurso cadastroCurso;
	private CadastroDisciplina cadastroDisciplina;
	private CadastroMaterial cadastroMaterial;
	private CadastroPessoa cadastroPessoa;

	CadastroCurCIn(int escolha){
		this.cadastroCantina = new CadastroCantina(escolha);
		this.cadastroCurso = new CadastroCurso(escolha);
		this.cadastroDisciplina = new CadastroDisciplina(escolha);
		this.cadastroMaterial = new CadastroMaterial(escolha);
		this.cadastroPessoa = new CadastroPessoa(escolha);
		
	}
	
	public void inserirCantina(Cantina cant) throws CantinaExistenteException{
		cadastroCantina.inserirCantina(cant);
	}
	
	public Cantina nomeCantina(String nome) {
		return cadastroCantina.nomeCantina(nome);
	}
	
	public boolean procurarCantina(Cantina cant) {
		return cadastroCantina.procurarCantina(cant);
	}
	
	public void atualizarCantina(Cantina nova) throws CantinaNaoExistenteException{
		cadastroCantina.atualizarCantina(nova);
	}
	
	public void removerCantina(Cantina cant) throws CantinaNaoExistenteException{
		cadastroCantina.removerCantina(cant);
	}
	
	public String alarmeInicioCantina(Cantina cant) {
		return cadastroCantina.alarmeInicioCantina(cant);
	}
	
	public String alarmeFimCantina(Cantina cant) {
		return cadastroCantina.alarmeFimCantina(cant);
	}

	public void inserirMaterial(Material material) throws MaterialExistenteException{
		cadastroMaterial.inserirMaterial(material);
	}
	
	public boolean procurarMaterial(String material) {
		return cadastroMaterial.procurarMaterial(material);
	}
	
	public void atualizarMaterial(Material antigo, Material atual) throws MaterialNaoExistenteException{
		cadastroMaterial.atualizarMaterial(antigo, atual);
	}
	
	public void removerMaterial(String material) throws MaterialNaoExistenteException{
		cadastroMaterial.removerMaterial(material);
	}
	
	public void inserirCurso(Curso curso) throws CursoExistenteException{
		cadastroCurso.inserirCurso(curso);
	}
	
	public boolean procurarCurso(Curso curso) {
		return cadastroCurso.procurarCurso(curso);
	}
	
	public void atualizarCurso(Curso novo) throws CursoNaoExistenteException{
		cadastroCurso.atualizarCurso(novo);
	}
	
	public void removerCurso(Curso curso) throws CursoNaoExistenteException{
		cadastroCurso.removerCurso(curso);
	}
	
	public void cadastrarDisciplina(Disciplina disciplina) throws DisciplinaCadastradaException, MensalidadeIncorretaException {
		cadastroDisciplina.cadastrarDisciplina(disciplina);
	}
	
	public void removerDisciplina(String nomeDisciplina) throws DisciplinaNaoCadastradaException {
		cadastroDisciplina.removerDisciplina(nomeDisciplina);
	}
	
	public boolean procurarDisciplina(String nomeDisciplina) {
		return cadastroDisciplina.procurarDisciplina(nomeDisciplina);
	}
	
	public void atualizarMensalidade(Disciplina disciplina) throws MensalidadeIncorretaException, DisciplinaNaoCadastradaException {
		cadastroDisciplina.atualizarMensalidade(disciplina);
	}
	
	public Disciplina[] dadosDisciplina() throws NenhumaDisciplinaCadastradaException {
		return cadastroDisciplina.dados();
	}
	
	public void inserirPessoa(Pessoa pessoa) throws PessoaExistenteException{
		cadastroPessoa.inserirPessoa(pessoa);
	}
	
	public boolean procurarPessoa(String nomePessoa) {
		return cadastroPessoa.procurarPessoa(nomePessoa);
	}
	
	public void atualizarPessoa(Pessoa novo) throws PessoaNaoEncontradaException{
		cadastroPessoa.atualizarPessoa(novo);
	}
	
	public void removerPessoa(String pessoa) throws PessoaNaoEncontradaException{
		cadastroPessoa.removerPessoa(pessoa);
	}
	
	public Pessoa nomePessoa(String nome) {
		return cadastroPessoa.nomePessoa(nome);
	}
}