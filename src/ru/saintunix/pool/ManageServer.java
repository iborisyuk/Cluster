package ru.saintunix.pool;

import ru.saintunix.utils.Option;

import java.util.List;

public interface ManageServer {
    int getId();
    boolean isAvailability();
    void setStatus(boolean status);
    List<Option<ManageServer>> getPoolServers();
}
