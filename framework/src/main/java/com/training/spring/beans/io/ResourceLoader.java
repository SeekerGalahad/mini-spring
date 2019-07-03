package com.training.spring.beans.io;

import java.net.URL;

/**
 * @author Wagic
 * @date 2019-07-02 17:14 by Wagic 创建
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
