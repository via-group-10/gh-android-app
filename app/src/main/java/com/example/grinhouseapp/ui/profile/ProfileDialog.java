package com.example.grinhouseapp.ui.profile;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grinhouseapp.R;

public class ProfileDialog {
    private static android.app.AlertDialog dialog;

    public static void showAlertDialog(Activity activity, boolean
            cancelableTouchOut, final AlertDialogBtnClickListener
                                               alertDialogBtnClickListener) {
        View view = LayoutInflater.from(activity).inflate(R.layout.profile_dialog, null);
        Button applyButton = view.findViewById(R.id.applyButton);
        Button cancelButton = view.findViewById(R.id.cancelButton);
        applyButton.setOnClickListener(v -> {
            alertDialogBtnClickListener.clickApply();
            dialog.dismiss();
        });
        cancelButton.setOnClickListener(v -> {
            alertDialogBtnClickListener.clickCancel();
            dialog.dismiss();
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(view);

        builder.setCancelable(true);   //返回键dismiss
        //创建对话框
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);//去掉圆角背景背后的棱角
        dialog.setCanceledOnTouchOutside(cancelableTouchOut);   //失去焦点dismiss
        dialog.show();
    }

    public interface AlertDialogBtnClickListener {
        void clickApply();

        void clickCancel();
    }

}