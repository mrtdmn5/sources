package com.animaconnected.secondo.screens.debugsettings;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.animaconnected.watch.display.AndroidKanvas;
import com.animaconnected.watch.display.AndroidPaint;
import com.animaconnected.watch.display.emulator.EmulatorDisplay;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugDisplayView.kt */
/* loaded from: classes3.dex */
public final class DebugDisplayView extends View {
    public static final int $stable = 8;
    public EmulatorDisplay emulatorDisplay;
    private float heightScale;
    private AndroidKanvas kanvas;
    private TextPaint linePaint;
    private int pixelHeight;
    private int pixelWidth;
    private float textHeight;
    private TextPaint textPaint;
    private float textWidth;
    private float widthScale;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugDisplayView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pixelWidth = 1;
        this.pixelHeight = 1;
        this.widthScale = 2.0f;
        this.heightScale = 2.0f;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.kanvas = new AndroidKanvas(context2);
        init();
    }

    private final void init() {
        TextPaint textPaint = new TextPaint();
        textPaint.setFlags(textPaint.getFlags() & 1);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setTextSize(10.0f);
        textPaint.setColor(-1);
        textPaint.setTypeface(ResourcesCompat.getFont(getContext(), R.font.inter_regular));
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAlpha(255);
        this.textPaint = textPaint;
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setColor(-1);
        textPaint2.setStyle(Paint.Style.STROKE);
        textPaint2.setAlpha(255);
        this.linePaint = textPaint2;
        invalidateTextPaintAndMeasurements();
        AndroidKanvas androidKanvas = this.kanvas;
        TextPaint textPaint3 = this.linePaint;
        if (textPaint3 != null) {
            AndroidPaint androidPaint = new AndroidPaint(textPaint3);
            TextPaint textPaint4 = this.textPaint;
            if (textPaint4 != null) {
                setEmulatorDisplay(new EmulatorDisplay(androidKanvas, androidPaint, new AndroidPaint(textPaint4), new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDisplayView$init$3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DebugDisplayView.this.invalidate();
                    }
                }));
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("textPaint");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("linePaint");
        throw null;
    }

    private final void invalidateTextPaintAndMeasurements() {
        TextPaint textPaint = this.textPaint;
        if (textPaint != null) {
            textPaint.setColor(-1);
            this.textWidth = textPaint.measureText("test");
            this.textHeight = textPaint.getFontMetrics().bottom;
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
        throw null;
    }

    public final EmulatorDisplay getEmulatorDisplay() {
        EmulatorDisplay emulatorDisplay = this.emulatorDisplay;
        if (emulatorDisplay != null) {
            return emulatorDisplay;
        }
        Intrinsics.throwUninitializedPropertyAccessException("emulatorDisplay");
        throw null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.kanvas.setNativeCanvas(canvas);
        float f = this.widthScale;
        float f2 = this.heightScale;
        int save = canvas.save();
        canvas.scale(f, f2, 0.0f, 0.0f);
        try {
            getEmulatorDisplay().draw();
        } finally {
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.widthScale = getMeasuredWidth() / this.pixelWidth;
        this.heightScale = getMeasuredHeight() / this.pixelHeight;
    }

    public final void setEmulatorDisplay(EmulatorDisplay emulatorDisplay) {
        Intrinsics.checkNotNullParameter(emulatorDisplay, "<set-?>");
        this.emulatorDisplay = emulatorDisplay;
    }

    public final void setPixelSize(int r1, int r2) {
        this.pixelWidth = r1;
        this.pixelHeight = r2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugDisplayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.pixelWidth = 1;
        this.pixelHeight = 1;
        this.widthScale = 2.0f;
        this.heightScale = 2.0f;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.kanvas = new AndroidKanvas(context2);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugDisplayView(Context context, AttributeSet attrs, int r4) {
        super(context, attrs, r4);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.pixelWidth = 1;
        this.pixelHeight = 1;
        this.widthScale = 2.0f;
        this.heightScale = 2.0f;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.kanvas = new AndroidKanvas(context2);
        init();
    }
}
