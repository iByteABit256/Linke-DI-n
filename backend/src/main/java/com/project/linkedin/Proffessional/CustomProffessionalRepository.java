package com.project.linkedin.Proffessional;


import com.project.linkedin.User.User;
import java.util.List;

public interface CustomProffessionalRepository {
    List<User> getNameLike(String firstName);
    List<Proffessional> getEmailLike(String email);
    Proffessional getProffessionalByUserID(Long ID);

}
