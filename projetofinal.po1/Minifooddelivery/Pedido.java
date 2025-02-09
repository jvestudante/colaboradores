public class Pedido {
    private int numeroPedido;
    Cliente c;
    static Estoque e;
        
        public Pedido(int numeroPedido, Cliente c, Estoque e) {
            this.numeroPedido = numeroPedido;
            this.c = c;
            this.e = e;
        }
    
        public Pedido() {
        }

        public static void listagemProdutos(){

        }
    
        public static String pedido(int codigo, int quantidade){
            e.retirada(codigo, quantidade);
        return "Pedido Feito com Sucesso!\n\n"+e.itensRetirado(codigo,quantidade);
    }
}
