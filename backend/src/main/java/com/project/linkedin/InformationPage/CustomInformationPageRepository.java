package com.project.linkedin.InformationPage;

import java.util.List;

public interface CustomInformationPageRepository {
    InformationPage finduserinformationpage(Long id);
    int changeworkexperience(Long id,String newworkexp);
    int changebio(Long id,String newbio);
}
