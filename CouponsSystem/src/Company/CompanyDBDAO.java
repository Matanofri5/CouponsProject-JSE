package Company;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import Coupon.Coupon;
import Coupon.CouponType;
import Main.Database;

/**
 * In this class we have to implement all the method in CompanyDao
 * every method getting connection to DB and close when finished 
 */

public class CompanyDBDAO implements CompanyDAO {
	Connection con;
	
	/**
	 * @insert
	 * This method create new company by getting connection to DB
	 *  and sending query with values
	 */
	@Override
	public void insertCompany(Company company) throws Exception {
		con = DriverManager.getConnection(Database.getDBUrl());
		String sql = "INSERT INTO Company (companyName,password,email)  VALUES(?,?,?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, company.getCompanyName());
			pstmt.setString(2, company.getPassword());
			pstmt.setString(3, company.getEmail());

			pstmt.executeUpdate();
			System.out.println("Company insert success :D  " + company.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.err.println("Company insert failed :(");
		} finally {
			con.close();
		}
	}

	@Override
	public void removeCompany(long id) throws Exception {
		con = DriverManager.getConnection(Database.getDBUrl());
		String sql = "DELETE FROM Company WHERE id= ?";

		try (PreparedStatement pstm1 = con.prepareStatement(sql);) {
			con.setAutoCommit(false);
			pstm1.setLong(1, id);
			pstm1.executeUpdate();
			con.commit();
			System.out.println("Company remove success :D ");
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new Exception("Database error");
			}
			System.err.println("Company remove faied :( ");
		} finally {
			con.close();
		}
	}

	@Override
	public void updateCompany(Company company) throws Exception {
		con = DriverManager.getConnection(Database.getDBUrl());
		try (Statement stm = con.createStatement()) {
			String sql = "UPDATE Company " + " SET companyName='" + company.getCompanyName() + "', password='"
					+ company.getPassword() + "', email='" + company.getEmail() + "' WHERE id=" + company.getId();

			System.out.println("Company update success :D " + company.getId());
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new Exception("Company update failed :( ");
		}
	}

	@Override
	public Company getCompany(long id) throws Exception {
		con = DriverManager.getConnection(Database.getDBUrl());
		Company company = new Company();
		try (Statement stm = con.createStatement()) {
			String sql = "SELECT * FROM Company WHERE ID=" + id;
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				company.setId(rs.getLong(1));
				company.setCompanyName(rs.getString(2));
				company.setPassword(rs.getString(3));
				company.setEmail(rs.getString(4));
				System.out.println("Get company success :D ");
			}

		} catch (SQLException e) {
			System.err.println("Get company failed :(");
		} finally {
			con.close();

		}
		return company;
	}

	@Override
	public Set<Company> getAllCompanys() throws Exception {
		con = DriverManager.getConnection(Database.getDBUrl());
		Set<Company> set = new HashSet<>();
		try {
			Statement stm = con.createStatement();
			String sql = "SELECT * FROM Company";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				long id = rs.getLong(1);
				String companyName = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);

				set.add(new Company(id, companyName, password, email));
				System.out.println("Get all company success :D ");
			}
		} catch (SQLException e) {
			System.err.println(e);
			throw new Exception("Get all company failed :( ");
		} finally {
			con.close();
		}
		return set;
	}

	@Override
	public Set<Coupon> getCoupons(long companyId) throws Exception {
		Coupon coupon;
		Set<Coupon> coupons = new HashSet<Coupon>();
		con = DriverManager.getConnection(Database.getDBUrl());
		java.sql.Statement stm = null;
		try {
			stm = con.createStatement();
			String sql = "SELECT * FROM Coupon WHERE companyId=?";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				coupon = new Coupon();
				coupon.setId(rs.getLong(1));
				coupon.setTitle(rs.getString(2));
				coupon.setEndDate((Date) rs.getDate(3));
				coupon.setStartDate((Date) rs.getDate(4));
				coupon.setAmount(rs.getInt(5));
				coupon.setMessage(rs.getString(6));
				coupon.setPrice(rs.getDouble(7));
				coupon.setImage(rs.getString(8));
				CouponType type = CouponType.valueOf(rs.getString(9));
				coupon.setType(type);
				coupons.add(coupon);
				System.out.println("Get coupons by company success :D ");
			}
		} catch (SQLException e) {
			System.err.println("Get coupons by company failed :( ");
			throw new Exception(e.getMessage());
		} finally {
			con.close();
		}
		return coupons;
	}
	
	@Override
	public void dropTable() throws Exception {
		con = DriverManager.getConnection(Database.getDBUrl());
		try {
			String sql = "DROP TABLE Company";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("drop Company Table success!! :D ");

		} catch (SQLException ex) {
			System.err.println("MMMMMMM....dropCompanyTableEXCEPTION :( ");
			throw new Exception(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.err.println("the connection cannot closed :( " + ex.getMessage());
			}
		}

	}
}
