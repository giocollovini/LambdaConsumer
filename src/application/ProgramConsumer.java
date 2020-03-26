package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import entities.Product;
import util.PriceUpdate;

public class ProgramConsumer {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();		
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		System.out.println();
		System.out.println("===========LAMBDA CONSUMER===============================================");
		System.out.println();
		System.out.println("Fazer um programa que, a partir de uma lista de produtos, aumente o"); 
		System.out.println("preço dos produtos em 10%.");
		System.out.println("Product('Tv', 900.00)");
		System.out.println("Product('Mouse', 50.00)");
		System.out.println("Product('Tablet', 350.50)");
		System.out.println("Product('HD Case', 80.90)");
		System.out.println();
		
		for (int i=1; i < 6; i++) { 	
									
			if (i == 1) { 
				System.out.println(); 
				System.out.println("===========Implementação da interface=============================");
								
				list.forEach(new PriceUpdate());
			} else if (i == 2) { 
				System.out.println();
				System.out.println("===========Reference method com método estático==================");
				
				list.forEach(Product::initialValues); //Deixa aLista com os valores iniciais
				
				list.forEach(Product::staticPriceUpdate);
			}  else if (i == 3) {
				System.out.println();
				System.out.println("===========Reference method com método não estático==============");
				
				list.forEach(Product::initialValues); //Deixa aLista com os valores iniciais
				
				list.forEach(Product::nonStaticPriceUpdate);
			} else if (i == 4) {
				System.out.println();
				System.out.println("===========Expressão lambda declarada============================");
			
				double factor = 1.1;
				
				list.forEach(Product::initialValues); //Deixa aLista com os valores iniciais
				
				Consumer<Product> cons = p -> p.setPrice(p.getPrice() * factor);
				
				list.forEach(cons); 
			}  else { 
				System.out.println();
				System.out.println("===========Expressão lambda inline===============================");
								
				double factor = 1.1; 
				
				list.forEach(Product::initialValues); //Deixa aLista com os valores iniciais
				
				list.forEach(p -> p.setPrice(p.getPrice() * factor));
			}		
	
			list.forEach(System.out::println);
		}
				
		
	}
}
