package com.home.security;

public class SecurityConstants {

    protected static final String SECRET = "SecretKeyToGenJWTs";
    protected static final long EXPIRATION_TIME = 864_000_000; // 10 days
    protected static final String TOKEN_PREFIX = "Bearer ";
    protected static final String HEADER_STRING = "Authorization";
}

