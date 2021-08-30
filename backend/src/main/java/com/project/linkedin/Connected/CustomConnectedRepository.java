package com.project.linkedin.Connected;


import java.util.List;

public interface CustomConnectedRepository {
    List<Long> findConnected(Long id);
}
