package com.rradjabli.clock_app.service;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class TimeService {

    String ntpServer = "time.google.com";
    String finalTime = null;
    public String getTime(){
        try {

            NTPUDPClient ntpudpClient= new NTPUDPClient();//1
            ntpudpClient.setDefaultTimeout(10000);

            InetAddress inetAddress=InetAddress.getByName(ntpServer);
            TimeInfo time=ntpudpClient.getTime(inetAddress);//2

            long milliseconds=time.getMessage().getTransmitTimeStamp().getTime();//3
            Date date = new Date(milliseconds);//4

            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            finalTime = sdf.format(date);
            if(finalTime==null)throw new RuntimeException("finalTime cannot be null");;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalTime;
    }
}


//            NTPUDPClient updClient = new NTPUDPClient();
//            updClient.setDefaultTimeout(10000);
//
//            InetAddress inetAddress = InetAddress.getByName(ntpServer);
//            TimeInfo timeInfo = updClient.getTime(inetAddress);
//
//            // Time in milliseconds
//            long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
//            Date time = new Date(returnTime);
//
//            // Formatting the time
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//            System.out.println("Current Online Time (NTP): " + sdf.format(time));