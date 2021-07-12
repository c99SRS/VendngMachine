package com.machine.service;

import com.machine.entity.Admin;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{


    @Override
    public String notifyUser(Admin admin) {
        return "Notified Admin about the shortage of Beverages !!!";
    }

}
