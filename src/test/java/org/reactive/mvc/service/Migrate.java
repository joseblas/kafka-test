package org.reactive.mvc.service;

import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactive.mvc.CassandraService;
import org.reactive.mvc.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import javax.print.Doc;
import java.lang.reflect.Method;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CassandraConfig.class)
public class Migrate {
    @Autowired
    OrderRepository repository;

    LuceneService luceneService = new LuceneService();

    final static Logger logger = Logger.getLogger(Migrate.class);

    @Test
    public void createTable() throws Exception {

//        luceneService.readAll("/home/dev/Downloads/ernest-mayo/orders", 1).stream().forEach( doc -> System.out.println("Doc "+ doc.getFields()));

        Document document = luceneService.readAll("/home/dev/Downloads/ernest-mayo/orders",0, 1).get(0);
        System.out.println("********");
        System.out.println(" ");
        //CREATE TABLE IF NOT EXISTS ras.vuelos (flightNumber TEXT, leaves TEXT, arrives TEXT, duration TEXT, regular bigint, business bigint, origin TEXT, destination TEXT,  PRIMARY KEY (flightNumber, leaves))
        System.out.println(" create table IF NOT EXISTS ras.eorders (");
        document.getFields().stream().forEach(f -> System.out.println(f.name().toLowerCase().replaceAll(" ","_") + " text, "));
        System.out.println(" PRIMARY KEY(orderid) )");

        System.out.println(" ");
        document.getFields().stream().forEach(f -> System.out.println("private String "+ f.name().toLowerCase().replaceAll(" ","_") + "; "));
        System.out.println(" ");



    }


    @Test
    public void count() throws Exception {
        System.out.println("count ++++ ");
        System.out.println("count " + repository.count());
        System.out.println("count ++++ ");
    }


        @Test
    public void migrate() throws Exception {
            batch(0, 50000);
            batch(500000, 1000000);
            batch(1000000, 250000);
//            batch(1250000, 250000);
//            batch(1500000, 250000);
//            batch(1750000, 250000);
//            batch(2000000, 250000);
//            batch(2250000, 250000);
//            batch(2500000, 250000);
//            batch(2750000, 250000);
//            batch(3000000, 10000);

        }

    private void batch(int init, int end) throws Exception{
        List<Document> documents = luceneService.readAll("/home/dev/Downloads/ernest-mayo/orders", init, end );
        int i = 0;
        logger.info("init");
        for(Document doc : documents){
            i++;
            Order order = new Order();
            doc.getFields().stream().forEach(f ->{
                String method = String.format("set%s", StringUtils.capitalize(f.name().toLowerCase().replaceAll(" ", "_")));
                try {
                    Method m = Order.class.getMethod(method, String.class);
                    m.invoke(order, f.stringValue());
                } catch (Exception e) {
//                    e.printStackTrace();
                }

                });
            repository.save(order);
            if(i % 5000 == 0) {
                Thread.sleep(500);
                logger.info("sleep " + i + " " + order.getOrderid());
            }
            if(i % 50000 == 0) {
                Thread.sleep(2500);
//                try {
//                    logger.info("count ");
//                    logger.info("count " + repository.count());
//                }catch (Throwable t){
//                    logger.info("count failed " + i);
//                    Thread.sleep(1000);
//                }
            }
        }
            logger.info("end");
    }
}
