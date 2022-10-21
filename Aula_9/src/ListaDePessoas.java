package src;

import java.util.ArrayList;

public class ListaDePessoas implements ColecaoPessoas {

    private ArrayList <Pessoa> listaDePessoas = null;
	

	public ListaDePessoas() {
		listaDePessoas = new ArrayList<Pessoa>();
	}
	

    @Override
    public void AdicionarPessoa(Pessoa pessoa) {
        this.listaDePessoas.add(pessoa);
    }

    @Override
    public Pessoa ObterPessoa(int indicePessoa) {
        return this.listaDePessoas.get(indicePessoa);
       
    }

    @Override
    public int ObterTotalDePessoas() {
        return this.listaDePessoas.size();
    }


    @Override
    public boolean ExcluirPessoa() {
        if (this.listaDePessoas.size() > 0) {
			int ultimaPessoaDaLista = this.listaDePessoas.size() - 1;
			this.listaDePessoas.remove(ultimaPessoaDaLista);
			return true;
		}
		return false; 
    }


    @Override
    public void IncluirPessoa(int indicePessoa, Pessoa pessoa){
        this.listaDePessoas.add(indicePessoa, pessoa);
        
    }


    @Override
    public boolean ExcluirPessoaPorPosicao(int indicePessoa) {
        if (this.listaDePessoas.size() > 0) {
			this.listaDePessoas.remove(indicePessoa);
			return true;
		}
		return false; 
    }


    @Override
    public int BuscaPessoa(String n) {
        int totalDePessoas = ObterTotalDePessoas();
        for(int posicao = 0; posicao < totalDePessoas; posicao++){
            String nome = this.listaDePessoas.get(posicao).getNome();
            if(n.equals(nome)){
                return posicao;
            }
        }
        return -1;
    }


    @Override
    public void OrdenarLista(Ordenador ordenador) {
        //ordenador.ordenarPeloMetodoBolha(this);
        //ordenador.ordenarPeloMetodoSelecao(this);
        //ordenador.ordenarPeloMetodoInsercao(this);
        ordenador.ordenarPeloMetodoQuickSort(this, 0, ObterTotalDePessoas() - 1);
        
    }


    @Override
    public void TrocarPosicoesEntreDuasPessoas(int primeiraPosicao, int segundaPosicao) {
        Pessoa armazenamentoAuxiliar;
        armazenamentoAuxiliar = this.listaDePessoas.get(primeiraPosicao);
        this.listaDePessoas.set(primeiraPosicao, this.listaDePessoas.get(segundaPosicao));
        this.listaDePessoas.set(segundaPosicao,armazenamentoAuxiliar);
        
    }

 

    @Override
    public void AlterarPessoa(int posicaoDaPessoa, Pessoa novaPessoa) {
        this.listaDePessoas.add(posicaoDaPessoa, novaPessoa);  
    }

   
    
}
