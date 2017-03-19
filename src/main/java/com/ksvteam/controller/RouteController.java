package com.ksvteam.controller;

import com.ksvteam.entity.Route;
import com.ksvteam.service.RouteService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Yuriy Vlasiuk on 19.03.2017.
 */

@RestController
public class RouteController {
    private RouteService routeService = RouteService.getInstance();

    @RequestMapping(value = "/addRoute", method = RequestMethod.POST)
    public long addRoute(@RequestBody Route route) {
        return routeService.addRoute(route);
    }

    @RequestMapping(value = "/getAllRoute", method = RequestMethod.GET)
    public ArrayList<Route> getAllRoute() {
        return routeService.getAllRoute();
    }
}
