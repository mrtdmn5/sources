package com.amazonaws.services.s3;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.internal.S3DirectSpi;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketNotificationConfiguration;
import com.amazonaws.services.s3.model.BucketPolicy;
import com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazonaws.services.s3.model.CopyPartResult;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.DeleteBucketAnalyticsConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.DeleteBucketCrossOriginConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketInventoryConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.DeleteBucketLifecycleConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketMetricsConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.DeleteBucketPolicyRequest;
import com.amazonaws.services.s3.model.DeleteBucketReplicationConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketRequest;
import com.amazonaws.services.s3.model.DeleteBucketTaggingConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteBucketWebsiteConfigurationRequest;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.DeleteObjectTaggingRequest;
import com.amazonaws.services.s3.model.DeleteObjectTaggingResult;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.DeleteVersionRequest;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetBucketAccelerateConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketAclRequest;
import com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketCrossOriginConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketInventoryConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketLifecycleConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazonaws.services.s3.model.GetBucketLoggingConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketMetricsConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.GetBucketNotificationConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketPolicyRequest;
import com.amazonaws.services.s3.model.GetBucketReplicationConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketTaggingConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketVersioningConfigurationRequest;
import com.amazonaws.services.s3.model.GetBucketWebsiteConfigurationRequest;
import com.amazonaws.services.s3.model.GetObjectAclRequest;
import com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.GetObjectTaggingRequest;
import com.amazonaws.services.s3.model.GetObjectTaggingResult;
import com.amazonaws.services.s3.model.GetS3AccountOwnerRequest;
import com.amazonaws.services.s3.model.HeadBucketRequest;
import com.amazonaws.services.s3.model.HeadBucketResult;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsRequest;
import com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsRequest;
import com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsRequest;
import com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketsRequest;
import com.amazonaws.services.s3.model.ListMultipartUploadsRequest;
import com.amazonaws.services.s3.model.ListNextBatchOfObjectsRequest;
import com.amazonaws.services.s3.model.ListNextBatchOfVersionsRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ListPartsRequest;
import com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.PartListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.Region;
import com.amazonaws.services.s3.model.RestoreObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.SetBucketAccelerateConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketAclRequest;
import com.amazonaws.services.s3.model.SetBucketAnalyticsConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketAnalyticsConfigurationResult;
import com.amazonaws.services.s3.model.SetBucketCrossOriginConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketInventoryConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.SetBucketLifecycleConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketLoggingConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketMetricsConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketMetricsConfigurationResult;
import com.amazonaws.services.s3.model.SetBucketNotificationConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketPolicyRequest;
import com.amazonaws.services.s3.model.SetBucketReplicationConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketTaggingConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketVersioningConfigurationRequest;
import com.amazonaws.services.s3.model.SetBucketWebsiteConfigurationRequest;
import com.amazonaws.services.s3.model.SetObjectAclRequest;
import com.amazonaws.services.s3.model.SetObjectTaggingRequest;
import com.amazonaws.services.s3.model.SetObjectTaggingResult;
import com.amazonaws.services.s3.model.StorageClass;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import com.amazonaws.services.s3.model.VersionListing;
import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public interface AmazonS3 extends S3DirectSpi {
    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    void abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) throws AmazonClientException, AmazonServiceException;

    void changeObjectStorageClass(String str, String str2, StorageClass storageClass) throws AmazonClientException, AmazonServiceException;

    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws AmazonClientException, AmazonServiceException;

    CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) throws AmazonClientException, AmazonServiceException;

    CopyObjectResult copyObject(String str, String str2, String str3, String str4) throws AmazonClientException, AmazonServiceException;

    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    CopyPartResult copyPart(CopyPartRequest copyPartRequest) throws AmazonClientException, AmazonServiceException;

    Bucket createBucket(CreateBucketRequest createBucketRequest) throws AmazonClientException, AmazonServiceException;

    Bucket createBucket(String str) throws AmazonClientException, AmazonServiceException;

    Bucket createBucket(String str, Region region) throws AmazonClientException, AmazonServiceException;

    Bucket createBucket(String str, String str2) throws AmazonClientException, AmazonServiceException;

    void deleteBucket(DeleteBucketRequest deleteBucketRequest) throws AmazonClientException, AmazonServiceException;

    void deleteBucket(String str) throws AmazonClientException, AmazonServiceException;

    DeleteBucketAnalyticsConfigurationResult deleteBucketAnalyticsConfiguration(DeleteBucketAnalyticsConfigurationRequest deleteBucketAnalyticsConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    DeleteBucketAnalyticsConfigurationResult deleteBucketAnalyticsConfiguration(String str, String str2) throws AmazonServiceException, AmazonClientException;

    void deleteBucketCrossOriginConfiguration(DeleteBucketCrossOriginConfigurationRequest deleteBucketCrossOriginConfigurationRequest);

    void deleteBucketCrossOriginConfiguration(String str);

    DeleteBucketInventoryConfigurationResult deleteBucketInventoryConfiguration(DeleteBucketInventoryConfigurationRequest deleteBucketInventoryConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    DeleteBucketInventoryConfigurationResult deleteBucketInventoryConfiguration(String str, String str2) throws AmazonServiceException, AmazonClientException;

    void deleteBucketLifecycleConfiguration(DeleteBucketLifecycleConfigurationRequest deleteBucketLifecycleConfigurationRequest);

    void deleteBucketLifecycleConfiguration(String str);

    DeleteBucketMetricsConfigurationResult deleteBucketMetricsConfiguration(DeleteBucketMetricsConfigurationRequest deleteBucketMetricsConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    DeleteBucketMetricsConfigurationResult deleteBucketMetricsConfiguration(String str, String str2) throws AmazonServiceException, AmazonClientException;

    void deleteBucketPolicy(DeleteBucketPolicyRequest deleteBucketPolicyRequest) throws AmazonClientException, AmazonServiceException;

    void deleteBucketPolicy(String str) throws AmazonClientException, AmazonServiceException;

    void deleteBucketReplicationConfiguration(DeleteBucketReplicationConfigurationRequest deleteBucketReplicationConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    void deleteBucketReplicationConfiguration(String str) throws AmazonServiceException, AmazonClientException;

    void deleteBucketTaggingConfiguration(DeleteBucketTaggingConfigurationRequest deleteBucketTaggingConfigurationRequest);

    void deleteBucketTaggingConfiguration(String str);

    void deleteBucketWebsiteConfiguration(DeleteBucketWebsiteConfigurationRequest deleteBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException;

    void deleteBucketWebsiteConfiguration(String str) throws AmazonClientException, AmazonServiceException;

    void deleteObject(DeleteObjectRequest deleteObjectRequest) throws AmazonClientException, AmazonServiceException;

    void deleteObject(String str, String str2) throws AmazonClientException, AmazonServiceException;

    DeleteObjectTaggingResult deleteObjectTagging(DeleteObjectTaggingRequest deleteObjectTaggingRequest);

    DeleteObjectsResult deleteObjects(DeleteObjectsRequest deleteObjectsRequest) throws AmazonClientException, AmazonServiceException;

    void deleteVersion(DeleteVersionRequest deleteVersionRequest) throws AmazonClientException, AmazonServiceException;

    void deleteVersion(String str, String str2, String str3) throws AmazonClientException, AmazonServiceException;

    void disableRequesterPays(String str) throws AmazonServiceException, AmazonClientException;

    boolean doesBucketExist(String str) throws AmazonClientException, AmazonServiceException;

    boolean doesObjectExist(String str, String str2) throws AmazonServiceException, AmazonClientException;

    void enableRequesterPays(String str) throws AmazonServiceException, AmazonClientException;

    URL generatePresignedUrl(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws AmazonClientException;

    URL generatePresignedUrl(String str, String str2, Date date) throws AmazonClientException;

    URL generatePresignedUrl(String str, String str2, Date date, HttpMethod httpMethod) throws AmazonClientException;

    BucketAccelerateConfiguration getBucketAccelerateConfiguration(GetBucketAccelerateConfigurationRequest getBucketAccelerateConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    BucketAccelerateConfiguration getBucketAccelerateConfiguration(String str) throws AmazonServiceException, AmazonClientException;

    AccessControlList getBucketAcl(GetBucketAclRequest getBucketAclRequest) throws AmazonClientException, AmazonServiceException;

    AccessControlList getBucketAcl(String str) throws AmazonClientException, AmazonServiceException;

    GetBucketAnalyticsConfigurationResult getBucketAnalyticsConfiguration(GetBucketAnalyticsConfigurationRequest getBucketAnalyticsConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    GetBucketAnalyticsConfigurationResult getBucketAnalyticsConfiguration(String str, String str2) throws AmazonServiceException, AmazonClientException;

    BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(GetBucketCrossOriginConfigurationRequest getBucketCrossOriginConfigurationRequest);

    BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(String str);

    GetBucketInventoryConfigurationResult getBucketInventoryConfiguration(GetBucketInventoryConfigurationRequest getBucketInventoryConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    GetBucketInventoryConfigurationResult getBucketInventoryConfiguration(String str, String str2) throws AmazonServiceException, AmazonClientException;

    BucketLifecycleConfiguration getBucketLifecycleConfiguration(GetBucketLifecycleConfigurationRequest getBucketLifecycleConfigurationRequest);

    BucketLifecycleConfiguration getBucketLifecycleConfiguration(String str);

    String getBucketLocation(GetBucketLocationRequest getBucketLocationRequest) throws AmazonClientException, AmazonServiceException;

    String getBucketLocation(String str) throws AmazonClientException, AmazonServiceException;

    BucketLoggingConfiguration getBucketLoggingConfiguration(GetBucketLoggingConfigurationRequest getBucketLoggingConfigurationRequest) throws AmazonClientException, AmazonServiceException;

    BucketLoggingConfiguration getBucketLoggingConfiguration(String str) throws AmazonClientException, AmazonServiceException;

    GetBucketMetricsConfigurationResult getBucketMetricsConfiguration(GetBucketMetricsConfigurationRequest getBucketMetricsConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    GetBucketMetricsConfigurationResult getBucketMetricsConfiguration(String str, String str2) throws AmazonServiceException, AmazonClientException;

    BucketNotificationConfiguration getBucketNotificationConfiguration(GetBucketNotificationConfigurationRequest getBucketNotificationConfigurationRequest) throws AmazonClientException, AmazonServiceException;

    BucketNotificationConfiguration getBucketNotificationConfiguration(String str) throws AmazonClientException, AmazonServiceException;

    BucketPolicy getBucketPolicy(GetBucketPolicyRequest getBucketPolicyRequest) throws AmazonClientException, AmazonServiceException;

    BucketPolicy getBucketPolicy(String str) throws AmazonClientException, AmazonServiceException;

    BucketReplicationConfiguration getBucketReplicationConfiguration(GetBucketReplicationConfigurationRequest getBucketReplicationConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    BucketReplicationConfiguration getBucketReplicationConfiguration(String str) throws AmazonServiceException, AmazonClientException;

    BucketTaggingConfiguration getBucketTaggingConfiguration(GetBucketTaggingConfigurationRequest getBucketTaggingConfigurationRequest);

    BucketTaggingConfiguration getBucketTaggingConfiguration(String str);

    BucketVersioningConfiguration getBucketVersioningConfiguration(GetBucketVersioningConfigurationRequest getBucketVersioningConfigurationRequest) throws AmazonClientException, AmazonServiceException;

    BucketVersioningConfiguration getBucketVersioningConfiguration(String str) throws AmazonClientException, AmazonServiceException;

    BucketWebsiteConfiguration getBucketWebsiteConfiguration(GetBucketWebsiteConfigurationRequest getBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException;

    BucketWebsiteConfiguration getBucketWebsiteConfiguration(String str) throws AmazonClientException, AmazonServiceException;

    S3ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest);

    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    ObjectMetadata getObject(GetObjectRequest getObjectRequest, File file) throws AmazonClientException, AmazonServiceException;

    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    S3Object getObject(GetObjectRequest getObjectRequest) throws AmazonClientException, AmazonServiceException;

    S3Object getObject(String str, String str2) throws AmazonClientException, AmazonServiceException;

    AccessControlList getObjectAcl(GetObjectAclRequest getObjectAclRequest) throws AmazonClientException, AmazonServiceException;

    AccessControlList getObjectAcl(String str, String str2) throws AmazonClientException, AmazonServiceException;

    AccessControlList getObjectAcl(String str, String str2, String str3) throws AmazonClientException, AmazonServiceException;

    String getObjectAsString(String str, String str2) throws AmazonServiceException, AmazonClientException;

    ObjectMetadata getObjectMetadata(GetObjectMetadataRequest getObjectMetadataRequest) throws AmazonClientException, AmazonServiceException;

    ObjectMetadata getObjectMetadata(String str, String str2) throws AmazonClientException, AmazonServiceException;

    GetObjectTaggingResult getObjectTagging(GetObjectTaggingRequest getObjectTaggingRequest);

    Region getRegion();

    String getRegionName();

    Owner getS3AccountOwner() throws AmazonClientException, AmazonServiceException;

    Owner getS3AccountOwner(GetS3AccountOwnerRequest getS3AccountOwnerRequest) throws AmazonClientException, AmazonServiceException;

    URL getUrl(String str, String str2);

    HeadBucketResult headBucket(HeadBucketRequest headBucketRequest) throws AmazonClientException, AmazonServiceException;

    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) throws AmazonClientException, AmazonServiceException;

    boolean isRequesterPaysEnabled(String str) throws AmazonServiceException, AmazonClientException;

    ListBucketAnalyticsConfigurationsResult listBucketAnalyticsConfigurations(ListBucketAnalyticsConfigurationsRequest listBucketAnalyticsConfigurationsRequest) throws AmazonServiceException, AmazonClientException;

    ListBucketInventoryConfigurationsResult listBucketInventoryConfigurations(ListBucketInventoryConfigurationsRequest listBucketInventoryConfigurationsRequest) throws AmazonServiceException, AmazonClientException;

    ListBucketMetricsConfigurationsResult listBucketMetricsConfigurations(ListBucketMetricsConfigurationsRequest listBucketMetricsConfigurationsRequest) throws AmazonServiceException, AmazonClientException;

    List<Bucket> listBuckets() throws AmazonClientException, AmazonServiceException;

    List<Bucket> listBuckets(ListBucketsRequest listBucketsRequest) throws AmazonClientException, AmazonServiceException;

    MultipartUploadListing listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest) throws AmazonClientException, AmazonServiceException;

    ObjectListing listNextBatchOfObjects(ListNextBatchOfObjectsRequest listNextBatchOfObjectsRequest) throws AmazonClientException, AmazonServiceException;

    ObjectListing listNextBatchOfObjects(ObjectListing objectListing) throws AmazonClientException, AmazonServiceException;

    VersionListing listNextBatchOfVersions(ListNextBatchOfVersionsRequest listNextBatchOfVersionsRequest) throws AmazonClientException, AmazonServiceException;

    VersionListing listNextBatchOfVersions(VersionListing versionListing) throws AmazonClientException, AmazonServiceException;

    ObjectListing listObjects(ListObjectsRequest listObjectsRequest) throws AmazonClientException, AmazonServiceException;

    ObjectListing listObjects(String str) throws AmazonClientException, AmazonServiceException;

    ObjectListing listObjects(String str, String str2) throws AmazonClientException, AmazonServiceException;

    ListObjectsV2Result listObjectsV2(ListObjectsV2Request listObjectsV2Request) throws AmazonClientException, AmazonServiceException;

    ListObjectsV2Result listObjectsV2(String str) throws AmazonClientException, AmazonServiceException;

    ListObjectsV2Result listObjectsV2(String str, String str2) throws AmazonClientException, AmazonServiceException;

    PartListing listParts(ListPartsRequest listPartsRequest) throws AmazonClientException, AmazonServiceException;

    VersionListing listVersions(ListVersionsRequest listVersionsRequest) throws AmazonClientException, AmazonServiceException;

    VersionListing listVersions(String str, String str2) throws AmazonClientException, AmazonServiceException;

    VersionListing listVersions(String str, String str2, String str3, String str4, String str5, Integer num) throws AmazonClientException, AmazonServiceException;

    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    PutObjectResult putObject(PutObjectRequest putObjectRequest) throws AmazonClientException, AmazonServiceException;

    PutObjectResult putObject(String str, String str2, File file) throws AmazonClientException, AmazonServiceException;

    PutObjectResult putObject(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) throws AmazonClientException, AmazonServiceException;

    PutObjectResult putObject(String str, String str2, String str3) throws AmazonServiceException, AmazonClientException;

    void restoreObject(RestoreObjectRequest restoreObjectRequest) throws AmazonServiceException;

    void restoreObject(String str, String str2, int r3) throws AmazonServiceException;

    void setBucketAccelerateConfiguration(SetBucketAccelerateConfigurationRequest setBucketAccelerateConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    void setBucketAccelerateConfiguration(String str, BucketAccelerateConfiguration bucketAccelerateConfiguration) throws AmazonServiceException, AmazonClientException;

    void setBucketAcl(SetBucketAclRequest setBucketAclRequest) throws AmazonClientException, AmazonServiceException;

    void setBucketAcl(String str, AccessControlList accessControlList) throws AmazonClientException, AmazonServiceException;

    void setBucketAcl(String str, CannedAccessControlList cannedAccessControlList) throws AmazonClientException, AmazonServiceException;

    SetBucketAnalyticsConfigurationResult setBucketAnalyticsConfiguration(SetBucketAnalyticsConfigurationRequest setBucketAnalyticsConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    SetBucketAnalyticsConfigurationResult setBucketAnalyticsConfiguration(String str, AnalyticsConfiguration analyticsConfiguration) throws AmazonServiceException, AmazonClientException;

    void setBucketCrossOriginConfiguration(SetBucketCrossOriginConfigurationRequest setBucketCrossOriginConfigurationRequest);

    void setBucketCrossOriginConfiguration(String str, BucketCrossOriginConfiguration bucketCrossOriginConfiguration);

    SetBucketInventoryConfigurationResult setBucketInventoryConfiguration(SetBucketInventoryConfigurationRequest setBucketInventoryConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    SetBucketInventoryConfigurationResult setBucketInventoryConfiguration(String str, InventoryConfiguration inventoryConfiguration) throws AmazonServiceException, AmazonClientException;

    void setBucketLifecycleConfiguration(SetBucketLifecycleConfigurationRequest setBucketLifecycleConfigurationRequest);

    void setBucketLifecycleConfiguration(String str, BucketLifecycleConfiguration bucketLifecycleConfiguration);

    void setBucketLoggingConfiguration(SetBucketLoggingConfigurationRequest setBucketLoggingConfigurationRequest) throws AmazonClientException, AmazonServiceException;

    SetBucketMetricsConfigurationResult setBucketMetricsConfiguration(SetBucketMetricsConfigurationRequest setBucketMetricsConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    SetBucketMetricsConfigurationResult setBucketMetricsConfiguration(String str, MetricsConfiguration metricsConfiguration) throws AmazonServiceException, AmazonClientException;

    void setBucketNotificationConfiguration(SetBucketNotificationConfigurationRequest setBucketNotificationConfigurationRequest) throws AmazonClientException, AmazonServiceException;

    void setBucketNotificationConfiguration(String str, BucketNotificationConfiguration bucketNotificationConfiguration) throws AmazonClientException, AmazonServiceException;

    void setBucketPolicy(SetBucketPolicyRequest setBucketPolicyRequest) throws AmazonClientException, AmazonServiceException;

    void setBucketPolicy(String str, String str2) throws AmazonClientException, AmazonServiceException;

    void setBucketReplicationConfiguration(SetBucketReplicationConfigurationRequest setBucketReplicationConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    void setBucketReplicationConfiguration(String str, BucketReplicationConfiguration bucketReplicationConfiguration) throws AmazonServiceException, AmazonClientException;

    void setBucketTaggingConfiguration(SetBucketTaggingConfigurationRequest setBucketTaggingConfigurationRequest);

    void setBucketTaggingConfiguration(String str, BucketTaggingConfiguration bucketTaggingConfiguration);

    void setBucketVersioningConfiguration(SetBucketVersioningConfigurationRequest setBucketVersioningConfigurationRequest) throws AmazonClientException, AmazonServiceException;

    void setBucketWebsiteConfiguration(SetBucketWebsiteConfigurationRequest setBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException;

    void setBucketWebsiteConfiguration(String str, BucketWebsiteConfiguration bucketWebsiteConfiguration) throws AmazonClientException, AmazonServiceException;

    void setEndpoint(String str);

    void setObjectAcl(SetObjectAclRequest setObjectAclRequest) throws AmazonClientException, AmazonServiceException;

    void setObjectAcl(String str, String str2, AccessControlList accessControlList) throws AmazonClientException, AmazonServiceException;

    void setObjectAcl(String str, String str2, CannedAccessControlList cannedAccessControlList) throws AmazonClientException, AmazonServiceException;

    void setObjectAcl(String str, String str2, String str3, AccessControlList accessControlList) throws AmazonClientException, AmazonServiceException;

    void setObjectAcl(String str, String str2, String str3, CannedAccessControlList cannedAccessControlList) throws AmazonClientException, AmazonServiceException;

    void setObjectRedirectLocation(String str, String str2, String str3) throws AmazonClientException, AmazonServiceException;

    SetObjectTaggingResult setObjectTagging(SetObjectTaggingRequest setObjectTaggingRequest);

    void setRegion(com.amazonaws.regions.Region region) throws IllegalArgumentException;

    void setS3ClientOptions(S3ClientOptions s3ClientOptions);

    @Override // com.amazonaws.services.s3.internal.S3DirectSpi
    UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) throws AmazonClientException, AmazonServiceException;
}
