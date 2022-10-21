package src;
import java.io.*;
import java.util.Scanner;

import src.ListaDePessoas;
import src.ColecaoPessoas;
import src.Pessoa;
import src.TratamentoDados;
import src.VetorDePessoas; 



public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {

		Scanner entradaDoTeclado = new Scanner(System.in);
		ColecaoPessoas listaDePessoas; 

		System.out.println("escolha: 1-Vetor\n\t 2-Lista\n\t 3-Lista Encadeada");
		int opcaoArmazenamentoEmMemoria = entradaDoTeclado.nextInt();
		if (opcaoArmazenamentoEmMemoria == 1) {
			listaDePessoas = new VetorDePessoas();
		}
		else if(opcaoArmazenamentoEmMemoria == 2){
			listaDePessoas = new ListaDePessoas();
		}
		else {
			listaDePessoas = new ListaEncadeadaPessoas();
		}


		TratamentoDados date = new TratamentoDados();
		date.lerDoArquivo(listaDePessoas);
		
		int opcao;
		do 
		{
			System.out.println("\n\n*************** Menu de Opções ****************");
			System.out.println("1 - Adicionar Pessoa");
			System.out.println("2 - Obter Pessoa");
			System.out.println("3 - Listar Pessoas");
			System.out.println("4 - Exluir Pessoas");
			System.out.println("5 - Ordenar Pessoas");
			System.out.println("0 - Sair do programa");
			opcao = entradaDoTeclado.nextInt();	
			int opcao_interna = 0;		
			switch (opcao) {
			
			case 1: 
					System.out.println("Escolhas as opcoes:\n1- Adicionar Na Ultima Posicao\n"+
										"2- Adicionar em Posicao Desejada");
		
					opcao_interna = entradaDoTeclado.nextInt();
					menuInclusao(opcao_interna, listaDePessoas);
					break;
			case 2:
					obterPessoa(listaDePessoas);
					break;
			case 3: 
					listarPessoas(listaDePessoas);
					break;
			case 4: 
					System.out.println("Escolhas as opcoes:\n1- Exluir Ultima Pessoa\n"+
										"2- Exluir Por Nome\n3- Exluir Posicao");
					opcao_interna = entradaDoTeclado.nextInt();
					menuExclusao(opcao_interna, listaDePessoas);
					break;

			case 5: ordenarLista(listaDePessoas);
					break;
			}
			
			date.escreverNoArquivo(listaDePessoas);
		}
		while (opcao != 0);
	}

	private static void ordenarLista(ColecaoPessoas listaDePessoas){
		listaDePessoas.OrdenarLista(new OrdenadorPorAnoNascimento());
	}


	private static void menuInclusao(int opcao, ColecaoPessoas listaDePessoas){
		/*Menu contendo os metodos de inclusao 
		 opcao1 adiciona na ultima posicao da lista 
		 opcao2 adiciona a qualquer posicao desejada
		 */
		if(opcao == 1){
			System.out.println(opcao);
			adicionarPessoa(listaDePessoas);
		}
		else if(opcao == 2){
			System.out.println(opcao);
			Scanner entradaDoTeclado = new Scanner(System.in);
			System.out.println("Digite o indice da pessoa");
			int indicePessoa = entradaDoTeclado.nextInt();
			incluirPessoa(listaDePessoas, indicePessoa);
		}
	}


	private static void menuExclusao(int opcao, ColecaoPessoas listaDePessoas){
		/*Menu contendo os metodos de exlusao
		 opcao1 exclui na ultima posicao da lista 
		 opcao2 exclui qualquer pessoa passando o nome 
		 opcao3 exclui passando a posicao da pessoa 
		 */
		Scanner entradaDoTeclado = new Scanner(System.in);
		if(opcao == 1){
			excluirPessoa(listaDePessoas);
		}
		else if(opcao == 2){
			//entradaDoTeclado.nextLine();
			System.out.println("Digite o nome da pessoa");
			String nome  = entradaDoTeclado.nextLine();
			excluirPorNome(listaDePessoas, nome);
		}
		else if(opcao ==3){
			System.out.println("Digite o indice da pessoa");
			int indicePessoa = entradaDoTeclado.nextInt();
			
			if(indicePessoa != -1){
				excluirPessoaPosicao(listaDePessoas, indicePessoa);
			}
			else{
				 System.out.println("nao foi encontrado");
			}
			
		}
	}



	//METODOS 

	//add na ultima posicao 
	private static void adicionarPessoa(ColecaoPessoas pessoas){
		Scanner entradaDoTeclado = new Scanner(System.in);
		System.out.println("Nome: ");
		String nome = entradaDoTeclado.nextLine();
		System.out.println("Descricao: ");
		String descricao = entradaDoTeclado.nextLine();
		System.out.println("Genero: ");
		String genero = entradaDoTeclado.nextLine();
		System.out.println("Pais: ");
		String pais = entradaDoTeclado.nextLine();
		System.out.println("Ocupacao: ");
		String ocupacao = entradaDoTeclado.nextLine();
		System.out.println("Data Nascimento: ");
		int dataNas = entradaDoTeclado.nextInt();
		System.out.println("Data Morte: ");
		int dataMor = entradaDoTeclado.nextInt();
		Pessoa p = new Pessoa(nome, descricao, genero, pais, ocupacao, dataNas, dataMor);
		pessoas.AdicionarPessoa(p);
	}




	//Exclui o último elemento
	private static void excluirPessoa(ColecaoPessoas listaDePessoas) {
		boolean excluiu;
		excluiu = listaDePessoas.ExcluirPessoa();
		if (excluiu == true) {
			System.out.println("Pessoa excluída com sucesso.");
		}
		else {
			System.out.println("Pessoa não encontrad.");
		}
	}

	//exclui o elemento passando a posicao desejada 
	private static void excluirPessoaPosicao(ColecaoPessoas pessoas, int indicePessoa){
		boolean excluiu;
		excluiu = pessoas.ExcluirPessoaPorPosicao(indicePessoa);
		if (excluiu == true) {
			System.out.println("Pessoa excluída com sucesso.");
		}
		else {
			System.out.println("Pessoa não encontrada.");
		}
	}


	//exclui por nome 
	private static void excluirPorNome(ColecaoPessoas listaPessoas, String nome) {
		int posicaoPessoa = listaPessoas.BuscaPessoa(nome);
		excluirPessoaPosicao(listaPessoas, posicaoPessoa);
	}


	//lista todos objetos da lista 
	private static void listarPessoas(ColecaoPessoas pessoas){
		int totalDeJogos = pessoas.ObterTotalDePessoas();
		for(int indiceDoJogo = 0; indiceDoJogo < totalDeJogos; indiceDoJogo++) {
			Pessoa p = pessoas.ObterPessoa(indiceDoJogo);
			System.out.println("\n------------------------------------------");
			System.out.println("Nome:" + p.getNome());
			System.out.println("Descricao:" + p.getDescricao());
			System.out.println("Genero:" + p.getGenero());
			System.out.println("Pais:" + p.getPais());
			System.out.println("Ocupacao:" + p.getOcupacao());
			System.out.println("Data de Nascimento:" + p.getDataNas());
			System.out.println("Data de Morte:" + p.getDataMor());
			System.out.println("\n------------------------------------------");
		}
	}


	//inclui em uma posicao especifica
	private static void incluirPessoa(ColecaoPessoas pessoas, int indicePessoa){
		Scanner entradaDoTeclado = new Scanner(System.in);
		System.out.println("Nome: ");
		String nome = entradaDoTeclado.nextLine();
		System.out.println("Descricao: ");
		String descricao = entradaDoTeclado.nextLine();
		System.out.println("Genero: ");
		String genero = entradaDoTeclado.nextLine();
		System.out.println("Pais: ");
		String pais = entradaDoTeclado.nextLine();
		System.out.println("Ocupacao: ");
		String ocupacao = entradaDoTeclado.nextLine();
		System.out.println("Data Nascimento: ");
		int dataNas = entradaDoTeclado.nextInt();
		System.out.println("Data Morte: ");
		int dataMor = entradaDoTeclado.nextInt();
		Pessoa p = new Pessoa(nome, descricao, genero, pais, ocupacao, dataNas, dataMor);
		pessoas.IncluirPessoa(indicePessoa, p);
	}
    
	//busca a pessoa pelo nome
	private static void obterPessoa(ColecaoPessoas pessoas){
		Scanner entradaDoTeclado = new Scanner(System.in);
		System.out.println("Digite o nome: ");
		String nome = entradaDoTeclado.nextLine();
		int pos = pessoas.BuscaPessoa(nome);
		Pessoa p = pessoas.ObterPessoa(pos);

		System.out.println("\n------------------------------------------");
		System.out.println("Nome:" + p.getNome());
		System.out.println("Descricao:" + p.getDescricao());
		System.out.println("Genero:" + p.getGenero());
		System.out.println("Pais:" + p.getPais());
		System.out.println("Ocupacao:" + p.getOcupacao());
		System.out.println("Data de Nascimento:" + p.getDataNas());
		System.out.println("Data de Morte:" + p.getDataMor());
		System.out.println("\n------------------------------------------");
	}
}
