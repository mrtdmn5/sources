package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.loader.app.LoaderManager;
import androidx.loader.app.LoaderManagerImpl;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import java.lang.reflect.Modifier;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
@KeepName
/* loaded from: classes3.dex */
public class SignInHubActivity extends FragmentActivity {
    public static boolean zba = false;
    public boolean zbb = false;
    public SignInConfiguration zbc;
    public boolean zbd;
    public int zbe;
    public Intent zbf;

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r4, int r5, Intent intent) {
        GoogleSignInAccount googleSignInAccount;
        if (this.zbb) {
            return;
        }
        setResult(0);
        if (r4 != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && (googleSignInAccount = signInAccount.zbc) != null) {
                zbn zbc = zbn.zbc(this);
                GoogleSignInOptions googleSignInOptions = this.zbc.zbb;
                googleSignInAccount.getClass();
                synchronized (zbc) {
                    zbc.zba.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
                    zbc.zbb = googleSignInAccount;
                }
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", googleSignInAccount);
                this.zbd = true;
                this.zbe = r5;
                this.zbf = intent;
                zbc();
                return;
            }
            if (intent.hasExtra("errorCode")) {
                int intExtra = intent.getIntExtra("errorCode", 8);
                if (intExtra == 13) {
                    intExtra = 12501;
                }
                zbd(intExtra);
                return;
            }
        }
        zbd(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        action.getClass();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            zbd(12500);
            return;
        }
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Log.e("AuthSignInClient", "Unknown action: ".concat(String.valueOf(intent.getAction())));
            finish();
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("config");
        bundleExtra.getClass();
        SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
        if (signInConfiguration == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        this.zbc = signInConfiguration;
        if (bundle == null) {
            if (zba) {
                setResult(0);
                zbd(12502);
                return;
            }
            zba = true;
            Intent intent2 = new Intent(action);
            if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
                intent2.setPackage("com.google.android.gms");
            } else {
                intent2.setPackage(getPackageName());
            }
            intent2.putExtra("config", this.zbc);
            try {
                startActivityForResult(intent2, 40962);
                return;
            } catch (ActivityNotFoundException unused) {
                this.zbb = true;
                Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
                zbd(17);
                return;
            }
        }
        boolean z = bundle.getBoolean("signingInGoogleApiClients");
        this.zbd = z;
        if (z) {
            this.zbe = bundle.getInt("signInResultCode");
            Intent intent3 = (Intent) bundle.getParcelable("signInResultData");
            intent3.getClass();
            this.zbf = intent3;
            zbc();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        zba = false;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zbd);
        if (this.zbd) {
            bundle.putInt("signInResultCode", this.zbe);
            bundle.putParcelable("signInResultData", this.zbf);
        }
    }

    public final void zbc() {
        LoaderManager supportLoaderManager = getSupportLoaderManager();
        zbw zbwVar = new zbw(this);
        LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl) supportLoaderManager;
        LoaderManagerImpl.LoaderViewModel loaderViewModel = loaderManagerImpl.mLoaderViewModel;
        if (!loaderViewModel.mCreatingLoader) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                SparseArrayCompat<LoaderManagerImpl.LoaderInfo> sparseArrayCompat = loaderViewModel.mLoaders;
                LoaderManagerImpl.LoaderInfo loaderInfo = (LoaderManagerImpl.LoaderInfo) sparseArrayCompat.get(0, null);
                LifecycleOwner lifecycleOwner = loaderManagerImpl.mLifecycleOwner;
                if (loaderInfo == null) {
                    try {
                        loaderViewModel.mCreatingLoader = true;
                        Set set = GoogleApiClient.zaa;
                        synchronized (set) {
                        }
                        zbc zbcVar = new zbc(this, set);
                        if (zbc.class.isMemberClass() && !Modifier.isStatic(zbc.class.getModifiers())) {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + zbcVar);
                        }
                        LoaderManagerImpl.LoaderInfo loaderInfo2 = new LoaderManagerImpl.LoaderInfo(zbcVar);
                        sparseArrayCompat.put(0, loaderInfo2);
                        loaderViewModel.mCreatingLoader = false;
                        LoaderManagerImpl.LoaderObserver<D> loaderObserver = new LoaderManagerImpl.LoaderObserver<>(loaderInfo2.mLoader, zbwVar);
                        loaderInfo2.observe(lifecycleOwner, loaderObserver);
                        Observer observer = loaderInfo2.mObserver;
                        if (observer != null) {
                            loaderInfo2.removeObserver(observer);
                        }
                        loaderInfo2.mLifecycleOwner = lifecycleOwner;
                        loaderInfo2.mObserver = loaderObserver;
                    } catch (Throwable th) {
                        loaderViewModel.mCreatingLoader = false;
                        throw th;
                    }
                } else {
                    LoaderManagerImpl.LoaderObserver<D> loaderObserver2 = new LoaderManagerImpl.LoaderObserver<>(loaderInfo.mLoader, zbwVar);
                    loaderInfo.observe(lifecycleOwner, loaderObserver2);
                    Observer observer2 = loaderInfo.mObserver;
                    if (observer2 != null) {
                        loaderInfo.removeObserver(observer2);
                    }
                    loaderInfo.mLifecycleOwner = lifecycleOwner;
                    loaderInfo.mObserver = loaderObserver2;
                }
                zba = false;
                return;
            }
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public final void zbd(int r3) {
        Status status = new Status(r3, null);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zba = false;
    }
}
