package com.coingeit.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 14/03/16
 */
public class DTOAuthResponse {


    @SerializedName(value = "authenticated")
    private boolean isAuthenticated_;

    @SerializedName(value = "message")
    private String message_;

    public DTOAuthResponse(boolean isAuthenticated, String message) {
        isAuthenticated_ = isAuthenticated;
        message_ = message;
    }

    public boolean isAuthenticated() {
        return isAuthenticated_;
    }

    public void setAuthenticated(boolean isAuthenticated) {
        isAuthenticated_ = isAuthenticated;
    }

    public String getMessage() {
        return message_;
    }

    public void setMessage(String message) {
        message_ = message;
    }
}
