package net.luvina;

public class Comment {
    private long id;
    private String title;
    private Post post;
    private User author;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Comment(long id, String title, Post post, User author) {
        this.id = id;
        this.title = title;
        this.post = post;
        this.author = author;
    }
}
