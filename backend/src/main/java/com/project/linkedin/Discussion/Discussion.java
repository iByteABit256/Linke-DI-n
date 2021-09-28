package com.project.linkedin.Discussion;



import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
public class Discussion implements Serializable {
    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id_discussion;
    private  Long id_proffessional1;
    private  Long id_proffessional2;


    public Discussion() {
    }

    public Discussion(Long id_proffessional1,Long id_proffessional2, Long id_discussion) {

        this.id_discussion= id_discussion;
        this.id_proffessional1= id_proffessional1;
        this.id_proffessional2 = id_proffessional2;

    }

}
