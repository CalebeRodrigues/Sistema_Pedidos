package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.OrdemItem;
import entities.Order;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		Order order;
		
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Data de nascimento: ");
		Date data = sdf.parse(scanner.next());

		Date moment = new Date();
		String moments = sdf2.format(moment);
		moment = sdf2.parse(moments);
		System.out.println("Inserir dados pedido: ");
		System.out.print("Status: ");
		String status = scanner.next();

		order = new Order(moment, OrderStatus.valueOf(status));
		Cliente cliente = new Cliente(nome, email, data);
		order.addCliente(cliente);

		System.out.print("Quantos items no pedido? ");
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Entre #"+(i+1)+" item: ");
			System.out.print("Nome produto: ");
			scanner.nextLine();
			nome = scanner.nextLine();
			System.out.print("Preço: ");
			Double price = scanner.nextDouble();
			System.out.print("Quantidade: ");
			int quantidade = scanner.nextInt();
			
			Product product = new Product(nome, price);
			OrdemItem ordem = new OrdemItem(quantidade, price);
			
			ordem.addProduct(product);
			
			order.addItems(ordem);			
		}
		
		System.out.println("Resumo pedido: ");
		
		System.out.print(order);

		scanner.close();
	}

}
