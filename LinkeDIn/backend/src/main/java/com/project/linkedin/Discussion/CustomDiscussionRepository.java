package com.project.linkedin.Discussion;


import java.util.List;

public interface CustomDiscussionRepository {
    List<Discussion> getDiscussions(Long id_prof);
}
