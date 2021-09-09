package com.project.linkedin.Proffessional;



import java.util.List;

public interface CustomProffessionalRepository {
    List<Proffessional> getNameLike(String firstName);
    List<Proffessional> getEmailLike(String email);
    Proffessional getProffessionalByUserID(Long ID);
}
