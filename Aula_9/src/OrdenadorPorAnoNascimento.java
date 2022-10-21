package src;

public class OrdenadorPorAnoNascimento implements Ordenador{

    @Override
    public void ordenarPeloMetodoBolha(ColecaoPessoas listaDePessoas) {
        int tamanho = listaDePessoas.ObterTotalDePessoas();
		for(int i = 0; i < tamanho; i++){
			boolean controle = true;
			for(int j = 0; j < (tamanho -1); j++){
                if(listaDePessoas.ObterPessoa(j).getDataNas() > listaDePessoas.ObterPessoa(j+1).getDataNas() ){
                    listaDePessoas.TrocarPosicoesEntreDuasPessoas(j, j+1);
                    controle = false;
                }
				
			}
            if(controle)
            break;
		}
    }

    @Override
    public void ordenarPeloMetodoSelecao(ColecaoPessoas listaDePessoas) {
        int tamanho = listaDePessoas.ObterTotalDePessoas();
          for(int i = 0; i < tamanho; i++){
            int menorAno = i;
            for(int j = i + 1; j < tamanho; j++){
                if(listaDePessoas.ObterPessoa(j).getDataNas() < listaDePessoas.ObterPessoa(menorAno).getDataNas()){
                    menorAno = j;
                }

            }
            listaDePessoas.TrocarPosicoesEntreDuasPessoas(menorAno, i);

       
        } 
        
    }

    @Override
    public void ordenarPeloMetodoInsercao(ColecaoPessoas listaDePessoas) {
        int tamanho = listaDePessoas.ObterTotalDePessoas();
        int j;
        Pessoa auxiliar;

        for(int i = 1; i < tamanho; i++ ){
            auxiliar = listaDePessoas.ObterPessoa(i);
            j = i -1;
            while (j >= 0 && listaDePessoas.ObterPessoa(j).getDataNas() > auxiliar.getDataNas()) {
                
                Pessoa p = listaDePessoas.ObterPessoa(j);
                listaDePessoas.AlterarPessoa(j+1, p);
                j--;
            }
            listaDePessoas.AlterarPessoa(j+1, auxiliar);
        }  
    }

    @Override
    public void ordenarPeloMetodoQuickSort(ColecaoPessoas listaDePessoas, int inicio, int fim) {
        if(fim > inicio) {
            //Chamada da rotina que ira dividir o vetor em 3 partes.
            int indexPivo = dividir(listaDePessoas, inicio, fim);
            /* Chamada recursiva para redivisao do vetor de elementos menores
              que o pivô. */
            ordenarPeloMetodoQuickSort(listaDePessoas, inicio, indexPivo - 1);
            /* Chamada recursiva para redivisao do vetor de elementos maiores
              que o pivô. */
            ordenarPeloMetodoQuickSort(listaDePessoas, indexPivo + 1, fim);
          }
        
    }

    private int dividir(ColecaoPessoas listaDePessoas, int inicio, int fim){
        int pontEsq, pontDir = fim;
        int pivo;
        pontEsq = inicio + 1;
        pivo = listaDePessoas.ObterPessoa(inicio).getDataNas();
    
        while(pontEsq <= pontDir) {
         
          while(pontEsq <= pontDir && listaDePessoas.ObterPessoa(pontEsq).getDataNas() <= pivo) {
            
            pontEsq++;
          }
    
          
          while(pontDir >= pontEsq && listaDePessoas.ObterPessoa(pontDir).getDataNas() > pivo) {
            pontDir--;
          }
          if(pontEsq < pontDir) {
            listaDePessoas.TrocarPosicoesEntreDuasPessoas(pontDir, pontEsq);
            pontEsq++;
            pontDir--;
          }
        }
        listaDePessoas.TrocarPosicoesEntreDuasPessoas(inicio, pontDir);
        return pontDir;
    }
}
