package Main;

import java.util.Date;
import java.util.Set;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.DateUtils;

public class DailyTask implements Runnable {

	public boolean exit = false;
	private Date localDate;
	private CouponDBDAO couponDBDAO = new CouponDBDAO();
	private long id;

	public DailyTask() {
	}

	public void couponExpired() throws Exception {

		Set<Coupon> coupons = couponDBDAO.getAllCoupons();
		for (Coupon coupon : coupons) {
			if (coupon.getEndDate().before(DateUtils.getCurrentDate())) {
				id = coupon.getId();
			couponDBDAO.removeCoupon(id);
			System.out.println("this coupon has been delete: " + couponDBDAO.getCoupon(id));
			}
			}
		
	}

	public void startThread() throws Exception {
		Thread t1 = new Thread(this);
		t1.start();
	}

	// @Override
	// public synchronized void run() {
	// // TODO Auto-generated method stub
	// while (!exit)
	// try {
	// this.couponExpired();
	// Thread.sleep(1000 * 60 * 60 * 24);
	// } catch (Exception e) {
	// System.out.println(e.getMessage());
	// }
	//
	// }

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		while (!exit)
			try {
				this.couponExpired();
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

	public void stopTask() {
		this.exit = true;
	}
}