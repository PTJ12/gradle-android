package cn.ut.application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.ut.application.Entity.UserInfo;
import cn.ut.application.R;


public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<UserInfo> datas;

    public MyAdapter(Context context, List<UserInfo> datas){
        this.mContext = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_my_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        UserInfo userInfo = datas.get(position);
        vh.tvUsername.setText(userInfo.getUsername());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //创建一个holder
    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvUsername;

        public ViewHolder(@NonNull View view) {
            super(view);
            tvUsername = view.findViewById(R.id.my_username);
        }
    }
}
