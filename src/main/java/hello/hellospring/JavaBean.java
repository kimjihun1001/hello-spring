package hello.hellospring;

import java.io.Serializable;

public class JavaBean implements Serializable {
    private String beanName;
    private int beanValue;

    public JavaBean() {
        // no-argument constructor
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public int getBeanValue() {
        return beanValue;
    }

    public void setBeanValue(int beanValue) {
        this.beanValue = beanValue;
    }
}