package cuongvo.androidcommon.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by cuongvo on 7/28/17.
 */

public class NetworkConnectionUtil {
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
