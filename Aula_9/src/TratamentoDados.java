package src;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;




public class TratamentoDados {

	public void lerDoArquivo(ColecaoPessoas listapessoas) throws FileNotFoundException, IOException {
		FileReader arquivoTextoLeitura = null;
		BufferedReader leituraBufferizada;
		Pessoa pessoa = null;
		String listaDeCampos[];
		String linhaLidaDoArquivo;

		
		try {
			arquivoTextoLeitura = new FileReader("C:/Users/Rafael/Desktop/Tec Programacao/Aula_7/dataset/AgeDataset-V2.csv");
			leituraBufferizada = new BufferedReader(arquivoTextoLeitura);
			linhaLidaDoArquivo = leituraBufferizada.readLine();
			
			while (linhaLidaDoArquivo != null) {
				listaDeCampos = linhaLidaDoArquivo.split(",");
				if (listaDeCampos.length == 10) {
					try {	
						int dataNascimento  = Integer.parseInt(listaDeCampos[6]);
						int dataMorte  = Integer.parseInt(listaDeCampos[7]);
						pessoa = new Pessoa(listaDeCampos[1], listaDeCampos[2], listaDeCampos[3], listaDeCampos[4], listaDeCampos[5], dataNascimento, dataMorte);
						listapessoas.AdicionarPessoa(pessoa);

					} catch (java.lang.NumberFormatException e) {
						
					}
					
				}
				linhaLidaDoArquivo = leituraBufferizada.readLine();
			}


		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro de entrada e saída!");
			e.printStackTrace();
		} 
		
		try {
			arquivoTextoLeitura.close();
		} 
		catch (IOException e) {
			System.out.println("Erro de entrada e saída!");
			e.printStackTrace();
		} 
		catch (NullPointerException e) {
			System.out.println("Erro: Arquivo não encontrado!");
			e.printStackTrace();
		}
	}

	public void escreverNoArquivo(ColecaoPessoas listaDePessoas) throws IOException {
		FileWriter arquivoDeSaida = null;
		String nome, descricao, genero, pais, ocupacao;
		int dataNas, dataMor;


		try {
			arquivoDeSaida = new FileWriter("C:/Users/Rafael/Desktop/Tec Programacao/Aula_7/dataset/AgeDataset-V3.txt");
			int totalDeJogos = listaDePessoas.ObterTotalDePessoas();
			
			for (int indiceDoJogo = 0; indiceDoJogo < totalDeJogos; indiceDoJogo++) {
				nome = listaDePessoas.ObterPessoa(indiceDoJogo).getNome();
				descricao = listaDePessoas.ObterPessoa(indiceDoJogo).getDescricao();
				genero = listaDePessoas.ObterPessoa(indiceDoJogo).getGenero();
				pais = listaDePessoas.ObterPessoa(indiceDoJogo).getPais();
				ocupacao = listaDePessoas.ObterPessoa(indiceDoJogo).getOcupacao();
				dataNas = listaDePessoas.ObterPessoa(indiceDoJogo).getDataNas();
				dataMor = listaDePessoas.ObterPessoa(indiceDoJogo).getDataMor();
				arquivoDeSaida.write(nome + "," + descricao + "," + genero + "," + pais + "," +
										ocupacao + "," + dataNas + ","+ dataMor +"\n");				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro de entrada e saída!");
			e.printStackTrace();
		}
		
		try {
			arquivoDeSaida.close();
		} 
		catch (IOException e) {
			System.out.println("Erro de entrada e saída!");
			e.printStackTrace();
		} 
		catch (NullPointerException e) {
			System.out.println("Erro: Arquivo não encontrado!");
			e.printStackTrace();
		}
	}
}
   

    

