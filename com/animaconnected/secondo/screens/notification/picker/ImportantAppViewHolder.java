package com.animaconnected.secondo.screens.notification.picker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class ImportantAppViewHolder extends RecyclerView.ViewHolder {
    private static final float DISABLED_ALPHA = 0.3f;
    private final ImageView mAppIcon;
    private AppInfo mAppInfo;
    private final TextView mAppName;
    private final TextView mNotInstalled;
    private final OnListItemClickedListener mOnListItemClickedListener;

    /* loaded from: classes3.dex */
    public interface OnListItemClickedListener {
        void onListItemClicked(AppInfo appInfo);
    }

    public ImportantAppViewHolder(View view, OnListItemClickedListener onListItemClickedListener) {
        super(view);
        this.mAppIcon = (ImageView) view.findViewById(R.id.app_icon);
        this.mAppName = (TextView) view.findViewById(R.id.app_name);
        this.mNotInstalled = (TextView) view.findViewById(R.id.not_installed);
        this.mOnListItemClickedListener = onListItemClickedListener;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.notification.picker.ImportantAppViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ImportantAppViewHolder.this.lambda$new$0(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        this.mOnListItemClickedListener.onListItemClicked(this.mAppInfo);
    }

    public static ImportantAppViewHolder newInstance(ViewGroup viewGroup, OnListItemClickedListener onListItemClickedListener) {
        return new ImportantAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.important_app_list_item, viewGroup, false), onListItemClickedListener);
    }

    public void bind(AppInfo appInfo) {
        this.mAppInfo = appInfo;
        this.mAppIcon.setImageDrawable(appInfo.getAppIcon());
        this.mAppName.setText(appInfo.getAppName());
        if (!appInfo.isInstalled()) {
            this.mNotInstalled.setVisibility(0);
            this.itemView.setAlpha(DISABLED_ALPHA);
        }
    }
}
