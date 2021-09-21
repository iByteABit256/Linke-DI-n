package com.project.linkedin.InterestDeclaration;


import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestDeclarationRepository  extends JpaRepository<InterestDeclaration, InterestDeclarationPK> , CustomInterestDeclarationRepository {
}
