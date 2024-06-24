package com.amazonaws.auth.policy.resources;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.amazonaws.auth.policy.Resource;

/* loaded from: classes.dex */
public class S3BucketResource extends Resource {
    public S3BucketResource(String str) {
        super(ConstraintSet$$ExternalSyntheticOutline0.m("arn:aws:s3:::", str));
    }
}
