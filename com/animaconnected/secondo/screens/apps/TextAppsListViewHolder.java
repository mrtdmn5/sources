package com.animaconnected.secondo.screens.apps;

import android.view.View;
import android.widget.TextView;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.databinding.ItemAppsTextBinding;
import com.animaconnected.secondo.utils.ViewKt;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchAppViewHolder.kt */
/* loaded from: classes3.dex */
public final class TextAppsListViewHolder extends AppsListViewHolder {
    public static final int $stable = 8;
    private final ItemAppsTextBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TextAppsListViewHolder(com.animaconnected.secondo.databinding.ItemAppsTextBinding r3) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.widget.LinearLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0)
            r2.binding = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.apps.TextAppsListViewHolder.<init>(com.animaconnected.secondo.databinding.ItemAppsTextBinding):void");
    }

    @Override // com.animaconnected.secondo.screens.apps.AppsListViewHolder
    public void bindType(AppsListItem item) {
        boolean z;
        Intrinsics.checkNotNullParameter(item, "item");
        AppsTextListItem appsTextListItem = (AppsTextListItem) item;
        ItemAppsTextBinding itemAppsTextBinding = this.binding;
        if (getAbsoluteAdapterPosition() == 0) {
            itemAppsTextBinding.tvQuickAction.setText(KronabyApplication.Companion.getContext().getString(R.string.quick_action));
            TextView tvQuickAction = itemAppsTextBinding.tvQuickAction;
            Intrinsics.checkNotNullExpressionValue(tvQuickAction, "tvQuickAction");
            ViewKt.visible(tvQuickAction);
        } else {
            TextView tvQuickAction2 = itemAppsTextBinding.tvQuickAction;
            Intrinsics.checkNotNullExpressionValue(tvQuickAction2, "tvQuickAction");
            ViewKt.gone(tvQuickAction2);
        }
        itemAppsTextBinding.tvTitle.setText(appsTextListItem.getTitle());
        itemAppsTextBinding.tvInfo.setText(appsTextListItem.getInfo());
        CharSequence text = itemAppsTextBinding.tvInfo.getText();
        if (text != null && text.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            View divider = itemAppsTextBinding.divider;
            Intrinsics.checkNotNullExpressionValue(divider, "divider");
            ViewKt.gone(divider);
            TextView tvInfo = itemAppsTextBinding.tvInfo;
            Intrinsics.checkNotNullExpressionValue(tvInfo, "tvInfo");
            ViewKt.gone(tvInfo);
            return;
        }
        View divider2 = itemAppsTextBinding.divider;
        Intrinsics.checkNotNullExpressionValue(divider2, "divider");
        ViewKt.visible(divider2);
        TextView tvInfo2 = itemAppsTextBinding.tvInfo;
        Intrinsics.checkNotNullExpressionValue(tvInfo2, "tvInfo");
        ViewKt.visible(tvInfo2);
    }
}
