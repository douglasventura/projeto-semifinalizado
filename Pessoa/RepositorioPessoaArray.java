package Pessoa;

import Pessoa.Pessoa;

public class RepositorioPessoaArray implements RepositorioPessoa {
	private Pessoa[] array;
	private int contador;

	public RepositorioPessoaArray() {
		this.array = new Pessoa[20];
		this.contador = 0;
	}

	public void inserir(Pessoa nome) {
		if (contador == array.length) {
			Pessoa[] novaArray = new Pessoa[contador * 2];
			for (int i = 0; i < contador; i++) {
				novaArray[i] = array[i];
			}
			this.array = novaArray;
		}
		this.array[contador] = nome;
		contador++;
	}

	public void remover(String nome) {
		for (int i = 0; i < array.length; i++) {
			if (this.array[i].getNome()!=null && this.array[i].getNome().equals(nome)) {
				for (int j = i; j < array.length; j++) {
					this.array[i] = this.array[i + 1];
				}
			}
		}
	}

	public void atualizar(Pessoa novo) {
		for (int i = 0; i < array.length; i++) {
			if (this.array[i].equals(novo)) {
				if (novo instanceof Aluno) {
					Aluno novoAluno = (Aluno) novo;
					Aluno antigoAluno = (Aluno) array[i];
					antigoAluno.setNascimento(novo.getNascimento());
					antigoAluno.setMatricula(novoAluno.getMatricula());
				}
				else {
					Funcionario novoFuncionario = (Funcionario) novo;
					Funcionario antigoFuncionario = (Funcionario) array[i];
					antigoFuncionario.setNascimento(novoFuncionario.getNascimento());
					antigoFuncionario.setCpf(novoFuncionario.getCpf());
				}
			}
		}
	}

	public boolean procurar(String nome) {
		for (int i = 0; i < array.length; i++) {
			if (this.array[i].getNome()!=null && this.array[i].getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}

	public Pessoa nome(String nome) {
		Pessoa pessoa = null;
		for (int i = 0; i < array.length; i++) {
			if (array[i].getNome().equals(nome)) {
				pessoa = array[i];
			}
		}
		return pessoa;
	}
}