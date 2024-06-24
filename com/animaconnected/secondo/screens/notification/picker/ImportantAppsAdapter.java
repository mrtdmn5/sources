package com.animaconnected.secondo.screens.notification.picker;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.secondo.screens.notification.picker.ImportantAppViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ImportantAppsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ImportantAppsAdapterListener mImportantAppsAdapterListener;
    protected final ArrayList<AppInfo> mApps = new ArrayList<>();
    private final ImportantAppViewHolder.OnListItemClickedListener mOnListItemClicked = new ImportantAppViewHolder.OnListItemClickedListener() { // from class: com.animaconnected.secondo.screens.notification.picker.ImportantAppsAdapter$$ExternalSyntheticLambda0
        @Override // com.animaconnected.secondo.screens.notification.picker.ImportantAppViewHolder.OnListItemClickedListener
        public final void onListItemClicked(AppInfo appInfo) {
            ImportantAppsAdapter.this.lambda$new$0(appInfo);
        }
    };

    /* loaded from: classes3.dex */
    public interface ImportantAppsAdapterListener {
        void onListItemClicked(AppInfo appInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(AppInfo appInfo) {
        this.mImportantAppsAdapterListener.onListItemClicked(appInfo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mApps.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int r3) {
        ((ImportantAppViewHolder) viewHolder).bind(this.mApps.get(r3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int r2) {
        return ImportantAppViewHolder.newInstance(viewGroup, this.mOnListItemClicked);
    }

    public void setData(List<AppInfo> list) {
        this.mApps.addAll(list);
        notifyDataSetChanged();
    }

    public void setImportantAppsAdapterListener(ImportantAppsAdapterListener importantAppsAdapterListener) {
        this.mImportantAppsAdapterListener = importantAppsAdapterListener;
    }
}
