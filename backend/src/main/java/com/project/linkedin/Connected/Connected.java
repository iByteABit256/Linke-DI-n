package com.project.linkedin.Connected;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;



@Data
@Entity
@IdClass(ConnectedPK.class)
public class Connected implements Serializable {
    private @Id  Long proffessional_id1;
    private @Id  Long proffessional_id2;


    public Connected() {
    }

    public Connected(Long proffessional_id1, Long proffessional_id2 ) {

        this.proffessional_id1 = proffessional_id1;
        this.proffessional_id2 = proffessional_id2;

    }
}
