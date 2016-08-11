package com.limiter.open.tokenbucket.core.impl;

import com.limiter.open.tokenbucket.core.TokenBucketDAO;
import com.limiter.open.tokenbucket.domain.TokenBucket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuhao
 */
public class LocalTokenBucketDAOImpl implements TokenBucketDAO {

    private static Map<String, TokenBucket> tokenBucketMap = new ConcurrentHashMap<>();

    @Override
    public TokenBucket getTokenBucket(String tokenBucketKey) {
        return tokenBucketMap.get(tokenBucketKey);
    }

    @Override
    public boolean saveTokenBucket(TokenBucket tokenBucket) {
        tokenBucketMap.put(tokenBucket.getTokenBucketKey(), tokenBucket);
        return true;
    }
}