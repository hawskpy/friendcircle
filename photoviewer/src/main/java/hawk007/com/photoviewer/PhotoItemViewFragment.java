package hawk007.com.photoviewer;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.io.File;

import hawk007.com.photoviewer.view.DragPhotoView;


/**
 *
 */
public class PhotoItemViewFragment extends Fragment implements DragPhotoView.OnPhotoViewActionListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public PhotoItemViewFragment() {
        // Required empty public constructor
    }

    private static final String ARGUMENTS_IMAGE = "argumens-image";
    private ProgressBar mProgressBar;
    private DragPhotoView mImageView;

    private DragPhotoView.OnPhotoViewActionListener dismissListener;
    public static PhotoItemViewFragment newInstance(String imageUrl) {
        PhotoItemViewFragment rawImageViewerFragment = new PhotoItemViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARGUMENTS_IMAGE, imageUrl);
        rawImageViewerFragment.setArguments(bundle);
        return rawImageViewerFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_photo_item_view, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mImageView = view.findViewById(R.id.siv_raw_imageview);
        mImageView.setDismissListener(this);
        mImageView.setDoubleTapZoomScale(2.0f);
        mImageView.setMaxScale(3.0f);

        mImageView.setOnImageEventListener(new SubsamplingScaleImageView.DefaultOnImageEventListener() {
            @Override
            public void onImageLoaded() {
                super.onImageLoaded();
                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onImageLoadError(Exception e) {
                super.onImageLoadError(e);
                mProgressBar.setVisibility(View.GONE);
            }
        });
        mProgressBar = view.findViewById(R.id.progressbar);
        loadThumb();
        loadImageView();
    }


    private void loadImageView() {
        final String url = getArguments().getString(ARGUMENTS_IMAGE);
        Glide.with(this).downloadOnly().load(url)
                /* todo replace error icon */
                .apply(new RequestOptions().error(R.mipmap.qq_refresh_success))
                .into(new SimpleTarget<File>() {
                    @Override
                    public void onResourceReady(File resource, Transition<? super File> transition) {
                        mImageView.setImage(ImageSource.uri(Uri.fromFile(resource)));
                    }

                    @Override
                    public void onLoadFailed(@Nullable Drawable errorDrawable) {
                        super.onLoadFailed(errorDrawable);
                    }
                });

    }

    private void loadThumb() {
        // TODO: 2017/11/14
    }

    @Override
    public void onDismiss() {
        if(getActivity() != null){
            getActivity().onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        onDismiss();
    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(v.getContext(), "onLongClicked", Toast.LENGTH_SHORT).show();
        return true;
    }
}
