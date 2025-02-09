import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;

public class Cliente{
    private static String nome;
    private static String cpf;
    private static int idade;
    private static String endereco;
    
    public Cliente() {
    }

    public Cliente(String nome, String endereco, String cpf, int idade) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.idade = idade;
    }

    public static void dados(List<Cliente> clientes, String cpf){
        for (Cliente busca: clientes){
            if (busca.getCpf().equals(cpf)){
                System.out.println("Cliente:\nNome: "+busca.getNome()+"\nEndereço: "+busca.getEndereco()+
                                   "\nCPF: "+busca.getCpf()+"Idade: "+busca.getIdade());
            }
        }
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Cliente.nome = nome;
    }

    public static String getCpf() {
        return cpf;
    }

    public static void setCpf(String cpf) {
        Cliente.cpf = cpf;
    }

    public static int getIdade() {
        return idade;
    }

    public static void setIdade(int idade) {
        Cliente.idade = idade;
    }

    public static String getEndereco() {
        return endereco;
    }

    public static void setEndereco(String endereco) {
        Cliente.endereco = endereco;
    }


}