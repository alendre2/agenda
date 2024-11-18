package util;

import entity.Contato;
import entity.Data;

public class Lista {
	
	private Item primeiro;
	
	public void insere_contato (String nome, String telefone, String celular, String email, Data dataAnivesario) {
		Contato contatoNovoContato = new Contato(nome, telefone, celular, email, dataAnivesario);
		
		Item item = new Item();
		
		if (contatoNovoContato == null || contatoNovoContato.getNome().compareToIgnoreCase(contatoNovoContato.getNome()) > 0) {
		item.setValor(contatoNovoContato);
		item.setProximo(item);
		
		primeiro = item;
		
		}
		
	}
}
