package com.amplifyframework.devmenu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amplifyframework.core.R;
import com.amplifyframework.logging.LogLevel;
import java.util.Locale;

/* loaded from: classes.dex */
public final class DevMenuLogsFragment extends Fragment {
    private DeveloperMenu developerMenu;
    private TextView logsText;
    private String searchQuery;
    private MenuItem selectedLogsFilterItem;

    /* renamed from: com.amplifyframework.devmenu.DevMenuLogsFragment$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements SearchView.OnQueryTextListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            DevMenuLogsFragment.this.searchQuery = str;
            DevMenuLogsFragment.this.displayFilteredLogs();
            return true;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public void displayFilteredLogs() {
        LogLevel logLevel;
        this.logsText.setText(R.string.placeholder_logs);
        if (this.selectedLogsFilterItem.getItemId() != R.id.all_logs) {
            logLevel = LogLevel.valueOf(this.selectedLogsFilterItem.getTitle().toString().toUpperCase(Locale.US));
        } else {
            logLevel = null;
        }
        this.logsText.setText(this.developerMenu.getFilteredLogs(this.searchQuery, logLevel));
    }

    public /* synthetic */ void lambda$onCreateView$0(View view) {
        requireActivity().openContextMenu(view);
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        this.selectedLogsFilterItem = menuItem;
        displayFilteredLogs();
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        requireActivity().getMenuInflater().inflate(R.menu.dev_menu_logs_menu, contextMenu);
        if (this.selectedLogsFilterItem == null) {
            this.selectedLogsFilterItem = contextMenu.findItem(R.id.all_logs);
        }
        contextMenu.findItem(this.selectedLogsFilterItem.getItemId()).setChecked(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dev_menu_fragment_logs, viewGroup, false);
        this.developerMenu = DeveloperMenu.singletonInstance(getContext());
        TextView textView = (TextView) inflate.findViewById(R.id.logs_text);
        this.logsText = textView;
        textView.setText(this.developerMenu.getLogs());
        ((SearchView) inflate.findViewById(R.id.search_logs_field)).setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.amplifyframework.devmenu.DevMenuLogsFragment.1
            public AnonymousClass1() {
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String str) {
                DevMenuLogsFragment.this.searchQuery = str;
                DevMenuLogsFragment.this.displayFilteredLogs();
                return true;
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String str) {
                return false;
            }
        });
        Button button = (Button) inflate.findViewById(R.id.filter_logs);
        registerForContextMenu(button);
        button.setOnClickListener(new DevMenuLogsFragment$$ExternalSyntheticLambda0(this, 0));
        return inflate;
    }
}
