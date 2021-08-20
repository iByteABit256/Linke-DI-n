package com.project.linkedin.Connected;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;



@Data
@Entity
public class Connected implements Serializable {
    private @Id  Long Proffessional_idProffessional1;
    private @Id  Long Proffessional_idProffessional2;


    public Connected() {
    }

    public Connected(Long Proffessional_idProffessional1, Long Proffessional_idProffessional2 ) {

        this.Proffessional_idProffessional1 = Proffessional_idProffessional1;
        this.Proffessional_idProffessional2 = Proffessional_idProffessional2;

    }
}
