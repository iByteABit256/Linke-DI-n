package com.project.linkedin.InterestDeclaration;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@IdClass(InterestDeclarationPK.class)
public class InterestDeclaration implements Serializable {

    private @Id Long id_proffessional;
    private @Id Long id_post;

    public InterestDeclaration() {
    }

    public InterestDeclaration( Long id_user, Long id_post ) {

        this.id_proffessional = id_user;
        this.id_post = id_post;

    }
}
