package com.itheima.googleplaydemo.ui.fragment;

import android.content.Intent;
import android.widget.BaseAdapter;

import com.itheima.googleplaydemo.R;
import com.itheima.googleplaydemo.adapter.AppListAdapter;
import com.itheima.googleplaydemo.bean.AppListItem;
import com.itheima.googleplaydemo.ui.activity.AppDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者: Leon
 * 创建时间: 2016/9/17 9:59
 * 描述： TODO
 */
public abstract class BaseAppListFragment extends BaseLoadMoreListFragment {

    List<AppListItem> mAppListItems = new ArrayList<AppListItem>();

    @Override
    protected BaseAdapter onCreateAdapter() {
       return new AppListAdapter(getContext(), mAppListItems);
    }

    @Override
    protected void initListView() {
        super.initListView();
        setListDivider(getResources().getDimensionPixelSize(R.dimen.app_list_divider_height));
    }


    @Override
    public void onResume() {
        super.onResume();
        if (getAdapter() != null) {
            getAdapter().notifyDataSetChanged();
        }
    }


    @Override
    protected void onListItemClick(int i) {
        Intent intent = new Intent(getContext(), AppDetailActivity.class);
        intent.putExtra("package_name", getAppList().get(i).getPackageName());
        startActivity(intent);
    }



    protected List<AppListItem> getAppList() {
        return mAppListItems;
    }
}
