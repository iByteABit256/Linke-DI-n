package com.project.linkedin.Connected;


import java.io.Serializable;

public class ConnectedPK implements Serializable {
    private Long Proffessional_idProffessional1;
    private Long Proffessional_idProffessional2;

    public ConnectedPK() {}

    public ConnectedPK(Long Proffessional_idProffessional1, Long Proffessional_idProffessional2) {
        this.Proffessional_idProffessional1 = Proffessional_idProffessional1;
        this.Proffessional_idProffessional2 = Proffessional_idProffessional2;
    }

//    Long getProffessional_idProffessional1(){
//        return this.Proffessional_idProffessional1;
//    }
//
//    Long getProffessional_idProffessional2(){
//        return this.Proffessional_idProffessional2;
//    }

}
