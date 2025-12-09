package com.project.employee_management_system.entity.config;

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
		String pre= "EMP";
		int suf=0;
		
		JdbcConnectionAccess access = session.getJdbcConnectionAccess();
		try(Connection con = access.obtainConnection();
				Statement st = con.createStatement();) {
			
			ResultSet set = st.executeQuery("select newVal('empid')");
			set.next();
			suf = set.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pre+suf;
	}

}
