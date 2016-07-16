package com.chen.meili.activity;

import com.chen.meili.R;
import com.utils.EditUtil;
import com.utils.snackbar.SnackBar;
import com.utils.snackbar.SnackBar.Style;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

	private EditText editText;
	// private Context context;
	private EditUtil eUtil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		eUtil = new EditUtil(this);
		editText = (EditText) findViewById(R.id.editText1);
		editText.setImeOptions(EditorInfo.IME_ACTION_SEND);
	}

	public void click(View v) {
		switch (v.getId()) {
		case R.id.button1:
			// 关闭键盘
			// SnackBar.makeMsg(this, "提示消息", (short) 1500).show();
			editText.setImeOptions(EditorInfo.IME_ACTION_DONE);
			eUtil.getInputMed().open(editText);

			break;
		case R.id.button2:
			eUtil.getInputMed().close(editText);
			SnackBar.makeMsg(this, "有action 点击 ", "OK", (short) 0).show();

			break;
		case R.id.button3:
			SnackBar.makeMsg(this, "有监听的", "ok", new SnackBar.OnMessageClickListener() {

				@Override
				public void onMessageClick(Parcelable token) {
					// SnackBar.makeMsg(MainActivity.this, "点击事件",
					// SnackBar.LONG_SNACK).show();
					Toast.makeText(MainActivity.this, "点击事件", 0).show();
				}
			}, SnackBar.LONG_SNACK).withStyle(Style.CONFIRM).show();
			break;

		}

	}

	/**
	 * 点击退出
	 */
	@Override

	public void onBackPressed() {

		SnackBar.makeMsg(this, "确定退出？", "确定", new SnackBar.OnMessageClickListener() {

			@Override
			public void onMessageClick(Parcelable token) {
				MainActivity.this.finish();
			}
		}, SnackBar.SHORT_SNACK).withStyle(Style.CONFIRM).show();

	}

}
