package com.cache.service.impl;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cache.entity.User;
import com.cache.repository.UserRepository;
import com.cache.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CacheManager cacheManager;

    public UserServiceImpl(UserRepository userRepository, CacheManager cacheManager) {
        this.userRepository = userRepository;
        this.cacheManager = cacheManager;
    }

    @Override
    //Always the result specail var need to be used in key when we use cacheevict nad cacheput 
    //also if the passed user have an id before then we can use that well but in my case it is auto generated so i will use the result id to be the key for caching
    @CachePut(value = "users", key = "#result.id")  
    public User save(User user) {
        System.out.println("[Cache] Saving user to DB...");
        User saved = userRepository.save(user);

        // @CachePut stores after method returns, so we print after a tiny yield
        System.out.println("[Cache] User saved to DB with id=" + saved.getId());
        System.out.println("[Cache] Snapshot BEFORE cache is populated (CachePut runs after return):");
        //CacheConfig.printCacheContents(cacheManager.getCache("users"));

        return saved;
    }

    @Override
    //here we are using the id passed in the method as the key to cache the result of this method, 
    // so when we call this method with the same id again it will return the cached value instead of calling the method again and hitting the database
    @Cacheable(value = "users", key = "#id")
    public  User getUserById(Long id) {
        //CacheConfig.printCacheContents(cacheManager.getCache("users"));
        return userRepository.findById(id).get();

    }

    @Override
    @CacheEvict(value = "users", key = "#id")
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
