package com.robot.anyDemo.dataStructure;

public class ChinaPostman extends Postman {
    @Override
    public boolean handExcuter(String address) {
        if (address.contains("China")) {
            System.out.println("分发至" + address);
            if (null != next) {
                return next.handExcuter(address);
            }
        } else {
            System.out.println("无法送达");
        }
        return false;
    }
}
