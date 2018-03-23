package hawk007.com.photoviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import hawk007.com.photoviewer.enitity.ImageItemModel;

/**
 * Created by hawk on 2018/3/23.
 */

public final class GPhotoPreviewBuilder {
    private Activity mContext;
    private Intent intent;
    private Class className;

    private GPhotoPreviewBuilder(@NonNull Activity activity) {
        mContext = activity;
        intent = new Intent();
    }

    /***
     * 设置开始启动预览
     * @param activity  启动
     *@return     GPreviewBuilder
     * **/
    public static GPhotoPreviewBuilder from(@NonNull Activity activity) {
        return new GPhotoPreviewBuilder(activity);
    }

    /***
     * 设置开始启动预览
     * @param fragment  启动
     *@return     GPreviewBuilder
     * **/
    public static GPhotoPreviewBuilder from(@NonNull Fragment fragment) {
        return new GPhotoPreviewBuilder(fragment.getActivity());
    }

    /****
     *自定义预览activity 类名
     * @param className   继承GPreviewActivity
     *@return     GPreviewBuilder
     * **/
    public GPhotoPreviewBuilder to(@NonNull Class className) {
        this.className = className;
        intent.setClass(mContext, className);
        return this;
    }

    /***
     * 设置数据源
     * @param imageUrls 数据
     *@param   <T>    你的实体类类型
     * @return GPreviewBuilder
     * **/
    public <T extends ImageItemModel> GPhotoPreviewBuilder setData(@NonNull String[] imageUrls, @NonNull ImageView[] imageViews) {
//        intent.putParcelableArrayListExtra("imagePaths", new ArrayList<Parcelable>(imgUrls));
        return this;
    }

    /***
     * 设置默认索引
     * @param currentIndex 数据
     * @return GPreviewBuilder
     * **/
    public GPhotoPreviewBuilder setCurrentIndex(int currentIndex) {
        intent.putExtra("position", currentIndex);
        return this;
    }

    /***
     * 设置指示器类型
     * @param indicatorType 枚举
     * @return GPreviewBuilder
     * **/
    public GPhotoPreviewBuilder setType(@NonNull IndicatorType indicatorType) {
        intent.putExtra("type", indicatorType);
        return this;
    }

    /***
     * 设置图片禁用拖拽返回
     * @param isDrag  true  可以 false 默认 true
     * @return GPreviewBuilder
     * **/
    public GPhotoPreviewBuilder setDrag(boolean isDrag) {
        intent.putExtra("isDrag", isDrag);
        return this;
    }

    /***
     * 是否设置为一张图片时 显示指示器  默认显示
     * @param isShow   true  显示 false 不显示
     * @return GPreviewBuilder
     * **/
    public GPhotoPreviewBuilder setSingleShowType( boolean isShow) {
        intent.putExtra("isShow", isShow);
        return this;
    }

    /***
     * 设置超出内容点击退出（黑色区域）
     * @param isSingleFling  true  可以 false
     * @return GPreviewBuilder
     * **/
    public GPhotoPreviewBuilder setSingleFling(boolean isSingleFling) {
        intent.putExtra("isSingleFling", isSingleFling);
        return this;
    }

    /***
     *  设置动画的时长
     * @param setDuration  单位毫秒
     * @return GPreviewBuilder
     * **/
    public GPhotoPreviewBuilder setDuration(int setDuration) {
        intent.putExtra("duration", setDuration);
        return this;
    }
    /***
     * 启动
     * **/
    public void start() {
        if (className == null) {
            intent.setClass(mContext, PhotoViewerActivity.class);
        } else {
            intent.setClass(mContext, className);
        }
        mContext.startActivity(intent);
        mContext.overridePendingTransition(0,0);
        intent = null;
        mContext = null;
    }

    public enum IndicatorType {
        Dot, Number
    }
}
