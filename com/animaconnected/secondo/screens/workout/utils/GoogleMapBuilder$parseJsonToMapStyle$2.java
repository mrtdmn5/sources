package com.animaconnected.secondo.screens.workout.utils;

import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.notification.model.Contact;
import com.animaconnected.secondo.screens.workout.utils.GoogleMapBuilder;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: GoogleMapsGenerator.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.utils.GoogleMapBuilder$parseJsonToMapStyle$2", f = "GoogleMapsGenerator.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class GoogleMapBuilder$parseJsonToMapStyle$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;
    final /* synthetic */ GoogleMapBuilder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleMapBuilder$parseJsonToMapStyle$2(GoogleMapBuilder googleMapBuilder, Continuation<? super GoogleMapBuilder$parseJsonToMapStyle$2> continuation) {
        super(2, continuation);
        this.this$0 = googleMapBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleMapBuilder$parseJsonToMapStyle$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BufferedReader bufferedReader;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                InputStream openRawResource = KronabyApplication.Companion.getContext().getResources().openRawResource(this.this$0.getResIdMapStyle());
                Intrinsics.checkNotNullExpressionValue(openRawResource, "openRawResource(...)");
                Reader inputStreamReader = new InputStreamReader(openRawResource, Charsets.UTF_8);
                if (inputStreamReader instanceof BufferedReader) {
                    bufferedReader = (BufferedReader) inputStreamReader;
                } else {
                    bufferedReader = new BufferedReader(inputStreamReader, DfuBaseService.ERROR_REMOTE_MASK);
                }
                try {
                    String readText = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    Json.Default r0 = Json.Default;
                    r0.getClass();
                    return CollectionsKt___CollectionsKt.joinToString$default((List) r0.decodeFromString(new ArrayListSerializer(GoogleMapBuilder.MapStyle.Companion.serializer()), readText), Contact.PHONE_NUMBERS_DELIMITER, null, null, new Function1<GoogleMapBuilder.MapStyle, CharSequence>() { // from class: com.animaconnected.secondo.screens.workout.utils.GoogleMapBuilder$parseJsonToMapStyle$2.1
                        @Override // kotlin.jvm.functions.Function1
                        public final CharSequence invoke(GoogleMapBuilder.MapStyle mapStyle) {
                            String str;
                            Intrinsics.checkNotNullParameter(mapStyle, "mapStyle");
                            StringBuilder sb = new StringBuilder("style=");
                            String featureType = mapStyle.getFeatureType();
                            if (featureType != null) {
                                sb.append("feature:" + featureType + '|');
                            }
                            String elementType = mapStyle.getElementType();
                            if (elementType != null) {
                                sb.append("element:" + elementType + '|');
                            }
                            List<GoogleMapBuilder.Styler> stylers = mapStyle.getStylers();
                            ArrayList arrayList = new ArrayList();
                            for (GoogleMapBuilder.Styler styler : stylers) {
                                if (styler.getColor() != null) {
                                    String substring = styler.getColor().substring(1);
                                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                    str = "color:0x".concat(substring);
                                } else if (styler.getVisibility() != null) {
                                    str = "visibility:" + styler.getVisibility();
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                    arrayList.add(str);
                                }
                            }
                            sb.append(CollectionsKt___CollectionsKt.joinToString$default(arrayList, "|", null, null, null, 62));
                            String sb2 = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                            return sb2;
                        }
                    }, 30);
                } finally {
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((GoogleMapBuilder$parseJsonToMapStyle$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
