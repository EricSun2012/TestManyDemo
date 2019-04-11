package com.robot.anyDemo.gouwuche;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.robot.anyDemo.R;

public class MyAnimationAdapter extends RecyclerView.Adapter<MyAnimationAdapter.ViewHolder> {

    private AnimationInterface mContext;

    public MyAnimationAdapter(AnimationInterface context) {
        this.mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext.getContext(), R.layout.item_anim, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.iv_anim = view.findViewById(R.id.iv_anim);
        viewHolder.txt_title = view.findViewById(R.id.tv);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.iv_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] loc = new int[2];
                view.getLocationInWindow(loc);
                loc[0] = loc[0] - view.getLayoutParams().width / 2;
                loc[1] = loc[1] - view.getLayoutParams().height / 2;
                mContext.playAnimation(loc);
            }
        });
        holder.txt_title.setText("吐司面包种类" + (position + 1));
    }

    @Override
    public int getItemCount() {
        return 16;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_anim;
        private TextView txt_title;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
