package fr.efficom.jee.crudTo.Domain;

import com.google.common.base.MoreObjects;

import java.time.LocalDateTime;

public class Comment {

    private LocalDateTime createDate;

    private String content;

    private String userEmail;

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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("createDate", createDate)
                .add("content", content)
                .add("userEmail", userEmail)
                .toString();
    }
}
