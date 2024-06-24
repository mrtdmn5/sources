package com.animaconnected.secondo.screens.notification.magicword;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.remotecrash.RemoteCrashProvider$$ExternalSyntheticLambda0;
import com.animaconnected.secondo.screens.notification.NotificationDetailsFragment;
import com.animaconnected.secondo.screens.notification.magicword.MagicWordProvider;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class MagicWordFragment extends NotificationDetailsFragment implements MagicWordProvider.MagicWordProviderListener {
    private final InputMethodManager mInputMethodManager = (InputMethodManager) KronabyApplication.getContext().getSystemService("input_method");
    private MagicWordAdapter mMagicWordAdapter;
    private RecyclerView mRecyclerView;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreateView$0(int r1) {
        MagicWordProvider.getInstance().removeKeyWord(r1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreateView$1(EditText editText, TextView textView, int r4, KeyEvent keyEvent) {
        if (r4 != 6) {
            return false;
        }
        String trim = editText.getText().toString().trim();
        if (trim.length() != 0) {
            KeyWord keyWord = new KeyWord();
            keyWord.keyword = trim;
            MagicWordProvider.getInstance().addKeyWord(keyWord);
        }
        editText.setText("");
        this.mInputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "MagicWord";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_magic_word, viewGroup, false);
        initView(inflate);
        this.mRecyclerView = (RecyclerView) inflate.findViewById(R.id.magic_word_recycler_view);
        MagicWordAdapter magicWordAdapter = new MagicWordAdapter();
        this.mMagicWordAdapter = magicWordAdapter;
        magicWordAdapter.setKeyWords(MagicWordProvider.getInstance().getAllKeyWords());
        this.mMagicWordAdapter.setClickedListener(new RemoteCrashProvider$$ExternalSyntheticLambda0());
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mRecyclerView.setAdapter(this.mMagicWordAdapter);
        final EditText editText = (EditText) inflate.findViewById(R.id.add_keyword_edit_text);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.animaconnected.secondo.screens.notification.magicword.MagicWordFragment$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int r4, KeyEvent keyEvent) {
                boolean lambda$onCreateView$1;
                lambda$onCreateView$1 = MagicWordFragment.this.lambda$onCreateView$1(editText, textView, r4, keyEvent);
                return lambda$onCreateView$1;
            }
        });
        return inflate;
    }

    @Override // com.animaconnected.secondo.screens.notification.magicword.MagicWordProvider.MagicWordProviderListener
    public void onKeyWordAdded(int r3) {
        this.mMagicWordAdapter.onKeyWordAdded(r3, MagicWordProvider.getInstance().getAllKeyWords());
        this.mRecyclerView.scrollToPosition(0);
    }

    @Override // com.animaconnected.secondo.screens.notification.magicword.MagicWordProvider.MagicWordProviderListener
    public void onKeyWordRemoved(int r3) {
        this.mMagicWordAdapter.onKeyWordRemoved(r3, MagicWordProvider.getInstance().getAllKeyWords());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        MagicWordProvider.getInstance().unregisterMagicWordProviderListener(this);
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MagicWordProvider.getInstance().registerMagicWordProviderListener(this);
    }
}
