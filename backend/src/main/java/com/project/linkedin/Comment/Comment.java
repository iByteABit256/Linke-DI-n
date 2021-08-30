package com.project.linkedin.Comment;




import lombok.Data;

import javax.persistence.*;



@Data
@Entity
@IdClass(CommentPK.class)
public class Comment {

    private @Id  Long Proffessional_idProffessional;
    private @Id  Long Post_idPost;

    public Comment() {
    }

    public Comment(Long Proffessional_idProffessional, Long Post_idPost) {

        this.Proffessional_idProffessional = Proffessional_idProffessional;
        this.Post_idPost = Post_idPost;

    }

}


