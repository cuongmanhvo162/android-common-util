package cuongvo.androidcommon.util.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {

	public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public interface Listener {
		public void onSoftKeyboardShown(boolean isShowing);
	}

	private Listener listener;

	public void setListener(Listener listener) {
		this.listener = listener;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int height = MeasureSpec.getSize(heightMeasureSpec);
		Activity activity = (Activity) getContext();
		Rect rect = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
		int statusBarHeight = rect.top;
		int screenHeight = activity.getWindowManager().getDefaultDisplay()
				.getHeight();
		int diff = (screenHeight - statusBarHeight) - height;
		if (listener != null) {
			listener.onSoftKeyboardShown(diff > 128); // assume all soft
														// keyboards are at
														// least 128 pixels high
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

}