package org.dimwits.data.utils;

import java.sql.ResultSet;

/**
 * Created by farid on 2/3/17.
 */
public interface TExecutor<T> {
    T execute(ResultSet result);
}
