package com.project.linkedin.Connected;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;



@Data
@Entity
@IdClass(ConnectedPK.class)
public class Connected implements Serializable {
    private @Id  Long id_proffessional1;
    private @Id  Long id_proffessional2;


    public Connected() {
    }

    public Connected(Long id_proffessional1, Long id_proffessional2) {

        this.id_proffessional1 = id_proffessional1;
        this.id_proffessional2 = id_proffessional2;

    }
}
