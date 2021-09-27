package com.project.linkedin.DiscussionIndex;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;


@Getter
@Setter
public class DiscussionIndexPK implements Serializable {
    private  Long id_proffessional1;
    private  Long id_proffessional2;

    public DiscussionIndexPK(){
    }

    public DiscussionIndexPK(Long id_proffessional1, Long id_proffessional2){
        this.id_proffessional1 = id_proffessional1;
        this.id_proffessional2 = id_proffessional2;
    }
}
