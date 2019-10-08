package com.transamerica.user.auth.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.transamerica.user.auth.controller.UserAuthenticationController;

@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        register(UserAuthenticationController.class);
    }

}
