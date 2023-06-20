package no2114_2127.project.myapplication;

public class CardDataClass {
    String userName;
    String cardName;
    String date;
    String email;

    public CardDataClass() {
        // 기본 생성자
    }

    public CardDataClass(String userName, String cardName, String date, String email) {
        this.userName = userName;
        this.cardName = cardName;
        this.date = date;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}