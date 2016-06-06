package org.reactive.kafka.client;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by dev on 26/04/16.
 */
public class ConsumerTest implements Runnable {
    private KafkaStream m_stream;
    private int m_threadNumber;

    static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");

    public ConsumerTest(KafkaStream a_stream, int a_threadNumber) {
        m_threadNumber = a_threadNumber;
        m_stream = a_stream;
    }

    public void run() {
        ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
        System.out.println("Thread " + m_threadNumber + ": " );
        while (it.hasNext())
            try {
                System.out.println("Thread " + m_threadNumber + ": "+ sdf.format(new Date())+" "  + new String( it.next().message(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        System.out.println("Shutting down Thread: " + m_threadNumber);
    }

}
