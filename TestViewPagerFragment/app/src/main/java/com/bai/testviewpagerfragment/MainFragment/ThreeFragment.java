package com.bai.testviewpagerfragment.MainFragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bai.testviewpagerfragment.Interface.FragmentMessgeI;
import com.bai.testviewpagerfragment.R;

public class ThreeFragment extends Fragment implements View.OnClickListener {


    private TextView fg_tv;
    private Button button;
    private FragmentMessgeI callback;
    private ReceiveBroadCast receiveBroadCast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_three,container,false);
        fg_tv = view.findViewById(R.id.tv_one_fg);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(this);

        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (FragmentMessgeI) context;
        receiveBroadCast = new ReceiveBroadCast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.bai.three");
        getActivity().registerReceiver(receiveBroadCast,intentFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (receiveBroadCast!=null){
            getActivity().unregisterReceiver(receiveBroadCast);
        }
    }

    public void SetText(String s){
        fg_tv.setText(s);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                callback.transferString("接口从3跳到1",0);
                break;
        }
    }

    class ReceiveBroadCast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            SetText(intent.getStringExtra("text"));
        }
    }
}
