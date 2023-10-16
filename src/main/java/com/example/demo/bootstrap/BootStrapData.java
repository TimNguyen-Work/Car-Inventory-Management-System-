package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }
        List<Part> existingParts = (List<Part>) partRepository.findAll();
        List<Product> existingProducts = (List<Product>) productRepository.findAll();

        if (existingParts.isEmpty() && existingProducts.isEmpty()) {
            InhousePart part1 = new InhousePart();
            part1.setId(1);
            part1.setName("Brakes");
            part1.setPrice(100.0);
            part1.setInv(50);
            part1.setMax(100);
            part1.setMin(20);

            InhousePart part2 = new InhousePart();
            part2.setId(2);
            part2.setName("Battery");
            part2.setPrice(250.0);
            part2.setInv(30);
            part2.setMax(150);
            part2.setMin(10);

            InhousePart part3 = new InhousePart();
            part3.setId(3);
            part3.setName("Radiator");
            part3.setPrice(200.0);
            part3.setInv(20);
            part3.setMax(100);
            part3.setMin(10);

            InhousePart part4 = new InhousePart();
            part4.setId(4);
            part4.setName("Tires");
            part4.setPrice(90.0);
            part4.setInv(100);
            part4.setMax(300);
            part4.setMin(50);

            InhousePart part5 = new InhousePart();
            part5.setId(5);
            part5.setName("Headlight");
            part5.setPrice(30.0);
            part5.setInv(200);
            part5.setMax(500);
            part5.setMin(70);

            partRepository.save(part1);
            partRepository.save(part2);
            partRepository.save(part3);
            partRepository.save(part4);
            partRepository.save(part5);

            Product car1 = new Product("CRV", 30000, 7);
            Product car2 = new Product("Camry", 25000, 5);
            Product car3 = new Product("Civic", 22000, 9);
            Product car4 = new Product("Escape", 28000, 3);
            Product car5 = new Product("Sorento", 31000, 5);

            productRepository.save(car1);
            productRepository.save(car2);
            productRepository.save(car3);
            productRepository.save(car4);
            productRepository.save(car5);

            System.out.println("Sample inventory added successfully.");
        } else {
            System.out.println("Inventory already exists. Skipping sample inventory addition.");
        }
        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
