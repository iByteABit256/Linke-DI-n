package com.project.linkedin.InformationPage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationPageRepository  extends JpaRepository<InformationPage,Long> , CustomInformationPageRepository {

}
