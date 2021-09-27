package com.project.linkedin.DiscussionIndex;



import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@IdClass(DiscussionIndexPK.class)
public class DiscussionIndex implements Serializable {
    private  @Id Long id_proffessional1;
    private  @Id Long id_proffessional2;
    private Long id_discussion;


    public DiscussionIndex() {
    }

    public DiscussionIndex(Long id_proffessional1,Long id_proffessional2, Long id_discussion) {

        this.id_proffessional1= id_proffessional1;
        this.id_proffessional2 = id_proffessional2;
        this.id_discussion= id_discussion;

    }

}
