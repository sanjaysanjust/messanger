package org.sanjay.javabrains.messanger.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CommentListWrapper {
	private List<Comment> comment;

    public CommentListWrapper() {
    }

    public CommentListWrapper(List<Comment> comment) {
        this.comment = comment;
    }

    @XmlElement(name = "comment")
    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

}
