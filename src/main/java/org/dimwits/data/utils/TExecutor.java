package org.dimwits.data.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by farid on 2/3/17.
 */
public interface TExecutor<T> {
    T execute(ResultSet result) throws SQLException;
}
