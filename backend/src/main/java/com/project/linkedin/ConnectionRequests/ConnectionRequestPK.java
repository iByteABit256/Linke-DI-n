package com.project.linkedin.ConnectionRequests;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;


@Getter
@Setter
public class ConnectionRequestPK implements Serializable {

    private Long id_proffessional1;
    private Long id_proffessional2;

}
