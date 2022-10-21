package src;

public class VetorDePessoas implements ColecaoPessoas {
    Pessoa vetorPessoa[];
    int totalDePessoas;


    
    public VetorDePessoas(){
        this.vetorPessoa = new Pessoa[1095379];
        this.totalDePessoas = 0 ;

    }


    public VetorDePessoas(int tamanhoVetor){
        this.vetorPessoa = new Pessoa[tamanhoVetor];
        this.totalDePessoas = 0 ;
    }

    @Override
    public void AdicionarPessoa(Pessoa pessoa){
        vetorPessoa[totalDePessoas] = pessoa;
        totalDePessoas ++;
    }

    @Override
    public Pessoa ObterPessoa(int indicePessoa){
        return vetorPessoa[indicePessoa];
    }

    @Override
    public int ObterTotalDePessoas(){
        return totalDePessoas;
    }


    @Override
    public boolean ExcluirPessoa() {
        if (this.totalDePessoas > 0) {
			this.totalDePessoas--;
			return true;
		}
		return false;
    }

    @Override
    public void IncluirPessoa(int indicePessoa, Pessoa pessoa) {
        if ((indicePessoa >= 0 && indicePessoa < this.vetorPessoa.length)){
            for(int posicao = this.totalDePessoas; posicao >= indicePessoa; posicao-- ){
               this.vetorPessoa[posicao+1] = this.vetorPessoa[posicao];
            }
            this.vetorPessoa[indicePessoa] = pessoa;
            this.totalDePessoas++;
            
        }
    }


    @Override
    public boolean ExcluirPessoaPorPosicao(int indicePessoa) {
        if ((indicePessoa >= 0 && indicePessoa < this.vetorPessoa.length)){
            for(int posicao = indicePessoa; posicao < this.totalDePessoas - 1; posicao++ ){
                this.vetorPessoa[posicao] = this.vetorPessoa[posicao+1];
            }
            this.totalDePessoas--;
            return true;
            
        }
        return false;
    }


    public int BuscaPessoa(String n){
        int posicao;
        for( posicao = 0; posicao  < totalDePessoas; posicao ++){
            String nome = this.vetorPessoa[posicao].getNome();
            if(n.equals(nome)){
                return posicao;
            }
        }
        
        return -1;
    } 


    @Override
    public void OrdenarLista(Ordenador ordenador) {
        //ordenador.ordenarPeloMetodoBolha(this);
        ordenador.ordenarPeloMetodoSelecao(this);
        //ordenador.ordenarPeloMetodoInsercao(this);
        //ordenador.ordenarPeloMetodoQuickSort(this, 0, this.totalDePessoas - 1);
        
    }


    @Override
    public void TrocarPosicoesEntreDuasPessoas(int primeiraPosicao, int segundaPosicao) {
        Pessoa armazenamentoAuxiliar; 
		armazenamentoAuxiliar = this.vetorPessoa[primeiraPosicao];
		this.vetorPessoa[primeiraPosicao] = this.vetorPessoa[segundaPosicao];
		this.vetorPessoa[segundaPosicao] = armazenamentoAuxiliar;
        
    }


    @Override
	public void AlterarPessoa(int posicaoDaPessoa, Pessoa novaPessoa) {
		this.vetorPessoa[posicaoDaPessoa] = novaPessoa;
		
	}

   


}
