import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Estoque {
    private String nomeEstoque;
    private static List <Item> itens;

        public Estoque(){
        }
    
        public Estoque(String nomeEstoque){
            this.nomeEstoque = nomeEstoque;
            itens = new ArrayList<>();
            setarProdutos();
        }

        public void setarProdutos(){
            Item item = new Item(1, "Televisão", "Eletrônico", "2.500,00", 2);
            itens.add(item);
            item = new Item(2, "Refri lata 250ml", "Alimento", "3,95", 45);
            itens.add(item);
            item = new Item(3, "Salgado", "Alimento", "7,00", 15);
            itens.add(item);
            item = new Item(4, "Celular", "Eletrônico", "2.000,00", 5);
            itens.add(item);
            item = new Item(5, "Geladeira", "Eletrodoméstico", "4.500,00", 3);
            itens.add(item);
            item = new Item(6, "Carregador universal", "Eletrônico", "15,00", 10);
            itens.add(item);
            item = new Item(7, "Notebook", "Eletrônico", "2.500,00", 0);
            itens.add(item);
            item = new Item(8, "Mouse", "Eletrônico", "55,90", 5);
            itens.add(item);
        }


        public static void listaProduto(List <Item> itens){
            System.out.println("\nLISTA DE PRODUTOS:");
            System.out.println("  Código     nome       classificação     preço     Quantidade");

            for (Item buscaItem : itens){
                System.out.println("  "+buscaItem.getCodigoItem()+"     "+buscaItem.getNomeItem()+"   "+
                                   buscaItem.getClass()+"     R$ "+buscaItem.getPreco()+"     "+
                                   buscaItem.getQuantidade());
            }
        }

        public static void buscaProduto(List <Item> itens, int codigo, int quantidade){

        }
    
        public static void novoProduto(int codigo, String nome, String clas, String preco, int quantidade){
            Item novoItem = new Item(codigo, nome, clas, preco, quantidade);
            itens.add(novoItem);
        }

        public static void reposicao(int codigo, int quantidade){
            for (Item index : itens){
                if (index.getCodigoItem() == codigo){
                    index.setCodigoItem(index.getCodigoItem()+quantidade);
                }
            }
        }

        public static void retirada(int codigo, int quantidade){
            for (Item index : itens){
                if(index.getCodigoItem() == codigo){
                    index.setCodigoItem(index.getCodigoItem()-quantidade);
                }
            }
        }

        public static String itensRetirado(int codigo, int quantidade){
            for (Item index : itens){
                if(index.getCodigoItem() == codigo){
                    return "\n\nItem(s) Pedido(s):\n"+index.getCodigoItem()+" "+index.getNomeItem()+
                           " "+index.getQuantidade()+" "+index.getPreco();
                }
            }
            return "";
        }

        public static List<Item> getItens() {
            return itens;
        }


}
