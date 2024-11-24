package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entity.Contato;
import entity.Data;

/**
 * Classe Lista representa uma lista encadeada para armazenar objetos do tipo Contato.
 * 
 * A lista mantém os contatos ordenados alfabeticamente por nome.
 * Permite realizar operações como inserir, buscar, listar, remover, atualizar
 * e salvar os contatos em um arquivo. Também suporta o carregamento de contatos
 * a partir de um arquivo externo.
 */
public class Lista {

    private Item primeiro;

    /**
     * Construtor padrão que inicializa a lista como vazia.
     */
    public Lista() {
        this.primeiro = null;
        carregarDados();
    }

    /**
     * Insere um novo contato na lista em ordem alfabética.
     * 
     * @param contato O objeto Contato a ser inserido.
     *                Se já existir um contato com o mesmo nome, não será inserido.
     */
    public void insere_contato(Contato contato) {
        if (buscaContato(contato.getNome()) != null) {
            System.out.println("Contato com o mesmo nome já existe na agenda.");
            return;
        }

        Item novo = new Item(contato);

        if (primeiro == null || primeiro.getValor().getNome().compareToIgnoreCase(contato.getNome()) > 0) {
            novo.setProximo(primeiro);
            primeiro = novo;
        } else {
            Item atual = primeiro;
            while (atual.getProximo() != null &&
                   atual.getProximo().getValor().getNome().compareToIgnoreCase(contato.getNome()) < 0) {
                atual = atual.getProximo();
            }
            novo.setProximo(atual.getProximo());
            atual.setProximo(novo);
        }
        
        salvarDadosContatos();
    }

    /**
     * Busca um contato na lista pelo nome.
     * 
     * @param nome O nome do contato a ser buscado.
     * @return O objeto Contato correspondente, ou null se não for encontrado.
     */
    public Contato buscaContato(String nome) {
        Item atual = primeiro;
        while (atual != null) {
            if (atual.getValor().getNome().equalsIgnoreCase(nome)) {
                return atual.getValor();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    /**
     * Lista apenas os nomes dos contatos armazenados na lista.
     * Exibe uma mensagem de erro se a lista estiver vazia.
     */
    public void listarNomesContatos() {
        if (primeiro == null) {
            System.out.println("Erro: Agenda está vazia.");
            return;
        }

        Item atual = primeiro;
        while (atual != null) {
            System.out.println(atual.getValor().getNome());
            atual = atual.getProximo();
        }
    }

    /**
     * Lista os detalhes de um contato específico pelo nome.
     * 
     * @param nome O nome do contato a ser exibido.
     *             Se não for encontrado, exibe uma mensagem informativa.
     */
    public void listarContatos(String nome) {
        Contato contato = buscaContato(nome);
        if (contato == null) {
            System.out.println("Contato não está na lista.");
        } else {
            System.out.println(contato);
        }
    }

    /**
     * Remove um contato da lista pelo nome.
     * 
     * @param nome O nome do contato a ser removido.
     *             Atualiza o arquivo após a remoção.
     *             Exibe uma mensagem caso o contato não seja encontrado.
     */
    public void removerContato(String nome) {
        if (primeiro == null) {
            System.out.println("Agenda está vazia.");
            return;
        }

        if (primeiro.getValor().getNome().equals(nome)) {
            primeiro = primeiro.getProximo();
            salvarDadosContatos();
            return;
        }

        Item atual = primeiro;
        while (atual.getProximo() != null) {
            if (atual.getProximo().getValor().getNome().equals(nome)) {
                atual.setProximo(atual.getProximo().getProximo());
                salvarDadosContatos();
                return;
            }
            atual = atual.getProximo();
        }

        System.out.println("Usuário não encontrado.");
    }

    /**
     * Atualiza os dados de um contato existente.
     * 
     * @param nome        O nome do contato a ser atualizado.
     * @param contatoNovo O novo objeto Contato com os dados atualizados.
     */
    public void atualizarContato(String nome, Contato contatoNovo) {
    	
        removerContato(nome);
        
        if (!nome.equals(contatoNovo.getNome()) && buscaContato(contatoNovo.getNome()) != null) {
            System.out.println("Contato com o mesmo nome já existe.");
            return;
        }

    	
        insere_contato(contatoNovo);
    }

    /**
     * Salva os dados da lista de contatos em um arquivo chamado "agenda.txt".
     * Cada linha do arquivo representa um contato no formato:
     * nome;telefone;celular;email;dia;mes
     */
    public void salvarDadosContatos() {
        try (BufferedWriter escrever = new BufferedWriter(new FileWriter("src/agenda.txt"))) {
            Item atual = primeiro;
            while (atual != null) {
                Contato contato = atual.getValor();
                escrever.write(String.format("%s,%s,%s,%s,%02d,%02d%n",
                                             contato.getNome(),
                                             contato.getTelefone(),
                                             contato.getCelular(),
                                             contato.getEmail(),
                                             contato.getDataAnivesario().getDia(),
                                             contato.getDataAnivesario().getMes()));
                atual = atual.getProximo();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }


    /**
     * Carrega os dados de contatos a partir de um arquivo chamado "agenda.txt".
     * Cada linha do arquivo deve estar no formato:
     * nome;telefone;celular;email;dia;mes
     */
    private void carregarDados() {
        try (BufferedReader leitor = new BufferedReader(new FileReader("src/agenda.txt"))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println("Linha lida: " + linha);  // Verifica o que está sendo lido

                String[] dados = linha.split(",");
                int dia = Integer.parseInt(dados[4]);
                int mes = Integer.parseInt(dados[5]);

                Data data = new Data(dia, mes);
                Contato contato = new Contato(dados[0], dados[1], dados[2], dados[3], data);

                insere_contato(contato);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados do arquivo: " + e.getMessage());
        }
    }

}
