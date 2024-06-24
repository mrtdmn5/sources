package com.animaconnected.secondo.behaviour.distress.detail;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class InvitationCodeLinkDialogFragment extends BottomSheetBaseDialogFragment {
    private static final String EXTRA_INVITATION_CODE = "com.animaconnected.secondo.behaviour.distress.detail.invitation_code";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialogView$0(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.kronaby_friend_app_link))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialogView$1(String str, View view) {
        ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(getText(R.string.distress_code_and_link_copy_clipboard_item_title), str));
        Toast.makeText(getContext(), getContext().getText(R.string.distress_code_and_link_copy_toast), 0).show();
    }

    public static InvitationCodeLinkDialogFragment newInstance(String str) {
        InvitationCodeLinkDialogFragment invitationCodeLinkDialogFragment = new InvitationCodeLinkDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_INVITATION_CODE, str);
        invitationCodeLinkDialogFragment.setArguments(bundle);
        return invitationCodeLinkDialogFragment;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog bottomDialog) {
        View inflate = View.inflate(getContext(), R.layout.fragment_details_distress_invitation_code_link, null);
        final String string = getArguments().getString(EXTRA_INVITATION_CODE);
        inflate.findViewById(R.id.invitation_link_description).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.distress.detail.InvitationCodeLinkDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InvitationCodeLinkDialogFragment.this.lambda$onCreateDialogView$0(view);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.invitation_code_text);
        textView.setText(string);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.distress.detail.InvitationCodeLinkDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InvitationCodeLinkDialogFragment.this.lambda$onCreateDialogView$1(string, view);
            }
        });
        return inflate;
    }
}
