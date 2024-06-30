package com.example.demo.config;

import com.example.demo.controller.WebsocketController_bloodOxygen;
import com.example.demo.controller.WebsocketController_heartRate;
import com.example.demo.controller.WebsocketController_humiture;
import com.example.demo.controller.WebsocketController_lightIntensity;
import com.example.demo.service.monitor.DataMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class websocketConfig {
    /**
     * 	注入ServerEndpointExporter，
     * 	这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Autowired
    public void setController(DataMonitor dm){
        WebsocketController_humiture.dm = dm;
        WebsocketController_heartRate.dm = dm;
        WebsocketController_bloodOxygen.dm = dm;
        WebsocketController_lightIntensity.dm = dm;
    }
}
