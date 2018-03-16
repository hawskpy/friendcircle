package hawk007.com.friendcircle.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import hawk007.com.friendcircle.R;

/**
 * Created by hawk on 2018/3/16.
 * 自定义的ViewHolder，持有每个Item的的所有界面元素
 */

public class ImageItemViewHolder extends RecyclerView.ViewHolder{
    //商品详情
    ImageView image;
    private Context mContext;

    ImageItemViewHolder(Context context,View view) {
        super(view);
        image = (ImageView) view;
        mContext = context;
    }

    public void bind( String path,int position){
        showImage(path, image);
    }

    /**
     * 显示图片
     */
    public void showImage(String url, ImageView imageView) {
        if (!TextUtils.isEmpty(url) && url.length() > 0) {
            url = url.replaceAll(" ", "");
        }
        if (TextUtils.isEmpty(url)) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(mContext).load(url)
//                .dontAnimate()
//                .placeholder(R.mipmap.ic_loding)
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .error(R.mipmap.ic_loding_error)
                .into(imageView);
//        Picasso.with(this).load(url)
//                .error(R.mipmap.ic_loding_error)
//                .into(imageView);
    }

}
