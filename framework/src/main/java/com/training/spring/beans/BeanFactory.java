package com.training.spring.beans;

import com.training.spring.web.mvc.Controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Wagic
 * @date 2019-06-27 17:18 by Wagic 创建
 */
public class BeanFactory {

    private static Map<Class<?>, Object> classToBean =
            new ConcurrentHashMap<>();

    public static Object getBean(Class<?> cls) {
        return classToBean.get(cls);
    }

    public static void initBean(List<Class<?>> classList) throws Exception {
        List<Class<?>> toCreate = new ArrayList<>(classList);
        while (toCreate.size() != 0) {
            int remainSize = toCreate.size();
            for (int i = 0; i < toCreate.size(); i++) {
                if (finishCreate(toCreate.get(i))) {
                    toCreate.remove(i);
                }
            }
            if (toCreate.size() == remainSize) {
                throw new Exception(("cycle dependency!"));
            }
        }
    }

    private static boolean finishCreate(Class<?> cls) throws IllegalAccessException, InstantiationException {
        if (!cls.isAnnotationPresent(Bean.class) &&
                !cls.isAnnotationPresent(Controller.class)) {
            return true;
        }

        Object bean = cls.newInstance();
        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Class<?> fieldType = field.getType();
                Object relatedBean = BeanFactory.getBean(fieldType);

                if (relatedBean == null) {
                    return false;
                }

                field.setAccessible(true);
                field.set(bean, relatedBean);
            }
        }
        classToBean.put(cls, bean);
        return true;
    }

}
