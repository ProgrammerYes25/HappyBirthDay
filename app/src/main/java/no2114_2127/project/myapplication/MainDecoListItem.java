package no2114_2127.project.myapplication;

import android.widget.TextView;

public class MainDecoListItem {
    TextView nameAndBirth;
    TextView cardName;

    public  MainDecoListItem (TextView cardName, TextView nameAndBirth){
        this.cardName=cardName;
        this.nameAndBirth=nameAndBirth;

    }

    public TextView getNameAndBirth() {
        return nameAndBirth;
    }

    public void setNameAndBirth(TextView nameAndBirth) {
        this.nameAndBirth = nameAndBirth;
    }

    public TextView getCardName() {
        return cardName;
    }

    public void setCardName(TextView cardName) {
        this.cardName = cardName;
    }








}
