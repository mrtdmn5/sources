package androidx.compose.foundation.layout;

import android.os.Build;
import android.view.View;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;
import com.kronaby.watch.app.R;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowInsets.android.kt */
/* loaded from: classes.dex */
public final class WindowInsetsHolder {
    public static final WeakHashMap<View, WindowInsetsHolder> viewMap;
    public int accessCount;
    public final AndroidWindowInsets captionBar = Companion.access$systemInsets(4, "captionBar");
    public final ValueInsets captionBarIgnoringVisibility;
    public final boolean consumes;
    public final AndroidWindowInsets displayCutout;
    public final AndroidWindowInsets ime;
    public final ValueInsets imeAnimationSource;
    public final ValueInsets imeAnimationTarget;
    public final InsetsListener insetsListener;
    public final AndroidWindowInsets mandatorySystemGestures;
    public final AndroidWindowInsets navigationBars;
    public final ValueInsets navigationBarsIgnoringVisibility;
    public final AndroidWindowInsets statusBars;
    public final ValueInsets statusBarsIgnoringVisibility;
    public final AndroidWindowInsets systemBars;
    public final ValueInsets systemBarsIgnoringVisibility;
    public final AndroidWindowInsets systemGestures;
    public final AndroidWindowInsets tappableElement;
    public final ValueInsets tappableElementIgnoringVisibility;
    public final ValueInsets waterfall;

    /* compiled from: WindowInsets.android.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final AndroidWindowInsets access$systemInsets(int r1, String str) {
            WeakHashMap<View, WindowInsetsHolder> weakHashMap = WindowInsetsHolder.viewMap;
            return new AndroidWindowInsets(r1, str);
        }

        public static final ValueInsets access$valueInsetsIgnoringVisibility(int r2, String str) {
            WeakHashMap<View, WindowInsetsHolder> weakHashMap = WindowInsetsHolder.viewMap;
            return new ValueInsets(new InsetsValues(0, 0, 0, 0), str);
        }
    }

    static {
        new Companion();
        viewMap = new WeakHashMap<>();
    }

    public WindowInsetsHolder(View view) {
        View view2;
        Object obj;
        AndroidWindowInsets access$systemInsets = Companion.access$systemInsets(128, "displayCutout");
        this.displayCutout = access$systemInsets;
        AndroidWindowInsets access$systemInsets2 = Companion.access$systemInsets(8, "ime");
        this.ime = access$systemInsets2;
        AndroidWindowInsets access$systemInsets3 = Companion.access$systemInsets(32, "mandatorySystemGestures");
        this.mandatorySystemGestures = access$systemInsets3;
        this.navigationBars = Companion.access$systemInsets(2, "navigationBars");
        this.statusBars = Companion.access$systemInsets(1, "statusBars");
        AndroidWindowInsets access$systemInsets4 = Companion.access$systemInsets(7, "systemBars");
        this.systemBars = access$systemInsets4;
        AndroidWindowInsets access$systemInsets5 = Companion.access$systemInsets(16, "systemGestures");
        this.systemGestures = access$systemInsets5;
        AndroidWindowInsets access$systemInsets6 = Companion.access$systemInsets(64, "tappableElement");
        this.tappableElement = access$systemInsets6;
        ValueInsets valueInsets = new ValueInsets(new InsetsValues(0, 0, 0, 0), "waterfall");
        this.waterfall = valueInsets;
        new UnionInsets(new UnionInsets(new UnionInsets(access$systemInsets4, access$systemInsets2), access$systemInsets), new UnionInsets(new UnionInsets(new UnionInsets(access$systemInsets6, access$systemInsets3), access$systemInsets5), valueInsets));
        this.captionBarIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(4, "captionBarIgnoringVisibility");
        this.navigationBarsIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(2, "navigationBarsIgnoringVisibility");
        this.statusBarsIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(1, "statusBarsIgnoringVisibility");
        this.systemBarsIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(7, "systemBarsIgnoringVisibility");
        this.tappableElementIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(64, "tappableElementIgnoringVisibility");
        this.imeAnimationTarget = Companion.access$valueInsetsIgnoringVisibility(8, "imeAnimationTarget");
        this.imeAnimationSource = Companion.access$valueInsetsIgnoringVisibility(8, "imeAnimationSource");
        Object parent = view.getParent();
        if (parent instanceof View) {
            view2 = (View) parent;
        } else {
            view2 = null;
        }
        if (view2 != null) {
            obj = view2.getTag(R.id.consume_window_insets_tag);
        } else {
            obj = null;
        }
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        this.consumes = bool != null ? bool.booleanValue() : true;
        this.insetsListener = new InsetsListener(this);
    }

    public static void update$default(WindowInsetsHolder windowInsetsHolder, WindowInsetsCompat windowInsets) {
        Insets insets;
        windowInsetsHolder.getClass();
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        boolean z = false;
        windowInsetsHolder.captionBar.update$foundation_layout_release(windowInsets, 0);
        windowInsetsHolder.ime.update$foundation_layout_release(windowInsets, 0);
        windowInsetsHolder.displayCutout.update$foundation_layout_release(windowInsets, 0);
        windowInsetsHolder.navigationBars.update$foundation_layout_release(windowInsets, 0);
        windowInsetsHolder.statusBars.update$foundation_layout_release(windowInsets, 0);
        windowInsetsHolder.systemBars.update$foundation_layout_release(windowInsets, 0);
        windowInsetsHolder.systemGestures.update$foundation_layout_release(windowInsets, 0);
        windowInsetsHolder.tappableElement.update$foundation_layout_release(windowInsets, 0);
        windowInsetsHolder.mandatorySystemGestures.update$foundation_layout_release(windowInsets, 0);
        ValueInsets valueInsets = windowInsetsHolder.captionBarIgnoringVisibility;
        Insets insetsIgnoringVisibility = windowInsets.getInsetsIgnoringVisibility(4);
        Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "insets.getInsetsIgnoring…aptionBar()\n            )");
        valueInsets.value$delegate.setValue(WindowInsets_androidKt.toInsetsValues(insetsIgnoringVisibility));
        ValueInsets valueInsets2 = windowInsetsHolder.navigationBarsIgnoringVisibility;
        Insets insetsIgnoringVisibility2 = windowInsets.getInsetsIgnoringVisibility(2);
        Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility2, "insets.getInsetsIgnoring…ationBars()\n            )");
        valueInsets2.value$delegate.setValue(WindowInsets_androidKt.toInsetsValues(insetsIgnoringVisibility2));
        ValueInsets valueInsets3 = windowInsetsHolder.statusBarsIgnoringVisibility;
        Insets insetsIgnoringVisibility3 = windowInsets.getInsetsIgnoringVisibility(1);
        Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility3, "insets.getInsetsIgnoring…tatusBars()\n            )");
        valueInsets3.value$delegate.setValue(WindowInsets_androidKt.toInsetsValues(insetsIgnoringVisibility3));
        ValueInsets valueInsets4 = windowInsetsHolder.systemBarsIgnoringVisibility;
        Insets insetsIgnoringVisibility4 = windowInsets.getInsetsIgnoringVisibility(7);
        Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility4, "insets.getInsetsIgnoring…ystemBars()\n            )");
        valueInsets4.value$delegate.setValue(WindowInsets_androidKt.toInsetsValues(insetsIgnoringVisibility4));
        ValueInsets valueInsets5 = windowInsetsHolder.tappableElementIgnoringVisibility;
        Insets insetsIgnoringVisibility5 = windowInsets.getInsetsIgnoringVisibility(64);
        Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility5, "insets.getInsetsIgnoring…leElement()\n            )");
        valueInsets5.value$delegate.setValue(WindowInsets_androidKt.toInsetsValues(insetsIgnoringVisibility5));
        DisplayCutoutCompat displayCutout = windowInsets.mImpl.getDisplayCutout();
        if (displayCutout != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                insets = Insets.toCompatInsets(DisplayCutoutCompat.Api30Impl.getWaterfallInsets(displayCutout.mDisplayCutout));
            } else {
                insets = Insets.NONE;
            }
            windowInsetsHolder.waterfall.value$delegate.setValue(WindowInsets_androidKt.toInsetsValues(insets));
        }
        synchronized (SnapshotKt.lock) {
            IdentityArraySet<StateObject> identityArraySet = SnapshotKt.currentGlobalSnapshot.get().modified;
            if (identityArraySet != null) {
                if (identityArraySet.isNotEmpty()) {
                    z = true;
                }
            }
        }
        if (z) {
            SnapshotKt.advanceGlobalSnapshot(new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$advanceGlobalSnapshot$3
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(SnapshotIdSet snapshotIdSet) {
                    SnapshotIdSet it = snapshotIdSet;
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final void updateImeAnimationSource(WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(8);
        Intrinsics.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…wInsetsCompat.Type.ime())");
        this.imeAnimationSource.value$delegate.setValue(WindowInsets_androidKt.toInsetsValues(insets));
    }
}
