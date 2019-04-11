package com.robot.anyDemo.dataStructure;

import com.robot.anyDemo.base.BasePresenter;
import com.robot.anyDemo.base.BaseView;

public class DataPresenter extends BasePresenter {
    private Postman man;

    public DataPresenter(BaseView baseView) {
        super(baseView);
        initPostman();
    }


    private void initPostman() {
        Postman china = new ChinaPostman();
        man = china;
        registerPostman(new BeijingPostman());
        registerPostman(new FangshanPostman());
    }

    private void registerPostman(Postman manObj) {
        Postman obj = man;
        if (null != obj) {
            while (obj.next != null) {
                obj = obj.next;
            }
            obj.next = manObj;
        }
    }

    protected void postAddress(String addr) {
        man.handExcuter(addr);
    }
}
