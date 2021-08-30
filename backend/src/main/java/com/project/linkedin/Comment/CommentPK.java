package com.project.linkedin.Comment;


import java.io.Serializable;

public class CommentPK implements Serializable {
    private Long Post_idPost;
    private Long Proffessional_idProffessional;


    public CommentPK() {}

    public CommentPK( Long Proffessional_idProffessional,Long Post_idPost) {
        this.Post_idPost = Post_idPost;
        this.Proffessional_idProffessional = Proffessional_idProffessional;
    }

//    Long getPostid(){
//        return this.Post_idPost;
//    }
//
//    Long getProffid(){
//        return this.Proffessional_idProffessional;
//    }



}
