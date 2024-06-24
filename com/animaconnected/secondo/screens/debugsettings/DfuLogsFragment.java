package com.animaconnected.secondo.screens.debugsettings;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.dfu.dfu.utils.DfuUtilities;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.debugsettings.DfuLogsFragment;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: DfuLogsFragment.kt */
/* loaded from: classes3.dex */
public final class DfuLogsFragment extends BaseFragment {
    private final Lazy logTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.animaconnected.secondo.screens.debugsettings.DfuLogsFragment$logTextView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextView invoke() {
            View view = DfuLogsFragment.this.getView();
            View findViewById = view != null ? view.findViewById(R.id.logs_text) : null;
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            return (TextView) findViewById;
        }
    });
    private final String name = "DfuLogs";
    private boolean shouldShowTime;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DfuLogsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DfuLogsFragment newInstance() {
            return new DfuLogsFragment();
        }

        private Companion() {
        }
    }

    private final String getLogText() {
        List<String> sLogs = DfuUtilities.sLogs;
        Intrinsics.checkNotNullExpressionValue(sLogs, "sLogs");
        String str = "";
        for (String str2 : sLogs) {
            StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str);
            if (!this.shouldShowTime) {
                Intrinsics.checkNotNull(str2);
                str2 = StringsKt__StringsKt.substringAfter$default(StringsKt__StringsJVMKt.replace$default(str2, "\n", ""), ":");
            }
            str = OpaqueKey$$ExternalSyntheticOutline0.m(m, str2, '\n');
        }
        return str;
    }

    private final TextView getLogTextView() {
        return (TextView) this.logTextView$delegate.getValue();
    }

    public static final DfuLogsFragment newInstance() {
        return Companion.newInstance();
    }

    public static final void onCreateView$lambda$3$lambda$1(DfuLogsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object systemService = view.getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("simple text", this$0.getLogText()));
        Toast.makeText(view.getContext(), "Copied!", 0).show();
    }

    public static final void onCreateView$lambda$3$lambda$2(DfuLogsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.shouldShowTime = !this$0.shouldShowTime;
        this$0.getLogTextView().setText(this$0.getLogText());
    }

    public static final void onResume$lambda$4(DfuLogsFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded()) {
            this$0.getLogTextView().setText(this$0.getLogText());
        }
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
        View inflate = inflater.inflate(R.layout.fragment_dfulogs, viewGroup, false);
        inflate.findViewById(R.id.copy_log).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.debugsettings.DfuLogsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DfuLogsFragment.onCreateView$lambda$3$lambda$1(DfuLogsFragment.this, view);
            }
        });
        inflate.findViewById(R.id.hide_time).setOnClickListener(new DfuLogsFragment$$ExternalSyntheticLambda1(0, this));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getLogTextView().setText(getLogText());
        DfuUtilities.sDebugListener = new DfuUtilities.DfuDebugListener() { // from class: org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda2
            @Override // com.animaconnected.dfu.dfu.utils.DfuUtilities.DfuDebugListener
            public final void onChange() {
                DfuLogsFragment.onResume$lambda$4((DfuLogsFragment) this);
            }
        };
    }
}
