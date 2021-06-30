package fr.efficom.jee.crudTo.Domain;

import java.time.LocalDate;

public class Comment {

    private LocalDate createDate;

    private String content;

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
