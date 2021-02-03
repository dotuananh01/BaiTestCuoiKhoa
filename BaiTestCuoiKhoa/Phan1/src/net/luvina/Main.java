package net.luvina;

public class Main {

    public static void main(String[] args) {
        System.out.println("===============Start Test post================");
        User anhDT = new User(1L, "Do Tuan Anh");
        System.out.println("User: "+ anhDT.getId() + "_" + anhDT.getFullName() + "_" + anhDT.getPosts().size() + "_" + anhDT.getComments().size());

        Post postA = new Post(1L, "Post A", "Content A", anhDT);
        anhDT.submitPost(postA);
        System.out.println("Post: "+ postA.getId() + "_" + postA.getTitle() + "_" + postA.getContent() + "_" + postA.getAuthor().getId());

        Post postB = new Post(2L, "Post B", "Content B", anhDT);
        anhDT.submitPost(postB);
        System.out.println("Post: "+ postB.getId() + "_" + postB.getTitle() + "_" + postB.getContent() + "_" + postB.getAuthor().getId());


        System.out.println("User: "+ anhDT.getId() + "_" + anhDT.getFullName() + "_" + anhDT.getPosts().size() + "_" + anhDT.getComments().size());



        User hienPT = new User(2, "Phan Thi Hien");
        System.out.println("User2: " + hienPT.getFullName());
        Post post3 = new Post(3L, "Post 1", "Content 1", anhDT);
        hienPT.submitPost(post3);
        System.out.println("User2: " + hienPT.getFullName() + "post bài số 1: " + post3.getContent());
        System.out.println("===============End Test post================");

        System.out.println("===============Start Test comment================");
        Comment comment1 = new Comment(1L, "User 1 comment 1 cho post 1", postB, anhDT);
        System.out.println("User1: " + anhDT.getFullName() + "comment 1: " + comment1.getTitle() + "cho post: " + postB.getId());

        Comment comment2 = new Comment(2L, "User 1 comment 1 cho post 1 cua user 2", post3, hienPT);
        System.out.println("User1: " + anhDT.getFullName() + "comment 1: " + comment2.getTitle() + "cho post: " + post3.getId());
        System.out.println("===============End Test comment================");

        System.out.println("===============Start Test remove================");
        System.out.println("User1 remove post 1");
        anhDT.deletePost(postB);

        System.out.println("User1 remove comment1 of Post 1");
        anhDT.deleteComment(comment2);

    }
}
