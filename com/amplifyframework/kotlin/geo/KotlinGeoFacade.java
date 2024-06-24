package com.amplifyframework.kotlin.geo;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.geo.GeoCategoryBehavior;
import com.amplifyframework.geo.GeoException;
import com.amplifyframework.geo.models.MapStyle;
import java.util.Collection;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinGeoFacade.kt */
/* loaded from: classes.dex */
public final class KotlinGeoFacade implements Geo {
    private final GeoCategoryBehavior delegate;

    public KotlinGeoFacade() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.amplifyframework.kotlin.geo.Geo
    public Object getAvailableMaps(Continuation<? super Collection<MapStyle>> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.getAvailableMaps(new Consumer() { // from class: com.amplifyframework.kotlin.geo.KotlinGeoFacade$getAvailableMaps$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Collection<MapStyle> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.geo.KotlinGeoFacade$getAvailableMaps$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(GeoException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.amplifyframework.kotlin.geo.Geo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getDefaultMap(kotlin.coroutines.Continuation<? super com.amplifyframework.geo.models.MapStyle> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.amplifyframework.kotlin.geo.KotlinGeoFacade$getDefaultMap$1
            if (r0 == 0) goto L13
            r0 = r5
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$getDefaultMap$1 r0 = (com.amplifyframework.kotlin.geo.KotlinGeoFacade$getDefaultMap$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$getDefaultMap$1 r0 = new com.amplifyframework.kotlin.geo.KotlinGeoFacade$getDefaultMap$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.amplifyframework.kotlin.geo.KotlinGeoFacade r0 = (com.amplifyframework.kotlin.geo.KotlinGeoFacade) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L59
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlin.coroutines.SafeContinuation r5 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)
            r5.<init>(r0)
            com.amplifyframework.geo.GeoCategoryBehavior r0 = r4.delegate
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$getDefaultMap$2$1 r2 = new com.amplifyframework.kotlin.geo.KotlinGeoFacade$getDefaultMap$2$1
            r2.<init>()
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$getDefaultMap$2$2 r3 = new com.amplifyframework.kotlin.geo.KotlinGeoFacade$getDefaultMap$2$2
            r3.<init>()
            r0.getDefaultMap(r2, r3)
            java.lang.Object r5 = r5.getOrThrow()
            if (r5 != r1) goto L59
            return r1
        L59:
            java.lang.String r0 = "suspendCoroutine { conti…ion(it) }\n        )\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.geo.KotlinGeoFacade.getDefaultMap(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.amplifyframework.kotlin.geo.Geo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMapStyleDescriptor(com.amplifyframework.geo.options.GetMapStyleDescriptorOptions r5, kotlin.coroutines.Continuation<? super com.amplifyframework.geo.models.MapStyleDescriptor> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.amplifyframework.kotlin.geo.KotlinGeoFacade$getMapStyleDescriptor$1
            if (r0 == 0) goto L13
            r0 = r6
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$getMapStyleDescriptor$1 r0 = (com.amplifyframework.kotlin.geo.KotlinGeoFacade$getMapStyleDescriptor$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$getMapStyleDescriptor$1 r0 = new com.amplifyframework.kotlin.geo.KotlinGeoFacade$getMapStyleDescriptor$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$1
            com.amplifyframework.geo.options.GetMapStyleDescriptorOptions r5 = (com.amplifyframework.geo.options.GetMapStyleDescriptorOptions) r5
            java.lang.Object r5 = r0.L$0
            com.amplifyframework.kotlin.geo.KotlinGeoFacade r5 = (com.amplifyframework.kotlin.geo.KotlinGeoFacade) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5f
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            kotlin.coroutines.SafeContinuation r6 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)
            r6.<init>(r0)
            com.amplifyframework.geo.GeoCategoryBehavior r0 = r4.delegate
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$getMapStyleDescriptor$2$1 r2 = new com.amplifyframework.kotlin.geo.KotlinGeoFacade$getMapStyleDescriptor$2$1
            r2.<init>()
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$getMapStyleDescriptor$2$2 r3 = new com.amplifyframework.kotlin.geo.KotlinGeoFacade$getMapStyleDescriptor$2$2
            r3.<init>()
            r0.getMapStyleDescriptor(r5, r2, r3)
            java.lang.Object r6 = r6.getOrThrow()
            if (r6 != r1) goto L5f
            return r1
        L5f:
            java.lang.String r5 = "suspendCoroutine { conti…}\n            )\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.geo.KotlinGeoFacade.getMapStyleDescriptor(com.amplifyframework.geo.options.GetMapStyleDescriptorOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.amplifyframework.kotlin.geo.Geo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object searchByCoordinates(com.amplifyframework.geo.models.Coordinates r5, com.amplifyframework.geo.options.GeoSearchByCoordinatesOptions r6, kotlin.coroutines.Continuation<? super com.amplifyframework.geo.result.GeoSearchResult> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByCoordinates$1
            if (r0 == 0) goto L13
            r0 = r7
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByCoordinates$1 r0 = (com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByCoordinates$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByCoordinates$1 r0 = new com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByCoordinates$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.L$2
            com.amplifyframework.geo.options.GeoSearchByCoordinatesOptions r5 = (com.amplifyframework.geo.options.GeoSearchByCoordinatesOptions) r5
            java.lang.Object r5 = r0.L$1
            com.amplifyframework.geo.models.Coordinates r5 = (com.amplifyframework.geo.models.Coordinates) r5
            java.lang.Object r5 = r0.L$0
            com.amplifyframework.kotlin.geo.KotlinGeoFacade r5 = (com.amplifyframework.kotlin.geo.KotlinGeoFacade) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L65
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            kotlin.coroutines.SafeContinuation r7 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)
            r7.<init>(r0)
            com.amplifyframework.geo.GeoCategoryBehavior r0 = r4.delegate
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByCoordinates$2$1 r2 = new com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByCoordinates$2$1
            r2.<init>()
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByCoordinates$2$2 r3 = new com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByCoordinates$2$2
            r3.<init>()
            r0.searchByCoordinates(r5, r6, r2, r3)
            java.lang.Object r7 = r7.getOrThrow()
            if (r7 != r1) goto L65
            return r1
        L65:
            java.lang.String r5 = "suspendCoroutine { conti…ion(it) }\n        )\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.geo.KotlinGeoFacade.searchByCoordinates(com.amplifyframework.geo.models.Coordinates, com.amplifyframework.geo.options.GeoSearchByCoordinatesOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.amplifyframework.kotlin.geo.Geo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object searchByText(java.lang.String r5, com.amplifyframework.geo.options.GeoSearchByTextOptions r6, kotlin.coroutines.Continuation<? super com.amplifyframework.geo.result.GeoSearchResult> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByText$1
            if (r0 == 0) goto L13
            r0 = r7
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByText$1 r0 = (com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByText$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByText$1 r0 = new com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByText$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.L$2
            com.amplifyframework.geo.options.GeoSearchByTextOptions r5 = (com.amplifyframework.geo.options.GeoSearchByTextOptions) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            com.amplifyframework.kotlin.geo.KotlinGeoFacade r5 = (com.amplifyframework.kotlin.geo.KotlinGeoFacade) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L65
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            kotlin.coroutines.SafeContinuation r7 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)
            r7.<init>(r0)
            com.amplifyframework.geo.GeoCategoryBehavior r0 = r4.delegate
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByText$2$1 r2 = new com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByText$2$1
            r2.<init>()
            com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByText$2$2 r3 = new com.amplifyframework.kotlin.geo.KotlinGeoFacade$searchByText$2$2
            r3.<init>()
            r0.searchByText(r5, r6, r2, r3)
            java.lang.Object r7 = r7.getOrThrow()
            if (r7 != r1) goto L65
            return r1
        L65:
            java.lang.String r5 = "suspendCoroutine { conti…ion(it) }\n        )\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.geo.KotlinGeoFacade.searchByText(java.lang.String, com.amplifyframework.geo.options.GeoSearchByTextOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public KotlinGeoFacade(GeoCategoryBehavior delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ KotlinGeoFacade(com.amplifyframework.geo.GeoCategoryBehavior r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto Lb
            com.amplifyframework.geo.GeoCategory r1 = com.amplifyframework.core.Amplify.Geo
            java.lang.String r2 = "Geo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        Lb:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.geo.KotlinGeoFacade.<init>(com.amplifyframework.geo.GeoCategoryBehavior, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
