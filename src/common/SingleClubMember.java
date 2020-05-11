package common;
import java.util.Date;

import javax.swing.JOptionPane;

public class SingleClubMember extends Member{
	private Club clubName;
	private String birthday;
	
	





	public SingleClubMember() {
		
	}
	

	public SingleClubMember(String memberType, String name, int id,String birthday, Club clubName) {
		 super(memberType,name,id);
		this.clubName = clubName;
		this.birthday = birthday;
	}



	@Override
	public String toString() {
		return "Membership Type: " + memberType + "\nClub Member Name:" + name + "\nID: " + id + "\nBirthday: " + birthday 
				+ "\nClub Name: " + clubName;
	}


	@Override
	public void checkIn(Club club) {
		
	}



	public String getClubName() {
		return clubName.getName();
	}



	public void setClubName(Club clubName) {
		this.clubName = clubName;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	@Override
	public void printBill() {
		double price = 75.00;
		Date todaysDate = new Date();
		Date startDate = new Date(2020, 1, 1);
		Date endDate = new Date(2020, 2, 1);
		if(todaysDate.after(startDate) && todaysDate.before(endDate)) {
			price = price - (price * .20);
			JOptionPane.showMessageDialog(null,String.format("%s's current bill is: $%.2f\n", getName(), (price)));
		}
		else {
			JOptionPane.showMessageDialog(null,String.format("%s's current bill is: $%.2f\n", getName(), (price)));
		}
	}
}
