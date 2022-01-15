package app.com.sspigeonmain;

import android.graphics.Bitmap;

public class OnlineFriendObject {

    private Bitmap avatar;
    private String userName;

    public OnlineFriendObject(Bitmap avatar, String userName) {
        this.avatar = avatar;
        this.userName = userName;
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
