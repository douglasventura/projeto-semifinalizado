package Exceptions;

@SuppressWarnings("serial")
public class NenhumaDisciplinaCadastradaException extends Exception {
	
	public NenhumaDisciplinaCadastradaException() {
		super("O curso nao tem disciplinas cadastradas");
	}
}
