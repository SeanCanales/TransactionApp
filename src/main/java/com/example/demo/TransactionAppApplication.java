package com.example.demo;

import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TransactionAppApplication {

    public static void main(String[] args) {
        SpringApplication app =
            new SpringApplication(TransactionAppApplication.class);

        app.setHeadless(false);

        ConfigurableApplicationContext context = app.run(args);

        SwingUtilities.invokeLater(() -> {
            TransactionGUI gui =
                context.getBean(TransactionGUI.class);

            gui.setVisible(true);
        });
    }
}