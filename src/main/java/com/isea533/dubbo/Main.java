package com.isea533.dubbo;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {

        ServiceLoader<Spi> load = ServiceLoader.load(Spi.class);
        Iterator<Spi> iter = load.iterator();
        while (iter.hasNext()) {
            iter.next().sayHello();
        }
    }
}
