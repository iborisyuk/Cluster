package ru.saintunix.pool;

import java.util.List;

public interface ManageServer {
    int getId();
    boolean isAvailability();
    void setStatus(boolean status);
    List<ManageServer> getPoolServers();
}
