package no2114_2127.project.myapplication;

import android.net.Uri;

public class ImageClass {
    private Uri imageUri;

    public ImageClass() {
        // 기본 생성자
    }

    public ImageClass(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }


}
