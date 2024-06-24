package com.animaconnected.secondo.screens.settings;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.google.common.base.Strings;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: OpenSourceLicenses.kt */
/* loaded from: classes3.dex */
public final class OpenSourceLicenses extends ComposeFragment {
    private final Json json = JsonKt.Json$default(new Function1<JsonBuilder, Unit>() { // from class: com.animaconnected.secondo.screens.settings.OpenSourceLicenses$json$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.ignoreUnknownKeys = true;
        }
    });
    private final String name = "Licence";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: OpenSourceLicenses.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OpenSourceLicenses newInstance() {
            return new OpenSourceLicenses();
        }

        private Companion() {
        }
    }

    private final List<Project> readLicensesFromJSON(Context context, String str) {
        BufferedReader bufferedReader;
        try {
            Json json = this.json;
            InputStream open = context.getAssets().open(str);
            Intrinsics.checkNotNullExpressionValue(open, "open(...)");
            Reader inputStreamReader = new InputStreamReader(open, Charsets.UTF_8);
            if (inputStreamReader instanceof BufferedReader) {
                bufferedReader = (BufferedReader) inputStreamReader;
            } else {
                bufferedReader = new BufferedReader(inputStreamReader, DfuBaseService.ERROR_REMOTE_MASK);
            }
            try {
                String readText = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                json.getClass();
                return (List) json.decodeFromString(new ArrayListSerializer(Project.Companion.serializer()), readText);
            } finally {
            }
        } catch (Exception unused) {
            return EmptyList.INSTANCE;
        }
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r10) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1972655720);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.LocalContext);
        startRestartGroup.startReplaceableGroup(1939723591);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = readLicensesFromJSON(context, "license-texts/licenseReleaseReport.json");
            startRestartGroup.updateValue(nextSlot);
        }
        List list = (List) nextSlot;
        Object m = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, 1939723727);
        if (m == composer$Companion$Empty$1) {
            m = readLicensesFromJSON(context, "license-texts/licenseReleaseReportFirmware.json");
            startRestartGroup.updateValue(m);
        }
        startRestartGroup.end(false);
        OpenSourceLicensesKt.ThirdPartyLicenses(BackgroundKt.m21backgroundbw27NRU(Modifier.Companion.$$INSTANCE, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m164getBackground0d7_KjU(), RectangleShapeKt.RectangleShape), list, (List) m, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.OpenSourceLicenses$ComposeContent$1
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
                OpenSourceLicenses.this.getMainController().goBack();
            }
        }, startRestartGroup, 576, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.OpenSourceLicenses$ComposeContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r3) {
                    OpenSourceLicenses.this.ComposeContent(composer2, Strings.updateChangedFlags(r10 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }
}
