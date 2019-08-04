package ru.saintunix;


import ru.saintunix.pool.*;
import ru.saintunix.search.FailSearchEngine;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ManageServer> servers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ArrayList<ManageServer> nodes = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                nodes.add(new Node(j));
            }

            servers.add(new Server(i, nodes));
        }

        Cluster cluster = new Cluster(0, servers);
        cluster.sendMassage();

        System.out.println(cluster);

        new FailSearchEngine().search(cluster);
    }
}

