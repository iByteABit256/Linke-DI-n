package com.project.linkedin.Connected;


import com.project.linkedin.User.User;

import java.util.List;

public interface CustomConnectedRepository {
    List<Long> findConnected(Long id);
    List<User> getConnectedUsers(Long id);
}
