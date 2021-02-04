package net.luvina;

public class Main {

    public static void main(String[] args) {
        System.out.println("==Start Test post===");
        System.out.println("==Khởi tạo user Do Tuan Anh===");
        User anhDT = new User(1L, "Do Tuan Anh");
        System.out.println("User: "+ anhDT.getId() + "_" + anhDT.getFullName() + "_" + anhDT.getPosts().size() + "_" + anhDT.getComments().size());

        System.out.println("==User Do Tuan Anh post bài A===");
        Post postA = new Post(1L, "Post A", "Content A", anhDT);
        anhDT.submitPost(postA);
        System.out.println("Post: "+ postA.getId() + "_" + postA.getTitle() + "_" + postA.getContent() + "_" + postA.getAuthor().getId());

        System.out.println("==User Do Tuan Anh post bài B===");
        Post postB = new Post(2L, "Post B", "Content B", anhDT);
        anhDT.submitPost(postB);
        System.out.println("Post: "+ postB.getId() + "_" + postB.getTitle() + "_" + postB.getContent() + "_" + postB.getAuthor().getId());

        System.out.println("==User Do Tuan Anh comment 1 vào bài post A===");
        Comment firstCommentInPostA = new Comment(1L, "First comment", postA, anhDT);
        anhDT.submitComment(postA, firstCommentInPostA);

        System.out.println("==User Do Tuan Anh comment 2 vào bài post B===");
        Comment secondCommentInPostB = new Comment(2L, "Second comment", postB, anhDT);
        anhDT.submitComment(postB, secondCommentInPostB);

        System.out.println("==Khởi tạo user Phan Thi Hien===");
        User hienPT = new User(2L, "Phan Thi Hien");

        System.out.println("==User Phan Thi Hien post bài C===");
        Post postC = new Post(3L, "Post C", "Content C", hienPT);
        hienPT.submitPost(postC);

        System.out.println("==User Phan Thi Hien comment 3 vào bài post A===");
        Comment secondCommentInPostA = new Comment(3L, "Second comment", postA, hienPT);
        hienPT.submitComment(postA, secondCommentInPostA);

        System.out.println("User Do Tuan Anh: "+ anhDT.getId() + "_" + anhDT.getFullName() + "_" + anhDT.getPosts().size() + " post" + "_" + anhDT.getComments().size() + " comment");
        System.out.println("User Phan Thi Hien: "+ hienPT.getId() + "_" + hienPT.getFullName() + "_" + hienPT.getPosts().size() + " post" + "_" + hienPT.getComments().size() + " comment");

        System.out.println("==User Do Tuan Anh xóa comment 1 và bài post A===");
        System.out.println("==User Phan Thi Hien xóa comment 3 tại bài post A===");
        hienPT.deleteComment(postA, secondCommentInPostA);
        anhDT.deleteComment(postA, firstCommentInPostA);
        anhDT.deletePost(postA);

        System.out.println("User Do Tuan Anh: "+ anhDT.getId() + "_" + anhDT.getFullName() + "_" + anhDT.getPosts().size() + " post" + "_" + anhDT.getComments().size() + " comment");
        System.out.println("User Phan Thi Hien: "+ hienPT.getId() + "_" + hienPT.getFullName() + "_" + hienPT.getPosts().size() + " post" + "_" + hienPT.getComments().size() + " comment");
        System.out.println("==End Test post===");

    }
}
