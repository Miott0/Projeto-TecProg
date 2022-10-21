package src;

public class ListaEncadeadaPessoas implements ColecaoPessoas {

    No inicio = null;
	int numeroDePessoas = 0;

    @Override
    public void AdicionarPessoa(Pessoa pessoa) {
        No novoNo = new No(pessoa);
		No noAtual = this.inicio;
		if (this.inicio != null) {
			while (noAtual.proximo != null) {
				noAtual = noAtual.proximo;
			}
			noAtual.proximo = novoNo;
		} else {
			this.inicio = novoNo;
		}
		numeroDePessoas++;
        
    }


    @Override
    public Pessoa ObterPessoa(int indicePessoa) {
        No noAtual = this.inicio;
		No noAnterior = null;
		int posicaoAtual = 0;
		
		if (this.inicio != null) {
			while ((noAtual != null) && (indicePessoa != posicaoAtual)) {
				noAnterior = noAtual;
				noAtual = noAtual.proximo;
				posicaoAtual++;
			}
			
			return noAtual.dado;
	
		}
		return null;
    }


    @Override
    public int ObterTotalDePessoas() {
        return numeroDePessoas;
    }


    @Override
    public boolean ExcluirPessoa() {
        No noAtual = this.inicio;
		No noAnterior = null;

		if (this.inicio != null) {
			while (noAtual.proximo != null) {
				noAnterior = noAtual;
				noAtual = noAtual.proximo;
			}
			if (noAnterior != null) {
				noAnterior.proximo = null;
			} else {
				this.inicio = null;
			}
            numeroDePessoas--;
			return true;
		}
		return false;
    }
    @Override

    public void IncluirPessoa(int indicePessoa, Pessoa pessoa) {
        No novoNo = new No(pessoa);
        No noAtual = this.inicio;
        No noAnterior = null;
        int posicaoAtual = 0;

        while ((noAtual != null) && (indicePessoa != posicaoAtual)) {
            noAnterior = noAtual;
            noAtual = noAtual.proximo;
            posicaoAtual++;
        }

        if (indicePessoa == posicaoAtual) {
            if (noAnterior == null) {
                novoNo.proximo = this.inicio;
                this.inicio = novoNo;
            }
            else {
                noAnterior.proximo = novoNo;
                novoNo.proximo = noAtual;
            }
        }      
    }


    @Override
    public boolean ExcluirPessoaPorPosicao(int indicePessoa) {
        No noAtual = this.inicio;
        No noAnterior = null;
        int posicaoAtual = 0;

        if (this.inicio != null) {
            while ((noAtual.proximo != null) && (indicePessoa != posicaoAtual)) {
                noAnterior = noAtual;
                noAtual = noAtual.proximo;
                posicaoAtual++;
            }
            if (indicePessoa == posicaoAtual) {
                if (noAnterior == null) {
                    this.inicio = noAtual.proximo;
                }
                else {
                    noAnterior.proximo = noAtual.proximo;
                }
                numeroDePessoas--;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int BuscaPessoa(String n) {
        No noAtual = this.inicio;
        No noAnterior = null;
        int posicaoAtual = 0;
        while ((noAtual != null)) {
            noAnterior = noAtual;
            noAtual = noAtual.proximo;
            
            if(n.equals(noAnterior.dado.getNome())){                   
                return posicaoAtual;
            }


            posicaoAtual++;
            }
           

        return -1;
    }
    @Override
    public void OrdenarLista(Ordenador ordenador) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void TrocarPosicoesEntreDuasPessoas(int i, int j) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void AlterarPessoa(int posicaoDaPessoa, Pessoa novaPessoa) {
        // TODO Auto-generated method stub
        
    }

}