package com.robot.anyDemo.dataStructure;

public class FangshanPostman extends Postman {
    @Override
    public boolean handExcuter(String address) {
        if (address.contains("fangshan")) {
            System.out.println("送抵fangshan");
            return true;
        }
        return false;
    }
}
