package com.yunuscrud.crudapi.exception;

public class UserNotFoundExeption extends RuntimeException {

    public UserNotFoundExeption(Long userId ){
        super("Could not found the user with Id " + userId);

    }


}
