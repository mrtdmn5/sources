package com.animaconnected.secondo.screens.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.secondo.utils.debugging.Debugging;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.BuildersKt;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: SettingsDebuggingFragment.kt */
/* loaded from: classes3.dex */
public final class SettingsDebuggingFragment extends BaseFragment {
    private EditText additionalInfo;
    private TextView collectingDataText;
    private ProgressBar progressbar;
    private Button sendBtn;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String deviceLogsFile = "deviceLogs.log";
    private final String additionalInfoFile = "info.txt";
    private final String zipFile = "logs.zip";
    private UartState uartState = UartState.Collecting;
    private final String name = "SettingsDebugging";

    /* compiled from: SettingsDebuggingFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SettingsDebuggingFragment newInstance() {
            return new SettingsDebuggingFragment();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SettingsDebuggingFragment.kt */
    /* loaded from: classes3.dex */
    public static final class UartState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UartState[] $VALUES;
        public static final UartState Collecting = new UartState("Collecting", 0);
        public static final UartState Success = new UartState("Success", 1);
        public static final UartState Failed = new UartState("Failed", 2);

        private static final /* synthetic */ UartState[] $values() {
            return new UartState[]{Collecting, Success, Failed};
        }

        static {
            UartState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private UartState(String str, int r2) {
        }

        public static EnumEntries<UartState> getEntries() {
            return $ENTRIES;
        }

        public static UartState valueOf(String str) {
            return (UartState) Enum.valueOf(UartState.class, str);
        }

        public static UartState[] values() {
            return (UartState[]) $VALUES.clone();
        }
    }

    /* compiled from: SettingsDebuggingFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[UartState.values().length];
            try {
                r0[UartState.Collecting.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[UartState.Success.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[UartState.Failed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    private final File loadFile(Function0<? extends File> function0) {
        try {
            File invoke = function0.invoke();
            if (!invoke.exists()) {
                return null;
            }
            return invoke;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void send() {
        Debugging debugging = Debugging.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String str = this.additionalInfoFile;
        EditText editText = this.additionalInfo;
        File file = null;
        if (editText != null) {
            File saveFile = debugging.saveFile(requireContext, str, editText.getText().toString());
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            List<File> appLogfiles = debugging.getAppLogfiles(requireContext2);
            File loadFile = loadFile(new Function0<File>() { // from class: com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment$send$watchDb$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final File invoke() {
                    Debugging debugging2 = Debugging.INSTANCE;
                    Context requireContext3 = SettingsDebuggingFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
                    return debugging2.getDatabaseFile(requireContext3, "watch_database");
                }
            });
            File loadFile2 = loadFile(new Function0<File>() { // from class: com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment$send$alarmDB$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final File invoke() {
                    Debugging debugging2 = Debugging.INSTANCE;
                    Context requireContext3 = SettingsDebuggingFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
                    return debugging2.getDatabaseFile(requireContext3, "alarms.db");
                }
            });
            if (this.uartState == UartState.Success) {
                file = loadFile(new Function0<File>() { // from class: com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment$send$deviceLogs$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final File invoke() {
                        String str2;
                        Debugging debugging2 = Debugging.INSTANCE;
                        Context requireContext3 = SettingsDebuggingFragment.this.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
                        str2 = SettingsDebuggingFragment.this.deviceLogsFile;
                        return debugging2.getFile(requireContext3, str2);
                    }
                });
            }
            Context requireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
            String str2 = this.zipFile;
            SpreadBuilder spreadBuilder = new SpreadBuilder(5);
            ArrayList<Object> arrayList = spreadBuilder.list;
            arrayList.add(saveFile);
            spreadBuilder.addSpread(appLogfiles.toArray(new File[0]));
            arrayList.add(loadFile);
            arrayList.add(loadFile2);
            arrayList.add(file);
            File createZip = debugging.createZip(requireContext3, str2, (File[]) arrayList.toArray(new File[arrayList.size()]));
            if (createZip == null) {
                return;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType(DfuBaseService.MIME_TYPE_ZIP);
            intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(requireContext(), createZip));
            Context context = getContext();
            if (context != null) {
                context.startActivity(Intent.createChooser(intent, "Send logs"));
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("additionalInfo");
        throw null;
    }

    @SuppressLint({"SetTextI18n"})
    private final void setUartState(UartState uartState, String str) {
        this.uartState = uartState;
        int r6 = WhenMappings.$EnumSwitchMapping$0[uartState.ordinal()];
        if (r6 != 1) {
            if (r6 != 2) {
                if (r6 == 3) {
                    TextView textView = this.collectingDataText;
                    if (textView != null) {
                        textView.setText(getText(R.string.settings_debugging_failed));
                        ProgressBar progressBar = this.progressbar;
                        if (progressBar != null) {
                            ViewKt.gone(progressBar);
                            Button button = this.sendBtn;
                            if (button != null) {
                                button.setEnabled(true);
                                return;
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
                                throw null;
                            }
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("collectingDataText");
                    throw null;
                }
                return;
            }
            TextView textView2 = this.collectingDataText;
            if (textView2 != null) {
                textView2.setText(getText(R.string.settings_debugging_success));
                ProgressBar progressBar2 = this.progressbar;
                if (progressBar2 != null) {
                    ViewKt.gone(progressBar2);
                    Button button2 = this.sendBtn;
                    if (button2 != null) {
                        button2.setEnabled(true);
                        return;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
                        throw null;
                    }
                }
                Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("collectingDataText");
            throw null;
        }
        TextView textView3 = this.collectingDataText;
        if (textView3 != null) {
            textView3.setText(((Object) getText(R.string.settings_debugging_collecting)) + ' ' + str);
            ProgressBar progressBar3 = this.progressbar;
            if (progressBar3 != null) {
                ViewKt.visible(progressBar3);
                Button button3 = this.sendBtn;
                if (button3 != null) {
                    button3.setEnabled(false);
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
                    throw null;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("progressbar");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("collectingDataText");
        throw null;
    }

    public static /* synthetic */ void setUartState$default(SettingsDebuggingFragment settingsDebuggingFragment, UartState uartState, String str, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            str = "";
        }
        settingsDebuggingFragment.setUartState(uartState, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object startUartDump(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment$startUartDump$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment$startUartDump$1 r0 = (com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment$startUartDump$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment$startUartDump$1 r0 = new com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment$startUartDump$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment r0 = (com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L6d
            goto L72
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L35:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.jvm.internal.Ref$IntRef r9 = new kotlin.jvm.internal.Ref$IntRef     // Catch: java.lang.Exception -> L6c
            r9.<init>()     // Catch: java.lang.Exception -> L6c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6c
            r2.<init>()     // Catch: java.lang.Exception -> L6c
            com.animaconnected.watch.WatchProvider r6 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()     // Catch: java.lang.Exception -> L6c
            com.animaconnected.watch.WatchManager r6 = r6.getWatchManager()     // Catch: java.lang.Exception -> L6c
            com.animaconnected.watch.Watch r6 = r6.getCurrentWatch()     // Catch: java.lang.Exception -> L6c
            com.animaconnected.watch.device.WatchIODebug r6 = r6.getDebugIo()     // Catch: java.lang.Exception -> L6c
            if (r6 != 0) goto L5c
            com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment$UartState r9 = com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment.UartState.Failed     // Catch: java.lang.Exception -> L6c
            setUartState$default(r8, r9, r5, r3, r5)     // Catch: java.lang.Exception -> L6c
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L6c
            return r9
        L5c:
            com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment$$ExternalSyntheticLambda0 r7 = new com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L6c
            r7.<init>()     // Catch: java.lang.Exception -> L6c
            r0.L$0 = r8     // Catch: java.lang.Exception -> L6c
            r0.label = r4     // Catch: java.lang.Exception -> L6c
            java.lang.Object r9 = r6.readDumpUart(r7, r0)     // Catch: java.lang.Exception -> L6c
            if (r9 != r1) goto L72
            return r1
        L6c:
            r0 = r8
        L6d:
            com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment$UartState r9 = com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment.UartState.Failed
            setUartState$default(r0, r9, r5, r3, r5)
        L72:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment.startUartDump(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startUartDump$lambda$2(StringBuilder logs, Ref$IntRef receivedParts, SettingsDebuggingFragment this$0, String str, int r4, int r5) {
        Intrinsics.checkNotNullParameter(logs, "$logs");
        Intrinsics.checkNotNullParameter(receivedParts, "$receivedParts");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        logs.append(str);
        int r3 = receivedParts.element + 1;
        receivedParts.element = r3;
        if (r3 == r5) {
            Debugging debugging = Debugging.INSTANCE;
            Context requireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            String str2 = this$0.deviceLogsFile;
            String sb = logs.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            debugging.saveFile(requireContext, str2, sb);
            setUartState$default(this$0, UartState.Success, null, 2, null);
            return;
        }
        UartState uartState = UartState.Collecting;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(receivedParts.element);
        sb2.append('/');
        sb2.append(r5);
        this$0.setUartState(uartState, sb2.toString());
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_settings_debugging, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.debugging_data_info);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.collectingDataText = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.debugging_additional_info);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.additionalInfo = (EditText) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.debugging_progressbar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.progressbar = (ProgressBar) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.debugging_send_logs);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        Button button = (Button) findViewById4;
        this.sendBtn = button;
        onClick(button, new SettingsDebuggingFragment$onCreateView$1$1(this, null));
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new SettingsDebuggingFragment$onCreateView$1$2(this, null), 3);
        return inflate;
    }
}
