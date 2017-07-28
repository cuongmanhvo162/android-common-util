package cuongvo.androidcommon.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

/**
 * Created by cuongvo on 7/28/17.
 */

public class ClipboardUtil {

    public static void copyToClipboard(Context context, String label, String text) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(label, text);
        clipboard.setPrimaryClip(clip);

    }

    public static String copied(Context context, String text) {
        String result = null;
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboard.hasPrimaryClip()) {
            if (clipboard.getPrimaryClip().getItemAt(0).getText().toString().equals(text)) {
                result = clipboard.getPrimaryClip().getItemAt(0).getText().toString();
            }
        }

        return result;
    }
}
