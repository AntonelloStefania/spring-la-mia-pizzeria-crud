package org.java.spring;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private PizzaService pizzaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		pizzaService.save(new Pizza("Margherita Classica", " Una pizza tradizionale con pomodoro, mozzarella fresca e basilico.", "https://primochef.it/wp-content/uploads/2019/08/SH_pizza_fatta_in_casa-1200x800.jpg", 8.50));
		pizzaService.save(new Pizza("Quattro Formaggi Special", "Una deliziosa combinazione di quattro formaggi: mozzarella, gorgonzola, fontina e parmigiano.", "https://i0.wp.com/www.piccolericette.net/piccolericette/wp-content/uploads/2017/06/3234_Pizza.jpg?resize=895%2C616&ssl=1", 10.00));
		pizzaService.save(new Pizza("Pepperoni Piccanti", "Pizza con pomodoro, mozzarella e peperoni piccanti per un tocco di calore.", "https://wips.plug.it/cips/buonissimo.org/cms/2012/05/69630013_m.jpg", 9.50));
		pizzaService.save(new Pizza("Vegetariana Salutare", "Una pizza leggera e sana con pomodoro, mozzarella, funghi, peperoni, cipolla e olive.", "https://www.guardini.com/images/guardinispa/ricette/full/pizza_set_2021_full.jpg", 11.00));
		pizzaService.save(new Pizza("Prosciutto e Funghi", "Un classico con pomodoro, mozzarella, prosciutto cotto e funghi freschi.", "https://i1.wp.com/www.piccolericette.net/piccolericette/wp-content/uploads/2019/10/4102_Pizza.jpg?resize=895%2C616&ssl=1", 9.75));
		pizzaService.save(new Pizza("Pizza al Pesto Genovese", " Uno strato di pesto genovese, mozzarella fresca, pomodori ciliegia e pinoli.", "https://staticcookist.akamaized.net/wp-content/uploads/sites/21/2023/08/pizza-al-pesto-still-life-ok-1200x675.jpg", 10.50));
		pizzaService.save(new Pizza("Mare e Monti", "Un mix di sapori di mare e terra con frutti di mare e prosciutto crudo.", "https://www.unmondodisapori.it/wp-content/uploads/2017/10/mariemonti.jpg", 12.00));
		pizzaService.save(new Pizza("Capricciosa Deluxe", " Una pizza ricca con pomodoro, mozzarella, prosciutto cotto, funghi, olive nere e carciofi.", "https://wips.plug.it/cips/buonissimo.org/cms/2019/04/pizza-capricciosa.jpg", 11.50));

		
	}

}
