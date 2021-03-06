/*
 * Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.services.rds;

import software.amazon.awssdk.annotations.SdkProtectedApi;
import software.amazon.awssdk.core.Request;
import software.amazon.awssdk.protocols.query.AwsQueryProtocolFactory;
import software.amazon.awssdk.services.rds.model.CreateDbInstanceReadReplicaRequest;
import software.amazon.awssdk.services.rds.transform.CreateDbInstanceReadReplicaRequestMarshaller;

/**
 * Handler for pre-signing {@link CreateDbInstanceReadReplicaRequest}.
 */
@SdkProtectedApi
public final class CreateDbInstanceReadReplicaPresignInterceptor extends
                                                                 RdsPresignInterceptor<CreateDbInstanceReadReplicaRequest> {

    public static final CreateDbInstanceReadReplicaRequestMarshaller MARSHALLER =
        new CreateDbInstanceReadReplicaRequestMarshaller(AwsQueryProtocolFactory.builder().build());

    public CreateDbInstanceReadReplicaPresignInterceptor() {
        super(CreateDbInstanceReadReplicaRequest.class);
    }

    @Override
    protected PresignableRequest adaptRequest(final CreateDbInstanceReadReplicaRequest originalRequest) {
        return new PresignableRequest() {
            @Override
            public String getSourceRegion() {
                return originalRequest.sourceRegion();
            }

            @Override
            public Request<?> marshall() {
                return MARSHALLER.marshall(originalRequest);
            }
        };
    }
}
