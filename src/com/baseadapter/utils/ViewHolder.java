package com.baseadapter.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ����һ��ͨ�õ�viewholder��
 *
 */
public class ViewHolder {
	private SparseArray<View> mViews;
	private int mPosition;
	private View mConvertView;
	//layoutId������Ҫ�����item�����ļ���id
	public ViewHolder(Context context, ViewGroup parent, int layoutId, int position)
	{
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);//�������ǵ�item�����ļ�
		mConvertView.setTag(this);
	}
	//ViewHolder������ÿ�ζ���Ҫʵ��������convertview��Ϊ��ʱ���ǾͲ���Ҫ��ʵ����ViewHolder�������������һ����ڷ���
	//���ж��Ƿ���Ҫ��ViewHolderʵ����
	public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position)
	{
		if (convertView == null) {
			return new ViewHolder(context, parent, layoutId, position);//����һ��ʵ��������
		}
		else {
			ViewHolder holder = (ViewHolder) convertView.getTag();
			holder.mPosition = position;
			return holder;
		}
	}
	
	/**
	 * ͨ��viewId��ȡ�ؼ�,�˷������ص���View��һ������
	 */
	public <T extends View> T getView(int viewId)
	{
		View view = mViews.get(viewId);
		if (view == null) {
			//���mViewsû����Ӧ�Ŀؼ������Ǿʹ�convertView���ҵ�����ؼ��������˿ؼ�����id�����mViews��
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}
	//mConvertView��get����
	public View getConvertView() {
		return mConvertView;
	}	
	/**
	 * �ҵ����Ƕ����TextView�ؼ��������ؼ���ֵ
	 */
	public ViewHolder setText(int viewId, String text)
	{
		TextView tv = getView(viewId);
		tv.setText(text);
		return this;
	}
	
	/**
	 * ���item����ImageView�ؼ��Ļ������ǾͿ����ô˷������ؼ�����ͼƬ��Դ
	 */
	public ViewHolder setImageResource(int viewId, int resId)
	{
		ImageView imageView = getView(viewId);
		imageView.setImageResource(resId);
		return this;
	}
	public ViewHolder setImageBitmap(int viewId, Bitmap bitmap)
	{
		ImageView imageView = getView(viewId);
		imageView.setImageBitmap(bitmap);
		return this;
	}
	//���ǻ�������������ĸ���ķ�������������������������

}
