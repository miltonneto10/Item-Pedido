/* Nesse código eu quero implementar um método que remova os itens inválidos de uma coleção de itens de um pedido. Um item de pedido possui os seguintes atributos:
	# A quantidade
	# O preço unitário
	# O produto solicitado
Um item válido é aquele que tem uma quantidade de 1 a 100 */

public class ItemPedido {
	private Produto produto;
	private int quantidade;
	private int precoUnitarioEmCentavos;
	
	public ItemPedido(Produto produto, int quantidade, int valorEmCentavos) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitarioEmCentavos = valorEmCentavos;
	}
	public int valor() {
		return quantidade * precoUnitarioEmCentavos;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getPrecoUnitarioEmCentavos() {
		return precoUnitarioEmCentavos;
	}
	public void setPrecoUnitarioEmCentavos(int precoUnitarioEmCentavos){
		this.precoUnitarioEmCentavos = precoUnitarioEmCentavos;
	}
/*Agora vamos ter a primeira implementação da operação de remoção dos itens válidos: */
	public void removerItensInvalidos(Collection<ItemPedido> itens) throws Exception{
		Iterator<ItemPedido> cursor = null;
		if (itens instanceof ArrayList)
			//O ArrayList representa estruturas como Arrays.
			cursor = new ArrayIterator((ArrayList) itens);
		else if (itens instanceof HashSet)
			//O HashSet representa estruturas como conjuntos chave-valor
			cursor = new HashSetIterator((HashSet) itens);
		
		if (cursor == null)
			throw new Exception ("tipo da coleção de itens inválido");
		while (cursor.hasNext()) {
			//O hasNext verifica se existe um próximo elemento no ArrayList ou se o cursor já está posicionado no último elemento.
			ItemPedido item = cursor.next();
			//O next retorna o próximo elemento do ArrayList. Na primeira chamada, ele retorna o primeiro elemento da coleção.
			if (! isValido(item)) {
				cursor.remove(item);
			//O "remove", remove um elemento da coleção.
			}
		}
	}
}

	public boolean isValido(ItemPedido item) {
		return (item.getQuantidade() > 0 && item.getQuantidade() <100);
	}