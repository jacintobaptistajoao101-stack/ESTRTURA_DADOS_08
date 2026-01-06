import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // Classe que guarda os dados do paciente
    static class Paciente {
        int id;
        String nome;
        int idade;
        String genero;
        String contacto;

        // Construtor do paciente
        Paciente(int id, String nome, int idade, String genero, String contacto) {
            this.id = id;
            this.nome = nome;
            this.idade = idade;
            this.genero = genero;
            this.contacto = contacto;
        }

        // Retorna o ID do paciente
        int getId() {
            return id;
        }

        // Mostra os dados do paciente
        public String toString() {
            return "ID: " + id +
                    "\nNome: " + nome +
                    "\nIdade: " + idade +
                    "\nGenero: " + genero +
                    "\nContacto: " + contacto +
                    "\n----------------";
        }
    }

    // guardar os pacientes
    static HashMap<Integer, Paciente> pacientes = new HashMap<>();

    // Adiciona um paciente
    static void adicionarPaciente(Paciente p) {
        pacientes.put(p.getId(), p);
        System.out.println("Paciente cadastrado.");
    }

    // Procurar paciente pelo ID
    static Paciente buscarPaciente(int id) {
        return pacientes.get(id);
    }

    // Remove paciente
    static void removerPaciente(int id) {
        if (pacientes.remove(id) != null)
            System.out.println("Paciente removido.");
        else
            System.out.println("Paciente não encontrado.");
    }

    // Lista todos os pacientes
    static void listarPacientes() {
        if (pacientes.isEmpty())
            System.out.println("Não há pacientes cadastrados.");
        else
            for (Paciente p : pacientes.values())
                System.out.println(p);
    }

    // Verifica se o ID já existe
    static boolean existePaciente(int id) {
        return pacientes.containsKey(id);
    }




    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nCadastro de Pacientes");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Consultar");
            System.out.println("3 - Listar");
            System.out.println("4 - Remover");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (existePaciente(id)) {
                        System.out.println("Esse ID já existe.");
                        break;
                    }

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Genero: ");
                    String genero = sc.nextLine();

                    System.out.print("Contacto: ");
                    String contacto = sc.nextLine();

                    adicionarPaciente(new Paciente(id, nome, idade, genero, contacto));
                    break;

                case 2:
                    System.out.print("Digite o ID: ");
                    Paciente p = buscarPaciente(sc.nextInt());
                    if (p != null)
                        System.out.println(p);
                    else
                        System.out.println("Paciente não encontrado.");
                    break;

                case 3:
                    listarPacientes();
                    break;

                case 4:
                    System.out.print("Digite o ID: ");
                    removerPaciente(sc.nextInt());
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção errada.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
