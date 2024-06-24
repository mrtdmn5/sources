package com.amazonaws.services.s3.iterable;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazonaws.services.s3.model.VersionListing;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class S3Versions implements Iterable<S3VersionSummary> {
    private Integer batchSize;
    private String bucketName;
    private String key;
    private String prefix;
    private AmazonS3 s3;

    /* loaded from: classes.dex */
    public class VersionIterator implements Iterator<S3VersionSummary> {
        private Iterator<S3VersionSummary> currentIterator;
        private VersionListing currentListing;
        private S3VersionSummary nextSummary;

        private VersionIterator() {
            this.currentListing = null;
            this.currentIterator = null;
            this.nextSummary = null;
        }

        private S3VersionSummary nextMatchingSummary() {
            S3VersionSummary s3VersionSummary;
            if (S3Versions.this.getKey() != null && ((s3VersionSummary = this.nextSummary) == null || !s3VersionSummary.getKey().equals(S3Versions.this.getKey()))) {
                return null;
            }
            return this.nextSummary;
        }

        private void prepareCurrentListing() {
            while (true) {
                if (this.currentListing == null || (!this.currentIterator.hasNext() && this.currentListing.isTruncated())) {
                    if (this.currentListing == null) {
                        ListVersionsRequest listVersionsRequest = new ListVersionsRequest();
                        listVersionsRequest.setBucketName(S3Versions.this.getBucketName());
                        if (S3Versions.this.getKey() != null) {
                            listVersionsRequest.setPrefix(S3Versions.this.getKey());
                        } else {
                            listVersionsRequest.setPrefix(S3Versions.this.getPrefix());
                        }
                        listVersionsRequest.setMaxResults(S3Versions.this.getBatchSize());
                        this.currentListing = S3Versions.this.getS3().listVersions(listVersionsRequest);
                    } else {
                        this.currentListing = S3Versions.this.getS3().listNextBatchOfVersions(this.currentListing);
                    }
                    this.currentIterator = this.currentListing.getVersionSummaries().iterator();
                }
            }
            if (this.nextSummary == null && this.currentIterator.hasNext()) {
                this.nextSummary = this.currentIterator.next();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            prepareCurrentListing();
            if (nextMatchingSummary() != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public S3VersionSummary next() {
            prepareCurrentListing();
            S3VersionSummary nextMatchingSummary = nextMatchingSummary();
            this.nextSummary = null;
            return nextMatchingSummary;
        }
    }

    private S3Versions(AmazonS3 amazonS3, String str) {
        this.s3 = amazonS3;
        this.bucketName = str;
    }

    public static S3Versions forKey(AmazonS3 amazonS3, String str, String str2) {
        S3Versions s3Versions = new S3Versions(amazonS3, str);
        s3Versions.key = str2;
        return s3Versions;
    }

    public static S3Versions inBucket(AmazonS3 amazonS3, String str) {
        return new S3Versions(amazonS3, str);
    }

    public static S3Versions withPrefix(AmazonS3 amazonS3, String str, String str2) {
        S3Versions s3Versions = new S3Versions(amazonS3, str);
        s3Versions.prefix = str2;
        return s3Versions;
    }

    public Integer getBatchSize() {
        return this.batchSize;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public AmazonS3 getS3() {
        return this.s3;
    }

    @Override // java.lang.Iterable
    public Iterator<S3VersionSummary> iterator() {
        return new VersionIterator();
    }

    public S3Versions withBatchSize(int r1) {
        this.batchSize = Integer.valueOf(r1);
        return this;
    }
}
