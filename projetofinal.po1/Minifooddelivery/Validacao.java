import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Validacao {
    
    public static void opcaoException(Scanner s){
        try{
            System.out.print("\nPara começar digite uma opção: ");
            int opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    App.comprar();
                    break;
                case 2:
                    App.cadastrar();
                    break;
                case 3:
                    App.login(App.userAdmin, App.passwordAdmin);
                    break;
                case 4:
                    System.out.println("\n\nOK!!! Bye bye\n\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nOps. Não há opção para o número digitado. Tente novamente.");
                    App.menu();
                    break;
            }
        }catch( InputMismatchException e){
            s.nextLine();
            System.out.println("\nOBS: digite uma entrada válida !!!");
            System.out.println("Vamos começar de novo? (Responda sim ou nao).");
            while (true) {
                System.out.print("RESPOSTA: ");
                String resposta = s.nextLine().toLowerCase();
                if (resposta.equals("sim")) {
                    App.menu();
                    break;
                }else if (resposta.equals("nao") || resposta.equals("não")) {
                    System.out.println("\nOk então. Tchau !\n");
                    System.exit(0);
                }
                else{
                    System.out.println("\nDesculte não entendi...");
                }
            }
        }
    }

    public static boolean regexCpf (String cpf){
        String regex = "\\d{11}";
        if (cpf.matches(regex)){
            return true;
        }
        return false;
    }

    public static void verificaEstoque(int codigo, int quantidade, List<Item> itens, List<Cliente> clientes, String cpf){
        for (Item buscaItem : itens){

            if (buscaItem.getCodigoItem() == codigo){
                if (buscaItem.getQuantidade() > 0 && buscaItem.getQuantidade() <= quantidade){
                    Cliente.dados(clientes, cpf);
                    Pedido.pedido(codigo,quantidade);

                }else if (buscaItem.getQuantidade() == 0){
                    System.out.println("\nEsse produto está em falta em nosso estoque.");
                    App.menu();
                }

            }else{
                System.out.println("\nDesculpe esse produto não existe em nosso estoque.");
                App.menu();
            }
        }
    }
}
