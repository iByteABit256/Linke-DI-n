package com.project.linkedin.ConnectionRequests;


import java.util.List;


public interface CustomConnectionRequestsRepository {

    void accept(Long id1,Long id2);
    void reject(Long id1,Long id2);
    List<ConnectionRequests> getconnectionrequests(Long id);

}
