package com.spring.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.mvc.model.beans.BorderBean;

@Repository
public class BorderDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public ArrayList<BorderBean> getBorderList() {
		String sql = "select * from border_mst";
		ArrayList<BorderBean> list = (ArrayList<BorderBean>)jdbcTemplate.query(sql, new RowMapper<BorderBean>() {
			@Override
			public BorderBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				BorderBean borderBean = new BorderBean();
				borderBean.setBorder_code(rs.getInt(1));
				borderBean.setBorder_title(rs.getString(2));
				borderBean.setBorder_cpmtent(rs.getString(3));
				borderBean.setBorder_file(rs.getString(4));
				borderBean.setWriter_name(rs.getString(5));
				borderBean.setWriter_ip(rs.getString(6));
				borderBean.setBorder_date(rs.getString(7));
				borderBean.setBorder_count(rs.getInt(8));
				return borderBean;
			}
		});
		return list;
	}
}
