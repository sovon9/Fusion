package com.sovon9.ActivityService;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ActivityController {

    @QueryMapping
    public List<Activity> activities()
    {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1L, "manufacturing"));
        return activities;
    }

}
