package com.project.linkedin.Connected;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;



@Data
@Entity
@IdClass(ConnectedPK.class)
public class Connected implements Serializable {
    private @Id  Long Proffessional_id1;
    private @Id  Long Proffessional_id2;


    public Connected() {
    }

    public Connected(Long Proffessional_id1, Long Proffessional_id2 ) {

        this.Proffessional_id1 = Proffessional_id1;
        this.Proffessional_id2 = Proffessional_id2;

    }
}
