package com.amplifyframework.devmenu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amplifyframework.core.R;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;

/* loaded from: classes.dex */
public final class DevMenuFileIssueFragment extends Fragment {
    private static final String DESCRIPTION_LENGTH_ERROR = "Issue description must be at least 20 characters.";
    private static final int MIN_DESCRIPTION_LENGTH = 20;
    private static final String NEW_ISSUE_URL = "https://github.com/aws-amplify/amplify-android/issues/new";
    private DeveloperMenu developerMenu;
    private View fileIssueView;

    private void fileIssue() {
        String issueBody = getIssueBody();
        if (!issueBody.isEmpty()) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(NEW_ISSUE_URL).buildUpon().appendQueryParameter(DetailBottomDialog.keyTitle, "").appendQueryParameter("body", issueBody).build()));
        }
    }

    private String getIssueBody() {
        EditText editText = (EditText) this.fileIssueView.findViewById(R.id.issue_description);
        String obj = editText.getText().toString();
        if (obj.length() < 20) {
            editText.setError(DESCRIPTION_LENGTH_ERROR);
            return "";
        }
        return this.developerMenu.createIssueBody(obj, false);
    }

    public /* synthetic */ void lambda$onCreateView$0(View view) {
        fileIssue();
    }

    public /* synthetic */ void lambda$onCreateView$1(Context context, View view) {
        String issueBody = getIssueBody();
        if (!issueBody.isEmpty()) {
            this.developerMenu.copyToClipboard(issueBody);
            Toast.makeText(context, "Copied issue body to clipboard.", 0).show();
        }
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fileIssueView = layoutInflater.inflate(R.layout.dev_menu_fragment_file_issue, viewGroup, false);
        final Context applicationContext = requireContext().getApplicationContext();
        this.developerMenu = DeveloperMenu.singletonInstance(applicationContext);
        this.fileIssueView.findViewById(R.id.file_issue).setOnClickListener(new DevMenuFileIssueFragment$$ExternalSyntheticLambda0(this, 0));
        this.fileIssueView.findViewById(R.id.copy_issue).setOnClickListener(new View.OnClickListener() { // from class: com.amplifyframework.devmenu.DevMenuFileIssueFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DevMenuFileIssueFragment.this.lambda$onCreateView$1(applicationContext, view);
            }
        });
        return this.fileIssueView;
    }
}
