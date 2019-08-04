package ru.saintunix;

import ru.saintunix.pool.*;
import ru.saintunix.search.FailSearchEngine;
import ru.saintunix.utils.Option;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Option<ManageServer>> servers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ArrayList<Option<ManageServer>> nodes = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                nodes.add(new Option<>(new Node(j)));
            }

            servers.add(new Option<>(new Server(i, nodes)));
        }

        Cluster cluster = new Cluster(0, servers);
        cluster.sendMassage();

        System.out.println(cluster);

        new FailSearchEngine().search(cluster);
    }
}

