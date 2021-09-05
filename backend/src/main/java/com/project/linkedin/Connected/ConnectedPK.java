package com.project.linkedin.Connected;


import java.io.Serializable;

public class ConnectedPK implements Serializable {
    private Long Proffessional_id1;
    private Long Proffessional_id2;

    public ConnectedPK() {}

    public ConnectedPK(Long Proffessional_id1, Long Proffessional_id2) {
        this.Proffessional_id1 = Proffessional_id1;
        this.Proffessional_id2 = Proffessional_id2;
    }

//    Long getProffessional_idProffessional1(){
//        return this.Proffessional_idProffessional1;
//    }
//
//    Long getProffessional_idProffessional2(){
//        return this.Proffessional_idProffessional2;
//    }

}
