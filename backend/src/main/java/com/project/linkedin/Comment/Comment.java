package com.project.linkedin.Comment;




import lombok.Data;

import javax.persistence.*;



@Data
@Entity
@IdClass(CommentPK.class)
public class Comment {

    private @Id  Long Proffessional_id;
    private @Id  Long Post_id;

    public Comment() {
    }

    public Comment(Long Proffessional_id, Long Post_id) {

        this.Proffessional_id = Proffessional_id;
        this.Post_id = Post_id;

    }

}


