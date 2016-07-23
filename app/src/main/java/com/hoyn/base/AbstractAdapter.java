package com.hoyn.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Hoyn
 * Created by a on 2016/6/12.
 */
public abstract class AbstractAdapter<E, T extends BaseHolder> extends BaseAdapter {


    protected List<E> data = new ArrayList<E>();
    protected Context context;

    public AbstractAdapter() {
    }

    public AbstractAdapter(List<E> list) {
        this.data = list;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    /**
     * 增加全部list
     *
     * @param data
     */
    public void addDatas(List<E> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 增加某个item
     *
     * @param data
     */
    public void addData(E data) {
        this.data.add(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 删除某项item
     *
     * @param position
     */
    public void delItem(int position) {
        if (data != null && data.size() > position) {
            data.remove(position);
            this.notifyDataSetChanged();
        }
    }

    /**
     * 删除全部
     */
    public void delAll() {
        data.clear();
        this.notifyDataSetChanged();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        T holder = null;
        if (convertView == null) {
            convertView = getItemView(getView(), parent);
            holder = getHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (T) convertView.getTag();
        }
        bindEvent(holder, position);
        return convertView;
    }


    protected abstract T getHolder(View v);

    protected abstract int getView();

    protected abstract void bindEvent(T holder, int position);

    protected View getItemView(int id, ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(id, parent, false);
    }

}
