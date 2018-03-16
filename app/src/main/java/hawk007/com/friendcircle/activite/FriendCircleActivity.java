package hawk007.com.friendcircle.activite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hawk007.com.friendcircle.R;
import hawk007.com.friendcircle.adapter.FriendCircleAdapter;
import hawk007.com.friendcircle.model.ImageInfo;

public class FriendCircleActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_circle);
        ButterKnife.bind(this);

        initView();
    }

    private void initView(){
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        List<ImageInfo> infos = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ImageInfo info = new ImageInfo();
            info.title = "这是一组测试图片" + "---item=" + i;
            info.images = new String[7];
            info.images[0] = "http://img4.duitang.com/uploads/item/201312/05/20131205171756_cfAFz.thumb.600_0.jpeg";
            info.images[1] = "http://v1.qzone.cc/skin/201601/17/17/21/569b5d317bdcb243.jpg%21600x600.jpg";
            info.images[2] = "http://img1.imgtn.bdimg.com/it/u=3429135274,3155470602&fm=214&gp=0.jpg";
            info.images[3] = "https://img.huxiucdn.com/moment/201803/02/155825464977.jpeg";
            info.images[4] = "https://img.huxiucdn.com/test/moment/201802/01/201210081900.jpg";
            info.images[5] = "http://img4.duitang.com/uploads/item/201312/05/20131205171756_cfAFz.thumb.600_0.jpeg";
            info.images[6] = "https://img.huxiucdn.com/test/moment/201801/03/141929965352.gif";
            infos.add(info);
        }

        recyclerview.setAdapter(new FriendCircleAdapter(this, infos));
    }
}
