package jantar;
import java.util.Scanner;

public class jantar_informatico {

	static Scanner leitor = new Scanner(System.in);
	//VARIAVEIS
	static int omeletasCompletas;//QUANTIDADE DE OMELTAS COMPLETAS PEDIDO PELO UTILIZADOR 
	static int omeletasIncompletas;//QUANTIDADE DE OMELETAS INCOMPLETAS PEDIDO PELO UTILIZADOR
	
	public static void main(String[] args) {
		
		//INTERAÇÕES COM O UTILIZADOR
		pedidos();
		despesa();
	}	
	//LER E VALIDAR OMELETAS
	public static void pedidos() {
		do {
			omeletasCompletas = completas();
			omeletasIncompletas = incompletas();
		} while (omeletasCompletas < 0 & omeletasIncompletas < 0);
	}
	
	//LER E VALIDAR AS QUANTIDADES DE OMELETAS COMPLETAS
	public static int completas() {
		do {
			System.out.println("Quantas omeletas completas?");
			omeletasCompletas = leitor.nextInt();
		} while (omeletasCompletas < 0);
		return omeletasCompletas;
	}
	//LER E VALIDAR AS QUANTIDADES DE OMELETAS INCOMPLETAS
	public static int incompletas() {
		int quantidadeIncompletas;
		do {
			System.out.println("Quantas omeletas incompletas?");
			omeletasIncompletas = leitor.nextInt();
		} while (omeletasIncompletas < 0);
		return omeletasIncompletas;
	}			
	//VALOR DAS OMELETAS
	public static int precoCompleta() {
		int preco = 3;
		return preco;
	}
	public static double precoIncompleta() {
		double preco;
		preco = 1.5;
		return preco;
	}
	//FIM DOS VALORES
	//CALCULAR DESPESAS DAS OMELETAS COMPLETAS
	public static int despesaOmeletasCompletas() {
		int despesa;
		despesa = omeletasCompletas * precoCompleta();
		return despesa;
	}
	//CALCULAR A DESPESA DAS OMELETAS INCOMPLETAS
	public static double despesaOmeletasIncompletas() {
		double despesa;
		if (omeletasIncompletas == 0) {
			despesa = 0;
		}else if (omeletasIncompletas == 1) {
			despesa = omeletasIncompletas * precoIncompleta();
		}else if (omeletasIncompletas == 2) {
			despesa = (omeletasIncompletas * precoIncompleta()) - desconto2OmeltasIncompletas();
		} else if (omeletasIncompletas == 3){
			despesa = (omeletasIncompletas * precoIncompleta()) - desconto3OmeltasIncompletas();
		} else if (omeletasIncompletas == 4) {
			despesa = (omeletasIncompletas * precoIncompleta()) - desconto4OmeltasIncompletas();
		} else {
			despesa = (omeletasIncompletas * precoIncompleta()) - desconto5ouMaisOmeletasIncompletas();
		}
		return despesa;
	}
	//DESCONTOS PARA AS OMELETAS INCOMPLETAS, ENTRE A SEGUNDA E QUINTA OMELETA APLICA-SE 5% DE DESCONTO
	public static double desconto2OmeltasIncompletas() {
		double desconto=0;
		desconto = precoIncompleta() * (5.0/100);
		return desconto;
	}
	public static double desconto3OmeltasIncompletas() {
		double desconto;
		desconto = (2 * precoIncompleta()) * (5.0/100);
		return desconto;
	}
	public static double desconto4OmeltasIncompletas() {
		double desconto;
		desconto = (3 * precoIncompleta()) * (5.0/100);
		return desconto;
	}
	public static double desconto5ouMaisOmeletasIncompletas() {
		double desconto;
		desconto = (4 * precoIncompleta()) * (5.0/100);
		return desconto;
	}
	//FIM DOS DESCONTOS
	//CALCULO E PRINT DA DESPESA TOTAL
	public static void despesa() {
		double despesaTotal;
		despesaTotal = despesaOmeletasIncompletas() + despesaOmeletasCompletas();
		System.out.println("Você deve um total de "+despesaTotal+"€");
	}
}
