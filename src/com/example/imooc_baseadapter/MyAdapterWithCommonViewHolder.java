package com.example.imooc_baseadapter;

import java.util.List;

import javax.security.auth.PrivateCredentialPermission;

import com.baseadapter.bean.Bean;
import com.baseadapter.utils.CommonAdapter;
import com.baseadapter.utils.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * �޸Ĵ���������ʹ֮�̳������Ƕ���ĳ���ͨ�õ�CommonAdapter
 */
public class MyAdapterWithCommonViewHolder extends CommonAdapter<Bean> {
	
	public MyAdapterWithCommonViewHolder(Context context, List<Bean> datas) {
		super(context, datas, R.layout.item);
	}

	@Override
	public void convert(ViewHolder holder, Bean bean) {
		/*TextView title = holder.getView(R.id.id_title);
		title.setText(bean.getTitle());
		//��������仰���Ժϲ�Ϊ((TextView)holder.getView(R.id.id_title)).setText(bean.getTitle());
		TextView desc = holder.getView(R.id.id_desc);
		desc.setText(bean.getDesc());
		TextView time = holder.getView(R.id.id_time);
		time.setText(bean.getTime());
		TextView phone = holder.getView(R.id.id_phone);
		phone.setText(bean.getPhone());*/
		
		holder.setText(R.id.id_title, bean.getTitle())
		.setText(R.id.id_desc, bean.getDesc())
		.setText(R.id.id_time, bean.getTime())
		.setText(R.id.id_phone, bean.getPhone());
	}

}
