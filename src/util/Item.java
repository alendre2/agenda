package util;

import entity.Contato;

public class Item {
	
	private Contato valor;
	private Item proximo;
	
	
	
	public Item(Contato valor) {
        this.valor = valor;
        this.proximo = null;
    }
	
	
	public Contato getValor() {
		return valor;
	}
	public void setValor(Contato valor) {
		this.valor = valor;
	}
	public Item getProximo() {
		return proximo;
	}
	public void setProximo(Item proximo) {
		this.proximo = proximo;
	}
	
	
		

}
