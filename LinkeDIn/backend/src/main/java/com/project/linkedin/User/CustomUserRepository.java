package com.project.linkedin.User;

import java.util.List;

public interface CustomUserRepository {
    List<User> getNameLike(String firstName);
    User getEmailLike(String email);
    User getUserFromProf(Long id_prof);
}
