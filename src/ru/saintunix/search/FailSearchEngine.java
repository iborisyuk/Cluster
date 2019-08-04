package ru.saintunix.search;

import ru.saintunix.pool.Cluster;
import ru.saintunix.pool.ManageServer;

import java.util.List;

public class FailSearchEngine {
    private Cluster cluster;

    public void search(Cluster cluster) {
        this.cluster = cluster;

        int failServer = searchFailServer(cluster.getPoolServers());
        int failNode = searchFailServer(cluster.getPoolServers().get(failServer).getPoolServers());

        System.out.printf("Failed server: %d, node: %d ", failServer, failNode);
    }

    private int searchFailServer(List<ManageServer> srv) {
        if (srv.size() == 0)
            return -1;

        int mid = (srv.size() / 2);

        if (!srv.get(mid).isAvailability() &&
                (srv.size() == 1 || srv.get(mid - 1).isAvailability()))
            return srv.get(mid).getId();

        if (srv.get(mid).isAvailability())
            return searchFailServer(srv.subList(mid, srv.size()));

        return searchFailServer(srv.subList(0, mid));
    }
}
