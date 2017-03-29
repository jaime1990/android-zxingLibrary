package com.uuch.android_zxinglibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;
/**
 * *        _            _
 * *       |_|   ___ _  (_)  _________     __
 * *       | |  / __` | | | |  _ \ _  \  /  _ \
 * *       | | | (  | | | | | | \ | | | / /__\ \
 * *   |\__/ / | (__| | | | | | | | | | \ \_ / /
 * *   \____/   \___,_| |_| |_| | | | |  \ __ /
 * *
 *  @author: jaime
 *  @email: appeal1990@hotmail.com
 *  @date: 17-3-28 下午4:14
 *  @description: 生成二维码类
 *  @version
 *
 **/

public class ThreeActivity extends BaseActivity {

    public EditText editText = null;
    public Button button = null;
    public Button button1 = null;
    public ImageView imageView = null;

    public Bitmap mBitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);


        initView();
    }

    /**
     * 初始化组件
     */
    private void initView() {

        editText = (EditText) findViewById(R.id.edit_content);
        button = (Button) findViewById(R.id.button_content);
        button1 = (Button) findViewById(R.id.button1_content);
        imageView = (ImageView) findViewById(R.id.image_content);

        /**
         * 生成二维码图片
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textContent = editText.getText().toString();
                if (TextUtils.isEmpty(textContent)) {
                    Toast.makeText(ThreeActivity.this, "您的输入为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editText.setText("");
                mBitmap = CodeUtils.createImage(textContent, 500, 500, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                imageView.setImageBitmap(mBitmap);
            }
        });

        /**
         * 生成不带logo的二维码图片
         */
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textContent = editText.getText().toString();
                if (TextUtils.isEmpty(textContent)) {
                    Toast.makeText(ThreeActivity.this, "您的输入为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                editText.setText("");
                mBitmap = CodeUtils.createImage(textContent, 500, 500, null);
                imageView.setImageBitmap(mBitmap);
            }
        });
    }

}
