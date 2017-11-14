package DBAccess;

import FunctionLayer.WoodAndRoof;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author PC
 */
public class MaterialMapper {
    public ArrayList<WoodAndRoof> getWoodAndRoof() throws SQLException {
        
        ArrayList<WoodAndRoof> WoodandRoof = new ArrayList<WoodAndRoof>();
        WoodAndRoof WoodsAndRoofs;
        
        try {
            
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM WoodAndRoof";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                WoodsAndRoofs = new WoodAndRoof(
                rs.getString("name"),
                rs.getInt("length"),
                rs.getInt("amount"),
                rs.getString("unit"),
                rs.getString("description")
                );
                WoodandRoof.add(WoodsAndRoofs);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MaterialMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return WoodandRoof;
    }
}
