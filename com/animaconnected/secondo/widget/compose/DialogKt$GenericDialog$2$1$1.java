package com.animaconnected.secondo.widget.compose;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.animaconnected.secondo.databinding.DialogGenericBinding;
import com.animaconnected.secondo.utils.ViewKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Dialog.kt */
/* loaded from: classes3.dex */
public final class DialogKt$GenericDialog$2$1$1 extends Lambda implements Function1<Context, LinearLayout> {
    final /* synthetic */ String $body;
    final /* synthetic */ String $btnPrimaryText;
    final /* synthetic */ String $btnSecondaryText;
    final /* synthetic */ Function0<Unit> $onBtnPrimaryClick;
    final /* synthetic */ Function0<Unit> $onBtnSecondaryClick;
    final /* synthetic */ String $title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogKt$GenericDialog$2$1$1(String str, String str2, String str3, String str4, Function0<Unit> function0, Function0<Unit> function02) {
        super(1);
        this.$title = str;
        this.$body = str2;
        this.$btnPrimaryText = str3;
        this.$btnSecondaryText = str4;
        this.$onBtnPrimaryClick = function0;
        this.$onBtnSecondaryClick = function02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$0(Function0 onBtnPrimaryClick, View view) {
        Intrinsics.checkNotNullParameter(onBtnPrimaryClick, "$onBtnPrimaryClick");
        onBtnPrimaryClick.invoke();
    }

    @Override // kotlin.jvm.functions.Function1
    public final LinearLayout invoke(Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        DialogGenericBinding inflate = DialogGenericBinding.inflate(LayoutInflater.from(it), null, false);
        String str = this.$title;
        String str2 = this.$body;
        String str3 = this.$btnPrimaryText;
        String str4 = this.$btnSecondaryText;
        final Function0<Unit> function0 = this.$onBtnPrimaryClick;
        final Function0<Unit> function02 = this.$onBtnSecondaryClick;
        inflate.tvTitle.setText(str);
        inflate.tvBody.setText(str2);
        inflate.btnPrimary.setText(str3);
        inflate.btnPrimary.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.widget.compose.DialogKt$GenericDialog$2$1$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogKt$GenericDialog$2$1$1.invoke$lambda$2$lambda$0(Function0.this, view);
            }
        });
        if (str4.length() > 0) {
            Button btnSecondary = inflate.btnSecondary;
            Intrinsics.checkNotNullExpressionValue(btnSecondary, "btnSecondary");
            ViewKt.visible(btnSecondary);
            inflate.btnSecondary.setText(str4);
            inflate.btnSecondary.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.widget.compose.DialogKt$GenericDialog$2$1$1$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function0.this.invoke();
                }
            });
        } else {
            Button btnSecondary2 = inflate.btnSecondary;
            Intrinsics.checkNotNullExpressionValue(btnSecondary2, "btnSecondary");
            ViewKt.gone(btnSecondary2);
        }
        return inflate.getRoot();
    }
}
