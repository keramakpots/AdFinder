package com.codecool.adfinder.user;

import com.codecool.adfinder.data.AdServices;
import com.codecool.adfinder.data.ExtendAd;
import com.codecool.adfinder.user.request.UserRequest;
import com.codecool.adfinder.user.response.ResponseHandler;
import com.codecool.adfinder.user.response.UserResponse;
import com.google.gson.Gson;
import com.google.maps.errors.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Autowired
    private AdServices adServices;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loadStartView(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody
    String getAds(UserRequest request) throws InterruptedException, ApiException, IOException {
        ResponseHandler responseHandler = new ResponseHandler();
        List<ExtendAd> result = responseHandler.getResult(adServices, request);
        UserResponse userResponse = new UserResponse(result);
        return new Gson().toJson(userResponse);
    }
}
