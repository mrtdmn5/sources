package com.animaconnected.secondo.screens.debugsettings;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.watch.WatchProvider;
import com.google.common.collect.Hashing;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeviceLogsFragment.kt */
@SuppressLint({"SetTextI18n"})
/* loaded from: classes3.dex */
public final class DeviceLogsFragment extends BaseFragment {
    private int bytesReceived;
    private boolean err;
    private ScrollView logScroll;
    private TextView logTextView;
    private int mParts;
    private int partsReceived;
    private TextView readBytesText;
    private TextView readPartText;
    private Button sendLogButton;
    private boolean uartDumpStarted;
    private Date uartDumpStartedTime;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "DeviceLogsFragment";
    private WatchProvider watchProvider = ProviderFactory.getWatch();
    private StringBuilder logStrBuf = new StringBuilder();

    /* compiled from: DeviceLogsFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment$1", f = "DeviceLogsFragment.kt", l = {41}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (!DeviceLogsFragment.this.uartDumpStarted) {
                    DeviceLogsFragment deviceLogsFragment = DeviceLogsFragment.this;
                    this.label = 1;
                    if (deviceLogsFragment.startUartDump(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            }
            DeviceLogsFragment.this.update();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: DeviceLogsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DeviceLogsFragment newInstance() {
            return new DeviceLogsFragment();
        }

        private Companion() {
        }
    }

    public DeviceLogsFragment() {
        LifecycleCoroutineScopeImpl lifecycleScope = Hashing.getLifecycleScope(this);
        BuildersKt.launch$default(lifecycleScope, null, null, new LifecycleCoroutineScope$launchWhenCreated$1(lifecycleScope, new AnonymousClass1(null), null), 3);
    }

    private final String header() {
        Locale locale = Locale.ROOT;
        Date date = this.uartDumpStartedTime;
        String format = String.format(locale, "dump_uart log %tFT%tT%tz", Arrays.copyOf(new Object[]{date, date, date}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final String headerAndLog() {
        return StringsKt__IndentKt.trimIndent("\n            " + header() + ":\n            " + ((Object) this.logStrBuf) + "\n            ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$lambda$0(DeviceLogsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendLog();
    }

    private final void sendLog() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", header());
        intent.putExtra("android.intent.extra.TEXT", headerAndLog());
        startActivity(Intent.createChooser(intent, "Send dump_uart log"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object startUartDump(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment$startUartDump$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment$startUartDump$1 r0 = (com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment$startUartDump$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment$startUartDump$1 r0 = new com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment$startUartDump$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment r0 = (com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L2b
            goto L5e
        L2b:
            r5 = move-exception
            goto L6a
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            r4.uartDumpStarted = r3
            java.util.Date r5 = new java.util.Date
            r5.<init>()
            r4.uartDumpStartedTime = r5
            com.animaconnected.watch.WatchProvider r5 = r4.watchProvider     // Catch: java.lang.Exception -> L68
            com.animaconnected.watch.Watch r5 = r5.getWatch()     // Catch: java.lang.Exception -> L68
            com.animaconnected.watch.device.WatchIODebug r5 = r5.getDebugIo()     // Catch: java.lang.Exception -> L68
            if (r5 == 0) goto L5d
            com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment$$ExternalSyntheticLambda1 r2 = new com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L68
            r2.<init>()     // Catch: java.lang.Exception -> L68
            r0.L$0 = r4     // Catch: java.lang.Exception -> L68
            r0.label = r3     // Catch: java.lang.Exception -> L68
            java.lang.Object r5 = r5.readDumpUart(r2, r0)     // Catch: java.lang.Exception -> L68
            if (r5 != r1) goto L5d
            return r1
        L5d:
            r0 = r4
        L5e:
            java.lang.String r5 = com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment.TAG     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = r0.headerAndLog()     // Catch: java.lang.Exception -> L2b
            android.util.Log.i(r5, r1)     // Catch: java.lang.Exception -> L2b
            goto L80
        L68:
            r5 = move-exception
            r0 = r4
        L6a:
            r0.err = r3
            java.lang.String r1 = com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment.TAG
            java.lang.String r2 = "WatchDeviceInterface.readDumpUart() failed"
            android.util.Log.w(r1, r2, r5)
            java.lang.StringBuilder r0 = r0.logStrBuf
            r1 = 10
            r0.append(r1)
            r0.append(r1)
            r0.append(r5)
        L80:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment.startUartDump(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startUartDump$lambda$2(DeviceLogsFragment this$0, String str, int r3, int r4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.logStrBuf.append(str);
        this$0.mParts = r4;
        this$0.partsReceived++;
        this$0.bytesReceived += r3;
        this$0.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void update() {
        if (!isResumed()) {
            return;
        }
        TextView textView = this.logTextView;
        if (textView != null) {
            textView.setText(this.logStrBuf.toString());
            ScrollView scrollView = this.logScroll;
            if (scrollView != null) {
                scrollView.post(new Runnable() { // from class: com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeviceLogsFragment.update$lambda$3(DeviceLogsFragment.this);
                    }
                });
                if (this.err) {
                    TextView textView2 = this.readPartText;
                    if (textView2 != null) {
                        textView2.setText("Read error!");
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("readPartText");
                        throw null;
                    }
                } else if (this.uartDumpStarted && this.partsReceived == 0) {
                    TextView textView3 = this.readPartText;
                    if (textView3 != null) {
                        textView3.setText("Reading...");
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("readPartText");
                        throw null;
                    }
                } else {
                    int r0 = this.partsReceived;
                    if (r0 > 0) {
                        TextView textView4 = this.readPartText;
                        if (textView4 != null) {
                            String format = String.format(Locale.ROOT, "Read %d / %d", Arrays.copyOf(new Object[]{Integer.valueOf(r0), Integer.valueOf(this.mParts)}, 2));
                            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                            textView4.setText(format);
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("readPartText");
                            throw null;
                        }
                    }
                }
                TextView textView5 = this.readBytesText;
                if (textView5 != null) {
                    String format2 = String.format(Locale.ROOT, "%d bytes", Arrays.copyOf(new Object[]{Integer.valueOf(this.bytesReceived)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    textView5.setText(format2);
                    if (this.partsReceived > 0 || this.err) {
                        Button button = this.sendLogButton;
                        if (button != null) {
                            button.setEnabled(true);
                            return;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("sendLogButton");
                            throw null;
                        }
                    }
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("readBytesText");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("logScroll");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logTextView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void update$lambda$3(DeviceLogsFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ScrollView scrollView = this$0.logScroll;
        if (scrollView != null) {
            scrollView.fullScroll(R.styleable.AppTheme_statusTopStripeSetup);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("logScroll");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(com.kronaby.watch.app.R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "DeviceLogs";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(com.kronaby.watch.app.R.layout.fragment_devicelogs, viewGroup, false);
        View findViewById = inflate.findViewById(com.kronaby.watch.app.R.id.devicelogs_scroll);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.logScroll = (ScrollView) findViewById;
        View findViewById2 = inflate.findViewById(com.kronaby.watch.app.R.id.devicelogs_log_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.logTextView = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(com.kronaby.watch.app.R.id.devicelogs_read_part_text);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.readPartText = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(com.kronaby.watch.app.R.id.devicelogs_read_bytes_text);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.readBytesText = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(com.kronaby.watch.app.R.id.devicelogs_send_log_button);
        ((Button) findViewById5).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.debugsettings.DeviceLogsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeviceLogsFragment.onCreateView$lambda$1$lambda$0(DeviceLogsFragment.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById5, "apply(...)");
        this.sendLogButton = (Button) findViewById5;
        return inflate;
    }
}
