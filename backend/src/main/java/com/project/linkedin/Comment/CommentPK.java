package com.project.linkedin.Comment;


import java.io.Serializable;

public class CommentPK implements Serializable {
    private Long Post_id;
    private Long Proffessional_id;


    public CommentPK() {}

    public CommentPK( Long Proffessional_id,Long Post_id) {
        this.Post_id = Post_id;
        this.Proffessional_id = Proffessional_id;
    }

//    Long getPostid(){
//        return this.Post_idPost;
//    }
//
//    Long getProffid(){
//        return this.Proffessional_idProffessional;
//    }



}
