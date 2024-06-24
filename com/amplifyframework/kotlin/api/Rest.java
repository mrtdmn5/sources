package com.amplifyframework.kotlin.api;

import com.amplifyframework.api.ApiException;
import com.amplifyframework.api.rest.RestOptions;
import com.amplifyframework.api.rest.RestResponse;
import kotlin.coroutines.Continuation;

/* compiled from: Rest.kt */
/* loaded from: classes.dex */
public interface Rest {

    /* compiled from: Rest.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object delete$default(Rest rest, RestOptions restOptions, String str, Continuation continuation, int r4, Object obj) throws ApiException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    str = null;
                }
                return rest.delete(restOptions, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        public static /* synthetic */ Object get$default(Rest rest, RestOptions restOptions, String str, Continuation continuation, int r4, Object obj) throws ApiException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    str = null;
                }
                return rest.get(restOptions, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }

        public static /* synthetic */ Object head$default(Rest rest, RestOptions restOptions, String str, Continuation continuation, int r4, Object obj) throws ApiException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    str = null;
                }
                return rest.head(restOptions, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: head");
        }

        public static /* synthetic */ Object patch$default(Rest rest, RestOptions restOptions, String str, Continuation continuation, int r4, Object obj) throws ApiException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    str = null;
                }
                return rest.patch(restOptions, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: patch");
        }

        public static /* synthetic */ Object post$default(Rest rest, RestOptions restOptions, String str, Continuation continuation, int r4, Object obj) throws ApiException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    str = null;
                }
                return rest.post(restOptions, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: post");
        }

        public static /* synthetic */ Object put$default(Rest rest, RestOptions restOptions, String str, Continuation continuation, int r4, Object obj) throws ApiException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    str = null;
                }
                return rest.put(restOptions, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: put");
        }
    }

    Object delete(RestOptions restOptions, String str, Continuation<? super RestResponse> continuation) throws ApiException;

    Object get(RestOptions restOptions, String str, Continuation<? super RestResponse> continuation) throws ApiException;

    Object head(RestOptions restOptions, String str, Continuation<? super RestResponse> continuation) throws ApiException;

    Object patch(RestOptions restOptions, String str, Continuation<? super RestResponse> continuation) throws ApiException;

    Object post(RestOptions restOptions, String str, Continuation<? super RestResponse> continuation) throws ApiException;

    Object put(RestOptions restOptions, String str, Continuation<? super RestResponse> continuation) throws ApiException;
}
