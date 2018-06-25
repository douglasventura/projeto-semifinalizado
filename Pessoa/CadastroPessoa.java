package Pessoa;

import Pessoa.Pessoa;
import Exceptions.*;

public class CadastroPessoa {

private RepositorioPessoa repositorioPessoa; 
	
	public CadastroPessoa(int escolha){
		if (escolha == 1) {
			this.repositorioPessoa = new RepositorioPessoaLista(); 
		}
		else if (escolha == 2) {
			this.repositorioPessoa = new RepositorioPessoaArray();
		}
	}
	
	public void inserirPessoa(Pessoa pessoa) throws PessoaExistenteException{
		if (repositorioPessoa.procurar(pessoa.getNome()) == false) {
			repositorioPessoa.inserir(pessoa);
		}
		else {
			throw new PessoaExistenteException();
		}
	}
	
	public boolean procurarPessoa(String pessoa) {
		return repositorioPessoa.procurar(pessoa);
	}
	
	public void atualizarPessoa(Pessoa novo) throws PessoaNaoEncontradaException{
		if (repositorioPessoa.procurar(novo.getNome()) == true) {
			repositorioPessoa.atualizar(novo);
		}
		else {
			throw new PessoaNaoEncontradaException();
		}
	}
	
	public void removerPessoa(String pessoa) throws PessoaNaoEncontradaException{
		if (repositorioPessoa.procurar(pessoa) == true) {
			repositorioPessoa.remover(pessoa);
		}
		else {
			throw new PessoaNaoEncontradaException();
		}
	}
	public Pessoa nomePessoa(String nome){
		return repositorioPessoa.nome(nome);		
	}
}