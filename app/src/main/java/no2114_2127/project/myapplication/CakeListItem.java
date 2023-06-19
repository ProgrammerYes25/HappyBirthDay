package no2114_2127.project.myapplication;
//c-케이크 꾸미기 아이템 그리드뷰 POJO 클레스
public class CakeListItem {
    int icons, circle;
    public CakeListItem(int icon){
        this.icons = icon;
        //     this.circle = circle;
    }
    public CakeListItem(int icon, int circle){
        this.icons = icon;
        this.circle = circle;
    }
    public int getCircle(){return circle;}
    public void setCircle(int circle){
        this.circle = circle;
    }
    public int getIcon(){
        return icons;
    }
    public void setIcon(int icon){
        this.icons = icon;
    }
}
