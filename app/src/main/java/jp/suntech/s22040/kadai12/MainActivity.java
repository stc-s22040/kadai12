package jp.suntech.s22040.kadai12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClick = findViewById(R.id.btSend);
        Button btClick2 = findViewById(R.id.btClear);
        Button btClick3 = findViewById(R.id.btConfirm);

        ButtonClickListener listener = new ButtonClickListener();

        btClick.setOnClickListener(listener);
        btClick2.setOnClickListener(listener);
        btClick3.setOnClickListener(listener);


    }

        private class ButtonClickListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                //名前入力欄であるEditTextオブジェクトを取得
                EditText input1 = findViewById(R.id.etName);
                //タイトル
                EditText input2 = findViewById(R.id.etMain);
                //メールアドレス
                EditText input3 = findViewById(R.id.etMail);
                //質問内容
                EditText input4 = findViewById(R.id.etComment);

                //メッセージを表示するTextViewオブジェクトを取得
                //TextView output = findViewById(R.id.tvOutput);

                String inputStr1 = input1.getText().toString();
                String inputStr2 = input2.getText().toString();
                String inputStr3 = input3.getText().toString();
                String inputStr4 = input4.getText().toString();
                String inputStr5 = ("名前:" + inputStr1 + "タイトル" + inputStr2 + "メールアドレス" + inputStr3 + "質問内容" + inputStr4);

                int id = v.getId();
                if (id == R.id.btSend) {
                    Toast.makeText(MainActivity.this, inputStr5, Toast.LENGTH_LONG).show();
                } else if (id == R.id.btConfirm) {
                    //Toast.makeText(MainActivity.this, inputStr5, Toast.LENGTH_LONG).show();
                    MyDialogFragment dialogFragment = new MyDialogFragment();
                    dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
                } else {
                    input1.setText("");
                    input2.setText("");
                    input3.setText("");
                    input4.setText("");
                }
            }
        }
    }
