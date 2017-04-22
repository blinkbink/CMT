/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfce;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.modelSupplier;

/**
 *
 * @author asass
 */
public interface interfaceSupplier {
    List<modelSupplier> getAll() throws SQLException;
}
