package com.kgb4232.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kgb4232.dto.CoffeeDTO;

public class CoffeeDAO extends AbstractDAO{

	public int coffeeOrder(CoffeeDTO dto) {
		int result = 0;
		Connection con = db.getConn();
		PreparedStatement pstmt = null;
		String sql ="INSERT INTO coffee (cfname, mno) "
				+ "VALUES (?, (SELECT mno FROM member WHERE mid=?))";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getCfName());
			pstmt.setString(2, dto.getMid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, con);
		}
		return result;
	}

	public int coffeeCount(String cof) {
		int result = 0;
		Connection con = db.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM coffee WHERE cfname=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cof);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		return result;
	}
	
	
	
}
