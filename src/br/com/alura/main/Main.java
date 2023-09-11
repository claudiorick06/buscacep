package br.com.alura.main;

import br.com.alura.models.ConsultaCEP;
import br.com.alura.models.Endereco;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        int opcao = 0;
        while (opcao != 3) {
            System.out.println("""
                    ============================================
                    BUSCA CEP
                    ============================================
                    """);
            System.out.println("""
                    Opções:
                    1- Verificar endereço pelo CEP
                    2- Verificar CEP pelo endereço
                    3- Sair
                                    
                    Digite a opção desejada:""");
            opcao = scan.nextInt();
            System.out.println("""
                                    
                    ============================================
                    """);
            if (opcao == 1) {
                System.out.println("Digite um CEP(apenas números):");
                scan.nextLine();
                int cep = scan.nextInt();

                ConsultaCEP consultaCEP = new ConsultaCEP();
                Endereco endereco = consultaCEP.buscaEndereco(cep);

                System.out.println(" ");
                System.out.println(endereco);
                System.out.println(" ");
            }
            else if(opcao == 2) {
                System.out.println("Digite o estado:");
                scan.nextLine();
                String uf = scan.nextLine();

                System.out.println(" ");
                System.out.println("Digite a cidade:");
                String cidade = scan.nextLine();

                System.out.println(" ");
                System.out.println("Digite o nome da rua:");
                String logradouro = scan.nextLine();


                ConsultaCEP consultaCEP = new ConsultaCEP();
                List<Endereco> endereco = consultaCEP.buscaCEP(uf, cidade, logradouro);

                System.out.println(" ");
                System.out.println(endereco);
                System.out.println(" ");
            }
        }
    }
}

