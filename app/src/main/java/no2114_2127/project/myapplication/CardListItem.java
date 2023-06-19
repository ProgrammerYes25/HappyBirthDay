package no2114_2127.project.myapplication;

public class CardListItem {
    private String userName;
    private String date;

    public CardListItem() {
        // 기본 생성자
    }

    public CardListItem(String userName, String date) {
        this.userName = userName;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
