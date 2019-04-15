package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

import Clients.AdminFacade;
import Company.Company;
import Company.CompanyDBDAO;
import Company.CompanyFacade;
import CompanyCoupon.CompanyCoupon;
import CompanyCoupon.CompanyCouponFacade;
import Coupon.Coupon;
import Coupon.CouponFacade;
import Coupon.CouponType;
import Customer.Customer;
import Customer.CustomerFacade;
import CustomerCoupon.CustomerCoupon;
import Coupon.DateUtils;
import CustomerCoupon.CustomerCoupon;
import CustomerCoupon.CustomerCouponDAO;
import CustomerCoupon.CustomerCouponFacade;

public class Test {

	public static void main(String[] args) throws Exception {

		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = DriverManager.getConnection(Database.getDBUrl());

		Database.createTables(con);
		/*************************************** Company ****************************/

		Company p1 = new Company(1, "HP", "3443345654", "hp@gmail.com");
		Company p2 = new Company(2, "Lg", "987869977", "lg@gmail.com");
		Company p3 = new Company(3, "Sony", "4314134143", "sony@gmail.com");
		Company p4 = new Company(46, "HP", "vsdv", "vsdvsdv");

		CompanyFacade companyFacade = new CompanyFacade();
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
//		companyDBDAO.getAllCompanyCoupons();
		
//		 companyFacade.insertCompany(p1);
//		 companyFacade.insertCompany(p2);
//		 companyFacade.insertCompany(p3);

		// companyFacade.updateCompany(p3, 3, "fdsg", "fsdg", "dgzdg");
		// companyFacade.updateCompany(p1, 7, "llll", "ffff", "54554");
		// companyFacade.updateCompany(p3, 8, "tttt", "uuu", "scas");

		// companyFacade.updateCompany(p3, 12, "TOM", "FWW", "EE");
		// companyFacade.removeCompany(7);
		// companyFacade.removeCompany(5);
		// companyFacade.removeCompany(6);
		
//				System.out.println(companyFacade.getAllCoupon());
		// companyFacade.dropTable();
//		 System.out.println(companyFacade.getAllCompany());
		// System.out.println(companyFacade.getCompany(1));

		/*************************************** Customer ****************************/

		Customer c1 = new Customer(4, "Matan", "3784628");
		Customer c2 = new Customer(5, "Bar", "1325266");
		Customer c3 = new Customer(6, "Dvir", "9879886");
		Customer c4 = new Customer(8, "Dvir", "fdfdasadf");

		CustomerFacade customerFacade = new CustomerFacade();
//		 customerFacade.insertCustomer(c1);
//		 customerFacade.insertCustomer(c2);
//		 customerFacade.insertCustomer(c3);

//		customerFacade.updateCustomer(c2, 3, "Ehud", "445577566");
		// customerFacade.removeCustomer(1);
		// customerFacade.removeCustomer(3);
		// customerFacade.removeCustomer(6);

		// customerFacade.dropTable();

		// System.out.println(customerFacade.getAllCustomer());
		// System.out.println(customerFacade.getCustomer(9));
		/*************************************** Coupon ****************************/

		Coupon u1 = new Coupon(7, "test", DateUtils.getCurrentDate(), DateUtils.getExpiredDate(), 55, "sick", 33.5,
				"image", CouponType.HEALTH);
		Coupon u2 = new Coupon(8, "test2", DateUtils.getCurrentDate(), DateUtils.getExpiredDate(), 66, "camp", 36.7,
				"picture", CouponType.CAMPING);
		Coupon u3 = new Coupon(9, "test3", DateUtils.getCurrentDate(), DateUtils.getExpiredDate(), 77, "food", 41.2,
				"photo", CouponType.FOOD);
		Coupon u4 = new Coupon(10, "test4", DateUtils.getCurrentDate(), DateUtils.getExpiredDate(), 99, "bla", 32.4,
				"uy", CouponType.TRAVELING);
		Coupon u5 = new Coupon(70, "test", DateUtils.getCurrentDate(), DateUtils.getExpiredDate(), 44, "ff", 4444.7, "gg", CouponType.ELECTRICITY);

		CouponFacade couponFacade = new CouponFacade();

//		 couponFacade.insertCoupon(u1);
//		 couponFacade.insertCoupon(u2);
//		 couponFacade.insertCoupon(u3);

		// couponFacade.updateCoupon(u1, 5, "Matanofri", DateUtils.getCurrentDate(),
		// DateUtils.getExpiredDate(), 100, "bbb", 22.2, "ccc", CouponType.SPORTS);

		 couponFacade.removeCoupon(3);
		// couponFacade.removeCoupon(2);
//		 couponFacade.removeCoupon(48);
//		companyFacade.updateCoupon(u1, 40, DateUtils.getCurrentDate(), 45);
//		 System.out.println(couponFacade.getAllCoupon());
//		 System.out.println(couponFacade.getCoupon(8));

		// couponFacade.dropTable();

		/**************************************** CustomerCoupon****************************/

		CustomerCoupon a1 = new CustomerCoupon(26, 3);
		CustomerCoupon a2 = new CustomerCoupon(9, 11);
		CustomerCoupon a3 = new CustomerCoupon(15,40);
		CustomerCoupon a4 = new CustomerCoupon(16, 41);
		CustomerCoupon a5 = new CustomerCoupon(17, 42);
		CustomerCoupon a6 = new CustomerCoupon(26, 43);
		CustomerCoupon a7 = new CustomerCoupon(10, 47);

		CustomerCouponFacade customerCouponFacade = new CustomerCouponFacade();

//		 customerCouponFacade.insertCustomerCoupon(a1);
//		 customerCouponFacade.insertCustomerCoupon(a4);
//		 customerCouponFacade.insertCustomerCoupon(a7);

//		 customerCouponFacade.removeCustomerCoupon(26, 43);

		// customerCouponFacade.updateCustomerCoupon(a1, 9, 10);
//		System.out.println(customerCouponFacade.getCustomerCoupon());
		// System.out.println(customerCouponFacade.getAllCustomerCoupon());

		// customerCouponFacade.dropTable();

		/*****************************************Threads******************************/
		
//		DailyTask d = new DailyTask();
//
//		d.startThread();
//		d.stopTask();
		
		CompanyCoupon b1 = new CompanyCoupon(1, 3);
		CompanyCoupon b2 = new CompanyCoupon(46, 47);
		CompanyCoupon b3 = new CompanyCoupon(33, 11);
		
		CompanyCouponFacade companyCouponFacade = new CompanyCouponFacade();
//		companyCouponFacade.insertCompanyCoupon(b3);
//		System.out.println(companyCouponFacade.getAllCompanyCoupon());
		
//		companyCouponFacade.dropTable();
	
//		companyFacade.removeCouponById(10, 47);
		AdminFacade adminFacade = new AdminFacade();
		
		companyFacade.getCompany(14);
	}
}
