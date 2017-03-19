package com.ksvteam.service;


import com.ksvteam.entity.Route;

import java.util.ArrayList;

/**
 * Created by Yuriy Vlasiuk on 19.03.2017.
 */
public class RouteService {
    private static RouteService instance;
    private ArrayList<Route> routeArrayList;

    private RouteService() {
        routeArrayList = new ArrayList<>();
    }

   public static synchronized RouteService getInstance() {
        if (instance == null) {
            instance = new RouteService();
        }
        return instance;
    }

    public ArrayList<Route> getAllRoute() {
        return routeArrayList;
    }

    public long addRoute (Route route) {
        long routeID = routeArrayList.size() + 1;
        route.setRouteID(routeID);
        routeArrayList.add(route);

        return routeID;
    }

}
