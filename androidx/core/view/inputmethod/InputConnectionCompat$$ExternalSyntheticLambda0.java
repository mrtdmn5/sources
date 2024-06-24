package androidx.core.view.inputmethod;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class InputConnectionCompat$$ExternalSyntheticLambda0 implements InputConnectionCompat$OnCommitContentListener, SynchronizationGuard.CriticalSection {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ InputConnectionCompat$$ExternalSyntheticLambda0(Object obj) {
        this.f$0 = obj;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public final Object execute() {
        ((Uploader) this.f$0).clientHealthMetricsStore.resetClientMetrics();
        return null;
    }

    public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int r8, Bundle bundle) {
        ContentInfoCompat.BuilderCompat builderCompatImpl;
        View view = (View) this.f$0;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 25 && (r8 & 1) != 0) {
            try {
                inputContentInfoCompat.mImpl.requestPermission();
                Parcelable parcelable = (Parcelable) inputContentInfoCompat.mImpl.getInputContentInfo();
                if (bundle == null) {
                    bundle = new Bundle();
                } else {
                    bundle = new Bundle(bundle);
                }
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
            }
        }
        ClipDescription description = inputContentInfoCompat.mImpl.getDescription();
        InputContentInfoCompat.InputContentInfoCompatImpl inputContentInfoCompatImpl = inputContentInfoCompat.mImpl;
        ClipData clipData = new ClipData(description, new ClipData.Item(inputContentInfoCompatImpl.getContentUri()));
        if (r1 >= 31) {
            builderCompatImpl = new ContentInfoCompat.BuilderCompat31Impl(clipData, 2);
        } else {
            builderCompatImpl = new ContentInfoCompat.BuilderCompatImpl(clipData, 2);
        }
        builderCompatImpl.setLinkUri(inputContentInfoCompatImpl.getLinkUri());
        builderCompatImpl.setExtras(bundle);
        if (ViewCompat.performReceiveContent(view, builderCompatImpl.build()) == null) {
            return true;
        }
        return false;
    }
}
