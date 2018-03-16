package hawk007.com.friendcircle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hawk007.com.friendcircle.activite.FriendCircleActivity;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_friend_circle_btn)
    Button mainFriendCircleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.main_friend_circle_btn})
    public void clicked(View view) {
        switch (view.getId()) {
            case R.id.main_friend_circle_btn:
                Intent intent = new Intent(MainActivity.this, FriendCircleActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
