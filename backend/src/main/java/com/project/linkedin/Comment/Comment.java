package com.project.linkedin.Comment;




import lombok.Data;

import javax.persistence.*;



@Data
@Entity
@IdClass(CommentPK.class)
public class Comment {

    private @Id  Long proffessional_id;
    private @Id  Long post_id;

    public Comment() {
    }

    public Comment(Long proffessional_id, Long post_id) {

        this.proffessional_id = proffessional_id;
        this.post_id = post_id;

    }

}


