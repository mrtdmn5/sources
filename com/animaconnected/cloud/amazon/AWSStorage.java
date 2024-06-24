package com.animaconnected.cloud.amazon;

import android.content.Context;
import android.util.Log;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3Client;
import com.animaconnected.future.FlatMapCallback;
import com.animaconnected.future.Future;
import com.animaconnected.future.MapCallback;
import com.animaconnected.future.Promise;
import com.animaconnected.future.SuccessCallback;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class AWSStorage {
    private static final String TAG = "AWSStorage";
    private final AWSCloudConfig mConfig;
    private final Context mContext;
    private final AWSAmplifyCredentialsProvider mCredentialsProvider;
    private TransferUtility mTransferUtility;

    public AWSStorage(Context context, AWSCloudConfig aWSCloudConfig, AWSAmplifyCredentialsProvider aWSAmplifyCredentialsProvider) {
        this.mContext = context;
        this.mConfig = aWSCloudConfig;
        this.mCredentialsProvider = aWSAmplifyCredentialsProvider;
        new AWSLambda(context, aWSCloudConfig, aWSAmplifyCredentialsProvider);
    }

    private Future<TransferUtility> getTransferUtility() {
        return this.mCredentialsProvider.getCredentialsProvider().map(new MapCallback() { // from class: com.animaconnected.cloud.amazon.AWSStorage$$ExternalSyntheticLambda2
            @Override // com.animaconnected.future.MapCallback
            public final Object onResult(Object obj) {
                TransferUtility lambda$getTransferUtility$0;
                lambda$getTransferUtility$0 = AWSStorage.this.lambda$getTransferUtility$0((AWSAmplifyCredentials) obj);
                return lambda$getTransferUtility$0;
            }
        });
    }

    public /* synthetic */ TransferUtility lambda$getTransferUtility$0(AWSAmplifyCredentials aWSAmplifyCredentials) throws IOException {
        AmazonS3Client amazonS3Client = new AmazonS3Client(aWSAmplifyCredentials, Region.getRegion(this.mConfig.getRegion()));
        amazonS3Client.setRegion(Region.getRegion(this.mConfig.getRegion()));
        TransferUtility build = TransferUtility.builder().s3Client(amazonS3Client).context(this.mContext).build();
        this.mTransferUtility = build;
        return build;
    }

    public /* synthetic */ void lambda$storeToS3$1(String str, String str2, File file, Promise promise, TransferUtility transferUtility) {
        transferUtility.upload(str, str2, file).setTransferListener(new TransferListener() { // from class: com.animaconnected.cloud.amazon.AWSStorage.1
            final /* synthetic */ String val$destBucket;
            final /* synthetic */ String val$destKey;
            final /* synthetic */ Promise val$promise;

            public AnonymousClass1(String str3, String str22, Promise promise2) {
                r2 = str3;
                r3 = str22;
                r4 = promise2;
            }

            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
            public void onError(int r2, Exception exc) {
                try {
                    r4.reject(exc);
                } catch (IllegalStateException e) {
                    Log.e(AWSStorage.TAG, "Promise cant be rejected ", e);
                }
            }

            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
            public void onStateChanged(int r3, TransferState transferState) {
                try {
                    String str3 = "https://" + r2 + ".s3.amazonaws.com/" + r3;
                    if (transferState == TransferState.COMPLETED) {
                        r4.resolve(str3);
                    } else if (transferState == TransferState.FAILED) {
                        r4.reject(new Throwable("Failed storing to bucket=" + r2 + ", key=" + r3));
                    }
                } catch (IllegalStateException e) {
                    Log.e(AWSStorage.TAG, "Promise cant be resolved/rejected ", e);
                }
            }

            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
            public void onProgressChanged(int r1, long j, long j2) {
            }
        });
    }

    private Future<String> storeToS3(final String str, final String str2, final File file) {
        final Promise promise = new Promise();
        getTransferUtility().success(new SuccessCallback() { // from class: com.animaconnected.cloud.amazon.AWSStorage$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                AWSStorage.this.lambda$storeToS3$1(str, str2, file, promise, (TransferUtility) obj);
            }
        });
        return promise.getFuture();
    }

    public Future<Void> download(final Map<String, String> map, final File file) {
        return getTransferUtility().flatMap(new FlatMapCallback() { // from class: com.animaconnected.cloud.amazon.AWSStorage$$ExternalSyntheticLambda1
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$download$2;
                lambda$download$2 = AWSStorage.this.lambda$download$2(map, file, (TransferUtility) obj);
                return lambda$download$2;
            }
        });
    }

    public Future<String> uploadDeviceCrash(File file, String str) {
        return storeToS3(this.mConfig.getS3UploadDeviceCrashBucket(), str, file);
    }

    /* renamed from: download */
    public Future<Void> lambda$download$2(Map<String, String> map, File file, TransferUtility transferUtility) {
        Promise promise = new Promise();
        transferUtility.download(map.get("s3Bucket"), map.get("s3Key"), file).setTransferListener(new TransferListener() { // from class: com.animaconnected.cloud.amazon.AWSStorage.2
            final /* synthetic */ Promise val$promise;

            public AnonymousClass2(Promise promise2) {
                r2 = promise2;
            }

            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
            public void onError(int r1, Exception exc) {
                r2.reject(exc);
            }

            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
            public void onStateChanged(int r2, TransferState transferState) {
                if (transferState == TransferState.COMPLETED) {
                    r2.resolve(null);
                } else if (transferState == TransferState.CANCELED) {
                    r2.reject(new RuntimeException("Canceled"));
                }
            }

            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
            public void onProgressChanged(int r1, long j, long j2) {
            }
        });
        return promise2.getFuture();
    }

    /* renamed from: com.animaconnected.cloud.amazon.AWSStorage$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements TransferListener {
        final /* synthetic */ String val$destBucket;
        final /* synthetic */ String val$destKey;
        final /* synthetic */ Promise val$promise;

        public AnonymousClass1(String str3, String str22, Promise promise2) {
            r2 = str3;
            r3 = str22;
            r4 = promise2;
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void onError(int r2, Exception exc) {
            try {
                r4.reject(exc);
            } catch (IllegalStateException e) {
                Log.e(AWSStorage.TAG, "Promise cant be rejected ", e);
            }
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void onStateChanged(int r3, TransferState transferState) {
            try {
                String str3 = "https://" + r2 + ".s3.amazonaws.com/" + r3;
                if (transferState == TransferState.COMPLETED) {
                    r4.resolve(str3);
                } else if (transferState == TransferState.FAILED) {
                    r4.reject(new Throwable("Failed storing to bucket=" + r2 + ", key=" + r3));
                }
            } catch (IllegalStateException e) {
                Log.e(AWSStorage.TAG, "Promise cant be resolved/rejected ", e);
            }
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void onProgressChanged(int r1, long j, long j2) {
        }
    }

    /* renamed from: com.animaconnected.cloud.amazon.AWSStorage$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements TransferListener {
        final /* synthetic */ Promise val$promise;

        public AnonymousClass2(Promise promise2) {
            r2 = promise2;
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void onError(int r1, Exception exc) {
            r2.reject(exc);
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void onStateChanged(int r2, TransferState transferState) {
            if (transferState == TransferState.COMPLETED) {
                r2.resolve(null);
            } else if (transferState == TransferState.CANCELED) {
                r2.reject(new RuntimeException("Canceled"));
            }
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void onProgressChanged(int r1, long j, long j2) {
        }
    }
}
