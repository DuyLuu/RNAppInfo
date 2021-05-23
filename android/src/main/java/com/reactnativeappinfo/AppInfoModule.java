
import android.content.pm.PackageManager;
import android.os.Build;

import com.facebook.drawee.backends.pipeline.BuildConfig;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import java.util.HashMap;
import java.util.Map;


public class AppInfoModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private final String flavor;

    private static final String APP_VERSION = "appVersion";
    private static final String APP_BUILD = "buildVersion";
    private static final String PACKAGE_NAME = "bundleIdentifier";
    private static final String FLAVOR = "flavor";
    private static final String DEVICE_MODEL = "deviceModel";

    public AppInfoModule(ReactApplicationContext reactContext, String flavor) {
        super(reactContext);
        this.reactContext = reactContext;
        if (flavor.equals("alpha")) {
            this.flavor = "dev";
        } else if (flavor.equals("beta")) {
            this.flavor = "demo";
        } else {
            this.flavor = "pro";
        }
    }

    @Override
    public String getName() {
        return "AppInfo";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        final PackageManager packageManager = this.reactContext.getPackageManager();
        final String packageName = this.reactContext.getPackageName();
        try {
            constants.put(APP_VERSION, packageManager.getPackageInfo(packageName, 0).versionName);
            constants.put(APP_BUILD, packageManager.getPackageInfo(packageName, 0).versionCode);
            constants.put(PACKAGE_NAME, packageName);
            constants.put(FLAVOR, this.flavor);
            constants.put(DEVICE_MODEL, Build.MODEL);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return constants;
    }
}
