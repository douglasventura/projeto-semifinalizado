package curCIn;

import java.util.Scanner;
import Cantina.*;
import Curso.*;
import Disciplina.*;
import Exceptions.*;
import Material.*;
import Pessoa.*;

public class Programa {
	public static void main(String[] args) throws CantinaExistenteException, CantinaNaoExistenteException, CursoExistenteException, CursoNaoExistenteException, DisciplinaCadastradaException, DisciplinaNaoCadastradaException, DisciplinaNaoEncontradaException, MaterialExistenteException, MaterialNaoExistenteException, MensalidadeIncorretaException, PessoaExistenteException, PessoaNaoEncontradaException {
		Scanner in = new Scanner(System.in);
		System.out.println("Bem vindo ao registro do CurCIn!");
		System.out.println("Para iniciar, que tipo de repositorio deseja utilizar?");
		try {
			System.out.println("1 - Lista       2 - Array");
			int tipoRep = Integer.parseInt(in.nextLine());
			if (tipoRep == 1) {
				System.out.println("Voce escolheu o tipo Lista. Vamos comecar!");
			}
			if (tipoRep == 2) {
				System.out.println("Voce escolheu o tipo Array. Vamos comecar!");
			}
			CadastroCurCIn cc = new CadastroCurCIn(tipoRep);
			boolean repetidor = true;
			while (repetidor) {
				System.out.println("Digite o numero do tipo de registro que voc� deseja manipular:");
				System.out.println("0 - Sair");
				System.out.println("1 - Cantina");
				System.out.println("2 - Curso");
				System.out.println("3 - Disciplina");
				System.out.println("4 - Material");
				System.out.println("5 - Aluno");
				System.out.println("6 - Funcionario");
				int codigoRegistro = Integer.parseInt(in.nextLine());

				if (codigoRegistro == 0) {
					repetidor = false;
				}

				else if (codigoRegistro == 1) {
					System.out.println("Voc� escolheu cantina! O que voc� deseja fazer?");
					System.out.println("1 - Criar uma cantina e registr�-la no reposit�rio");
					System.out.println("2 - Manipular as cantinas existentes.");
					int cRCantina = Integer.parseInt(in.nextLine());

					if (cRCantina == 1) {
						System.out.println("Voc� deseja registrar uma cantina!");
						System.out.println("Qual o nome do prato principal da cantina? ");
						String nomeP = in.nextLine();
						System.out.println("Qual o seu pre�o? ");
						double precoP = Double.parseDouble(in.nextLine());
						Prato prato = new Prato(nomeP, precoP);
						System.out.println("Devemos registrar o gerente no sistema.");
						System.out.println("Qual seu nome?");
						String nome = in.nextLine();
						System.out.println("Quando ele nasceu? (DD/MM/AA)");
						String data = in.nextLine();
						System.out.println("Qual seu CPF?");
						String cpf = in.nextLine();
						Pessoa pessoa = new Funcionario(nome, data, cpf);
						System.out.println("Qual o nome da sua cantina?");
						String nomeC = in.nextLine();
						Cantina cant = new Cantina(nomeC, prato, pessoa);
						cc.inserirCantina(cant);
						System.out.println("A cantina " + cant.getNome() + " foi inserida no sistema.");
						System.out.println("");
					}

					else if (cRCantina == 2) {
						System.out.println("O que deseja fazer?");
						System.out.println("1 - Ver quais cantinas est�o no reposit�rio");
						System.out.println("2 - Imprimir dados de alguma cantina especifica");
						System.out.println("3 - Manipular alguma cantina especifica");
						System.out.println("4 - Manipular o reposit�rio");
						int tipoM = Integer.parseInt(in.nextLine());
						if (tipoM == 1) {
							System.out.println("As seguintes cantinas estao no sistema: ");
							// mostrar nome das cantinas que estao no sistema

						} else if (tipoM == 2) {
							System.out.println("Qual o nome da cantina que voc� deseja ver?");
							String nomeC = in.nextLine();
							System.out.println("Nome da cantina: " + cc.nomeCantina(nomeC).getNome());
							System.out.println("Prato principal: " + cc.nomeCantina(nomeC).getPrato().getNome());
							System.out.println(
									"Preco do prato principal: R$" + cc.nomeCantina(nomeC).getPrato().getPreco());
							System.out.println("Nome do gerente: " + cc.nomeCantina(nomeC).getGerente().getNome());
							System.out.println("");

						} else if (tipoM == 3) {
							System.out.println("Qual o nome da cantina que voc� deseja manipular?");
							String nomeC = in.nextLine();
							System.out.println("Deseja mudar seu nome? (S/N)");
							String respN = in.nextLine();
							if (respN.equals("S") || respN.equals("s")) {
								System.out.println("Qual sera o novo nome?");
								String nomeNovo = in.nextLine();
								cc.nomeCantina(nomeC).setNome(nomeNovo);
								nomeC = nomeNovo;
								System.out.println("Nome alterado!");
							}
							System.out.println("Deseja mudar o prato principal? (S/N)");
							String respP = in.nextLine();
							if (respP.equals("S") || respP.equals("s")) {
								System.out.println("Qual o nome do novo prato?");
								String respPN = in.nextLine();
								System.out.println("Qual ser� seu preco?");
								Double respPP = Double.parseDouble(in.nextLine());
								Prato prato = new Prato(respPN, respPP);
								cc.nomeCantina(nomeC).setPrato(prato);
							}
							System.out.println("Dados alterados com sucesso!");
						} else if (tipoM == 4) {
							System.out.println("O que deseja fazer no reposit�rio? ");
							System.out.println("1 - Checar se uma cantina existe");
							System.out.println("2 - Remover uma cantina do reposit�rio");
							System.out.println("3 - Soar alarme de in�cio de expediente");
							System.out.println("4 - Soar alarme de fim de expediente");
							int manRep = Integer.parseInt(in.nextLine());
							if (manRep == 1) {
								System.out.println("Qual o nome da cantina que deseja checar?");
								String nomeC = in.nextLine();
								if (cc.procurarCantina(cc.nomeCantina(nomeC))) {
									System.out.println("A cantina " + nomeC + " esta no repositorio.");
								}
								else {
									System.out.println("A cantina " + nomeC + " nao esta no repositorio.");
								}
							}
							if (manRep == 2) {
								System.out.println("Qual o nome da cantina que deseja remover?");
								String nomeC = in.nextLine();
								cc.removerCantina(cc.nomeCantina(nomeC));
								System.out.println("Cantina removida com sucesso");
							}
							if (manRep == 3) {
								System.out.println("Digite o nome da cantina que quer soar o alarme de inicio.");
								String nomeC = in.nextLine();
								System.out.println(cc.alarmeInicioCantina(cc.nomeCantina(nomeC)));
							}
							if (manRep == 4) {
								System.out.println("Digite o nome da cantina que quer soar o alarme de fim.");
								String nomeC = in.nextLine();
								System.out.println(cc.alarmeFimCantina(cc.nomeCantina(nomeC)));
							}

						}
					}
				}

				else if (codigoRegistro == 2) {

				}

				else if (codigoRegistro == 3) {

				}

				else if (codigoRegistro == 4) {
					System.out.println("Voce escolheu Material! O que deseja fazer a seguir?");
					System.out.println("1 - Registrar um material no repositorio");
					System.out.println("2 - Remover um material do repositorio.");
					System.out.println("3 - Atualizar um material do repositorio.");
					int cRMaterial = Integer.parseInt(in.nextLine());
					if (cRMaterial == 1) {
						System.out.println("Voce deseja registrar um material, siga as instrucoes ate o final!");
						System.out.println("Digite o titulo do material por favor");
						String tit = in.nextLine();
						System.out.println("Digite o tipo do material por favor");
						String tip = in.nextLine();
						System.out.println("Digite o inteiro do nivel do material por favor");
						int nvl = Integer.parseInt(in.nextLine());
						Material material = new Material(tit, tip, nvl);
						if (cc.procurarMaterial(tit)) {
							throw new MaterialExistenteException();
						} else {
							cc.inserirMaterial(material);
							System.out.println("Voce adicionou " + material.getTitulo() + " com sucesso!");

						}

					} else if (cRMaterial == 2) {
						System.out.println("Voce deseja remover um material!");
						System.out.println("Digite o titulo do material por favor");
						String tit = in.nextLine();

						if (cc.procurarMaterial(tit)) {
							cc.removerMaterial(tit);
							System.out.println("Voce removeu " + tit + " com sucesso!");


						} else {
							throw new MaterialNaoExistenteException();
						}

					} else if (cRMaterial == 3) {
						System.out.println("Voce deseja atualizar um material!");
						System.out.println("Digite o titulo do material por favor");
						String tit = in.nextLine();


					}
				}

				else if (codigoRegistro == 5) {
					System.out.println("Voce escolheu Aluno! O que deseja fazer a seguir?");
					System.out.println("1 - Adicionar um aluno ao sistema");
					System.out.println("2 - Manipular os cadastros dos alunos existentes");
					int cRAluno = Integer.parseInt(in.nextLine());
					if (cRAluno == 1) {
						System.out.println("Voce deseja adicionar um aluno!");
						System.out.println("Digite o nome do aluno por favor");
						String nomeAluno = in.nextLine();
						System.out.println("Digite a sua data de nascimento por favor");
						String dataNascAluno = in.nextLine();
						String matricula = nomeAluno+"-"+dataNascAluno;
						Aluno alun = new Aluno (nomeAluno, dataNascAluno, matricula);
						cc.inserirPessoa(alun);
						System.out.println("Voce adicionou "+nomeAluno+" com sucesso!");

					}
					else if (cRAluno == 2) {
						System.out.println("OK, voce decidiu manipular os cadastros existentes");
						System.out.println("O que deseja fazer?");
						System.out.println("1 - Ver se um aluno esta matriculado");
						System.out.println("2 - Imprimir dados de alguma aluno em especifico");
						System.out.println("3 - Atualizar algum cadastro de aluno");
						System.out.println("4 - Remover algum cadastro de aluno");
						int manipAlunos = Integer.parseInt(in.nextLine());

						if (manipAlunos == 1) {
							System.out.println("Por favor digite o nome do aluno");
							String nomeAluno = in.nextLine();
							if (cc.procurarPessoa(nomeAluno)) {
								System.out.println("O aluno se encontra em nossos sistemas");
							}
							else {
								System.out.println("Nao conseguimos encontrar o aluno, por favor tente novamente");
							}

						}
						else if (manipAlunos == 2) {
							System.out.println("Por favor digite o nome do aluno que deseja");
							String nomeAluno = in.nextLine();
							if (cc.procurarPessoa(nomeAluno)) {
								Aluno este = (Aluno) cc.nomePessoa(nomeAluno);
								System.out.println("Sua matricula e: "+este.getMatricula());
								System.out.println("Sua data de nascimento e: "+este.getNascimento());
							}
							else {
								System.out.println("Nao conseguimos encontrar o aluno, por favor tente novamente");
							}
						}
						else if (manipAlunos == 3) {
							System.out.println("Por favor digite o nome do aluno");
							String nomeAluno = in.nextLine();
							if (cc.procurarPessoa(nomeAluno)) {
								System.out.println("Por favor insira a data de nascimento nova");
								String dataNovaAluno = in.nextLine();
								String matricAluno = nomeAluno+"-"+dataNovaAluno;
								Aluno novo = new Aluno (nomeAluno, dataNovaAluno, matricAluno);
								cc.atualizarPessoa(novo);								
							}
							else {
								System.out.println("Aluno nao encontrado");
							}

						}
						else if (manipAlunos == 4) {
							System.out.println("Digite o nome do aluno que ter� o cadastro removido!");
							String nomeAluno = in.nextLine();
							if (cc.procurarPessoa(nomeAluno)) {
								cc.removerPessoa(nomeAluno);
							}
							else {
								System.out.println("Aluno nao encontrado");
							}

						}
					}

				}
				else if (codigoRegistro == 6) {
					System.out.println("Voce escolheu Funcionario! O que deseja fazer a seguir?");
					System.out.println("1 - Adicionar um funcionario ao sistema");
					System.out.println("2 - Manipular os cadastros dos funcionarios existentes");
					int cRFuncionario = Integer.parseInt(in.nextLine());
					if (cRFuncionario == 1) {
						System.out.println("Voce deseja adicionar um funcionario!");
						System.out.println("Digite o nome do funcionario por favor");
						String nomeFuncionario = in.nextLine();
						System.out.println("Digite a sua data de nascimento por favor");
						String dataNascFuncionario = in.nextLine();
						System.out.println("Digite seu cpf por favor");
						Funcionario func = new Funcionario (nomeFuncionario, dataNascFuncionario, dataNascFuncionario);
						cc.inserirPessoa(func);
						System.out.println("Voce adicionou "+nomeFuncionario+" com sucesso!");

					}
					else if (cRFuncionario == 2) {
						System.out.println("OK, voce decidiu manipular os cadastros existentes");
						System.out.println("O que deseja fazer?");
						System.out.println("1 - Ver se um funcionario esta matriculado");
						System.out.println("2 - Imprimir dados de alguma funcionario em especifico");
						System.out.println("3 - Atualizar algum cadastro de funcionario");
						System.out.println("4 - Remover algum cadastro de funcionario");
						int manipFuncionarios = Integer.parseInt(in.nextLine());

						if (manipFuncionarios == 1) {
							System.out.println("Por favor digite o nome do funcionario");
							String nomeFuncionario = in.nextLine();
							if (cc.procurarPessoa(nomeFuncionario)) {
								System.out.println("O funcionario se encontra em nossos sistemas");
							}
							else {
								System.out.println("Nao conseguimos encontrar o funcionario, por favor tente novamente");
							}

						}
						else if (manipFuncionarios == 2) {
							System.out.println("Por favor digite o nome do funcionario que deseja");
							String nomeFuncionario = in.nextLine();
							if (cc.procurarPessoa(nomeFuncionario)) {
								Funcionario este = (Funcionario) cc.nomePessoa(nomeFuncionario);
								System.out.println("Seu cpf e: "+este.getCpf());
								System.out.println("Sua data de nascimento e: "+este.getNascimento());
							}
							else {
								System.out.println("Nao conseguimos encontrar o funcionario, por favor tente novamente");
							}
						}
						else if (manipFuncionarios == 3) {
							System.out.println("Por favor digite o nome do funcionario");
							String nomeFuncionario = in.nextLine();
							if (cc.procurarPessoa(nomeFuncionario)) {
								System.out.println("Por favor insira a data de nascimento nova");
								String dataNovaFuncionario = in.nextLine();
								System.out.println("Por favor insira o cpf novo");
								String cpfNovoFuncionario = in.nextLine();
								Aluno novo = new Aluno (nomeFuncionario, dataNovaFuncionario, cpfNovoFuncionario);
								cc.atualizarPessoa(novo);								
							}
							else {
								System.out.println("Aluno nao encontrado");
							}

						}
						else if (manipFuncionarios == 4) {
							System.out.println("Digite o nome do funcionario que ter� o cadastro removido!");
							String nomeFuncionario = in.nextLine();
							if (cc.procurarPessoa(nomeFuncionario)) {
								cc.removerPessoa(nomeFuncionario);
							}
							else {
								System.out.println("Aluno nao encontrado");
							}

						}
					}

				}

				else if (codigoRegistro > 6 || codigoRegistro < 0) {
					System.out.println("Entrada invalida, por favor tente novamente!");
				}
				System.out.println("");
			}

		} catch (CantinaExistenteException x) {
			System.out.println(x.getMessage());
		}
		catch (CantinaNaoExistenteException x) {
			System.out.println(x.getMessage());
		}

		catch (CursoExistenteException x) {
			System.out.println(x.getMessage());
		}
		catch (CursoNaoExistenteException x) { //calma que o erro ir� sumir a medida que fomos criando os codigos
			System.out.println(x.getMessage());
		}
		catch (DisciplinaCadastradaException x) {
			System.out.println(x.getMessage());
		}
		catch (DisciplinaNaoCadastradaException x) {
			System.out.println(x.getMessage());
		}
		catch (DisciplinaNaoEncontradaException x) {
			System.out.println(x.getMessage());
		}
		catch (MaterialExistenteException x) {
			System.out.println(x.getMessage());
		}
		catch (MaterialNaoExistenteException x) {
			System.out.println(x.getMessage());
		}
		catch (MensalidadeIncorretaException x) {
			System.out.println(x.getMessage());
		}
		catch (PessoaExistenteException x) {
			System.out.println(x.getMessage());
		}
		catch (PessoaNaoEncontradaException x) {
			System.out.println(x.getMessage());
		}

	}
}
