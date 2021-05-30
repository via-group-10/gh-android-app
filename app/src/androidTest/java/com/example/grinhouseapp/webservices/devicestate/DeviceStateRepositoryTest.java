package com.example.grinhouseapp.webservices.devicestate;

import junit.framework.TestCase;

import org.junit.Assert;

public class DeviceStateRepositoryTest extends TestCase {
    private DeviceStateRepository deviceStateRepository;

    public void setUp() throws Exception {
        deviceStateRepository = DeviceStateRepository.getInstance();

    }

    public void testSetACState() {
        deviceStateRepository.setACState();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(deviceStateRepository.getCurrentAcState().getValue());
    }

    public void testSetCo2GeneratorState() {
        deviceStateRepository.setCo2GeneratorState();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(deviceStateRepository.getCurrentCo2State().getValue());

    }

    public void testSetHumidifierState() {
        deviceStateRepository.setHumidifierState();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(deviceStateRepository.getCurrentHumidifierState().getValue());
    }
}