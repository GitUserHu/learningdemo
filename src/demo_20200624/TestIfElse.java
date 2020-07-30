package demo_20200624;

import java.text.DecimalFormat;

public class TestIfElse {
	
	public static void main(String[] args) {
		// 场景： 超市有4种不同的会员 - 普通会员， 黄金会员， 钻石会员， 尊贵会员。针对不同的会员有不同折扣。
		CheckOutUsingSwitch checkOut = new CheckOutUsingSwitch();
		System.out.println(checkOut.checkOut(101, 3));
		
		// 
		CheckOut checkOut2 = new CheckOut();
		Customer diamondVIP = new DiamondVIP(101);
		System.out.println(checkOut2.checkOut(diamondVIP));
	}

}

class CheckOutUsingSwitch {
	static DecimalFormat df = new DecimalFormat();
	public String checkOut(double consumMoney, int vipType) {
		double result = 0;
		// 普通会员 - 1， 黄金会员 - 2， 钻石会员 - 3， 尊贵会员 -4
		switch (vipType) {
		case 1:
			result = consumMoney * 0.95;
			break;
		case 2:
			result = consumMoney * 0.81;
			break;
		case 3:
			result = consumMoney * 0.75;
			break;
		case 4:
			result = consumMoney * 0.5;
			break;
		default:
			result = consumMoney;
			break;
		}
		return df.format(result);
	}
}

class CheckOut {
	String checkOut(Customer customer) {
		return customer.checkOut();
	}
}


abstract class Customer {
	static DecimalFormat df = new DecimalFormat();
	protected double consumMoney;
	Customer(double consumMoney) {
		this.consumMoney = consumMoney;
	}
	abstract String checkOut();
}
class NormalCustomer extends Customer{
	
	NormalCustomer(double consumMoney) {
		super(consumMoney);
	}

	@Override
	String checkOut() {
		
		return df.format(consumMoney);
	}	
}

class DiamondVIP extends Customer {

	DiamondVIP(double consumMoney) {
		super(consumMoney);
	}

	@Override
	String checkOut() {
		return df.format(consumMoney*0.75);
	}
	
}

class GoldVIP extends Customer {

	GoldVIP(double consumMoney) {
		super(consumMoney);
	}

	@Override
	String checkOut() {
		return df.format(consumMoney*0.85);
	}
	
}

class SupremeVIP extends Customer {

	SupremeVIP(double consumMoney) {
		super(consumMoney);
	}

	@Override
	String checkOut() {
		return df.format(consumMoney*0.5);
	}
	
}

class NormalVIP extends Customer {

	NormalVIP(double consumMoney) {
		super(consumMoney);
	}

	@Override
	String checkOut() {
		return df.format(consumMoney*0.95);
	}
	
}

