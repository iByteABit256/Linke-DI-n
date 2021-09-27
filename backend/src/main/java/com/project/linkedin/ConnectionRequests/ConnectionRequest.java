package com.project.linkedin.ConnectionRequests;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;



@Data
@Entity
@IdClass(ConnectionRequestPK.class)
public class ConnectionRequest implements Serializable {

    private @Id  Long id_proffessional1;
    private @Id  Long id_proffessional2;


    public ConnectionRequest() {
    }

    public ConnectionRequest(Long id_proffessional1, Long id_proffessional2) {

        this.id_proffessional1 = id_proffessional1;
        this.id_proffessional2 = id_proffessional2;

    }
}
