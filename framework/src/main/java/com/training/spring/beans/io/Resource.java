package com.training.spring.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Wagic
 * @date 2019-07-02 17:11 by Wagic 创建
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
