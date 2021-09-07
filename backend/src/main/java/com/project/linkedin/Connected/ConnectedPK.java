package com.project.linkedin.Connected;


import java.io.Serializable;

public class ConnectedPK implements Serializable {
    private Long proffessional_id1;
    private Long proffessional_id2;

    public ConnectedPK() {}

    public ConnectedPK(Long proffessional_id1, Long proffessional_id2) {
        this.proffessional_id1 = proffessional_id1;
        this.proffessional_id2 = proffessional_id2;
    }

//    Long getProffessional_idProffessional1(){
//        return this.Proffessional_idProffessional1;
//    }
//
//    Long getProffessional_idProffessional2(){
//        return this.Proffessional_idProffessional2;
//    }

}
