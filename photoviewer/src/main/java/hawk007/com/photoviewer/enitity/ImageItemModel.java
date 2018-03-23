package hawk007.com.photoviewer.enitity;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.widget.ImageView;

/**
 * Created by hawk on 2018/3/23.
 */

public class ImageItemModel {
    //    缩略图url
    private String thumbnailUrl;
    //    原图url
    private String originUrl;
    //    缩略图bitmap
    private Bitmap thumbnailBitmap;

    // 记录坐标
    private Rect mBounds;

    public int top;
    public int left;
    public int width;
    public int height;


    public ImageItemModel(String url, ImageView imageView){
        this.originUrl = url;
        int location[] = new int[2];
        imageView.getLocationOnScreen(location);
        this.left = location[0];
        this.top = location[1];
        this.width = imageView.getWidth();
        this.height = imageView.getHeight();
    }

    public Rect getmBounds() {
        return mBounds;
    }

    public void setmBounds(Rect mBounds) {
        this.mBounds = mBounds;
    }



    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    public void setThumbnailBitmap(Bitmap thumbnailBitmap) {
        this.thumbnailBitmap = thumbnailBitmap;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public Bitmap getThumbnailBitmap() {
        return thumbnailBitmap;
    }
}
