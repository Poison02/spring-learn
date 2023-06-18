package cdu.zch.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zch
 * @data 2023/6/18
 **/
public class DateFactoryBean implements FactoryBean<Date> {

    private String strDate;

    public DateFactoryBean(String strDate) {
        this.strDate = strDate;
    }

    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(strDate);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
