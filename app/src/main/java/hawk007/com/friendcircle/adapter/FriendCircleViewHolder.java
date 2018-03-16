package hawk007.com.friendcircle.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import hawk007.com.friendcircle.model.ImageInfo;

/**
 * Created by hawk on 2018/3/16.
 */

public class FriendCircleViewHolder extends RecyclerView.ViewHolder {
    //商品详情
    TextView text;
    RecyclerView recycler;
    Context mContext;

    FriendCircleViewHolder(View view, Context context) {
        super(view);
        mContext = context;
        text = (TextView) ((LinearLayout) view).getChildAt(0);
        recycler = (RecyclerView) ((LinearLayout) view).getChildAt(1);
    }

    public void bind(ImageInfo imageInfo) {
        text.setText(imageInfo.title);
        Log.v("DetailAdapter", imageInfo.title);
        recycler.setLayoutManager(new GridLayoutManager(mContext, 4));
        recycler.setAdapter(new ImageAdapter(mContext, imageInfo.images));

    }
}
