package com.example.imooc_baseadapter;

import java.util.ArrayList;
import java.util.List;

import com.baseadapter.bean.Bean;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private ListView mListView;
	private List<Bean> mDatas;//�������������˶��item�������Ҫ���4��Bean�����list
	//private MyAdapter mAdapter;//�����Զ����������
	private MyAdapterWithCommonViewHolder mAdapterWithCommonViewHolder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initDatas();//�ȵ��������������Ϊ�����������adapter����������
		initView();//���������ǳ�ʼ����view��Ϊlistview������������
	}
	
	private void initView() {
		mListView = (ListView) findViewById(R.id.id_listview);
		//mListView.setAdapter(mAdapter);
		mListView.setAdapter(mAdapterWithCommonViewHolder);
	}
	private void initDatas() {
		//��������listview�ϵ�����
		mDatas = new ArrayList<Bean>();
		Bean bean1 = new Bean("С���õĹ���1","��һ�죬С����ȥ�ӱߵ��㣬ʲôҲû������"
				+ "�ؼ��ˡ��ڶ��죬С������ȥ�ӱߵ��㣬����ʲôҲû�������ؼ��ˡ������죬С���øյ��ӱߣ�"
				+ "һ������Ӻ���������������С���ô�У��������Ҫ���ٸ��ú��Ჷ��������Ҿͱ����㣡",
				"2015-12-31","10086");
		mDatas.add(bean1);
		Bean bean2 = new Bean("С���õĹ���2","����ϲ����ʳ���ǰ���ܿ��ա�һ�գ������̿�׷���ӣ���ϲ��"
				+ "����������ס���ӣ���ݺݵ�˵�������ӣ��Ѻ��ܲ���������",
				"2015-12-31","10086");
		mDatas.add(bean2);
		Bean bean3 = new Bean("С���õĹ���3","һֻ����͵��������һ�����Ⱦ��ܣ����ӽ�׷���ᡣ�����鼱֮������������"
				+ "��һ�����һֻ������˳����������̲�ס��Ц����������С������Ƥ�������˰ɣ�",
				"2015-12-31","10086");
		mDatas.add(bean3);
		Bean bean4 = new Bean("С���õĹ���4","С�������ڴ�ɭ����������·�ˣ���ʱ��������һֻС���ã����С���ÿ�ѧ���ˣ�"
				+ "�ܹ�ȥ˵����С���ø�磬С���ø�磬��Ҫ�Ǹ��������������߳���ɭ�֣��Ҿ���������������С����һ����"
				+ "��ʱ��Բ�˸�С����һ������ͣ�˵�����ҿ�����Ѿ����·�ţ������Ұ��ţ���",
				"2015-12-31","10086");
		mDatas.add(bean4);
		Bean bean5 = new Bean("С���õĹ���5","������ɭ�����ߣ�ͻȻ����һֻ����������æһͷ���������һֻ�ȡ�"
				+ "С���ü��˺ܺ��棬�ʣ����ڸ�ʲô?�������Ķ���˵���ꡭ������������Ұ�Ѿһ��ͷ����",
				"2015-12-31","10086");
		mDatas.add(bean5);
		
		//mAdapter = new MyAdapter(this, mDatas);
		mAdapterWithCommonViewHolder = new MyAdapterWithCommonViewHolder(this, mDatas);
		
	}

	
}
