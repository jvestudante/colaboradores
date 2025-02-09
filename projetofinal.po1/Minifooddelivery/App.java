import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner s = new Scanner(System.in);
    static List<Cliente> listaClientes = new ArrayList<>();
    static String userAdmin = "admin";
    static String passwordAdmin = "admin";

    public static void main(String[] args) {

        menu();
        
    }
    public static void menu(){
        System.out.println("\n-----MENU------");
        System.out.println("| 1- Comprar  |");
        System.out.println("| 2- Cadastrar|");
        System.out.println("| 3- Admin    |");
        System.out.println("| 4- SAIR     |");
        readMenu();
    }
    public static void readMenu(){
        Validacao.opcaoException(s);
    }
    public static void comprar(){
        System.out.println("\nDigite seu cpf (Apenas números)");
        String cpf = s.nextLine();
        
        if (Validacao.regexCpf(cpf) == true){
            Cliente clientes = new Cliente();
            for (Cliente busca : listaClientes){
                if (busca.getCpf().equals(cpf)){
                    Estoque.listaProduto(Estoque.getItens());
                    System.out.print("\nEscolha um produto pelo código:");
                    int codigo = s.nextInt();
                    System.out.print("\nEscolha a quantidade que deseja:");
                    int quantidade = s.nextInt();
                    Validacao.verificaEstoque(codigo, quantidade, Estoque.getItens(), listaClientes, cpf);
                }else{
                    System.out.println("Verifiquei que você não tem cadastro em nosso sistema");
                }
            }
        }else{
            System.out.println("\nDigite um CPF válido.");
            comprar();
        }
    }

    public static void cadastrar(){
        System.out.print("\nDigite seu nome: ");
        String nome = s.nextLine();
        System.out.print("\nDigite seu CPF (Apenas números): ");
        String cpf = s.nextLine();
        if (Validacao.regexCpf(cpf) == true){
            System.out.print("\nDigite sua idade: ");
            int idade = s.nextInt();
            s.nextLine();
            System.out.print("\nDigite seu endereço: ");
            String endereco = s.nextLine();

            Cliente novoCliente = new Cliente(nome, cpf, idade, endereco);
            listaClientes.add(novoCliente);
            System.out.println("\nCadastro realizado com sucesso !!!");
            App.menu();
        }else{
            System.out.println("\nDigite um CPF válido. Vamos começar de novo.");
            cadastrar();
        }
    }

    public static void login(String user, String senha){
        System.out.print("\nDigite o login:");
        String login = s.nextLine();
        System.out.print("\nAgora a senha: ");
        String password = s.nextLine();

        if (login.equals(user)){
            if (password.equals(senha)){
                submenu();
            }else{
                System.out.println("\nUsuário ou senha não cadastrados");
                App.menu();
            }
        } else{
            System.out.println("\nUsuário ou senha não cadastrados");
            App.menu();
        }
    }

    public static void submenu(){
        System.out.println("------SUBMENU------");
        System.out.println("| 1- Novo Produto |");
        System.out.println("| 2- Reposição    |");
        System.out.println("| 3- Voltar       |");

        try{
            System.out.print("\nDigite um número de opção: ");
            int index = s.nextInt();
            s.nextLine();
            switch (index) {
                case 1:
                    cadastroProduto();
                    break;
                case 2:
                    reporProduto();
                    break;
                case 3:
                    App.menu();
                    break;
                default:
                    System.out.println("Inválido");
                    submenu();
                    break;
            }
        }catch (InputMismatchException e){
            System.out.println("\nOBS: digite uma entrada válida !!!");
            submenu();
        }
    }

    public static void cadastroProduto(){
        System.out.print("\nDigite o código do produto: ");
        int cod = s.nextInt();
        s.nextLine();
        System.out.print("\nDigite o nome do produto: ");
        String nome = s.nextLine();
        System.out.print("\nDigite a classificação do produto: ");
        String classificacao = s.nextLine();
        System.out.print("\nDigite o preço do produto: ");
        String preco = s.nextLine();
        System.out.print("\nDigite a quantidade do produto: ");
        int quantidade = s.nextInt();
        s.nextLine();

        Estoque.novoProduto(cod, nome, classificacao, preco, quantidade);
    }

    public static void reporProduto(){
        System.out.print("\nBom para repor o estoque informe o código do produto: ");
        int cdg = s.nextInt();
        System.out.print("\nAgora a quantidade:");
        int quantidade = s.nextInt();

        Estoque.reposicao(cdg, quantidade);
    }

}
