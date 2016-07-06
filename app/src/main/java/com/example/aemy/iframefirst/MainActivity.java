package com.example.aemy.iframefirst;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.aemy.iframefirst.beans.User;
import com.example.aemy.iframeyong.net.listener.ResponseHandler;
import com.example.aemy.iframeyong.net.manager.NetworkManager;
import com.example.aemy.iframeyong.utils.ToastUtils;
import com.example.aemy.iframeyong.utils.UIUtils;
import com.example.aemy.iframeyong.view.multistateview.MultiStateView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import java.util.HashMap;
import java.util.Map;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewById(R.id.multiStateView)
    MultiStateView multiStateView;
    @AfterViews
    void initAfterViews(){
        multiStateView.getView(MultiStateView.VIEW_STATE_ERROR).findViewById(R.id.retry)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        multiStateView.setViewState(MultiStateView.VIEW_STATE_LOADING);
                        UIUtils.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                multiStateView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
                            }
                        }, 3000);
                    }
                });
        Map<String, String> map=new HashMap<String,String>();
        map.put("username", "15933888320");
        map.put("password", "123456");
        NetworkManager.getNetworkManager().postRequest(this, "http://dsappresttest.dashangapp.com/login", map, User.class,
                new ResponseHandler() {
            @Override
            public void onSuccess(boolean code, Object response) {
                ToastUtils.showToast(MainActivity.this,"加载成功");
                multiStateView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
            }

            @Override
            public void onError(Exception e) {
                ToastUtils.showToast(MainActivity.this,"加载错误");
            }

            @Override
            public void onStartLoading() {
                ToastUtils.showToast(MainActivity.this,"正在加载");
                multiStateView.setViewState(MultiStateView.VIEW_STATE_LOADING);
            }

            @Override
            public void onNullData() {
                ToastUtils.showToast(MainActivity.this,"没有数据");
            }

            @Override
            public void onNullNetWork() {
                ToastUtils.showToast(MainActivity.this,"没有网络");
            }
        });
    }
}
