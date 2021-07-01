package fr.efficom.jee.crudTo.Domain;

import java.time.LocalDateTime;

public class Comment {

    private LocalDateTime createDate;

    private String content;

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
