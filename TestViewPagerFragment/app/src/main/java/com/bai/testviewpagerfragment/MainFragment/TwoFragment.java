package com.bai.testviewpagerfragment.MainFragment;

import android.content.Context;
import android.content.Intent;
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

public class TwoFragment extends Fragment implements View.OnClickListener {

    private TextView fg_tv;
    private Button button;
    private FragmentMessgeI callback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_two,container,false);
        fg_tv = view.findViewById(R.id.tv_one_fg);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (FragmentMessgeI) context;
    }

    public void SetText(String s){
        fg_tv.setText(s);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                callback.transferString("接口从2跳到1",0);
                Intent intent = new Intent();
                intent.putExtra("text","广播从2到3");
                intent.setAction("com.bai.three");
                getActivity().sendBroadcast(intent);
                break;
        }
    }
}
