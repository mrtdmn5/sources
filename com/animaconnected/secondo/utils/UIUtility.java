package com.animaconnected.secondo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.BehaviourFactory;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.display.AndroidGraphicsKt;
import com.animaconnected.watch.image.Mitmap;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UIUtility.kt */
/* loaded from: classes3.dex */
public final class UIUtility {
    public static final UIUtility INSTANCE = new UIUtility();
    private static final Lazy behaviourFactory$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BehaviourFactory>() { // from class: com.animaconnected.secondo.utils.UIUtility$behaviourFactory$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BehaviourFactory invoke() {
            return ProviderFactory.getBehaviourFactory();
        }
    });
    private static final Lazy behaviours$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Behaviours>() { // from class: com.animaconnected.secondo.utils.UIUtility$behaviours$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Behaviours invoke() {
            return ProviderFactory.getWatch().getBehaviours();
        }
    });
    public static final int $stable = 8;

    /* compiled from: UIUtility.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Watch.WatchState.values().length];
            try {
                r0[Watch.WatchState.Ready.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Watch.WatchState.Syncing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[Watch.WatchState.UpdateRequired.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[Watch.WatchState.Initializing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[Watch.WatchState.Initialized.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[Watch.WatchState.Disconnected.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r0[Watch.WatchState.Inactive.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    private UIUtility() {
    }

    private final SpannableString createSpannableTextWithColor(Context context, String str, int r6, int r7) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(r6, true), 0, str.length(), 0);
        Object obj = ContextCompat.sLock;
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.Api23Impl.getColor(context, r7)), 0, str.length(), 0);
        return spannableString;
    }

    private final CharSequence formatLightAndDarkText(Context context, int r6, Integer num, boolean z) {
        int r0;
        int r7;
        int r8;
        if (z) {
            r0 = R.color.textColorPrimaryLightShadowed;
        } else {
            r0 = R.color.textColorPrimaryShadowed;
        }
        String string = context.getString(r6);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        SpannableString createSpannableTextWithColor = createSpannableTextWithColor(context, string, 12, r0);
        SpannableString createSpannableTextWithColor2 = createSpannableTextWithColor(context, ": ", 12, r0);
        if (num != null) {
            r7 = num.intValue();
        } else {
            r7 = R.string.behaviour_name_empty;
        }
        String string2 = context.getString(r7);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        if (z) {
            r8 = R.color.white;
        } else {
            r8 = R.color.black;
        }
        CharSequence concat = TextUtils.concat(createSpannableTextWithColor, createSpannableTextWithColor2, createSpannableTextWithColor(context, string2, 12, r8));
        Intrinsics.checkNotNullExpressionValue(concat, "concat(...)");
        return concat;
    }

    public static final Spanned fromHtml(String str) {
        Spanned fromHtml = Html.fromHtml(str, 0);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(...)");
        return fromHtml;
    }

    private final BehaviourFactory getBehaviourFactory() {
        return (BehaviourFactory) behaviourFactory$delegate.getValue();
    }

    private final Behaviours getBehaviours() {
        return (Behaviours) behaviours$delegate.getValue();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x012c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object getFormatDeviceSettingsString(android.content.Context r10, boolean r11, kotlin.coroutines.Continuation<? super java.lang.CharSequence> r12) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.UIUtility.getFormatDeviceSettingsString(android.content.Context, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getNameOnSlot(com.animaconnected.watch.Slot r5, kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.secondo.utils.UIUtility$getNameOnSlot$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.secondo.utils.UIUtility$getNameOnSlot$1 r0 = (com.animaconnected.secondo.utils.UIUtility$getNameOnSlot$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.utils.UIUtility$getNameOnSlot$1 r0 = new com.animaconnected.secondo.utils.UIUtility$getNameOnSlot$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            com.animaconnected.secondo.utils.UIUtility r5 = (com.animaconnected.secondo.utils.UIUtility) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            com.animaconnected.watch.behaviour.Behaviours r6 = r4.getBehaviours()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.getBehaviour(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r5 = r4
        L46:
            com.animaconnected.watch.behaviour.Behaviour r6 = (com.animaconnected.watch.behaviour.Behaviour) r6
            com.animaconnected.secondo.behaviour.BehaviourFactory r5 = r5.getBehaviourFactory()
            java.lang.String r6 = r6.getType()
            com.animaconnected.secondo.behaviour.BehaviourPlugin r5 = r5.getPlugin(r6)
            if (r5 == 0) goto L5b
            int r5 = r5.getNameId()
            goto L5e
        L5b:
            r5 = 2132017683(0x7f140213, float:1.9673651E38)
        L5e:
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.UIUtility.getNameOnSlot(com.animaconnected.watch.Slot, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Mitmap loadMitmap$default(UIUtility uIUtility, int r1, Context context, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            context = KronabyApplication.Companion.getContext();
        }
        return uIUtility.loadMitmap(r1, context);
    }

    public static final void setColorIntFilter(Drawable drawable, int r2, BlendModeCompat blendMode) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        drawable.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(r2, blendMode));
    }

    public final int getTextHeight(String text, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect.height();
    }

    public final int getTextWidth(String text, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect.width() + rect.left;
    }

    public final Mitmap loadMitmap(int r2, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), r2);
        Intrinsics.checkNotNullExpressionValue(decodeResource, "decodeResource(...)");
        return AndroidGraphicsKt.toMitmap$default(decodeResource, null, 1, null);
    }
}
