package provaTI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EraVinho {
	static int vinhoTintoGarrafa = 0;
	static int vinhoBrancoGarrafa = 0;
	static int vinhoRoseGarrafa = 0;

	//pre�o dos vinhos n�o informados, usando placeholder
	static float vinhoTintoPreco = 1;
	static float vinhoBrancoPreco = 2;
	static float vinhoRosePreco = 3;
	
	static float montanteBoleto = 0;
	static float montanteCartao = 0;
	static File Baccho = new File ("Baccho");
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
				
		FileWriter escritor = new FileWriter(Baccho);
		
		System.out.println("Bem vindo a EraVinho. Para sair digite SAIR no c�digo de venda");
		
		String codigoVenda = "a";
		while(!codigoVenda.equals("SAIR")) {
			String cpf;
			String nome;
			int idade;
			int quantidade;
			String tipoGarrafa;
			String formaPagamento;

			
			System.out.println("Digite o c�digo da venda (digite SAIR para fechar o programa)");
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
				System.out.println("ATEN��O! A EraVinho n�o vende para menores de 18 anos.");
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
			if(formaPagamento.equals("boleto") && tipoGarrafa.equals("ros�")) {
				montanteBoleto = montanteBoleto + vinhoRosePreco * quantidade;
				vinhoRoseGarrafa = vinhoRoseGarrafa + quantidade;
			}
			if(formaPagamento.equals("cart�o") && tipoGarrafa.equals("tinto")) {
				montanteCartao = montanteCartao + vinhoTintoPreco * quantidade;
				vinhoTintoGarrafa = vinhoTintoGarrafa + quantidade;
			}
			if(formaPagamento.equals("cart�o") && tipoGarrafa.equals("branco")) {
				montanteBoleto = montanteCartao + vinhoBrancoPreco * quantidade;
				vinhoBrancoGarrafa = vinhoBrancoGarrafa + quantidade;
			}
			if(formaPagamento.equals("cart�o") && tipoGarrafa.equals("ros�")) {
				montanteBoleto = montanteCartao + vinhoRosePreco * quantidade;
				vinhoRoseGarrafa = vinhoRoseGarrafa + quantidade;
			}
		}
		System.out.println("..........");
		escritor.write("Quantidade de venda de cada vinho");
		escritor.write("Tinto: " + (float)(vinhoTintoGarrafa * vinhoTintoPreco));
		escritor.write("Branco: " + (float)(vinhoBrancoGarrafa * vinhoBrancoPreco));
		escritor.write("Ros�: " + (float)(vinhoRoseGarrafa * vinhoRosePreco));
		escritor.write("Montante de vendas por boleto: " + montanteBoleto);
		escritor.write("Montante de vendas por cart�o: " + montanteCartao);
		System.out.println("Volte sempre!");
		
		escritor.close();
	}
}