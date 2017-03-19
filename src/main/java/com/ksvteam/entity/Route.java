package com.ksvteam.entity;

/**
 * Created by Yuriy Vlasiuk on 19.03.2017.
 */
public class Route {
    private long routeID;
    private int numberOfRoute;

    public Route(long routeID, int numberOfRoute) {
        this.routeID = routeID;
        this.numberOfRoute = numberOfRoute;
    }

    public Route() {
    }

    public long getRouteID() {
        return routeID;
    }

    public void setRouteID(long routeID) {
        this.routeID = routeID;
    }

    public int getNumberOfRoute() {
        return numberOfRoute;
    }

    public void setNumberOfRoute(int numberOfRoute) {
        this.numberOfRoute = numberOfRoute;
    }
}
