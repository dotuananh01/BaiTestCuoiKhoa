package net.luvina;

import java.io.IOException;
import java.util.ArrayList;

public class User {
    private long id;
    private String fullName;
    private ArrayList<Post> posts;
    private ArrayList<Comment> comments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public User(long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.posts = new ArrayList<Post>();
        this.comments = new ArrayList<Comment>();
    }

    public void submitPost(Post post) {
        posts.add(post);
    }

    public void deletePost(Post post) throws PostException {
        if (isAuthorOfPost(post)) {
            posts.remove(post);
        } else {
            System.out.println("You haven't permission to delete this post!");
            throw new PostException("You haven't permission to delete this post!", new IOException());
        }
    }

    private boolean isAuthorOfPost(Post post) {
        if (post == null){
            return false;
        }
        if (this.equals(post.getAuthor())) {
            return true;
        }
        return false;
    }

    public void submitComment(Post post, Comment comment) {
        if (comment == null || post == null){
            return ;
        }
        post.addComment(comment);
        comments.add(comment);
    }

    public void deleteComment(Post post, Comment comment) {
        if (comment == null || post == null){
            return;
        }
        if (isAuthorOfComment(comment)) {
            post.deleteComment(comment);
            comments.remove(comment);
        } else {
            System.out.println("You haven't permission to delete this post!");
        }
    }

    private boolean isAuthorOfComment (Comment comment) {
        if (comment == null){
            return false;
        }
        if (this.equals(comment.getAuthor())) {
            return true;
        }
        return false;
    }

}

