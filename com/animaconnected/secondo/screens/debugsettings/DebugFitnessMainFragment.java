package com.animaconnected.secondo.screens.debugsettings;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.watch.fitness.FitnessDatabaseImportKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.model.DriverFactoryKt;
import com.animaconnected.watch.model.SqlDriverFactory;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: DebugFitnessMainFragment.kt */
@SuppressLint({"SetTextI18n"})
/* loaded from: classes3.dex */
public final class DebugFitnessMainFragment extends BaseFragment {
    private TextView fitnessState;
    private TextView lastSessionText;
    private TextView liveData;
    private ProgressBar progressBar;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private final FitnessProvider fitnessProvider = ProviderFactory.getWatch().fitness();
    private final String name = "DebugFitnessMain";

    /* compiled from: DebugFitnessMainFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DebugFitnessMainFragment newInstance() {
            return new DebugFitnessMainFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean importDatabase(Context context, Uri uri) {
        InputStream inputStream;
        File databasePath = context.getDatabasePath("importDebug.db");
        if (databasePath == null) {
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null) {
            inputStream = contentResolver.openInputStream(uri);
        } else {
            inputStream = null;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(databasePath.getAbsolutePath());
        try {
            if (inputStream != null) {
                try {
                    ByteStreamsKt.copyTo$default(inputStream, fileOutputStream);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(inputStream, null);
                } finally {
                }
            }
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            SqlDriverFactory sqlDriverFactory = new SqlDriverFactory(requireContext);
            FitnessDatabaseImportKt.moveFitnessData(DriverFactoryKt.createWatchDatabase(sqlDriverFactory.createDebugDriver("importDebug.db"), DebugFitnessMainFragment$importDatabase$2.INSTANCE), DriverFactoryKt.createWatchDatabase(sqlDriverFactory.createDriver(), DebugFitnessMainFragment$importDatabase$3.INSTANCE));
            databasePath.delete();
            return true;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean importJson(Context context, Uri uri) {
        InputStream openInputStream;
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null && (openInputStream = contentResolver.openInputStream(uri)) != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openInputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append('\n');
                } else {
                    FitnessProvider fitnessProvider = this.fitnessProvider;
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                    fitnessProvider.debugImportFromJson(sb2);
                    return true;
                }
            }
        } else {
            return false;
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

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugFitnessMainFragment$onCreate$1(this, null), 3);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        boolean z = false;
        View inflate = inflater.inflate(R.layout.fragment_debug_fitness_main, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.progress_bar_calculating);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.progressBar = (ProgressBar) findViewById;
        View findViewById2 = inflate.findViewById(R.id.fitness_debug_state);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.fitnessState = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.fitness_debug_last_session);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.lastSessionText = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.fitness_debug_live_mode_data);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.liveData = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.fitness_debug_data_delete);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        onClick(findViewById5, new DebugFitnessMainFragment$onCreateView$1$1(this, inflate, null));
        View findViewById6 = inflate.findViewById(R.id.fitness_debug_pre_data_delete);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        onClick(findViewById6, new DebugFitnessMainFragment$onCreateView$1$2(this, inflate, null));
        View findViewById7 = inflate.findViewById(R.id.fitness_pre_process);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        onClick(findViewById7, new DebugFitnessMainFragment$onCreateView$1$3(this, inflate, null));
        View findViewById8 = inflate.findViewById(R.id.fitness_pre_process_sleep);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        onClick(findViewById8, new DebugFitnessMainFragment$onCreateView$1$4(this, null));
        View findViewById9 = inflate.findViewById(R.id.fitness_pre_process_resting_heart_rate);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        onClick(findViewById9, new DebugFitnessMainFragment$onCreateView$1$5(this, null));
        View findViewById10 = inflate.findViewById(R.id.fitness_database);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        onClick(findViewById10, new DebugFitnessMainFragment$onCreateView$1$6(this, null));
        View findViewById11 = inflate.findViewById(R.id.fitness_force_sync);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        onClick(findViewById11, new DebugFitnessMainFragment$onCreateView$1$7(inflate, this, null));
        View findViewById12 = inflate.findViewById(R.id.delete_data_on_cloud);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        onClick(findViewById12, new DebugFitnessMainFragment$onCreateView$1$8(this, inflate, null));
        View findViewById13 = inflate.findViewById(R.id.fitness_delete_local);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
        onClick(findViewById13, new DebugFitnessMainFragment$onCreateView$1$9(this, inflate, null));
        View findViewById14 = inflate.findViewById(R.id.fitness_debug_data_export);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
        onClick(findViewById14, new DebugFitnessMainFragment$onCreateView$1$10(inflate, this, null));
        Button button = (Button) inflate.findViewById(R.id.fitness_debug_data_import);
        if (Build.VERSION.SDK_INT < 33) {
            z = true;
        }
        button.setEnabled(z);
        onClick(button, new DebugFitnessMainFragment$onCreateView$1$11$1(this, button, null));
        View findViewById15 = inflate.findViewById(R.id.fitness_reset_onboarding);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(...)");
        onClick(findViewById15, new DebugFitnessMainFragment$onCreateView$1$12(this, inflate, null));
        return inflate;
    }
}
