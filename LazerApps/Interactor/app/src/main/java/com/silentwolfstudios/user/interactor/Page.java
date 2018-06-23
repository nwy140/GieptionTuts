package com.silentwolfstudios.user.interactor;

// This is for imageView and TextView // Waiter

public class Page {

    private int textId;
    private int imageId;

    private Choice choice1;
    private Choice choice2;

    private  boolean isFinalPage;

    public boolean isFinalPage() {
        return isFinalPage;
    }

    public void setFinalPage(boolean finalPage) {
        isFinalPage = finalPage;
    }


    public Page(int textId, int imageId) {
        this.textId = textId;
        this.imageId = imageId;
        isFinalPage = true;
    }


    public Page(int textId, int imageId, Choice choice1, Choice choice2) {
        this.textId = textId;
        this.imageId = imageId;
        this.choice1 = choice1;
        this.choice2 = choice2;
        isFinalPage = false;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }
}