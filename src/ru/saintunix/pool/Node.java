package ru.saintunix.pool;

import ru.saintunix.exceptions.ServerNotNode;
import ru.saintunix.utils.Option;

import java.util.List;

public class Node implements ManageServer {
    private int id;
    private boolean status = true;

    public Node(int id) {
        this.id = id;
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
    public String toString() {
        return String.format("Node: { id: %d, availability: %s }", id, status);
    }

    @Override
    public List<Option<ManageServer>> getPoolServers() {
        throw new ServerNotNode("Class Node does not contains other servers.");
    }

}
