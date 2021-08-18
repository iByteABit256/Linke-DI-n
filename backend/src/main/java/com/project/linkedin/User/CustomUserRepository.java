package com.project.linkedin.User;

import java.util.List;

public interface CustomUserRepository {
    List<User> getNameLike(String firstName);
    List<User> getEmailLike(String email);
}
