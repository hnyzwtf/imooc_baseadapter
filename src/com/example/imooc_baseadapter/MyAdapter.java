package com.example.imooc_baseadapter;

import java.util.List;

import javax.security.auth.PrivateCredentialPermission;

import com.baseadapter.bean.Bean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


/**
 * �½�һ��listview������������Ҫ�Ĳ����У�Context,����Դ��List<Bean>��
 * �Լ���LayoutInflater�������ǵ�item�����ļ�
 *	��������ԭʼ�ķ���
 */
public class MyAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<Bean> mDatas;
	
	public MyAdapter(Context context, List<Bean> datas) {
		mInflater = LayoutInflater.from(context);
		mDatas = datas;
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//��ʼ��viewholder
		ViewHolder holder = null;
		
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item, parent, false);//����item�����ļ�
			holder = new ViewHolder();
			//��ʼ�����ǵ�item�еĿؼ�
			holder.mTitle = (TextView) convertView.findViewById(R.id.id_title);
			holder.mDesc = (TextView) convertView.findViewById(R.id.id_desc);
			holder.mTime = (TextView) convertView.findViewById(R.id.id_time);
			holder.mPhone = (TextView) convertView.findViewById(R.id.id_phone);
			
			convertView.setTag(holder);
		}
		else {
			holder = (ViewHolder) convertView.getTag();
		}
		//Ϊ�ؼ���ֵ
		Bean bean = mDatas.get(position);
		
		holder.mTitle.setText(bean.getTitle());
		holder.mDesc.setText(bean.getDesc());
		holder.mTime.setText(bean.getTime());
		holder.mPhone.setText(bean.getPhone());
		return convertView;
	}
	private class ViewHolder
	{
		//item�е��ĸ��ؼ�
		TextView mTitle;
		TextView mDesc;
		TextView mTime;
		TextView mPhone;
	}

}
