package ru.saintunix.pool;

import java.util.List;

public class Server implements ManageServer {
    private int id;
    private boolean status = true;

    private List<ManageServer> nodes;

    public Server(int id, List<ManageServer> nodes) {
        this.id = id;
        this.nodes = nodes;
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
        return nodes;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder(String.format("Server: { id: %d, availability: %s }\n", id, status));
        for (ManageServer srv : nodes) {
            data.append("\t").append(srv).append("\n");
        }

        return data.toString();
    }
}
