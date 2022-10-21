package src;
public interface Ordenador {
	public void ordenarPeloMetodoBolha(ColecaoPessoas listaDePessoas);
		
	public void ordenarPeloMetodoSelecao(ColecaoPessoas listaDePessoas);
	
	public void ordenarPeloMetodoInsercao(ColecaoPessoas listaDePessoas);

	public void ordenarPeloMetodoQuickSort(ColecaoPessoas listaDePessoas, int inicio, int fim);
}
