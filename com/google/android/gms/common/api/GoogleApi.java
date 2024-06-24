package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import androidx.collection.ArraySet;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.api.internal.zach;
import com.google.android.gms.common.api.internal.zacv;
import com.google.android.gms.common.api.internal.zae;
import com.google.android.gms.common.api.internal.zah;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public abstract class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {
    public final GoogleApiManager zaa;
    public final Context zab;
    public final String zac;
    public final Api zad;
    public final Api.ApiOptions zae;
    public final ApiKey zaf;
    public final Looper zag;
    public final int zah;

    @NotOnlyInitialized
    public final zabv zai;
    public final ApiExceptionMapper zaj;

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public static class Settings {
        public static final Settings DEFAULT_SETTINGS = new Settings(new ApiExceptionMapper(), Looper.getMainLooper());
        public final ApiExceptionMapper zaa;
        public final Looper zab;

        public Settings(ApiExceptionMapper apiExceptionMapper, Looper looper) {
            this.zaa = apiExceptionMapper;
            this.zab = looper;
        }
    }

    @Deprecated
    public GoogleApi() {
        throw null;
    }

    public GoogleApi(Context context, Api<O> api, O o, Settings settings) {
        String str;
        if (context == null) {
            throw new NullPointerException("Null context is not permitted.");
        }
        if (api == null) {
            throw new NullPointerException("Api must not be null.");
        }
        if (settings != null) {
            this.zab = context.getApplicationContext();
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                }
                this.zac = str;
                this.zad = api;
                this.zae = o;
                this.zag = settings.zab;
                this.zaf = new ApiKey(api, o, str);
                this.zai = new zabv(this);
                GoogleApiManager zam = GoogleApiManager.zam(this.zab);
                this.zaa = zam;
                this.zah = zam.zan.getAndIncrement();
                this.zaj = settings.zaa;
                zau zauVar = zam.zat;
                zauVar.sendMessage(zauVar.obtainMessage(7, this));
                return;
            }
            str = null;
            this.zac = str;
            this.zad = api;
            this.zae = o;
            this.zag = settings.zab;
            this.zaf = new ApiKey(api, o, str);
            this.zai = new zabv(this);
            GoogleApiManager zam2 = GoogleApiManager.zam(this.zab);
            this.zaa = zam2;
            this.zah = zam2.zan.getAndIncrement();
            this.zaj = settings.zaa;
            zau zauVar2 = zam2.zat;
            zauVar2.sendMessage(zauVar2.obtainMessage(7, this));
            return;
        }
        throw new NullPointerException("Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    }

    public final ClientSettings.Builder createClientSettingsBuilder() {
        Account account;
        Collection emptySet;
        GoogleSignInAccount googleSignInAccount;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        Api.ApiOptions apiOptions = this.zae;
        boolean z = apiOptions instanceof Api.ApiOptions.HasGoogleSignInAccountOptions;
        if (z && (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions).getGoogleSignInAccount()) != null) {
            String str = googleSignInAccount.zaf;
            if (str != null) {
                account = new Account(str, "com.google");
            }
            account = null;
        } else {
            if (apiOptions instanceof Api.ApiOptions.HasAccountOptions) {
                account = ((Api.ApiOptions.HasAccountOptions) apiOptions).getAccount();
            }
            account = null;
        }
        builder.zaa = account;
        if (z) {
            GoogleSignInAccount googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions).getGoogleSignInAccount();
            if (googleSignInAccount2 == null) {
                emptySet = Collections.emptySet();
            } else {
                emptySet = googleSignInAccount2.getRequestedScopes();
            }
        } else {
            emptySet = Collections.emptySet();
        }
        if (builder.zab == null) {
            builder.zab = new ArraySet();
        }
        builder.zab.addAll(emptySet);
        Context context = this.zab;
        builder.zad = context.getClass().getName();
        builder.zac = context.getPackageName();
        return builder;
    }

    public final zzw doUnregisterEventListener(ListenerHolder.ListenerKey listenerKey, int r5) {
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.getClass();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        googleApiManager.zaL(taskCompletionSource, r5, this);
        zah zahVar = new zah(listenerKey, taskCompletionSource);
        zau zauVar = googleApiManager.zat;
        zauVar.sendMessage(zauVar.obtainMessage(13, new zach(zahVar, googleApiManager.zao.get(), this)));
        return taskCompletionSource.zza;
    }

    @Override // com.google.android.gms.common.api.HasApiKey
    public final ApiKey<O> getApiKey() {
        return this.zaf;
    }

    public final void zad(int r3, BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        boolean z;
        if (!baseImplementation$ApiMethodImpl.zaq && !((Boolean) BasePendingResult.zaa.get()).booleanValue()) {
            z = false;
        } else {
            z = true;
        }
        baseImplementation$ApiMethodImpl.zaq = z;
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.getClass();
        zae zaeVar = new zae(r3, baseImplementation$ApiMethodImpl);
        zau zauVar = googleApiManager.zat;
        zauVar.sendMessage(zauVar.obtainMessage(4, new zach(zaeVar, googleApiManager.zao.get(), this)));
    }

    public final zzw zae(int r5, zacv zacvVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.getClass();
        googleApiManager.zaL(taskCompletionSource, zacvVar.zac, this);
        com.google.android.gms.common.api.internal.zag zagVar = new com.google.android.gms.common.api.internal.zag(r5, zacvVar, taskCompletionSource, this.zaj);
        zau zauVar = googleApiManager.zat;
        zauVar.sendMessage(zauVar.obtainMessage(4, new zach(zagVar, googleApiManager.zao.get(), this)));
        return taskCompletionSource.zza;
    }
}
