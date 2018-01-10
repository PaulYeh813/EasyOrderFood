package com.paul.easyorderfood;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Paul on 2018/1/9.
 */

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.ViewHolder>{
    private static final String TAG = "MainActivity";
    private List<Item> mData;
    private  String[] mDataset;
    static int price = 0;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public CheckBox mCheckBox;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.info_text);
            mCheckBox = (CheckBox) v.findViewById(R.id.checkBox);
            mCheckBox.setChecked(false);
        }
    }
    @Override
    public DishAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final DishAdapter.ViewHolder holder, final int position) {
        Item item = mData.get(position);
        holder.mTextView.setText(item.getText());
        holder.mCheckBox.setChecked(item.isCheck());
        holder.mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b = ((CheckBox) view).isChecked();
                holder.mCheckBox.setChecked(b);
                mData.get(position).setCheck(b);

            }
        });

    }

    public DishAdapter(List<Item> data) {
        this.mData = data;
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }


}
