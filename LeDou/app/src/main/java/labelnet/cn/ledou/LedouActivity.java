package labelnet.cn.ledou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LedouActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ledou);

        /**
         * TextInputLayout使用
         */
        final TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.tv_layout);
        textInputLayout.setHint("请输入你的姓名：");

        EditText editText = textInputLayout.getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 10) {
                    textInputLayout.setError("姓名长度太长了");
                    textInputLayout.setErrorEnabled(true);
                } else {
                    textInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /**
         * Snaked bar
         */
        final FloatingActionButton btn_floating = (FloatingActionButton) findViewById(R.id.btn_floating);
        btn_floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Snackbar snackbar = Snackbar.make(btn_floating, "www.labelnet.cn", Snackbar.LENGTH_LONG);

                //添加一个按钮
                snackbar.setAction("点击访问", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
            }
        });


        final Button btn_tabs = (Button) findViewById(R.id.btn_tabs);
        btn_tabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LedouActivity.this, TestActivity.class));
            }
        });


        final Button btn_navigation = (Button) findViewById(R.id.btn_navigation);
        btn_navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LedouActivity.this, navitionActivity.class));
            }
        });

        final Button btn_toobar = (Button) findViewById(R.id.btn_toobar);
        btn_toobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LedouActivity.this, toobarActivity.class));
            }
        });
    }


}
