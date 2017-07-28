package cuongvo.androidcommon.util.bus;

import com.squareup.otto.Bus;

import java.util.HashMap;

/**
 * Created by cuongvo on 6/16/17.
 */

public class AppBus {
    private static HashMap<Integer, String> clientList = null;

    private static MainThreadBus instance = null;

    private AppBus() {
        instance = new MainThreadBus();
    }

    public static Bus getInstance() {
        if (instance == null) {
            instance = new MainThreadBus();
        }

        return instance;
    }

    public static Bus getInstance(Class clazz) {
        if (instance == null) {
            instance = new MainThreadBus();
            clientList = new HashMap<>();
        }

        clientList.put(clazz.hashCode(), clazz.getSimpleName());

        return instance;
    }

    public static HashMap<Integer, String> getClientList() {
        return clientList;
    }
}
