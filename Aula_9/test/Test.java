package test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import src.ListaDePessoas;
import src.OrdenadorPorAnoNascimento;
import src.ColecaoPessoas;
import src.Pessoa;
import src.TratamentoDados;
import src.VetorDePessoas;



public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {



		Scanner entradaDoTeclado = new Scanner(System.in);
		ColecaoPessoas listaDePessoas; 


		//listaDePessoas = new VetorDePessoas();
		listaDePessoas = new ListaDePessoas();
	
		TratamentoDados dados = new TratamentoDados();
		dados.lerDoArquivo(listaDePessoas);



		listaDePessoas.OrdenarLista(new OrdenadorPorAnoNascimento());

		
		








		listarPessoas(listaDePessoas);
		dados.escreverNoArquivo(listaDePessoas);
		
		
	}
 
	
	
	private static void listarPessoas(ColecaoPessoas pessoas){
		int totalDeJogos = pessoas.ObterTotalDePessoas();
		for(int indiceDoJogo = 0; indiceDoJogo < totalDeJogos; indiceDoJogo++) {
			Pessoa p = pessoas.ObterPessoa(indiceDoJogo);
			System.out.println("\n------------------------------------------");
			System.out.println("Nome:" + p.getNome());
			System.out.println("Data de Nascimento:" + p.getDataNas());
			System.out.println("Data de Morte:" + p.getDataMor());
			System.out.println("\n------------------------------------------");
		}
	}

}





/* private static void excluirPessoaPosicao(ColecaoPessoas pessoas, int indicePessoa){
		boolean excluiu;
		
		excluiu = pessoas.ExcluirPessoaPorPosicao(indicePessoa);
		if (excluiu == true) {
			System.out.println("Pessoa excluída com sucesso.");
		}
		else {
			System.out.println("Pessoa não encontrada.");
		}
	} */




	
 

	/* private static void obterPessoa(ColecaoPessoas pessoas){
		Scanner entradaDoTeclado = new Scanner(System.in);
		System.out.println("Digite a posicao: ");
		int pos = entradaDoTeclado.nextInt();
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
	} */