package ru.saintunix.pool;

import java.util.List;
import java.util.Random;

public class Cluster implements ManageServer {
    private int id;
    private boolean status = true;

    private List<ManageServer> servers;

    public Cluster(int id, List<ManageServer> servers) {
        this.id = id;
        this.servers = servers;
    }

    public void sendMassage() {
        Random random = new Random();
        int randServer = random.nextInt(servers.size() - 1);
        int randNode = random.nextInt(servers.get(randServer).getPoolServers().size() - 1);

        for (int i = randServer; i < servers.size(); i++) {
            servers.get(i).setStatus(false);

            List<ManageServer> poolServers = servers.get(i).getPoolServers();
            for (int j = 0; j < poolServers.size(); j++) {
                if (i == randServer && j < randNode) {
                    j = randNode;
                }
                poolServers.get(j).setStatus(false);
            }
        }
    }

    public boolean isFailed(int server, int node) {
        return !servers.get(server).getPoolServers().get(node).isAvailability();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isAvailability() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public List<ManageServer> getPoolServers() {
        return servers;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder(String.format("Cluster: { id: %d, availability: %s }\n", id, status));
        for (ManageServer srv : servers) {
            data.append(srv).append("\n");
        }
        return data.toString();
    }
}
