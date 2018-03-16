package hawk007.com.friendcircle.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import hawk007.com.friendcircle.model.ImageInfo;

/**
 * Created by hawk on 2018/3/16.
 */

public class FriendCircleAdapter  extends RecyclerView.Adapter<FriendCircleViewHolder> {
    private List<ImageInfo> infos;
    private Context mContext;

    public FriendCircleAdapter(Context context, List<ImageInfo> infos) {
        this.mContext = context;
        this.infos = infos;
    }

    // 获取数据的数量
    @Override
    public int getItemCount() {
        return infos.size();
    }

    // 创建新View，被LayoutManager所调用
    @Override
    public FriendCircleViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LinearLayout linearLayout = new LinearLayout(mContext);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(lp);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(20, 20, 20, 20);

        TextView textView = new TextView(mContext);
        RecyclerView recyclerView = new RecyclerView(mContext);
        linearLayout.addView(textView);
        linearLayout.addView(recyclerView);

        return new FriendCircleViewHolder(linearLayout,mContext);
    }

    // 将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(FriendCircleViewHolder viewHolder, int position) {
        viewHolder.bind(infos.get(position));
    }
}
