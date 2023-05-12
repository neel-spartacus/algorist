package com.test.codility;

import java.util.Optional;

public class ProcessedTransaction {

    String id;

    Optional<String> status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Optional<String> getStatus() {
        return status;
    }

    public void setStatus(Optional<String> status) {
        this.status = status;
    }
}
