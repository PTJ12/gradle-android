package cn.ut.application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.ut.application.R;
import cn.ut.application.listern.OnItemClickListener;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<String> datas;
    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    public ListAdapter(Context context, List<String> datas){
        this.mContext = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_layout, parent, false);

        ListHolder listHolder = new ListHolder(view);
        return listHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListHolder lh = (ListHolder) holder;
        String s = datas.get(position);
        lh.listTest.setText(s);
        lh.str = s;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder{

        private TextView listTest;

        private String str;
        public ListHolder(@NonNull View view) {
            super(view);
            listTest = view.findViewById(R.id.list_test);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.OnItemClick(str);
                }
            });
        }
    }
}
