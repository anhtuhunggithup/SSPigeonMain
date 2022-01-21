package app.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import app.com.sspigeonmain.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class OnlineFriendAdapter extends RecyclerView.Adapter<OnlineFriendAdapter.ViewHolder> {

    private ArrayList<OnlineFriendObject> onlineFriendList;
    private Context context;

    public OnlineFriendAdapter(Context context, ArrayList<OnlineFriendObject> onlineFriendList) {
        this.context = context;
        this.onlineFriendList = onlineFriendList;
    }

    @NotNull
    @NonNull
    @Override
    public OnlineFriendAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_online_friend, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnlineFriendAdapter.ViewHolder holder, int position) {
        OnlineFriendObject Object = onlineFriendList.get(position);
        holder.avatar.setImageBitmap(Object.getAvatar());
        holder.userName.setText(DisplayUserName(Object));
        holder.layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Animation animation = AnimationUtils.loadAnimation(context, R.anim.item_online_friend);
                        view.startAnimation(animation);
                        break;
                    case MotionEvent.ACTION_UP:
                        view.clearAnimation();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return onlineFriendList.size();
    }

    private String DisplayUserName(OnlineFriendObject Object) {
        String tempUserName = Object.getUserName();
        String tempWord[] = new String[4], line[] = new String[]{"", ""};
        int dem = 0;
        while (tempUserName != null) {
            if (tempUserName.indexOf(' ') != -1) {
                tempWord[dem] = tempUserName.substring(0, tempUserName.indexOf(' '));
                tempUserName = tempUserName.substring(tempUserName.indexOf(' ') + 1, tempUserName.length());
                dem++;
            }
            if (tempUserName.indexOf(' ') == -1) {
                tempWord[dem] = tempUserName;
                tempUserName = null;
                dem++;
            }
        }

        if (dem == 4) {
            line[0] = tempWord[0] + " " + tempWord[1];
            line[1] = "\n" + tempWord[2] + " " + tempWord[3];
        }

        if (dem == 3) {
            line[0] = tempWord[0];
            line[1] = "\n" + tempWord[1] + " " + tempWord[2];
        }

        if (dem == 2) {
            line[0] = tempWord[0];
            line[1] = "\n" + tempWord[1];
        }

        if (dem == 1) line[0] = tempWord[0];

        line[0] = (line[0].length() > 12) ? line[0].substring(0, 12) + "..." : line[0];
        if (dem != 1)
            line[1] = (line[1].length() > 12) ? line[1].substring(0, 12) + "..." : line[1];

        return line[0] + line[1];
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout layout;
        private CircleImageView avatar;
        private TextView userName;

        public ViewHolder(@NotNull @NonNull View item) {
            super(item);
            layout = (ConstraintLayout) item.findViewById(R.id.Layout);
            avatar = (CircleImageView) item.findViewById(R.id.Avatar);
            userName = (TextView) item.findViewById(R.id.UserName);
        }
    }

}
