package aplicativo;



import java.util.Scanner;

import entity.Contato;
import entity.Data;
import util.Lista;

public class Programa {
    public static void main(String[] args) {
        Lista agenda = new Lista();
        Scanner sc = new Scanner(System.in);

        while (true) {
        	
        	System.out.println();
        	System.out.println("-------------------------");
            System.out.println("1 - Inserir Contato");
            System.out.println("2 - Listar Contatos");
            System.out.println("3 - Imprimir Contato");
            System.out.println("4 - Atualizar Contato");
            System.out.println("5 - Remover Contato");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); 
            System.out.println("-------------------------");
        	System.out.println();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Celular: ");
                    String celular = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Data de Aniversário (dd/mm): ");
                    String[] data = sc.nextLine().split("/");
                    Data aniversario = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
                    Contato contato = new Contato(nome, telefone, celular, email, aniversario);
                    agenda.insere_contato(contato);
                    }
                case 2 -> agenda.listarNomesContatos();
                case 3 -> {
                    System.out.print("Digite o nome do contato: ");
                    String nome = sc.nextLine();
                    agenda.listarContatos(nome);
                }
                case 4 -> {
                    System.out.print("Digite o nome do contato a ser atualizado: ");
                    String nome = sc.nextLine();
                    System.out.print("Novo Nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Celular: ");
                    String celular = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Data de Aniversário (dd/mm): ");
                    String[] data = sc.nextLine().split("/");
                    Data aniversario = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
                    Contato novoContato = new Contato(novoNome, telefone, celular, email, aniversario);
                    agenda.atualizarContato(nome, novoContato);
                }
                case 5 -> {
                    System.out.print("Digite o nome do contato a ser removido: ");
                    String nome = sc.nextLine();
                    agenda.removerContato(nome);
                }
                case 6 -> {
                    System.out.println("Encerrando o programa.");
                    break; 
                }
                default -> System.out.println("Opção inválida.");
            }

            if (opcao == 6) break; 
        }
    }
}
