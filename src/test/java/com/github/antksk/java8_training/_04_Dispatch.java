package com.github.antksk.java8_training;

import com.google.common.collect.Lists;

import java.util.List;

public class _04_Dispatch {

    interface Post{
        void postOn(SNS sns);
    }

    static class TextPost implements Post{
        @Override
        public void postOn(SNS sns) {
            sns.post(this); // visit 패턴
        }
    }

    static class PicturePost implements  Post{
        @Override
        public void postOn(SNS sns) {
            sns.post(this);
        }
    }



    interface SNS {
        void post(TextPost post);
        void post(PicturePost post);
    }

    static class Facebook implements  SNS{

        @Override
        public void post(TextPost post) {
            System.out.println("Facebook : " + post.getClass().getSimpleName());
        }

        @Override
        public void post(PicturePost post) {
            System.out.println("Facebook : " + post.getClass().getSimpleName());
        }
    }

    static class Twitter implements SNS{

        @Override
        public void post(TextPost post) {
            System.out.println("Twitter : " + post.getClass().getSimpleName());
        }

        @Override
        public void post(PicturePost post) {
            System.out.println("Twitter : " + post.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        List<Post> posts = Lists.newArrayList(new TextPost(), new PicturePost());
        List<SNS> snss = Lists.newArrayList(new Facebook(), new Twitter());

        posts.forEach(p->{
            snss.forEach(s->p.postOn(s));
        });

    }
}
