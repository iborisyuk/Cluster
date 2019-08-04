package ru.saintunix.search;

import ru.saintunix.exceptions.FailedServerNotFound;
import ru.saintunix.pool.Cluster;
import ru.saintunix.pool.ManageServer;

import java.util.List;

public class FailSearchEngine {
    private Cluster cluster;

    public void search(Cluster cluster) {
        this.cluster = cluster;

        try {
            int failServer = searchFailServer(cluster.getPoolServers());
            int failNode = searchFailServer(cluster.getPoolServers().get(failServer).getPoolServers());
            System.out.printf("Failed server: %d, node: %d ", failServer, failNode);

        } catch (FailedServerNotFound e) {
            System.out.println("Failed server not found!");
            e.printStackTrace();
        }
    }

    private int searchFailServer(List<ManageServer> srv) throws FailedServerNotFound {
        if (srv.size() == 0)
            throw new FailedServerNotFound();

        int mid = (srv.size() / 2);

        if (!srv.get(mid).isAvailability() &&
                (srv.size() == 1 || srv.get(mid - 1).isAvailability()))
            return srv.get(mid).getId();

        if (srv.get(mid).isAvailability())
            return searchFailServer(srv.subList(mid, srv.size()));

        return searchFailServer(srv.subList(0, mid));
    }
}
