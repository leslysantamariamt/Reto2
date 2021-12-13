package retos_ciclo4.retos_ciclo4;

import retos_ciclo4.retos_ciclo4.interfaces.InterfaceCleaningProduct;
import retos_ciclo4.retos_ciclo4.interfaces.InterfaceOrder;
import retos_ciclo4.retos_ciclo4.interfaces.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class RetosCiclo4Application implements CommandLineRunner {

    @Autowired
    private InterfaceCleaningProduct interfaceCleaningProduct;
    @Autowired
    private InterfaceUser interfaceUser;
    @Autowired
    private InterfaceOrder interfaceOrder;

	public static void main(String[] args) {
		SpringApplication.run(RetosCiclo4Application.class, args);
	}
        
    @Override
    public void run(String... args) throws Exception {
        
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        interfaceCleaningProduct.deleteAll();
        interfaceUser.deleteAll();
        interfaceOrder.deleteAll(); 
    }
}
