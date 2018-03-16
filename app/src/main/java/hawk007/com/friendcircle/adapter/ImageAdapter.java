package hawk007.com.friendcircle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import hawk007.com.friendcircle.model.ImageInfo;
import hawk007.com.photoviewer.PhotoViewerActivity;

/**
 * Created by hawk on 2018/3/16.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageItemViewHolder> {
    private String[] images;
    private ImageView[] imageViews;
    private Context mContext;

    ImageAdapter(Context context,String[] images) {
        this.mContext = context;
        this.images = images;
    }


    // 获取数据的数量
    @Override
    public int getItemCount() {
        return images.length;
    }

    public ImageAdapter(Context context) {
        this.mContext = context;
    }

    // 创建新View，被LayoutManager所调用
    @Override
    public ImageItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        ImageView image = new ImageView(mContext);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(250, 250);
        lp.setMargins(0, 4, 0, 4);
        image.setLayoutParams(lp);
        return new ImageItemViewHolder(mContext,image);
    }

    // 将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final ImageItemViewHolder viewHolder, final int position) {
        viewHolder.bind(images[position],position);
        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhotoViewerActivity.startPhotoViewerActivity(mContext, images, position);
                //List转[] --- List.toArray(new String[List.size()])
//                ImageShowActivity.startImageActivity((Activity) mContext, imageViews, images, currentPosition);
            }
        });
        if (imageViews == null) {
            imageViews = new ImageView[images.length];
        }
        imageViews[position] = viewHolder.image;
    }
}
