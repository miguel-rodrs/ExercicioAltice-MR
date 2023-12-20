package com.mr.quarkuslabseq.labseq;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Cache;
import java.math.BigInteger;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class LabSeq {

    Cache<Integer, BigInteger> cache = Caffeine.newBuilder()
            .maximumSize(100000)
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .build();

    public LabSeq(){
        this.populateFirstNumbers();
    }

    public BigInteger calculate(int n){
        BigInteger res = this.cache.getIfPresent(n);
        if(res==null){
            for(int i = 4; i<=n; i++){
                res = this.cache.getIfPresent(i);
                if(res==null){
                    res = Objects.requireNonNull(this.cache.getIfPresent(i - 4)).add(this.cache.getIfPresent(i-3));
                    this.cache.put(i, res);
                }
            }
        }
        return this.cache.getIfPresent(n);
    }

    public void populateFirstNumbers(){
        this.cache.put(0, BigInteger.valueOf(0));
        this.cache.put(1, BigInteger.valueOf(1));
        this.cache.put(2, BigInteger.valueOf(0));
        this.cache.put(3, BigInteger.valueOf(1));
    }
}
