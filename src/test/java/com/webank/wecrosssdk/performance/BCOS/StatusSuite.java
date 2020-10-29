package com.webank.wecrosssdk.performance.BCOS;

import com.webank.wecrosssdk.exception.ErrorCode;
import com.webank.wecrosssdk.exception.WeCrossSDKException;
import com.webank.wecrosssdk.performance.PerformanceSuite;
import com.webank.wecrosssdk.performance.PerformanceSuiteCallback;
import com.webank.wecrosssdk.resource.Resource;
import com.webank.wecrosssdk.rpc.methods.Callback;
import com.webank.wecrosssdk.rpc.methods.Response;

public class StatusSuite implements PerformanceSuite {
    private final Resource resource;

    public StatusSuite(Resource resource) throws WeCrossSDKException {
        if (!resource.isActive()) {
            throw new WeCrossSDKException(ErrorCode.RESOURCE_INACTIVE, "Resource inactive");
        }

        try {
            resource.status();
        } catch (WeCrossSDKException e) {
            throw new WeCrossSDKException(
                    ErrorCode.INVALID_CONTRACT, "Invalid contract or user: " + e.getMessage());
        }

        this.resource = resource;
    }

    @Override
    public String getName() {
        return "Status Suite";
    }

    @Override
    public void call(PerformanceSuiteCallback callback, int index) {
        try {
            resource.getWeCrossRPC()
                    .status(resource.getPath())
                    .asyncSend(
                            new Callback<Response>() {
                                @Override
                                public void onSuccess(Response response) {
                                    if (response.getData().equals("exists")) {
                                        callback.onSuccess("success");
                                    } else {
                                        callback.onFailed("failed");
                                    }
                                }

                                @Override
                                public void onFailed(WeCrossSDKException e) {
                                    callback.onFailed(e.getMessage());
                                }
                            });

        } catch (Exception e) {
            callback.onFailed(e.getMessage());
        }
    }
}
