package com.project.linkedin.Comment;


import java.io.Serializable;

public class CommentPK implements Serializable {
    private Long post_id;
    private Long proffessional_id;


    public CommentPK() {}

    public CommentPK( Long proffessional_id,Long post_id) {
        this.post_id = post_id;
        this.proffessional_id = proffessional_id;
    }

//    Long getPostid(){
//        return this.Post_idPost;
//    }
//
//    Long getProffid(){
//        return this.Proffessional_idProffessional;
//    }



}
