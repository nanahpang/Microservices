package com.xinchen.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class App implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(App.class);
    private HashMap<Integer, Product> map = new HashMap<Integer, Product>();

    public static void main(String args[]) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void run(String... strings) throws Exception {

        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE product IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE product(" +
                "id SERIAL, count INT, name VARCHAR(255))");

        insertNewProducts();
        
    }
    private void insertNewProducts() {
    		// Split up the array of whole names into an array of first/last names
        List<Object[]> splitUpProducts = Arrays.asList("1,300,candy", "2,100,iphone", "3,500,table", "4,10,keyboard", "5,20,screen", "6,100,protein_bar", "7,50,lipstick").stream()
                .map(tuple -> tuple.split(","))
                .collect(Collectors.toList());
        
        // Use a Java 8 stream to print out each tuple of the list
        splitUpProducts.forEach(tuple -> map.put((Integer)tuple[0], new Product((Integer)tuple[0], (Integer)tuple[1], (String)tuple[2])));
        splitUpProducts.forEach(tuple -> log.info(String.format("Inserting product record for %d %d %s", tuple[0], tuple[1], tuple[2])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO product(id, count, name) VALUES (?,?,?)", splitUpProducts);
	}
	public void sellProduct(int id, int count) {
        log.info("Querying for product records where id = '?':", id);
        jdbcTemplate.query(
                "SELECT id, count, name FROM product WHERE id = ?", new Object[] { "1" },
                (rs, rowNum) -> new Product(rs.getInt("id"), rs.getInt("count"), rs.getString("last_name"))
        ).forEach(product -> log.info(product.toString()));
        Product product = map.get(id);
        if (product.getCount() < count) {
        		// exception
        } else {
        		product.changeCount(-count);
        		map.put(product.getId(), product);
        }
        
    }
}