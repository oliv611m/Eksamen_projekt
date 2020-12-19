package com.example.demo;

import com.example.demo.services.ProjectCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void getProcentTest() {
        ProjectCalculator projectCalculator = new ProjectCalculator();
        String procent = projectCalculator.getProcent(50, 100);
        Assertions.assertEquals("50", procent);

        String procent2 = projectCalculator.getProcent(50, 25);
        Assertions.assertEquals("12,5", procent2);

        String procent3 = projectCalculator.getProcent(37,83);
        Assertions.assertEquals("30,71",procent3);
    }

   @Test
   void getWorkingHours(){
        ProjectCalculator projectCalculator = new ProjectCalculator();
        int workingDays = 5;
        int forventede = projectCalculator.getWorkingHours(workingDays);
        Assertions.assertEquals(35,forventede);
   }

}
