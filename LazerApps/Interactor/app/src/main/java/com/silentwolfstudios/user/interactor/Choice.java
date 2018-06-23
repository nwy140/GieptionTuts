package com.silentwolfstudios.user.interactor;

//This is for button //

public class Choice {
    private int buttonId;
    private int pageNumber;

    public Choice(int buttonId, int pageNumber) {
        this.buttonId = buttonId;
        this.pageNumber = pageNumber;
    }

    public int getButtonId() {
        return buttonId;
    }

    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}