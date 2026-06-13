package com.cache.Config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCacheManager {
//
//    @Bean
//    public org.springframework.cache.CacheManager cacheManager() {
//        SimpleCacheManager manager = new SimpleCacheManager();
//
//        // Register cache regions here — add more names as you create new caches
//        manager.setCaches(List.of(
//                new ConcurrentMapCache("users")
//        ));
//
//        System.out.println("=================================================");
//        System.out.println("  CacheManager initialized: SimpleCacheManager");
//        System.out.println("  Registered cache regions : [users]");
//        System.out.println("=================================================");
//
//        return manager;
//    }
//
//
//    public static void printCacheContents(Cache cache) {
//        if (cache == null) {
//            System.out.println("[Cache] Cache not found!");
//            return;
//        }
//
//        Object nativeCache = cache.getNativeCache();
//
//        System.out.println("-------------------------------------------------");
//        System.out.println("  Cache Name   : " + cache.getName());
//        System.out.println("  Cache Type   : " + nativeCache.getClass().getSimpleName());
//
//        if (nativeCache instanceof ConcurrentMap<?, ?> map) {
//            System.out.println("  Total Entries: " + map.size());
//            if (map.isEmpty()) {
//                System.out.println("  Entries      : (empty)");
//            } else {
//                System.out.println("  Entries:");
//                map.forEach((key, value) ->
//                        System.out.println("    key=" + key + "  =>  value=" + value));
//            }
//        }
//        System.out.println("-------------------------------------------------");
//    }
}
