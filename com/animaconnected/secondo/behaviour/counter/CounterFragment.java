package com.animaconnected.secondo.behaviour.counter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amplifyframework.devmenu.DevMenuMainFragment$$ExternalSyntheticLambda0;
import com.amplifyframework.devmenu.DevMenuMainFragment$$ExternalSyntheticLambda1;
import com.animaconnected.secondo.provider.counter.CounterChangedListener;
import com.animaconnected.secondo.provider.counter.CounterProvider;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class CounterFragment extends BaseDetailsFragment implements CounterChangedListener {
    private TextView mTextCount;

    public static /* synthetic */ void lambda$onCreateView$0(View view) {
        CounterProvider.getInstance().addCount(1);
    }

    public static /* synthetic */ void lambda$onCreateView$1(View view) {
        CounterProvider.getInstance().removeCount(1);
    }

    public /* synthetic */ void lambda$onCreateView$2(View view) {
        CounterProvider.getInstance().resetCount();
        refresh();
    }

    public static BaseDetailsFragment newInstance(Slot slot) {
        CounterFragment counterFragment = new CounterFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("slot", slot);
        bundle.putString("type", Counter.TYPE);
        counterFragment.setArguments(bundle);
        return counterFragment;
    }

    private void refresh() {
        this.mTextCount.setText(String.valueOf(CounterProvider.getInstance().getCount()));
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.provider.counter.CounterChangedListener
    public void onCounterChanged() {
        refresh();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_counter, viewGroup, false);
        this.mTextCount = (TextView) inflate.findViewById(R.id.current_count_amount_text_view);
        inflate.findViewById(R.id.btn_add_count).setOnClickListener(new DevMenuMainFragment$$ExternalSyntheticLambda0(1));
        inflate.findViewById(R.id.btn_delete_count).setOnClickListener(new DevMenuMainFragment$$ExternalSyntheticLambda1(1));
        ((Button) inflate.findViewById(R.id.btn_counter_reset)).setOnClickListener(new CounterFragment$$ExternalSyntheticLambda0(this, 0));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        CounterProvider.getInstance().unregisterCounterChangedListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        CounterProvider.getInstance().registerCounterChangedListener(this);
        refresh();
    }
}
