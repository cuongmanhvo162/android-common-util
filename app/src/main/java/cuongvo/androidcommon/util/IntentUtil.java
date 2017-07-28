package cuongvo.androidcommon.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;

/**
 * Created by cuongvo on 7/28/17.
 */

public class IntentUtil {
    public static Intent createIntent(Activity activity, Class<?> clazz, String action) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.setClass(activity, clazz);
        return intent;
    }

    public static Intent createIntentAndClearExistingTask(Activity activity, Class<?> clazz, String action) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setClass(activity, clazz);
        return intent;
    }

    public static Intent createIntentWithBundle(Activity activity, Class<?> clazz, String action, Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.setClass(activity, clazz);
        intent.putExtras(bundle);
        return intent;
    }

    public static Intent createIntentToOpenSettings(Context context) {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
        intent.setData(uri);
        return intent;
    }

    public static void createSharingIntent(Context context, String subject, String copiedData) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        sharingIntent.putExtra(Intent.EXTRA_TEXT, copiedData);
        context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
