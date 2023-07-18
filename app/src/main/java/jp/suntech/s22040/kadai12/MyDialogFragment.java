package jp.suntech.s22040.kadai12;

import android.app.AlertDialog;

import android.app.Dialog;

import android.content.DialogInterface;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment{

    @NonNull
    @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        //ダイアログビルダーの生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //ダイアログのタイトル設定
        builder.setTitle(R.string.dialog_title);
        //ダイアログのメッセージ設定
        builder.setMessage(R.string.dialog_msg);
        //Positive Button
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
        //Negative Button
        builder.setNegativeButton(R.string.dialog_btn_no, new DialogButtonClickListener());
        //ダイアログオブジェクトを生成し、りたーん
        AlertDialog dialog = builder.create();
        return dialog;
    }
    //ダイアログのアクションボタンがタップされた時の処理が記述されたメンバクラス
    private class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which){
            //トーストメッセージ用文字列変数を用意
            String msg = "";
            //タップされたアクションボタン
            switch (which){
                //Positive Buttonならば
                case DialogInterface.BUTTON_POSITIVE:
                    //はい用メッセージ
                    msg = getString(R.string.dialog_btn_ok_toast);
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    //いいえ用メッセージ
                    msg = getString(R.string.dialog_btn_no_toast);
                    break;
            }
            //トーストの表示
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }
    }
}
