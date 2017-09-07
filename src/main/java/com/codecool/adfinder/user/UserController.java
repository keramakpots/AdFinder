package com.codecool.adfinder.user;

import com.codecool.adfinder.data.AdServices;
import com.codecool.adfinder.data.ExtendAd;
import com.codecool.adfinder.user.request.UserRequest;
import com.codecool.adfinder.user.response.ResponseHandler;
import com.codecool.adfinder.validation.ValidUserRequest;
import com.google.maps.errors.ApiException;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
    ModelAndView getAds(ModelAndView modelAndView, UserRequest request)
        throws InterruptedException, ApiException, IOException {
        ResponseHandler responseHandler = new ResponseHandler();
        ValidUserRequest validUserRequest = new ValidUserRequest(request);
        request = validUserRequest.validRequest();
        List<ExtendAd> result = responseHandler.getResult(adServices, request);
        modelAndView.addObject("offers", result);
        modelAndView.setViewName("map");
        return modelAndView;
    }

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public ModelAndView getMap(ModelAndView modelAndView) {
        modelAndView.setViewName("map");
        return modelAndView;
    }
}
