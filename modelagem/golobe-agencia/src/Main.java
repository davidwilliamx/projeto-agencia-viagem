import java.util.List;
import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner entrada = new Scanner(System.in);
    static int opcao = -1;
    public static void mostrarMenu() {
        System.out.println("###### Menu Principal");
        System.out.println("Digite 1 _ Menu Cliente");
        System.out.println("Digite 2 _ Menu Destino");
        System.out.println("Digite 3 _ Menu Pacote");
        System.out.println("Digite 4 _ Menu Venda");
        System.out.println("Digite 0 _ Fechar Sistema");
    }
    public static void mostrarMenuCliente() {
        System.out.println("###### Menu Cliente");
        System.out.println("Digite 10 = Cadastrar Cliente_______________");
        System.out.println("Digite 11 = Listar Clientes_________________");
        System.out.println("Digite 12 = Atualizar/Corrigir Cliente______");
        System.out.println("Digite 13 = Excluir Cliente_________________");
        System.out.println("############################################");
    }
    public static void mostrarMenuPacote() {
        System.out.println("++++++ Menu Pacote");
        System.out.println("Digite 20 = Cadastrar Pacote________________");
        System.out.println("Digite 21 = Listar Pacotes__________________");
        System.out.println("Digite 22 = Atualizar/Corrigir Pacote_______");
        System.out.println("Digite 24 = Excluir Pacote__________________");
        System.out.println("############################################");
    }
    public static void mostrarMenuDestino() {
        System.out.println("****** Menu Destino");
        System.out.println("Digite 30 = Cadastrar Destino_______________");
        System.out.println("Digite 31 = Listar Destinos_________________");
        System.out.println("Digite 32 = Atualizar/Corrigir Destino______");
        System.out.println("Digite 33 = Excluir Destino_________________");
        System.out.println("############################################");
    }
    public static void mostrarMenuVenda() {
        System.out.println("------ Menu Venda");
        System.out.println("Digite 40 = Cadastrar Venda_________________");
        System.out.println("Digite 41 = Listar Vendas___________________");
        System.out.println("Digite 42 = Atualizar/Corrigir Venda________");
        System.out.println("Digite 43 = Excluir Venda___________________");
        System.out.println("############################################");
    }
    public static void main(String[] args) {
        while (opcao != 0) {
            try {
                mostrarMenu();
                opcao = entrada.nextInt();

                switch (opcao) {
                    case 1:
                        Cliente cliente = new Cliente();
                        ClienteDAO clienteDAO = new ClienteDAO();

                        mostrarMenuCliente();
                        System.out.println("Escolha uma opção do Menu Cliente: ");
                        int opcaoMenuCliente = entrada.nextInt();

                        switch (opcaoMenuCliente) {
                            case 10:
                                System.out.println("###### Menu Cliente");
                                System.out.println("Novo Cliente");
                                System.out.println("-------------------");
                                System.out.println(" ");
                                System.out.println("Informe seu nome: ");
                                String nome = entrada.next();
                                cliente.setNome(nome);

                                System.out.println("Informe seu endereço: ");
                                String endereco = entrada.next();
                                cliente.setEndereco(endereco);

                                System.out.println("Informe agora o seu endereço de email: ");
                                String email = entrada.next();
                                cliente.setEmail(email);

                                System.out.println("Informe o seu telefone com DDD: ");
                                String telfone = entrada.next();
                                cliente.setTelefone(telfone);

                                System.out.println("E por fim o seu CPF[Apenas números]: ");
                                String cpf = entrada.next();
                                cliente.setCpf(cpf);

                                clienteDAO.criarCliente(cliente);
                                clienteDAO.fecharConexao();
                                break;
                            case 11:
                                System.out.println("###### Menu Cliente");
                                System.out.println("Listar Clientes");
                                System.out.println("-------------------");
                                System.out.println("Clientes ----------");
                                List<Cliente> clientes = null;
                                try {
                                    clientes = clienteDAO.listarCliente();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                for (Cliente ignored : clientes) {
                                    System.out.println("ID" + cliente.getId() + " - " + cliente.getNome() + " - " + cliente.getEndereco() + " - " + cliente.getEmail() + " - " + cliente.getTelefone() + " - " + cliente.getCpf());
                                }
                                System.out.println(clienteDAO.buscarCliente(1));
                                break;
                            case 12:
                                System.out.println("###### Menu Cliente");
                                System.out.println("Atualizar Cliente");
                                System.out.println("-------------------");
                                System.out.println("Informe o ID cliente: ");
                            default:
                                System.out.println("Código incorreto, tente novamente.");
                                opcaoMenuCliente = entrada.nextInt();
                        }
                        System.out.println(" ");
                        System.out.println("-------------------");
                        mostrarMenu();
                        System.out.println("Informe uma opção: ");
                        opcao = entrada.nextInt();
                        break;
                    case 2:
                        mostrarMenuDestino();
                        opcao = entrada.nextInt();
                        break;
                    case 3:
                        mostrarMenuPacote();
                        opcao = entrada.nextInt();
                        break;
                    case 4:
                        mostrarMenuVenda();
                        opcao = entrada.nextInt();
                        break;
                    case 5:
                        mostrarMenu();
                        opcao = entrada.nextInt();
                        break;
                    case 0:
                        System.out.println("Até mais.\nFinalizando programa!!!");
                        break;
                    default:
                        System.out.println("Informe um valor válido.");
                        break;
                }
            }catch (Exception e) {
                System.out.println("Opa! Erro!");
            }
        }
    }

}
