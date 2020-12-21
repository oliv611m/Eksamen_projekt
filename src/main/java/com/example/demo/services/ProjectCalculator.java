//Amir
package com.example.demo.services;

import com.example.demo.models.Project;
import com.example.demo.repositories.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Locale;


@Service
public class ProjectCalculator {

    public String getProcent(double procent, double number) {
        DecimalFormat df = new DecimalFormat("##.##");
        double amount = (procent/100)*number;
        return df.format(amount);
    }

    public int getWorkingDays(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        int workingDays = 0;
        try {
            Calendar start = Calendar.getInstance();
            start.setTime(sdf.parse(startDate));
            Calendar end = Calendar.getInstance();
            end.setTime(sdf.parse(endDate));
            while (!start.after(end)) {
                int day = start.get(Calendar.DAY_OF_WEEK);
                if ((day != Calendar.SATURDAY) && (day != Calendar.SUNDAY))
                    workingDays++;
                start.add(Calendar.DATE, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workingDays;
    }

    public int getWorkingHours(int workingDays) {
        return workingDays * 7;
    }

    public int getTotalPrice(int days, int dayPrice) {
        return days * dayPrice;
    }

    public double getDoubleFromString(String string) {
        try {
            NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
            Number number = format.parse(string);
            return number.doubleValue();
        } catch (ParseException ex) {
            System.out.println(ex.toString());
            return 0;
        }
    }

}
