package androidx.compose.ui.platform.actionmodecallback;

import android.R;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: TextActionModeCallback.android.kt */
/* loaded from: classes.dex */
public enum MenuItemOption {
    Copy(0),
    Paste(1),
    Cut(2),
    SelectAll(3);

    private final int id;
    private final int order;

    /* compiled from: TextActionModeCallback.android.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[MenuItemOption.values().length];
            try {
                r0[MenuItemOption.Copy.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[MenuItemOption.Paste.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[MenuItemOption.Cut.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[MenuItemOption.SelectAll.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    MenuItemOption(int r3) {
        this.id = r3;
        this.order = r3;
    }

    public final int getId() {
        return this.id;
    }

    public final int getOrder() {
        return this.order;
    }

    public final int getTitleResource() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 3) {
                    if (r0 == 4) {
                        return R.string.selectAll;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return R.string.cut;
            }
            return R.string.paste;
        }
        return R.string.copy;
    }
}
