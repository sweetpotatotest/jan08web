package com.kgb4232.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kgb4232.dto.BoardDTO;
import com.kgb4232.dto.MemberDTO;

public class AdminDAO extends AbstractDAO{
	
	
	public List<BoardDTO> searchDAO(String parameter) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection con = db.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT board_no, board_title, board_date, board_ip, board_del, "
				+ "(SELECT COUNT(*) FROM visitcount v WHERE v.board_no=b.board_no) AS count, "
				+ "(SELECT COUNT(*) FROM comment c WHERE c.board_no=b.board_no) AS comment, "
				+ "m.mname FROM board b JOIN member m ON b.mno=m.mno "
				+ "WHERE board_title LIKE CONCAT('%', '?', '%')"
				+ "OR board_content LIKE CONCAT('%', '?', '%')"
				+ "OR mname LIKE CONCAT('%', '?', '%')"
				+ "ORDER BY board_no DESC";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, parameter);
			pstmt.setString(2, parameter);
			pstmt.setString(3, parameter);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO e = new BoardDTO();
				e.setNo(rs.getInt("board_no"));
				e.setTitle(rs.getString("board_title"));
				e.setWrite(rs.getString("mname")); //member에서
				e.setDate(rs.getString("board_date"));
				e.setCount(rs.getInt("count")); //visitcount에서
				e.setComment(rs.getInt("comment")); //comment에서
				e.setIp(rs.getString("board_ip"));
				e.setDel(rs.getInt("board_del"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		
		return list;
	}

	public List<MemberDTO> memberList() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection con = db.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT mno, mid, mname, mdate, mgrade FROM member";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDTO e = new MemberDTO();
				e.setMno(rs.getInt("mno"));
				e.setMid(rs.getString("mid"));
				e.setMname(rs.getString("mname"));
				e.setMdate(rs.getString("mdate"));
				e.setMgrade(rs.getInt("mgrade"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		
		
		
		return list;
	}
	
	

	public List<MemberDTO> memberList(int grade) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection con = db.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT mno, mid, mname, mdate, mgrade FROM member WHERE mgrade=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDTO e = new MemberDTO();
				e.setMno(rs.getInt("mno"));
				e.setMid(rs.getString("mid"));
				e.setMname(rs.getString("mname"));
				e.setMdate(rs.getString("mdate"));
				e.setMgrade(rs.getInt("mgrade"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		
		
		
		return list;
	}



	public List<BoardDTO> boardList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection con = db.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT board_no, board_title, board_date, board_ip, board_del, "
				+ "(SELECT COUNT(*) FROM visitcount v WHERE v.board_no=b.board_no) AS count, "
				+ "(SELECT COUNT(*) FROM comment c WHERE c.board_no=b.board_no) AS comment, "
				+ "m.mname FROM board b JOIN member m ON b.mno=m.mno ORDER BY board_no DESC";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO e = new BoardDTO();
				e.setNo(rs.getInt("board_no"));
				e.setTitle(rs.getString("board_title"));
				e.setWrite(rs.getString("mname")); //member에서
				e.setDate(rs.getString("board_date"));
				e.setCount(rs.getInt("count")); //visitcount에서
				e.setComment(rs.getInt("comment")); //comment에서
				e.setIp(rs.getString("board_ip"));
				e.setDel(rs.getInt("board_del"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		
		return list;
	}

}
