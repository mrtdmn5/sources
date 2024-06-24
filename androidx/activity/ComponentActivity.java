package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandleAttacher;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateHandlesProvider;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory$Companion$ApplicationKeyImpl;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final ContextAwareHelper mContextAwareHelper;
    private ViewModelProvider.Factory mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final FullyDrawnReporter mFullyDrawnReporter;
    private final LifecycleRegistry mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<Consumer<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> mOnTrimMemoryListeners;
    private final ReportFullyDrawnExecutor mReportFullyDrawnExecutor;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    /* renamed from: androidx.activity.ComponentActivity$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e) {
                if (TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                } else {
                    throw e;
                }
            }
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends ActivityResultRegistry {

        /* renamed from: androidx.activity.ComponentActivity$2$1 */
        /* loaded from: classes.dex */
        public final class AnonymousClass1 implements Runnable {
            public final /* synthetic */ int val$requestCode;
            public final /* synthetic */ ActivityResultContract.SynchronousResult val$synchronousResult;

            public AnonymousClass1(int r2, ActivityResultContract.SynchronousResult synchronousResult) {
                r2 = r2;
                r3 = synchronousResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                ActivityResultCallback<O> activityResultCallback;
                T t = r3.value;
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                String str = (String) anonymousClass2.mRcToKey.get(Integer.valueOf(r2));
                if (str != null) {
                    ActivityResultRegistry.CallbackAndContract callbackAndContract = (ActivityResultRegistry.CallbackAndContract) anonymousClass2.mKeyToCallback.get(str);
                    if (callbackAndContract != null && (activityResultCallback = callbackAndContract.mCallback) != 0) {
                        if (anonymousClass2.mLaunchedKeys.remove(str)) {
                            activityResultCallback.onActivityResult(t);
                        }
                    } else {
                        anonymousClass2.mPendingResults.remove(str);
                        anonymousClass2.mParsedPendingResults.put(str, t);
                    }
                }
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$2$2 */
        /* loaded from: classes.dex */
        public final class RunnableC00002 implements Runnable {
            public final /* synthetic */ IntentSender.SendIntentException val$e;
            public final /* synthetic */ int val$requestCode;

            public RunnableC00002(int r2, IntentSender.SendIntentException sendIntentException) {
                r2 = r2;
                r3 = sendIntentException;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AnonymousClass2.this.dispatchResult(r2, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", r3));
            }
        }

        public AnonymousClass2() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.activity.result.ActivityResultRegistry
        public final void onLaunch(int r9, ActivityResultContract activityResultContract, Object obj) {
            Bundle bundle;
            String[] strArr;
            ComponentActivity componentActivity = ComponentActivity.this;
            ActivityResultContract.SynchronousResult synchronousResult = activityResultContract.getSynchronousResult(componentActivity, obj);
            if (synchronousResult != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.ComponentActivity.2.1
                    public final /* synthetic */ int val$requestCode;
                    public final /* synthetic */ ActivityResultContract.SynchronousResult val$synchronousResult;

                    public AnonymousClass1(int r92, ActivityResultContract.SynchronousResult synchronousResult2) {
                        r2 = r92;
                        r3 = synchronousResult2;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public final void run() {
                        ActivityResultCallback<O> activityResultCallback;
                        T t = r3.value;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        String str = (String) anonymousClass2.mRcToKey.get(Integer.valueOf(r2));
                        if (str != null) {
                            ActivityResultRegistry.CallbackAndContract callbackAndContract = (ActivityResultRegistry.CallbackAndContract) anonymousClass2.mKeyToCallback.get(str);
                            if (callbackAndContract != null && (activityResultCallback = callbackAndContract.mCallback) != 0) {
                                if (anonymousClass2.mLaunchedKeys.remove(str)) {
                                    activityResultCallback.onActivityResult(t);
                                }
                            } else {
                                anonymousClass2.mPendingResults.remove(str);
                                anonymousClass2.mParsedPendingResults.put(str, t);
                            }
                        }
                    }
                });
                return;
            }
            Intent createIntent = activityResultContract.createIntent(componentActivity, obj);
            if (createIntent.getExtras() != null && createIntent.getExtras().getClassLoader() == null) {
                createIntent.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (createIntent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = createIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                createIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else {
                bundle = null;
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(createIntent.getAction())) {
                String[] stringArrayExtra = createIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                int r1 = ActivityCompat.$r8$clinit;
                HashSet hashSet = new HashSet();
                for (int r2 = 0; r2 < stringArrayExtra.length; r2++) {
                    if (!TextUtils.isEmpty(stringArrayExtra[r2])) {
                        if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(stringArrayExtra[r2], "android.permission.POST_NOTIFICATIONS")) {
                            hashSet.add(Integer.valueOf(r2));
                        }
                    } else {
                        throw new IllegalArgumentException(ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
                    }
                }
                int size = hashSet.size();
                if (size > 0) {
                    strArr = new String[stringArrayExtra.length - size];
                } else {
                    strArr = stringArrayExtra;
                }
                if (size > 0) {
                    if (size != stringArrayExtra.length) {
                        int r22 = 0;
                        for (int r11 = 0; r11 < stringArrayExtra.length; r11++) {
                            if (!hashSet.contains(Integer.valueOf(r11))) {
                                strArr[r22] = stringArrayExtra[r11];
                                r22++;
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (componentActivity instanceof ActivityCompat.RequestPermissionsRequestCodeValidator) {
                    ((ActivityCompat.RequestPermissionsRequestCodeValidator) componentActivity).validateRequestPermissionsRequestCode(r92);
                }
                ActivityCompat.Api23Impl.requestPermissions(componentActivity, stringArrayExtra, r92);
                return;
            }
            if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(createIntent.getAction())) {
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) createIntent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    IntentSender intentSender = intentSenderRequest.intentSender;
                    Intent intent = intentSenderRequest.fillInIntent;
                    int r4 = intentSenderRequest.flagsMask;
                    int r5 = intentSenderRequest.flagsValues;
                    int r10 = ActivityCompat.$r8$clinit;
                    ActivityCompat.Api16Impl.startIntentSenderForResult(componentActivity, intentSender, r92, intent, r4, r5, 0, bundle);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.ComponentActivity.2.2
                        public final /* synthetic */ IntentSender.SendIntentException val$e;
                        public final /* synthetic */ int val$requestCode;

                        public RunnableC00002(int r92, IntentSender.SendIntentException e2) {
                            r2 = r92;
                            r3 = e2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass2.this.dispatchResult(r2, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", r3));
                        }
                    });
                    return;
                }
            }
            int r112 = ActivityCompat.$r8$clinit;
            ActivityCompat.Api16Impl.startActivityForResult(componentActivity, createIntent, r92, bundle);
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$3 */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements LifecycleEventObserver {
        public AnonymousClass3() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            View view;
            if (event == Lifecycle.Event.ON_STOP) {
                Window window = ComponentActivity.this.getWindow();
                if (window != null) {
                    view = window.peekDecorView();
                } else {
                    view = null;
                }
                if (view != null) {
                    view.cancelPendingInputEvents();
                }
            }
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$4 */
    /* loaded from: classes.dex */
    public class AnonymousClass4 implements LifecycleEventObserver {
        public AnonymousClass4() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                ComponentActivity.this.mContextAwareHelper.context = null;
                if (!ComponentActivity.this.isChangingConfigurations()) {
                    ComponentActivity.this.getViewModelStore().clear();
                }
            }
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$5 */
    /* loaded from: classes.dex */
    public class AnonymousClass5 implements LifecycleEventObserver {
        public AnonymousClass5() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            ComponentActivity componentActivity = ComponentActivity.this;
            componentActivity.ensureViewModelStore();
            componentActivity.getLifecycle().removeObserver(this);
        }
    }

    /* loaded from: classes.dex */
    public static class Api33Impl {
        public static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    /* loaded from: classes.dex */
    public static final class NonConfigurationInstances {
        public Object custom;
        public ViewModelStore viewModelStore;
    }

    /* loaded from: classes.dex */
    public interface ReportFullyDrawnExecutor extends Executor {
        void viewCreated(View view);
    }

    /* loaded from: classes.dex */
    public class ReportFullyDrawnExecutorApi16Impl implements ReportFullyDrawnExecutor, ViewTreeObserver.OnDrawListener, Runnable {
        public final long mEndWatchTimeMillis = SystemClock.uptimeMillis() + 10000;
        public boolean mOnDrawScheduled = false;
        public Runnable mRunnable;

        public ReportFullyDrawnExecutorApi16Impl() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.mRunnable = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (this.mOnDrawScheduled) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    decorView.invalidate();
                    return;
                } else {
                    decorView.postInvalidate();
                    return;
                }
            }
            decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.ComponentActivity$ReportFullyDrawnExecutorApi16Impl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentActivity.ReportFullyDrawnExecutorApi16Impl reportFullyDrawnExecutorApi16Impl = ComponentActivity.ReportFullyDrawnExecutorApi16Impl.this;
                    Runnable runnable2 = reportFullyDrawnExecutorApi16Impl.mRunnable;
                    if (runnable2 != null) {
                        runnable2.run();
                        reportFullyDrawnExecutorApi16Impl.mRunnable = null;
                    }
                }
            });
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            boolean z;
            Runnable runnable = this.mRunnable;
            if (runnable != null) {
                runnable.run();
                this.mRunnable = null;
                FullyDrawnReporter fullyDrawnReporter = ComponentActivity.this.mFullyDrawnReporter;
                synchronized (fullyDrawnReporter.lock) {
                    z = fullyDrawnReporter.reportedFullyDrawn;
                }
                if (z) {
                    this.mOnDrawScheduled = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            if (SystemClock.uptimeMillis() > this.mEndWatchTimeMillis) {
                this.mOnDrawScheduled = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public final void viewCreated(View view) {
            if (!this.mOnDrawScheduled) {
                this.mOnDrawScheduled = true;
                view.getViewTreeObserver().addOnDrawListener(this);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.activity.ComponentActivity$$ExternalSyntheticLambda1] */
    public ComponentActivity() {
        this.mContextAwareHelper = new ContextAwareHelper();
        this.mMenuHostHelper = new MenuHostHelper(new Runnable() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ComponentActivity.this.invalidateMenu();
            }
        });
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController savedStateRegistryController = new SavedStateRegistryController(this);
        this.mSavedStateRegistryController = savedStateRegistryController;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.ComponentActivity.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ComponentActivity.super.onBackPressed();
                } catch (IllegalStateException e) {
                    if (TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    } else {
                        throw e;
                    }
                }
            }
        });
        ReportFullyDrawnExecutor createFullyDrawnExecutor = createFullyDrawnExecutor();
        this.mReportFullyDrawnExecutor = createFullyDrawnExecutor;
        this.mFullyDrawnReporter = new FullyDrawnReporter(createFullyDrawnExecutor, new Function0() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit lambda$new$0;
                lambda$new$0 = ComponentActivity.this.lambda$new$0();
                return lambda$new$0;
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new ActivityResultRegistry() { // from class: androidx.activity.ComponentActivity.2

            /* renamed from: androidx.activity.ComponentActivity$2$1 */
            /* loaded from: classes.dex */
            public final class AnonymousClass1 implements Runnable {
                public final /* synthetic */ int val$requestCode;
                public final /* synthetic */ ActivityResultContract.SynchronousResult val$synchronousResult;

                public AnonymousClass1(int r92, ActivityResultContract.SynchronousResult synchronousResult2) {
                    r2 = r92;
                    r3 = synchronousResult2;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    ActivityResultCallback<O> activityResultCallback;
                    T t = r3.value;
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    String str = (String) anonymousClass2.mRcToKey.get(Integer.valueOf(r2));
                    if (str != null) {
                        ActivityResultRegistry.CallbackAndContract callbackAndContract = (ActivityResultRegistry.CallbackAndContract) anonymousClass2.mKeyToCallback.get(str);
                        if (callbackAndContract != null && (activityResultCallback = callbackAndContract.mCallback) != 0) {
                            if (anonymousClass2.mLaunchedKeys.remove(str)) {
                                activityResultCallback.onActivityResult(t);
                            }
                        } else {
                            anonymousClass2.mPendingResults.remove(str);
                            anonymousClass2.mParsedPendingResults.put(str, t);
                        }
                    }
                }
            }

            /* renamed from: androidx.activity.ComponentActivity$2$2 */
            /* loaded from: classes.dex */
            public final class RunnableC00002 implements Runnable {
                public final /* synthetic */ IntentSender.SendIntentException val$e;
                public final /* synthetic */ int val$requestCode;

                public RunnableC00002(int r92, IntentSender.SendIntentException e2) {
                    r2 = r92;
                    r3 = e2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass2.this.dispatchResult(r2, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", r3));
                }
            }

            public AnonymousClass2() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.activity.result.ActivityResultRegistry
            public final void onLaunch(int r92, ActivityResultContract activityResultContract, Object obj) {
                Bundle bundle;
                String[] strArr;
                ComponentActivity componentActivity = ComponentActivity.this;
                ActivityResultContract.SynchronousResult synchronousResult2 = activityResultContract.getSynchronousResult(componentActivity, obj);
                if (synchronousResult2 != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.ComponentActivity.2.1
                        public final /* synthetic */ int val$requestCode;
                        public final /* synthetic */ ActivityResultContract.SynchronousResult val$synchronousResult;

                        public AnonymousClass1(int r922, ActivityResultContract.SynchronousResult synchronousResult22) {
                            r2 = r922;
                            r3 = synchronousResult22;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public final void run() {
                            ActivityResultCallback<O> activityResultCallback;
                            T t = r3.value;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            String str = (String) anonymousClass2.mRcToKey.get(Integer.valueOf(r2));
                            if (str != null) {
                                ActivityResultRegistry.CallbackAndContract callbackAndContract = (ActivityResultRegistry.CallbackAndContract) anonymousClass2.mKeyToCallback.get(str);
                                if (callbackAndContract != null && (activityResultCallback = callbackAndContract.mCallback) != 0) {
                                    if (anonymousClass2.mLaunchedKeys.remove(str)) {
                                        activityResultCallback.onActivityResult(t);
                                    }
                                } else {
                                    anonymousClass2.mPendingResults.remove(str);
                                    anonymousClass2.mParsedPendingResults.put(str, t);
                                }
                            }
                        }
                    });
                    return;
                }
                Intent createIntent = activityResultContract.createIntent(componentActivity, obj);
                if (createIntent.getExtras() != null && createIntent.getExtras().getClassLoader() == null) {
                    createIntent.setExtrasClassLoader(componentActivity.getClassLoader());
                }
                if (createIntent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                    Bundle bundleExtra = createIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    createIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    bundle = bundleExtra;
                } else {
                    bundle = null;
                }
                if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(createIntent.getAction())) {
                    String[] stringArrayExtra = createIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    if (stringArrayExtra == null) {
                        stringArrayExtra = new String[0];
                    }
                    int r1 = ActivityCompat.$r8$clinit;
                    HashSet hashSet = new HashSet();
                    for (int r2 = 0; r2 < stringArrayExtra.length; r2++) {
                        if (!TextUtils.isEmpty(stringArrayExtra[r2])) {
                            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(stringArrayExtra[r2], "android.permission.POST_NOTIFICATIONS")) {
                                hashSet.add(Integer.valueOf(r2));
                            }
                        } else {
                            throw new IllegalArgumentException(ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
                        }
                    }
                    int size = hashSet.size();
                    if (size > 0) {
                        strArr = new String[stringArrayExtra.length - size];
                    } else {
                        strArr = stringArrayExtra;
                    }
                    if (size > 0) {
                        if (size != stringArrayExtra.length) {
                            int r22 = 0;
                            for (int r11 = 0; r11 < stringArrayExtra.length; r11++) {
                                if (!hashSet.contains(Integer.valueOf(r11))) {
                                    strArr[r22] = stringArrayExtra[r11];
                                    r22++;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    if (componentActivity instanceof ActivityCompat.RequestPermissionsRequestCodeValidator) {
                        ((ActivityCompat.RequestPermissionsRequestCodeValidator) componentActivity).validateRequestPermissionsRequestCode(r922);
                    }
                    ActivityCompat.Api23Impl.requestPermissions(componentActivity, stringArrayExtra, r922);
                    return;
                }
                if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(createIntent.getAction())) {
                    IntentSenderRequest intentSenderRequest = (IntentSenderRequest) createIntent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                    try {
                        IntentSender intentSender = intentSenderRequest.intentSender;
                        Intent intent = intentSenderRequest.fillInIntent;
                        int r4 = intentSenderRequest.flagsMask;
                        int r5 = intentSenderRequest.flagsValues;
                        int r10 = ActivityCompat.$r8$clinit;
                        ActivityCompat.Api16Impl.startIntentSenderForResult(componentActivity, intentSender, r922, intent, r4, r5, 0, bundle);
                        return;
                    } catch (IntentSender.SendIntentException e2) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.ComponentActivity.2.2
                            public final /* synthetic */ IntentSender.SendIntentException val$e;
                            public final /* synthetic */ int val$requestCode;

                            public RunnableC00002(int r922, IntentSender.SendIntentException e22) {
                                r2 = r922;
                                r3 = e22;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                AnonymousClass2.this.dispatchResult(r2, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", r3));
                            }
                        });
                        return;
                    }
                }
                int r112 = ActivityCompat.$r8$clinit;
                ActivityCompat.Api16Impl.startActivityForResult(componentActivity, createIntent, r922, bundle);
            }
        };
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() != null) {
            getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.3
                public AnonymousClass3() {
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    View view;
                    if (event == Lifecycle.Event.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        if (window != null) {
                            view = window.peekDecorView();
                        } else {
                            view = null;
                        }
                        if (view != null) {
                            view.cancelPendingInputEvents();
                        }
                    }
                }
            });
            getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.4
                public AnonymousClass4() {
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        ComponentActivity.this.mContextAwareHelper.context = null;
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.getViewModelStore().clear();
                        }
                    }
                }
            });
            getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.5
                public AnonymousClass5() {
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    ComponentActivity componentActivity = ComponentActivity.this;
                    componentActivity.ensureViewModelStore();
                    componentActivity.getLifecycle().removeObserver(this);
                }
            });
            savedStateRegistryController.performAttach();
            Lifecycle.State currentState = getLifecycle().getCurrentState();
            if (currentState == Lifecycle.State.INITIALIZED || currentState == Lifecycle.State.CREATED) {
                if (getSavedStateRegistry().getSavedStateProvider() == null) {
                    SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(getSavedStateRegistry(), this);
                    getSavedStateRegistry().registerSavedStateProvider("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
                    getLifecycle().addObserver(new SavedStateHandleAttacher(savedStateHandlesProvider));
                }
                getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda2
                    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
                    public final Bundle saveState() {
                        Bundle lambda$new$1;
                        lambda$new$1 = ComponentActivity.this.lambda$new$1();
                        return lambda$new$1;
                    }
                });
                addOnContextAvailableListener(new OnContextAvailableListener() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda3
                    @Override // androidx.activity.contextaware.OnContextAvailableListener
                    public final void onContextAvailable(Context context) {
                        ComponentActivity.this.lambda$new$2(context);
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    private ReportFullyDrawnExecutor createFullyDrawnExecutor() {
        return new ReportFullyDrawnExecutorApi16Impl();
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullParameter(decorView, "<this>");
        decorView.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView2 = getWindow().getDecorView();
        Intrinsics.checkNotNullParameter(decorView2, "<this>");
        decorView2.setTag(R.id.report_drawn, this);
    }

    public /* synthetic */ Unit lambda$new$0() {
        reportFullyDrawn();
        return null;
    }

    public Bundle lambda$new$1() {
        Bundle bundle = new Bundle();
        ActivityResultRegistry activityResultRegistry = this.mActivityResultRegistry;
        activityResultRegistry.getClass();
        HashMap hashMap = activityResultRegistry.mKeyToRc;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(hashMap.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(hashMap.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(activityResultRegistry.mLaunchedKeys));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) activityResultRegistry.mPendingResults.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", activityResultRegistry.mRandom);
        return bundle;
    }

    public void lambda$new$2(Context context) {
        Bundle consumeRestoredStateForKey = getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (consumeRestoredStateForKey != null) {
            ActivityResultRegistry activityResultRegistry = this.mActivityResultRegistry;
            activityResultRegistry.getClass();
            ArrayList<Integer> integerArrayList = consumeRestoredStateForKey.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = consumeRestoredStateForKey.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                activityResultRegistry.mLaunchedKeys = consumeRestoredStateForKey.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                activityResultRegistry.mRandom = (Random) consumeRestoredStateForKey.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                Bundle bundle = consumeRestoredStateForKey.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                Bundle bundle2 = activityResultRegistry.mPendingResults;
                bundle2.putAll(bundle);
                for (int r10 = 0; r10 < stringArrayList.size(); r10++) {
                    String str = stringArrayList.get(r10);
                    HashMap hashMap = activityResultRegistry.mKeyToRc;
                    boolean containsKey = hashMap.containsKey(str);
                    HashMap hashMap2 = activityResultRegistry.mRcToKey;
                    if (containsKey) {
                        Integer num = (Integer) hashMap.remove(str);
                        if (!bundle2.containsKey(str)) {
                            hashMap2.remove(num);
                        }
                    }
                    int intValue = integerArrayList.get(r10).intValue();
                    String str2 = stringArrayList.get(r10);
                    hashMap2.put(Integer.valueOf(intValue), str2);
                    hashMap.put(str2, Integer.valueOf(intValue));
                }
            }
        }
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(MenuProvider menuProvider) {
        MenuHostHelper menuHostHelper = this.mMenuHostHelper;
        menuHostHelper.mMenuProviders.add(menuProvider);
        menuHostHelper.mOnInvalidateMenuCallback.run();
    }

    public final void addOnConfigurationChangedListener(Consumer<Configuration> consumer) {
        this.mOnConfigurationChangedListeners.add(consumer);
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener listener) {
        ContextAwareHelper contextAwareHelper = this.mContextAwareHelper;
        contextAwareHelper.getClass();
        Intrinsics.checkNotNullParameter(listener, "listener");
        Context context = contextAwareHelper.context;
        if (context != null) {
            listener.onContextAvailable(context);
        }
        contextAwareHelper.listeners.add(listener);
    }

    public final void addOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> consumer) {
        this.mOnMultiWindowModeChangedListeners.add(consumer);
    }

    public final void addOnNewIntentListener(Consumer<Intent> consumer) {
        this.mOnNewIntentListeners.add(consumer);
    }

    public final void addOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.mOnPictureInPictureModeChangedListeners.add(consumer);
    }

    public final void addOnTrimMemoryListener(Consumer<Integer> consumer) {
        this.mOnTrimMemoryListeners.add(consumer);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this.mViewModelStore = nonConfigurationInstances.viewModelStore;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
        }
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        Application application = getApplication();
        LinkedHashMap linkedHashMap = mutableCreationExtras.map;
        if (application != null) {
            linkedHashMap.put(ViewModelProvider$AndroidViewModelFactory$Companion$ApplicationKeyImpl.INSTANCE, getApplication());
        }
        linkedHashMap.put(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        linkedHashMap.put(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            linkedHashMap.put(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getIntent().getExtras());
        }
        return mutableCreationExtras;
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Bundle bundle;
        if (this.mDefaultFactory == null) {
            Application application = getApplication();
            if (getIntent() != null) {
                bundle = getIntent().getExtras();
            } else {
                bundle = null;
            }
            this.mDefaultFactory = new SavedStateViewModelFactory(application, this, bundle);
        }
        return this.mDefaultFactory;
    }

    public FullyDrawnReporter getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.custom;
        }
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.savedStateRegistry;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int r2, int r3, Intent intent) {
        if (!this.mActivityResultRegistry.dispatchResult(r2, r3, intent)) {
            super.onActivityResult(r2, r3, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<Consumer<Configuration>> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:            if (androidx.core.os.BuildCompat.isAtLeastPreReleaseCodename("Tiramisu", r3) != false) goto L37;     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r3) {
        /*
            r2 = this;
            androidx.savedstate.SavedStateRegistryController r0 = r2.mSavedStateRegistryController
            r0.performRestore(r3)
            androidx.activity.contextaware.ContextAwareHelper r0 = r2.mContextAwareHelper
            r0.getClass()
            r0.context = r2
            java.util.concurrent.CopyOnWriteArraySet r0 = r0.listeners
            java.util.Iterator r0 = r0.iterator()
        L12:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L22
            java.lang.Object r1 = r0.next()
            androidx.activity.contextaware.OnContextAvailableListener r1 = (androidx.activity.contextaware.OnContextAvailableListener) r1
            r1.onContextAvailable(r2)
            goto L12
        L22:
            super.onCreate(r3)
            int r3 = androidx.lifecycle.ReportFragment.$r8$clinit
            androidx.lifecycle.ReportFragment.Companion.injectIfNeededIn(r2)
            int r3 = androidx.core.os.BuildCompat.$r8$clinit
            int r3 = android.os.Build.VERSION.SDK_INT
            r0 = 33
            if (r3 >= r0) goto L48
            r0 = 32
            if (r3 < r0) goto L46
            java.lang.String r3 = android.os.Build.VERSION.CODENAME
            java.lang.String r0 = "CODENAME"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            java.lang.String r0 = "Tiramisu"
            boolean r3 = androidx.core.os.BuildCompat.isAtLeastPreReleaseCodename(r0, r3)
            if (r3 == 0) goto L46
            goto L48
        L46:
            r3 = 0
            goto L49
        L48:
            r3 = 1
        L49:
            if (r3 == 0) goto L5e
            androidx.activity.OnBackPressedDispatcher r3 = r2.mOnBackPressedDispatcher
            android.window.OnBackInvokedDispatcher r0 = androidx.activity.ComponentActivity.Api33Impl.getOnBackInvokedDispatcher(r2)
            r3.getClass()
            java.lang.String r1 = "invoker"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r3.invokedDispatcher = r0
            r3.updateBackInvokedCallbackState$activity_release()
        L5e:
            int r3 = r2.mContentLayoutId
            if (r3 == 0) goto L65
            r2.setContentView(r3)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.ComponentActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r1, Menu menu) {
        if (r1 == 0) {
            super.onCreatePanelMenu(r1, menu);
            MenuHostHelper menuHostHelper = this.mMenuHostHelper;
            getMenuInflater();
            Iterator<MenuProvider> it = menuHostHelper.mMenuProviders.iterator();
            while (it.hasNext()) {
                it.next().onCreateMenu();
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r3, MenuItem menuItem) {
        if (super.onMenuItemSelected(r3, menuItem)) {
            return true;
        }
        if (r3 != 0) {
            return false;
        }
        Iterator<MenuProvider> it = this.mMenuHostHelper.mMenuProviders.iterator();
        while (it.hasNext()) {
            if (it.next().onMenuItemSelected()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<Consumer<MultiWindowModeChangedInfo>> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new MultiWindowModeChangedInfo());
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<Consumer<Intent>> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r3, Menu menu) {
        Iterator<MenuProvider> it = this.mMenuHostHelper.mMenuProviders.iterator();
        while (it.hasNext()) {
            it.next().getClass();
        }
        super.onPanelClosed(r3, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<Consumer<PictureInPictureModeChangedInfo>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new PictureInPictureModeChangedInfo());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r1, View view, Menu menu) {
        if (r1 == 0) {
            super.onPreparePanel(r1, view, menu);
            Iterator<MenuProvider> it = this.mMenuHostHelper.mMenuProviders.iterator();
            while (it.hasNext()) {
                it.next().getClass();
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int r4, String[] strArr, int[] r6) {
        if (!this.mActivityResultRegistry.dispatchResult(r4, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", r6))) {
            super.onRequestPermissionsResult(r4, strArr, r6);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore == null && (nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nonConfigurationInstances.viewModelStore;
        }
        if (viewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances2 = new NonConfigurationInstances();
        nonConfigurationInstances2.custom = onRetainCustomNonConfigurationInstance;
        nonConfigurationInstances2.viewModelStore = viewModelStore;
        return nonConfigurationInstances2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            ((LifecycleRegistry) lifecycle).setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int r4) {
        super.onTrimMemory(r4);
        Iterator<Consumer<Integer>> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(r4));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.context;
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback<O> activityResultCallback) {
        return activityResultRegistry.register("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, activityResultContract, activityResultCallback);
    }

    public void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.removeMenuProvider(menuProvider);
    }

    public final void removeOnConfigurationChangedListener(Consumer<Configuration> consumer) {
        this.mOnConfigurationChangedListeners.remove(consumer);
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener listener) {
        ContextAwareHelper contextAwareHelper = this.mContextAwareHelper;
        contextAwareHelper.getClass();
        Intrinsics.checkNotNullParameter(listener, "listener");
        contextAwareHelper.listeners.remove(listener);
    }

    public final void removeOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> consumer) {
        this.mOnMultiWindowModeChangedListeners.remove(consumer);
    }

    public final void removeOnNewIntentListener(Consumer<Intent> consumer) {
        this.mOnNewIntentListeners.remove(consumer);
    }

    public final void removeOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.mOnPictureInPictureModeChangedListeners.remove(consumer);
    }

    public final void removeOnTrimMemoryListener(Consumer<Integer> consumer) {
        this.mOnTrimMemoryListeners.remove(consumer);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (Trace.isEnabled()) {
                android.os.Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            FullyDrawnReporter fullyDrawnReporter = this.mFullyDrawnReporter;
            synchronized (fullyDrawnReporter.lock) {
                fullyDrawnReporter.reportedFullyDrawn = true;
                Iterator it = fullyDrawnReporter.onReportCallbacks.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                fullyDrawnReporter.onReportCallbacks.clear();
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            android.os.Trace.endSection();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int r3) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(r3);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int r2) {
        super.startActivityForResult(intent, r2);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int r2, Intent intent, int r4, int r5, int r6) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, r2, intent, r4, r5, r6);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int r2, Bundle bundle) {
        super.startActivityForResult(intent, r2, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int r2, Intent intent, int r4, int r5, int r6, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, r2, intent, r4, r5, r6, bundle);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<Consumer<MultiWindowModeChangedInfo>> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new MultiWindowModeChangedInfo(0));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<Consumer<PictureInPictureModeChangedInfo>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new PictureInPictureModeChangedInfo(0));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        return registerForActivityResult(activityResultContract, this.mActivityResultRegistry, activityResultCallback);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(view);
    }

    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        this.mMenuHostHelper.addMenuProvider(menuProvider, lifecycleOwner);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        this.mMenuHostHelper.addMenuProvider(menuProvider, lifecycleOwner, state);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    public ComponentActivity(int r1) {
        this();
        this.mContentLayoutId = r1;
    }
}
