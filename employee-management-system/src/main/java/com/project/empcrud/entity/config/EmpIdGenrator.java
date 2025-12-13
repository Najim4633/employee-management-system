package com.project.empcrud.entity.config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmpIdGenrator implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		// TODO Auto-generated method stub
		String prefix= "EMP";
		int suf=0;
		
		JdbcConnectionAccess access = session.getJdbcConnectionAccess();
		try(Connection con = access.obtainConnection();
				Statement st = con.createStatement();) {
			
			ResultSet set = st.executeQuery("SELECT nextval('empid')");
			
			while (set.next()) {
				suf=set.getInt(1);
				System.out.println(set.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prefix+suf;
	}

}
