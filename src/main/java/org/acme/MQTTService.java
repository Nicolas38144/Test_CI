package org.acme;

import io.quarkus.logging.Log;
import org.acme.Game;
import org.eclipse.paho.client.mqttv3.MqttClient;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

@ApplicationScoped
public class MQTTService {

    private MqttClient client;

    private final String topic = "ibaneztod10n";

    public MQTTService() {
        try {
            client = new MqttClient("ws://mqtt.eclipseprojects.io:1883", MqttClient.generateClientId());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            client.connect(options);
            Log.info("MQTT Service initialized");
            //Send the game state every 10 milliseconds by a Task
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            sendGameState();
                        }
                    },
                    0,
                    10
            );
        } catch (MqttException e) {
            Log.error("Error while initializing MQTT client", e);
        }
    }

    public void sendGameState() {
        Game game = Game.getInstance();
        Log.info("Sending game state: " + game);
        try {
            client.publish(topic, game.toString().getBytes(), 0, false);
        } catch (MqttException e) {
            Log.error("Error while sending game state", e);
        }
    }
}
