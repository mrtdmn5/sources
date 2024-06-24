package com.animaconnected.secondo.provider.googlefit;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import com.animaconnected.info.DeviceType;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.animaconnected.watch.BaseWatchProviderListener;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.fitness.Session;
import com.animaconnected.watch.fitness.SessionListener;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.auth.api.signin.internal.zbn;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.data.Device;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: GoogleFitProvider.kt */
/* loaded from: classes3.dex */
public final class GoogleFitProvider extends BaseWatchProviderListener implements CoroutineScope, SessionListener {
    private static Device device;
    private final MutableStateFlow<GoogleFitUiState> _uiState;
    private final GoogleFitApi api;
    private final Context context;
    private final MutableStateFlow<Device> deviceFlow;
    private boolean isUploading;
    private final CompletableJob job;
    private final StateFlow<GoogleFitUiState> uiState;
    private final WatchProvider watchProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: GoogleFitProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public GoogleFitProvider() {
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(device);
        this.deviceFlow = MutableStateFlow;
        this.watchProvider = ProviderFactory.getWatch();
        this.context = KronabyApplication.Companion.getContext();
        this.api = new GoogleFitApi(MutableStateFlow, new Function0<GoogleSignInAccount>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$api$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GoogleSignInAccount invoke() {
                GoogleSignInAccount googleAccount;
                googleAccount = GoogleFitProvider.this.getGoogleAccount();
                return googleAccount;
            }
        });
        this.job = SupervisorKt.SupervisorJob$default();
        StateFlowImpl MutableStateFlow2 = StateFlowKt.MutableStateFlow(new GoogleFitUiState(false, false, false, 7, null));
        this._uiState = MutableStateFlow2;
        this.uiState = MutableStateFlow2;
        updateUiState();
    }

    private final boolean checkFitPermission() {
        GoogleSignInAccount googleAccount = getGoogleAccount();
        FitnessOptions fitnessOptions = getFitnessOptions();
        Preconditions.checkNotNull(fitnessOptions, "Please provide a non-null GoogleSignInOptionsExtension");
        ArrayList arrayList = new ArrayList(fitnessOptions.zza);
        Scope[] scopeArr = (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
        if (googleAccount == null) {
            return false;
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, scopeArr);
        return new HashSet(googleAccount.zac).containsAll(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object disableFitWithFallback(Continuation<? super Unit> continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        Object withContext = BuildersKt.withContext(MainDispatcherLoader.dispatcher, new GoogleFitProvider$disableFitWithFallback$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    private final FitnessOptions getFitnessOptions() {
        return GoogleFitScopeProvider.INSTANCE.getFitnessOptions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GoogleSignInAccount getGoogleAccount() {
        GoogleSignInAccount googleSignInAccount;
        Context context = this.context;
        FitnessOptions fitnessOptions = getFitnessOptions();
        Preconditions.checkNotNull(context, "please provide a valid Context object");
        Preconditions.checkNotNull(fitnessOptions, "please provide valid GoogleSignInOptionsExtension");
        zbn zbc = zbn.zbc(context);
        synchronized (zbc) {
            googleSignInAccount = zbc.zbb;
        }
        if (googleSignInAccount == null) {
            Account account = new Account("<<default account>>", "com.google");
            googleSignInAccount = GoogleSignInAccount.zaa(null, null, account.name, null, null, null, null, 0L, account.name, new HashSet());
        }
        ArrayList arrayList = new ArrayList(fitnessOptions.zza);
        Scope[] scopeArr = (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
        if (scopeArr != null) {
            Collections.addAll(googleSignInAccount.zan, scopeArr);
        }
        return googleSignInAccount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasDisplay() {
        DeviceType deviceType = ProviderFactory.getWatch().getDeviceType();
        if (deviceType == null || !deviceType.getHasDisplay()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GoogleSignInClient getSignInClient() {
        Context context = this.context;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        FitnessOptions fitnessOptions = getFitnessOptions();
        fitnessOptions.getClass();
        if (!hashMap.containsKey(3)) {
            hashSet.addAll(new ArrayList(fitnessOptions.zza));
            hashMap.put(3, new GoogleSignInOptionsExtensionParcelable(1, 3, new Bundle()));
            if (hashSet.contains(GoogleSignInOptions.zae)) {
                Scope scope = GoogleSignInOptions.zad;
                if (hashSet.contains(scope)) {
                    hashSet.remove(scope);
                }
            }
            return new GoogleSignInClient(context, new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, hashMap, null));
        }
        throw new IllegalStateException("Only one extension per type may be added");
    }

    private final void registerListeners() {
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$registerListeners$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "register listeners";
            }
        }, 7, (Object) null);
        this.watchProvider.registerListener(this);
        if (getHasDisplay()) {
            this.watchProvider.fitness().registerSessionListener(this);
        }
    }

    private final void unregisterListeners() {
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$unregisterListeners$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "unregister listeners";
            }
        }, 7, (Object) null);
        this.watchProvider.unregisterListener(this);
        if (getHasDisplay()) {
            this.watchProvider.fitness().unregisterSessionListener(this);
        }
    }

    public final Object disableGoogleFit(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new GoogleFitProvider$disableGoogleFit$2(this, null), continuation);
    }

    public final boolean enableGoogleFit(CustomActivityResult<Intent, ActivityResult> launcher, Function1<? super ActivityResult, Unit> result) {
        Intent zbc;
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        Intrinsics.checkNotNullParameter(result, "result");
        if (!checkFitPermission()) {
            GoogleSignInClient signInClient = getSignInClient();
            int zba = signInClient.zba();
            int r2 = zba - 1;
            if (zba != 0) {
                Api.ApiOptions apiOptions = signInClient.zae;
                Context context = signInClient.zab;
                if (r2 != 2) {
                    if (r2 != 3) {
                        zbm.zba.d("getNoImplementationSignInIntent()", new Object[0]);
                        zbc = zbm.zbc(context, (GoogleSignInOptions) apiOptions);
                        zbc.setAction("com.google.android.gms.auth.NO_IMPL");
                    } else {
                        zbc = zbm.zbc(context, (GoogleSignInOptions) apiOptions);
                    }
                } else {
                    zbm.zba.d("getFallbackSignInIntent()", new Object[0]);
                    zbc = zbm.zbc(context, (GoogleSignInOptions) apiOptions);
                    zbc.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
                }
                launcher.launch(zbc, result);
                return false;
            }
            throw null;
        }
        updateUiState();
        return true;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return MainDispatcherLoader.dispatcher.plus(this.job);
    }

    public final StateFlow<GoogleFitUiState> getUiState() {
        return this.uiState;
    }

    public final boolean isBadgeVisible() {
        return this.context.getSharedPreferences("google-fit-badge-storage", 0).getBoolean("badge-visible", true);
    }

    public final boolean isEnabled() {
        boolean checkFitPermission = checkFitPermission();
        LogKt.debug$default((Object) this, "has Google Fit permission: " + checkFitPermission, (String) null, (Throwable) null, false, 14, (Object) null);
        return checkFitPermission;
    }

    @Override // com.animaconnected.watch.fitness.SessionListener
    public Object onCompletedPreProcess(Session session, List<? extends List<LocationEntry>> list, Continuation<? super Unit> continuation) {
        Object uploadSession = this.api.uploadSession(session, continuation);
        if (uploadSession == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return uploadSession;
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onConnectionChanged(boolean z) {
        if (z && !this.isUploading) {
            BuildersKt.launch$default(this, null, null, new GoogleFitProvider$onConnectionChanged$1(this, null), 3);
        }
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onHourly() {
        super.onHourly();
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$onHourly$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                boolean z;
                StringBuilder sb = new StringBuilder("onHourly triggered. Uploading status: ");
                z = GoogleFitProvider.this.isUploading;
                sb.append(z);
                return sb.toString();
            }
        }, 7, (Object) null);
        if (this.isUploading) {
            return;
        }
        BuildersKt.launch$default(this, null, null, new GoogleFitProvider$onHourly$2(this, null), 3);
    }

    @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onStepsNow(int r10, int r11) {
        LogKt.warn$default((Object) this, HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Steps received! Steps: ", r10, " dayOfMonth: ", r11), (String) null, (Throwable) null, false, 14, (Object) null);
        if (this.isUploading) {
            return;
        }
        BuildersKt.launch$default(this, null, null, new GoogleFitProvider$onStepsNow$1(this, r10, null), 3);
    }

    public final void setBadgeVisible(boolean z) {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("google-fit-badge-storage", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("badge-visible", z);
        edit.apply();
    }

    public final void updateUiState() {
        GoogleSignInAccount googleSignInAccount;
        boolean z;
        GoogleFitUiState value;
        zbn zbc = zbn.zbc(this.context);
        synchronized (zbc) {
            googleSignInAccount = zbc.zbb;
        }
        boolean z2 = true;
        if (googleSignInAccount != null) {
            z = true;
        } else {
            z = false;
        }
        boolean checkFitPermission = checkFitPermission();
        if (!isBadgeVisible() && (!z || checkFitPermission)) {
            z2 = false;
        }
        setBadgeVisible(z2);
        MutableStateFlow<GoogleFitUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, value.copy(z, checkFitPermission, isBadgeVisible())));
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$updateUiState$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                MutableStateFlow mutableStateFlow2;
                mutableStateFlow2 = GoogleFitProvider.this._uiState;
                return ((GoogleFitUiState) mutableStateFlow2.getValue()).toString();
            }
        }, 7, (Object) null);
        if (checkFitPermission) {
            registerListeners();
        } else {
            unregisterListeners();
        }
    }
}
