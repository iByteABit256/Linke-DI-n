package com.project.linkedin.Connected;


import java.io.Serializable;

public class ConnectedPK implements Serializable {
    private Long id_proffessional1;
    private Long id_proffessional2;

    public ConnectedPK() {}

    public ConnectedPK(Long id_proffessional1, Long id_proffessional2) {
        this.id_proffessional1 = id_proffessional1;
        this.id_proffessional2 = id_proffessional2;
    }

//    Long getProffessional_idProffessional1(){
//        return this.Proffessional_idProffessional1;
//    }
//
//    Long getProffessional_idProffessional2(){
//        return this.Proffessional_idProffessional2;
//    }

}
