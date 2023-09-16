package ru.infoza.jvmdeep;

import java.util.List;

/*
 Analysis of Java heap dump: analyze on examples
 https://habr.com/ru/companies/timeweb/articles/719434/
 */
public class HeapDump {

    // to run set args
    // for example --args="180 30"
    // generate 180 units of product (1 MB string)
    // and wait for 30 sec after to check the heap in VisualVM
    public static void main(String[] args) throws InterruptedException {
        int count = Integer.parseInt(args[0]);
        int waitTime = Integer.parseInt(args[1]);
        System.out.println("Loading products...");
        List<String> products = new ProductCatalogService().getProducts(count);
        System.out.println(products.size() + " products are loaded into memory.");
        Thread.sleep(waitTime * 1000L);
    }

}
