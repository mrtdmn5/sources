package com.animaconnected.secondo.screens.apps;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchAppViewHolder.kt */
/* loaded from: classes3.dex */
public abstract class AppsListViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppsListViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    public abstract void bindType(AppsListItem appsListItem);
}
