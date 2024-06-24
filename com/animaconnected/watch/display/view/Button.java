package com.animaconnected.watch.display.view;

import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.HidCommand;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayDefinition.kt */
/* loaded from: classes3.dex */
public final class Button extends Element {
    private Integer animation;
    private final int color;
    private List<? extends HidCommand> hidCommands;
    private Integer navCommand;
    private Function0<Unit> onClick;
    private CanvasPaint paint;
    private final String text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Button(String text, int r10) {
        super(0, 0, 0, 0, 15, null);
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.color = r10;
        this.paint = DisplayDefinitionKt.createColorPaint$default(r10, false, 0.0f, 6, null);
        this.onClick = new Function0<Unit>() { // from class: com.animaconnected.watch.display.view.Button$onClick$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
    }

    public final Integer getAnimation() {
        return this.animation;
    }

    public final int getColor() {
        return this.color;
    }

    public final List<HidCommand> getHidCommands() {
        return this.hidCommands;
    }

    public final Integer getNavCommand() {
        return this.navCommand;
    }

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    public final CanvasPaint getPaint() {
        return this.paint;
    }

    public final String getText() {
        return this.text;
    }

    public final void setAnimation(Integer num) {
        this.animation = num;
    }

    public final void setHidCommands(List<? extends HidCommand> list) {
        this.hidCommands = list;
    }

    public final void setNavCommand(Integer num) {
        this.navCommand = num;
    }

    public final void setOnClick(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onClick = function0;
    }

    public final void setPaint(CanvasPaint canvasPaint) {
        Intrinsics.checkNotNullParameter(canvasPaint, "<set-?>");
        this.paint = canvasPaint;
    }

    public /* synthetic */ Button(String str, int r2, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (r3 & 2) != 0 ? -1 : r2);
    }
}
