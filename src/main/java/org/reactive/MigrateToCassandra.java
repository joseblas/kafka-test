package org.reactive;

import com.datastax.driver.core.*;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.TwoPhaseCommit;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.tomcat.jni.Thread;
import org.reactive.mvc.CassandraService;
import org.reactive.mvc.service.LuceneService;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by dev on 20/05/16.
 */
public class MigrateToCassandra {

    public static void main(String[] args) throws Exception{

        Cluster cluster = null;
        try {
//            Inet4Address server1 = new InetAddress();
            Inet4Address.getAllByName("localhost");
            cluster = Cluster.builder()
                    .addContactPointsWithPorts(Arrays.asList(new InetSocketAddress("localhost", 19042),new InetSocketAddress("localhost", 29042)))
//                .addContactPoint()
                    .build();
            Metadata metadata = cluster.getMetadata();
            System.out.printf("Connected to cluster: %s\n",
                    metadata.getClusterName());
            for (Host host : metadata.getAllHosts()) {
                System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n",
                        host.getDatacenter(), host.getAddress(), host.getRack());
            }


            for(int i = 0; i < 100; i++) {
                try {

                    Session connect = cluster.connect();
                    Iterator<Row> iterator = connect.execute("SELECT orderid FROM ras.eorders limit 3;").iterator();
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next().getString(0));
                    }

                    connect.close();

                    java.lang.Thread.sleep(5000);
                    System.out.println(" sleep : " + i);
                }catch (Throwable t){
                    t.printStackTrace();
                    java.lang.Thread.sleep(5000);
                    System.out.println(" sleep : " + i);
                }

            }



        }catch(Throwable t){
            t.printStackTrace();
        }finally {
            cluster.close();
        }

    }
}
