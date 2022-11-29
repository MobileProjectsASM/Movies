package com.applications.asm.data.framework.network.api_rest.pojos;

import com.google.gson.annotations.SerializedName;

public class Error {
    @SerializedName("status_message")
    public String statusMessage;

    @SerializedName("success")
    public Boolean success;

    @SerializedName("status_code")
    public String statusCode;
}
