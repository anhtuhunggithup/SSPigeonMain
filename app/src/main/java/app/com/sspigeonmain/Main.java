package app.com.sspigeonmain;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    RecyclerView rcvOnlineFriend, rcvFriend;
    OnlineFriendAdapter onlinefriendAdapter;
    FriendAdapter friendAdapter;
    ArrayList<OnlineFriendObject> onlineFriendList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Mapping();
        DataRcvOnlineFriend();
        DataRcvFriend();
    }

    private void Mapping() {
        rcvOnlineFriend = findViewById(R.id.RecyclerOnlineFriend);
        rcvFriend = findViewById(R.id.RecyclerFriend);
    }

    public void DataRcvOnlineFriend() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avatar_information_main);
        onlineFriendList.add(new OnlineFriendObject(bitmap, "Hung Pham"));
        onlineFriendList.add(new OnlineFriendObject(bitmap, "Pham Huynh Thanh Hung"));
        onlineFriendList.add(new OnlineFriendObject(bitmap, "Nguyen Cong Danh"));
        onlineFriendList.add(new OnlineFriendObject(bitmap, "Hung"));
        onlineFriendList.add(new OnlineFriendObject(bitmap, "Hung Taoaaaaaaaaaaa aiaaaaaaaaaaa"));
        onlineFriendList.add(new OnlineFriendObject(bitmap, "Hungaaaaaaaaaaaaaaaaaaaa"));
        onlinefriendAdapter = new OnlineFriendAdapter(getApplicationContext(), onlineFriendList);
        LinearLayoutManager layout = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvOnlineFriend.setLayoutManager(layout);
        rcvOnlineFriend.setHasFixedSize(true);
        rcvOnlineFriend.setAdapter(onlinefriendAdapter);
        rcvOnlineFriend.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                onlinefriendAdapter.notifyDataSetChanged();
            }
        });
    }

    private void DataRcvFriend() {
        friendAdapter = new FriendAdapter(getApplicationContext());
        LinearLayoutManager layout = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rcvFriend.setLayoutManager(layout);
        rcvFriend.setHasFixedSize(true);
        rcvFriend.setAdapter(friendAdapter);
    }

}
