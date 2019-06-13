package com.example.iosloadingdialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * 加载弹窗
 */
public class LoadingDialog extends Dialog {

    private Context mContext;
    private String message = "";
    public LoadingDialog(Context context) {
        super(context, R.style.loading_dialog);
        this.mContext = context;
        initView();
    }
    public LoadingDialog(Context context, String message) {
        super(context, R.style.loading_dialog);
        this.mContext = context;
        this.message = message;
        initView();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:
                if(LoadingDialog.this.isShowing())
                    LoadingDialog.this.dismiss();
                break;
        }
        return true;
    }

    private void initView(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_loading,null);
        TextView tipTextView = view.findViewById(R.id.tipTextView);
        setContentView(view);
        setCancelable(false);

        if (TextUtils.isEmpty(message)){
            tipTextView.setVisibility(View.GONE);
        }else {
            tipTextView.setText(message);
        }
    }
}