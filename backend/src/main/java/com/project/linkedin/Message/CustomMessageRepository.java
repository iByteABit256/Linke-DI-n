package com.project.linkedin.Message;


import java.util.List;

public interface CustomMessageRepository {
    List<Message> getMessages(Long id_disc);
}
