package org.acme.svcTests;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.svc.impl.Game;
import org.acme.svc.impl.MQTTService;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MQTTServiceTest {

    //TODO: Implement tests for MQTTService

//    package org.acme.svc.impl;
//
//import io.quarkus.logging.Log;
//import org.eclipse.paho.client.mqttv3.MqttClient;
//import jakarta.enterprise.context.ApplicationScoped;
//import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
//import org.eclipse.paho.client.mqttv3.MqttException;
//
//    @ApplicationScoped
//    public class MQTTService {
//
//        private MqttClient client;
//
//        private final String topic = "ibaneztod10n";
//
//        public MQTTService() {
//            try {
//                client = new MqttClient("ws://mqtt.eclipseprojects.io:1883", MqttClient.generateClientId());
//                MqttConnectOptions options = new MqttConnectOptions();
//                options.setAutomaticReconnect(true);
//                client.connect(options);
//                Log.info("MQTT Service initialized");
//                //Send the game state every 10 milliseconds by a Task
//                new java.util.Timer().schedule(
//                        new java.util.TimerTask() {
//                            @Override
//                            public void run() {
//                                sendGameState();
//                            }
//                        },
//                        0,
//                        10
//                );
//            } catch (MqttException e) {
//                Log.error("Error while initializing MQTT client", e);
//            }
//        }
//
//        public void sendGameState() {
//            Game game = Game.getInstance();
//            Log.info("Sending game state: " + game);
//            try {
//                client.publish(topic, game.toString().getBytes(), 0, false);
//            } catch (MqttException e) {
//                Log.error("Error while sending game state", e);
//            }
//        }
//    }

    @Test
    void testMQTTService() {
        MQTTService mqttService = new MQTTService();
        assertNotNull(mqttService);
    }

    @Test
    void testSendGameState() {
        MQTTService mqttService = new MQTTService();
        mqttService.sendGameState();
    }
}
