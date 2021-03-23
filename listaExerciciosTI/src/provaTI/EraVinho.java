package provaTI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EraVinho {
	static int vinhoTintoGarrafa = 0;
	static int vinhoBrancoGarrafa = 0;
	static int vinhoRoseGarrafa = 0;

	//preço dos vinhos não informados, usando placeholder
	static float vinhoTintoPreco = 1;
	static float vinhoBrancoPreco = 2;
	static float vinhoRosePreco = 3;
	
	static float montanteBoleto = 0;
	static float montanteCartao = 0;
	static File Baccho = new File ("Baccho");
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
				
		FileWriter escritor = new FileWriter(Baccho);
		
		System.out.println("Bem vindo a EraVinho. Para sair digite SAIR no código de venda");
		
		String codigoVenda = "a";
		while(!codigoVenda.equals("SAIR")) {
			String cpf;
			String nome;
			int idade;
			int quantidade;
			String tipoGarrafa;
			String formaPagamento;

			
			System.out.println("Digite o código da venda (digite SAIR para fechar o programa)");
			codigoVenda = teclado.next();
			if(codigoVenda.equals("SAIR")) break;
			
			System.out.println("Digite o CPF do comprador");
			cpf = teclado.next();
			System.out.println("Digite o nome do comprador");
			nome = teclado.next();
			System.out.println("Digite a idade do comprador");
			idade = teclado.nextInt();
			System.out.println("Digite a quantidade comprada");
			quantidade = teclado.nextInt();
			System.out.println("Digite o tipo de vinho comprado");
			tipoGarrafa = teclado.next();
			System.out.println("Digite a forma de pagamento");
			formaPagamento = teclado.next();
			
			if(idade < 18) {
				System.out.println("ATENÇÃO! A EraVinho não vende para menores de 18 anos.");
				break;
			}
			teclado.close();
			if(formaPagamento.equals("boleto") && tipoGarrafa.equals("tinto")) {
				montanteBoleto = montanteBoleto + vinhoTintoPreco * quantidade;
				vinhoTintoGarrafa = vinhoTintoGarrafa + quantidade;
			}
			if(formaPagamento.equals("boleto") && tipoGarrafa.equals("branco")) {
				montanteBoleto = montanteBoleto + vinhoBrancoPreco * quantidade;
				vinhoBrancoGarrafa = vinhoBrancoGarrafa + quantidade;
			}
			if(formaPagamento.equals("boleto") && tipoGarrafa.equals("rosé")) {
				montanteBoleto = montanteBoleto + vinhoRosePreco * quantidade;
				vinhoRoseGarrafa = vinhoRoseGarrafa + quantidade;
			}
			if(formaPagamento.equals("cartão") && tipoGarrafa.equals("tinto")) {
				montanteCartao = montanteCartao + vinhoTintoPreco * quantidade;
				vinhoTintoGarrafa = vinhoTintoGarrafa + quantidade;
			}
			if(formaPagamento.equals("cartão") && tipoGarrafa.equals("branco")) {
				montanteBoleto = montanteCartao + vinhoBrancoPreco * quantidade;
				vinhoBrancoGarrafa = vinhoBrancoGarrafa + quantidade;
			}
			if(formaPagamento.equals("cartão") && tipoGarrafa.equals("rosé")) {
				montanteBoleto = montanteCartao + vinhoRosePreco * quantidade;
				vinhoRoseGarrafa = vinhoRoseGarrafa + quantidade;
			}
		}
		System.out.println("..........");
		escritor.write("Quantidade de venda de cada vinho");
		escritor.write("Tinto: " + (float)(vinhoTintoGarrafa * vinhoTintoPreco));
		escritor.write("Branco: " + (float)(vinhoBrancoGarrafa * vinhoBrancoPreco));
		escritor.write("Rosé: " + (float)(vinhoRoseGarrafa * vinhoRosePreco));
		escritor.write("Montante de vendas por boleto: " + montanteBoleto);
		escritor.write("Montante de vendas por cartão: " + montanteCartao);
		System.out.println("Volte sempre!");
		
		escritor.close();
	}
}