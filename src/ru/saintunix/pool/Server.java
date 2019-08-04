package ru.saintunix.pool;

import ru.saintunix.utils.Option;

import java.util.List;

public class Server implements ManageServer {
    private int id;
    private boolean status = true;

    private List<Option<ManageServer>> nodes;

//    public Server(int id, List<ManageServer> nodes) {
//        this.id = id;
//        this.nodes = nodes;
//    }

    public Server(int id, List<Option<ManageServer>> nodes) {
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
    public List<Option<ManageServer>> getPoolServers() {
        return nodes;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder(String.format("Server: { id: %d, availability: %s }\n", id, status));
        for (Option<ManageServer> srv : nodes) {
            data.append("\t").append(srv.get()).append("\n");
        }

        return data.toString();
    }
}
