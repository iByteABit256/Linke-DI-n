package com.project.linkedin.ConnectionRequests;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;



@Data
@Entity
@IdClass(ConnectionRequestsPK.class)
public class ConnectionRequests implements Serializable {

    private @Id  Long id_proffessional1;
    private @Id  Long id_proffessional2;


    public ConnectionRequests() {
    }

    public ConnectionRequests(Long id_proffessional1, Long id_proffessional2) {

        this.id_proffessional1 = id_proffessional1;
        this.id_proffessional2 = id_proffessional2;

    }
}
