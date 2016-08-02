package com.example.mr_wind.priojectdemo.views.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mr_wind.priojectdemo.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mr_wind on 2016/8/1.
 */
public class SampleRecyclerAdapter extends RecyclerView.Adapter<SampleRecyclerAdapter.ViewHolder> {
    private final ArrayList<SampleModel> sampleData = getTestData();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 获得列表项控件（LinearLayer对象）

        // list_basic_item.xml布局文件中只包含一个<LinearLayer>标签，在该标签中包含
        // 了一个<TextView>标签
        //  item是LinearLayout对象
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycler_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //  获取当前item中显示的数据
        final SampleModel rowData = sampleData.get(position);

        //  设置要显示的数据
        holder.textViewSample.setText(rowData.getText());
        holder.itemView.setTag(rowData);

    }

    @Override
    public int getItemCount() {
        return sampleData.size();
    }

    /**
     * 删除指定的Item
     *
     * @param position 删除的item的位置
     */
    public void removeData(int position) {
        sampleData.remove(position);
        //  通知RecyclerView控件某个Item已经被删除
        notifyItemRemoved(position);
    }

    /**
     * 在指定位置添加一个新的Item
     *
     * @param positionToAdd 添加Item的位置
     */
    public void addItem(int positionToAdd) {
        sampleData.add(positionToAdd, new SampleModel("新的列表项" + new Random().nextInt(10000)));
        //  通知RecyclerView控件插入了某个Item
        notifyItemInserted(positionToAdd);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewSample;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewSample = (TextView) itemView
                    .findViewById(R.id.textViewSample);
        }
    }

    /**
     * 生成20个测试用数据
     *
     * @return 数据项目列表
     */
    public ArrayList<SampleModel> getTestData() {
        ArrayList<SampleModel> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new SampleModel("text " + i));
        }
        return list;
    }
}

