package com.codecool.adfinder.user;

import com.codecool.adfinder.data.AdServices;
import com.codecool.adfinder.data.ExtendAd;
import com.codecool.adfinder.user.request.UserRequest;
import com.codecool.adfinder.user.response.UserResponse;
import com.google.maps.errors.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserResponseFactory userResponseFactory;


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody
    UserResponse getAds(@RequestBody UserRequest request) throws InterruptedException, ApiException, IOException {
        return userResponseFactory.from(request);
    }
}
