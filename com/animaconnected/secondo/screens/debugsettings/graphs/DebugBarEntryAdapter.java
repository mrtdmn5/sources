package com.animaconnected.secondo.screens.debugsettings.graphs;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.watch.graphs.BarEntry;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: DebugBarEntryAdapter.kt */
/* loaded from: classes3.dex */
public final class DebugBarEntryAdapter extends RecyclerView.Adapter<ChartDataHolder> {
    public static final int $stable = 8;
    private List<BarEntry> data = new ArrayList();
    public Function2<? super Integer, ? super Integer, Unit> itemClicked;

    /* compiled from: DebugBarEntryAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class ChartDataHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final TextView index;
        private final EditText value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChartDataHolder(View view, final Function2<? super Integer, ? super Integer, Unit> callback) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(callback, "callback");
            View findViewById = view.findViewById(R.id.et_item_debug_steps_chart_data);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            EditText editText = (EditText) findViewById;
            this.value = editText;
            View findViewById2 = view.findViewById(R.id.tv_item_debug_steps_chart_data);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.index = (TextView) findViewById2;
            editText.addTextChangedListener(new TextWatcher() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugBarEntryAdapter$ChartDataHolder$special$$inlined$doAfterTextChanged$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    boolean z;
                    if (editable != null) {
                        if (editable.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z && !StringsKt__StringsJVMKt.isBlank(editable)) {
                            Function2.this.invoke(Integer.valueOf(Integer.parseInt(editable.toString())), Integer.valueOf(this.getBindingAdapterPosition()));
                            return;
                        }
                    }
                    Function2.this.invoke(0, Integer.valueOf(this.getBindingAdapterPosition()));
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                }
            });
        }

        public final TextView getIndex() {
            return this.index;
        }

        public final EditText getValue() {
            return this.value;
        }
    }

    public final Function2<Integer, Integer, Unit> getItemClicked() {
        Function2 function2 = this.itemClicked;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemClicked");
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final void setData(List<BarEntry> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        notifyDataSetChanged();
    }

    public final void setItemClicked(Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.itemClicked = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"SetTextI18n"})
    public void onBindViewHolder(ChartDataHolder holder, int r4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getValue().setText(String.valueOf(this.data.get(r4).getValue()));
        holder.getIndex().setText("Bar " + (r4 + 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ChartDataHolder onCreateViewHolder(ViewGroup parent, int r5) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_debug_bar_chart_data, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ChartDataHolder(inflate, new Function2<Integer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.graphs.DebugBarEntryAdapter$onCreateViewHolder$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int r2, int r3) {
                DebugBarEntryAdapter.this.getItemClicked().invoke(Integer.valueOf(r2), Integer.valueOf(r3));
            }
        });
    }
}
