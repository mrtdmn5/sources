package com.animaconnected.secondo.behaviour.distress.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel;
import com.animaconnected.watch.behaviour.distress.WalkMeHomeState;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DistressModel.kt */
/* loaded from: classes3.dex */
public final class DistressModel {
    private static final String MODEL = "model";
    private static final String PREFERENCES_NAME = "com.kronaby.watch.distress";

    @SuppressLint({"StaticFieldLeak"})
    private static DistressModel sInstance;
    private final Lazy distressData$delegate;
    private final Handler handler;
    private final List<OnChangeListener> onChangeListeners;
    private final Runnable saveRunnable;
    private SharedPreferences sharedPreferences;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DistressModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DistressModel getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            DistressModel distressModel = DistressModel.sInstance;
            if (distressModel == null) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                DistressModel distressModel2 = new DistressModel(applicationContext, null);
                DistressModel.sInstance = distressModel2;
                return distressModel2;
            }
            return distressModel;
        }

        private Companion() {
        }
    }

    /* compiled from: DistressModel.kt */
    /* loaded from: classes3.dex */
    public static final class Data {

        @SerializedName("invitationToken")
        private String invitationToken;

        @SerializedName("configured")
        private boolean isConfigured;

        @SerializedName("observer")
        private Observer observer;

        @SerializedName("state")
        private String state = WalkMeHomeState.NotStarted.string;

        @SerializedName("subject")
        private Subject subject;

        @SerializedName(AWSCognitoLegacyCredentialStore.TOKEN_KEY)
        private String token;

        public final String getInvitationToken() {
            return this.invitationToken;
        }

        public final Observer getObserver() {
            return this.observer;
        }

        public final String getState() {
            return this.state;
        }

        public final Subject getSubject() {
            return this.subject;
        }

        public final String getToken() {
            return this.token;
        }

        public final boolean isConfigured() {
            return this.isConfigured;
        }

        public final void setConfigured(boolean z) {
            this.isConfigured = z;
        }

        public final void setInvitationToken(String str) {
            this.invitationToken = str;
        }

        public final void setObserver(Observer observer) {
            this.observer = observer;
        }

        public final void setState(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.state = str;
        }

        public final void setSubject(Subject subject) {
            this.subject = subject;
        }

        public final void setToken(String str) {
            this.token = str;
        }
    }

    /* compiled from: DistressModel.kt */
    /* loaded from: classes3.dex */
    public interface OnChangeListener {
        void onChanged();

        void onMissingObserver();
    }

    /* compiled from: DistressModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[WalkMeHomeState.values().length];
            try {
                r0[WalkMeHomeState.Pending.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[WalkMeHomeState.Idle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[WalkMeHomeState.Active.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public /* synthetic */ DistressModel(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final Data getDistressData() {
        return (Data) this.distressData$delegate.getValue();
    }

    public static final DistressModel getInstance(Context context) {
        return Companion.getInstance(context);
    }

    public final Data load() {
        String string = this.sharedPreferences.getString(MODEL, null);
        if (string != null) {
            Object fromJson = new Gson().fromJson(string, (Class<Object>) Data.class);
            Intrinsics.checkNotNull(fromJson);
            return (Data) fromJson;
        }
        Data data = new Data();
        SharedPreferences sharedPreferences = this.sharedPreferences;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(MODEL, new Gson().toJson(data));
        edit.apply();
        return data;
    }

    public static final void saveRunnable$lambda$0(DistressModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.save(this$0.getDistressData());
    }

    private final void setDirty() {
        this.handler.post(this.saveRunnable);
    }

    public final void addOnChangeListener(OnChangeListener onChangeListener) {
        if (onChangeListener != null && !this.onChangeListeners.contains(onChangeListener)) {
            this.onChangeListeners.add(onChangeListener);
        }
    }

    public final boolean canStartDistress() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[getState().ordinal()];
        if (r0 == 1 || r0 == 2 || r0 == 3) {
            return true;
        }
        return false;
    }

    public final boolean canStartWalk() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[getState().ordinal()];
        if (r0 == 1 || r0 == 2) {
            return true;
        }
        return false;
    }

    public final String getInvitationToken() {
        return getDistressData().getInvitationToken();
    }

    public final Observer getObserver() {
        return getDistressData().getObserver();
    }

    public final WalkMeHomeState getState() {
        return WalkMeHomeState.Companion.fromString(getDistressData().getState());
    }

    public final Subject getSubject() {
        return getDistressData().getSubject();
    }

    public final String getToken() {
        return getDistressData().getToken();
    }

    public final void invalidate() {
        notifyChanged();
    }

    public final boolean isActive() {
        boolean z;
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new WalkMeHomeState[]{WalkMeHomeState.Active, WalkMeHomeState.Distress, WalkMeHomeState.Pending});
        if ((listOf instanceof Collection) && listOf.isEmpty()) {
            return false;
        }
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            if (((WalkMeHomeState) it.next()) == getState()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean isConfigured() {
        return getDistressData().isConfigured();
    }

    public final boolean isSetUp() {
        if ((canStartDistress() || WalkMeHomeState.Distress == getState()) && !isWaitingForInviteResponse()) {
            return true;
        }
        return false;
    }

    public final boolean isWaitingForInviteResponse() {
        if (getDistressData().getObserver() == null && getDistressData().isConfigured()) {
            return true;
        }
        return false;
    }

    public final void notifyChanged() {
        Iterator<T> it = this.onChangeListeners.iterator();
        while (it.hasNext()) {
            ((OnChangeListener) it.next()).onChanged();
        }
    }

    public final void notifyMissingObserver() {
        Iterator<T> it = this.onChangeListeners.iterator();
        while (it.hasNext()) {
            ((OnChangeListener) it.next()).onMissingObserver();
        }
    }

    public final void removeOnChangeListener(OnChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onChangeListeners.remove(listener);
    }

    public final void save() {
        setDirty();
        notifyChanged();
    }

    public final void setConfigured(boolean z) {
        getDistressData().setConfigured(z);
        setDirty();
    }

    public final void setInvitationToken(String str) {
        getDistressData().setInvitationToken(str);
        setDirty();
    }

    public final void setObserver(Observer observer) {
        getDistressData().setObserver(observer);
        setDirty();
    }

    public final void setState(WalkMeHomeState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        getDistressData().setState(state.string);
        setDirty();
    }

    public final void setSubject(Subject subject) {
        getDistressData().setSubject(subject);
        setDirty();
    }

    public final void setToken(String str) {
        getDistressData().setToken(str);
        setDirty();
    }

    private DistressModel(Context context) {
        this.handler = new Handler(Looper.getMainLooper());
        this.sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, 0);
        this.distressData$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Data>() { // from class: com.animaconnected.secondo.behaviour.distress.model.DistressModel$distressData$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DistressModel.Data invoke() {
                DistressModel.Data load;
                load = DistressModel.this.load();
                return load;
            }
        });
        this.onChangeListeners = new CopyOnWriteArrayList();
        this.saveRunnable = new DistressModel$$ExternalSyntheticLambda0(0, this);
    }

    private final void save(Data data) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(MODEL, new Gson().toJson(data));
        edit.apply();
        notifyChanged();
    }
}
