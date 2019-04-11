package com.robot.anyDemo.dataStructure;

public class BeijingPostman extends Postman {
    @Override
    public boolean handExcuter(String address) {
        if (address.contains("beijing")) {
            System.out.println("已送达");
            if (null != next) {
                return next.handExcuter(address);
            }
        } else {
            System.out.println("无法送达,未开通");
        }
        return false;
    }
}
