package com.sovon9.ActivityService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UdpController {

    @QueryMapping
    public List<Udp> udpValues()
    {
        List<Udp> udps = new ArrayList<>();
        Udp udp = new Udp(1L, "data", "value");
        udp.setActivityId(1L);
        udps.add(udp);
        return udps;
    }

    @QueryMapping
    public List<Udp> udpValuesByActivityId(@Argument Long activityId)
    {
        List<Udp> udps = new ArrayList<>();
        Udp udp = new Udp(1L, "data", "value");
        udp.setActivityId(activityId);
        udps.add(udp);
        return udps;
    }

}
