package com.baseadapter.utils;

import java.util.List;

import com.baseadapter.bean.Bean;
import com.example.imooc_baseadapter.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * ��дͨ�õ�Adapter��ָ�����ͣ��Ա���Ӧ��ͬ��Java bean
 * @param <T>
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
	//��Щ���Զ���ÿ���������ж����õ��ģ����ʿ��Ʒ�����Ϊprotected���Ա�̳е����඼�ܷ���
	protected LayoutInflater mInflater;
	protected List<T> mDatas;//����Դ
	protected Context mContext;
	protected int layoutId;//item�����ļ�
	
	public CommonAdapter(Context context, List<T> mDatas, int layoutId) {
		this.mContext = context;
		this.mDatas = mDatas;
		mInflater = LayoutInflater.from(context);
		this.layoutId = layoutId;
	}

	@Override
	public int getCount() {		
		return mDatas.size();
	}

	@Override
	public T getItem(int position) {//����ķ���ֵ������T�������Զ����ɵ�Object
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		//��ʼ��ViewHolder���������ǵ�item�����ļ�
		ViewHolder holder = ViewHolder.get(mContext, convertView, parent, layoutId, position);
		convert(holder, getItem(position));//getItem(position)�����;���T����仰�������еľ���ʵ�־��Ǹ�����Ŀؼ���ʼ��
		//����ֵ����ʼ����ֵ�ؼ�ʱ��ҪviewHolder�;��������Java bean����������������������T
		return holder.getConvertView();//����convertView
	}
	public abstract void convert(ViewHolder holder, T t);

}
