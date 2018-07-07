package com.cskaoyan.project.bean;

public class Conversation {
    Letter letter;
    User user;

    public Conversation() {
    }

    public Conversation(Letter letter, User user) {

        this.letter = letter;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "letter=" + letter +
                ", user=" + user +
                '}';
    }

    public Letter getLetter() {
        return letter;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
