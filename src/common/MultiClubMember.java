package common;
import java.util.Date;

import javax.swing.JOptionPane;

public class MultiClubMember extends Member {
	
	private int membershipPoints;;
	private String birthday;
	
	
	public MultiClubMember(String memberType, String name, int id, String birthday, int membershipPoints) {
		super(memberType,name,id);
		this.membershipPoints = membershipPoints;
		this.birthday = birthday;

	}


	@Override
	public void checkIn(Club club) {
	}


	public int getMembershipPoints() {
		return membershipPoints;
	}


	public void setMembershipPoints(int membershipPoints) {
		this.membershipPoints = membershipPoints;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	@Override
	public void printBill() {
		int points = getMembershipPoints();
		double price = 100.00;
		Date todaysDate = new Date();
		Date startDate = new Date(2020, 1, 1);
		Date endDate = new Date(2020, 2, 1);
		if(todaysDate.after(startDate) && todaysDate.before(endDate)) {
			price = price - (price * .20);
			if (points > 50) {
				price -= 5;
			}
			JOptionPane.showMessageDialog(null,String.format("%s's current bill is: $%.2f\n They have %d membership points.", getName(), price, points));
		}
		if (points > 50) {
			price -= 5;
			JOptionPane.showMessageDialog(null,String.format("%s's current bill is: $%.2f\n They have %d membership points.", getName(), price, points));
		}
		else {
			JOptionPane.showMessageDialog(null,String.format("%s's current bill is: $%.2f\n They have %d membership points.", getName(), price, points));
		}	
	}


	@Override
	protected String getClubName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return "Membership Type: " + memberType + "\nClub Member Name:" + name + "\nID: " + id + "\nBirthday: " + birthday 
         + "\nMembership Points: " + membershipPoints;
	}

}


	