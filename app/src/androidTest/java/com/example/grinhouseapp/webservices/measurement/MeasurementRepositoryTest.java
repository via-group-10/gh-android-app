package com.example.grinhouseapp.webservices.measurement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class MeasurementRepositoryTest {

    @Spy
    MeasurementRepository measurementRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getData(){
        when(measurementRepository.getAllMeasurements()).thenReturn(measurementRepository.getAllMeasurements());
    }

    @After
    public void tearDown() throws Exception {
    }
}